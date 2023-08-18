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
import simula.compiler.syntaxClass.declaration.ClassDeclaration;
import simula.compiler.syntaxClass.declaration.Parameter;
import simula.compiler.syntaxClass.declaration.ProcedureDeclaration;
import simula.compiler.syntaxClass.declaration.StandardClass;
import simula.compiler.syntaxClass.declaration.VirtualSpecification;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Remote Variable.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 *   remote-variable = expression  DOT  variable
 * 
 * </pre>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/expression/RemoteVariable.java">
 * <b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 */
public final class RemoteVariable extends Expression {
	
	/**
	 * The remote attribute's semantic meaning.
	 */
	private Meaning remoteAttribute; // Set by doChecking
	
	/**
	 * If the remoteAttribute is declared as a ProcedureDeclaration 'callRemoteProcedure' is the procedure to be called.
	 */
	private ProcedureDeclaration callRemoteProcedure = null;
	
	/**
	 * If the remoteAttribute is declared as a VirtualSpecification 'callRemoteVirtual' is the procedure to be called.
	 */
	private VirtualSpecification callRemoteVirtual = null;
	
	/**
	 * The object expression
	 */
	final Expression obj;
	
	/**
	 * The variable
	 */
	final VariableExpression var;

	/**
	 * Used to indicate access remote array. Set by doChecking.
	 */
	private boolean accessRemoteArray = false;

	/**
	 * Create a new RemoteVariable
	 * @param obj object expression
	 * @param var the variable
	 */
	RemoteVariable(final Expression obj, final VariableExpression var) {
		this.obj = obj;
		this.var = var;
		obj.backLink = var.backLink = this;
	}

	@Override
	public VariableExpression getWriteableVariable() {
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

	/**
	 * Perform semantic checking
	 * @param obj remote object
	 * @param attr remote attribute
	 * @return the attribute's type
	 */
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
			if(Option.SPORT)
			     Util.warning("Illegal remote access into object of class with local classes.");
			else Util.error("Illegal remote access into object of class with local classes.");

		if (attr instanceof VariableExpression var) {
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

	/**
	 * Perform semantic checking
	 * @param obj remote object
	 * @param attr remote attribute
	 * @return the attribute's type
	 */
	private Type doRemoteTextChecking(final Expression obj, final Expression attr) {
		Type result;
		if (attr instanceof VariableExpression var) { // Covers FunctionDesignator and SubscriptedVariable since they are subclasses
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
		ASSERT_SEMANTICS_CHECKED();
		return (var.maybeStatement());
	}

	@Override
	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED();
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
	/**
	 * Coding Utility: Edit remote array access.
	 * @param beforeDot expression before dot
	 * @param array the array variable
	 * @return the resulting Java source code
	 */
	private String doAccessRemoteArray(final Expression beforeDot, final VariableExpression array) {
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
