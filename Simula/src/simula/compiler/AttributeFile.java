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
import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.LabelDeclaration;
import simula.compiler.declaration.Parameter;
import simula.compiler.declaration.ProcedureSpecification;
import simula.compiler.declaration.TypeDeclaration;
import simula.compiler.declaration.Virtual;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

public class AttributeFile {
	private final String MAGIC="428-348"; // Platon lived ca. 428 through 348 BC.
	private final String VERSION="1.0";

	String attributeFileName;
	ObjectOutputStream oupt;
	ObjectInputStream inpt;
	boolean verbose=true; //false;//true;
	
	public AttributeFile(String attributeFileName) 
	{ this.attributeFileName=attributeFileName; }
	
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
	  if (Option.verbose) Util.BREAK("*** BEGIN Generate SimulaAttributeFile: "+attributeFileName);
	  AttributeFile attributeFile=new AttributeFile(attributeFileName);
	  attributeFile.write((BlockDeclaration)program.module);
	  if(Option.verbose) attributeFile.readAttributeFile(attributeFileName);
	  if (Option.verbose) Util.BREAK("*** ENDOF Generate SimulaAttributeFile: "+attributeFileName);
	}
	
	private void write(BlockDeclaration module) throws IOException
	{ File attributeDir=new File(Global.tempClassFileDir+Global.packetName);
	  Util.BREAK("AttributeFile.write: attributeDir="+attributeDir);
	  Util.BREAK("AttributeFile.write: attributeDir'canWrite="+attributeDir.canWrite());
	  attributeDir.mkdirs();
	  File attributeFile=new File(attributeFileName);
	  Util.BREAK("AttributeFile.write: attributeFile="+attributeFile);
	  Util.BREAK("AttributeFile.write: attributeFile'canWrite="+attributeFile.canWrite());
	  attributeFile.createNewFile();
	  Util.BREAK("AttributeFile.write: attributeFile'canWrite="+attributeFile.canWrite());
//	  attributeFile.mkdirs();
//	  FileOutputStream fileOutputStream=new FileOutputStream(attributeFileName);
	  FileOutputStream fileOutputStream=new FileOutputStream(attributeFile);
	  oupt=new ObjectOutputStream(fileOutputStream);
	  writeVersion();	
	  doWriteAttributeInfo(module); 
	  oupt.flush(); oupt.close(); oupt=null;
	}

	private BlockDeclaration readAttributeFile(String attributeFileName) throws IOException
	{ if (Option.verbose) Util.BREAK("*** BEGIN Read SimulaAttributeFile: "+attributeFileName);
	  FileInputStream fileInputStream=new FileInputStream(attributeFileName);
	  inpt=new ObjectInputStream(fileInputStream);
	  if(!checkVersion()) Util.error("Malformed SimulaAttributeFile: "+attributeFileName);
	  BlockDeclaration.Kind blockKind=readBlockKind();
	  BlockDeclaration blockDeclaration=readBlockDeclaration(blockKind);
	  inpt.close();
	  if (Option.verbose)
	  { Util.BREAK("*** ENDOF Read SimulaAttributeFile: "+attributeFileName);
		blockDeclaration.print("","");
	  }
	  return(blockDeclaration);
	}
	

	public static BlockDeclaration readAttributeFile(InputStream inputStream,String attributeFileName) throws IOException
	{ AttributeFile attributeFile=new AttributeFile(attributeFileName);
	  attributeFile.inpt=new ObjectInputStream(inputStream);
	  if(!attributeFile.checkVersion()) Util.error("Malformed SimulaAttributeFile: "+attributeFileName);
	  BlockDeclaration.Kind blockKind=attributeFile.readBlockKind();
	  BlockDeclaration blockDeclaration=attributeFile.readBlockDeclaration(blockKind);
	  attributeFile.inpt.close();
	  if (Option.verbose)
	  { Util.BREAK("*** ENDOF Read SimulaAttributeFile: "+attributeFileName);
		blockDeclaration.print("","");
	  }
	  return(blockDeclaration);
	}
	
	  
	private void doWriteAttributeInfo(Declaration dcl) throws IOException
	{ //Util.BREAK("BlockDeclaration.doWriteAttributeInfo: dcl="+dcl);
	  if(dcl instanceof BlockDeclaration) doWriteBlockDeclaration((BlockDeclaration)dcl);
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
	{ if(verbose) System.out.println("ATTR OUTPUT: Variable: "+dcl.type+' '+dcl.identifier);
	  oupt.writeUTF("Variable"); oupt.writeUTF(dcl.identifier); writeType(dcl.type);
	}
	
	public TypeDeclaration readTypeDeclaration() throws IOException
	{ String identifier=inpt.readUTF();
	  Type type=readType();
	  if(verbose) System.out.println("ATTR INPUT: Variable: "+type+' '+identifier);
	  return(new TypeDeclaration(type,identifier));
	}
	  
	private void doWriteBlockDeclaration(BlockDeclaration blk) throws IOException
	{ //Util.BREAK("BlockDeclaration.doWriteAttributeInfo: blk="+blk);
	  if(verbose) System.out.println("ATTR OUTPUT: BEGIN Write Block: "+blk.identifier);
	  oupt.writeUTF(""+blk.blockKind);
	  writeString("Identifier",blk.identifier);
	  writeString("ExtIdentifier",blk.externalIdent);
	  oupt.writeUTF("BlockType"); writeType(blk.type);
	  writeInt("BlockLevel",blk.blockLevel);
	  for(Parameter par:blk.parameterList) writeParameter(par);
	    
	  if(blk.blockKind==BlockDeclaration.Kind.Class)
	  { writeString("Prefix",blk.prefix);
	    writeBoolean("HasLocalClasses",blk.hasLocalClasses);
	    writeBoolean("DetachUsed",blk.detachUsed);
	    for(Virtual vrt:blk.virtualList) writeVirtual(vrt);
	    for(String hdn:blk.hiddenList) writeString("Hidden",hdn);
	    for(String prt:blk.protectedList) writeString("Protected",prt);
	    for(LabelDeclaration lab:blk.labelList) writeLabel(lab);
	    for(Declaration dcl:blk.declarationList) doWriteAttributeInfo(dcl);
	  }
	  oupt.writeUTF("BLOCKEND");
	  if(verbose) System.out.println("ATTR OUTPUT: END Write Block: "+blk.identifier);
	}
	  
	public BlockDeclaration readBlockDeclaration(BlockDeclaration.Kind blockKind) throws IOException
	{ if(verbose) System.out.println("ATTR INPUT: BEGIN Read Block:");
	  BlockDeclaration decl=new BlockDeclaration(null);
	  decl.blockKind=blockKind;
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
	    else if(label.equalsIgnoreCase("Class")) decl.declarationList.add(readBlockDeclaration(BlockDeclaration.Kind.Class));
	    else if(label.equalsIgnoreCase("Procedure")) decl.declarationList.add(readBlockDeclaration(BlockDeclaration.Kind.Procedure));
	    else if(label.equalsIgnoreCase("BLOCKEND")) break READING;
	    else Util.error("Malformed Attribute File (at "+label+")");
	  }
	  if(verbose) System.out.println("ATTR INPUT: Block: "+decl);
	  //decl.print("","");
	  Global.currentScope=decl.declaredIn;
	  return(decl);
	}
	
	private void writeParameter(Parameter par) throws IOException
	{ if(verbose) System.out.println("ATTR: Parameter: "+par.type+' '+par.identifier+' '+par.kind+' '+par.mode);
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
	  if(verbose) System.out.println("ATTR INPUT: Parameter: "+type+' '+identifier+' '+kind+' '+mode);
	  return(par);
	}
	
	private void writeVirtual(Virtual virt) throws IOException
	{ if(verbose) System.out.println("ATTR: Virtual: "+virt.type+' '+virt.identifier+' '+virt.kind);
	  oupt.writeUTF("Virtual"); oupt.writeUTF(virt.identifier);
	  writeType(virt.type); writeVirtualKind(virt.kind); 
	  writeVirtProcedureSpec(virt.procedureSpec);
	}
	
	public Virtual readVirtual() throws IOException
	{ String identifier=inpt.readUTF();
	  //Util.BREAK("AttributeInputStream.readVirtual: identifier="+identifier);
	  Type type=readType();
	  //Util.BREAK("AttributeInputStream.readVirtual: type="+type);
	  Virtual.Kind kind=readVirtualKind();
	  ProcedureSpecification procedureSpec=readVirtProcedureSpec();
	  return(new Virtual(identifier,type,kind,procedureSpec));
	}
	
	private void writeVirtProcedureSpec(ProcedureSpecification procedureSpec) throws IOException
	{ if(procedureSpec==null) { oupt.writeUTF("NOSPEC"); return; }
	  if(verbose) System.out.println("ATTR: ProcedureSpecification: "+procedureSpec.type+' '+procedureSpec.identifier);
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
	{ if(verbose) System.out.println("ATTR: Label: "+lab.index);
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
	{ if(verbose) System.out.println("ATTR: "+type);
	  if(type==Type.Text) oupt.writeUTF("TEXT");
	  else if(type==null) oupt.writeUTF("NULLTYPE");
	  else if(type.isReferenceType()) oupt.writeUTF(type.getRefIdent());
	  else oupt.writeUTF(""+type);
	}
	
	private Type readType() throws IOException
	{ String tp=inpt.readUTF();
	  if(tp.equalsIgnoreCase("Integer")) return(Type.Integer);
	  if(tp.equalsIgnoreCase("ShortInteger")) return(Type.ShortInteger);
	  if(tp.equalsIgnoreCase("Real")) return(Type.Real);
	  if(tp.equalsIgnoreCase("LongReal")) return(Type.LongReal);
	  if(tp.equalsIgnoreCase("Boolean")) return(Type.Boolean);
	  if(tp.equalsIgnoreCase("Character")) return(Type.Character);
	  if(tp.equalsIgnoreCase("Text")) return(Type.Text);
	  if(tp.equalsIgnoreCase("Procedure")) return(Type.Procedure);
	  if(tp.equalsIgnoreCase("Label")) return(Type.Label);
	  if(tp.equalsIgnoreCase("LabelQuantity")) return(Type.LabelQuantity);
	  if(tp.equalsIgnoreCase("NULLTYPE")) return(null);
	  return(new Type(tp));
	}

	private void writeParameterKind(Parameter.Kind kind) throws IOException
	{ if(verbose) System.out.println("ATTR: "+kind);
	  oupt.writeUTF(""+kind);
	}
	
	private Parameter.Kind readParameterKind() throws IOException
	{ String kind=inpt.readUTF();
	  //Util.BREAK("AttributeInputStream.readParameterKind: kind="+kind);
	  if(kind.equalsIgnoreCase("Simple")) return(Parameter.Kind.Simple);
	  if(kind.equalsIgnoreCase("Array")) return(Parameter.Kind.Array);
	  if(kind.equalsIgnoreCase("Procedure")) return(Parameter.Kind.Procedure);
	  if(kind.equalsIgnoreCase("Label")) return(Parameter.Kind.Label);
	  if(kind.equalsIgnoreCase("Switch")) return(Parameter.Kind.Switch);
	  return(null);
	}

	private void writeVirtualKind(Virtual.Kind kind) throws IOException
	{ if(verbose) System.out.println("ATTR: "+kind);
	  oupt.writeUTF(""+kind);
	}
	
	private Virtual.Kind readVirtualKind() throws IOException
	{ String tp=inpt.readUTF();
	  //Util.BREAK("AttributeInputStream.readParameterKind: tp="+tp);
	  if(tp.equalsIgnoreCase("Procedure")) return(Virtual.Kind.Procedure);
	  if(tp.equalsIgnoreCase("Label")) return(Virtual.Kind.Label);
	  if(tp.equalsIgnoreCase("Switch")) return(Virtual.Kind.Switch);
	  return(null);
	}

	private void writeParameterMode(Parameter.Mode mode) throws IOException
	{ if(verbose) System.out.println("ATTR: "+mode);
	  oupt.writeUTF(""+mode);
	}
	
	private Parameter.Mode readParameterMode() throws IOException
	{ String tp=inpt.readUTF();
	  //Util.BREAK("AttributeInputStream.readParameterMode: tp="+tp);
	  if(tp.equalsIgnoreCase("Value")) return(Parameter.Mode.value);
	  if(tp.equalsIgnoreCase("Name")) return(Parameter.Mode.name);
	  return(null);
	}
	
	public BlockDeclaration.Kind readBlockKind() throws IOException
	{ String kind=inpt.readUTF();
	  //Util.BREAK("AttributeInputStream.readBlockKind: kind="+kind);
	  if(kind.equalsIgnoreCase("Procedure")) return(BlockDeclaration.Kind.Procedure);
	  return(BlockDeclaration.Kind.Class);
	}
	
	private void writeString(String label,String val) throws IOException
	{ if(verbose) System.out.println("ATTR: "+label+": "+val);
	  oupt.writeUTF(label); oupt.writeUTF(val);
	}

	private String readString() throws IOException
	{ return(inpt.readUTF());	}
	
	private void writeInt(String label,int val) throws IOException
	{ if(verbose) System.out.println("ATTR: "+label+": "+val);
	  oupt.writeUTF(label); oupt.writeInt(val);
	}
	
	public int readInt() throws IOException
	{ int result=inpt.readInt();
	  //Util.BREAK("AttributeInputStream.readInt: result="+result);
	  return(result);
	}
	
	private void writeBoolean(String label,boolean val) throws IOException
	{ if(verbose) System.out.println("ATTR: "+label+": "+val);
	  oupt.writeUTF(label); oupt.writeBoolean(val);
	}
	
	public boolean readBoolean() throws IOException
	{ return(inpt.readBoolean()); }


}
