/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler;

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
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

public final class AttributeFile {
	private final String MAGIC="428-348"; // Platon lived ca. 428 through 348 BC.
	private final String VERSION="1.0";

	String attributeFileName;
	ObjectOutputStream oupt;
	ObjectInputStream inpt;
	boolean verbose=true; //false;//true;
	
	public AttributeFile(String attributeFileName) 
	{ this.attributeFileName=attributeFileName; }
	
	private void TRACE_OUTPUT(String msg)
	{ if(Option.TRACE_ATTRIBUTE_OUTPUT) Util.println("ATTR OUTPUT: "+msg); }
	
	private void TRACE_INPUT(String msg)
	{ if(Option.TRACE_ATTRIBUTE_INPUT) Util.println("ATTR INPUT: "+msg); }
	
	public static void write(ProgramModule program) throws IOException
	{ 
//	  String attributeFileName;
//	  if(program.module.blockKind==BlockDeclaration.Kind.Class)
//		     attributeFileName=Global.tempClassFileDir+Global.packetName+"/CLASS.AF";
//	  else if(program.module.blockKind==BlockDeclaration.Kind.Procedure)
//		     attributeFileName=Global.tempClassFileDir+Global.packetName+"/PROCEDURE.AF";
//	  else return;
	
	  String relativeAttributeFileName=program.getRelativeAttributeFileName();
      if(relativeAttributeFileName==null) return;
      String attributeFileName=Global.tempClassFileDir+relativeAttributeFileName;
	  if (Option.verbose) Util.TRACE("*** BEGIN Generate SimulaAttributeFile: "+attributeFileName);
	  AttributeFile attributeFile=new AttributeFile(attributeFileName);
	  attributeFile.write((BlockDeclaration)program.module);
	  if(Option.TRACE_ATTRIBUTE_OUTPUT) attributeFile.listAttributeFile(attributeFileName);
	  if (Option.verbose) Util.TRACE("*** ENDOF Generate SimulaAttributeFile: "+attributeFileName);
	}
	
	private void write(BlockDeclaration module) throws IOException
	{ File attributeDir=new File(Global.tempClassFileDir+Global.packetName);
	  //Util.BREAK("AttributeFile.write: attributeDir="+attributeDir);
	  //Util.BREAK("AttributeFile.write: attributeDir'canWrite="+attributeDir.canWrite());
	  attributeDir.mkdirs();
	  File attributeFile=new File(attributeFileName);
	  //Util.BREAK("AttributeFile.write: attributeFile="+attributeFile);
	  //Util.BREAK("AttributeFile.write: attributeFile'canWrite="+attributeFile.canWrite());
	  attributeFile.createNewFile();
	  //Util.BREAK("AttributeFile.write: attributeFile'canWrite="+attributeFile.canWrite());
	  FileOutputStream fileOutputStream=new FileOutputStream(attributeFile);
	  oupt=new ObjectOutputStream(fileOutputStream);
	  writeVersion();	
	  writeDependencies();
	  if (Option.verbose) Util.TRACE("***       Write External "+module.blockKind+' '+module.identifier+'['+module.externalIdent+']');
	  doWriteAttributeInfo(module); 
	  oupt.flush(); oupt.close(); oupt=null;
	}

	private void writeDependencies() throws IOException {
		//Util.BREAK("AttributeFile.write: BEGIN WRITING DEPENDENCIES");
		for(Declaration dcl:StandardClass.ENVIRONMENT.declarationList) {
			//Util.BREAK("AttributeFile.write: DCL: "+dcl,", QUAL="+dcl.getClass().getSimpleName());
			if(dcl instanceof BlockDeclaration) {
				BlockDeclaration ext=(BlockDeclaration)dcl;
				if(ext.isPreCompiled) {
					//Util.BREAK("AttributeFile.write: BLK="+ext.identifier+", isPreCompiled="+ext.isPreCompiled);   
					if (Option.verbose) Util.TRACE("***       Write External "+ext.blockKind+' '+ext.identifier+'['+ext.externalIdent+']');
					doWriteAttributeInfo(ext);
				}
			}
		}
		//Util.BREAK("AttributeFile.write: END WRITING DEPENDENCIES");
	}
	
