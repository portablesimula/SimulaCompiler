/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import org.apache.bcel.classfile.Constant;
import org.apache.bcel.classfile.ConstantMethodref;
import org.apache.bcel.classfile.ConstantNameAndType;
import org.apache.bcel.classfile.ConstantPool;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.ConstantPushInstruction;
import org.apache.bcel.generic.GETFIELD;
import org.apache.bcel.generic.INVOKESTATIC;
import org.apache.bcel.generic.Instruction;
import org.apache.bcel.generic.InstructionHandle;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.InstructionTargeter;
import org.apache.bcel.generic.MethodGen;
import org.apache.bcel.generic.TABLESWITCH;
import org.apache.bcel.generic.TargetLostException;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

public class ByteCodeEngineering {
	private static final boolean LIST_RESULTING_INSTRUCTION_LIST=false;
	private static final boolean TRACE_REPAIRING=false;
	
	class LabelHandle
	{ int index;
	  InstructionHandle target;
	  LabelHandle(int index,InstructionHandle target)
	  { this.index=index; this.target=target; }
	}
	Vector<LabelHandle> labels;
	String currentClassFileName;
	
	public ByteCodeEngineering() {
	}

    public void doRepairByteCode() {
        try {
//        	listFiles(new File(Global.tempClassFileDir+Global.packetName));  // TEST
        	scanFiles(new File(Global.tempClassFileDir+Global.packetName));
        } catch (Exception e) { e.printStackTrace(); }
    }

//	private void listFiles(File source) throws IOException {
//		if (source.isDirectory()) {
//			for (File nestedFile : source.listFiles())
//				listFiles(nestedFile);
//			return;
//		}
//		String classFileName = source.getPath().replace("\\", "/");
//		if (classFileName.endsWith(".class"))
//			System.out.println(classFileName);
//	}

	private void scanFiles(File source) throws IOException {
		if (source.isDirectory()) {
			for (File nestedFile : source.listFiles())
				scanFiles(nestedFile);
			return;
		}
		String classFileName = source.getPath().replace("\\", "/");
		if (classFileName.endsWith(".class"))
			doRepairSingleByteCode(classFileName);
	}

