package simula.compiler.byteCodeEngineering;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.FrameNode;
import org.objectweb.asm.tree.IincInsnNode;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.InvokeDynamicInsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.LineNumberNode;
import org.objectweb.asm.tree.LookupSwitchInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MultiANewArrayInsnNode;
import org.objectweb.asm.tree.TableSwitchInsnNode;
import org.objectweb.asm.tree.TypeInsnNode;
import org.objectweb.asm.tree.VarInsnNode;
import org.objectweb.asm.util.Printer;
import org.objectweb.asm.util.Textifier;

import simula.compiler.utilities.Util;

public class AsmUtils {
	
	public static void exploreTableswitch(TableSwitchInsnNode tableSwitch) {
		// Util.BREAK("AsmUtils.exploreTableswitch: " + tableSwitch);
		StringBuilder s=new StringBuilder();
		int min=tableSwitch.min;
		int max=tableSwitch.max;
		LabelNode dflt=tableSwitch.dflt;
		List<LabelNode> labels=tableSwitch.labels;
		//Util.BREAK("AsmUtils.exploreTableswitch: "+Printer.OPCODES[tableSwitch.getOpcode()]+' '+min+' '+max+' '+"...");
		s.append("  TABLESWITCH["+min+":"+max+"] {\n");
		int n=min;
		for(LabelNode L:labels) {
			s.append("      KEY").append(n++).append(": ");
			s.append(""+edLabel(L)+"\n");
		}
		s.append(" } Default: "+edLabel(dflt));
		Util.println(s.toString());
		//Util.BREAK("AsmUtils.exploreTableswitch: END");
	}

	
	public static String edInstruction(AbstractInsnNode instr) {
		StringBuilder s=new StringBuilder();
		int type=instr.getType();
		switch(type)
		{ /** The type of {@link InsnNode} instructions. */
		  case AbstractInsnNode.INSN: return(Printer.OPCODES[instr.getOpcode()]);
		  /** The type of {@link IntInsnNode} instructions. */
		  case AbstractInsnNode.INT_INSN:
			  int operand=((IntInsnNode)instr).operand;
			  return(Printer.OPCODES[instr.getOpcode()]+' '+operand);

		  /** The type of {@link VarInsnNode} instructions. */
		  case AbstractInsnNode.VAR_INSN:
			  int var=((VarInsnNode)instr).var;
			  return(Printer.OPCODES[instr.getOpcode()]+' '+var);

		  /** The type of {@link TypeInsnNode} instructions. */
		  case AbstractInsnNode.TYPE_INSN:
			  String desc=((TypeInsnNode)instr).desc;
			  return(Printer.OPCODES[instr.getOpcode()]+' '+desc);

		  /** The type of {@link FieldInsnNode} instructions. */
		  case AbstractInsnNode.FIELD_INSN:
			  String owner=((FieldInsnNode)instr).owner;
			  String name=((FieldInsnNode)instr).name;
			  desc=((FieldInsnNode)instr).desc;
			  return(Printer.OPCODES[instr.getOpcode()]+' '+owner+' '+name+' '+desc);

		  /** The type of {@link MethodInsnNode} instructions. */
		  case AbstractInsnNode.METHOD_INSN:
			  name=((MethodInsnNode)instr).name;
			  desc=((MethodInsnNode)instr).desc;
			  boolean itf=((MethodInsnNode)instr).itf;
			  return(Printer.OPCODES[instr.getOpcode()]+' '+name+' '+desc+' '+itf);

		  /** The type of {@link InvokeDynamicInsnNode} instructions. */
		  case AbstractInsnNode.INVOKE_DYNAMIC_INSN:
			  name=((InvokeDynamicInsnNode)instr).name;
			  desc=((InvokeDynamicInsnNode)instr).desc;
			  return(Printer.OPCODES[instr.getOpcode()]+' '+name+' '+desc+' '+"...");

		  /** The type of {@link JumpInsnNode} instructions. */
		  case AbstractInsnNode.JUMP_INSN:
			  LabelNode label=((JumpInsnNode)instr).label;
			  return(Printer.OPCODES[instr.getOpcode()]+' '+label);

		  /** The type of {@link LabelNode} "instructions". */
		  case AbstractInsnNode.LABEL:
			  return("LABEL "+edLabel(instr)+':');

		  /** The type of {@link LdcInsnNode} instructions. */
		  case AbstractInsnNode.LDC_INSN:
			  Object cst=((LdcInsnNode)instr).cst;
			  return(Printer.OPCODES[instr.getOpcode()]+' '+cst);

		  /** The type of {@link IincInsnNode} instructions. */
		  case AbstractInsnNode.IINC_INSN:
			  var=((IincInsnNode)instr).var;
			  int incr=((IincInsnNode)instr).incr;
			  return(Printer.OPCODES[instr.getOpcode()]+' '+var+' '+incr);

		  /** The type of {@link TableSwitchInsnNode} instructions. */
		  case AbstractInsnNode.TABLESWITCH_INSN:
			  int min=((TableSwitchInsnNode)instr).min;
			  int max=((TableSwitchInsnNode)instr).max;
			  LabelNode dflt=((TableSwitchInsnNode)instr).dflt;
//			  List<LabelNode> labels=((TableSwitchInsnNode)instr).labels;
			  return(Printer.OPCODES[instr.getOpcode()]+' '+min+' '+max+' '+"...");

		  /** The type of {@link LookupSwitchInsnNode} instructions. */
		  case AbstractInsnNode.LOOKUPSWITCH_INSN:
			  dflt=((LookupSwitchInsnNode)instr).dflt;
			  List<Integer> keys=((LookupSwitchInsnNode)instr).keys;
//			  labels=((LookupSwitchInsnNode)instr).labels;
			  return(Printer.OPCODES[instr.getOpcode()]+' '+dflt+' '+keys+' '+"...");

		  /** The type of {@link MultiANewArrayInsnNode} instructions. */
		  case AbstractInsnNode.MULTIANEWARRAY_INSN:
			  desc=((MultiANewArrayInsnNode)instr).desc;
			  int dims=((MultiANewArrayInsnNode)instr).dims;
			  return(Printer.OPCODES[instr.getOpcode()]+' '+desc+' '+dims);

		  /** The type of {@link FrameNode} "instructions". */
		  case AbstractInsnNode.FRAME:
			  type=((FrameNode)instr).type;
			  List<Object> local=((FrameNode)instr).local;
			  int numLocal=(local==null)?0:local.size();
			  List<Object> stack=((FrameNode)instr).stack;
			  int numStack=(stack==null)?0:stack.size();
			  String ed=edFrame(type, numLocal, (local==null)?null:local.toArray(), numStack, (stack==null)?null:stack.toArray());
			  return(ed);

		  /** The type of {@link LineNumberNode} "instructions". */
		  case AbstractInsnNode.LINE:
			  int line=((LineNumberNode)instr).line;
			  LabelNode start=((LineNumberNode)instr).start;
			  return("LINE "+' '+line+' '+edLabel(start));
		}
		return(s.toString());
	}
	
