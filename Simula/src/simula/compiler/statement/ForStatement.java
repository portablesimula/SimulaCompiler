/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.statement;

import java.util.Iterator;
import java.util.Vector;

import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.Parameter;
import simula.compiler.expression.Expression;
import simula.compiler.expression.TypeConversion;
import simula.compiler.expression.Variable;
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.ParameterMode;
import simula.compiler.utilities.Token;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;
import simula.runtime.ENVIRONMENT$.$NAME;
import simula.runtime.RTObject$.ForList;
import simula.runtime.RTObject$.SingleElt;
import simula.runtime.RTObject$.StepUntil;
import simula.runtime.RTObject$.WhileElt;


/**
 * For Statement.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 *  ForStatement = FOR Variable :- ReferenceList DO Statement
 *               | FOR Variable := ValueList DO Statement
 *               
 * 		ReferenceList = ReferenceListElement { , ReferenceListElement }
 * 			ReferenceListElement = ReferenceExpression [ WHILE BooleanExpression ]
 * 
 * 		ValueList = ValueListElement { , ValueListElement }
 * 			ValueListElement = ValueExpression [ WHILE BooleanExpression ]
 *                           | ArithmeticExpression STEP ArithmeticExpression UNTIL ArithmeticExpression
 *
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public class ForStatement extends Statement
{ Variable controlVariable;
  Token assignmentOperator; //  :=   eller   :-
  Vector<ForListElement> forList=new Vector<ForListElement>();
  Statement doStatement;
  
  public ForStatement()
  { if(Option.TRACE_PARSE) Parser.TRACE("Parse ForStatement");
    controlVariable=new Variable(expectIdentifier());
    if(!Parser.accept(KeyWord.ASSIGNVALUE)) Parser.expect(KeyWord.ASSIGNREF);
    assignmentOperator=Parser.prevToken;
    do { forList.add(parseForListElement()); } while(Parser.accept(KeyWord.COMMA));
    Parser.expect(KeyWord.DO); doStatement=Statement.doParse();
    if(doStatement==null) { Util.error("No statement following DO in For statement"); doStatement=new DummyStatement(); }
    if(Option.TRACE_PARSE) Util.TRACE("NEW ForStatement: "+toString());
  }
    
  private ForListElement parseForListElement()
  { if(Option.TRACE_PARSE) Parser.TRACE("Parse ForListElement");
	Expression expr1=Expression.parseExpression();
	if(Parser.accept(KeyWord.WHILE)) return(new WhileElement(expr1,Expression.parseExpression()));
	if(Parser.accept(KeyWord.STEP))
	{ Expression expr2=Expression.parseExpression();
	  Parser.expect(KeyWord.UNTIL);
	  return(new StepUntilElement(expr1,expr2,Expression.parseExpression()));
	} else return(new ForListElement(expr1));	  
  }
 
  private String getControlVariableByName(String classIdent)
  { String cv=controlVariable.toJavaCode();
    String cast=controlVariable.type.toJavaType();
	String cvName="new $NAME<"+classIdent+">()"+
//			"{ public "+classIdent+" put("+classIdent+" x$){"+cv+"=("+cast+")x$; return("+cv+");};"+
            "{ public "+classIdent+" put("+classIdent+" x$){"+cv+"=("+cast+")x$; return(x$);};"+
			"  public "+classIdent+" get(){return(("+classIdent+")"+cv+"); }	}";
	return(cvName);
  }
  
  private class ForListElement
  { Expression expr1;
	public ForListElement(Expression expr1)
	{ this.expr1=expr1;
	  if(Option.TRACE_PARSE) Util.TRACE("NEW ForListElement: "+toString());
	}  
	public void doChecking()
	{ if(Option.TRACE_CHECKER) Util.TRACE("BEGIN ForListElement("+this+").doChecking - Current Scope Chain: "+Global.currentScope.edScopeChain());
	  expr1.doChecking(); 
	}
	public String edCode()
	{ Util.NOT_IMPLEMENTED("ForStatement: Single expression for list element");
      return(""+expr1.toJavaCode());
	}
	public String edNewCode(String classIdent)
	{ // new SingleElt(new $NAME<Number>() { public Number get(){return(<expression>); }})
  	  return("new SingleElt<"+classIdent+">("+getControlVariableByName(classIdent)
	    +",new $NAME<"+classIdent+">() { public "+classIdent+" get(){return("+expr1.toJavaCode()+"); }})");
	}
	public String edRefCode()
	{ // new SingleElt(new $NAME<ClassIdent>() { public ClassIdent get(){return(<expression>); }})
	  String classIdent=expr1.type.getJavaRefIdent();
//  	  return("new SingleRefElt<"+classIdent+">("
//	    +"new $NAME<"+classIdent+">() { public "+classIdent+" get(){return("+expr1.toJavaCode()+"); }})");
  	  return(edNewCode(classIdent));
	}
	public String toString() { return(""+expr1); }
  }
  
  private class WhileElement extends ForListElement
  { Expression expr2;
	public WhileElement(Expression expr1,Expression expr2) { super(expr1); this.expr2=expr2; }  
	public void doChecking()
	{ if(Option.TRACE_CHECKER) Util.TRACE("BEGIN WhileElement("+this+").doChecking - Current Scope Chain: "+Global.currentScope.edScopeChain());
	  expr1.doChecking();
	  expr2.doChecking(); if(expr2.type!=Type.Boolean) Util.error("While "+expr2+" is not of type Boolean");
	  expr1=TypeConversion.testAndCreate(controlVariable.type,expr1);
	}
	public String edCode()
	{ String code1=expr1.toJavaCode();
	  return(""+code1+';'+expr2.toJavaCode()+';'+controlVariable.toJavaCode()+"="+code1);
	}
	public String edNewCode(String classIdent)
	{ return("new WhileElt<"+classIdent+">("+getControlVariableByName(classIdent)
			            +",new $NAME<"+classIdent+">() { public "+classIdent+" get(){return("+expr1.toJavaCode()+"); }}"
			            +",new $NAME<Boolean>() { public Boolean get(){return("+expr2.toJavaCode()+"); }})");
	}
	public String edRefCode()
	{ // new WhileElt(new $NAME<ClassIdent>() { public ClassIdent get(){return(<Expression1>); }}
	  //             ,new $NAME<Boolean>() { public Boolean get(){return(<Boolean'Expression2>); }})
	  String classIdent=expr1.type.getJavaRefIdent();
//	  return("new WhileRefElt<"+classIdent+">("
//	        +"new $NAME<"+classIdent+">() { public "+classIdent+" get(){return("+expr1.toJavaCode()+"); }}"
//			+",new $NAME<Boolean>() { public Boolean get(){return("+expr2.toJavaCode()+"); }})");
  	  return(edNewCode(classIdent));
	}
	public String toString() { return(""+expr1+" while "+expr2); }
  }
  
  private class StepUntilElement extends ForListElement
  { Expression expr2;
    Expression expr3;
	public StepUntilElement(Expression expr1,Expression expr2,Expression expr3)
	{ super(expr1); this.expr2=expr2; this.expr3=expr3; }  
	public void doChecking()
	{ expr1.doChecking(); expr1=TypeConversion.testAndCreate(controlVariable.type,expr1);
	  expr2.doChecking(); expr2=TypeConversion.testAndCreate(controlVariable.type,expr2);
	  expr3.doChecking(); expr3=TypeConversion.testAndCreate(controlVariable.type,expr3);
	}
	public String edCode()
	{ // for(i=34;i<=78;i=i+4) k=k+1;  // For i:=34 Step 4 until 78 do k=k+1;
	  expr3.backLink=ForStatement.this; // To ensure $result from functions
      String s=""+expr1.toJavaCode()+';'
    		     +controlVariable.toJavaCode()+"<="+expr3.toJavaCode()+';'
    		     +controlVariable.toJavaCode()+'='+controlVariable.toJavaCode()+'+'+expr2.toJavaCode();
      return(s);
	}
	public String edNewCode(String classIdent)
	{ // new StepUntil(new $NAME<Number>() { public Number get(){return(<expr1>); }}
	  //			  ,new $NAME<Number>() { public Number get(){return(<expr2>); }}
	  //			  ,new $NAME<Number>() { public Number get(){return(<expr3>); }})
	  expr1.backLink=ForStatement.this; // To ensure $result from functions
	  expr2.backLink=ForStatement.this; // To ensure $result from functions
	  expr3.backLink=ForStatement.this; // To ensure $result from functions
  	  return("new StepUntil("+getControlVariableByName(classIdent)
  	                     +",new $NAME<Number>() { public Number get(){return("+expr1.toJavaCode()+"); }}"
  	                     +",new $NAME<Number>() { public Number get(){return("+expr2.toJavaCode()+"); }}"
  	                     +",new $NAME<Number>() { public Number get(){return("+expr3.toJavaCode()+"); }})");
      
	}
	public String toString() { return(""+expr1+" step "+expr2+ " until "+expr3); }
  }

  public void doChecking()
  { if(IS_SEMANTICS_CHECKED()) return;
   	Util.setLine(lineNumber);
    if(Option.TRACE_CHECKER) Util.TRACE("BEGIN ForStatement("+controlVariable+").doChecking - Current Scope Chain: "+Global.currentScope.edScopeChain());
    controlVariable.doChecking();
    this.type=controlVariable.type; // Type of control variable
    Declaration decl=controlVariable.meaning.declaredAs;
    if(decl instanceof Parameter && ((Parameter)decl).mode==ParameterMode.name)
    	  Util.error("For-Statement's Controled Variable("+controlVariable+") cannot be a formal parameter called by Name");
    Iterator<ForListElement> iterator=forList.iterator();
    while(iterator.hasNext()) { iterator.next().doChecking(); }
    doStatement.doChecking();
	//Debug.BREAK("END ForStatement("+controlVariable+").doChecking: type="+type);
	SET_SEMANTICS_CHECKED();
  }
  public void doJavaCoding(String indent)
  {	if(controlVariable.type.isReferenceType())
    { if(Global.NEW_REF_FOR_CODING)	{ doCodeReferenceFor(indent); return; }
	  doOldJavaCoding(indent);
    }
    else
    { if(Global.NEW_VALUE_FOR_CODING) { doNewForCoding(indent); return; }
      doOldJavaCoding(indent);
    }
  }

  public void doOldJavaCoding(String indent)
  {	Util.setLine(lineNumber);
	ASSERT_SEMANTICS_CHECKED(this);
    if(forList.size()>1) Util.NOT_IMPLEMENTED("ForStatement: Multiple("+forList.size()+") for list elements - ");
    ForListElement elt=forList.firstElement();
    Util.code(indent+"for("+controlVariable.toJavaCode()+"="+elt.edCode()+") {");
    doStatement.doJavaCoding(indent+"   ");
    Util.code(indent+'}');
//    if(elt instanceof StepUntilElement) // AD'HOC Correction after ForStepUntil
//    { StepUntilElement stepUntilElement=(StepUntilElement)elt;
//      Util.code(indent+controlVariable.toJavaCode()+"="+stepUntilElement.expr3.toJavaCode()+"; // Set ControlVariable=Until'Value");
//    }
  }  
  
  // ------------------------------------------------------------
  //	for(Number CVAR$:new ForList(
  //			 new SingleElt(n1)
  //			,new SingleElt(n3)
  //			,new StepUntil(n5,n3,n201)
  //			,new WhileElt(n4,b1)
  //       )) { cv=(int)CVAR$;
  //	// Statements ...
  //	}
  // ------------------------------------------------------------
  public void doNewForCoding(String indent)
  {	Util.setLine(lineNumber);
	ASSERT_SEMANTICS_CHECKED(this);
	String CB="CB$"+lineNumber;
    Util.code(indent+"for(boolean "+CB+":new ForList(");
    char del=' ';
    for(ForListElement elt:forList)
    { Util.code(indent+"   "+del+elt.edNewCode("Number"));
      del=',';
    }
    Util.code(indent+"   )) { if(!"+CB+") continue;");
    
    doStatement.doJavaCoding(indent+"   ");
    Util.code(indent+'}');
  }  
  public void doCodeReferenceFor(String indent)
  {	Util.setLine(lineNumber);
	ASSERT_SEMANTICS_CHECKED(this);
	String CB="CB$"+lineNumber;
    Util.code(indent+"for(boolean "+CB+":new ForList(");
    char del=' ';
    for(ForListElement elt:forList)
    { Util.code(indent+"   "+del+elt.edRefCode());
      del=',';
    }
    Util.code(indent+"   )) { if(!"+CB+") continue;");
    
    doStatement.doJavaCoding(indent+"   ");
    Util.code(indent+'}');
  }  
  
  public void print(String indent,String tail)
  { String fl=forList.toString().replace('[',' ').replace(']',' ');
    System.out.println(indent+"FOR "+controlVariable+" "+assignmentOperator+fl+"DO");
    if(doStatement!=null) doStatement.print(indent,";"); }
  
  public String toString()
  { String fl=forList.toString().replace('[',' ').replace(']',' ');
	return("FOR "+controlVariable+" "+assignmentOperator+fl+" DO "+doStatement);
  }
}