    private void doRepairSingleByteCode(String classFileName) {
        try {
            //Util.BREAK("ByteCodeEngineering.doRepairByteCode: Load "+classFileName);
            currentClassFileName=classFileName;
            JavaClass javaClass=ClassFileUtilities.load(classFileName);
            
            // Set major version number of class file, default value is 45 (JDK 1.1)
            // This is necessary because the current version of BCEL
            // does not support higher versions.
            javaClass.setMajor(49);
            
            Method[] methods = javaClass.getMethods();
            ConstantPool constantPool=javaClass.getConstantPool();
            ConstantPoolGen constantPoolGen = new ConstantPoolGen(constantPool);

            for (int i = 0; i < methods.length; i++) {
                if (!(methods[i].isAbstract() || methods[i].isNative())) {
                	
              	    String name=methods[i].getName();
                    //Util.BREAK("ByteCodeEngineering.doRepairByteCode: Method "+name);

                    if(name.equals("STM"))
                    { MethodGen methodGen = new MethodGen(methods[i], javaClass.getClassName(), constantPoolGen);
                      Method modified = treatSTM_Method(methodGen,constantPool);
                      if (modified != null) methods[i] = modified; // Overwrite with modified method
                      else return; // No changes
                    }
                }
            }

            // Dump the class to <classFileName>
            javaClass.setConstantPool(constantPoolGen.getFinalConstantPool());
            javaClass.dump(classFileName);
        } catch (Exception e) { e.printStackTrace(); }
    }

	
	private Method treatSTM_Method(MethodGen methodGen,ConstantPool constantPool) {
		InstructionList instructionList=methodGen.getInstructionList();
		labels=new Vector<LabelHandle>();
        
        if(TRACE_REPAIRING) System.out.println("*** PASS 1 - FIND AND TREAT ALL LABELS ***");
        for(InstructionHandle handle:instructionList) {
        	Instruction ins=handle.getInstruction();
            if(ins instanceof INVOKESTATIC) {
            	String methodName=getMethodName((INVOKESTATIC)ins, constantPool);
                if(methodName.equals("LABEL$")) treatLABEL(instructionList,handle);
            }
        }
        
        if(labels.size()==0)
        { //if(Option.verbose) System.out.println("ByteCodeEngineering: No label found in "+currentClassFileName);
          return(null);
        } else if(Option.verbose) System.out.println("ByteCodeEngineering: "+labels.size()+" label found in "+currentClassFileName);
        
        if(TRACE_REPAIRING) System.out.println("*** PASS 2 - FIND AND TREAT JUMP$ ***");
        for(InstructionHandle handle:instructionList) {
        	Instruction ins=handle.getInstruction();
            if(ins instanceof INVOKESTATIC) {
            	String methodName=getMethodName((INVOKESTATIC)ins, constantPool);
                if(methodName.equals("JUMPTABLE$")) treatJUMPTABLE(instructionList,handle);
            }
        }
        
        if(LIST_RESULTING_INSTRUCTION_LIST)
        { System.out.println("*** LIST RESULTING INSTRUCTION LIST ***");
          for(InstructionHandle handle:instructionList) {
        	  System.out.println("  "+handle);
          }
        }

        Method modified = methodGen.getMethod();
        instructionList.dispose(); // Reuse instruction handles
        return(modified);
	}
	
	
	/*
	 * Locate the instruction sequence:
	 * <pre>
	 *    PREV-INSTRUCTION
	 *    ICONST n
	 *    INVOKESTATIC LABEL$
	 *    NEXT-INSTRUCTION
	 * </pre>
	 */
	private void treatLABEL(InstructionList instructionList, InstructionHandle invokeStatic) {
		// Util.BREAK("ByteCodeEngineering.treatLABEL: GOT LABEL --	InstructionHandle "+invokeStatic);
		InstructionHandle pushConst = invokeStatic.getPrev();
		Instruction maybePushConstInstruction = pushConst.getInstruction();
		Number labelIndex = 0;
		if (maybePushConstInstruction instanceof ConstantPushInstruction) {
			ConstantPushInstruction iconstInstruction = (ConstantPushInstruction) maybePushConstInstruction;
			labelIndex = iconstInstruction.getValue();
		} else {
			InstructionHandle PREV = pushConst.getPrev();
			listInstructionSequence("ByteCodeEngineering.treatLABEL: UNKNOWN ", PREV, 8);
			// System.out.println("*** LIST COMPLETE INSTRUCTION LIST ***");
			// for (InstructionHandle handle : instructionList) {
			// System.out.println(" " + handle);
			// }
			Util.NOT_IMPLEMENTED("ByteCodeEngineering.treatLABEL: Unknown Instruction Sequence");
		}

		// Util.BREAK("ByteCodeEngineering.treatLABEL: GOT LABEL -- InstructionHandle "+invokeStatic+", LabelIndex="+labelIndex);
		InstructionHandle PREV = pushConst.getPrev();
		InstructionHandle NEXT = invokeStatic.getNext();
		if (TRACE_REPAIRING)
			listInstructionSequence("ByteCodeEngineering.treatLABEL: GOT ", PREV, 8);
		int ix = labelIndex.intValue() - 1;
//		label[ix] = NEXT;
		labels.add(new LabelHandle(ix,NEXT));
		// Util.BREAK("ByteCodeEngineering.treatLABEL: LABEL["+ix+"] ="+label[ix]);

		//instructionList.insert(pushConst,new NOP()); // Insert NOP before the pushConst instruction (handle).
		try {
			instructionList.delete(pushConst, invokeStatic);
		} catch (TargetLostException e) {
			for (final InstructionHandle target : e.getTargets()) {
				for (final InstructionTargeter targeter : target.getTargeters()) {
					targeter.updateTarget(target, NEXT);
				}
				// e.printStackTrace();
			}
		}
		instructionList.setPositions(); // Give all instructions their position number (offset in byte stream), i.e.,
										// make the list ready to be dumped.
		// Util.BREAK("ByteCodeEngineering.treatLABEL: LABEL["+ix+"] ="+label[ix]);
		if (TRACE_REPAIRING)
			listInstructionSequence("ByteCodeEngineering.treatLABEL: NEW ", PREV, 8);
	}
	
	private void listInstructionSequence(String id,InstructionHandle START,int n)
	{ InstructionHandle HHH=START;
	  System.out.println(id+"INSTRUCTION SEQUENCE:");
	  while((n--)>0) { System.out.println(id+HHH); HHH=HHH.getNext(); }
	}
	
