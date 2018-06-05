/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.expression;

import simula.compiler.declaration.BlockDeclaration;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Binary Operation.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 *   BinaryOperation = Expression  operator  Expression
 *   
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public class BinaryISINQUAOperation extends Expression
{ public Expression lhs;
  public KeyWord opr;
  public String classIdentifier;
  BlockDeclaration classDeclaration; // Set by doChecking

  
  public BinaryISINQUAOperation(Expression lhs,KeyWord opr,String classIdentifier)
  { this.lhs=lhs; this.opr=opr; this.classIdentifier=classIdentifier;
    //Util.BREAK("new BinaryOperation: lhs="+lhs);
    //Util.BREAK("new BinaryOperation: opr="+opr);
    //Util.BREAK("new BinaryOperation: rhs="+rhs);
    lhs.backLink=this;
	//Util.BREAK("NEW BinaryOperation: "+toString());
  }

  
  public boolean isRemoteVariable() { return(false); }
  public Variable getVariable() { return(null); }
  
  public void doChecking()
  { if(IS_SEMANTICS_CHECKED()) return;
   	Util.setLine(lineNumber);
	if(Option.TRACE_CHECKER) Util.TRACE("BEGIN BinaryOperation"+toString()+".doChecking - Current Scope Chain: "+Global.currentScope.edScopeChain());
	//Util.BREAK("BEGIN BinaryOperation"+toString()+".doChecking - Current Scope Chain: "+currentScope.edScopeChain());

	classDeclaration=getQualification(classIdentifier);

	switch(opr)
	{
	  case IS: case IN:
	  { // Object IS ClassIdentifier   |   Object IN ClassIdentifier
		//Util.BREAK("BinaryOperation.doChecking:"+lhs+" "+opr+" "+rhs);
		lhs.doChecking(); 
		Type type1=lhs.type;
	    String refIdent=type1.getRefIdent();
	    if(refIdent==null)
	    	Util.error("BinaryOperation.doChecking: The Variable "+lhs+" is not ref() type");
	    
	    //Util.BREAK("BinaryOperation.doChecking: lhs="+lhs+", Qual="+lhs.getClass().getSimpleName());
	    //Util.BREAK("BinaryOperation.doChecking: rhs="+rhs+", Qual="+rhs.getClass().getSimpleName());
		
		if(!checkCompatability(lhs,classIdentifier))
			   Util.warning("IS/IN is always FALSE -- " + classIdentifier	+ " is not compatible with " + refIdent);
		this.type=Type.Boolean;
		//  Debug.BREAK("BinaryOperation.doChecking: "+oprCode);
		break;
	  }
	  case QUA:
	  { lhs.doChecking();
		if(!checkCompatability(lhs,classIdentifier))
			Util.error("Illegal Object Expression: "+lhs+" is not compatible with "+classIdentifier);
		this.type=new Type(classIdentifier);
		break;
	  }
	  default:
			Util.NOT_IMPLEMENTED("BinaryOperation -- Util.error(Something went wrong) opr="+opr);
			this.type=lhs.type;  // TODO  TEMP
	}
	if(Option.TRACE_CHECKER) Util.TRACE("END BinaryOperation"+toString()+".doChecking - Result type="+this.type);
	SET_SEMANTICS_CHECKED();
  }


  public String toJavaCode()
  { //Util.BREAK("BinaryOperation.toJavaCode: "+this);
	ASSERT_SEMANTICS_CHECKED(this);
	switch(opr)
	{ case QUA:
	  { String result="((" + classDeclaration.getJavaIdentifier() + ")(" + lhs.get() + "))";
	    // Util.BREAK("BinaryOperation.toJavaCode: "+this+", ==> "+result);
	    return(result);
	  }
	  case IN:
	  {	if(!checkCompatability(lhs,classIdentifier)) return("false"); // warning("IS/IN is always FALSE
		return(lhs.get()+opr.toJavaCode()+classDeclaration.getJavaIdentifier());
	  }
	  case IS:
	  {	if(!checkCompatability(lhs,classIdentifier)) return("false"); // warning("IS/IN is always FALSE
		return("IS$("+lhs.get()+","+classDeclaration.getJavaIdentifier()+".class)");
	  }
	  default: Util.FATAL_ERROR("Impossible"); return("");
	}
  }
  

  public String toString()
  { return("("+lhs+' '+opr+' '+classIdentifier+")"); }

}
