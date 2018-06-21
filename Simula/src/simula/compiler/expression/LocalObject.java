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
import simula.compiler.declaration.BlockDeclaration;
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
public class LocalObject extends Expression {
	private String classIdentifier;
	private BlockDeclaration classDeclaration; // Set by doChecking
	private DeclarationScope declarationScope; // Set by doChecking

	private LocalObject(String classIdentifier) {
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
		if (Option.TRACE_CHECKER)
			Util.TRACE("BEGIN LocalObject(" + toString()+").doChecking - Current Scope Chain: "+Global.currentScope.edScopeChain());
		Meaning meaning=Global.currentScope.findMeaning(classIdentifier);
		Declaration decl = meaning.declaredAs;
		if (decl instanceof BlockDeclaration) classDeclaration=(BlockDeclaration)decl;
		else Util.error("LocalObject("+this+") "+classIdentifier+" is not a class");
		declarationScope=Global.currentScope.findThis(classIdentifier);
		if(declarationScope==null) Util.error("This "+classIdentifier+" -- Is not on static chain.");
		SET_SEMANTICS_CHECKED();
	}

	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED(this);
		String cast=classDeclaration.getJavaIdentifier();
		if(declarationScope instanceof ConnectionBlock)
		{ ConnectionBlock connectionBlock=(ConnectionBlock)declarationScope;
//		  return ("(("+cast+")"+connectionBlock.inspectedVariable.getJavaIdentifier()+")");
		  return ("(("+cast+")"+connectionBlock.inspectedVariable.toJavaCode()+")");
		}
		BlockDeclaration classDeclaration=(BlockDeclaration)declarationScope;
		if(classDeclaration.blockLevel!=Global.currentScope.blockLevel)
//			 return ("(("+cast+")"+Global.currentScope.edCTX(classDeclaration.blockLevel)+")");
			 return ("(("+cast+")"+classDeclaration.edCTX()+")");
		else return ("("+cast+".this)");
	}

	public String toString() {
		return ("THIS " + classIdentifier);
	}

}
