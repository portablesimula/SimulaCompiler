/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.statement;

import simula.compiler.expression.BinaryOperation;
import simula.compiler.expression.Expression;
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Standalone Expression Statement.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 *   Statement = Expression | AssignmentStatement
 *
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public class StandaloneExpression extends Statement {
	private Expression expression;

	public StandaloneExpression(Expression expression) {
		this.expression = expression;
		if (Option.TRACE_PARSE) Util.TRACE("NEW StandaloneExpression: " + toString());
		
		if (Parser.accept(KeyWord.ASSIGNVALUE)
				|| Parser.accept(KeyWord.ASSIGNREF))
		{ Util.BREAK("NEW StandaloneExpression: Dette er ikke MULIG ! "+this);
			this.expression = new BinaryOperation(expression, Parser.prevToken.getKeyWord(),
					Expression.parseExpression());
		}
	}

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Util.setLine(lineNumber);
		if (Option.TRACE_CHECKER) Util.TRACE("StandaloneExpression("+expression+").doChecking - Current Scope Chain: "+Global.currentScope.edScopeChain());
		expression.doChecking();
		if (Option.TRACE_CHECKER) Util.TRACE("END StandaloneExpression(" + expression+ ").doChecking: type=" + type);
		// Debug.BREAK("END StandaloneExpression");
		SET_SEMANTICS_CHECKED();
	}
	


	public void doJavaCoding(String indent) {
		Util.setLine(lineNumber);
		Util.code(indent + toJavaCode() + ';');
	}

	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED(this);
		String result=expression.toJavaCode();
		//Util.BREAK("StandaloneExpression.toJavaCode: "+this+" ==> "+result);
		return (result);
	}

	public void print(String indent, String tail) {
		expression.print(indent, tail);
	}

	public String toString() {
		return ("STANDALONE " + expression);
	}

}
