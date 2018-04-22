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
import simula.compiler.declaration.BlockDeclaration;
import simula.compiler.declaration.Parameter;
import simula.compiler.declaration.StandardClass;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.ParameterKind;
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
public class BinaryOperation extends Expression
{ public Expression lhs;
  public KeyWord opr;
  public Expression rhs;
  private boolean textValueAssignment=false; // Set by doChecking
  private BlockDeclaration callRemoteProcedure=null; 
  private boolean accessRemoteArray=false; // Set by doChecking

  
  public BinaryOperation(Expression lhs,KeyWord opr,Expression rhs)
  { this.lhs=lhs; this.opr=opr; this.rhs=rhs;
    //Util.BREAK("new BinaryOperation: lhs="+lhs);
    //Util.BREAK("new BinaryOperation: opr="+opr);
    //Util.BREAK("new BinaryOperation: rhs="+rhs);
    lhs.backLink=rhs.backLink=this;
	//Util.BREAK("NEW BinaryOperation: "+toString());
  }

  
  public boolean isRemoteVariable()
  { if(opr==KeyWord.DOT)
    { if(rhs instanceof Variable) return(true);	}
  	return(false);
  }
  
  public Variable getVariable()
  { if(opr==KeyWord.DOT)
    { if(rhs instanceof Variable) return((Variable)rhs);	}
  	return(null);
  }
  
