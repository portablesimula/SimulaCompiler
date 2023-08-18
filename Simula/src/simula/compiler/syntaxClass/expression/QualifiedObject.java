/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass.expression;

import simula.compiler.syntaxClass.Type;
import simula.compiler.syntaxClass.declaration.ClassDeclaration;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Qualified Object
 * 
 * <pre>
 * Simula Standard: 3.8 Object expressions
 * 
 *   qualified-object
 *        =  simple-object-expression  QUA  class-identifier
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
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/expression/QualifiedObject.java">
 * <b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 */
public final class QualifiedObject extends Expression {
	
	/**
	 * The left hand simple-object-expression 
	 */
	private final Expression lhs;
	
	/**
	 * The right hand class identifier.
	 */
	private final String classIdentifier;
	
	/**
	 * The right hand class declaration. Set by doChecking.
	 */
	ClassDeclaration classDeclaration; // Set by doChecking

	/**
	 * Create a new QualifiedObject
	 * @param lhs left hand side
	 * @param classIdentifier class identifier
	 */
	QualifiedObject(final Expression lhs, final String classIdentifier) {
		this.lhs = lhs;
		this.classIdentifier = classIdentifier;
		lhs.backLink = this;
	}

	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber = lineNumber;
		if (Option.TRACE_CHECKER)
			Util.TRACE("BEGIN QualifiedObject" + toString() + ".doChecking - Current Scope Chain: "	+ Global.getCurrentScope().edScopeChain());
		classDeclaration = getQualification(classIdentifier);
		lhs.doChecking();
		if (!checkCompatibility(lhs, classIdentifier))
			Util.error("Illegal Object Expression: " + lhs + " is not compatible with " + classIdentifier);
		this.type = new Type(classIdentifier);
		if (Option.TRACE_CHECKER)
			Util.TRACE("END QualifiedObject" + toString() + ".doChecking - Result type=" + this.type);
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
		return("((" + classDeclaration.getJavaIdentifier() + ")(" + lhs.get() + "))");
	}

	@Override
	public String toString() {
		return ("(" + lhs + " QUA " + classIdentifier + ")");
	}

}
