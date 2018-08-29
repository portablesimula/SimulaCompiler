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
import simula.compiler.declaration.ProcedureDeclaration;
import simula.compiler.declaration.StandardClass;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Meaning;
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
 *   RemoteVariable = Expression  DOT  Variable
 *   
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public class RemoteVariable extends Expression
{ public Expression lhs;
  public Variable rhs;
  private Meaning remoteAttribute; // Set by doChecking
  private ProcedureDeclaration callRemoteProcedure=null; 
  private boolean accessRemoteArray=false; // Set by doChecking

  
  public RemoteVariable(Expression lhs,Variable rhs)
  { this.lhs=lhs; this.rhs=rhs;
    lhs.backLink=rhs.backLink=this;
  }

  
  public Variable getWriteableVariable()
  { return(rhs); }
  
  public void doChecking()
  { if(IS_SEMANTICS_CHECKED()) return;
   	Global.sourceLineNumber=lineNumber;
	if(Option.TRACE_CHECKER) Util.TRACE("BEGIN RemoteVariable"+toString()+".doChecking - Current Scope Chain: "+Global.currentScope.edScopeChain());
	//Util.BREAK("BEGIN RemoteVariable"+toString()+".doChecking - Current Scope Chain: "+currentScope.edScopeChain());
	this.type=doRemoteChecking(lhs,rhs);
	
	if(Option.TRACE_CHECKER) Util.TRACE("END RemoteVariable"+toString()+".doChecking - Result type="+this.type);
	SET_SEMANTICS_CHECKED();
  }

  private Type doRemoteChecking(Expression obj,Expression attr)
  {	Global.sourceLineNumber=lineNumber;
    Type result;
	//Util.BREAK("RemoteVariable.doRemoteChecking("+toString()+").doChecking - Current Scope Chain: "+currentScope.edScopeChain());
	obj.doChecking(); Type objType=obj.type;
	//if(DEBUG) Util.log("BEGIN doRemoteChecking("+toString()+").doChecking(2) - objType="+objType+", obj="+obj);
	if(objType==Type.Text) return(doRemoteTextChecking(obj,attr));
	
	objType.doChecking(Global.currentScope); // Nødvendig hvis TypeDeclaration er nedenfor   TODO: ER DETTE OK ?
	if(objType.getQual()==null)
		Util.error("doRemoteChecking: Object Expression ("+obj+") is not a ref() type rather "+objType);
    
	//Util.BREAK("RemoteVariable.doRemoteChecking("+toString()+").doChecking(3) findDefinition("+classIdentifier+") ==> "+decl);
	//attr.doChecking(); // NOTE Should not be called for a remote attribute
	//Util.BREAK("RemoteVariable.doRemoteChecking("+toString()+").doChecking(4) - attr="+attr+", attr.Class="+attr.getClass().getName());
	if(attr instanceof Variable) // Covers FunctionDesignator and SubscriptedVariable since they are subclasses
	{ Variable var=(Variable)attr;
	  String ident=var.identifier;
	  //Util.BREAK("RemoteVariable.doRemoteChecking("+toString()+").doChecking(5a) findRemoteAttributeMeaning("+ident+")  Search in "+objType.getQual());
	  remoteAttribute=objType.getQual().findRemoteAttributeMeaning(ident);	  
	  //Util.BREAK("RemoteVariable.doRemoteChecking("+toString()+").doChecking(5) findRemoteAttributeMeaning("+ident+")  ==> "+remoteAttribute);
	  if(remoteAttribute==null) Util.error("RemoteVariable.doRemoteChecking: "+ident+" is not an attribute of "+objType.getRefIdent());
	  var.setRemotelyAccessed(remoteAttribute);
	  if(remoteAttribute.declaredAs instanceof Parameter)
	  { Parameter par=(Parameter)remoteAttribute.declaredAs;
//	    Util.BREAK("RemoteVariable.doRemoteChecking: DOT par="+par);
//	    Util.BREAK("RemoteVariable.doRemoteChecking: DOT par'kind="+par.kind);
		  if(par.kind==Parameter.Kind.Array) accessRemoteArray=true;
	  }
	  //Util.EXIT();
	  
	  
	  if(remoteAttribute.declaredAs instanceof ArrayDeclaration) // Array // TODO: NEW ARRAY CODE
	  { if(var.hasArguments()) accessRemoteArray=true;
		  
	  }
	  else if(remoteAttribute.declaredAs instanceof ProcedureDeclaration) // Procedure 
	  { //Util.BREAK("RemoteVariable.doRemoteChecking: Call Remote Procedure "+remote+", qual="+remote.getClass().getSimpleName());
		callRemoteProcedure=(ProcedureDeclaration)remoteAttribute.declaredAs; 
	  }
	  result=remoteAttribute.declaredAs.type;
	  //Util.BREAK("RemoteVariable.doRemoteChecking("+toString()+").doChecking(6) - attr="+attr+", attr.Type="+result);
	}
	else 
	{ //Util.BREAK("RemoteVariable.doRemoteChecking -- Usikker p� dette !!!");		
	  //Util.BREAK("RemoteVariable.doRemoteChecking: attr="+attr.getClass().getName());
	  Util.error("Illegal attribute("+attr+") in remote access");
	  result=attr.type;
	}
	return(result);
  }	

  private Type doRemoteTextChecking(Expression obj,Expression attr)
  {	//Util.BREAK("RemoteVariable.doRemoteTextChecking("+toString()+").doChecking - Current Scope Chain: "+currentScope.edScopeChain());
    Type result;
    //Util.BREAK("RemoteVariable.doRemoteTextChecking("+toString()+").doChecking - attr'name="+attr.getClass().getName());
	if(attr instanceof Variable) // Covers FunctionDesignator and SubscriptedVariable since they are subclasses
	{ Variable var=(Variable)attr;
	  String ident=var.identifier;
	  Meaning remote=StandardClass.typeText.findMeaning(ident);
	  //Util.BREAK("RemoteVariable.doRemoteTextChecking: remote="+remote);
	  if(remote==null) Util.error("RemoteVariable.doRemoteTextChecking: "+ident+" is not a Text attribute");
	  var.setRemotelyAccessed(remote);
	  callRemoteProcedure=(ProcedureDeclaration)remote.declaredAs; 
	  result=remote.declaredAs.type;

	}
	else 
	{ //Util.BREAK("RemoteVariable.doRemoteTextChecking -- Usikker p� dette !!!");		
	  //Util.BREAK("RemoteVariable.doRemoteTextChecking: attr="+attr.getClass().getName());
	  Util.error("Illegal attribute("+attr+") in remote access");
	  result=attr.type;
	}
	return(result);
  }

  // Returns true if this expression may be used as a statement.
  public boolean maybeStatement()
  {	ASSERT_SEMANTICS_CHECKED(this);
    return(rhs.maybeStatement());
  }
	  
  public String toJavaCode()
  { //Util.BREAK("RemoteVariable.toJavaCode: "+this);
	ASSERT_SEMANTICS_CHECKED(this);
    if(callRemoteProcedure!=null)
    	 return(CallProcedure.remote(lhs,callRemoteProcedure,(Variable)rhs,backLink));    
	else if(accessRemoteArray)
		 return(doAccessRemoteArray(lhs,(Variable)rhs));
	//Util.BREAK("RemoteVariable.toJavaCode: DOT - remoteAttribute="+remoteAttribute);
	String result;
	if(remoteAttribute.foundBehindInvisible)
//	    { String remoteCast=remoteAttribute.declaredIn.getJavaIdentifier();
	{ String remoteCast=remoteAttribute.foundIn.getJavaIdentifier();
	  result="(("+remoteCast+")("+lhs.get()+"))."+rhs.get();
	} else result=lhs.get()+KeyWord.DOT.toJavaCode()+rhs.get();
	  
	//Util.BREAK("RemoteVariable.toJavaCode: DOT result="+result);
	return(result);
  }
  
  // ***********************************************************************
  // *** CODE: doAccessRemoteArray 
  // ***********************************************************************
  private String doAccessRemoteArray(Expression beforeDot,Variable array)
  { StringBuilder s=new StringBuilder();
	int nDim=0;
	// Generate: obj.M.A[6-obj.M.LB[1]];
	String obj=beforeDot.toJavaCode();
    String remoteIdent=obj+'.'+array.edIdentifierAccess(true);
    StringBuilder ixs=new StringBuilder();
    String dimBrackets="";
	for(Expression ix:array.checkedParams) {
		String index="["+ix.toJavaCode()+"-"+remoteIdent+".LB["+(nDim++)+"]]"; // TODO: NEW ARRAY CODE
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
  { return("("+lhs+" DOT "+rhs+")"); }

}
