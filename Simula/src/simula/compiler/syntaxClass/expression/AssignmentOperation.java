/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass.expression;

import simula.compiler.syntaxClass.Type;
import simula.compiler.syntaxClass.declaration.ArrayDeclaration;
import simula.compiler.syntaxClass.declaration.Declaration;
import simula.compiler.syntaxClass.declaration.Parameter;
import simula.compiler.syntaxClass.declaration.SimpleVariableDeclaration;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Assignment Operation.
 * <p>
 * The Simula assignment statement is for convenience implemented as an assignment operation.
 * <pre>
 * 
 * Simula Standard: 4.1 Assignment statements
 * 
 *   assignment-operation = expression  assignment-operator  expression
 *   
 *		assignment-operator =  :=  |  :-
 *   
 * </pre>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/expression/AssignmentOperation.java">
 * <b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 */
public final class AssignmentOperation extends Expression {

	/**
	 * The left hand side
	 */
	private Expression lhs;

	/**
	 * The arithmetic operation
	 */
	private final KeyWord opr;

	/**
	 * The right hand side
	 */
	private Expression rhs;
	
	/**
	 * Indicates that this assignment is a text value assignment.
	 */
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
		if (IS_SEMANTICS_CHECKED())
			return;
		Global.sourceLineNumber = lineNumber;
		if (Option.TRACE_CHECKER)
			Util.TRACE("BEGIN Assignment" + toString() + ".doChecking - Current Scope Chain: "
					+ Global.getCurrentScope().edScopeChain());
		lhs.doChecking();
		Type toType = lhs.type;
		if (lhs instanceof VariableExpression var) {
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
	/**
	 * Coding Utility: Code text value assignment.
	 * @return the resulting Java source code
	 */
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
	/**
	 * Coding Utility: Code assignment.
	 * @return the resulting Java source code
	 */
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
			if (afterDot instanceof VariableExpression varAfterDot && varAfterDot.hasArguments()) {
				Declaration decl = varAfterDot.meaning.declaredAs;
				Expression beforeDot = rem.obj;
//				System.out.println("AssignmentOperation.doCodeAssignment: beforeDot = " + beforeDot + ", decl=" + decl);
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
	/**
	 * Coding Utility: Code access remote array.
	 * @param beforeDot expression before dot
	 * @param array the array  variable
	 * @param rightPart right part of assignment
	 * @return the resulting Java source code
	 */
	private String doAccessRemoteArray(final Expression beforeDot, final VariableExpression array, final String rightPart) {
		String obj = beforeDot.toJavaCode();
		String remoteIdent = obj + '.' + array.edIdentifierAccess(true);
		Declaration decl = array.meaning.declaredAs;
		System.out.println("AssignmentOperation.doAccessRemoteArray: decl="+decl.getClass().getSimpleName()+"  "+decl);
		if(decl instanceof Parameter par) { // TESTING_ARRAY
			String arrayType = par.type.getArrayType();
			remoteIdent = "(("+arrayType+")"+remoteIdent+")";
		}
		return (array.doPutELEMENT(remoteIdent, rightPart));
	}

	@Override
	public String toString() {
		return ("(" + lhs + ' ' + opr + ' ' + rhs + ")");
	}

}
