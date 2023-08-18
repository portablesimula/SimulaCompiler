package simula.compiler.syntaxClass.statement;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.parsing.Parse;
import simula.compiler.syntaxClass.Type;
import simula.compiler.syntaxClass.expression.Constant;
import simula.compiler.syntaxClass.expression.Expression;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * While Statement.
 * 
 * <pre>
 * 
 * Simula Standard: 4.3 While-statement
 * 
 *   while-statement = WHILE Boolean-expression DO Statement
 *
 * </pre>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/statement/WhileStatement.java">
 * <b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 */
public final class WhileStatement extends Statement {
	/**
	 * The WHILE condition
	 */
	private final Expression condition;
	
	/**
	 * The statement after DO
	 */
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
	
	/**
	 * Check if this while statement is a 'while true do'.
	 * @return true if this while statement is a 'while true do'
	 */
	private boolean isWhileTrueDo() {
		// Check for:  while(true) do {}
		if(condition instanceof Constant cnst) return((boolean)cnst.value);
		else return(false);
	}

	@Override
	public void printTree(final int indent) {
		System.out.println(edTreeIndent(indent)+"WHILE " + condition + " DO");
		doStatement.printTree(indent+1);
	}

	@Override
	public String toString() {
		return ("WHILE " + condition + " DO " + doStatement);
	}
}
