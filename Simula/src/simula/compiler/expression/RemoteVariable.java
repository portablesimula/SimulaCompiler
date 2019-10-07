/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.expression;

import simula.compiler.declaration.ArrayDeclaration;
import simula.compiler.declaration.ClassDeclaration;
import simula.compiler.declaration.Parameter;
import simula.compiler.declaration.ProcedureDeclaration;
import simula.compiler.declaration.StandardClass;
import simula.compiler.declaration.VirtualSpecification;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Binary Operation.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 *   RemoteVariable = Expression  DOT  Variable
 * 
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public final class RemoteVariable extends Expression {
	public final Expression obj;
	public final Variable var;
	private Meaning remoteAttribute; // Set by doChecking
	private ProcedureDeclaration callRemoteProcedure = null;
	private VirtualSpecification callRemoteVirtual = null;

	private boolean accessRemoteArray = false; // Set by doChecking

	public RemoteVariable(final Expression obj, final Variable var) {
		this.obj = obj;
		this.var = var;
		obj.backLink = var.backLink = this;
	}

	public Variable getWriteableVariable() {
		return (var);
	}

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber = lineNumber;
		if (Option.TRACE_CHECKER)
			Util.TRACE("BEGIN RemoteVariable" + toString() + ".doChecking - Current Scope Chain: "
					+ Global.currentScope.edScopeChain());
		this.type = doRemoteChecking(obj, var);

		if (Option.TRACE_CHECKER)
			Util.TRACE("END RemoteVariable" + toString() + ".doChecking - Result type=" + this.type);
		SET_SEMANTICS_CHECKED();
	}

	private Type doRemoteChecking(final Expression obj, final Expression attr) {
		Global.sourceLineNumber = lineNumber;
		Type result;
		obj.doChecking();
		Type objType = obj.type;
		if (objType == Type.Text)
			return (doRemoteTextChecking(obj, attr));

		objType.doChecking(Global.currentScope); // Nødvendig hvis TypeDeclaration er nedenfor TODO: ER DETTE OK ?
		ClassDeclaration qual = objType.getQual();
		if (qual == null)
			Util.error("doRemoteChecking: Object Expression (" + obj + ") is not a ref() type rather " + objType);
		else if (qual.hasLocalClasses)
			Util.error("Illegal remote access into object of class with local classes.");

		if (attr instanceof Variable) {
			Variable var = (Variable) attr;
			String ident = var.identifier;
			remoteAttribute = objType.getQual().findRemoteAttributeMeaning(ident);
			if (remoteAttribute == null) {
				Util.error("RemoteVariable.doRemoteChecking: " + ident + " is not an attribute of "	+ objType.getRefIdent());
				return (Type.Integer); // Error Recovery
			}
			var.setRemotelyAccessed(remoteAttribute);

			if (remoteAttribute.declaredAs instanceof Parameter) {
				Parameter par = (Parameter) remoteAttribute.declaredAs;
				if (par.kind == Parameter.Kind.Array)
					accessRemoteArray = true;
			}

			if (remoteAttribute.declaredAs instanceof ArrayDeclaration) { // Array
				if (var.hasArguments())	accessRemoteArray = true;
			} else if (remoteAttribute.declaredAs instanceof ProcedureDeclaration) { // Procedure
				callRemoteProcedure = (ProcedureDeclaration) remoteAttribute.declaredAs;
			} else if (remoteAttribute.declaredAs instanceof VirtualSpecification) { // Virtual Procedure
				callRemoteVirtual = (VirtualSpecification) remoteAttribute.declaredAs;
			}
			result = remoteAttribute.declaredAs.type;
		} else {
			Util.error("Illegal attribute(" + attr + ") in remote access");
			result = attr.type;
		}
		return (result);
	}

	private Type doRemoteTextChecking(final Expression obj, final Expression attr) {
		Type result;
		if (attr instanceof Variable) { // Covers FunctionDesignator and SubscriptedVariable since they are subclasses
			Variable var = (Variable) attr;
			String ident = var.identifier;
			Meaning remote = StandardClass.typeText.findMeaning(ident);
			if (remote == null)
				Util.error("RemoteVariable.doRemoteTextChecking: " + ident + " is not a Text attribute");
			var.setRemotelyAccessed(remote);
			callRemoteProcedure = (ProcedureDeclaration) remote.declaredAs;
			result = remote.declaredAs.type;

		} else {
			Util.error("Illegal attribute(" + attr + ") in remote access");
			result = attr.type;
		}
		return (result);
	}

	// Returns true if this expression may be used as a statement.
	public boolean maybeStatement() {
		ASSERT_SEMANTICS_CHECKED(this);
		return (var.maybeStatement());
	}

	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED(this);
		if (callRemoteProcedure != null)
			return (CallProcedure.remote(obj, callRemoteProcedure, var, backLink));
		else if (callRemoteVirtual != null)
			return (CallProcedure.remoteVirtual(obj, var, callRemoteVirtual));
		else if (accessRemoteArray)
			return (doAccessRemoteArray(obj, var));
		String result;
		if (remoteAttribute.foundBehindInvisible) {
			String remoteCast = remoteAttribute.foundIn.getJavaIdentifier();
			result = "((" + remoteCast + ")(" + obj.get() + "))." + var.get();
		} else result = obj.get() + KeyWord.DOT.toJavaCode() + var.get();
		return (result);
	}

	// ***********************************************************************
	// *** CODE: doAccessRemoteArray
	// ***********************************************************************
	private String doAccessRemoteArray(final Expression beforeDot, final Variable array) {
		StringBuilder s = new StringBuilder();
		int nDim = 0;
		// Generate: obj.M.A[6-obj.M.LB[1]];
		String obj = beforeDot.toJavaCode();
		String remoteIdent = obj + '.' + array.edIdentifierAccess(true);
		StringBuilder ixs = new StringBuilder();
		String dimBrackets = "";
		for (Expression ix : array.checkedParams) {
			String index = "[" + ix.toJavaCode() + "-" + remoteIdent + ".LB[" + (nDim++) + "]]";
			ixs.append(index);
			dimBrackets = dimBrackets + "[]";
		}
		String eltType = type.toJavaType();
		String cast = "ARRAY$<" + eltType + dimBrackets + ">";
		String castedVar = "((" + cast + ")" + remoteIdent + ")";
		s.append(castedVar).append(".Elt").append(ixs);

		return (s.toString());
	}

	public String toString() {
		return ("(" + obj + " DOT " + var + ")");
	}

}
