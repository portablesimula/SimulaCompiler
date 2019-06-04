/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.expression;

import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.DeclarationScope;

import simula.compiler.declaration.ClassDeclaration;
import simula.compiler.declaration.ConnectionBlock;
import simula.compiler.expression.Expression;
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * LocalObject i.e. This class expression.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 * LocalObject = THIS ClassIdentifier
 * 
 * </pre>
 * 
 * A local object "this C" is valid provided that the expression is used within
 * the class body of C or that of any subclass of C, or a connection block whose
 * block qualification is C or a subclass of C (see 4.8).
 * <p>
 * The value of a local object in a given context is the object which is, or is
 * connected by, the smallest textually enclosing block instance in which the
 * local object is valid.
 * <p>
 * If there is no such block the local object is illegal (in the given context).
 * For an instance of a procedure or a class body, "textually enclosing" means
 * containing its declaration.
 * 
 * 
 * @author Simula Standard
 * @author Øystein Myhre Andersen
 */
public final class LocalObject extends Expression {
	private final String classIdentifier;
	private ClassDeclaration classDeclaration; // Set by doChecking
//	private DeclarationScope declarationScope; // Set by doChecking
	private int ctxDiff;  // Set by doChecking

	private LocalObject(final String classIdentifier) {
		this.classIdentifier = classIdentifier;
		this.type=Type.Ref(classIdentifier);
		if (Option.TRACE_PARSE)
			Util.TRACE("NEW ThisObjectExpression: " + toString());
	}

	public static Expression acceptThisIdentifier() {
		if (Option.TRACE_PARSE)
			Util.TRACE("Parse ThisObjectExpression, current=" + Parser.currentToken);
		String classIdentifier = expectIdentifier();
		Expression expr = new LocalObject(classIdentifier);
		return(expr);
	}

	public void doChecking() { 
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		if (Option.TRACE_CHECKER);
			Util.TRACE("BEGIN LocalObject(" + toString()+").doChecking - Current Scope Chain: "+Global.currentScope.edScopeChain());
		//Util.BREAK("BEGIN LocalObject(" + toString()+").doChecking - Current Scope Chain: "+Global.currentScope.edScopeChain());
		Meaning meaning=Global.currentScope.findMeaning(classIdentifier);
		Util.BREAK("LocalObject(" + toString()+").doChecking - Meaning="+meaning);
		Declaration decl = meaning.declaredAs;
		//Util.BREAK("LocalObject.doChecking: decl="+decl+", QUAL="+decl.getClass().getSimpleName());
		if (decl instanceof ClassDeclaration) classDeclaration=(ClassDeclaration)decl;
		else Util.error("LocalObject("+this+") "+classIdentifier+" is not a class");
//		declarationScope=Global.currentScope.findThis(classIdentifier);
//		declarationScope=findThis(Global.currentScope,classIdentifier);
//		declarationScope=findThis(Global.currentScope);
//		declarationScope=findThis();
		findThis();
		
		
		
//		if(declarationScope==null) Util.error("This "+classIdentifier+" -- Is not on static chain.");
		SET_SEMANTICS_CHECKED();
	}