	/*
	 * Locate the instruction sequence:
	 * <pre>
	 *    PREV-INSTRUCTION
	 *    GETFIELD JTX$
	 *    INVOKESTATIC JUMPTABLE$
	 *    NEXT-INSTRUCTION
	 * </pre>
	 * Replace it by:
	 * <pre>
	 *    PREV-INSTRUCTION
	 *    GETFIELD JTX$
	 *    TABLESWITCH ...
	 *    NEXT-INSTRUCTION
	 * </pre>
	 */
	private void treatJUMPTABLE(InstructionList instructionList,InstructionHandle invokeStatic)
    { // Util.BREAK("ByteCodeEngineering.treatJUMPTABLE: GOT JUMP -- InstructionHandle "+invokeStatic);
      InstructionHandle getfield=invokeStatic.getPrev();  
      Instruction maybeGetfieldInstruction=getfield.getInstruction();
	  if(maybeGetfieldInstruction instanceof GETFIELD)
	  { //GETFIELD getfieldInstruction=(GETFIELD)maybeGetfieldInstruction;
		// Util.BREAK("ByteCodeEngineering.treatJUMPTABLE: GOT JUMP -- InstructionHandle "+invokeStatic);
		InstructionHandle PREV=getfield.getPrev();
		InstructionHandle NEXT=invokeStatic.getNext();
		if(TRACE_REPAIRING) listInstructionSequence("ByteCodeEngineering.treatJUMPTABLE: GOT ",PREV,8);
		
//		int nLab=label.length;
		int nLab=labels.size();
		InstructionHandle[] label=new InstructionHandle[nLab];
		for(LabelHandle h:labels) label[h.index]=h.target;

		int[] match=new int[nLab];
		for(int i=0;i<nLab;i++) match[i]=i+1;
//		for(int i=0;i<nLab;i++)System.out.println("ByteCodeEngineering.treatJUMPTABLE: MATCH["+i+"] ="+match[i]);
//		for(int i=0;i<nLab;i++)System.out.println("ByteCodeEngineering.treatJUMPTABLE: LABEL["+i+"] ="+label[i]);
		TABLESWITCH tableSwitch=new TABLESWITCH(match,label,NEXT);
		if(TRACE_REPAIRING) exploreTableswitch(tableSwitch);

		instructionList.insert(invokeStatic,tableSwitch); // Insert tableSwitch before the invokeStatic instruction (handle).
		instructionList.setPositions(); // Give all instructions their position number (offset in byte stream), i.e., make the list ready to be dumped.
		if(TRACE_REPAIRING) exploreTableswitch(tableSwitch);
		try { instructionList.delete(invokeStatic); } catch(TargetLostException e)
        { for (final InstructionHandle target : e.getTargets()) {
            for (final InstructionTargeter targeter : target.getTargeters()) {
                targeter.updateTarget(target, NEXT);
            }
		    //e.printStackTrace();
		  }
        }

		instructionList.setPositions(); // Give all instructions their position number (offset in byte stream), i.e., make the list ready to be dumped.
		if(TRACE_REPAIRING) listInstructionSequence("ByteCodeEngineering.treatJUMPTABLE: NEW ",PREV,8);
		if(TRACE_REPAIRING) exploreTableswitch(tableSwitch);
	  } else Util.NOT_IMPLEMENTED("ByteCodeEngineering.treatJUMPTABLE: Unknown Instruction Sequence");
	}

	private void exploreTableswitch(TABLESWITCH tableSwitch) {
		// Util.BREAK("ByteCodeEngineering.exploreTableswitch: " + tableSwitch);
		StringBuilder s=new StringBuilder();
		int[] matchs = tableSwitch.getMatchs();
		InstructionHandle[] targets = tableSwitch.getTargets();
		s.append("  TABLESWITCH["+matchs[0]+":"+matchs[matchs.length-1]+']');
		s.append(" GOTO { ");
		for (int j = 0; j < targets.length; j++)
		{ if(j!=0) s.append(", ");
		  s.append(""+targets[j].getPosition());
		}
		s.append(" } Default: "+tableSwitch.getTarget().getPosition());
		System.out.println(s.toString());
	}
	
	private static String getMethodName(INVOKESTATIC invokeStatic, ConstantPool constantPool) {
		int index = invokeStatic.getIndex(); // Index into Constant Pool
		Constant cnst = constantPool.getConstant(index);
		// Util.BREAK("ByteCodeEngineering.getMethodName: cnst=" + cnst + ", QUAL=" + cnst.getClass().getName());
		if (cnst instanceof ConstantMethodref) {
			ConstantMethodref metref = (ConstantMethodref) cnst;
			int nameAndTypeIndex = metref.getNameAndTypeIndex(); // ConstantCP ?
			Constant nameAndTypeID = constantPool.getConstant(nameAndTypeIndex);
			// Util.BREAK("ByteCodeEngineering.getMethodName: nameAndTypeID=" + nameAndTypeID + ", QUAL=" + nameAndTypeID.getClass().getName());
			if (nameAndTypeID instanceof ConstantNameAndType) {
				ConstantNameAndType nameAndType = (ConstantNameAndType) nameAndTypeID;
				String methodName = nameAndType.getName(constantPool);
				// Util.BREAK("ByteCodeEngineering.getMethodName: methodName=" + methodName);
				return (methodName);
			}
		}
		return (null);
	}        	
        
	
	
//    private static void printCode(Method method, boolean verbose) {
//    	System.out.println(method);
//
//    	Code code = method.getCode();
//    	if (code != null) {
//                System.out.println(code.toString(verbose));
//    	}
//    }

}
