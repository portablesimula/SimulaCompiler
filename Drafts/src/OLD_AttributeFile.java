/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */


import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import simula.compiler.declaration.ArrayDeclaration;
import simula.compiler.declaration.BlockDeclaration;
import simula.compiler.declaration.BlockKind;
import simula.compiler.declaration.ClassDeclaration;
import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.HiddenSpecification;
import simula.compiler.declaration.LabelDeclaration;
import simula.compiler.declaration.Parameter;
import simula.compiler.declaration.ProcedureDeclaration;
import simula.compiler.declaration.ProcedureSpecification;
import simula.compiler.declaration.ProtectedSpecification;
import simula.compiler.declaration.StandardClass;
import simula.compiler.declaration.TypeDeclaration;
import simula.compiler.declaration.VirtualMatch;
import simula.compiler.declaration.VirtualSpecification;
import simula.compiler.expression.Constant;
import simula.compiler.expression.Expression;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

public final class OLD_AttributeFile {
//	private final String MAGIC="428-348"; // Platon lived ca. 428 through 348 BC.
//	private final String VERSION="1.0";
//
//	final String attributeFileName;
//	ObjectOutputStream oupt;
//	ObjectInputStream inpt;
//	boolean verbose=true; //false;//true;
//	
//	public OLD_AttributeFile(final String attributeFileName) {
//		this.attributeFileName = attributeFileName;
//		Util.BREAK("EXIT"); System.exit(-1);
//	}
//
//	private void TRACE_OUTPUT(final String msg) {
//		if (Option.TRACE_ATTRIBUTE_OUTPUT)
//			Util.println("ATTR OUTPUT: " + msg);
//	}
//
//	private void TRACE_INPUT(final String msg) {
//		if (Option.TRACE_ATTRIBUTE_INPUT)
//			Util.println("ATTR INPUT: " + msg);
//	}
//
//	public static void write(final ProgramModule program) throws IOException {
//		String relativeAttributeFileName = program.getRelativeAttributeFileName();
//		if (relativeAttributeFileName == null) return;
//		String attributeFileName = Global.tempClassFileDir + relativeAttributeFileName;
//		if (Option.verbose)	Util.TRACE("*** BEGIN Generate SimulaAttributeFile: " + attributeFileName);
//		OLD_AttributeFile attributeFile = new OLD_AttributeFile(attributeFileName);
//		attributeFile.write((BlockDeclaration) program.module);
//		if (Option.TRACE_ATTRIBUTE_OUTPUT) attributeFile.listAttributeFile(attributeFileName);
//		if (Option.verbose)	Util.TRACE("*** ENDOF Generate SimulaAttributeFile: " + attributeFileName);
//	}
//
//	private void write(final BlockDeclaration module) throws IOException {
//		File attributeDir = new File(Global.tempClassFileDir + Global.packetName);
//		// Util.BREAK("AttributeFile.write: attributeDir="+attributeDir);
//		// Util.BREAK("AttributeFile.write:
//		// attributeDir'canWrite="+attributeDir.canWrite());
//		attributeDir.mkdirs();
//		File attributeFile = new File(attributeFileName);
//		// Util.BREAK("AttributeFile.write: attributeFile="+attributeFile);
//		// Util.BREAK("AttributeFile.write:
//		// attributeFile'canWrite="+attributeFile.canWrite());
//		attributeFile.createNewFile();
//		// Util.BREAK("AttributeFile.write:
//		// attributeFile'canWrite="+attributeFile.canWrite());
//		FileOutputStream fileOutputStream = new FileOutputStream(attributeFile);
//		oupt = new ObjectOutputStream(fileOutputStream);
//		writeVersion();
//		writeDependencies();
//		if (Option.verbose)
//			Util.TRACE("***       Write External " + module.blockKind + ' ' + module.identifier + '[' + module.externalIdent + ']');
//		if(Global.NEW_VERSION) {
//			//Option.TRACE_ATTRIBUTE_OUTPUT=true;
//			oupt.writeObject(module);
//		} else doWriteAttributeInfo(module);
//		oupt.flush(); oupt.close();	oupt = null;
//	}
//
//	private void writeDependencies() throws IOException {
//		//Util.BREAK("AttributeFile.write: BEGIN WRITING DEPENDENCIES");
//		for(Declaration dcl:StandardClass.ENVIRONMENT.declarationList) {
//			//Util.BREAK("AttributeFile.write: DCL: "+dcl,", QUAL="+dcl.getClass().getSimpleName());
//			if(dcl instanceof BlockDeclaration) {
//				BlockDeclaration ext=(BlockDeclaration)dcl;
//				if(ext.isPreCompiled) {
//					//Util.BREAK("AttributeFile.write: BLK="+ext.identifier+", isPreCompiled="+ext.isPreCompiled);   
//					if (Option.verbose) Util.TRACE("***       Write External "+ext.blockKind+' '+ext.identifier+'['+ext.externalIdent+']');
//					if(Global.NEW_VERSION) {
//						oupt.writeObject(ext);
//					}
//					else doWriteAttributeInfo(ext);
//				}
//			}
//		}
//		//Util.BREAK("AttributeFile.write: END WRITING DEPENDENCIES");
//	}
//	
//	private BlockDeclaration listAttributeFile(final String attributeFileName) throws IOException {
//		if (Option.verbose)	Util.TRACE("*** BEGIN Read SimulaAttributeFile: " + attributeFileName);
//		FileInputStream fileInputStream = new FileInputStream(attributeFileName);
//		inpt = new ObjectInputStream(fileInputStream);
//		if (!checkVersion()) Util.error("Malformed SimulaAttributeFile: " + attributeFileName);
//		BlockDeclaration blockDeclaration=null;
//		if(Global.NEW_VERSION) {
//			blockDeclaration = readBlockDeclaration();			
//		} else {
//			BlockKind blockKind = readBlockKind();
//			blockDeclaration = readBlockDeclaration(blockKind);
//		}
//		inpt.close();
//		if (Option.verbose) {
//			// Util.BREAK("*** ENDOF Read SimulaAttributeFile: "+attributeFileName);
//			if (Option.TRACE_ATTRIBUTE_INPUT) {
//				Util.TRACE("*** ENDOF Read SimulaAttributeFile: " + attributeFileName);
//				blockDeclaration.print(0);
//			}
//		}
//		return (blockDeclaration);
//	}
//	
//	  
//	private BlockDeclaration readBlockDeclaration() {// throws IOException {
//		// Global.NEW_VERSION  ONLY
//		Option.TRACE_ATTRIBUTE_INPUT=true; Option.verbose=true;
//		BlockDeclaration blk=null;
//		try {
////			blk=(BlockDeclaration) inpt.readObject();
//			Object obj=inpt.readObject();
//			Util.BREAK("AttributeFile.readBlockDeclaration(1): "+obj+", QUAL="+((obj==null)?"null":obj.getClass().getSimpleName()));
//			if(obj instanceof BlockDeclaration) blk=(BlockDeclaration)obj;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Util.BREAK("AttributeFile.readBlockDeclaration: "+blk+", Declared in: "+((blk==null)?"null":blk.declaredIn.toString()));
//		return(blk);
//	}
//	  
//	private BlockDeclaration readBlockDeclaration(final BlockKind blockKind) throws IOException {
//		if (blockKind == BlockKind.Class)
//			return (readClassDeclaration());
//		else return (readProcedureDeclaration());
//	}
//
//	public static Type readAttributeFile(final InputStream inputStream,final String attributeFileName,final Vector<Declaration> declarationList) throws IOException {
//		if(Global.NEW_VERSION) {
//			//Option.TRACE_ATTRIBUTE_INPUT=true; Option.verbose=true;
//			return(readNEWAttributeFile(inputStream,attributeFileName,declarationList));
//		}
//		
//		OLD_AttributeFile attributeFile = new OLD_AttributeFile(attributeFileName);
//		if (Option.verbose)	Util.TRACE("*** BEGIN Read SimulaAttributeFile: " + attributeFileName);
//		attributeFile.inpt = new ObjectInputStream(inputStream);
//		if (!attributeFile.checkVersion())
//			Util.error("Malformed SimulaAttributeFile: " + attributeFileName);
//		Type moduleType=null;
//		LOOP: while (true) {
//			BlockKind blockKind = attributeFile.readBlockKind();
//			BlockDeclaration module = null;// attributeFile.readBlockDeclaration(blockKind);
//			if (blockKind == BlockKind.Procedure) module = attributeFile.readProcedureDeclaration();
//			else if (blockKind == BlockKind.Class) module = attributeFile.readClassDeclaration();
//			else break LOOP;
//			module.isPreCompiled = true;
//			declarationList.add(module);
//			moduleType=module.type;
//			if (Option.verbose)
//				Util.TRACE("***       Read External " + module.blockKind + ' ' + module.identifier + '[' + module.externalIdent + ']');
//			if (Option.TRACE_ATTRIBUTE_INPUT) module.print(0);
//		}
//		attributeFile.inpt.close();
//		if (Option.verbose)	Util.TRACE("*** ENDOF Read SimulaAttributeFile: " + attributeFileName);
//		return(moduleType);
//	}	
//
//	private static Type readNEWAttributeFile(final InputStream inputStream,final String attributeFileName,final Vector<Declaration> declarationList) throws IOException {
//		OLD_AttributeFile attributeFile = new OLD_AttributeFile(attributeFileName);
//		if (Option.verbose)	Util.TRACE("*** BEGIN Read SimulaAttributeFile: " + attributeFileName);
//		attributeFile.inpt = new ObjectInputStream(inputStream);
//		if (!attributeFile.checkVersion())
//			Util.error("Malformed SimulaAttributeFile: " + attributeFileName);
//		Type moduleType=null;
////		boolean eof=false;
////		LOOP: while (!eof) {
//		LOOP: while (true) {
//			BlockDeclaration module=null;
//			//Util.BREAK("AttributeFile.readBlockDeclaration(1): "+module);
//			try { module=(BlockDeclaration) attributeFile.inpt.readObject();}
//			catch (ClassNotFoundException e) { e.printStackTrace(); }
//			catch (EOFException e1) {
////				e1.printStackTrace(); eof=true;
//				break LOOP;
//			}
//			//Util.BREAK("AttributeFile.readBlockDeclaration: "+module+", Declared in: "+module.declaredIn);
//				
//			module.isPreCompiled = true;
//			declarationList.add(module);
//			moduleType=module.type;
//			if (Option.verbose)
//				Util.TRACE("***       Read External " + module.blockKind + ' ' + module.identifier + '[' + module.externalIdent + ']');
//			if (Option.TRACE_ATTRIBUTE_INPUT) module.print(0);
//		}
//		attributeFile.inpt.close();
//		if (Option.verbose)	Util.TRACE("*** ENDOF Read SimulaAttributeFile: " + attributeFileName);
//		return(moduleType);
//	}	
//	  
//	private void doWriteAttributeInfo(final Declaration dcl) throws IOException {
//		//Util.BREAK("AttributeFile.doWriteAttributeInfo: dcl="+dcl);
//	    if(dcl instanceof ClassDeclaration) doWriteClassDeclaration((ClassDeclaration)dcl);
//		else if(dcl instanceof ProcedureDeclaration) doWriteProcedureDeclaration((ProcedureDeclaration)dcl);
//		else if(dcl instanceof TypeDeclaration) writeTypeDeclaration((TypeDeclaration)dcl);
//		else if(dcl instanceof ArrayDeclaration) writeArrayDeclaration((ArrayDeclaration)dcl);
//	}
//	  
//	private void writeVersion() throws IOException {
//		oupt.writeUTF("SimulaAttributeFile"); oupt.writeUTF(MAGIC); oupt.writeUTF(VERSION);
//	}
//	
//	public boolean checkVersion() throws IOException {
//		if(!inpt.readUTF().equals("SimulaAttributeFile")) return(false);
//	    if(!inpt.readUTF().equals(MAGIC)) return(false);
//	    if(!inpt.readUTF().equals(VERSION)) return(false);
//	    return(true);
//	}
//	  
//	private void writeTypeDeclaration(final TypeDeclaration dcl) throws IOException {
//		TRACE_OUTPUT("Variable: "+dcl.type+' '+dcl.identifier+", constant="+dcl.isConstant()+", const="+dcl.constantElement);
//	    oupt.writeUTF("Variable"); oupt.writeUTF(dcl.identifier); writeType(dcl.type);
//	    oupt.writeBoolean(dcl.isConstant());
//	    writeConstant(dcl.constantElement);
//	}
//	
//	public TypeDeclaration readTypeDeclaration() throws IOException	{
//		String identifier=inpt.readUTF();
//	    Type type=readType();
//	    boolean constant=inpt.readBoolean();
//	    Constant constantElement=readConstant();
//	    TRACE_INPUT("Variable: "+type+' '+identifier+", constant="+constant+", constantElement="+constantElement);
//	    return(new TypeDeclaration(type,identifier,constant,constantElement));
//	}
//	
//	private void writeConstant(final Expression constantElement) throws IOException {
//		if(constantElement!=null) {
//			if(constantElement instanceof Constant) {
//				oupt.writeUTF("Constant"); writeType(constantElement.type);
//				//Util.BREAK("AttributeFile.writeConstant: "+cnst+", value="+cnst.value);
//				oupt.writeUTF(((Constant)constantElement).value.toString());
//			} else {
//				oupt.writeUTF("NoConstant");
//			}
//		} else oupt.writeUTF("NoConstant");
//	}
//	
//	private Constant readConstant() throws IOException {
//		String kind=inpt.readUTF();
//		if(kind.equalsIgnoreCase("NoConstant")) return(null);
//		Type type=readType();
//		String val=inpt.readUTF();
//		//Util.BREAK("AttributeFile.readConstant: type="+type+", value="+val);
//		Object value;
//		if(type==Type.Boolean)        value=Boolean.parseBoolean(val);
//		else if(type==Type.Character) value=val.charAt(0);
//		else if(type==Type.Text)      value=val;
//		else if(type==Type.Integer)	  value=Integer.parseInt(val);
//		else if(type==Type.Real)	  value=Float.parseFloat(val);
//		else if(type==Type.LongReal)  value=Double.parseDouble(val);
//		else { Util.FATAL_ERROR("Impossible"); return(null); }
//		
//		return(new Constant(type,value)); // TEMP !!!!!
//	}
//	  
//	private void writeArrayDeclaration(final ArrayDeclaration dcl) throws IOException	{
//		TRACE_OUTPUT("Array: "+dcl.type+' '+dcl.identifier+", nDim="+dcl.nDim);
//	    oupt.writeUTF("Array"); oupt.writeUTF(dcl.identifier); writeType(dcl.type);
//	    oupt.writeInt(dcl.nDim);
//	}
//	
//	public ArrayDeclaration readArrayDeclaration() throws IOException {
//		String identifier=inpt.readUTF();
//	    Type type=readType(); int nDim=inpt.readInt();
//	    TRACE_INPUT("Array: "+type+' '+identifier+", nDim="+nDim);
//	    return(new ArrayDeclaration(identifier,type,nDim));
//	}
//	  
//	private void doWriteClassDeclaration(final ClassDeclaration blk) throws IOException {
//		//Util.BREAK("AttributeFile.doWriteAttributeInfo: blk="+blk);
//		TRACE_OUTPUT("BEGIN Write Block: "+blk.identifier);
//		oupt.writeUTF(""+blk.blockKind);
//		writeString("Identifier",blk.identifier);
//		writeString("ExtIdentifier",blk.externalIdent);
//		oupt.writeUTF("BlockType"); writeType(blk.type);
//		writeInt("BlockLevel",blk.blockLevel);
//		for(Parameter par:blk.parameterList) writeParameter(par);
//		writeString("Prefix",blk.prefix);
//		writeBoolean("HasLocalClasses",blk.hasLocalClasses);
//		writeBoolean("DetachUsed",blk.detachUsed);
//		for(VirtualSpecification vrt:blk.virtualSpecList) writeVirtualSpec(vrt);
////      for(VirtualMatch mth:blk.virtualMatchList) writeVirtualMatch(mth);
//		for(HiddenSpecification hdn:blk.hiddenList) writeString("Hidden",hdn.identifier);
//		for(ProtectedSpecification prt:blk.protectedList) writeString("Protected",prt.identifier);
//		for(LabelDeclaration lab:blk.labelList) writeLabel(lab);
//		for(Declaration dcl:blk.declarationList) doWriteAttributeInfo(dcl);
//		for(VirtualMatch mth:blk.virtualMatchList) writeVirtualMatch(mth);
//		if(blk.code1!=null) writeSavedCode("Code1",blk.code1);
//		if(blk.code2!=null) writeSavedCode("Code2",blk.code2);
//		oupt.writeUTF("BLOCKEND");
//		TRACE_OUTPUT("END Write Block: "+blk.identifier);
//	}
//
//	private void doWriteProcedureDeclaration(final ProcedureDeclaration blk) throws IOException {
//		//Util.BREAK("AttributeFile.doWriteAttributeInfo: blk="+blk);
//		TRACE_OUTPUT("BEGIN Write Block: "+blk.identifier);
//		oupt.writeUTF(""+blk.blockKind);
//		writeString("Identifier",blk.identifier);
//		writeString("ExtIdentifier",blk.externalIdent);
//		oupt.writeUTF("BlockType"); writeType(blk.type);
//		writeInt("BlockLevel",blk.blockLevel);
//		for(Parameter par:blk.parameterList) writeParameter(par);
//		oupt.writeUTF("BLOCKEND");
//		TRACE_OUTPUT("END Write Block: "+blk.identifier);
//	}
//	  
//	public ClassDeclaration readClassDeclaration() throws IOException {
//		TRACE_INPUT("BEGIN Read Block:");
//		ClassDeclaration decl=new ClassDeclaration(null);
//		decl.blockKind=BlockKind.Class;
//	//	decl.blockKind=BlockKind.ExternalClass;
//		READING:while(true) {
//			String label=readString();
//		    //Util.BREAK("AttributeFile.doReadAttributeInfo: label="+label);
//		    if(label.equalsIgnoreCase("BlockDeclaration.Kind")) decl.blockKind=readBlockKind();
//			else if(label.equalsIgnoreCase("Identifier")) decl.identifier=readString();
//			else if(label.equalsIgnoreCase("ExtIdentifier")) decl.externalIdent=readString();
//			else if(label.equalsIgnoreCase("BlockType")) decl.type=readType();
//			else if(label.equalsIgnoreCase("BlockLevel")) decl.blockLevel=readInt();
//			else if(label.equalsIgnoreCase("Parameter")) decl.parameterList.add(readParameter());
//		    else if(label.equalsIgnoreCase("Prefix")) decl.prefix=readString();
//		    else if(label.equalsIgnoreCase("HasLocalClasses")) decl.hasLocalClasses=readBoolean();
//		    else if(label.equalsIgnoreCase("DetachUsed")) decl.detachUsed=readBoolean();
//		    else if(label.equalsIgnoreCase("VirtualSpec")) decl.virtualSpecList.add(readVirtualSpec(decl));
//		    else if(label.equalsIgnoreCase("VirtualMatch")) decl.virtualMatchList.add(readVirtualMatch(decl));
//		    else if(label.equalsIgnoreCase("Hidden")) decl.hiddenList.add(new HiddenSpecification(decl,readString()));
//		    else if(label.equalsIgnoreCase("Protected")) decl.protectedList.add(new ProtectedSpecification(decl,readString()));
//		    else if(label.equalsIgnoreCase("Label")) decl.labelList.add(readLabel());
//		    else if(label.equalsIgnoreCase("Variable")) decl.declarationList.add(readTypeDeclaration());
//		    else if(label.equalsIgnoreCase("Array")) decl.declarationList.add(readArrayDeclaration());
//		    else if(label.equalsIgnoreCase("Class")) decl.declarationList.add(readClassDeclaration());
//		    else if(label.equalsIgnoreCase("Procedure")) decl.declarationList.add(readProcedureDeclaration());
//		    else if(label.equalsIgnoreCase("Code1")) readCode1(decl);
//		    else if(label.equalsIgnoreCase("Code2")) readCode2(decl);
//		    else if(label.equalsIgnoreCase("BLOCKEND")) break READING;
//		    else Util.error("Malformed Attribute File (at "+label+")");
//		}
//		TRACE_INPUT("Block: "+decl);
//		//decl.print(0);
//		Global.currentScope=decl.declaredIn;
//		return(decl);
//	}
//
//    private void writeSavedCode(final String label,final Vector<CodeLine> code) throws IOException {
//    	//System.out.println("AttributeFile.writeSavedCode: "+label+", size="+code.size());
//    	if(code.size()>0) {
//    		oupt.writeUTF(label); oupt.writeInt(code.size());
//    		for(CodeLine c:code) {
//    			//System.out.println("Line: "+c.sourceLineNumber+"  "+c.codeLine);
//        		TRACE_OUTPUT(label+": "+c);
//        		oupt.writeInt(c.sourceLineNumber);
//        		oupt.writeUTF(c.codeLine);
//    		}
//    	}
//    }
//
//    private void readCode1(final ClassDeclaration cls) throws IOException {
//    	cls.code1=new Vector<CodeLine>();
//    	int size=inpt.readInt();
//    	//System.out.println("AttributeFile.readCode1: size="+size);
//    	for(int i=0;i<size;i++) {
//    		CodeLine line=new CodeLine(inpt.readInt(),inpt.readUTF());
//    		//System.out.println("Line: "+line);
//    		TRACE_INPUT("Code1: "+line);
//    		cls.code1.add(line);
//    	}
//    }
//
//    private void readCode2(final ClassDeclaration cls) throws IOException {
//    	cls.code2=new Vector<CodeLine>();
//    	int size=inpt.readInt();
//    	//System.out.println("AttributeFile.readCode2: size="+size);
//    	for(int i=0;i<size;i++) {
//    		CodeLine line=new CodeLine(inpt.readInt(),inpt.readUTF());
//    		//System.out.println("Line: "+line);
//    		TRACE_INPUT("Code2: "+line);
//    		cls.code2.add(line);
//    	}
//    }
//	  
//	public ProcedureDeclaration readProcedureDeclaration() throws IOException {
//		TRACE_INPUT("BEGIN Read Block:");
//	    ProcedureDeclaration decl=new ProcedureDeclaration(null,BlockKind.Procedure);
////	    ProcedureDeclaration decl=new ProcedureDeclaration(null,BlockKind.ExternalProcedure);
//	    decl.blockKind=BlockKind.Procedure;
////	    decl.blockKind=BlockKind.ExternalProcedure;
//	    READING:while(true) {
//	    	String label=readString();
//	        //Util.BREAK("AttributeFile.doReadAttributeInfo: label="+label);
//		    if(label.equalsIgnoreCase("BlockDeclaration.Kind")) decl.blockKind=readBlockKind();
//			else if(label.equalsIgnoreCase("Identifier")) decl.identifier=readString();
//			else if(label.equalsIgnoreCase("ExtIdentifier")) decl.externalIdent=readString();
//			else if(label.equalsIgnoreCase("BlockType")) decl.type=readType();
//			else if(label.equalsIgnoreCase("BlockLevel")) decl.blockLevel=readInt();
//			else if(label.equalsIgnoreCase("Parameter")) decl.parameterList.add(readParameter());
////	        else if(label.equalsIgnoreCase("Prefix")) decl.prefix=readString();
//		    else if(label.equalsIgnoreCase("HasLocalClasses")) decl.hasLocalClasses=readBoolean();
////	        else if(label.equalsIgnoreCase("DetachUsed")) decl.detachUsed=readBoolean();
////	        else if(label.equalsIgnoreCase("Virtual")) decl.virtualList.add(readVirtual());
////	        else if(label.equalsIgnoreCase("Hidden")) decl.hiddenList.add(readString());
////	        else if(label.equalsIgnoreCase("Protected")) decl.protectedList.add(readString());
//		    else if(label.equalsIgnoreCase("Label")) decl.labelList.add(readLabel());
//		    else if(label.equalsIgnoreCase("Variable")) decl.declarationList.add(readTypeDeclaration());
//		    else if(label.equalsIgnoreCase("Array")) decl.declarationList.add(readArrayDeclaration());
//		    else if(label.equalsIgnoreCase("Class")) decl.declarationList.add(readClassDeclaration());
//		    else if(label.equalsIgnoreCase("Procedure")) decl.declarationList.add(readProcedureDeclaration());
//		    else if(label.equalsIgnoreCase("BLOCKEND")) break READING;
//		    else Util.error("Malformed Attribute File (at "+label+")");
//		}
//		TRACE_INPUT("Block: "+decl);
//		//decl.print(0);
//		Global.currentScope=decl.declaredIn;
//		return(decl);
//	}
//	
//	private void writeParameter(final Parameter par) throws IOException {
//		TRACE_OUTPUT("Parameter: "+par.type+' '+par.identifier+' '+par.kind+' '+par.mode);
//	    oupt.writeUTF("Parameter"); oupt.writeUTF(par.identifier); oupt.writeUTF(par.externalIdent);
//	    writeType(par.type); writeParameterKind(par.kind); writeParameterMode(par.mode);
//	}
//	
//	public Parameter readParameter() throws IOException	{
//		String identifier=inpt.readUTF();
//		String externalIdent=inpt.readUTF();
//		Type type=readType();
//		Parameter.Kind kind=readParameterKind();
//		Parameter.Mode mode=readParameterMode();
//		Parameter par=new Parameter(identifier,type,kind);
//		par.externalIdent=externalIdent; par.mode=mode;
//		TRACE_INPUT("Parameter: "+type+' '+identifier+' '+kind+' '+mode);
//		return(par);
//	}
//	
//	private void writeVirtualSpec(final VirtualSpecification virt) throws IOException	{
//		TRACE_OUTPUT("VirtualSpec: "+virt.type+' '+virt.identifier);
//	    oupt.writeUTF("VirtualSpec");
////	    oupt.writeInt(virt.prefixLevel);
//	    oupt.writeUTF(virt.identifier); writeType(virt.type);
//	    writeVirtProcedureSpec(virt.procedureSpec);
//	}
//	
//	public VirtualSpecification readVirtualSpec(final ClassDeclaration specifiedIn) throws IOException {
//		//int prefixLevel=inpt.readInt();
//	    String identifier=inpt.readUTF();
//	    //Util.BREAK("AttributeInputStream.readVirtual: identifier="+identifier);
//	    Type type=readType();
//	    //Util.BREAK("AttributeInputStream.readVirtual: type="+type);
//	    ProcedureSpecification procedureSpec=readVirtProcedureSpec();
////	    return(new VirtualSpecification(prefixLevel,identifier,type,procedureSpec));
//	    VirtualSpecification.Kind kind=VirtualSpecification.Kind.Procedure; // AdHoc
//	    return(new VirtualSpecification(specifiedIn,identifier,type,kind,procedureSpec));
//	}
//	
//	private void writeVirtualMatch(final VirtualMatch match) throws IOException {
//		TRACE_OUTPUT("VirtualMatch: "+match.identifier);
//	    oupt.writeUTF("VirtualMatch");
//	    oupt.writeUTF(match.identifier);
//	}
//	
//	public VirtualMatch readVirtualMatch(final ClassDeclaration decl) throws IOException {
//		//int prefixLevel=inpt.readInt();
//		String identifier=inpt.readUTF();
//		//Util.BREAK("AttributeInputStream.readVirtualMatch: Search="+decl);
//		//Util.BREAK("AttributeInputStream.readVirtualMatch: identifier="+identifier);
//		ProcedureDeclaration proc=decl.findLocalProcedure(identifier);
//		//Util.BREAK("AttributeInputStream.readVirtualMatch: proc="+proc);
//		if(proc!=null) {
////  	    VirtualSpecification virtualSpec=proc.getVirtualSpecification();
//			VirtualSpecification virtualSpec=VirtualSpecification.getVirtualSpecification(proc);  // AdHoc
//			//Util.BREAK("AttributeInputStream.readVirtualMatch: virtualSpec="+virtualSpec);
//		  	if(virtualSpec!=null) return(new VirtualMatch(virtualSpec,proc));
//		}
//	  	Util.error("Malformed Attribute File (at VirtualMatch "+identifier+")");
//	  	return(null); // Error Recovery
//	}
//	
//	private void writeVirtProcedureSpec(final ProcedureSpecification procedureSpec) throws IOException {
//		if(procedureSpec==null) { oupt.writeUTF("NOSPEC"); return; }
//		TRACE_OUTPUT("ProcedureSpecification: "+procedureSpec.type+' '+procedureSpec.identifier);
//		oupt.writeUTF("ProcedureSpec"); oupt.writeUTF(procedureSpec.identifier); writeType(procedureSpec.type);
//		for(Parameter par:procedureSpec.parameterList) writeParameter(par);
//		oupt.writeUTF("PROCEND");
//	}
//	
//	public ProcedureSpecification readVirtProcedureSpec() throws IOException {
//		String label=readString(); if(label.equalsIgnoreCase("NOSPEC")) return(null);
//	    if(!label.equalsIgnoreCase("ProcedureSpec")) Util.error("Malformed Attribute File (at "+label+")");
//		String identifier=inpt.readUTF();
//		//Util.BREAK("AttributeInputStream.readVirtual: identifier="+identifier);
//		Type type=readType();
//		//Util.BREAK("AttributeInputStream.readVirtual: type="+type);
//		Vector<Parameter> parameterList=new Vector<Parameter>();
//		READING:while(true) {
//			label=readString();
//		    //Util.BREAK("AttributeFile.doReadAttributeInfo: label="+label);
//		    if(label.equalsIgnoreCase("Parameter"))	parameterList.add(readParameter());
//		    else if(label.equalsIgnoreCase("PROCEND")) break READING;
//		    else Util.error("Malformed Attribute File (at "+label+")");
//		}
//		return(new ProcedureSpecification(identifier,type,parameterList));
//	}
//	
//	private void writeLabel(final LabelDeclaration lab) throws IOException {
//		TRACE_OUTPUT("Label: "+lab.index);
//	    oupt.writeUTF("Label"); oupt.writeUTF(lab.identifier); oupt.writeInt(lab.index);
//	}
//	
//	public LabelDeclaration readLabel() throws IOException {
//		String identifier=inpt.readUTF();
//		//Util.BREAK("AttributeInputStream.readVirtual: identifier="+identifier);
//		int index=readInt();
//		//Util.BREAK("AttributeInputStream.readVirtual: index="+index);
//		LabelDeclaration labelDeclaration=new LabelDeclaration(identifier);
//		labelDeclaration.index=index;
//		return(labelDeclaration);
//	}
//
//	private void writeType(final Type type) throws IOException {
//		TRACE_OUTPUT("Type="+type);
//		if(type==Type.Text) oupt.writeUTF("TEXT");
//		else if(type==Type.LongReal) oupt.writeUTF("LongReal");
//		else if(type==null) oupt.writeUTF("NULLTYPE");
//		else if(type.isReferenceType()) oupt.writeUTF(type.getRefIdent());
//		else oupt.writeUTF(""+type);
//	}
//	
//	private Type readType() throws IOException {
//		String tp=inpt.readUTF();
//		if(tp.equalsIgnoreCase("Integer")) return(Type.Integer);
//		if(tp.equalsIgnoreCase("Real")) return(Type.Real);
//		if(tp.equalsIgnoreCase("LongReal")) return(Type.LongReal);
//		if(tp.equalsIgnoreCase("Boolean")) return(Type.Boolean);
//		if(tp.equalsIgnoreCase("Character")) return(Type.Character);
//		if(tp.equalsIgnoreCase("Text")) return(Type.Text);
//		if(tp.equalsIgnoreCase("Procedure")) return(Type.Procedure);
//		if(tp.equalsIgnoreCase("Label")) return(Type.Label);
//		if(tp.equalsIgnoreCase("NULLTYPE")) return(null);
//		return(new Type(tp));
//	}
//
//	private void writeParameterKind(final Parameter.Kind kind) throws IOException	{
//		TRACE_OUTPUT("Kind="+kind);
//	    oupt.writeUTF(""+kind);
//	}
//	
//	private Parameter.Kind readParameterKind() throws IOException {
//		String kind=inpt.readUTF();
//		//Util.BREAK("AttributeInputStream.readParameterKind: kind="+kind);
//		if(kind.equalsIgnoreCase("Simple")) return(Parameter.Kind.Simple);
//		if(kind.equalsIgnoreCase("Array")) return(Parameter.Kind.Array);
//		if(kind.equalsIgnoreCase("Procedure")) return(Parameter.Kind.Procedure);
//		if(kind.equalsIgnoreCase("Label")) return(Parameter.Kind.Label);
//		return(null);
//	}
//
//	private void writeParameterMode(final Parameter.Mode mode) throws IOException	{
//		TRACE_OUTPUT("Mode="+mode);
//	    oupt.writeUTF(""+mode);
//	}
//	
//	private Parameter.Mode readParameterMode() throws IOException {
//		String tp=inpt.readUTF();
//	    //Util.BREAK("AttributeInputStream.readParameterMode: tp="+tp);
//	    if(tp.equalsIgnoreCase("Value")) return(Parameter.Mode.value);
//	    if(tp.equalsIgnoreCase("Name")) return(Parameter.Mode.name);
//	    return(null);
//	}
//	
//	public BlockKind readBlockKind() { //throws IOException
//		try {
//			String kind=inpt.readUTF();
//	        //Util.BREAK("AttributeInputStream.readBlockKind: kind="+kind);
//            if(kind.equalsIgnoreCase("Procedure")) return(BlockKind.Procedure);
////	        if(kind.equalsIgnoreCase("Procedure")) return(BlockKind.ExternalProcedure);
//	        return(BlockKind.Class);
////	        return(BlockKind.ExternalClass);
//		} catch(IOException e) {
//	        //Util.BREAK("AttributeInputStream.readBlockKind: END-OF-AF");
//		    return(null);
//		}
//	}
//	
//	private void writeString(final String label,final String val) throws IOException {
//		TRACE_OUTPUT("String: " + label + ": " + val);
//		oupt.writeUTF(label);
//		oupt.writeUTF(val);
//	}
//
//	private String readString() throws IOException {
//		return (inpt.readUTF());
//	}
//
//	private void writeInt(final String label,final int val) throws IOException {
//		TRACE_OUTPUT("Int: " + label + ": " + val);
//		oupt.writeUTF(label);
//		oupt.writeInt(val);
//	}
//
//	public int readInt() throws IOException {
//		int result = inpt.readInt();
//		// Util.BREAK("AttributeInputStream.readInt: result="+result);
//		return (result);
//	}
//
//	private void writeBoolean(final String label,final boolean val) throws IOException {
//		TRACE_OUTPUT("Boolean: " + label + ": " + val);
//		oupt.writeUTF(label);
//		oupt.writeBoolean(val);
//	}
//
//	public boolean readBoolean() throws IOException {
//		return (inpt.readBoolean());
//	}

}