	private BlockDeclaration listAttributeFile(String attributeFileName) throws IOException
	{ if (Option.verbose) Util.TRACE("*** BEGIN Read SimulaAttributeFile: "+attributeFileName);
	  FileInputStream fileInputStream=new FileInputStream(attributeFileName);
	  inpt=new ObjectInputStream(fileInputStream);
	  if(!checkVersion()) Util.error("Malformed SimulaAttributeFile: "+attributeFileName);
	  BlockKind blockKind=readBlockKind();
	  BlockDeclaration blockDeclaration=readBlockDeclaration(blockKind);
	  inpt.close();
	  if (Option.verbose)
	  { //Util.BREAK("*** ENDOF Read SimulaAttributeFile: "+attributeFileName);
		if(Option.TRACE_ATTRIBUTE_INPUT) {
			Util.TRACE("*** ENDOF Read SimulaAttributeFile: "+attributeFileName);
			blockDeclaration.print("");
		}
	  }
	  return(blockDeclaration);
	}
	
	  
	public BlockDeclaration readBlockDeclaration(BlockKind blockKind) throws IOException
	{ if(blockKind==BlockKind.Class)
		   return(readClassDeclaration());
	  else return(readProcedureDeclaration());
	}

	public static void readAttributeFile(InputStream inputStream,String attributeFileName,Vector<Declaration> declarationList) throws IOException
	{ AttributeFile attributeFile=new AttributeFile(attributeFileName);
	  if (Option.verbose) Util.TRACE("*** BEGIN Read SimulaAttributeFile: "+attributeFileName);
	  attributeFile.inpt=new ObjectInputStream(inputStream);
	  if(!attributeFile.checkVersion()) Util.error("Malformed SimulaAttributeFile: "+attributeFileName);
	  
	  LOOP:while(true) {
		  BlockKind blockKind=attributeFile.readBlockKind();
		  BlockDeclaration module=null;//attributeFile.readBlockDeclaration(blockKind);
		  if(blockKind==BlockKind.Procedure)  module=attributeFile.readProcedureDeclaration();
		  else if(blockKind==BlockKind.Class) module=attributeFile.readClassDeclaration();
		  else break LOOP;
		  module.isPreCompiled=true;
		  declarationList.add(module);
		  if (Option.verbose) Util.TRACE("***       Read External "+module.blockKind+' '+module.identifier+'['+module.externalIdent+']');
		  if(Option.TRACE_ATTRIBUTE_INPUT) module.print("");
	  }
	  
	  attributeFile.inpt.close();
	  if (Option.verbose) Util.TRACE("*** ENDOF Read SimulaAttributeFile: "+attributeFileName);
	}
	
	  
	private void doWriteAttributeInfo(Declaration dcl) throws IOException
	{ //Util.BREAK("BlockDeclaration.doWriteAttributeInfo: dcl="+dcl);
	  if(dcl instanceof ClassDeclaration) doWriteClassDeclaration((ClassDeclaration)dcl);
	  else if(dcl instanceof ProcedureDeclaration) doWriteProcedureDeclaration((ProcedureDeclaration)dcl);
	  else if(dcl instanceof TypeDeclaration) writeTypeDeclaration((TypeDeclaration)dcl);
	  else if(dcl instanceof ArrayDeclaration) writeArrayDeclaration((ArrayDeclaration)dcl);
	}
	  
	private void writeVersion() throws IOException
	{ oupt.writeUTF("SimulaAttributeFile"); oupt.writeUTF(MAGIC); oupt.writeUTF(VERSION);
	}
	
	public boolean checkVersion() throws IOException
	{ if(!inpt.readUTF().equals("SimulaAttributeFile")) return(false);
	  if(!inpt.readUTF().equals(MAGIC)) return(false);
	  if(!inpt.readUTF().equals(VERSION)) return(false);
	  return(true);
	}
	  
