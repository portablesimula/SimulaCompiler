package testing.asm;

import java.util.List;
import java.util.ListIterator;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.FrameNode;
import org.objectweb.asm.tree.IincInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.InvokeDynamicInsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.LineNumberNode;
import org.objectweb.asm.tree.LookupSwitchInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.MultiANewArrayInsnNode;
import org.objectweb.asm.tree.TableSwitchInsnNode;
import org.objectweb.asm.tree.TypeInsnNode;
import org.objectweb.asm.tree.VarInsnNode;
import org.objectweb.asm.util.Printer;

public class RepairCodeAdapter extends MethodVisitor {
	String owner;
	MethodVisitor next;

	public RepairCodeAdapter(String owner, int access, String name, String desc, MethodVisitor mv) {
		super(Opcodes.ASM7, new MethodNode(access, name, desc, null, null));
		this.owner = owner;
		next = mv;
	}

	@Override
	public void visitEnd() {
		System.out.println("RepairCodeAdapter: Visit END: mv'QUAL="+mv.getClass().getSimpleName());
		MethodNode mn = (MethodNode) mv;
//		Analyzer<BasicValue> a = new Analyzer<BasicValue>(new BasicInterpreter());
//		try {
//			a.analyze(owner, mn);
//			Frame<BasicValue>[] frames = a.getFrames();
//			AbstractInsnNode[] insns = mn.instructions.toArray();
//			for (int i = 0; i < frames.length; ++i) {
//				if (frames[i] == null && !(insns[i] instanceof LabelNode)) {
//					mn.instructions.remove(insns[i]);
//				}
//			}
//		} catch (AnalyzerException ignored) {
//		}
		
		InsnList instructions=mn.instructions;
		ListIterator<AbstractInsnNode> iterator=instructions.iterator();
		while(iterator.hasNext()) {
			AbstractInsnNode instr=iterator.next();
			System.out.println("RepairCodeAdapter.visitEnd: Instruction="+edInstruction(instr));
		}
		
		mn.accept(next);
	}
	
	private String edInstruction(AbstractInsnNode instr) {
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
			  return("LABEL "+instr);

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
			  List<LabelNode> labels=((TableSwitchInsnNode)instr).labels;
			  return(Printer.OPCODES[instr.getOpcode()]+' '+min+' '+max+' '+"...");

		  /** The type of {@link LookupSwitchInsnNode} instructions. */
		  case AbstractInsnNode.LOOKUPSWITCH_INSN:
			  dflt=((LookupSwitchInsnNode)instr).dflt;
			  List<Integer> keys=((LookupSwitchInsnNode)instr).keys;
			  labels=((LookupSwitchInsnNode)instr).labels;
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
			  String ed=STM$Adapter.editFrame(type, numLocal, (local==null)?null:local.toArray(), numStack, (stack==null)?null:stack.toArray());
//			  return("FRAME "+edFrameType(type));
			  return(ed);

		  /** The type of {@link LineNumberNode} "instructions". */
		  case AbstractInsnNode.LINE:
			  int line=((LineNumberNode)instr).line;
			  LabelNode start=((LineNumberNode)instr).start;
			  return("LINE "+' '+line+' '+start);
		}
		return(s.toString());
	}
	
	private String edFrameType(final int type) {
		switch (type) {
		case Opcodes.F_NEW: return("NEW");
		case Opcodes.F_FULL: return("FULL");
		case Opcodes.F_APPEND: return("APPEND");
		case Opcodes.F_CHOP: return("CHOP");
		case Opcodes.F_SAME: return("SAME");
		case Opcodes.F_SAME1: return("SAME1");
		default: return("UNKNOWN");
		}
	}

}
