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
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Conditional Statement.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 *   ConditionalStatement = Ifclause { Label : } ForStatement
 *                        | Ifclause { Label : } UnconditionalStatement  [ ELSE Statement ]
 *     Ifclause = IF BooleanExpression THEN
 *
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public final class ConditionalStatement extends Statement {
	private final Expression condition;
	private final Statement thenStatement;
	private final Statement elseStatement;

	public ConditionalStatement() {
		condition = Expression.parseExpression();
		Parser.expect(KeyWord.THEN);
		Statement elseStatement = null;
		if (Parser.accept(KeyWord.ELSE)) {
			thenStatement = new DummyStatement();
			elseStatement = Statement.doParse();
		} else {
		    thenStatement = Statement.doParse();
		    if (Parser.accept(KeyWord.ELSE)) {
			    elseStatement = Statement.doParse();
		    }
		}
		this.elseStatement=elseStatement;
	}

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

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		condition.doChecking();
		condition.backLink=this; // To ensure RESULT$ from functions
		if (!condition.type.equals(Type.Boolean))
			Util.error("ConditionalStatement.doChecking: Condition is not of Type Boolean, but: "
					+ condition.type);
		thenStatement.doChecking();
		if (elseStatement != null)
			elseStatement.doChecking();
		SET_SEMANTICS_CHECKED();
	}

	
	// TODO: Kan optimaliseres til å gjenkjenne Label inne i Conditional
	//       statement grenene. Og bare legge inn  VALUE$(condition)  da !
	public void doJavaCoding() {
		Global.sourceLineNumber=lineNumber;
		ASSERT_SEMANTICS_CHECKED(this);
		JavaModule.code("if(VALUE$(" + condition.toJavaCode() + ")) {");
		thenStatement.doJavaCoding();
		if (elseStatement != null) {
			JavaModule.code("} else");
			elseStatement.doJavaCoding();
		} else
			JavaModule.code("}");
	}

	public String toString() {
		return ("IF " + condition + " THEN " + thenStatement + " ELSE "
				+ elseStatement + ';');
	}
}
