/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.statement;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.expression.AssignmentOperation;
import simula.compiler.expression.Expression;
import simula.compiler.parsing.Parse;
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
 *   StandaloneStatement = Expression | AssignmentStatement
 *
 *   AssignmentStatement
 *        =  Expression { AssignmentOperator  Expression }
 *
 * </pre>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/statement/StandaloneExpression.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 */
public final class StandaloneExpression extends Statement {
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
			this.expression = new AssignmentOperation(this.expression, Parse.prevToken.getKeyWord(),parseStandaloneExpression());
		}		
	}

	//  StandaloneExpression  =  Expression  { AssignmentOperator  Expression }
	private static Expression parseStandaloneExpression() { 
		Expression retExpr=Expression.parseExpression();
		while (Parse.accept(KeyWord.ASSIGNVALUE,KeyWord.ASSIGNREF)) {
			KeyWord opr=Parse.prevToken.getKeyWord();
			retExpr=new AssignmentOperation(retExpr,opr,parseStandaloneExpression());
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
		if (Option.TRACE_CHECKER) Util.TRACE("END StandaloneExpression(" + expression+ ").doChecking: type=" + type);
		SET_SEMANTICS_CHECKED();
	}
	
	@Override
	public void doJavaCoding() {
		Global.sourceLineNumber=lineNumber;
		GeneratedJavaClass.code(toJavaCode() + ';');
	}

	@Override
	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED(this);
		String result=expression.toJavaCode();
		return (result);
	}

	@Override
	public void print(final int indent) {
		expression.print(indent);
	}

	@Override
	public String toString() {
		return ("STANDALONE " + expression);
	}

}
