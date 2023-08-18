/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass.expression;

import simula.compiler.parsing.Parse;
import simula.compiler.syntaxClass.Type;
import simula.compiler.syntaxClass.declaration.ClassDeclaration;
import simula.compiler.syntaxClass.declaration.ConnectionBlock;
import simula.compiler.syntaxClass.declaration.Declaration;
import simula.compiler.syntaxClass.declaration.DeclarationScope;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * LocalObject i.e. This class expression.
 * 
 * <pre>
 * 
 * Simula Standard: 3.8 Object expressions
 * 
 * local-object = THIS class-identifier
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
 * <p>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/expression/LocalObject.java">
 * <b>Source File</b></a>.
 * 
 * @author Simula Standard
 * @author Øystein Myhre Andersen
 */
public final class LocalObject extends Expression {
	
	/**
	 * The class identifier.
	 */
	private final String classIdentifier;
	
	/**
	 * The class declaration. Set by doChecking.
	 */
	private ClassDeclaration classDeclaration; // Set by doChecking
	
	/**
	 * THIS scope. Set by doChecking.
	 */
	private DeclarationScope thisScope; // Set by doChecking
	
	/**
	 * Context difference. Set by doChecking.
	 */
	private int ctxDiff;  // Set by doChecking

	/**
	 * Create a new LocalObject
	 * @param ident class-identifier
	 */
	private LocalObject(final String ident) {
		this.classIdentifier = ident;
		this.type=Type.Ref(classIdentifier);
		if (Option.TRACE_PARSE)
			Util.TRACE("NEW ThisObjectExpression: " + toString());
	}

	/**
	 * Expect This Identifier.
	 * @return the newly created LocalObject.
	 */
	static Expression expectThisIdentifier() {
		if (Option.TRACE_PARSE)
			Util.TRACE("Parse ThisObjectExpression, current=" + Parse.currentToken);
		String classIdentifier = Parse.expectIdentifier();
		Expression expr = new LocalObject(classIdentifier);
		return(expr);
	}

	@Override
	public void doChecking() { 
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		if (Option.TRACE_CHECKER)
			Util.TRACE("BEGIN LocalObject(" + toString()+").doChecking - Current Scope Chain: "+Global.getCurrentScope().edScopeChain());
		Meaning meaning=Global.getCurrentScope().findMeaning(classIdentifier);
		Declaration decl = meaning.declaredAs;
		if (decl instanceof ClassDeclaration cdecl) classDeclaration=cdecl;
		else Util.error("LocalObject("+this+") "+classIdentifier+" is not a class");
		findThis();
		SET_SEMANTICS_CHECKED();
	}

    //***********************************************************************************************
    //*** Utility: findThis  --  Follow Static Chain Looking for a Class named 'classIdentifier'
    //***********************************************************************************************
	/**
	 * Follow Static Chain Looking for a Class named 'classIdentifier'
	 */
	private void findThis() {
		ctxDiff=0;
		thisScope=Global.getCurrentScope();
		while(thisScope!=null) {
			if (thisScope instanceof ClassDeclaration x) {
				if (Util.equals(classIdentifier, thisScope.identifier)) return;
				while ((x = x.getPrefixClass()) != null) {
					if (Util.equals(classIdentifier, x.identifier)) {
						return;// (thisScope);
					}
				}
			} else if (thisScope instanceof ConnectionBlock z) {
				ClassDeclaration x = (ClassDeclaration) z.classDeclaration;
				if (Util.equals(classIdentifier, x.identifier)) return;
				while ((x = x.getPrefixClass()) != null) {
					if (Util.equals(classIdentifier, x.identifier)) return;
				}
			}
			if(thisScope.declarationKind != Declaration.Kind.CompoundStatement
			&& thisScope.declarationKind != Declaration.Kind.ConnectionBlock) {
				ctxDiff++;
			}
			thisScope=thisScope.declaredIn;
		}
		Util.error("This "+classIdentifier+" -- Is not on static chain.");
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
		String cast = classDeclaration.getJavaIdentifier();
		if (thisScope instanceof ConnectionBlock connectionBlock) {
			return ("((" + cast + ")" + connectionBlock.inspectedVariable.toJavaCode() + ")");
		}
		return ("((" + cast + ")" + DeclarationScope.edCTX(ctxDiff) + ")");
	}

	@Override
	public String toString() {
		return ("THIS " + classIdentifier);
	}

}
