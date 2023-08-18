/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass.declaration;

import java.util.Vector;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.parsing.Parse;
import simula.compiler.syntaxClass.ProtectedSpecification;
import simula.compiler.syntaxClass.Type;
import simula.compiler.syntaxClass.expression.Expression;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Switch Declaration.
 * 
 * <pre>
 * 
 * Simula Standard: 5.3 Switch declaration
 * 
 *  switch-declaration
 *     = SWITCH switch-identifier := switch-list
 *     
 *     switch-list = designational-expression { , designational-expression }
 * </pre>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/declaration/SwitchDeclaration.java">
 * <b>Source File</b></a>.
 *
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 */
public final class SwitchDeclaration extends ProcedureDeclaration {
	
	/**
	 * The switch list of label expressions.
	 */
	Vector<Expression> switchList = new Vector<Expression>();

	/**
	 * Create a new SwitchDeclaration.
	 * @param ident switch identifier
	 */
	public SwitchDeclaration(final String ident) {
		super(ident,Declaration.Kind.Procedure);
		if (Option.TRACE_PARSE)	Parse.TRACE("Parse SwitchDeclaration");
		this.type = Type.Label;
		Parse.expect(KeyWord.ASSIGNVALUE);
		do { switchList.add(Expression.expectExpression());
		} while (Parse.accept(KeyWord.COMMA));
		if (Option.TRACE_PARSE)	Parse.TRACE("Parse SwitchDeclaration(3), switchList=" + switchList);
		new Parameter("_SW", Type.Integer, Parameter.Kind.Simple).into(parameterList);
		Global.setScope(declaredIn);
	}

	@Override
	public void doChecking() {
		super.doChecking();
		externalIdent = edJavaClassName();
		for (Expression expr : switchList) {
			expr.doChecking();
			if(expr.type!=Type.Label) Util.error("Switch element "+expr+" is not a Label");
			expr.backLink = this; // To ensure _RESULT from functions
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
	@Override
	protected void codeProcedureBody() {
		boolean duringSTM_Coding=Global.duringSTM_Coding;
		Global.duringSTM_Coding=true;
		GeneratedJavaClass.debug("// Switch Body");
		GeneratedJavaClass.code("@Override");
		GeneratedJavaClass.code("public " + getJavaIdentifier() + " _STM() {");
		GeneratedJavaClass.code("switch(p__SW-1) {");
		int n = 0;
		for (Expression expr : ((SwitchDeclaration) this).switchList) {
			GeneratedJavaClass.code("case " + (n++) + ": _RESULT=" + expr.toJavaCode() + "; break;");
		}
		GeneratedJavaClass.code("default: throw new RTS_SimulaRuntimeError(\"Illegal switch index: \"+p__SW);");
		GeneratedJavaClass.code("}");
		GeneratedJavaClass.code("EBLK();");
		GeneratedJavaClass.code("return(this);");
		GeneratedJavaClass.code("}","End of Switch BODY");
		Global.duringSTM_Coding=duringSTM_Coding;
	}

	@Override
	public String toString() {
		return ("SWITCH " + identifier + " := " + switchList);
	}
	

	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	/**
	 * Default constructor used by Externalization.
	 */
	public SwitchDeclaration() { super(null, Declaration.Kind.Procedure); }

	// Inherited from ProcedureDeclaration:
	//	public void writeExternal(ObjectOutput oupt) throws IOException {
	//	public void readExternal(ObjectInput inpt) throws IOException, ClassNotFoundException {


}
