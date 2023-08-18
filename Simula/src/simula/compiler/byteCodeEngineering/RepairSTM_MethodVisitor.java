/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.byteCodeEngineering;

import java.util.ListIterator;
import java.util.Vector;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TableSwitchInsnNode;

import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Repair STM_ MethodVisitor.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/byteCodeEngineering/RepairSTM_MethodVisitor.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public class RepairSTM_MethodVisitor extends MethodVisitor {
	private static final boolean DEBUG=false;

	private String classFileName;
	private MethodNode mn;
	private MethodVisitor next;
	
	private InsnList instructions;
	
	private class LabelHandle {
		int index;
		LabelNode target;
		String ident;
		LabelHandle(int index,LabelNode target,Object ident) {
			this.index=index; this.target=target; this.ident=(String)ident; }
		@Override
		public String toString() { return("LABEL"+index+" = "+ident); }//+" = "+AsmUtils.edLabel(target)); }
	}
	
	private Vector<LabelHandle> labelHandles;
	private int maxIndex;

	/**
	 * The repair STM MethodVisitor.
	 * 
	 * @param classFileName the classFileName
	 * @param access        the method's access flags
	 * @param name          the method's name
	 * @param desc          the method's descriptor
	 * @param mv            the MethodVisitor
	 */
	RepairSTM_MethodVisitor(String classFileName, int access, String name, String desc, MethodVisitor mv) {
		super(SimClassVisitor.ASM_Release, new MethodNode(access, name, desc, null, null));
		this.classFileName=classFileName;
		next = mv;
	}

	@Override
	public void visitEnd() {
		if(DEBUG) Util.println("Repair_STMMethodVisitor: Visit END: mv'QUAL="+mv.getClass().getSimpleName());
		mn = (MethodNode) mv;
		instructions=mn.instructions;
		String methodName=mn.name;
		treat_STMMethod(methodName);
		mn.accept(next);
	}
	
	
	private void treat_STMMethod(String methodName) {
        if(Option.TRACE_REPAIRING) Util.println("*** PASS 1 - FIND AND TREAT ALL LABELS IN "+methodName+"("+classFileName+") ***");
        labelHandles=new Vector<LabelHandle>(); maxIndex=0;
		ListIterator<AbstractInsnNode> iterator1=instructions.iterator();
		while(iterator1.hasNext()) {
			AbstractInsnNode instr=iterator1.next();
			//if(DEBUG) Util.println("Repair_STMMethodVisitor.treat_STMMethod: PASS1 Instruction="+edInstruction(instr));
			int opcode=instr.getOpcode();
			if(opcode==Opcodes.INVOKESTATIC) {
//				if(DEBUG) Util.println("Repair_STMMethodVisitor.treat_STMMethod: PASS1 Method Instruction="+AsmUtils.edInstruction(instr));
				MethodInsnNode invokeStatic=(MethodInsnNode)instr;
				String name=invokeStatic.name;
				if(name.equals("_LABEL"))  {
//					if(DEBUG) Util.println("Repair_STMMethodVisitor.treat_STMMethod: PASS1 GOT: INVOKESTATIC _LABEL (I)V false, opcode="+opcode+", Opcode="+Opcodes.INVOKESTATIC);
					if(DEBUG) Util.println("Repair_STMMethodVisitor.treat_STMMethod: PASS1 GOT: INVOKESTATIC _LABEL (I)V false, instr="+AsmUtils.edInstruction(instr));
					treatLABEL(invokeStatic);
				}
			}
		}
		
	       
//		String method=AsmUtils.edAccessFlags(mn.access)+' '+methodName+"("+classFileName+")";
		String method=methodName+"("+classFileName+")";
        if(labelHandles.size()==0) {
        	if(DEBUG) Util.println("Repair_STMMethodVisitor: No label found in Method "+method);
        	return; // ByteCodeEngineering FAILED
        } else if(Option.verbose) Util.println("Repair_STMMethodVisitor: "+labelHandles.size()+" label found in Method "+method);
        
        if(Option.TRACE_REPAIRING) Util.println("*** PASS 2 - FIND AND TREAT _JUMPTABLE ***");
		ListIterator<AbstractInsnNode> iterator2=instructions.iterator();
		PASS2:while(iterator2.hasNext()) {
			AbstractInsnNode instr=iterator2.next();
			int opcode=instr.getOpcode();
			if(opcode==Opcodes.INVOKESTATIC) {
				//if(DEBUG) Util.println("Repair_STMMethodVisitor.treat_STMMethod: PASS2 Method Instruction="+edInstruction(instr));
				MethodInsnNode invokeStatic=(MethodInsnNode)instr;
				String name=invokeStatic.name;
				String desc=invokeStatic.desc;
				boolean itf=invokeStatic.itf;
				if(name.equals("_JUMPTABLE") & desc.equals("(I)V") & (!itf)	)  {
					if(DEBUG) Util.println("Repair_STMMethodVisitor.treat_STMMethod: PASS2 GOT: INVOKESTATIC _JUMPTABLE (I)V false, opcode="+opcode+", Opcode="+Opcodes.INVOKESTATIC);
//					if(DEBUG) Util.println("Repair_STMMethodVisitor.treat_STMMethod: PASS2 GOT: INVOKESTATIC _JUMPTABLE (I)V false, instr="+AsmUtils.edInstruction(instr));
					treatJUMPTABLE(invokeStatic); break PASS2;
				}
			}
		}
		instructions.resetLabels();

        if(Option.LIST_REPAIRED_INSTRUCTION_LIST) {
        	Util.println("*** LIST REPAIRED INSTRUCTION LIST ***");
        	ListIterator<AbstractInsnNode> iterator3=instructions.iterator();
        	while(iterator3.hasNext()) {
        		AbstractInsnNode instr=iterator3.next();
				Util.println("  "+AsmUtils.edInstruction(instr));
//				Util.println("  "+instr);
          }
        }
	}

	// ************************************************************************
	// *** PASS1: treatLabel
	// ************************************************************************
	/*
	 * Locate the instruction sequence:
	 * <pre>
	 *    PREV-INSTRUCTION
	 *    ICONST n   or  BIPUSH  or SIPUSH
	 *    LDC Label-ident
	 *    INVOKESTATIC _LABEL
	 *    NEXT-INSTRUCTION
	 * </pre>
	 */
	private void treatLABEL(MethodInsnNode invokeStatic) {
		AbstractInsnNode pushLabelIdentifier=invokeStatic.getPrevious();
		// Retrieve Label Identifier
		Object labelIdentifier="Unknown";
		//Util.ASSERT(pushLabelIdentifier.getType()==AbstractInsnNode.LDC_INSN,"Repair_STMMethodVisitor.treatLABEL: Invariant-1");
		if(pushLabelIdentifier.getType()!=AbstractInsnNode.LDC_INSN) {
			Util.println("Repair_STMMethodVisitor.treatLABEL: UNEXPECTED INSTRUCTION SEQUENCE BEFORE INVOKE _LABEL");
			listInstructionSequence("Repair_STMMethodVisitor.treatLABEL: UNKNOWN ", pushLabelIdentifier.getPrevious().getPrevious(), 8);
			Util.IERR("FORCED EXIT");
		} else {
			LdcInsnNode labid=(LdcInsnNode)pushLabelIdentifier;
			labelIdentifier=labid.cst;
			if(DEBUG) Util.println("Repair_STMMethodVisitor.treatLABEL: labeIdentr="+labelIdentifier+", QUAL="+labelIdentifier.getClass().getSimpleName());
			instructions.remove(pushLabelIdentifier);
		}
		
		// Retrieve Label Index
		AbstractInsnNode pushLabelIndexInstrution=invokeStatic.getPrevious();
		int prevOpcode=pushLabelIndexInstrution.getOpcode();
		int insType=pushLabelIndexInstrution.getType();
//		if(DEBUG) Util.println("Repair_STMMethodVisitor.treatLABEL: prev2 instr="+AsmUtils.edInstruction(pushLabelIndexInstrution)+", type="+insType+", QUAL="+pushLabelIndexInstrution.getClass().getSimpleName());
//		if(DEBUG) Util.println("Repair_STMMethodVisitor.treatLABEL: prev1 instr="+AsmUtils.edInstruction(pushLabelIdentifier)+", type="+insType+", QUAL="+pushLabelIdentifier.getClass().getSimpleName());
		
		int labelIndex=0;
		// • Load a constant on to the operand stack: bipush, sipush, ldc, ldc_w, ldc2_w,
		//   aconst_null, iconst_m1, iconst_<i>, lconst_<l>, fconst_<f>, dconst_<d>.
		if(insType==AbstractInsnNode.INSN) {
			switch(prevOpcode)
			{ case Opcodes.ICONST_1: labelIndex=1; break;
			  case Opcodes.ICONST_2: labelIndex=2; break;
			  case Opcodes.ICONST_3: labelIndex=3; break;
			  case Opcodes.ICONST_4: labelIndex=4; break;
			  case Opcodes.ICONST_5: labelIndex=5; break;
			  default: Util.IERR("Repair_STMMethodVisitor.treatLABEL: IMPOSSIBLE-1");
			}
		}
		else if(insType==AbstractInsnNode.INT_INSN) {
			IntInsnNode iprev=(IntInsnNode)pushLabelIndexInstrution;
			switch(prevOpcode)
			{ case Opcodes.BIPUSH: labelIndex=iprev.operand; break; // Value: −128 <= labelIndex < 127
			  case Opcodes.SIPUSH: labelIndex=iprev.operand; break; // Value: −32768 <= labelIndex < 32767
			  default: Util.IERR("Repair_STMMethodVisitor.treatLABEL: IMPOSSIBLE-2");
			}
		}
		else if(insType==AbstractInsnNode.LDC_INSN) {
			LdcInsnNode lprev=(LdcInsnNode)pushLabelIndexInstrution;
			Object cst=lprev.cst;
			//labelIndex=VALUE(cst); // Hva gjør vi her ??
			listInstructionSequence("Repair_STMMethodVisitor.treatLABEL: UNKNOWN ", pushLabelIndexInstrution.getPrevious().getPrevious(), 8);
			Util.IERR("*** NOT IMPLEMENTED: " +"More than 32767 labels in same Block (cst="+cst+')');
		} else {
			Util.IERR("Repair_STMMethodVisitor.treatLABEL: IMPOSSIBLE-3");
		}
		if(DEBUG) Util.println("Repair_STMMethodVisitor.treatLABEL: PASS1 GOT: _LABEL"+labelIndex);
		AbstractInsnNode start=pushLabelIndexInstrution.getPrevious().getPrevious().getPrevious().getPrevious();
		if (Option.TRACE_REPAIRING)
			listInstructionSequence("Repair_STMMethodVisitor.treatLABEL: GOT ", start, 8);
		LabelNode label=new LabelNode();
//		if(DEBUG) Util.println("Repair_STMMethodVisitor.treatLABEL: ADD LableHandle: labelIndex="+labelIndex+", label="+AsmUtils.edLabel(label)+", ident="+labelIdentifier);
		maxIndex=Math.max(maxIndex,labelIndex);
		labelHandles.add(new LabelHandle(labelIndex,label,labelIdentifier));
		instructions.insertBefore(pushLabelIndexInstrution, label); // Insert Label before pushLabelIndexInstrution
		instructions.remove(pushLabelIndexInstrution);
		instructions.remove(invokeStatic);
		if (Option.TRACE_REPAIRING)
			listInstructionSequence("Repair_STMMethodVisitor.treatLABEL: NEW ", start, 8);
	}
	
	private void listInstructionSequence(String id,AbstractInsnNode START,int n) {
		AbstractInsnNode HHH=START;
		Util.println(id+"INSTRUCTION SEQUENCE:");
		while((n--)>0) { Util.println(id+AsmUtils.edInstruction(HHH)); HHH=HHH.getNext(); }
	}

	
	// ************************************************************************
	// *** PASS2: treatJUMPTABLE
	// ************************************************************************
	/*
	 * Locate the instruction sequence:
	 * <pre>
	 *    PREV-INSTRUCTION
	 *    GETFIELD _JTX
	 *    INVOKESTATIC _JUMPTABLE
	 *    NEXT-INSTRUCTION
	 * </pre>
	 * Replace it by:
	 * <pre>
	 *    PREV-INSTRUCTION
	 *    GETFIELD _JTX
	 *    TABLESWITCH ...
	 *    NEXT-INSTRUCTION
	 * </pre>
	 */
	private void treatJUMPTABLE(MethodInsnNode invokeStatic) {
		AbstractInsnNode start=invokeStatic.getPrevious().getPrevious();
		if (Option.TRACE_REPAIRING)
			listInstructionSequence("Repair_STMMethodVisitor.treatJUMPTABLE: GOT ", start, 8);
		// Prepare Labels
		LabelNode[] labels=new LabelNode[maxIndex];
		if(DEBUG) {
			Util.println("Repair_STMMethodVisitor.treatJUMPTABLE: size="+labelHandles.size());
			Util.println("Repair_STMMethodVisitor.treatJUMPTABLE: labels.length="+labels.length);
			Util.println("Repair_STMMethodVisitor.treatJUMPTABLE: maxIndex="+maxIndex);
		}
		boolean failed=false;
		for(LabelHandle h:labelHandles) {
			if (Option.TRACE_REPAIRING)
				Util.println("Repair_STMMethodVisitor.treatJUMPTABLE: "+h);
			labels[h.index-1]=h.target;
			if(h.target==null) failed=true;
		}
		if(failed) {
			for(LabelHandle h:labelHandles) {
				Util.println("Repair_STMMethodVisitor.treatJUMPTABLE: "+h);
			}
			Util.IERR("ByteCode Engineering FAILED");
		}
		
		int min=1; // the minimum key value.
		int max=labels.length; // the maximum key value.
		LabelNode dflt=new LabelNode(); // beginning of the default handler block.
		TableSwitchInsnNode tableSwitch=new TableSwitchInsnNode(min,max,dflt,labels);
//		if(DEBUG) AsmUtils.exploreTableswitch(tableSwitch);
		instructions.insertBefore(invokeStatic, tableSwitch); // Insert tableSwitch before invokeStatic
		instructions.insertBefore(invokeStatic, dflt); // Insert dflt before invokeStatic
		instructions.remove(invokeStatic);
		
		if (Option.TRACE_REPAIRING)
			listInstructionSequence("Repair_STMMethodVisitor.treatJUMPTABLE: NEW ", start, 8);
	}


}
