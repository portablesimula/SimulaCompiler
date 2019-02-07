package testing.asm;

import java.util.HashMap;
import java.util.Map;

import org.objectweb.asm.ConstantDynamic;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.InstructionAdapter;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.util.Printer;
import org.objectweb.asm.util.Textifier;

public class STM$Adapter extends InstructionAdapter {

	public STM$Adapter(final MethodVisitor methodVisitor) {
		super(Opcodes.ASM7, methodVisitor);
		System.out.println("NEW STM$Adapter: methodVisitor=" + methodVisitor);
		// Thread.dumpStack();
	}

	public void visitInsn(final int opcode) {
		System.out.println("STM$Adapter: Instr: " + Printer.OPCODES[opcode]);
		mv.visitInsn(opcode);
	}

	public void visitIntInsn(final int opcode, final int operand) {
		System.out.println("STM$Adapter: Instr: " + Printer.OPCODES[opcode] + " Operand=" + operand);
		mv.visitIntInsn(opcode, operand);
	}

	public void visitVarInsn(final int opcode, final int var) {
		System.out.println("STM$Adapter: Instr: " + Printer.OPCODES[opcode] + " var=" + var);
		mv.visitVarInsn(opcode, var);
	}

	public void visitTypeInsn(final int opcode, final String type) {
		System.out.println("STM$Adapter: Instr: " + Printer.OPCODES[opcode] + " type=" + type);
		if (mv != null) {
			mv.visitTypeInsn(opcode, type);
		}
	}

	public void visitFieldInsn(final int opcode, final String owner, final String name, final String descriptor) {
		System.out.println("STM$Adapter: Instr: " + Printer.OPCODES[opcode] + " owner=" + owner + ", name=" + name
				+ ", descriptor=" + descriptor);
		if (mv != null) {
			mv.visitFieldInsn(opcode, owner, name, descriptor);
		}
	}

	public void visitMethodInsn(final int opcode, final String owner, final String name, final String descriptor,
			final boolean isInterface) {
		System.out.println("STM$Adapter: Instr: " + Printer.OPCODES[opcode] + " owner=" + owner + ", name=" + name
				+ ", descriptor=" + descriptor + ", isInterface" + isInterface);
		if (mv != null) {
			mv.visitMethodInsn(opcode, owner, name, descriptor, isInterface);
		}
	}

	public void visitInvokeDynamicInsn(final String name, final String descriptor, final Handle bootstrapMethodHandle,
			final Object... bootstrapMethodArguments) {
		System.out.println("STM$Adapter: Instr: " + name + ", descriptor=" + descriptor);
		if (mv != null) {
			mv.visitInvokeDynamicInsn(name, descriptor, bootstrapMethodHandle, bootstrapMethodArguments);
		}
	}

	public void visitJumpInsn(final int opcode, final Label label) {
		System.out.println("STM$Adapter: Instr: " + Printer.OPCODES[opcode] + " label=" + label);
		if (mv != null) {
			mv.visitJumpInsn(opcode, label);
		}
	}

	public void visitLabel(final Label label) {
		System.out.println("STM$Adapter: Instr: label=" + label);
		if (mv != null) {
			mv.visitLabel(label);
		}
	}

	public void visitLdcInsn(final Object value) {
		System.out.println("STM$Adapter: Instr: value=" + value);
		if (mv != null) {
			mv.visitLdcInsn(value);
		}
	}

	public void visitIincInsn(final int var, final int increment) {
		System.out.println("STM$Adapter: Instr: var=" + var + ", increment=" + increment);
		if (mv != null) {
			mv.visitIincInsn(var, increment);
		}
	}

	public void visitTableSwitchInsn(final int min, final int max, final Label dflt, final Label... labels) {
		System.out.println("STM$Adapter: TableSwitch: min=" + min + ", max=" + max);
		if (mv != null) {
			mv.visitTableSwitchInsn(min, max, dflt, labels);
		}
	}

	public void visitLookupSwitchInsn(final Label dflt, final int[] keys, final Label[] labels) {
		System.out.println("STM$Adapter: LookupSwitch: dflt=" + dflt + ", keys=" + keys);
		if (mv != null) {
			mv.visitLookupSwitchInsn(dflt, keys, labels);
		}
	}

	public void visitMultiANewArrayInsn(final String descriptor, final int numDimensions) {
		System.out.println(
				"STM$Adapter: MultiANewArrayInsn: descriptor=" + descriptor + ", numDimensions=" + numDimensions);
		if (mv != null) {
			mv.visitMultiANewArrayInsn(descriptor, numDimensions);
		}
	}

	public void visitFrame(final int type, final int numLocal, final Object[] local, final int numStack,
			final Object[] stack) {
		System.out.println("*** STM$Adapter: StackMapFrame: " + editFrame(type, numLocal, local, numStack, stack));
		if (mv != null) {
			mv.visitFrame(type, numLocal, local, numStack, stack);
		}
	}

	public void visitMaxs(final int maxStack, final int maxLocals) {
		System.out.println("STM$Adapter: Visit MAX: maxStack=" + maxStack + ", maxLocals=" + maxLocals);
		if (mv != null) {
			mv.visitMaxs(maxStack, maxLocals);
		}
	}

	public void visitEnd() {
		System.out.println("STM$Adapter: Visit END: mv'QUAL="+mv.getClass().getSimpleName());
		//MethodNode mn = (MethodNode) mv;
		if (mv != null) mv.visitEnd();
	}
	  
	// FREAME EDITING COPIED FROM Textifier
	static StringBuilder stringBuilder;

	public static String editFrame(final int type, final int numLocal, final Object[] local, final int numStack, final Object[] stack) {
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
