/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.expression;

import simula.compiler.declaration.ClassDeclaration;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Qualified Object
 * 
 * <pre>
 *  QualifiedObject
 *        =  SimpleObjectExpression  QUA  ClassIdentifier
 * </pre>
 * 
 * The qualification of an object expression is defined by the following rules:
 * <ul>
 * <li>The expression none is qualified by a fictitious class which is inner to
 * all declared classes.
 * 
 * <li>A variable or function designator is qualified as stated in the
 * declaration (or specification, see below) of the variable or array or
 * procedure in question.
 * 
 * <li>An object generator, local object or qualified object is qualified by the
 * class of the identifier following the symbol new, this or qua respectively.
 * 
 * <li>A conditional object expression is qualified by the innermost class which
 * includes the qualifications of both alternatives. If there is no such class,
 * the expression is illegal.
 * 
 * <li>Any formal parameter of object reference type is qualified according to
 * its specification regardless of the qualification of the corresponding actual
 * parameter.
 * 
 * <li>The qualification of a function designator whose procedure identifier is
 * that of a virtual quantity depends on the access level (see 5.5.5). The
 * qualification is that of the matching declaration, if any, occurring at the
 * innermost prefix level equal or outer to the access level, or, if no such
 * match exists, it is that of the virtual specification.
 * </ul>
 * 
 * @author Øystein Myhre Andersen
 */
public final class QualifiedObject extends Expression {
	public final Expression lhs;
	public final String classIdentifier;
	ClassDeclaration classDeclaration; // Set by doChecking

	public QualifiedObject(final Expression lhs, final String classIdentifier) {
		this.lhs = lhs;
		this.classIdentifier = classIdentifier;
		lhs.backLink = this;
	}

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber = lineNumber;
		if (Option.TRACE_CHECKER)
			Util.TRACE("BEGIN QualifiedObject" + toString() + ".doChecking - Current Scope Chain: "	+ Global.getCurrentScope().edScopeChain());
		classDeclaration = getQualification(classIdentifier);
		lhs.doChecking();
		if (!checkCompatability(lhs, classIdentifier))
			Util.error("Illegal Object Expression: " + lhs + " is not compatible with " + classIdentifier);
		this.type = new Type(classIdentifier);
		if (Option.TRACE_CHECKER)
			Util.TRACE("END QualifiedObject" + toString() + ".doChecking - Result type=" + this.type);
		SET_SEMANTICS_CHECKED();
	}

	// Returns true if this expression may be used as a statement.
	public boolean maybeStatement() {
		ASSERT_SEMANTICS_CHECKED(this);
		return (false);
	}

	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED(this);
		return("((" + classDeclaration.getJavaIdentifier() + ")(" + lhs.get() + "))");
	}

	public String toString() {
		return ("(" + lhs + " QUA " + classIdentifier + ")");
	}

}
