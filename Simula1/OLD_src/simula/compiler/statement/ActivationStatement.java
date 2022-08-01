/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.statement;

import simula.compiler.expression.Expression;
import simula.compiler.expression.TypeConversion;
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Token;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Activation Statement.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 * ActivationStatement = Activator  ObjectExpression [ SchedulingPart ]
 * 
 *		Activator = ACTIVATE | REACTIVATE
 *
 *		SchedulingPart = AT ArithmeticExpression [ PRIOR ]
 *                     | DELAY ArithmeticExpression [ PRIOR ]
 *                     | BEFORE ObjectExpression
 *                     | AFTER ObjectExpression
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public final class ActivationStatement extends Statement {
	private final boolean REAC;
	private Expression object1;
	private Expression object2;
	private Expression time = null;
	private Boolean prior = false;
	private ActivationCode code;
	private enum ActivationCode { direct, at, delay, before, after }

	public ActivationStatement() {
		Token activator = Parser.prevToken;
		REAC = activator.getKeyWord() == KeyWord.REACTIVATE;
		if (Option.TRACE_PARSE)
			Parser.TRACE("Parse ActivationStatement");
		object1 = Expression.parseExpression();
		code = ActivationCode.direct;
		if (Parser.accept(KeyWord.AT) || Parser.accept(KeyWord.DELAY)) {
			code = (Parser.prevToken.getKeyWord() == KeyWord.AT) ? ActivationCode.at : ActivationCode.delay;
			time = Expression.parseExpression();
			if (Parser.accept(KeyWord.PRIOR)) prior = true;
		} else if (Parser.accept(KeyWord.BEFORE) || Parser.accept(KeyWord.AFTER)) {
			code = (Parser.prevToken.getKeyWord() == KeyWord.BEFORE) ? ActivationCode.before : ActivationCode.after;
			object2 = Expression.parseExpression();
		}
		if (Option.TRACE_PARSE)
			Util.TRACE("END NEW ActivationStatement: " + toString());
	}

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		if (object1 != null) object1.doChecking();
		if (time != null) time.doChecking();
		if (object2 != null) object2.doChecking();
		SET_SEMANTICS_CHECKED();
	}

	public String toJavaCode() {
		Type refProcess = new Type("Process");
		if (object1 != null)
			object1 = TypeConversion.testAndCreate(refProcess, object1);
		if (object2 != null)
			object2 = TypeConversion.testAndCreate(refProcess, object2);
		switch (code) {
		    case at:return (edActivateAt());
		    case delay:	return (edActivateDelay());
		    case before:return (edActivateBefore());
		    case after:return (edActivateAfter());
		    case direct:
			default: return (edActivateDirect());
		}
	}

	private String edActivateDirect() {
		String obj1 = (object1 == null) ? "null" : object1.toJavaCode();
		Meaning activate1 = Global.currentScope.findMeaning("ActivateDirect");
		String staticLink = activate1.edQualifiedStaticLink();
		return (staticLink + ".ActivateDirect(" + REAC + ',' + obj1 + ')');
	}

	private String edActivateAt() {
		String obj1 = (object1 == null) ? "null" : object1.toJavaCode();
		String staticLink = Global.currentScope.findMeaning("ActivateAt").edQualifiedStaticLink();
		return (staticLink + ".ActivateAt(" + REAC + ',' + obj1 + ',' + time.toJavaCode() + ',' + prior + ')');
	}

	private String edActivateDelay() {
		String obj1 = (object1 == null) ? "null" : object1.toJavaCode();
		String staticLink = Global.currentScope.findMeaning("ActivateDelay").edQualifiedStaticLink();
		return (staticLink + ".ActivateDelay(" + REAC + ',' + obj1 + ',' + time.toJavaCode() + ',' + prior + ')');
	}

	private String edActivateBefore() {
		String obj1 = (object1 == null) ? "null" : object1.toJavaCode();
		String obj2 = (object2 == null) ? "null" : object2.toJavaCode();
		Meaning activate3 = Global.currentScope.findMeaning("ActivateBefore");
		String staticLink = activate3.edQualifiedStaticLink();
		return (staticLink + ".ActivateBefore(" + REAC + ',' + obj1 + ',' + obj2 + ')');
	}

	private String edActivateAfter() {
		String obj1 = (object1 == null) ? "null" : object1.toJavaCode();
		String obj2 = (object2 == null) ? "null" : object2.toJavaCode();
		Meaning activate3 = Global.currentScope.findMeaning("ActivateAfter");
		String staticLink = activate3.edQualifiedStaticLink();
		return (staticLink + ".ActivateAfter(" + REAC + ',' + obj1 + ',' + obj2 + ')');
	}

	public String toString() {
		String pri = "";
		if (prior) pri = " PRIOR";
		String activator = ((REAC) ? "REACTIVATE " : "ACTIVATE ") + object1;
		switch (code) {
		    case at: case delay: return (activator + ' ' + code + ' ' + time + pri);
		    case before: case after: return (activator + ' ' + code + ' ' + object2);
		    case direct:
		    default: return (activator);
		}
	}

}