	private void writeTypeDeclaration(TypeDeclaration dcl) throws IOException
	{ TRACE_OUTPUT("Variable: "+dcl.type+' '+dcl.identifier+", const="+dcl.constantElement);
	  oupt.writeUTF("Variable"); oupt.writeUTF(dcl.identifier); writeType(dcl.type);
	  writeConstant(dcl.constantElement);
	}
	
	public TypeDeclaration readTypeDeclaration() throws IOException
	{ String identifier=inpt.readUTF();
	  Type type=readType();
	  Constant constantElement=readConstant();
	  TRACE_INPUT("Variable: "+type+' '+identifier+", const="+constantElement);
	  return(new TypeDeclaration(type,identifier,constantElement));
	}
	
	private void writeConstant(Constant cnst) throws IOException {
		if(cnst!=null) {
			oupt.writeUTF("Constant"); writeType(cnst.type);
			Util.BREAK("AttributeFile.writeConstant: "+cnst+", value="+cnst.value);
			oupt.writeUTF(cnst.value.toString());
		} else oupt.writeUTF("NoConstant");
	}
	
	private Constant readConstant() throws IOException {
		String kind=inpt.readUTF();
		if(kind.equalsIgnoreCase("NoConstant")) return(null);
		Type type=readType();
		String val=inpt.readUTF();
		//Util.BREAK("AttributeFile.readConstant: type="+type+", value="+val);
		Object value;
		if(type==Type.Boolean)        value=Boolean.parseBoolean(val);
		else if(type==Type.Character) value=val.charAt(0);
		else if(type==Type.Text)      value=val;
		else if(type==Type.Integer)	  value=Integer.parseInt(val);
		else if(type==Type.Real)	  value=Float.parseFloat(val);
		else if(type==Type.LongReal)  value=Double.parseDouble(val);
		else { Util.FATAL_ERROR("Impossible"); return(null); }
		
		return(new Constant(type,value)); // TEMP !!!!!
	}
	  
	private void writeArrayDeclaration(ArrayDeclaration dcl) throws IOException
	{ TRACE_OUTPUT("Array: "+dcl.type+' '+dcl.identifier+", nDim="+dcl.nDim);
	  oupt.writeUTF("Array"); oupt.writeUTF(dcl.identifier); writeType(dcl.type);
	  oupt.writeInt(dcl.nDim);
	}
	
	public ArrayDeclaration readArrayDeclaration() throws IOException
	{ String identifier=inpt.readUTF();
	  Type type=readType(); int nDim=inpt.readInt();
	  TRACE_INPUT("Array: "+type+' '+identifier+", nDim="+nDim);
	  return(new ArrayDeclaration(identifier,type,nDim));
	}
	  
	private void doWriteClassDeclaration(ClassDeclaration blk) throws IOException
	{ //Util.BREAK("BlockDeclaration.doWriteAttributeInfo: blk="+blk);
	  TRACE_OUTPUT("BEGIN Write Block: "+blk.identifier);
	  oupt.writeUTF(""+blk.blockKind);
	  writeString("Identifier",blk.identifier);
	  writeString("ExtIdentifier",blk.externalIdent);
	  oupt.writeUTF("BlockType"); writeType(blk.type);
	  writeInt("BlockLevel",blk.blockLevel);
	  for(Parameter par:blk.parameterList) writeParameter(par);
	  writeString("Prefix",blk.prefix);
	  writeBoolean("HasLocalClasses",blk.hasLocalClasses);
	  writeBoolean("DetachUsed",blk.detachUsed);
	  for(VirtualSpecification vrt:blk.virtualSpecList) writeVirtualSpec(vrt);
//	  for(VirtualMatch mth:blk.virtualMatchList) writeVirtualMatch(mth);
	  for(HiddenSpecification hdn:blk.hiddenList) writeString("Hidden",hdn.identifier);
	  for(ProtectedSpecification prt:blk.protectedList) writeString("Protected",prt.identifier);
	  for(LabelDeclaration lab:blk.labelList) writeLabel(lab);
	  for(Declaration dcl:blk.declarationList) doWriteAttributeInfo(dcl);
	  for(VirtualMatch mth:blk.virtualMatchList) writeVirtualMatch(mth);
	  oupt.writeUTF("BLOCKEND");
	  TRACE_OUTPUT("END Write Block: "+blk.identifier);
	}
	  
