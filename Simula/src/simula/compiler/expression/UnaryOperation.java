/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.expression;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Unary Operation.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 *   UnaryOperation =  operation  Expression
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public final class UnaryOperation extends Expression {
	private KeyWord oprator;
	private Expression operand;
	  
	  public static Expression newUnaryOperation(KeyWord oprator,Expression operand) {
//		  Util.BREAK("UnaryOperation.NEW: lhs="+lhs+", QUAL="+lhs.getClass().getSimpleName());
//		  Util.BREAK("UnaryOperation.NEW: oprator="+oprator);
//		  Util.BREAK("UnaryOperation.NEW: operand="+operand+", QUAL="+operand.getClass().getSimpleName());

		  if (oprator == KeyWord.NOT) {
			  
		  }
		  else if (oprator == KeyWord.PLUS || oprator == KeyWord.MINUS) {
			  Number rhn=Constant.getNumber(operand);
			  if(rhn!=null) {
				  //Util.BREAK("UnaryOperation.NEW: rhn="+rhn+", QUAL="+rhn.getClass().getSimpleName());
				  //Util.BREAK("UnaryOperation.Evaluate: "+lhs+' '+oprator+' '+operand);
				  return(Constant.evaluate(oprator,rhn));
			  }  
		  }
		  return(new UnaryOperation(oprator,operand));
	  }

	private UnaryOperation(KeyWord oprator, Expression operand) {
		//Util.BREAK("NEW UnaryOperation: "+oprator+' '+operand);
		this.oprator = oprator;
		this.operand = operand;
		if(this.operand==null)
		{ Util.error("Missing operand after unary "+oprator);
		  this.operand=new Variable("UNKNOWN$");
		}
		this.operand.backLink=this;
		//Util.BREAK("NEW UnaryOperation: "+toString());
	}

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		if (Option.TRACE_CHECKER)
			Util.TRACE("BEGIN UnaryOperation" + toString()
					+ ".doChecking - Current Scope Chain: "
					+ Global.currentScope.edScopeChain());
		operand.doChecking();
		if (oprator == KeyWord.NOT)
			this.type=Type.Boolean;
		else if (oprator == KeyWord.PLUS || oprator == KeyWord.MINUS) {
			this.type=operand.type;
		}
		SET_SEMANTICS_CHECKED();
	}

	  // Returns true if this expression may be used as a statement.
	  public boolean maybeStatement()
	  {	ASSERT_SEMANTICS_CHECKED(this);
		return(false);  
	  }

	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED(this);
		return ("(" + oprator.toJavaCode() + "(" + operand.toJavaCode() + "))");
	}

	public String toString() {
		return ("(UNARY:" + oprator + ' ' + operand + ")");
	}

}
