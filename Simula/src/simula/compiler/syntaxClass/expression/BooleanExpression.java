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
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Boolean expressions
 * 
 * <pre>
 * Simula Standard: 3.2 Boolean expressions
 *
 *    Boolean-expression
 *        =  simple-Boolean-expression
 *        |  IF Boolean-expression THEN  simple-Boolean-expression  ELSE  Boolean-expression
 *
 *    simple-Boolean-expression
 *        =  Boolean-tertiary  { OR ELSE  Boolean-tertiary }
 *
 *    Boolean-tertiary
 *        =  equivalence  { AND THEN  equivalence }
 *
 *    equivalence
 *        =  implication  { EQV  implication }
 *
 *    implication
 *        =  Boolean-term  { IMP  Boolean-term }
 *
 *    Boolean-term
 *        =  Boolean-factor  { OR  Boolean-factor }
 *
 *    Boolean-factor
 *        =  Boolean-secondary  { AND  Boolean-secondary }
 *
 *    Boolean-secondary
 *        =  [ NOT ]  Boolean-primary
 *
 *    Boolean-primary
 *        =  logical-value
 *        |  variable
 *        |  function-designator
 *        |  relation
 *        |  "("  Boolean-expression  ")"
 * </pre>
 * 
 * A Boolean expression is of type Boolean. It is a rule for computing a logical
 * value. Except for the operators and then and or else (see 3.4) the semantics
 * are entirely analogous to those given for arithmetic expressions.
 * <p>
 * Variables and function designators entered as Boolean primaries must be of
 * type Boolean.
 * 
 * 
 * Simula Standard: 3.4 The logical operators
 * <p>
 * The meaning of the logical operators not, and, or, imp, and eqv is given by
 * the following function table:
 * 
 * <pre>
        b1               false     false     true      true
        b2               false     true      false     true
      ---------------------------------------------------------
        not  b1          true      true      false     false
        b1 and b2        false     false     false     true
        b1 or b2         false     true      true      true
        b1 imp b2        true      true      false     true
        b1 eqv b2        true      false     false     true
     ----------------------------------------------------------
 * </pre>
 * 
 * The operation "b1 and then b2" denotes "conditional and". If the value of b1
 * is false the operation yields the result false, otherwise it yields the
 * result of evaluating b2.
 * <p>
 * The operation "b1 or else b2" denotes "conditional or". If the value of b1 is
 * true the operator yields the result true, otherwise it yields the result of
 * evaluating b2.
 * <p>
 * Note: The value of "b1 and then b2" is given by textual substitution of the
 * Boolean expression "(if b1 then b2 else false)". Similarly, the operation "b1
 * or else b2" is defined by substitution of "(if b1 then true else b2)". These
 * definitions imply that the evaluation of the second operand is suppressed
 * when the evaluation result is already evident from the value of the first
 * operand alone.
 * <p>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/expression/BooleanExpression.java">
 * <b>Source File</b></a>.
 * 
 * @author Simula Standard
 * @author Øystein Myhre Andersen
 */
public final class BooleanExpression extends Expression {

	/**
	 * The left hand side
	 */
	private Expression lhs;

	/**
	 * The Boolean operation
	 */
	private final KeyWord opr;

	/**
	 * The right hand side
	 */
	private Expression rhs;

	/**
	 * Create a new BooleanExpression.
	 * @param lhs left hand side
	 * @param opr Boolean operation
	 * @param rhs right hand side
	 */
	BooleanExpression(Expression lhs, KeyWord opr, Expression rhs) {
		this.lhs = lhs;
		this.opr = opr;
		this.rhs = rhs;
		if (this.lhs == null) {
			Util.error("Missing operand before " + opr);
			this.lhs = new VariableExpression("UNKNOWN_");
		}
		if (this.rhs == null) {
			Util.error("Missing operand after " + opr);
			this.rhs = new VariableExpression("UNKNOWN_");
		}
		this.lhs.backLink = this.rhs.backLink = this;
	}

	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber = lineNumber;
		if (Option.TRACE_CHECKER)
			Util.TRACE("BEGIN BooleanOperation" + toString() + ".doChecking - Current Scope Chain: " + Global.getCurrentScope().edScopeChain());
		switch (opr) {
		    case AND:case OR:case IMP:case EQV:case AND_THEN:case OR_ELSE: {
		    	// Boolean operation
				lhs.doChecking();
				rhs.doChecking();
				Type type1 = lhs.type;
				Type type2 = rhs.type;
				if (type1.equals(type2) & type1 == Type.Boolean)
					this.type = Type.Boolean;
				if (this.type == null)
					Util.error("Incompatible types in binary operation: " + toString());
				break;
		    }
		    default: Util.IERR("Impossible");
		}
		if (Option.TRACE_CHECKER)
			Util.TRACE("END BooleanOperation" + toString() + ".doChecking - Result type=" + this.type);
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
		switch (opr) {
			case IMP: return ("((!" + lhs.get() + ") | " + rhs.get() + ')');
			case EQV: return ("((" + lhs.get() + ") == (" + rhs.get() + "))");
			default: {
				if (this.backLink == null)
				 	 return (lhs.get() + opr.toJavaCode() + '(' + rhs.get() + ')');
				else return ("(" + lhs.get() + opr.toJavaCode() + '(' + rhs.get() + "))");
			}
		}
	}

	@Override
	public String toString() {
		return ("(" + lhs + ' ' + opr + ' ' + rhs + ")");
	}

}
