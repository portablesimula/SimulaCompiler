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
 * Object relations
 * 
 * <pre>
 *  ObjectRelation
 *        =  SimpleObjectExpression  IS  ClassIdentifier
 *        |  SimpleObjectExpression  IN  ClassIdentifier
 *        
 *  QualifiedObject
 *        =  SimpleObjectExpression  QUA  ClassIdentifier
 * </pre>
 * 
 * The operators IS and IN may be used to test the class membership of an
 * object.
 * <p>
 * The relation "X IS C" has the value true if X refers to an object belonging
 * to the class C, otherwise the value is false.
 * <p>
 * The relation "X IN C" has the value true if X refers to an object belonging
 * to a class C or a class inner to C, otherwise the value is false.
 * 
 * <p>
 * The qualification of an object expression is defined by the following rules:
 * <ul>
 * <li>The expression none is qualified by a fictitious class which is inner to
 * all declared classes.
 * 
 * <li>A variable or function designator is qualified as stated in the
 * declaration (or specification, see below) of the variable or array or
 * procedure in question.
 * 
 * <li>An object generator, local object or qualified object is qualified by the
 * class of the identifier following the symbol new, this or qua respectively.
 * 
 * <li>A conditional object expression is qualified by the innermost class which
 * includes the qualifications of both alternatives. If there is no such class,
 * the expression is illegal.
 * 
 * <li>Any formal parameter of object reference type is qualified according to
 * its specification regardless of the qualification of the corresponding actual
 * parameter.
 * 
 * <li>The qualification of a function designator whose procedure identifier is
 * that of a virtual quantity depends on the access level (see 5.5.5). The
 * qualification is that of the matching declaration, if any, occurring at the
 * innermost prefix level equal or outer to the access level, or, if no such
 * match exists, it is that of the virtual specification.
 * </ul>
 * 
 * @author Øystein Myhre Andersen
 */
public class ObjectRelation extends Expression
{ public Expression lhs;
  public KeyWord opr;
  public String classIdentifier;
  BlockDeclaration classDeclaration; // Set by doChecking

  
  public ObjectRelation(Expression lhs,KeyWord opr,String classIdentifier)
  { this.lhs=lhs; this.opr=opr; this.classIdentifier=classIdentifier;
    lhs.backLink=this;
  }
  
  public void doChecking()
  { if(IS_SEMANTICS_CHECKED()) return;
   	Util.setLine(lineNumber);
	if(Option.TRACE_CHECKER) Util.TRACE("BEGIN ObjectRelation"+toString()+".doChecking - Current Scope Chain: "+Global.currentScope.edScopeChain());
	classDeclaration=getQualification(classIdentifier);
	// Object IS ClassIdentifier   |   Object IN ClassIdentifier
	//Util.BREAK("ObjectRelation.doChecking:"+lhs+" "+opr+" "+rhs);
	lhs.doChecking(); 
	Type type1=lhs.type;
    String refIdent=type1.getRefIdent();
    if(refIdent==null)
    	Util.error("ObjectRelation.doChecking: The Variable "+lhs+" is not ref() type");
	    
    //Util.BREAK("ObjectRelation.doChecking: lhs="+lhs+", Qual="+lhs.getClass().getSimpleName());
    //Util.BREAK("ObjectRelation.doChecking: rhs="+rhs+", Qual="+rhs.getClass().getSimpleName());
		
	if(!checkCompatability(lhs,classIdentifier))
		   Util.warning("IS/IN is always FALSE -- " + classIdentifier	+ " is not compatible with " + refIdent);
	this.type=Type.Boolean;
	//  Debug.BREAK("ObjectRelation.doChecking: "+oprCode);
	if(Option.TRACE_CHECKER) Util.TRACE("END ObjectRelation"+toString()+".doChecking - Result type="+this.type);
	SET_SEMANTICS_CHECKED();
  }


  public String toJavaCode()
  { //Util.BREAK("ObjectRelation.toJavaCode: "+this);
	ASSERT_SEMANTICS_CHECKED(this);
	if(opr==KeyWord.IN)	{
		if(!checkCompatability(lhs,classIdentifier)) return("false"); // warning("IS/IN is always FALSE
	    return(lhs.get()+opr.toJavaCode()+classDeclaration.getJavaIdentifier());
	} else if(opr==KeyWord.IS) {
		if(!checkCompatability(lhs,classIdentifier)) return("false"); // warning("IS/IN is always FALSE
		return("IS$("+lhs.get()+","+classDeclaration.getJavaIdentifier()+".class)");
	} else { Util.FATAL_ERROR("Impossible"); return(""); }
  }
  

  public String toString()
  { return("("+lhs+' '+opr+' '+classIdentifier+")"); }

}