  public void doChecking()
  { if(IS_SEMANTICS_CHECKED()) return;
   	Util.setLine(lineNumber);
	if(Option.TRACE_CHECKER) Util.TRACE("BEGIN BinaryOperation"+toString()+".doChecking - Current Scope Chain: "+Global.currentScope.edScopeChain());
	//Util.BREAK("BEGIN BinaryOperation"+toString()+".doChecking - Current Scope Chain: "+currentScope.edScopeChain());
	switch(opr)
	{ case PLUS: case MINUS: case MUL: case DIV:
	  { // ArithmeticExpression
		lhs.doChecking(); rhs.doChecking();
		Type type1=lhs.type; Type type2=rhs.type;
		this.type=Type.arithmeticTypeConversion(type1,type2);
		lhs=(Expression)TypeConversion.testAndCreate(this.type,lhs);
		rhs=(Expression)TypeConversion.testAndCreate(this.type,rhs);
		//Util.BREAK("BinaryOperation.doChecking: arithmeticTypeConversion("+type1+','+type2+") ==> "+this.type);
		if(this.type==null) Util.error("Incompatible types in binary operation: "+toString());
		break;
	  }
	  case INTDIV:
	  {	lhs.doChecking(); rhs.doChecking();
		Type type1=lhs.type; Type type2=rhs.type;
		if(type1==Type.ShortInteger || type1==Type.Integer)
	    { if(type2==Type.ShortInteger || type2==Type.Integer)  this.type=Type.Integer; }
		if(this.type==null) Util.error("Incompatible types in binary operation: "+toString());
		lhs=(Expression)TypeConversion.testAndCreate(this.type,lhs);
		rhs=(Expression)TypeConversion.testAndCreate(this.type,rhs);
	    break; 
	  }
	  case EXP:
	  {	lhs.doChecking(); rhs.doChecking();
//		Type type1=lhs.type; Type type2=rhs.type;
//        if(type1==Type.ShortInteger || type1==Type.Integer)
//	    { if(type2==Type.ShortInteger || type2==Type.Integer)  this.type=Type.Integer;
//	      else if(type2==Type.Real || type2==Type.LongReal)  this.type=type2;
//	    }
//	    else if(type1==Type.Real || type1==Type.LongReal )
//	    { if(type2==Type.ShortInteger || type2==Type.Integer)  this.type=type1;
//	      else if(type2==Type.Real || type2==Type.LongReal)  this.type=type2;
//	    }
//		lhs=(Expression)TypeConversion.testAndCreate(this.type,lhs);
//		rhs=(Expression)TypeConversion.testAndCreate(this.type,rhs);
//    	if(this.type==null) Util.error("Incompatible types in binary operation: "+toString());
    	this.type=Type.LongReal;
		lhs=(Expression)TypeConversion.testAndCreate(this.type,lhs);
		rhs=(Expression)TypeConversion.testAndCreate(this.type,rhs);
	    break; 
	  }
	  case LT: case LE: case EQ: case NE: case GE: case GT:
	  {	lhs.doChecking(); rhs.doChecking(); 
		Type type1=lhs.type; Type type2=rhs.type;
		if(type1==Type.Text && type2==Type.Text) { this.type=Type.Boolean; break; }
		if(type1==Type.Character && type2==Type.Character) { this.type=Type.Boolean; break; }
		// Arithmetic Relation
		Type atype=Type.arithmeticTypeConversion(type1,type2);
		if(atype==null) Util.error("Incompatible types in binary operation: "+toString());
		this.type=Type.Boolean;
		lhs=(Expression)TypeConversion.testAndCreate(atype,lhs);
		rhs=(Expression)TypeConversion.testAndCreate(atype,rhs);
		break;
	  }
	  case AND: case OR: case IMP: case EQV: case AND_THEN: case OR_ELSE:
	  { // Boolean operation
		lhs.doChecking(); rhs.doChecking();
		Type type1=lhs.type; Type type2=rhs.type;
		if( type1.equals(type2) & type1==Type.Boolean) this.type=Type.Boolean;
		if(this.type==null) Util.error("Incompatible types in binary operation: "+toString());
		break;
	  }
	  case CONC:
	  { // TEXT  &  TEXT
		lhs.doChecking(); rhs.doChecking();
		if(lhs.type!=Type.Text || rhs.type!=Type.Text) Util.error("Operand Type to Text Concatenation(&) is not Text");
		this.type=Type.Text;
		break;
	  }
	  case IS: case IN:
	  { // Object IS ClassIdentifier   |   Object IN ClassIdentifier
		//Util.BREAK("BinaryOperation.doChecking:"+lhs+" "+opr+" "+rhs);
		lhs.doChecking(); rhs.doChecking();
		Type type1=lhs.type;
//		Type type2=rhs.type;
//		Util.log("BinaryOperation.doChecking: getRefIdent="+type1.getRefIdent());
	    String refIdent=type1.getRefIdent();
	    if(refIdent==null)
	    	Util.error("BinaryOperation.doChecking: The Variable "+lhs+" is not ref() type");
	    
	    //Util.BREAK("BinaryOperation.doChecking: lhs="+lhs+", Qual="+lhs.getClass().getSimpleName());
	    //Util.BREAK("BinaryOperation.doChecking: rhs="+rhs+", Qual="+rhs.getClass().getSimpleName());
		
		String rhsIdent=((Variable)rhs).identifier;
		if(!checkCompatability(lhs,rhsIdent))
			   Util.warning("IS/IN is always FALSE -- " + rhsIdent	+ " is not compatible with " + refIdent);
		this.type=Type.Boolean;
		//  Debug.BREAK("BinaryOperation.doChecking: "+oprCode);
		break;
	  }
	  case EQR: case NER:
	  { // Object =/= Object   or   Object == Object
		lhs.doChecking(); rhs.doChecking();
		Type type1=lhs.type; Type type2=rhs.type;
		if((!type1.isReferenceType())||(!type2.isReferenceType()))
		Util.error("BinaryOperation: Illegal types: "+type1+" "+opr+" "+type2);
		
		this.type=Type.Boolean;
		break;
	  }
	  case DOT:
	  { this.type=doRemoteChecking(lhs,rhs);
		break;  
	  }
	  case QUA:
	  { lhs.doChecking(); rhs.doChecking();
		String classIdentifier=((Variable)rhs).identifier;
	    //Util.BREAK("BinaryOperation QUA, rhs="+rhs.getClass().getName());
		if(!checkCompatability(lhs,classIdentifier))
			Util.error("Illegal Object Expression: "+lhs+" is not compatible with "+classIdentifier);
		this.type=new Type(classIdentifier);
		break;
	  }
	  case ASSIGNVALUE:
	  case ASSIGNREF: doAssignmentChecking(opr); break;
	  default:
			Util.NOT_IMPLEMENTED("BinaryOperation -- Util.error(Something went wrong) opr="+opr);
			this.type=rhs.type;  // TODO  TEMP
	}
	if(Option.TRACE_CHECKER) Util.TRACE("END BinaryOperation"+toString()+".doChecking - Result type="+this.type);
	SET_SEMANTICS_CHECKED();
  }


