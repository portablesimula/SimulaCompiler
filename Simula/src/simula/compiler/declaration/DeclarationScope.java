/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import java.util.Vector;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Util;

public abstract class DeclarationScope extends Declaration {
	
	public int sourceBlockLevel; // Set during Parsing
	protected static int currentBlockLevel = 0; // Used during doChecking
	public int blockLevel; // Set during doChecking
	public boolean hasLocalClasses = false;
	public Vector<Declaration> declarationList = new Vector<Declaration>();
	public Vector<LabelDeclaration> labelList = new Vector<LabelDeclaration>();

	// ***********************************************************************************************
	// *** Constructor
	// ***********************************************************************************************
	public DeclarationScope(final String ident) {
		super(ident);
		declaredIn = Global.currentScope;
		Global.currentScope = this;
		if (declaredIn != null)	sourceBlockLevel = declaredIn.sourceBlockLevel + 1;
		//if("pb".equals(ident)) Util.BREAK("NEW DeclarationScope("+this.edJavaClassName()+"): sourceBlockLevel="+sourceBlockLevel);
	}

	// ***********************************************************************************************
	// *** Utility: findVisibleAttributeMeaning
	// ***********************************************************************************************
	public Meaning findVisibleAttributeMeaning(final String ident) {
		Util.FATAL_ERROR("BlockDeclaration.findVisibleAttributeMeaning: SHOULD BEEN REDEFINED");
		return (null);
	}
	  
    // ***********************************************************************************************
    // *** Utility: findMeaning
    // ***********************************************************************************************
    public Meaning findMeaning(final String identifier) {
    	Meaning meaning=findVisibleAttributeMeaning(identifier);
    	if(meaning==null && declaredIn!=null) meaning=declaredIn.findMeaning(identifier);
    	if(meaning==null) {
    		if(!Global.duringParsing) Util.error("Undefined variable: "+identifier);
    		meaning=new Meaning(null,null); // Error Recovery: No Meaning
    	}
    	return(meaning);
    }

	// ***********************************************************************************************
	// *** Utility: findProcedure -- Follow Static Chain Looking for a Procedure named 'identifier'
	// ***********************************************************************************************
	public ProcedureDeclaration findProcedure(final String identifier) {
		DeclarationScope scope=this;
		while(scope!=null) {
			if(identifier.equalsIgnoreCase(scope.identifier)) {
				if(scope instanceof ProcedureDeclaration) return((ProcedureDeclaration)scope);
	    		return(null);
			}
			scope=scope.declaredIn;
		}
		return(null);
	}

    // ***********************************************************************************************
    // *** Coding Utility: edCTX
    // ***********************************************************************************************
    public String edCTX() {
    	if(blockLevel==0) return("CTX$");
    	int curLevel=Global.currentScope.blockLevel;
        int ctxDiff=curLevel-blockLevel;
        return(edCTX(ctxDiff));
        
    }

    // ***********************************************************************************************
    // *** Coding Utility: edCTX
    // ***********************************************************************************************
    public static String edCTX(int ctxDiff) {
        String ret="CUR$";
        while((ctxDiff--)>0) ret=ret+".SL$";
        return("("+ret+')');
    }
	  
    // ***********************************************************************************************
    // *** Print Utility: edScopeChain
    // ***********************************************************************************************
	public String edScopeChain() {
		if (declaredIn == null) return (identifier);
		String encName = declaredIn.edScopeChain();
		return (identifier + '.' + encName);
	}
	  
	// ***********************************************************************************************
	// *** Utility: edJavaClassName
	// ***********************************************************************************************
	public String edJavaClassName() {
		DeclarationScope scope=this;
		String id=null;
		while(scope!=null) {
			if((scope instanceof BlockDeclaration)
    		&& !(scope instanceof StandardClass)
    		&& !(scope instanceof StandardProcedure)) {
				if(id==null) id=scope.identifier;
				else id=scope.identifier+'$'+id;
	        }
			scope=scope.declaredIn;
		}
		return(id);
	}

}
