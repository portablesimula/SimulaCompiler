/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.statement;

import simula.compiler.JavaModule;
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

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		label.doChecking();
		if (label.type != Type.Label)
			Util.error("Goto " + label + ", " + label + " is not a Label");
		label.backLink = this; // To ensure RESULT$ from functions
		SET_SEMANTICS_CHECKED();
	}

	public void doJavaCoding() {
		Global.sourceLineNumber = lineNumber;
		ASSERT_SEMANTICS_CHECKED(this);
  		Type type = label.type;
		Util.ASSERT(type == Type.Label, "Invariant");
		JavaModule.code("GOTO$(" + label.toJavaCode() + ");","GOTO EVALUATED LABEL");
	}

	public String toString() {
		return ("GOTO " + label);
	}

}