  public void doAssignmentChecking(KeyWord keyWord)
  { lhs.doChecking(); Type toType=lhs.type;
    rhs.doChecking(); Type fromType=rhs.type;
	//if(DEBUG) Util.log("doAssignmentChecking("+toString()+").doChecking - ("+toType+' '+keyWord+' '+fromType+")");
	//if(DEBUG) Util.log("doAssignmentChecking: operator: "+keyWord);
	if(keyWord==KeyWord.ASSIGNVALUE) this.textValueAssignment=(toType==Type.Text);
	rhs=(Expression)TypeConversion.testAndCreate(toType,rhs);
	this.type=toType;
	//if(DEBUG) Util.log("doAssignmentChecking: CHECKED("+toString()+").doChecking - Result type="+this.type+"("+toType+' '+keyWord+' '+fromType+")");
	if(this.type==null) Util.error("doAssignmentChecking: Illegal types: "+toType+" := "+fromType);
  }

  private Type doRemoteChecking(Expression obj,Expression attr)
  {	Util.setLine(lineNumber);
    Type result;
	//Util.BREAK("BinaryOperation.doRemoteChecking("+toString()+").doChecking - Current Scope Chain: "+currentScope.edScopeChain());
	obj.doChecking(); Type objType=obj.type;
	//if(DEBUG) Util.log("BEGIN doRemoteChecking("+toString()+").doChecking(2) - objType="+objType+", obj="+obj);
	if(objType==Type.Text) return(doRemoteTextChecking(obj,attr));
	
	objType.doChecking(Global.currentScope); // Nødvendig hvis TypeDeclaration er nedenfor   TODO: ER DETTE OK ?
	if(objType.getQual()==null)
		Util.error("doRemoteChecking: Object Expression ("+obj+") is not a ref() type rather "+objType);
    
	//Util.BREAK("BinaryOperation.doRemoteChecking("+toString()+").doChecking(3) findDefinition("+classIdentifier+") ==> "+decl);
	//attr.doChecking(); // NOTE Should not be called for a remote attribute
	//Util.BREAK("BinaryOperation.doRemoteChecking("+toString()+").doChecking(4) - attr="+attr+", attr.Class="+attr.getClass().getName());
	if(attr instanceof Variable) // Covers FunctionDesignator and SubscriptedVariable since they are subclasses
	{ Variable var=(Variable)attr;
	  String ident=var.identifier;
	  //Util.BREAK("BinaryOperation.doRemoteChecking("+toString()+").doChecking(5a) findAttribute("+ident+")  Search in "+decl);
//	  Declaration remote=((BlockDeclaration)decl).findAttribute(ident);
	  
	  //Meaning remote=((BlockDeclaration)decl).findMeaning(ident);	  
	  Meaning remote=objType.getQual().findMeaning(ident);	  
	  
	  //Util.BREAK("BinaryOperation.doRemoteChecking("+toString()+").doChecking(5) findAttribute("+ident+")  ==> "+remote);
	  if(remote==null) Util.error("BinaryOperation.doRemoteTextChecking: "+ident+" is not an attribute of "+objType.getRefIdent());
	  var.setRemotelyAccessed(remote);
	  //Util.BREAK("BinaryOperation.doRemoteChecking: DOT "+var+", qual="+var.getClass().getSimpleName());
	  //Util.BREAK("BinaryOperation.doRemoteChecking: DOT "+remote+", qual="+remote.getClass().getSimpleName());
	  if(remote.declaredAs instanceof ArrayDeclaration) // Array // TODO: NEW ARRAY CODE
	  { if(var instanceof SubscriptedVariable) accessRemoteArray=true;
		  
	  }
	  else if(remote.declaredAs instanceof BlockDeclaration) // Procedure (or Class ?)
	  { //Util.BREAK("BinaryOperation.doRemoteChecking: Call Remote Procedure "+remote+", qual="+remote.getClass().getSimpleName());
//		if(((BlockDeclaration)remote.declaredAs).blockKind!=BlockKind.Method)
		     callRemoteProcedure=(BlockDeclaration)remote.declaredAs; 
	  }
	  result=remote.declaredAs.type;
	  //Util.BREAK("BinaryOperation.doRemoteChecking("+toString()+").doChecking(6) - attr="+attr+", attr.Type="+result);
	}
	else 
	{ //Util.BREAK("BinaryOperation.doRemoteChecking -- Usikker på dette !!!");		
	  //Util.BREAK("BinaryOperation.doRemoteChecking: attr="+attr.getClass().getName());
	  Util.error("Illegal attribute("+attr+") in remote access");
	  result=attr.type;
	}
	return(result);
  }	

