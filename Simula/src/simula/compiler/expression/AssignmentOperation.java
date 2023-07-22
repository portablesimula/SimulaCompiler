/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.expression;

import simula.compiler.declaration.ArrayDeclaration;
import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.Parameter;
import simula.compiler.declaration.SimpleVariableDeclaration;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Assignment Operation.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 *   AssignmentOperation = Expression  AssignmentOperator  Expression
 *   
 *		AssignmentOperator =  :=  |  :-
 *   
 * </pre>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/expression/AssignmentOperation.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 */
public final class AssignmentOperation extends Expression {
	private Expression lhs;
	private final KeyWord opr;
	private Expression rhs;
	private boolean textValueAssignment = false; // Set by doChecking

	/**
	 * AssignmentOperation.
	 * @param lhs the left hand side
	 * @param opr the operation
	 * @param rhs the right hand side
	 */
	public AssignmentOperation(final Expression lhs, final KeyWord opr, final Expression rhs) {
		this.lhs = lhs;
		this.opr = opr;
		this.rhs = rhs;
		if (this.lhs == null) {
			Util.error("Missing operand before " + opr);
			this.lhs = new Variable("UNKNOWN_");
		}
		if (this.rhs == null) {
			Util.error("Missing operand after " + opr);
			this.rhs = new Variable("UNKNOWN_");
		}
		this.lhs.backLink = this.rhs.backLink = this;
	}

	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())
			return;
		Global.sourceLineNumber = lineNumber;
		if (Option.TRACE_CHECKER)
			Util.TRACE("BEGIN Assignment" + toString() + ".doChecking - Current Scope Chain: "
					+ Global.getCurrentScope().edScopeChain());
		lhs.doChecking();
		Type toType = lhs.type;
		if (lhs instanceof Variable var) {
			Meaning meaning = var.getMeaning();
			if (meaning.declaredAs instanceof SimpleVariableDeclaration dcl) {
				if (dcl.isConstant())
					Util.error("Assignment to Constant: '" + lhs + "' is Illegal");
			}
		} else {
			if (lhs.getWriteableVariable() == null)
				Util.error("Can't assign to " + lhs);
		}
		rhs.doChecking();
		Type fromType = rhs.type;
		if (opr == KeyWord.ASSIGNVALUE)
			this.textValueAssignment = (toType == Type.Text);
		rhs = (Expression) TypeConversion.testAndCreate(toType, rhs);
		this.type = toType;
		if (this.type == null)
			Util.error("doAssignmentChecking: Illegal types: " + toType + " := " + fromType);
		SET_SEMANTICS_CHECKED();
	}

	// Returns true if this expression may be used as a statement.
	@Override
	public boolean maybeStatement() {
		ASSERT_SEMANTICS_CHECKED();
		return (true);
	}

	@Override
	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED();
		if (this.textValueAssignment)
			return (doCodeTextValueAssignment());
		else
			return (doCodeAssignment());
	}

	// ***********************************************************************
	// *** CODE: doCodeTextValueAssignment
	// ***********************************************************************
	private String doCodeTextValueAssignment() {
		StringBuilder s = new StringBuilder();
		if (rhs instanceof Constant cnst) {
			Object value = cnst.value;
			if (value != null) {
				s.append("_ASGSTR(").append(lhs.toJavaCode()).append(",\"").append(value).append("\")");
				return (s.toString());
			}
		}
		s.append("_ASGTXT(").append(lhs.toJavaCode()).append(',').append(rhs.toJavaCode()).append(')');
		return (s.toString());
	}

	// ***********************************************************************
	// *** CODE: doCodeAssignment
	// ***********************************************************************
	private String doCodeAssignment() {
		StringBuilder s = new StringBuilder();
		// -------------------------------------------------------------------------
		// CHECK FOR SPECIAL CASE:
		// OBJECT DOT ARRAY(x1,x2,...) := Expression ;
		// SHOULD BE CODED LIKES:
		// OBJECT.ARRAY.putELEMENT(OBJECT.ARRAY.index(x1,x2),Expression);
		// -------------------------------------------------------------------------
		if (lhs instanceof RemoteVariable rem) {
			Expression afterDot = ((RemoteVariable) lhs).var;
			if (afterDot instanceof Variable varAfterDot && varAfterDot.hasArguments()) {
				Declaration decl = varAfterDot.meaning.declaredAs;
				Expression beforeDot = rem.obj;
				System.out.println("AssignmentOperation.doCodeAssignment: beforeDot = " + beforeDot + ", decl=" + decl);
				if (decl instanceof ArrayDeclaration)
					return (doAccessRemoteArray(beforeDot, varAfterDot, rhs.toJavaCode()));
				else if (decl instanceof Parameter par) {
					if (par.kind == Parameter.Kind.Array)
						return (doAccessRemoteArray(beforeDot, varAfterDot, rhs.toJavaCode()));
				}

			}
		}
		s.append(lhs.put(rhs.get()));
		return (s.toString());
	}

	// ***********************************************************************
	// *** CODE: doAccessRemoteArray
	// ***********************************************************************
	private String doAccessRemoteArray(final Expression beforeDot, final Variable array, final String rightPart) {
		String obj = beforeDot.toJavaCode();
		String remoteIdent = obj + '.' + array.edIdentifierAccess(true);
		return (array.doPutELEMENT(remoteIdent, rightPart));
	}

	@Override
	public String toString() {
		return ("(" + lhs + ' ' + opr + ' ' + rhs + ")");
	}

}
