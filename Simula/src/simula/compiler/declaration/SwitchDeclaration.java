/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import java.util.Vector;

import simula.compiler.JavaModule;
import simula.compiler.expression.Expression;
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Switch Declaration.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 *  SwitchDeclaration
 *     = SWITCH SwitchIdentifier := DesignationalExpression { , DesignationalExpression }
 * </pre>
 *
 * @see simula.compiler.expression.ConditionalExpression
 * @author Øystein Myhre Andersen
 */
public final class SwitchDeclaration extends ProcedureDeclaration {
	final Vector<Expression> switchList = new Vector<Expression>();

	public SwitchDeclaration(final String ident) {
		super(ident,Declaration.Kind.Procedure);
		if (Option.TRACE_PARSE)	Parser.TRACE("Parse SwitchDeclaration");
		this.type = Type.Label;
		Parser.expect(KeyWord.ASSIGNVALUE);
		do { switchList.add(Expression.parseExpression());
		} while (Parser.accept(KeyWord.COMMA));
		if (Option.TRACE_PARSE)	Parser.TRACE("Parse SwitchDeclaration(3), switchList=" + switchList);
		new Parameter("$SW", Type.Integer, Parameter.Kind.Simple).into(parameterList);
		Global.currentScope = declaredIn;
	}

	public void doChecking() {
		super.doChecking();
		externalIdent = edJavaClassName();
		for (Expression expr : switchList) {
			expr.doChecking();
			if(expr.type!=Type.Label) Util.error("Switch element "+expr+" is not a Label");
			expr.backLink = this; // To ensure RESULT$ from functions
		}
		VirtualSpecification virtSpec=VirtualSpecification.getVirtualSpecification(this);
		if(virtSpec==null) {
			// Switch attributes are implicit specified 'protected'
			if(declaredIn.declarationKind==Declaration.Kind.Class)
				((ClassDeclaration)declaredIn).protectedList.add(new ProtectedSpecification((ClassDeclaration)Global.currentScope,identifier));
		}
	}

	// ***********************************************************************************************
	// *** Coding Utility: doCodeSwitchBody
	// ***********************************************************************************************
	public void codeProcedureBody() {
		JavaModule.debug("// Switch Body");
		JavaModule.code("public " + getJavaIdentifier() + " STM$() {");
		JavaModule.code("switch(p$$SW-1) {");
		int n = 0;
		for (Expression expr : ((SwitchDeclaration) this).switchList) {
			JavaModule.code("case " + (n++) + ": RESULT$=" + expr.toJavaCode() + "; break;");
		}
		JavaModule.code("default: throw new RuntimeException(\"Illegal switch index: \"+p$$SW);");
		JavaModule.code("}");
		JavaModule.code("EBLK();");
		JavaModule.code("return(this);");
		JavaModule.code("}","End of Switch BODY");
	}

	public String toString() {
		return ("SWITCH " + identifier + " := " + switchList);
	}
}