  private Type doRemoteTextChecking(Expression obj,Expression attr)
  {	//Util.BREAK("BinaryOperation.doRemoteTextChecking("+toString()+").doChecking - Current Scope Chain: "+currentScope.edScopeChain());
    Type result;
    //Util.BREAK("BinaryOperation.doRemoteTextChecking("+toString()+").doChecking - attr'name="+attr.getClass().getName());
	if(attr instanceof Variable) // Covers FunctionDesignator and SubscriptedVariable since they are subclasses
	{ Variable var=(Variable)attr;
	  String ident=var.identifier;
//	  Declaration remote=StandardClass.typeText.findAttribute(ident);
	  Meaning remote=StandardClass.typeText.findMeaning(ident);
	  //Util.BREAK("BinaryOperation.doRemoteTextChecking: remote="+remote);
	  if(remote==null) Util.error("BinaryOperation.doRemoteTextChecking: "+ident+" is not a Text attribute");
	  var.setRemotelyAccessed(remote);
	  //var.doChecking();
	  callRemoteProcedure=(BlockDeclaration)remote.declaredAs; 
	  result=remote.declaredAs.type;

	}
	else 
	{ //Util.BREAK("BinaryOperation.doRemoteTextChecking -- Usikker på dette !!!");		
	  //Util.BREAK("BinaryOperation.doRemoteTextChecking: attr="+attr.getClass().getName());
	  Util.error("Illegal attribute("+attr+") in remote access");
	  result=attr.type;
	}
	return(result);
  }

	private static BlockDeclaration getQualification(Expression simpleObjectExpression) {
		String refIdent=simpleObjectExpression.type.getRefIdent();
		Declaration objDecl = Global.currentScope.findMeaning(refIdent).declaredAs;
		if(objDecl instanceof BlockDeclaration)	return((BlockDeclaration)objDecl);
		Util.error("Illegal ref(" + refIdent + "): " + refIdent + " is not a class");
		return(null);
	}
	  
	public static BlockDeclaration getQualification(String classIdentifier) {
		Declaration classDecl=Global.currentScope.findMeaning(classIdentifier).declaredAs;
		if(classDecl instanceof BlockDeclaration) return((BlockDeclaration)classDecl);
			Util.error("Illegal: " + classIdentifier + " is not a class");
		return(null);
	}
	  
	public static boolean checkCompatability(Expression simpleObjectExpression,String classIdentifier) {
		BlockDeclaration objDecl=getQualification(simpleObjectExpression);
		BlockDeclaration quaDecl=getQualification(classIdentifier);
		if(quaDecl==objDecl) Util.warning("Unneccessary QUA "+ classIdentifier);
		else if(quaDecl==null) Util.error("Illegal QUA -- " + classIdentifier + " is not a class");
		else if(!(objDecl.isCompatibleClasses(quaDecl))) return(false);
		return(true);
	}
	  
