/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import java.util.Vector;

import simula.compiler.expression.Expression;
import simula.compiler.expression.TypeConversion;
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
public class SwitchDeclaration extends BlockDeclaration // Declaration
{
	Vector<Expression> switchList = new Vector<Expression>();

	public SwitchDeclaration() {
		super(expectIdentifier(), BlockDeclaration.Kind.Procedure);
		if (Option.TRACE_PARSE)
			Parser.TRACE("Parse SwitchDeclaration");
		this.type = Type.Label;
		Parser.expect(KeyWord.ASSIGNVALUE);
		do {
			switchList.add(Expression.parseExpression());
		} while (Parser.accept(KeyWord.COMMA));
		if (Option.TRACE_PARSE)
			Parser.TRACE("Parse SwitchDeclaration(3), switchList=" + switchList);
		this.addParameter(new Parameter("$SW", Type.Integer, Parameter.Kind.Simple));
		Global.currentScope = declaredIn;
		// Util.BREAK("NEW SwitchDeclaration: blockKind=" + blockKind);
	}

	public void doChecking() {
		super.doChecking();
		externalIdent = edJavaClassName();
		for (Expression expr : switchList) {
			expr.doChecking();
			expr.backLink = this; // To ensure $result from functions
		}
	}

	// ***********************************************************************************************
	// *** Coding Utility: doCodeSwitchBody
	// ***********************************************************************************************
	public void codeProcedureBody(String indent) {
		Util.code(indent + "   // Switch Body");
		Util.code(indent + "   public " + getJavaIdentifier() + " STM() {");
		Util.code(indent + "      switch(p$$SW-1) {");
		int n = 0;
		for (Expression expr : ((SwitchDeclaration) this).switchList) {
			// Util.BREAK("BlockDeclaration.doCodeSwitchBody: expr="+expr+", Type="+expr.type+", Qual="+expr.getClass().getSimpleName());
			Expression labQuant = TypeConversion.testAndCreate(Type.Label, expr); // TODO: MÅ SJEKKES - ER DETTE NØDVENDIG ?
			labQuant.doChecking();
			Util.code(indent + "        case " + (n++) + ": $result=" + labQuant.toJavaCode() + "; break;");
		}
		Util.code(indent + "        default: throw new RuntimeException(\"Illegal switch index: \"+p$$SW);");
		Util.code(indent + "      }");
		Util.code(indent + "      EBLK();");
		Util.code(indent + "      return(this);");
		Util.code(indent + "   } // End of Switch BODY");
	}

	public String toString() {
		return ("SWITCH " + identifier + " := " + switchList);
	}
}
