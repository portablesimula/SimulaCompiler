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
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;

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
public class SwitchDeclaration extends BlockDeclaration //Declaration
{ Vector<Expression> switchList=new Vector<Expression>();

  public SwitchDeclaration()
  { super(expectIdentifier(),BlockDeclaration.Kind.Switch);
	if(Option.TRACE_PARSE) Parser.TRACE("Parse SwitchDeclaration");
	this.type=Type.LabelQuantity;
	Parser.expect(KeyWord.ASSIGNVALUE);
	do { switchList.add(Expression.parseExpression()); } while( Parser.accept(KeyWord.COMMA) );      
	if(Option.TRACE_PARSE) Parser.TRACE("Parse SwitchDeclaration(3), switchList="+switchList);
//    this.parameterList.add(new Parameter("$SW",Type.Integer,Parameter.Kind.Simple));
    this.addParameter(new Parameter("$SW",Type.Integer,Parameter.Kind.Simple));
    Global.currentScope=declaredIn;
  }

  public void doChecking()
  { super.doChecking();
	for(Expression expr:switchList)
	{ expr.doChecking();
	  expr.backLink=this; // To ensure $result from functions
	}
  }
  
  public String toString()
  {	return ("SWITCH " + identifier + " := " + switchList); }
}
