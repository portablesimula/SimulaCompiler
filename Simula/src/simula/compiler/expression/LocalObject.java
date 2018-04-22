/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.expression;

import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.BlockDeclaration;
import simula.compiler.expression.Expression;
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.Global;
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
 * @author Øystein Myhre Andersen
 */
public class LocalObject extends Expression {
	private String classIdentifier;
	private BlockDeclaration classDeclaration; // Set by doChecking

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
		if (IS_SEMANTICS_CHECKED())
			return;
		Util.setLine(lineNumber);
		if (Option.TRACE_CHECKER)
			Util.TRACE("BEGIN LocalObject(" + toString()
					+ ").doChecking - Current Scope Chain: "
					+ Global.currentScope.edScopeChain());
		Declaration decl = Global.currentScope.findMeaning(classIdentifier).declaredAs;
		Util.BREAK("LocalObject.doChecking: findMeaning("+classIdentifier+") declaredAs="+decl);
//		if (classDeclaration instanceof BlockDeclaration)
		if (decl instanceof BlockDeclaration) classDeclaration=(BlockDeclaration)decl;
		else Util.error("LocalObject("+this+") "+classIdentifier+" is not a class");
		SET_SEMANTICS_CHECKED();
	}

	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED(this);
		if(classDeclaration.blockLevel!=Global.currentScope.blockLevel)
			 return ("((" + classDeclaration.getJavaIdentifier() + ")"+Global.currentScope.edCTX(classDeclaration.blockLevel)+")");
		else return ("(" + classDeclaration.getJavaIdentifier() + ".this)");
	}

	public String toString() {
		return ("THIS " + classIdentifier);
	}

}