	private void doWriteProcedureDeclaration(ProcedureDeclaration blk) throws IOException
	{ //Util.BREAK("BlockDeclaration.doWriteAttributeInfo: blk="+blk);
	  TRACE_OUTPUT("BEGIN Write Block: "+blk.identifier);
	  oupt.writeUTF(""+blk.blockKind);
	  writeString("Identifier",blk.identifier);
	  writeString("ExtIdentifier",blk.externalIdent);
	  oupt.writeUTF("BlockType"); writeType(blk.type);
	  writeInt("BlockLevel",blk.blockLevel);
	  for(Parameter par:blk.parameterList) writeParameter(par);
	  oupt.writeUTF("BLOCKEND");
	  TRACE_OUTPUT("END Write Block: "+blk.identifier);
	}
	  
	public ClassDeclaration readClassDeclaration() throws IOException
	{ TRACE_INPUT("BEGIN Read Block:");
	  ClassDeclaration decl=new ClassDeclaration(null);
	  decl.blockKind=BlockKind.Class;
	  READING:while(true)
	  { String label=readString();
	    //Util.BREAK("BlockDeclaration.doReadAttributeInfo: label="+label);
	    if(label.equalsIgnoreCase("BlockDeclaration.Kind")) decl.blockKind=readBlockKind();
		else if(label.equalsIgnoreCase("Identifier")) decl.identifier=readString();
		else if(label.equalsIgnoreCase("ExtIdentifier")) decl.externalIdent=readString();
		else if(label.equalsIgnoreCase("BlockType")) decl.type=readType();
		else if(label.equalsIgnoreCase("BlockLevel")) decl.blockLevel=readInt();
		else if(label.equalsIgnoreCase("Parameter")) decl.parameterList.add(readParameter());
	    else if(label.equalsIgnoreCase("Prefix")) decl.prefix=readString();
	    else if(label.equalsIgnoreCase("HasLocalClasses")) decl.hasLocalClasses=readBoolean();
	    else if(label.equalsIgnoreCase("DetachUsed")) decl.detachUsed=readBoolean();
	    else if(label.equalsIgnoreCase("VirtualSpec")) decl.virtualSpecList.add(readVirtualSpec(decl));
	    else if(label.equalsIgnoreCase("VirtualMatch")) decl.virtualMatchList.add(readVirtualMatch(decl));
	    else if(label.equalsIgnoreCase("Hidden")) decl.hiddenList.add(new HiddenSpecification(decl,readString()));
	    else if(label.equalsIgnoreCase("Protected")) decl.protectedList.add(new ProtectedSpecification(decl,readString()));
	    else if(label.equalsIgnoreCase("Label")) decl.labelList.add(readLabel());
	    else if(label.equalsIgnoreCase("Variable")) decl.declarationList.add(readTypeDeclaration());
	    else if(label.equalsIgnoreCase("Array")) decl.declarationList.add(readArrayDeclaration());
	    else if(label.equalsIgnoreCase("Class")) decl.declarationList.add(readClassDeclaration());
	    else if(label.equalsIgnoreCase("Procedure")) decl.declarationList.add(readProcedureDeclaration());
	    else if(label.equalsIgnoreCase("BLOCKEND")) break READING;
	    else Util.error("Malformed Attribute File (at "+label+")");
	  }
	  TRACE_INPUT("Block: "+decl);
	  //decl.print("");
	  Global.currentScope=decl.declaredIn;
	  return(decl);
	}
	  
