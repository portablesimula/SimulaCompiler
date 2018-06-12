/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.expression;

import simula.compiler.declaration.ArrayDeclaration;
import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.Parameter;
import simula.compiler.declaration.TypeDeclaration;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Assignment Operation.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 *   AssignmentOperation = Expression  AssignmentOperator  Expression
 *   
 *		AssignmentOperator =  :=  |  :-
 *   
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public class AssignmentOperation extends Expression
{ public Expression lhs;
  public KeyWord opr;
  public Expression rhs;
  private boolean textValueAssignment=false; // Set by doChecking

  
  public AssignmentOperation(Expression lhs,KeyWord opr,Expression rhs)
  { this.lhs=lhs; this.opr=opr; this.rhs=rhs;
    lhs.backLink=rhs.backLink=this;
  }

  public void doChecking()
  { if(IS_SEMANTICS_CHECKED()) return;
   	Global.sourceLineNumber=lineNumber;
	if(Option.TRACE_CHECKER) Util.TRACE("BEGIN Assignment"+toString()+".doChecking - Current Scope Chain: "+Global.currentScope.edScopeChain());
	doAssignmentChecking(opr);
	SET_SEMANTICS_CHECKED();
  }


  public void doAssignmentChecking(KeyWord keyWord)
  { lhs.doChecking(); Type toType=lhs.type;
    if(lhs instanceof Variable)
    { Variable var=(Variable)lhs;
      Meaning meaning=var.getMeaning();
      if(meaning.declaredAs instanceof TypeDeclaration)
      { TypeDeclaration dcl=(TypeDeclaration)meaning.declaredAs;
        if(dcl.isConstant()) Util.error("Assignment to Constant: '"+lhs+"' is Illegal");
      }
    }
    rhs.doChecking(); Type fromType=rhs.type;
	//if(DEBUG) Util.log("doAssignmentChecking("+toString()+").doChecking - ("+toType+' '+keyWord+' '+fromType+")");
	//if(DEBUG) Util.log("doAssignmentChecking: operator: "+keyWord);
	if(keyWord==KeyWord.ASSIGNVALUE) this.textValueAssignment=(toType==Type.Text);
	rhs=(Expression)TypeConversion.testAndCreate(toType,rhs);
	this.type=toType;
	//Util.BREAK("doAssignmentChecking: CHECKED("+toString()+").doChecking - Result type="+this.type+"("+toType+' '+keyWord+' '+fromType+")");
	if(this.type==null) Util.error("doAssignmentChecking: Illegal types: "+toType+" := "+fromType);
  }

	  
  public String toJavaCode()
  { //Util.BREAK("Assignment.toJavaCode: "+this);
	ASSERT_SEMANTICS_CHECKED(this);
	return(doCodeAssignment());
  }

  // ***********************************************************************
  // *** CODE: doCodeTextValueAssignment
  // ***********************************************************************
  private String doCodeTextValueAssignment()
  { StringBuilder s=new StringBuilder();
    //Util.BREAK("Assignment.doCodeTextValueAssignment: rhs="+rhs+", qual="+rhs.getClass().getSimpleName());
    if(rhs instanceof Constant)
    { Object value=((Constant)rhs).value;
      //Util.BREAK("Assignment.doCodeTextValueAssignment: value="+value);
      if(value!=null)
      { //Util.BREAK("Assignment.doCodeTextValueAssignment: value="+value+", qual="+value.getClass().getSimpleName());
        s.append("ASGSTR$(").append(lhs.toJavaCode()).append(",\"").append(value).append("\")");
        //Util.BREAK("Assignment.doCodeTextValueAssignment: result="+s.toString());
    	return(s.toString()); 
      }
    }
    s.append("ASGTXT$(").append(lhs.toJavaCode()).append(',').append(rhs.toJavaCode()).append(')');
	return(s.toString());  
  }
  

  // ***********************************************************************
  // *** CODE: doCodeAssignment   -- TODO: FJERNES / RETTES // 
  // ***********************************************************************
  private String doCodeAssignment()
  { StringBuilder s=new StringBuilder();
	if(this.textValueAssignment) s.append(doCodeTextValueAssignment());
	else
	{ //Util.BREAK("Assignment.doCodeAssignment: lhs="+lhs+", qual="+lhs.getClass().getSimpleName());
	  //Util.BREAK("Assignment.doCodeAssignment: rhs="+rhs+", qual="+rhs.getClass().getSimpleName());
	  
//	  // -------------------------------------------------------------------------
//	  // CHECK FOR SPECIAL CASE:
//	  //     <Array> := <Expression-2> ;
//	  // SHOULD BE CODED AS:
//	  //     ARRAY.put(x1,x2,<Expression-2>) ;
//	  // -------------------------------------------------------------------------
//	  //Util.BREAK("Assignment.doCodeAssignment: afterDot="+afterDot+", qual="+afterDot.getClass().getSimpleName());
//	  if(lhs instanceof SubscriptedVariable)
//	  { Declaration decl=((SubscriptedVariable)lhs).declaredAs;
//	    Util.BREAK("Assignment.doCodeAssignment20: decl="+decl+", qual="+decl.getClass().getSimpleName());
//	    if(decl instanceof ArrayDeclaration) return(doCodeArrayAssignment((SubscriptedVariable)lhs,false));
//	    else if(decl instanceof Parameter)
//	    { Parameter par=(Parameter)decl;
//		  Util.BREAK("Assignment.doCodeAssignment21: par="+par+", qual="+par.getClass().getSimpleName());
//		  if(par.kind==Kind.Array) return(doCodeArrayAssignment((SubscriptedVariable)lhs,par.mode==Mode.name));
//	    }
//	  }
	  
	  
//	  // -------------------------------------------------------------------------
//	  // CHECK FOR SPECIAL CASE:
//	  //     <Expression-1> DOT <Array> := <Expression-2> ;
//	  // SHOULD BE CODED AS:
//	  //     <Expression-1> . ARRAY.put(x1,x2,<Expression-2>) ;
//	  // -------------------------------------------------------------------------
//	  if(lhs instanceof Assignment && ((Assignment)lhs).opr==KeyWord.DOT)
//	  { Expression afterDot=((Assignment)lhs).rhs;
//		//Util.BREAK("Assignment.doCodeAssignment: afterDot="+afterDot+", qual="+afterDot.getClass().getSimpleName());
//		if(afterDot instanceof SubscriptedVariable)
//		{ Declaration decl=((SubscriptedVariable)afterDot).declaredAs;
//		  Util.BREAK("Assignment.doCodeAssignment30: decl="+decl+", qual="+decl.getClass().getSimpleName());
// 	      Expression beforeDot=((Assignment)lhs).lhs;
//		  if(decl instanceof ArrayDeclaration) return(doRemoteArrayAssignment(beforeDot,(SubscriptedVariable)afterDot,false));
//		  else if(decl instanceof Parameter)
//		  { Parameter par=(Parameter)decl;
//			Util.BREAK("Assignment.doCodeAssignment31: par="+par+", qual="+par.getClass().getSimpleName());
//			if(par.kind==Kind.Array) return(doRemoteArrayAssignment(beforeDot,(SubscriptedVariable)afterDot,par.mode==Mode.name));
//		  }
//		}
//	  }
	  // -------------------------------------------------------------------------
	  // CHECK FOR SPECIAL CASE:
	  //     OBJECT DOT ARRAY(x1,x2,...) := Expression ;
	  // SHOULD BE CODED LIKES:
	  //     <Expression-1> . ARRAY.put(x1,x2,<Expression-2>) ;
	  //     OBJECT . ARRAY.A[x+9- OBJECT.ARRAY.LB[0]]=134;
	  // -------------------------------------------------------------------------
//	  if(lhs instanceof Assignment && ((Assignment)lhs).opr==KeyWord.DOT)
//	  { Expression afterDot=((Assignment)lhs).rhs;
	  if(lhs instanceof RemoteVariable)
	  { Expression afterDot=((RemoteVariable)lhs).rhs;
		//Util.BREAK("Assignment.doCodeAssignment: afterDot="+afterDot+", qual="+afterDot.getClass().getSimpleName());
		if(afterDot instanceof SubscriptedVariable)
		{ Declaration decl=((SubscriptedVariable)afterDot).meaning.declaredAs;
		  //Util.BREAK("Assignment.doCodeAssignment30: decl="+decl+", qual="+decl.getClass().getSimpleName());
 	      Expression beforeDot=((RemoteVariable)lhs).lhs;
		  if(decl instanceof ArrayDeclaration) return(assignToRemoteArray(beforeDot,(SubscriptedVariable)afterDot,rhs));
		  else if(decl instanceof Parameter)
		  { Parameter par=(Parameter)decl;
			//Util.BREAK("Assignment.doCodeAssignment31: par="+par+", qual="+par.getClass().getSimpleName());
			if(par.kind==Parameter.Kind.Array) return(assignToRemoteArray(beforeDot,(SubscriptedVariable)afterDot,rhs));
		  }
		  
		}
	  }
	  s.append(lhs.put(rhs.get()));
	}
//	Util.BREAK("Assignment.doCodeAssignment: "+this+" ==> "+s);
	return(s.toString());
  }
  
  
  // ***********************************************************************
  // *** CODE: assignToRemoteArray
  // ***********************************************************************
  private String assignToRemoteArray(Expression beforeDot,SubscriptedVariable array,Expression rhs)
  { String lhs=doAccessRemoteArray(beforeDot,(SubscriptedVariable)array);
	String asg=lhs+'='+rhs.toJavaCode();
	return(asg);
  }
  
  // ***********************************************************************
  // *** CODE: doAccessRemoteArray 
  // ***********************************************************************
  private String doAccessRemoteArray(Expression beforeDot,SubscriptedVariable array)
  { StringBuilder s=new StringBuilder();
	int nDim=0;
	// Generate: obj.M.A[6-obj.M.LB[1]];
	String obj=beforeDot.toJavaCode();
    String remoteIdent=obj+'.'+array.edVariable(true);
    StringBuilder ixs=new StringBuilder();
    String dimBrackets="";
	for(Expression ix:array.checkedParams) {
		String index="["+ix.toJavaCode()+"-"+remoteIdent+".LB["+(nDim++)+"]]";
		ixs.append(index);
		dimBrackets=dimBrackets+"[]";
	}
	String eltType=type.toJavaType();
	String cast="$ARRAY<"+eltType+dimBrackets+">";
	String castedVar="(("+cast+")"+remoteIdent+")";
	s.append(castedVar).append(".Elt").append(ixs);

	return(s.toString());
  }

  public String toString()
  { return("("+lhs+' '+opr+' '+rhs+")"); }

}
