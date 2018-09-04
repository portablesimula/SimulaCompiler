/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.statement;

import simula.compiler.JavaModule;
import simula.compiler.expression.AssignmentOperation;
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
 *   StandaloneStatement = Expression | AssignmentStatement
 *
 *   AssignmentStatement
 *        =  Expression { AssignmentOperator  Expression }
 *
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public final class StandaloneExpression extends Statement {
	private Expression expression;

	public StandaloneExpression(Expression expression) {
		this.expression = expression;
		if (Option.TRACE_PARSE) Util.TRACE("NEW StandaloneExpression: " + toString());
		
		while (Parser.accept(KeyWord.ASSIGNVALUE,KeyWord.ASSIGNREF))
		{ 
//		  this.expression = new Assignment(this.expression, Parser.prevToken.getKeyWord(),Expression.parseExpression());
		  this.expression = new AssignmentOperation(this.expression, Parser.prevToken.getKeyWord(),parseStandaloneExpression());
		  //Util.BREAK("NEW StandaloneExpression: "+this);
		}
	}

	  //  StandaloneExpression  =  Expression  { AssignmentOperator  Expression }
	  private static Expression parseStandaloneExpression() { 
		 //Util.BREAK("Expression.parseStandaloneExpression");
		 Expression retExpr=Expression.parseExpression();
		 while (Parser.accept(KeyWord.ASSIGNVALUE,KeyWord.ASSIGNREF)) {
		      KeyWord opr=Parser.prevToken.getKeyWord();
//	          retExpr=new Assignment(retExpr,opr,Expression.parseExpression());
	          retExpr=new AssignmentOperation(retExpr,opr,parseStandaloneExpression());
		 }
		 return retExpr;
	  }

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		if (Option.TRACE_CHECKER) Util.TRACE("StandaloneExpression("+expression+").doChecking - Current Scope Chain: "+Global.currentScope.edScopeChain());
		expression.doChecking();
//		Util.BREAK("StandaloneExpression.doChecking: expression="+expression);
//		Util.BREAK("StandaloneExpression.doChecking: expression'QUAL="+expression.getClass().getSimpleName());
		if(!expression.maybeStatement()) Util.error("Illegal/Missplaced Expression: "+expression);
		if (Option.TRACE_CHECKER) Util.TRACE("END StandaloneExpression(" + expression+ ").doChecking: type=" + type);
		// Debug.BREAK("END StandaloneExpression");
		SET_SEMANTICS_CHECKED();
	}
	
	public void doJavaCoding() {
		Global.sourceLineNumber=lineNumber;
		JavaModule.code(toJavaCode() + ';');
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
