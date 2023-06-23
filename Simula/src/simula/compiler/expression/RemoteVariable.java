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
import simula.runtime._SimulaRuntimeError;

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
	final Expression obj;
	final Variable var;
	private Meaning remoteAttribute; // Set by doChecking
	private ProcedureDeclaration callRemoteProcedure = null;
	private VirtualSpecification callRemoteVirtual = null;

	private boolean accessRemoteArray = false; // Set by doChecking

	RemoteVariable(final Expression obj, final Variable var) {
		this.obj = obj;
		this.var = var;
		obj.backLink = var.backLink = this;
	}

	@Override
	public Variable getWriteableVariable() {
		return (var);
	}

	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber = lineNumber;
		if (Option.TRACE_CHECKER)
			Util.TRACE("BEGIN RemoteVariable" + toString() + ".doChecking - Current Scope Chain: " + Global.getCurrentScope().edScopeChain());
		this.type = doRemoteChecking(obj, var);
		if (Option.TRACE_CHECKER) Util.TRACE("END RemoteVariable" + toString() + ".doChecking - Result type=" + this.type);
		SET_SEMANTICS_CHECKED();
	}

	private Type doRemoteChecking(final Expression obj, final Expression attr) {
		Global.sourceLineNumber = lineNumber;
		Type result;
		obj.doChecking();
		Type objType = obj.type;
		if (objType == Type.Text)
			return (doRemoteTextChecking(obj, attr));

		objType.doChecking(Global.getCurrentScope()); // Nødvendig hvis TypeDeclaration er nedenfor
		ClassDeclaration qual = objType.getQual();
		if (qual == null)
			Util.error("doRemoteChecking: Object Expression (" + obj + ") is not a ref() type rather " + objType);
		else if (qual.hasLocalClasses)
//			Util.warning("Illegal remote access into object of class with local classes.");
			Util.error("Illegal remote access into object of class with local classes.");

		if (attr instanceof Variable var) {
			String ident = var.identifier;
			qual = objType.getQual();
			if(qual!=null) remoteAttribute = qual.findRemoteAttributeMeaning(ident);
			if (remoteAttribute == null) {
				Util.error("RemoteVariable.doRemoteChecking: " + ident + " is not an attribute of "	+ objType.getRefIdent());
				return (Type.Integer); // Error Recovery
			}
			var.setRemotelyAccessed(remoteAttribute);

			if (remoteAttribute.declaredAs instanceof Parameter par) {
				if (par.kind == Parameter.Kind.Array)
					accessRemoteArray = true;
			}

			if (remoteAttribute.declaredAs instanceof ArrayDeclaration) { // Array
				if (var.hasArguments())	accessRemoteArray = true;
			} else if (remoteAttribute.declaredAs instanceof ProcedureDeclaration proc) { // Procedure
				callRemoteProcedure = proc;
			} else if (remoteAttribute.declaredAs instanceof VirtualSpecification virSpec) { // Virtual Procedure
				callRemoteVirtual = virSpec;
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
		if (attr instanceof Variable var) { // Covers FunctionDesignator and SubscriptedVariable since they are subclasses
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
	@Override
	public boolean maybeStatement() {
		ASSERT_SEMANTICS_CHECKED(this);
		return (var.maybeStatement());
	}

	@Override
	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED(this);
		if (callRemoteProcedure != null)
			return (CallProcedure.remote(obj, callRemoteProcedure, var, backLink));
		else if (callRemoteVirtual != null)
			return (CallProcedure.remoteVirtual(obj, var, callRemoteVirtual));
		else if (accessRemoteArray)
			return (doAccessRemoteArray(obj, var));
		Expression constantElement=remoteAttribute.getConstant();
		if(constantElement != null) {
			if(constantElement instanceof Constant constant) return(constant.toJavaCode());
		}
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
		String obj = beforeDot.toJavaCode();
		String cast=array.type.toJavaArrayType();
		String var="(("+cast+')'+obj+'.'+array.edIdentifierAccess(false)+')';
		return(array.doGetELEMENT(var));
	}

	@Override
	public String toString() {
		return ("(" + obj + " DOT " + var + ")");
	}

}
