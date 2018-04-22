/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.expression;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Unary Operation.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 *   UnaryOperation =  operation  Expression
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public class UnaryOperation extends Expression {
	private KeyWord oprator;
	private Expression operand;

	public UnaryOperation(KeyWord oprator, Expression operand) {
		this.oprator = oprator;
		this.operand = operand; operand.backLink=this;
		//Util.BREAK("NEW UnaryOperation: "+toString());
	}

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Util.setLine(lineNumber);
		if (Option.TRACE_CHECKER)
			Util.TRACE("BEGIN UnaryOperation" + toString()
					+ ".doChecking - Current Scope Chain: "
					+ Global.currentScope.edScopeChain());
		operand.doChecking();
		if (oprator == KeyWord.NOT)
			this.type=Type.Boolean;
		else if (oprator == KeyWord.PLUS || oprator == KeyWord.MINUS) {
			this.type=operand.type;
		}
		SET_SEMANTICS_CHECKED();
	}

	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED(this);
		return ("(" + oprator.toJavaCode() + "(" + operand.toJavaCode() + "))");
	}

	public String toString() {
		return ("(" + oprator + ' ' + operand + ")");
	}

}