	public ProcedureDeclaration readProcedureDeclaration() throws IOException
	{ TRACE_INPUT("BEGIN Read Block:");
	ProcedureDeclaration decl=new ProcedureDeclaration(null,BlockKind.Procedure);
	  decl.blockKind=BlockKind.Procedure;
	  READING:while(true)
	  { String label=readString();
	    //Util.BREAK("BlockDeclaration.doReadAttributeInfo: label="+label);
	    if(label.equalsIgnoreCase("BlockDeclaration.Kind")) decl.blockKind=readBlockKind();
		else if(label.equalsIgnoreCase("Identifier")) decl.identifier=readString();
		else if(label.equalsIgnoreCase("ExtIdentifier")) decl.externalIdent=readString();
		else if(label.equalsIgnoreCase("BlockType")) decl.type=readType();
		else if(label.equalsIgnoreCase("BlockLevel")) decl.blockLevel=readInt();
		else if(label.equalsIgnoreCase("Parameter")) decl.parameterList.add(readParameter());
//	    else if(label.equalsIgnoreCase("Prefix")) decl.prefix=readString();
	    else if(label.equalsIgnoreCase("HasLocalClasses")) decl.hasLocalClasses=readBoolean();
//	    else if(label.equalsIgnoreCase("DetachUsed")) decl.detachUsed=readBoolean();
//	    else if(label.equalsIgnoreCase("Virtual")) decl.virtualList.add(readVirtual());
//	    else if(label.equalsIgnoreCase("Hidden")) decl.hiddenList.add(readString());
//	    else if(label.equalsIgnoreCase("Protected")) decl.protectedList.add(readString());
	    else if(label.equalsIgnoreCase("Label")) decl.labelList.add(readLabel());
	    else if(label.equalsIgnoreCase("Variable")) decl.declarationList.add(readTypeDeclaration());
	    else if(label.equalsIgnoreCase("Array")) decl.declarationList.add(readArrayDeclaration());
	    else if(label.equalsIgnoreCase("Class")) decl.declarationList.add(readClassDeclaration());
	    else if(label.equalsIgnoreCase("Procedure")) decl.declarationList.add(readProcedureDeclaration());
	    else if(label.equalsIgnoreCase("BLOCKEND")) break READING;
	    else Util.error("Malformed Attribute File (at "+label+")");
	  }
	  TRACE_INPUT("Block: "+decl);
	  //decl.print("");
	  Global.currentScope=decl.declaredIn;
	  return(decl);
	}
	
	private void writeParameter(Parameter par) throws IOException
	{ TRACE_OUTPUT("Parameter: "+par.type+' '+par.identifier+' '+par.kind+' '+par.mode);
	  oupt.writeUTF("Parameter"); oupt.writeUTF(par.identifier); oupt.writeUTF(par.externalIdent);
	  writeType(par.type); writeParameterKind(par.kind); writeParameterMode(par.mode);
	}
	
	public Parameter readParameter() throws IOException
	{ String identifier=inpt.readUTF();
	  String externalIdent=inpt.readUTF();
	  Type type=readType();
	  Parameter.Kind kind=readParameterKind();
	  Parameter.Mode mode=readParameterMode();
	  Parameter par=new Parameter(identifier,type,kind);
	  par.externalIdent=externalIdent; par.mode=mode;
	  TRACE_INPUT("Parameter: "+type+' '+identifier+' '+kind+' '+mode);
	  return(par);
	}
	
	private void writeVirtualSpec(VirtualSpecification virt) throws IOException
	{ TRACE_OUTPUT("VirtualSpec: "+virt.type+' '+virt.identifier);
	  oupt.writeUTF("VirtualSpec");
//	  oupt.writeInt(virt.prefixLevel);
	  oupt.writeUTF(virt.identifier); writeType(virt.type);
	  writeVirtProcedureSpec(virt.procedureSpec);
	}
	
	public VirtualSpecification readVirtualSpec(ClassDeclaration specifiedIn) throws IOException
	{ //int prefixLevel=inpt.readInt();
	  String identifier=inpt.readUTF();
	  //Util.BREAK("AttributeInputStream.readVirtual: identifier="+identifier);
	  Type type=readType();
	  //Util.BREAK("AttributeInputStream.readVirtual: type="+type);
	  ProcedureSpecification procedureSpec=readVirtProcedureSpec();
//	  return(new VirtualSpecification(prefixLevel,identifier,type,procedureSpec));
	  return(new VirtualSpecification(specifiedIn,identifier,type,procedureSpec));
	}
	
