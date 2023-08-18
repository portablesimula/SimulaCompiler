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
import simula.compiler.syntaxClass.Type;
import simula.compiler.syntaxClass.expression.Expression;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Conditional Statement.
 * 
 * <pre>
 * 
 * Simula Standard: 4.2 Conditional statement
 * 
 *   conditional-statement = if-clause { Label : } for-statement
 *                         | if-clause { Label : } unconditional-statement  [ ELSE statement ]
 *                         
 *     if-clause = IF boolean-expression THEN
 *
 * </pre>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/statement/ConditionalStatement.java">
 * <b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 */
public final class ConditionalStatement extends Statement {
	
	/**
	 * The if-clause condition
	 */
	private final Expression condition;
	
	/**
	 * The then-statement
	 */
	private final Statement thenStatement;
	
	/**
	 * The else-statement
	 */
	private final Statement elseStatement;

	/**
	 * Create a new ConditionalStatement.
	 * @param line the source line number
	 */
	ConditionalStatement(final int line) {
		super(line);
		condition = Expression.expectExpression();
		Parse.expect(KeyWord.THEN);
		Statement elseStatement = null;
		if (Parse.accept(KeyWord.ELSE)) {
			thenStatement = new DummyStatement(Parse.currentToken.lineNumber);
			elseStatement = Statement.expectStatement();
		} else {
		    thenStatement = Statement.expectStatement();
		    if (Parse.accept(KeyWord.ELSE)) {
			    elseStatement = Statement.expectStatement();
		    }
		}
		this.elseStatement=elseStatement;
		if (Option.TRACE_PARSE) Util.TRACE("Line "+lineNumber+": IfStatement: "+this);
	}

	@Override
	public void print(final int indent) {
    	String spc=edIndent(indent);
		StringBuilder s = new StringBuilder(spc);
		s.append("IF ").append(condition);
		Util.println(s.toString());
		Util.println(spc + "THEN ");
		thenStatement.print(indent + 1);
		if (elseStatement != null) {
			Util.println(spc + "ELSE ");
			elseStatement.print(indent + 1);
		}
	}

	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		condition.doChecking();
		condition.backLink=this; // To ensure _RESULT from functions
		if (!condition.type.equals(Type.Boolean))
			Util.error("ConditionalStatement.doChecking: Condition is not of Type Boolean, but: "
					+ condition.type);
		thenStatement.doChecking();
		if (elseStatement != null)
			elseStatement.doChecking();
		SET_SEMANTICS_CHECKED();
	}

	
	@Override
	public void doJavaCoding() {
		Global.sourceLineNumber=lineNumber;
		ASSERT_SEMANTICS_CHECKED();
		GeneratedJavaClass.code("if(_VALUE(" + condition.toJavaCode() + ")) {");
		thenStatement.doJavaCoding();
		if (elseStatement != null) {
			GeneratedJavaClass.code("} else {");
			elseStatement.doJavaCoding();
			GeneratedJavaClass.code("}");
		} else
			GeneratedJavaClass.code("}");
	}
	
	@Override
	public void printTree(final int indent) {
		System.out.println(edTreeIndent(indent)+"IF " + condition + " THEN");
		thenStatement.printTree(indent+1);
		if(elseStatement != null) {
			System.out.println(edTreeIndent(indent)+"ELSE");
			elseStatement.printTree(indent+1);
		}
	}

	@Override
	public String toString() {
		return ("IF " + condition + " THEN " + thenStatement + " ELSE "
				+ elseStatement + ';');
	}
}
