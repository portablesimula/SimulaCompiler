package simula.compiler.statement;

import simula.compiler.expression.Constant;
import simula.compiler.expression.Expression;
import simula.compiler.parsing.Parser;
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
public class WhileStatement extends Statement {
	Expression condition;
	Statement doStatement;

	public WhileStatement() {
		if (Option.TRACE_PARSE)	Util.TRACE("Parse WhileStatement, current=" + Parser.currentToken);
		condition = Expression.parseExpression();
		Parser.expect(KeyWord.DO);
		doStatement = Statement.doParse();
		if (Option.TRACE_PARSE)	Util.TRACE("NEW WhileStatement: " + toString());
	}

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Util.setLine(lineNumber);
		// Util.BREAK("BEGIN WhileStatement("+condition+").doChecking - Current Scope Chain: "+currentScope.edScopeChain());
		condition.doChecking();
		if (condition.type != Type.Boolean)
			Util.error("While condition is not Boolean");
		doStatement.doChecking();
		SET_SEMANTICS_CHECKED();
	}

	public void doJavaCoding(String indent) {
		Util.setLine(lineNumber);
		ASSERT_SEMANTICS_CHECKED(this);
		Util.code(indent + "while(" + condition.toJavaCode() + ") {");
		doStatement.doJavaCoding(indent + "   ");
		
		if(isWhileTrueDo())
			Util.code(indent + "   if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate");
		
		Util.code(indent + '}');
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
