/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.transform;

import java.util.List;
import java.util.Vector;

import java.lang.constant.ConstantDesc;
import java.lang.classfile.CodeBuilder;
import java.lang.classfile.CodeElement;
import java.lang.classfile.CodeTransform;
import java.lang.classfile.Label;

import java.lang.classfile.instruction.ConstantInstruction;
import java.lang.classfile.instruction.InvokeInstruction;
import java.lang.classfile.instruction.LabelTarget;
import java.lang.classfile.instruction.SwitchCase;

import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

// ========================================
// NOTE NOTE NOTE:  PRØV DENNE FØRST
//=========================================
// RETT: SimulaCompiler  line  394
//=========================================


/*
 * Simula .class file transformer.
 * <p>
 * CASE 1: Repair the JUMPTABLE.
 * <p>
 * Locate the instruction sequence:
 * <pre>
 *    ... any instruction(s)
 *    GETFIELD _JTX
 *    ICONST n   or  BIPUSH  or SIPUSH
 *    INVOKESTATIC _JUMPTABLE
 * </pre>
 * Replace it by:
 * <pre>
 *    ... any instruction(s)
 *    GETFIELD _JTX
 *    TABLESWITCH ...
 * </pre>
 * <br> 
 * <br> 
 * CASE 2: Repair a LABEL.
 * <p>
 * Locate the instruction sequence:
 * <pre>
 *    ICONST n   or  BIPUSH  or SIPUSH
 *    INVOKESTATIC _LABEL
 * </pre>
 * Replace it by:
 * <pre>
 *    LABEL (pseudo instruction)
 * </pre>
 */

final class SimulaCodeTransform implements CodeTransform {

	private List<SwitchCase> cases;
	private CodeElement prevElement;

	@Override
	public void atEnd(CodeBuilder builder) {
		if (prevElement != null) {
			if (Option.TRACE_REPAIRING_OUTPUT)
				Util.TRACE("SimulaCodeTransform.atEnd: Output " + prevElement);
			builder.with(prevElement);
			prevElement = null;
		}
	}

	@Override
	public void accept(CodeBuilder builder, CodeElement element) {
		if (Option.TRACE_REPAIRING_INPUT)
			Util.TRACE("SimulaCodeTransform.accept: Input " + element);
		if (element instanceof InvokeInstruction instr) {
			if (instr.name().equalsString("_JUMPTABLE")) {
				// *******************************************************************************
				// *** JUMPTABLE Case
				// *******************************************************************************
				// iconst_n // Number of cases (tableSize)
				// invokestatic _JUMPTABLE
				//
				// Output:
				//
				// tableswitch ...
				//
				int tableSize = getConst(prevElement);
				prevElement = null;
				if (Option.TRACE_REPAIRING)
					Util.TRACE("SimulaCodeTransform.accept: Define TableSwitch " + tableSize);
				cases = new Vector<SwitchCase>();
				for (int i = 1; i <= tableSize; i++) {
					cases.add(SwitchCase.of(i, builder.newLabel()));
				}
				// Build the TableSwitch Instruction
				Label defaultTarget = builder.newLabel(); // beginning of the default handler block.
				int lowValue = 1; // the minimum key value.
				int highValue = cases.size(); // the maximum key value.
				if (Option.TRACE_REPAIRING_OUTPUT)
					Util.TRACE("SimulaCodeTransform.accept: Output TableSwitch");
				if (Option.TRACE_REPAIRING_OUTPUT)
					Util.TRACE("SimulaCodeTransform.accept: Output defaultTarget=" + defaultTarget);
				builder.tableswitch(lowValue, highValue, defaultTarget, cases).labelBinding(defaultTarget);
				return;
			}
			if (instr.name().equalsString("_SIM_LABEL")) {
				// *******************************************************************************
				// *** LABEL Cases
				// *******************************************************************************
				// iconst_n // Case number
				// invokestatic _SIM_LABEL
				//
				// Output:
				//
				// label (pseudo instruction)
				//
				int caseValue = getConst(prevElement);
				prevElement = null;
				if (Option.TRACE_REPAIRING)
					Util.TRACE("SimulaCodeTransform.accept: Define Label  " + caseValue);
				LabelTarget target = (LabelTarget) cases.get(caseValue - 1).target();
				builder.labelBinding(target.label());
				if (Option.TRACE_REPAIRING_OUTPUT)
					Util.TRACE("SimulaCodeTransform.accept: Output " + target);
				return;
			}
		}
		if (Option.TRACE_REPAIRING_OUTPUT)
			Util.TRACE("SimulaCodeTransform.accept: Output " + prevElement);
		if (prevElement != null)
			builder.with(prevElement);
		prevElement = element;
	}

	/**
	 * ConstantInstruction: ICONST n or BIPUSH or SIPUSH
	 * 
	 * @param element
	 * @return the integer constant value
	 * @throws RuntimeException if something went wrong
	 */
	private int getConst(CodeElement element) {
		if (element instanceof ConstantInstruction instr) {
			ConstantDesc val = instr.constantValue();
			Integer ival = (Integer) val;
			return (ival.intValue());
		}
		throw new RuntimeException("Expected ConstantInstruction, GOT " + element);
	}

	@Override
	public String toString() {
		return ("SimulaCodeTransform");
	}
}
