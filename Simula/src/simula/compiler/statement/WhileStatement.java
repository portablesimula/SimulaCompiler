package simula.compiler.statement;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.expression.Constant;
import simula.compiler.expression.Expression;
import simula.compiler.parsing.Parse;
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
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/statement/WhileStatement.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 */
public final class WhileStatement extends Statement {
	private final Expression condition;
	private final Statement doStatement;

	/**
	 * Create a new WhileStatement.
	 * @param line the source line number
	 */
	WhileStatement(int line) {
		super(line);
		if (Option.TRACE_PARSE)	Util.TRACE("Parse WhileStatement: line="+line+", current=" + Parse.currentToken);
		condition = Expression.expectExpression();
		Parse.expect(KeyWord.DO);
		doStatement = Statement.expectStatement();
		if (Option.TRACE_PARSE)	Util.TRACE("Line "+lineNumber+": WhileStatement: "+this);
	}

	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		condition.doChecking(); condition.backLink=this;
		if (condition.type != Type.Boolean) Util.error("While condition is not Boolean");
		doStatement.doChecking();
		SET_SEMANTICS_CHECKED();
	}

	@Override
	public void doJavaCoding() {
		Global.sourceLineNumber=lineNumber;
		ASSERT_SEMANTICS_CHECKED();
		GeneratedJavaClass.code("while(" + condition.toJavaCode() + ") {");
		doStatement.doJavaCoding();
		if(isWhileTrueDo())
			GeneratedJavaClass.code("if(_CTX==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate");
		GeneratedJavaClass.code("}");
	}
	
	private boolean isWhileTrueDo() {
		// Check for:  while(true) do {}
		if(condition instanceof Constant cnst) return((boolean)cnst.value);
		else return(false);
	}

	@Override
	public String toString() {
		return ("WHILE " + condition + " DO " + doStatement);
	}
}