	public static String edLabel(AbstractInsnNode label) {
		String res=label.toString();
		if(label instanceof LabelNode) {
			res=res.replace("org.objectweb.asm.tree.LabelNode@", "L");
			res=res.toUpperCase();
		}
		return(res);
	}
	
	public static String edAccessFlags(final int accessFlags) {
		StringBuilder stringBuilder=new StringBuilder();
	    if ((accessFlags & Opcodes.ACC_PUBLIC) != 0)		stringBuilder.append(" PUBLIC");
	    if ((accessFlags & Opcodes.ACC_PRIVATE) != 0)		stringBuilder.append(" PRIVATE");
	    if ((accessFlags & Opcodes.ACC_PROTECTED) != 0) 	stringBuilder.append(" PROTECTED");	    
	    if ((accessFlags & Opcodes.ACC_STATIC) != 0)    	stringBuilder.append(" STATIC");
	    if ((accessFlags & Opcodes.ACC_FINAL) != 0)     	stringBuilder.append(" FINAL");
	    if ((accessFlags & Opcodes.ACC_SYNCHRONIZED) != 0)  stringBuilder.append(" SYNCHRONIZED");
	    if ((accessFlags & Opcodes.ACC_BRIDGE) != 0)  		stringBuilder.append(" BRIDGE");
	    if ((accessFlags & Opcodes.ACC_VARARGS) != 0)       stringBuilder.append(" VARARGS");
	    if ((accessFlags & Opcodes.ACC_NATIVE) != 0)	    stringBuilder.append(" NATIVE");
	    if ((accessFlags & Opcodes.ACC_ABSTRACT) != 0) 	    stringBuilder.append(" ABSTRACT");
	    if ((accessFlags & Opcodes.ACC_STRICT) != 0) 	    stringBuilder.append(" STRICT");
	    if ((accessFlags & Opcodes.ACC_SYNTHETIC) != 0)     stringBuilder.append(" SYNTHETIC");
	    return(stringBuilder.toString());
	}
	  
