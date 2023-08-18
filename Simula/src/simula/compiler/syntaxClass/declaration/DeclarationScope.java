/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass.declaration;

import java.util.Vector;

import simula.compiler.utilities.DeclarationList;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Util;

/**
 * Declaration Scope.
 * <p>
 * This class is prefix to BlockDeclaration and ConnectionBlock, and superclass
 * of ClassDeclaration, ProcedureDeclaration and MaybeBlockDeclaration.
 * <p>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/declaration/DeclarationScope.java">
 * <b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 */
public abstract sealed class DeclarationScope extends Declaration
permits BlockDeclaration, ConnectionBlock  {
	
	/**
	 * Current Runtime Block level - Used during doChecking
	 */
	protected static int currentRTBlockLevel = 0;

	/**
	 * The source block level. Set during Parsing.
	 */
	public int sourceBlockLevel;

	/**
	 * The Compile time block level. Set during doChecking.
	 */
	public int ctBlockLevel;

	/**
	 * The Runtime block level. Set during doChecking.
	 */
	public int rtBlockLevel;

	/**
	 * Indicate if this scope has local classes.
	 */
	public boolean hasLocalClasses = false;

	/**
	 * The declaration list.
	 */
	public DeclarationList declarationList;

	/**
	 * The label list.
	 */
	public Vector<LabelDeclaration> labelList = new Vector<LabelDeclaration>();

	// ***********************************************************************************************
	// *** Constructor
	// ***********************************************************************************************
	/**
	 * Create a new DeclarationScope.
	 * 
	 * @param ident scope identifier
	 */
	protected DeclarationScope(final String ident) {
		super(ident);
		declarationList = new DeclarationList(
				this.getClass().getSimpleName() + ':' + ident + ":Line=" + Global.sourceLineNumber);
		declaredIn = Global.getCurrentScope();
		Global.setScope(this);
		if (declaredIn != null)
			sourceBlockLevel = declaredIn.sourceBlockLevel + 1;
	}

	// ***********************************************************************************************
	// *** Utility: scopeID
	// ***********************************************************************************************
	/**
	 * Returns a printable scope ID.
	 * 
	 * @return a printable scope ID
	 */
	public String scopeID() {
		if (rtBlockLevel > 1)
			return (declaredIn.scopeID() + '.' + identifier);
		return (identifier);
	}

	// ***********************************************************************************************
	// *** Utility: findVisibleAttributeMeaning
	// ***********************************************************************************************
	/**
	 * Find visible attribute's Meaning
	 * 
	 * @param ident attribute identifier
	 * @return the resulting Meaning
	 */
	public Meaning findVisibleAttributeMeaning(final String ident) {
		Util.IERR("DeclarationScope.findVisibleAttributeMeaning: SHOULD BEEN REDEFINED: " + identifier);
		return (null);
	}

	// ***********************************************************************************************
	// *** Utility: findMeaning
	// ***********************************************************************************************
	/**
	 * Find Meaning
	 * 
	 * @param identifier declared identifier
	 * @return the resulting Meaning
	 */
	public Meaning findMeaning(final String identifier) {
		Meaning meaning = findVisibleAttributeMeaning(identifier);
		if (meaning == null && declaredIn != null)
			meaning = declaredIn.findMeaning(identifier);
		if (meaning == null) {
			if (!Global.duringParsing)
				Util.error("Undefined variable: " + identifier);
			meaning = new Meaning(null, null); // Error Recovery: No Meaning
		}
		return (meaning);
	}

	// ***********************************************************************************************
	// *** Utility: findLabelMeaning
	// ***********************************************************************************************
	/**
	 * Find Label's Meaning
	 * 
	 * @param identifier declared label identifier
	 * @return the resulting Meaning
	 */
	public Meaning findLabelMeaning(final String identifier) {
		for (LabelDeclaration dcl : labelList) {
			if (Util.equals(dcl.identifier, identifier)) {
				return (new Meaning(dcl, this, this, false));
			}
		}
		if (declaredIn != null)
			return (declaredIn.findLabelMeaning(identifier));
		return (null);
	}

	// ***********************************************************************************************
	// *** Utility: findProcedure -- Follow Static Chain Looking for a Procedure
	// named 'identifier'
	// ***********************************************************************************************
	/**
	 * Follow Static Chain Looking for a Procedure named 'identifier'
	 * 
	 * @param identifier the procedure identifier
	 * @return the resulting ProcedureDeclaration
	 */
	public ProcedureDeclaration findProcedure(final String identifier) {
		DeclarationScope scope = this;
		while (scope != null) {
			if (Util.equals(identifier, scope.identifier)) {
				if (scope instanceof ProcedureDeclaration proc)
					return (proc);
				return (null);
			}
			scope = scope.declaredIn;
		}
		return (null);
	}

	// ***********************************************************************************************
	// *** Coding Utility: edCTX
	// ***********************************************************************************************
	/**
	 * Coding utility: Edit current context chain.
	 * 
	 * @return edited context chain
	 */
	public String edCTX() {
		if (rtBlockLevel == 0)
			return ("_CTX");
		int curLevel = Global.getCurrentScope().rtBlockLevel;
		int ctxDiff = curLevel - rtBlockLevel;
		return (edCTX(ctxDiff));

	}

	// ***********************************************************************************************
	// *** Coding Utility: edCTX
	// ***********************************************************************************************
	/**
	 * Coding utility: Edit context chain.
	 * 
	 * @param ctxDiff block level difference.
	 * @return edited context chain
	 */
	public static String edCTX(int ctxDiff) {
		String ret = "_CUR";
		while ((ctxDiff--) > 0)
			ret = ret + "._SL";
		return ("(" + ret + ')');
	}

	// ***********************************************************************************************
	// *** Print Utility: edScopeChain
	// ***********************************************************************************************
	/**
	 * Edit scope chain.
	 * 
	 * @return edited scope chain
	 */
	public String edScopeChain() {
		if (declaredIn == null)
			return (identifier);
		String encName = declaredIn.edScopeChain();
		return (identifier + '.' + encName);
	}

	// ***********************************************************************************************
	// *** Utility: edJavaClassName
	// ***********************************************************************************************
	/**
	 * Utility to edit JavaClass'Name
	 * 
	 * @return the edited JavaClass'Name
	 */
	protected String edJavaClassName() {
		DeclarationScope scope = this;
		String id = null;
		while (scope != null) {
			if ((scope instanceof BlockDeclaration) && !(scope instanceof StandardClass)
					&& !(scope instanceof StandardProcedure)) {
				if (id == null)
					id = scope.identifier;
				else
					id = scope.identifier + '_' + id;
			}
			scope = scope.declaredIn;
		}
		return (id);
	}
	
	protected void printDeclarationList(int indent) {
		for(Declaration d:declarationList) d.printTree(indent);
		for(LabelDeclaration d:labelList) d.printTree(indent);
	}

}
