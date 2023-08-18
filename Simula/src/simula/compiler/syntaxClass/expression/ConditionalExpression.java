/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass.expression;

import simula.compiler.syntaxClass.Type;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Conditional Expression.
 * 
 * <pre>
 * 
 * Syntax: 
 * 
 *   conditional-expression
 *       = IF Boolean-expression THEN simple-expression ELSE expression
 * 
 * </pre>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/expression/ConditionalExpression.java">
 * <b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 */
public final class ConditionalExpression extends Expression {
	
	/**
	 * The condition.
	 */
	final Expression condition;
	
	/**
	 * The then branch expression
	 */
	Expression thenExpression;
	
	/**
	 * The else branch expression
	 */
	Expression elseExpression;

	/**
	 * Create a new ConditionalExpression.
	 * @param type expression's type
	 * @param condition the condition
	 * @param thenExpression then branch expression
	 * @param elseExpression else branch expression
	 */
	ConditionalExpression(final Type type, final Expression condition, final Expression thenExpression, final Expression elseExpression) {
		this.condition = condition;
		this.thenExpression = thenExpression; thenExpression.backLink=this;
		this.elseExpression = elseExpression; elseExpression.backLink=this;
		if (Option.TRACE_PARSE)
			Util.TRACE("NEW ConditionalExpression: " + toString());
	}

	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		condition.doChecking();
		condition.backLink=this; // To ensure _RESULT from functions
		Type cType = condition.type;
		if (cType != Type.Boolean)
			Util.error("ConditionalExpression: Condition is not a boolean (rather " + cType + ")");
		thenExpression.doChecking();
		elseExpression.doChecking();
		Type expectedType=Type.commonTypeConversion(thenExpression.type,elseExpression.type);
		thenExpression = TypeConversion.testAndCreate(expectedType, thenExpression);
		elseExpression = TypeConversion.testAndCreate(expectedType, elseExpression);
		thenExpression.doChecking(); // In case TypeConversion was added
		elseExpression.doChecking(); // In case TypeConversion was added
		this.type=expectedType;
		SET_SEMANTICS_CHECKED();
	}

	// Returns true if this expression may be used as a statement.
	@Override
	public boolean maybeStatement() {
		ASSERT_SEMANTICS_CHECKED();
		return (false);
	}

	@Override
	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED();
		return ("((" + condition.get() + ")?("
				+ thenExpression.get() + "):("
				+ elseExpression.get() + "))");
	}

	@Override
	public String toString() {
		return ("(IF " + condition + " THEN " + thenExpression + " ELSE "
				+ elseExpression + ')');
	}


}