    //***********************************************************************************************
    //*** Utility: findThis  --  Follow Static Chain Looking for a Class named 'classIdentifier'
    //***********************************************************************************************
//	private static DeclarationScope findThis(DeclarationScope thisScope,final String classIdentifier) {
//	private DeclarationScope findThis(DeclarationScope thisScope) {
//	private DeclarationScope findThis() {
	private void findThis() {
		ctxDiff=0;
		DeclarationScope thisScope=Global.currentScope;
		while(thisScope!=null) {
			Util.BREAK("LocalObject.findThis: classIdentifier="+classIdentifier+"): CHECKING "+thisScope+", QUAL="+thisScope.getClass().getSimpleName());

			if (thisScope instanceof ClassDeclaration) {
				if (classIdentifier.equalsIgnoreCase(thisScope.identifier)) return;// (thisScope);
				ClassDeclaration x = (ClassDeclaration) thisScope;
//				if (classIdentifier.equalsIgnoreCase(x.identifier)) return (x);
				while ((x = x.getPrefixClass()) != null) {
					// Util.BREAK("DeclarationScope("+this.identifier+").findThis("+identifier+"): CHECKING "+x);
					if (classIdentifier.equalsIgnoreCase(x.identifier)) {
						//Util.BREAK("DeclarationScope("+this.identifier+").findThis("+identifier+"): Found in "+x);
//						return (x);
						return;// (thisScope);
					}
				}
			} else if (thisScope instanceof ConnectionBlock) {
				ConnectionBlock z = (ConnectionBlock)thisScope;
				ClassDeclaration x = (ClassDeclaration) z.classDeclaration;
				if (classIdentifier.equalsIgnoreCase(x.identifier)) return;// (z);
				while ((x = x.getPrefixClass()) != null) {
					// Util.BREAK("DeclarationScope("+this.identifier+").findThis("+identifier+"): CHECKING "+x);
					if (classIdentifier.equalsIgnoreCase(x.identifier)) return;// (z);
				}
			}
			//    	if(declaredIn!=null) return(declaredIn.findThis(identifier));
//			if(thisScope.declaredIn!=null) return(findThis(thisScope.declaredIn,classIdentifier));
			thisScope=thisScope.declaredIn;
			ctxDiff++;
		}
//		return(null);
		Util.error("This "+classIdentifier+" -- Is not on static chain.");
	}

//    //***********************************************************************************************
//    //*** Utility: findThis  --  Follow Static Chain Looking for a Class named 'classIdentifier'
//    //***********************************************************************************************
//    private static DeclarationScope OLD_findThis(DeclarationScope thisScope,final String classIdentifier) {
//    	// Util.BREAK("DeclarationScope("+this.identifier+").findThis("+identifier+"):");
//    	// Util.BREAK("DeclarationScope("+this.identifier+").findThis("+identifier+"): CHECKING "+this);
//    	//Util.BREAK("DeclarationScope("+this.identifier+").findThis("+identifier+"): CHECKING "+this+", QUAL="+this.getClass().getSimpleName());
//    	if (thisScope instanceof ClassDeclaration) {
//    		ClassDeclaration x = (ClassDeclaration) thisScope;
//    		if (classIdentifier.equalsIgnoreCase(x.identifier)) return (x);
//    		while ((x = x.getPrefixClass()) != null) {
//    			// Util.BREAK("DeclarationScope("+this.identifier+").findThis("+identifier+"): CHECKING "+x);
//    			if (classIdentifier.equalsIgnoreCase(x.identifier)) {
//       			    //Util.BREAK("DeclarationScope("+this.identifier+").findThis("+identifier+"): Found in "+x);
//    				return (x);
//    			}
//    		}
//    	} else if (thisScope instanceof ConnectionBlock) {
//    		ConnectionBlock z = (ConnectionBlock)thisScope;
//    		ClassDeclaration x = (ClassDeclaration) z.classDeclaration;
//    		if (classIdentifier.equalsIgnoreCase(x.identifier)) return (z);
//    		while ((x = x.getPrefixClass()) != null) {
//    			// Util.BREAK("DeclarationScope("+this.identifier+").findThis("+identifier+"): CHECKING "+x);
//    			if (classIdentifier.equalsIgnoreCase(x.identifier)) return (z);
//    		}
//    	}
////    	if(declaredIn!=null) return(declaredIn.findThis(identifier));
//    	if(thisScope.declaredIn!=null) return(OLD_findThis(thisScope.declaredIn,classIdentifier));
//    	return(null);
//    }

	// Returns true if this expression may be used as a statement.
	public boolean maybeStatement() {
		ASSERT_SEMANTICS_CHECKED(this);
		return (false);
	}

	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED(this);
		String cast=classDeclaration.getJavaIdentifier();
//		if(declarationScope instanceof ConnectionBlock)
//		{ ConnectionBlock connectionBlock=(ConnectionBlock)declarationScope;
//		  return ("(("+cast+")"+connectionBlock.inspectedVariable.toJavaCode()+")");
//		}
//		BlockDeclaration scopeDeclaration=(BlockDeclaration)declarationScope;
//		return ("(("+cast+")"+scopeDeclaration.edCTX()+")");

		return ("(("+cast+")"+DeclarationScope.edCTX(ctxDiff)+")");
	}

	public String toString() {
		return ("THIS " + classIdentifier);
	}

}
