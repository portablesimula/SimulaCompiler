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

import simula.compiler.declaration.BlockDeclaration;
import simula.compiler.declaration.BlockKind;
import simula.compiler.declaration.ClassDeclaration;
import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.LabelDeclaration;
import simula.compiler.declaration.Parameter;
import simula.compiler.declaration.ProcedureDeclaration;
import simula.compiler.declaration.ProcedureSpecification;
import simula.compiler.declaration.TypeDeclaration;
import simula.compiler.declaration.VirtualSpecification;
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
	{ if(Option.TRACE_ATTRIBUTE_OUTPUT) System.out.println("ATTR OUTPUT: "+msg); }
	
	private void TRACE_INPUT(String msg)
	{ if(Option.TRACE_ATTRIBUTE_INPUT) System.out.println("ATTR INPUT: "+msg); }
	
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
	  if(Option.TRACE_ATTRIBUTE_OUTPUT) attributeFile.readAttributeFile(attributeFileName);
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
	  doWriteAttributeInfo(module); 
	  oupt.flush(); oupt.close(); oupt=null;
	}

	private BlockDeclaration readAttributeFile(String attributeFileName) throws IOException
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
			blockDeclaration.print("","");
		}
	  }
	  return(blockDeclaration);
	}
	

	public static BlockDeclaration readAttributeFile(InputStream inputStream,String attributeFileName) throws IOException
	{ AttributeFile attributeFile=new AttributeFile(attributeFileName);
	  attributeFile.inpt=new ObjectInputStream(inputStream);
	  if(!attributeFile.checkVersion()) Util.error("Malformed SimulaAttributeFile: "+attributeFileName);
	  BlockKind blockKind=attributeFile.readBlockKind();
	  BlockDeclaration blockDeclaration=attributeFile.readBlockDeclaration(blockKind);
	  attributeFile.inpt.close();
	  if (Option.verbose)
	  { Util.TRACE("*** ENDOF Read SimulaAttributeFile: "+attributeFileName);
	    if(Option.TRACE_ATTRIBUTE_INPUT) blockDeclaration.print("","");
	  }
	  return(blockDeclaration);
	}
	
	  
	private void doWriteAttributeInfo(Declaration dcl) throws IOException
	{ //Util.BREAK("BlockDeclaration.doWriteAttributeInfo: dcl="+dcl);
	  if(dcl instanceof ClassDeclaration) doWriteClassDeclaration((ClassDeclaration)dcl);
	  if(dcl instanceof ProcedureDeclaration) doWriteProcedureDeclaration((ProcedureDeclaration)dcl);
	  else if(dcl instanceof TypeDeclaration) writeTypeDeclaration((TypeDeclaration)dcl);
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
	{ TRACE_OUTPUT("Variable: "+dcl.type+' '+dcl.identifier);
	  oupt.writeUTF("Variable"); oupt.writeUTF(dcl.identifier); writeType(dcl.type);
	}
	
	public TypeDeclaration readTypeDeclaration() throws IOException
	{ String identifier=inpt.readUTF();
	  Type type=readType();
	  TRACE_INPUT("Variable: "+type+' '+identifier);
	  return(new TypeDeclaration(type,identifier));
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
	  for(VirtualSpecification vrt:blk.virtualList) writeVirtual(vrt);
	  for(String hdn:blk.hiddenList) writeString("Hidden",hdn);
	  for(String prt:blk.protectedList) writeString("Protected",prt);
	  for(LabelDeclaration lab:blk.labelList) writeLabel(lab);
	  for(Declaration dcl:blk.declarationList) doWriteAttributeInfo(dcl);
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
	  
	public BlockDeclaration readBlockDeclaration(BlockKind blockKind) throws IOException
	{ if(blockKind==BlockKind.Class)
		   return(readClassDeclaration());
	  else return(readProcedureDeclaration());
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
	    else if(label.equalsIgnoreCase("Virtual")) decl.virtualList.add(readVirtual());
	    else if(label.equalsIgnoreCase("Hidden")) decl.hiddenList.add(readString());
	    else if(label.equalsIgnoreCase("Protected")) decl.protectedList.add(readString());
	    else if(label.equalsIgnoreCase("Label")) decl.labelList.add(readLabel());
	    else if(label.equalsIgnoreCase("Variable")) decl.declarationList.add(readTypeDeclaration());
	    else if(label.equalsIgnoreCase("Class")) decl.declarationList.add(readClassDeclaration());
	    else if(label.equalsIgnoreCase("Procedure")) decl.declarationList.add(readProcedureDeclaration());
	    else if(label.equalsIgnoreCase("BLOCKEND")) break READING;
	    else Util.error("Malformed Attribute File (at "+label+")");
	  }
	  TRACE_INPUT("Block: "+decl);
	  //decl.print("","");
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
	    else if(label.equalsIgnoreCase("Class")) decl.declarationList.add(readClassDeclaration());
	    else if(label.equalsIgnoreCase("Procedure")) decl.declarationList.add(readProcedureDeclaration());
	    else if(label.equalsIgnoreCase("BLOCKEND")) break READING;
	    else Util.error("Malformed Attribute File (at "+label+")");
	  }
	  TRACE_INPUT("Block: "+decl);
	  //decl.print("","");
	  Global.currentScope=decl.declaredIn;
	  return(decl);
	}
	
	private void writeParameter(Parameter par) throws IOException
	{ TRACE_OUTPUT("Parameter: "+par.type+' '+par.identifier+' '+par.kind+' '+par.mode);
	  oupt.writeUTF("Parameter"); oupt.writeUTF(par.identifier);
	  writeType(par.type); writeParameterKind(par.kind); writeParameterMode(par.mode);
	}
	
	public Parameter readParameter() throws IOException
	{ String identifier=inpt.readUTF();
	  Type type=readType();
	  Parameter.Kind kind=readParameterKind();
	  Parameter.Mode mode=readParameterMode();
	  Parameter par=new Parameter(identifier,type,kind);
	  par.mode=mode;
	  TRACE_INPUT("Parameter: "+type+' '+identifier+' '+kind+' '+mode);
	  return(par);
	}
	
	private void writeVirtual(VirtualSpecification virt) throws IOException
	{ TRACE_OUTPUT("Virtual: "+virt.type+' '+virt.identifier);
	  oupt.writeUTF("Virtual"); oupt.writeUTF(virt.identifier);
	  writeType(virt.type);
	  writeVirtProcedureSpec(virt.procedureSpec);
	}
	
	public VirtualSpecification readVirtual() throws IOException
	{ String identifier=inpt.readUTF();
	  //Util.BREAK("AttributeInputStream.readVirtual: identifier="+identifier);
	  Type type=readType();
	  //Util.BREAK("AttributeInputStream.readVirtual: type="+type);
	  ProcedureSpecification procedureSpec=readVirtProcedureSpec();
	  return(new VirtualSpecification(identifier,type,procedureSpec));
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
	
	public BlockKind readBlockKind() throws IOException
	{ String kind=inpt.readUTF();
	  //Util.BREAK("AttributeInputStream.readBlockKind: kind="+kind);
	  if(kind.equalsIgnoreCase("Procedure")) return(BlockKind.Procedure);
	  return(BlockKind.Class);
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
