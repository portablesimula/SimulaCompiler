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
 * Text expression.
 * 
 * <pre>
 * Simula Standard: 3.7 Text expressions
 * 
 *    text-expression
 *        =  simple-text-expression
 *        |  if-clause  simple-text-expression  else  text-expression
*
 *    simple-text-expression
 *        =  text-primary  {  &amp;  text-primary  }
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
 * The operator &amp; permits text concatenation. The simple text expression "TP1 &amp;
 * TP2 &amp; ... &amp; TPn", where TPi is a text primary (1&lt;=i&lt;=n), references a new
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
 * influence the result of evaluating Tj, if i&lt;j (due to the specified "by
 * reference" transmission of parameters to the procedures CONCATENATE_n).
 * Observe further that it follows from the syntax (cfr. 3.1.5) that . is
 * evaluated before &amp;, thus the two expressions "T1 &amp; T2.sub(1,2) &amp; T3.main" and
 * "T1 &amp; (T2.sub(1,2)) &amp; (T3.main)" are equivalent.
 * <p>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/expression/TextExpression.java">
 * <b>Source File</b></a>.
 * 
 * @author Simula Standard
 * @author Øystein Myhre Andersen
 */
public final class TextExpression extends Expression {
	
	/**
	 * The left hand side of &amp;
	 */
	private Expression lhs;
	
	/**
	 * The right hand side of &amp;
	 */
	private Expression rhs;

	/**
	 * Create a new TextExpression
	 * @param lhs left hand side
	 * @param rhs rigth hand side
	 */
	TextExpression(final Expression lhs, final Expression rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
		if (this.lhs == null) {
			Util.error("Missing operand before &");
			this.lhs = new VariableExpression("UNKNOWN_");
		}
		if (this.rhs == null) {
			Util.error("Missing operand after &");
			this.rhs = new VariableExpression("UNKNOWN_");
		}
		this.lhs.backLink = this.rhs.backLink = this;
	}

	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED()) return;
		Global.sourceLineNumber = lineNumber;
		if (Option.TRACE_CHECKER)
			Util.TRACE("BEGIN TextOperation" + toString() + ".doChecking - Current Scope Chain: " + Global.getCurrentScope().edScopeChain());
		// TEXT & TEXT
		lhs.doChecking();
		rhs.doChecking();
//		if (lhs.type != Type.Text || rhs.type != Type.Text) {
		if (!(lhs.type.equals(Type.Text) && rhs.type.equals(Type.Text))) {
			Util.error("Operand Type to Text Concatenation(&) is not Text: "+lhs.type+" & "+rhs.type);
		}
		this.type = Type.Text;
		if (Option.TRACE_CHECKER)
			Util.TRACE("END TextOperation" + toString() + ".doChecking - Result type=" + this.type);
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
		return ("CONC(" + lhs.get() + ',' + rhs.get() + ')');
	}

	@Override
	public String toString() {
		return ("(" + lhs + " & " + rhs + ")");
	}

}