  public String toJavaCode()
  { //Util.BREAK("BinaryOperation.toJavaCode: "+this);
	ASSERT_SEMANTICS_CHECKED(this);
	switch(opr)
	{ case ASSIGNVALUE: case ASSIGNREF: return(doCodeAssignment());
	  case QUA:
	  { // return ("((" + rhs.toJavaCode() + ")(" + lhs.get() + "))");
	    String result="((" + ((Variable)rhs).getJavaIdentifier() + ")(" + lhs.get() + "))";
	    // Util.BREAK("BinaryOperation.toJavaCode: "+this+", ==> "+result);
	    return(result);
	  }
	  case IMP: return("((!"+lhs.get()+") | "+rhs.get()+')');
	  case EQV: return("(("+lhs.get()+") == ("+rhs.get()+"))");
	
	  case IN:
	  {	String rhsIdent=((Variable)rhs).identifier;
		if(!checkCompatability(lhs,rhsIdent)) return("false"); // warning("IS/IN is always FALSE
		return(lhs.get()+opr.toJavaCode()+((Variable)rhs).getJavaIdentifier());
		//return( "((Object)"+lhs.get()+")"+opr.toJavaCode()+((Variable)rhs).getJavaIdentifier());
	  }
	  case IS:
	  {	String rhsIdent=((Variable)rhs).identifier;
		if(!checkCompatability(lhs,rhsIdent)) return("false"); // warning("IS/IN is always FALSE
		//return("("+lhs.get()+").getClass() == "+((Variable)rhs).getJavaIdentifier()+".class");
		return("IS$("+lhs.get()+","+((Variable)rhs).getJavaIdentifier()+".class)");
	  }
	  case EXP: return("Math.pow("+lhs.get()+','+rhs.get()+')');
	  case CONC: return("CONC("+lhs.get()+','+rhs.get()+')');
	  case DOT:
	  { if(callRemoteProcedure!=null)
	    {
		  return(CallProcedure.remote(lhs,callRemoteProcedure,(Variable)rhs,backLink));
	    }
	    else if(accessRemoteArray) return(accessRemoteArray(lhs,(SubscriptedVariable)rhs));
	    String result=lhs.get()+opr.toJavaCode()+rhs.get();
	    Util.BREAK("BinaryOperation.toJavaCode: DOT result="+result);
	    return(result);
	  }
	  case LT: case LE: case EQ: case NE: case GE: case GT:
	  {	Type type1=lhs.type; Type type2=rhs.type;
		if( (type1==Type.Text) && (type2==Type.Text) ) return(doCodeTextValueRelation());
	  }
	  case EQR: case NER:
	  {	Type type1=lhs.type; Type type2=rhs.type;
		if( (type1==Type.Text) && (type2==Type.Text) ) return(doCodeTextRefRelation());
	  }
      default: return(lhs.get()+opr.toJavaCode()+'('+rhs.get()+')');
	}
  }

  // ***********************************************************************
  // *** CODE: doCodeTextValueRelation
  // ***********************************************************************
  private String doCodeTextValueRelation()
  { StringBuilder s=new StringBuilder();
    String fnc="??";
    switch(opr)
    { case LT: fnc="LT("; break;
	  case EQ: fnc="EQ("; break;
	  case LE: fnc="LE("; break;
	  case GT: fnc="GT("; break;
	  case NE: fnc="NE("; break;
	  case GE: fnc="GE("; break;
      default:    
    }
    s.append("TXTREL$").append(fnc);
    s.append(lhs.get()).append(',');
	s.append(rhs.get()).append(')');
	return(s.toString());
  }

  // ***********************************************************************
  // *** CODE: doCodeTextRefRelation
  // ***********************************************************************
  private String doCodeTextRefRelation()
  { String fnc="TRF_EQ("; StringBuilder s=new StringBuilder();
    if(opr==KeyWord.NER) fnc="TRF_NE(";
    s.append(fnc);
    s.append(lhs.get()).append(',');
	s.append(rhs.get()).append(')');
	return(s.toString());
  }

