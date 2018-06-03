/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import simula.compiler.declaration.BlockDeclaration;
import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.LabelDeclaration;
import simula.compiler.declaration.Parameter;
import simula.compiler.declaration.TypeDeclaration;
import simula.compiler.declaration.Virtual;
import simula.compiler.utilities.BlockKind;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.ParameterKind;
import simula.compiler.utilities.ParameterMode;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

public class AttributeFile {
	private final String MAGIC="428-348"; // Platon lived ca. 428 through 348 BC.
	private final String VERSION="1.0";

	String attributeFileName;
	ObjectOutputStream oupt;
	ObjectInputStream inpt;
	boolean verbose=false;//true;
	
	public AttributeFile(String attributeFileName) 
	{ this.attributeFileName=attributeFileName; }
	
	public static void write(ProgramModule program) throws IOException
	{ String attributeFileName;
	  if(program.module.blockKind==BlockKind.Class)
		     attributeFileName=Global.tempClassFileDir+"CLASS.attr";
	  else if(program.module.blockKind==BlockKind.Procedure)
		     attributeFileName=Global.tempClassFileDir+"PROCEDURE.attr";
	  else return;
	  if (Option.verbose) Util.BREAK("*** BEGIN Generate SimulaAttributeFile: "+attributeFileName);
	  AttributeFile attributeFile=new AttributeFile(attributeFileName);
	  attributeFile.write((BlockDeclaration)program.module);
	  if(Option.verbose) attributeFile.readAttributeFile(attributeFileName);
	  if (Option.verbose) Util.BREAK("*** ENDOF Generate SimulaAttributeFile: "+attributeFileName);
	}
	
	private void write(BlockDeclaration module) throws IOException
	{ FileOutputStream fileOutputStream=new FileOutputStream(attributeFileName);
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
	  BlockKind blockKind=readBlockKind();
	  BlockDeclaration blockDeclaration=readBlockDeclaration(blockKind);
	  inpt.close();
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
	  writeInt("BlockLevel",blk.blockLevel);
	  for(Parameter par:blk.parameterList) writeParameter(par);
	    
	  if(blk.blockKind==BlockKind.Class)
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
	  
	public BlockDeclaration readBlockDeclaration(BlockKind blockKind) throws IOException
	{ if(verbose) System.out.println("ATTR INPUT: BEGIN Read Block:");
	  BlockDeclaration decl=new BlockDeclaration(null);
	  decl.blockKind=blockKind;
	  READING:while(true)
	  { String label=readString();
	    //Util.BREAK("BlockDeclaration.doReadAttributeInfo: label="+label);
	    if(label.equalsIgnoreCase("BlockKind")) decl.blockKind=readBlockKind();
		else if(label.equalsIgnoreCase("Identifier")) decl.identifier=readString();
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
	    else if(label.equalsIgnoreCase("Class")) decl.declarationList.add(readBlockDeclaration(BlockKind.Class));
	    else if(label.equalsIgnoreCase("Procedure")) decl.declarationList.add(readBlockDeclaration(BlockKind.Procedure));
	    else if(label.equalsIgnoreCase("BLOCKEND")) break READING;
	    else Util.error("Malformed Attribute File (at "+label+")");
	  }
	  if(verbose) System.out.println("ATTR INPUT: Block: "+decl);
	  //decl.print("","");
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
	  ParameterKind kind=readParameterKind();
	  ParameterMode mode=readParameterMode();
	  Parameter par=new Parameter(identifier,type,kind);
	  par.mode=mode;
	  if(verbose) System.out.println("ATTR INPUT: Parameter: "+type+' '+identifier+' '+kind+' '+mode);
	  return(par);
	}
	
	private void writeVirtual(Virtual virt) throws IOException
	{ if(verbose) System.out.println("ATTR: Virtual: "+virt.type+' '+virt.identifier+' '+virt.kind);
	  oupt.writeUTF("Virtual"); oupt.writeUTF(virt.identifier);
	  writeType(virt.type); oupt.writeUTF(""+virt.kind);
	}
	
	public Virtual readVirtual() throws IOException
	{ String identifier=inpt.readUTF();
	  //Util.BREAK("AttributeInputStream.readVirtual: identifier="+identifier);
	  Type type=readType();
	  //Util.BREAK("AttributeInputStream.readVirtual: type="+type);
	  ParameterKind kind=readParameterKind();
	  return(new Virtual(identifier,type,kind));
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
	  return(new Type(tp));
	}

	private void writeParameterKind(ParameterKind kind) throws IOException
	{ if(verbose) System.out.println("ATTR: "+kind);
	  oupt.writeUTF(""+kind);
	}
	
	private ParameterKind readParameterKind() throws IOException
	{ String tp=inpt.readUTF();
	  //Util.BREAK("AttributeInputStream.readParameterKind: tp="+tp);
	  if(tp.equalsIgnoreCase("Simple")) return(ParameterKind.Simple);
	  if(tp.equalsIgnoreCase("Procedure")) return(ParameterKind.Procedure);
	  if(tp.equalsIgnoreCase("Array")) return(ParameterKind.Array);
	  if(tp.equalsIgnoreCase("Label")) return(ParameterKind.Label);
	  if(tp.equalsIgnoreCase("Switch")) return(ParameterKind.Switch);
	  return(null);
	}

	private void writeParameterMode(ParameterMode mode) throws IOException
	{ if(verbose) System.out.println("ATTR: "+mode);
	  oupt.writeUTF(""+mode);
	}
	
	private ParameterMode readParameterMode() throws IOException
	{ String tp=inpt.readUTF();
	  //Util.BREAK("AttributeInputStream.readParameterMode: tp="+tp);
	  if(tp.equalsIgnoreCase("Value")) return(ParameterMode.value);
	  if(tp.equalsIgnoreCase("Name")) return(ParameterMode.name);
	  return(null);
	}
	
	public BlockKind readBlockKind() throws IOException
	{ String kind=inpt.readUTF();
	  //Util.BREAK("AttributeInputStream.readBlockKind: kind="+kind);
	  if(kind.equalsIgnoreCase("Procedure")) return(BlockKind.Procedure);
	  return(BlockKind.Class);
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
