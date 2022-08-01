/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import java.util.Vector;

import simula.compiler.GeneratedJavaClass;
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
	Vector<Expression> switchList = new Vector<Expression>();

	public SwitchDeclaration(final String ident) {
		super(ident,Declaration.Kind.Procedure);
		if (Option.TRACE_PARSE)	Parser.TRACE("Parse SwitchDeclaration");
		this.type = Type.Label;
		Parser.expect(KeyWord.ASSIGNVALUE);
		do { switchList.add(Expression.parseExpression());
		} while (Parser.accept(KeyWord.COMMA));
		if (Option.TRACE_PARSE)	Parser.TRACE("Parse SwitchDeclaration(3), switchList=" + switchList);
		new Parameter("$SW", Type.Integer, Parameter.Kind.Simple).into(parameterList);
//		Global.currentScope = declaredIn;
		Global.setScope(declaredIn);
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
				((ClassDeclaration)declaredIn).protectedList.add(new ProtectedSpecification((ClassDeclaration)Global.getCurrentScope(),identifier));
		}
	}

	// ***********************************************************************************************
	// *** Coding Utility: doCodeSwitchBody
	// ***********************************************************************************************
	public void codeProcedureBody() {
		GeneratedJavaClass.debug("// Switch Body");
		GeneratedJavaClass.code("public " + getJavaIdentifier() + " STM$() {");
		GeneratedJavaClass.code("switch(p$$SW-1) {");
		int n = 0;
		for (Expression expr : ((SwitchDeclaration) this).switchList) {
			GeneratedJavaClass.code("case " + (n++) + ": RESULT$=" + expr.toJavaCode() + "; break;");
		}
		GeneratedJavaClass.code("default: throw new SimulaRuntimeError(\"Illegal switch index: \"+p$$SW);");
		GeneratedJavaClass.code("}");
		GeneratedJavaClass.code("EBLK();");
		GeneratedJavaClass.code("return(this);");
		GeneratedJavaClass.code("}","End of Switch BODY");
	}

	public String toString() {
		return ("SWITCH " + identifier + " := " + switchList);
	}
	

	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	public SwitchDeclaration() { super(null, Declaration.Kind.Procedure); }

	// Inherited from ProcedureDeclaration:
	//	public void writeExternal(ObjectOutput oupt) throws IOException {
	//	public void readExternal(ObjectInput inpt) throws IOException, ClassNotFoundException {


}