  // ***********************************************************************
  // *** CODE: doCodeTextValueAssignment
  // ***********************************************************************
  private String doCodeTextValueAssignment()
  { StringBuilder s=new StringBuilder();
    Util.BREAK("BinaryOperation.doCodeTextValueAssignment: rhs="+rhs+", qual="+rhs.getClass().getSimpleName());
    if(rhs instanceof Constant)
    { Object value=((Constant)rhs).value;
      Util.BREAK("BinaryOperation.doCodeTextValueAssignment: value="+value);
      if(value!=null)
      { Util.BREAK("BinaryOperation.doCodeTextValueAssignment: value="+value+", qual="+value.getClass().getSimpleName());
        //s.append(lhs.toJavaCode()).append(".ASGSTR$(\"").append(value).append("\")");
        s.append("ASGSTR$(").append(lhs.toJavaCode()).append(",\"").append(value).append("\")");
        Util.BREAK("BinaryOperation.doCodeTextValueAssignment: result="+s.toString());
    	return(s.toString()); 
      }
    }
//    s.append(lhs.toJavaCode()).append(".ASGTXT$(").append(rhs.toJavaCode()).append(')');
    s.append("ASGTXT$(").append(lhs.toJavaCode()).append(',').append(rhs.toJavaCode()).append(')');
	return(s.toString());  
  }
  

  // ***********************************************************************
  // *** CODE: doCodeAssignment   -- FJERNES / RETTES // TODO: NEW ARRAY CODE
  // ***********************************************************************
  private String doCodeAssignment()
  { StringBuilder s=new StringBuilder();
	if(this.textValueAssignment) s.append(doCodeTextValueAssignment());
	else
	{ //Util.BREAK("BinaryOperation.doCodeAssignment: lhs="+lhs+", qual="+lhs.getClass().getSimpleName());
	  //Util.BREAK("BinaryOperation.doCodeAssignment: rhs="+rhs+", qual="+rhs.getClass().getSimpleName());
	  
//	  // -------------------------------------------------------------------------
//	  // CHECK FOR SPECIAL CASE:
//	  //     <Array> := <Expression-2> ;
//	  // SHOULD BE CODED AS:
//	  //     ARRAY.put(x1,x2,<Expression-2>) ;
//	  // -------------------------------------------------------------------------
//	  //Util.BREAK("BinaryOperation.doCodeAssignment: afterDot="+afterDot+", qual="+afterDot.getClass().getSimpleName());
//	  if(lhs instanceof SubscriptedVariable)
//	  { Declaration decl=((SubscriptedVariable)lhs).declaredAs;
//	    Util.BREAK("BinaryOperation.doCodeAssignment20: decl="+decl+", qual="+decl.getClass().getSimpleName());
//	    if(decl instanceof ArrayDeclaration) return(doCodeArrayAssignment((SubscriptedVariable)lhs,false));
//	    else if(decl instanceof Parameter)
//	    { Parameter par=(Parameter)decl;
//		  Util.BREAK("BinaryOperation.doCodeAssignment21: par="+par+", qual="+par.getClass().getSimpleName());
//		  if(par.kind==Kind.Array) return(doCodeArrayAssignment((SubscriptedVariable)lhs,par.mode==Mode.name));
//	    }
//	  }
	  
	  
//	  // -------------------------------------------------------------------------
//	  // CHECK FOR SPECIAL CASE:
//	  //     <Expression-1> DOT <Array> := <Expression-2> ;
//	  // SHOULD BE CODED AS:
//	  //     <Expression-1> . ARRAY.put(x1,x2,<Expression-2>) ;
//	  // -------------------------------------------------------------------------
//	  if(lhs instanceof BinaryOperation && ((BinaryOperation)lhs).opr==KeyWord.DOT)
//	  { Expression afterDot=((BinaryOperation)lhs).rhs;
//		//Util.BREAK("BinaryOperation.doCodeAssignment: afterDot="+afterDot+", qual="+afterDot.getClass().getSimpleName());
//		if(afterDot instanceof SubscriptedVariable)
//		{ Declaration decl=((SubscriptedVariable)afterDot).declaredAs;
//		  Util.BREAK("BinaryOperation.doCodeAssignment30: decl="+decl+", qual="+decl.getClass().getSimpleName());
// 	      Expression beforeDot=((BinaryOperation)lhs).lhs;
//		  if(decl instanceof ArrayDeclaration) return(doRemoteArrayAssignment(beforeDot,(SubscriptedVariable)afterDot,false));
//		  else if(decl instanceof Parameter)
//		  { Parameter par=(Parameter)decl;
//			Util.BREAK("BinaryOperation.doCodeAssignment31: par="+par+", qual="+par.getClass().getSimpleName());
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
	  if(lhs instanceof BinaryOperation && ((BinaryOperation)lhs).opr==KeyWord.DOT)    // TODO: NEW ARRAY CODE
	  { Expression afterDot=((BinaryOperation)lhs).rhs;
		//Util.BREAK("BinaryOperation.doCodeAssignment: afterDot="+afterDot+", qual="+afterDot.getClass().getSimpleName());
		if(afterDot instanceof SubscriptedVariable)
		{ Declaration decl=((SubscriptedVariable)afterDot).meaning.declaredAs;
		  //Util.BREAK("BinaryOperation.doCodeAssignment30: decl="+decl+", qual="+decl.getClass().getSimpleName());
 	      Expression beforeDot=((BinaryOperation)lhs).lhs;
		  if(decl instanceof ArrayDeclaration) return(assignToRemoteArray(beforeDot,(SubscriptedVariable)afterDot,rhs));
		  else if(decl instanceof Parameter)
		  { Parameter par=(Parameter)decl;
			//Util.BREAK("BinaryOperation.doCodeAssignment31: par="+par+", qual="+par.getClass().getSimpleName());
			if(par.kind==ParameterKind.Array) return(assignToRemoteArray(beforeDot,(SubscriptedVariable)afterDot,rhs));
		  }
		  
		}
	  }
	  s.append(lhs.put(rhs.get()));
	}
//	Util.BREAK("BinaryOperation.doCodeAssignment: "+this+" ==> "+s);
	return(s.toString());
  }
  
  
  // ***********************************************************************
  // *** CODE: assignToRemoteArray      // TODO: NEW ARRAY CODE
  // ***********************************************************************
  private String assignToRemoteArray(Expression beforeDot,SubscriptedVariable array,Expression rhs)
  { String lhs=accessRemoteArray(beforeDot,(SubscriptedVariable)array);
	String asg=lhs+'='+rhs.toJavaCode();
	return(asg);
  }
  