	private void writeVirtualMatch(VirtualMatch match) throws IOException
	{ TRACE_OUTPUT("VirtualMatch: "+match.identifier);
	  oupt.writeUTF("VirtualMatch");
	  oupt.writeUTF(match.identifier);
	}
	
	public VirtualMatch readVirtualMatch(ClassDeclaration decl) throws IOException
	{ //int prefixLevel=inpt.readInt();
	  String identifier=inpt.readUTF();
	  //Util.BREAK("AttributeInputStream.readVirtualMatch: Search="+decl);
	  //Util.BREAK("AttributeInputStream.readVirtualMatch: identifier="+identifier);
	  ProcedureDeclaration proc=decl.findLocalProcedure(identifier);
	  //Util.BREAK("AttributeInputStream.readVirtualMatch: proc="+proc);
	  if(proc!=null) {
		  VirtualSpecification virtualSpec=proc.getVirtualSpecification();
		  //Util.BREAK("AttributeInputStream.readVirtualMatch: virtualSpec="+virtualSpec);
	  	  if(virtualSpec!=null) return(new VirtualMatch(virtualSpec,proc));
	  }
  	  Util.error("Malformed Attribute File (at VirtualMatch "+identifier+")");
  	  return(null); // Error Recovery
	}
	
	private void writeVirtProcedureSpec(ProcedureSpecification procedureSpec) throws IOException
	{ if(procedureSpec==null) { oupt.writeUTF("NOSPEC"); return; }
	  TRACE_OUTPUT("ProcedureSpecification: "+procedureSpec.type+' '+procedureSpec.identifier);
	  oupt.writeUTF("ProcedureSpec"); oupt.writeUTF(procedureSpec.identifier); writeType(procedureSpec.type);
	  for(Parameter par:procedureSpec.parameterList) writeParameter(par);
	  oupt.writeUTF("PROCEND");
	}
	
	public ProcedureSpecification readVirtProcedureSpec() throws IOException
	{ String label=readString(); if(label.equalsIgnoreCase("NOSPEC")) return(null);
      if(!label.equalsIgnoreCase("ProcedureSpec")) Util.error("Malformed Attribute File (at "+label+")");
	  String identifier=inpt.readUTF();
	  //Util.BREAK("AttributeInputStream.readVirtual: identifier="+identifier);
	  Type type=readType();
	  //Util.BREAK("AttributeInputStream.readVirtual: type="+type);
	  Vector<Parameter> parameterList=new Vector<Parameter>();
	  READING:while(true)
	  { label=readString();
	    //Util.BREAK("BlockDeclaration.doReadAttributeInfo: label="+label);
	    if(label.equalsIgnoreCase("Parameter"))	parameterList.add(readParameter());
	    else if(label.equalsIgnoreCase("PROCEND")) break READING;
	    else Util.error("Malformed Attribute File (at "+label+")");
	  }
	  return(new ProcedureSpecification(identifier,type,parameterList));
	}
	
	private void writeLabel(LabelDeclaration lab) throws IOException
	{ TRACE_OUTPUT("Label: "+lab.index);
	  oupt.writeUTF("Label"); oupt.writeUTF(lab.identifier); oupt.writeInt(lab.index);
	}
	
	public LabelDeclaration readLabel() throws IOException
	{ String identifier=inpt.readUTF();
	  //Util.BREAK("AttributeInputStream.readVirtual: identifier="+identifier);
	  int index=readInt();
	  //Util.BREAK("AttributeInputStream.readVirtual: index="+index);
	  LabelDeclaration labelDeclaration=new LabelDeclaration(identifier);
	  labelDeclaration.index=index;
	  return(labelDeclaration);
	}

