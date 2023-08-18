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
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Object relations
 * 
 * <pre>
 * Simula Standard: 3.3.4. Object relations
 * 
 *   object-relation
 *        =  simple-object-expression  IS  class-identifier
 *        |  simple-object-expression  IN  class-identifier
 * </pre>
 * 
 * The operators IS and IN may be used to test the class membership of an
 * object.
 * <p>
 * The relation "X IS C" has the value true if X refers to an object belonging
 * to the class C, otherwise the value is false.
 * <p>
 * The relation "X IN C" has the value true if X refers to an object belonging
 * to a class C or a class inner to C, otherwise the value is false.
 * 
 * <p>
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
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/expression/ObjectRelation.java">
 * <b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 */
public final class ObjectRelation extends Expression {
	
	/**
	 * The left hand side.
	 */
	private final Expression lhs;
	
	/**
	 * The operation: IN, IS or QUA
	 */
	private final KeyWord opr;
	
	/**
	 * The right hand class identifier.
	 */
	private final String classIdentifier;
	
	/**
	 * The class declaration.
	 */
	ClassDeclaration classDeclaration; // Set by doChecking

	/**
	 * Create a new ObjectRelation
	 * @param lhs left hand side
	 * @param opr the operation: IN, IS or QUA
	 * @param classIdentifier the right hand class identifier
	 */
	ObjectRelation(final Expression lhs, final KeyWord opr, final String classIdentifier) {
		this.lhs = lhs;
		this.opr = opr;
		this.classIdentifier = classIdentifier;
		lhs.backLink = this;
	}
  
	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())
			return;
		Global.sourceLineNumber = lineNumber;
		if (Option.TRACE_CHECKER)
			Util.TRACE("BEGIN ObjectRelation" + toString() + ".doChecking - Current Scope Chain: " + Global.getCurrentScope().edScopeChain());
		classDeclaration = getQualification(classIdentifier);
		// Object IS ClassIdentifier | Object IN ClassIdentifier
		lhs.doChecking();
		Type type1 = lhs.type;
		String refIdent = type1.getRefIdent();
		if (refIdent == null) {
			Util.warning("NONE IS/IN " + classIdentifier + " -- Rewrite program");
//		} else {
//			if (!checkCompatability(lhs, classIdentifier))
//				Util.warning("IS/IN is always FALSE -- " + classIdentifier + " is not compatible with " + refIdent);
		}
		this.type = Type.Boolean;
		if (Option.TRACE_CHECKER)
			Util.TRACE("END ObjectRelation" + toString() + ".doChecking - Result type=" + this.type);
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
		String refIdent = lhs.type.getRefIdent();
		if (refIdent == null) return ("false"); // NONE IS/IN Any is always FALSE
		if (opr == KeyWord.IN) {
			if (!checkCompatibility(lhs, classIdentifier)) return ("false"); // warning("IN is always FALSE
			return (lhs.get() + opr.toJavaCode() + classDeclaration.getJavaIdentifier());
		} else if (opr == KeyWord.IS) {
			if (!checkCompatibility(lhs, classIdentifier)) return ("false"); // warning("IS is always FALSE
			return ("_IS(" + lhs.get() + "," + classDeclaration.getJavaIdentifier() + ".class)");
		} else {
			Util.IERR("Impossible");
			return ("");
		}
	}

	@Override
	public String toString() {
		return ("(" + lhs + ' ' + opr + ' ' + classIdentifier + ")");
	}

}