  // ***********************************************************************
  // *** CODE: accessRemoteArray 
  // ***********************************************************************
  private String accessRemoteArray(Expression beforeDot,SubscriptedVariable array)
  { StringBuilder s=new StringBuilder();
	int nDim=0;
	// Generate: obj.M.A[6-obj.M.LB[1]];
	String obj=beforeDot.toJavaCode();
    String remoteIdent=obj+'.'+array.edVariable(true);
//    s.append(remoteIdent+".A");
    s.append(remoteIdent+".Elt");
	for(Expression ix:array.checkedParams) {
		String index="["+ix.toJavaCode()+"-"+remoteIdent+".LB["+(nDim++)+"]]"; // TODO: NEW ARRAY CODE
		s.append(index);
	}
    return(s.toString());
  }
  
//  private String CallRemoteProcedure(Expression obj,BlockDeclaration procedure,Variable var)
//  { 
////	String call="new "+procedure.getJavaIdentifier();//+"("+obj.get();
////    String staticLink=obj.get();
////	Util.BREAK("BinaryOperation.CallRemoteProcedure: staticLink="+staticLink);
////	if(var instanceof SubscriptedVariable)
////	{ call=call+((SubscriptedVariable)var).edProcedureParameters(staticLink,procedure);
////	} else call=call+'('+staticLink+')';
////	if(procedure.type!=null && backLink!=null) call=call+".$result";
////	return(call);
//	return(CallProcedure.remote(obj, procedure, var, backLink));
//  }

  public String toString()
  { return("("+lhs+' '+opr+' '+rhs+")"); }

}
