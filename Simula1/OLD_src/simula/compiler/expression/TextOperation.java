/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.expression;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Simula Standard: 3.7 Text expressions
 * 
 * <pre>
 *    text-expression
 *        =  simple-text-expression
 *        |  if-clause  simple-text-expression  else  text-expression
*
 *    simple-text-expression
 *        =  text-primary  {  &  text-primary  }
*
 *    text-primary
 *        =  notext
 *        |  string
 *        |  variable
 *        |  function-designator
 *        |  "("  text-expression  ")"
 * </pre>
 * 
 * A text expression is of type text. It is a rule for obtaining an
 * identification of a text variable. Apart from possible if-clauses, all
 * constituents of a text expression must be of type text.
 * <p>
 * Each textual occurrence of a non-empty string corresponds to a unique
 * constant main text frame. A given occurrence always references that same
 * frame, while different occurrences of the same non-empty string always
 * reference different text frames.
 * <p>
 * The empty string ("") is textually equivalent to notext.
 * 
 * 
 * Simula Standard: 3.7.1 Text concatenation
 * <p>
 * The operator & permits text concatenation. The simple text expression "TP1 &
 * TP2 & ... & TPn", where TPi is a text primary (1<=i<=n), references a new
 * alterable main frame whose contents is formed by concatenating copies of the
 * frames referenced by TP1, TP2, ... , TPn (in that order). The expression is
 * equivalent to CONCATENATE_n(T1,T2,...,Tn) defined by
 * 
 * <pre>
 *    text procedure CONCATENATE_ _n(T1,T2,...,Tn);  text T1,T2,...,Tn;
 *    begin  text temp;
 *        CONCATENATE_ _n :- temp :- blanks(T1.length+T2.length+ ... +Tn.length);
 *        temp.sub(1,t1.length) := T1;
 *        temp.sub(1+T1.length,T2.length) := T2;
 *        ...
 *        temp.sub(1+T1.length+T2.length+... ,Tn.length) := Tn;
 *    end;
 * </pre>
 * 
 * Note: It follows that the text primary constituents of a simple text
 * expression are evaluated in strict lexical order. The evaluation of Ti may
 * influence the result of evaluating Tj, if i<j (due to the specified "by
 * reference" transmission of parameters to the procedures CONCATENATE_n).
 * Observe further that it follows from the syntax (cfr. 3.1.5) that . is
 * evaluated before &, thus the two expressions "T1 & T2.sub(1,2) & T3.main" and
 * "T1 & (T2.sub(1,2)) & (T3.main)" are equivalent.
 * 
 * @author Simula Standard
 * @author Øystein Myhre Andersen
 */
public final class TextOperation extends Expression {
	public Expression lhs;
	public Expression rhs;

	public TextOperation(final Expression lhs, final Expression rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
		if (this.lhs == null) {
			Util.error("Missing operand before &");
			this.lhs = new Variable("UNKNOWN$");
		}
		if (this.rhs == null) {
			Util.error("Missing operand after &");
			this.rhs = new Variable("UNKNOWN$");
		}
		this.lhs.backLink = this.rhs.backLink = this;
	}

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())
			return;
		Global.sourceLineNumber = lineNumber;
		if (Option.TRACE_CHECKER)
			Util.TRACE("BEGIN TextOperation" + toString() + ".doChecking - Current Scope Chain: " + Global.currentScope.edScopeChain());
		// TEXT & TEXT
		lhs.doChecking();
		rhs.doChecking();
		if (lhs.type != Type.Text || rhs.type != Type.Text)
			Util.error("Operand Type to Text Concatenation(&) is not Text");
		this.type = Type.Text;
		if (Option.TRACE_CHECKER)
			Util.TRACE("END TextOperation" + toString() + ".doChecking - Result type=" + this.type);
		SET_SEMANTICS_CHECKED();
	}

	// Returns true if this expression may be used as a statement.
	public boolean maybeStatement() {
		ASSERT_SEMANTICS_CHECKED(this);
		return (false);
	}

	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED(this);
		return ("CONC(" + lhs.get() + ',' + rhs.get() + ')');
	}

	public String toString() {
		return ("(" + lhs + " & " + rhs + ")");
	}

}
