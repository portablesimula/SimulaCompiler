/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.expression;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Simula Standard: 3.2 Boolean expressions
 * 
 * <pre>
 *    Boolean-expression
 *        =  simple-Boolean-expression
 *        |  if-clause  simple-Boolean-expression  else  Boolean-expression
 *
 *    simple-Boolean-expression
 *        =  Boolean-tertiary  { or else  Boolean-tertiary }
 *
 *    Boolean-tertiary
 *        =  equivalence  { and then  equivalence }
 *
 *    equivalence
 *        =  implication  { eqv  implication }
 *
 *    implication
 *        =  Boolean-term  { imp  Boolean-term }
 *
 *    Boolean-term
 *        =  Boolean-factor  { or  Boolean-factor }
 *
 *    Boolean-factor
 *        =  Boolean-secondary  { and  Boolean-secondary }
 *
 *    Boolean-secondary
 *        =  [ not ]  Boolean-primary
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
 * 
 * @author Simula Standard
 * @author Øystein Myhre Andersen
 */
public final class BooleanOperation extends Expression {
	public Expression lhs;
	public final KeyWord opr;
	public Expression rhs;

	public BooleanOperation(Expression lhs, KeyWord opr, Expression rhs) {
		this.lhs = lhs;
		this.opr = opr;
		this.rhs = rhs;
		if (this.lhs == null) {
			Util.error("Missing operand before " + opr);
			this.lhs = new Variable("UNKNOWN$");
		}
		if (this.rhs == null) {
			Util.error("Missing operand after " + opr);
			this.rhs = new Variable("UNKNOWN$");
		}
		this.lhs.backLink = this.rhs.backLink = this;
	}

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber = lineNumber;
		if (Option.TRACE_CHECKER)
			Util.TRACE("BEGIN BooleanOperation" + toString() + ".doChecking - Current Scope Chain: "
					+ Global.currentScope.edScopeChain());
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
		    default: Util.FATAL_ERROR("Impossible");
		}
		if (Option.TRACE_CHECKER)
			Util.TRACE("END BooleanOperation" + toString() + ".doChecking - Result type=" + this.type);
		SET_SEMANTICS_CHECKED();
	}

	// Returns true if this expression may be used as a statement.
	public boolean maybeStatement() {
		ASSERT_SEMANTICS_CHECKED(this);
		return (false);
	}

	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED(this);
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

	public String toString() {
		return ("(" + lhs + ' ' + opr + ' ' + rhs + ")");
	}

}
