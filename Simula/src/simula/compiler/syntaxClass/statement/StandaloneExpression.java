/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass.statement;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.parsing.Parse;
import simula.compiler.syntaxClass.expression.AssignmentOperation;
import simula.compiler.syntaxClass.expression.Expression;
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
 *   standalone-expression = expression | assignment-statement
 *
 *      assignment-statement
 *           = expression { assignment-operator expression }
 *
 * </pre>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/statement/StandaloneExpression.java">
 * <b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 */
public final class StandaloneExpression extends Statement {
	
	/**
	 * The expression.
	 */
	private Expression expression;

	/**
	 * Create a new StandaloneExpression.
	 * @param line the source line number
	 * @param expression the expression
	 */
	StandaloneExpression(final int line,final Expression expression) {
		super(line);
		this.expression = expression;
		if (Option.TRACE_PARSE) Util.TRACE("Line "+lineNumber+": StandaloneExpression: "+this);
		while (Parse.accept(KeyWord.ASSIGNVALUE,KeyWord.ASSIGNREF)) { 
			this.expression = new AssignmentOperation(this.expression, Parse.prevToken.getKeyWord(),expectStandaloneExpression());
		}		
	}

	/**
	 * Parse a standalone expression.
	 * <pre>
	 * Syntax:
	 * 
	 *    standalone-expression  =  expression  { assignment-operator  expression }
	 * </pre>
	 * Pre-Condition: First expression is already read.
	 * @return the resulting StandaloneExpression
	 */
	private static Expression expectStandaloneExpression() { 
		Expression retExpr=Expression.expectExpression();
		while (Parse.accept(KeyWord.ASSIGNVALUE,KeyWord.ASSIGNREF)) {
			KeyWord opr=Parse.prevToken.getKeyWord();
			retExpr=new AssignmentOperation(retExpr,opr,expectStandaloneExpression());
		}
		return retExpr;
	}

	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		if (Option.TRACE_CHECKER) Util.TRACE("StandaloneExpression("+expression+").doChecking - Current Scope Chain: "+Global.getCurrentScope().edScopeChain());
		expression.doChecking();
		if(!expression.maybeStatement()) Util.error("Illegal/Missplaced Expression: "+expression);
		if (Option.TRACE_CHECKER) Util.TRACE("END StandaloneExpression(" + expression+ ").doChecking:");
		SET_SEMANTICS_CHECKED();
	}
	
	@Override
	public void doJavaCoding() {
		Global.sourceLineNumber=lineNumber;
		GeneratedJavaClass.code(toJavaCode() + ';');
	}

	@Override
	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED();
		String result=expression.toJavaCode();
		return (result);
	}

	@Override
	public void print(final int indent) {
		expression.print(indent);
	}
	
	@Override
	public void printTree(final int indent) {
		expression.printTree(indent);
	}

	@Override
	public String toString() {
		return ("STANDALONE " + expression);
	}

}
