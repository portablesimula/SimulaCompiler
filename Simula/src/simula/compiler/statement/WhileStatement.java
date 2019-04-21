package simula.compiler.statement;

import simula.compiler.JavaModule;
import simula.compiler.expression.Constant;
import simula.compiler.expression.Expression;
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * While Statement.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 *   WhileStatement = WHILE BooleanExpression DO Statement
 *
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public final class WhileStatement extends Statement {
	private final Expression condition;
	private final Statement doStatement;

	public WhileStatement() {
		if (Option.TRACE_PARSE)	Util.TRACE("Parse WhileStatement, current=" + Parser.currentToken);
		condition = Expression.parseExpression();
		Parser.expect(KeyWord.DO);
		doStatement = Statement.doParse();
		if (Option.TRACE_PARSE)	Util.TRACE("NEW WhileStatement: " + toString());
	}

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		// Util.BREAK("BEGIN WhileStatement("+condition+").doChecking - Current Scope Chain: "+currentScope.edScopeChain());
		condition.doChecking(); condition.backLink=this;
		if (condition.type != Type.Boolean)
			Util.error("While condition is not Boolean");
		doStatement.doChecking();
		SET_SEMANTICS_CHECKED();
	}

	public void doJavaCoding() {
		Global.sourceLineNumber=lineNumber;
		ASSERT_SEMANTICS_CHECKED(this);
		JavaModule.code("while(" + condition.toJavaCode() + ") {");
		doStatement.doJavaCoding();
		
		if(isWhileTrueDo())
			JavaModule.code("if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate");
		
		JavaModule.code("}");
	}
	
	private boolean isWhileTrueDo()
	{ // Check for:  while(true) do {}
	  if(!(condition instanceof Constant)) return(false);
	  return(((Boolean)((Constant)condition).value));
	}

	public String toString() {
		return ("WHILE " + condition + " DO " + doStatement);
	}
}
