/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass.expression;

import simula.compiler.syntaxClass.Type;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Unary Operation.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 *   unary-operation =  unary-operator  Expression
 *   
 *      unary-operator = NOT | + | -
 * </pre>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/expression/UnaryOperation.java">
 * <b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 */
final class UnaryOperation extends Expression {
	
	/**
	 * The unary operator.
	 */
	final KeyWord oprator;
	
	/**
	 * The operand Expression.
	 */
	Expression operand;

	/**
	 * Create a new UnaryOperation.
	 * @param oprator the unary operator.
	 * @param operand the operand Expression
	 */
	private UnaryOperation(final KeyWord oprator,final Expression operand) {
		this.oprator = oprator;
		this.operand = operand;
		if(this.operand==null)
		{ Util.error("Missing operand after unary "+oprator);
		  this.operand=new VariableExpression("UNKNOWN_");
		}
		this.operand.backLink=this;
	}

	/**
	 * Create a new UnaryOperation.
	 * @param oprator the unary operator.
	 * @param operand the operand Expression
	 * @return the newly created UnaryOperation
	 */
	static Expression create(final KeyWord oprator,final Expression operand) {
		if (oprator == KeyWord.PLUS || oprator == KeyWord.MINUS) {
			try { // Try to Compile-time Evaluate this expression
				Number rhn=operand.getNumber();
				if(rhn!=null) {
					return(Constant.evaluate(oprator,rhn));
				}  
			} catch(Exception e) {}
		}
		return(new UnaryOperation(oprator,operand));
	}
	
	@Override
	public Expression evaluate() {
		// Try to Compile-time Evaluate this expression
		if (oprator == KeyWord.PLUS || oprator == KeyWord.MINUS) {
			//System.out.println("UnaryOperation.evaluate: "+oprator+", operand="+operand);
			Number rhn=operand.getNumber();
			if(rhn!=null) {
				return(Constant.evaluate(oprator,rhn));
			}  
		}
		return(this);
	}

	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		if (Option.TRACE_CHECKER)
			Util.TRACE("BEGIN UnaryOperation" + toString() + ".doChecking - Current Scope Chain: " + Global.getCurrentScope().edScopeChain());
		operand.doChecking();
		if (oprator == KeyWord.NOT)
			this.type=Type.Boolean;
		else if (oprator == KeyWord.PLUS || oprator == KeyWord.MINUS) {
			this.type=operand.type;
		}
		SET_SEMANTICS_CHECKED();
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
		return ("(" + oprator.toJavaCode() + "(" + operand.toJavaCode() + "))");
	}

	@Override
	public String toString() {
		return ("(UNARY:" + oprator + ' ' + operand + ")");
	}

}