	private void writeType(Type type) throws IOException
	{ TRACE_OUTPUT("Type="+type);
	  if(type==Type.Text) oupt.writeUTF("TEXT");
	  else if(type==Type.LongReal) oupt.writeUTF("LongReal");
	  else if(type==null) oupt.writeUTF("NULLTYPE");
	  else if(type.isReferenceType()) oupt.writeUTF(type.getRefIdent());
	  else oupt.writeUTF(""+type);
	}
	
	private Type readType() throws IOException
	{ String tp=inpt.readUTF();
	  if(tp.equalsIgnoreCase("Integer")) return(Type.Integer);
	  if(tp.equalsIgnoreCase("Real")) return(Type.Real);
	  if(tp.equalsIgnoreCase("LongReal")) return(Type.LongReal);
	  if(tp.equalsIgnoreCase("Boolean")) return(Type.Boolean);
	  if(tp.equalsIgnoreCase("Character")) return(Type.Character);
	  if(tp.equalsIgnoreCase("Text")) return(Type.Text);
	  if(tp.equalsIgnoreCase("Procedure")) return(Type.Procedure);
	  if(tp.equalsIgnoreCase("Label")) return(Type.Label);
	  if(tp.equalsIgnoreCase("NULLTYPE")) return(null);
	  return(new Type(tp));
	}

	private void writeParameterKind(Parameter.Kind kind) throws IOException
	{ TRACE_OUTPUT("Kind="+kind);
	  oupt.writeUTF(""+kind);
	}
	
	private Parameter.Kind readParameterKind() throws IOException
	{ String kind=inpt.readUTF();
	  //Util.BREAK("AttributeInputStream.readParameterKind: kind="+kind);
	  if(kind.equalsIgnoreCase("Simple")) return(Parameter.Kind.Simple);
	  if(kind.equalsIgnoreCase("Array")) return(Parameter.Kind.Array);
	  if(kind.equalsIgnoreCase("Procedure")) return(Parameter.Kind.Procedure);
	  if(kind.equalsIgnoreCase("Label")) return(Parameter.Kind.Label);
	  return(null);
	}

	private void writeParameterMode(Parameter.Mode mode) throws IOException
	{ TRACE_OUTPUT("Mode="+mode);
	  oupt.writeUTF(""+mode);
	}
	
	private Parameter.Mode readParameterMode() throws IOException
	{ String tp=inpt.readUTF();
	  //Util.BREAK("AttributeInputStream.readParameterMode: tp="+tp);
	  if(tp.equalsIgnoreCase("Value")) return(Parameter.Mode.value);
	  if(tp.equalsIgnoreCase("Name")) return(Parameter.Mode.name);
	  return(null);
	}
	
	public BlockKind readBlockKind() //throws IOException
	{ try { String kind=inpt.readUTF();
	        //Util.BREAK("AttributeInputStream.readBlockKind: kind="+kind);
	        if(kind.equalsIgnoreCase("Procedure")) return(BlockKind.Procedure);
	        return(BlockKind.Class);
	  } catch(IOException e) {
	        //Util.BREAK("AttributeInputStream.readBlockKind: END-OF-AF");
		    return(null);
	  }
	}
	
	private void writeString(String label,String val) throws IOException
	{ TRACE_OUTPUT("String: "+label+": "+val);
	  oupt.writeUTF(label); oupt.writeUTF(val);
	}

	private String readString() throws IOException
	{ return(inpt.readUTF());	}
	
	private void writeInt(String label,int val) throws IOException
	{ TRACE_OUTPUT("Int: "+label+": "+val);
	  oupt.writeUTF(label); oupt.writeInt(val);
	}
	
	public int readInt() throws IOException
	{ int result=inpt.readInt();
	  //Util.BREAK("AttributeInputStream.readInt: result="+result);
	  return(result);
	}
	
	private void writeBoolean(String label,boolean val) throws IOException
	{ TRACE_OUTPUT("Boolean: "+label+": "+val);
	  oupt.writeUTF(label); oupt.writeBoolean(val);
	}
	
	public boolean readBoolean() throws IOException
	{ return(inpt.readBoolean()); }


}