	// FREAME EDITING COPIED FROM Textifier
	static StringBuilder stringBuilder;

	public static String edFrame(final int type, final int numLocal, final Object[] local, final int numStack, final Object[] stack) {
		stringBuilder = new StringBuilder();
		stringBuilder.append("FRAME ");
		switch (type) {
		case Opcodes.F_NEW:
		case Opcodes.F_FULL:
			stringBuilder.append("FULL [");
			appendFrameTypes(numLocal, local);
			stringBuilder.append("] [");
			appendFrameTypes(numStack, stack);
			stringBuilder.append(']');
			break;
		case Opcodes.F_APPEND:
			stringBuilder.append("APPEND [");
			appendFrameTypes(numLocal, local);
			stringBuilder.append(']');
			break;
		case Opcodes.F_CHOP:
			stringBuilder.append("CHOP ").append(numLocal);
			break;
		case Opcodes.F_SAME:
			stringBuilder.append("SAME");
			break;
		case Opcodes.F_SAME1:
			stringBuilder.append("SAME1 ");
			appendFrameTypes(1, stack);
			break;
		default:
			throw new IllegalArgumentException();
		}
		return (stringBuilder.toString());
	}

	private static void appendFrameTypes(final int numTypes, final Object[] frameTypes) {
		for (int i = 0; i < numTypes; ++i) {
			if (i > 0) {
				stringBuilder.append(' ');
			}
			if (frameTypes[i] instanceof String) {
				String descriptor = (String) frameTypes[i];
				if (descriptor.charAt(0) == '[') {
					appendDescriptor(Textifier.FIELD_DESCRIPTOR, descriptor);
				} else {
					appendDescriptor(Textifier.INTERNAL_NAME, descriptor);
				}
			} else if (frameTypes[i] instanceof Integer) {
				switch (((Integer) frameTypes[i]).intValue()) {
				case 0:
					appendDescriptor(Textifier.FIELD_DESCRIPTOR, "T");
					break;
				case 1:
					appendDescriptor(Textifier.FIELD_DESCRIPTOR, "I");
					break;
				case 2:
					appendDescriptor(Textifier.FIELD_DESCRIPTOR, "F");
					break;
				case 3:
					appendDescriptor(Textifier.FIELD_DESCRIPTOR, "D");
					break;
				case 4:
					appendDescriptor(Textifier.FIELD_DESCRIPTOR, "J");
					break;
				case 5:
					appendDescriptor(Textifier.FIELD_DESCRIPTOR, "N");
					break;
				case 6:
					appendDescriptor(Textifier.FIELD_DESCRIPTOR, "U");
					break;
				default:
					throw new IllegalArgumentException();
				}
			} else {
				appendLabel((Label) frameTypes[i]);
			}
		}
	}

	protected static void appendDescriptor(final int type, final String value) {
		if (type == Textifier.CLASS_SIGNATURE || type == Textifier.FIELD_SIGNATURE
				|| type == Textifier.METHOD_SIGNATURE) {
			if (value != null) {
				stringBuilder.append("// signature ").append(value).append('\n');
			}
		} else {
			stringBuilder.append(value);
		}
	}

	protected static Map<Label, String> labelNames;

	protected static void appendLabel(final Label label) {
		if (labelNames == null) {
			labelNames = new HashMap<>();
		}
		String name = labelNames.get(label);
		if (name == null) {
			name = "L" + labelNames.size();
			labelNames.put(label, name);
		}
		stringBuilder.append(name);
	}

}
