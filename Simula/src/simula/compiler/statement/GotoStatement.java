/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.statement;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.expression.Expression;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Goto Statement.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 *  GotoStatement = GOTO DesignationalExpression
 *                | GO TO DesignationalExpression
 *
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public final class GotoStatement extends Statement {
	private final Expression label;

	public GotoStatement() {
		label = Expression.parseExpression();
	}

	@Override
	public void doChecking() {
		if (_ISSEMANTICS_CHECKED())	return;
		label.doChecking();
		if (label.type != Type.Label)
			Util.error("Goto " + label + ", " + label + " is not a Label");
		label.backLink = this; // To ensure _RESULT from functions
		SET_SEMANTICS_CHECKED();
	}

	@Override
	public void doJavaCoding() {
		Global.sourceLineNumber = lineNumber;
		ASSERT_SEMANTICS_CHECKED(this);
  		Type type = label.type;
		Util.ASSERT(type == Type.Label, "Invariant");
		GeneratedJavaClass.code("_GOTO(" + label.toJavaCode() + ");","GOTO EVALUATED LABEL");
	}

	@Override
	public String toString() {
		return ("GOTO " + label);
	}

}
