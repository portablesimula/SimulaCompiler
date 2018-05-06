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
  Token assignmentOperator; //  :=   or   :-
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
  
  public void doChecking()
  { if(IS_SEMANTICS_CHECKED()) return;
   	Util.setLine(lineNumber);
    controlVariable.doChecking();
    this.type=controlVariable.type; // Type of control variable
    Declaration decl=controlVariable.meaning.declaredAs;
    if(decl instanceof Parameter && ((Parameter)decl).mode==ParameterMode.name)
    	  Util.error("For-Statement's Controled Variable("+controlVariable+") can't be a formal parameter by Name");
    Iterator<ForListElement> iterator=forList.iterator();
    while(iterator.hasNext()) { iterator.next().doChecking(); }
    doStatement.doChecking();
	//Debug.BREAK("END ForStatement("+controlVariable+").doChecking: type="+type);
	SET_SEMANTICS_CHECKED();
  }
  
  public void doJavaCoding(String indent)
  {	// ------------------------------------------------------------
    //	for(boolean CB$:new ForList(
    //			 new SingleElt<Number>(n1)
    //			,new SingleElt<Number>(n3)
    //			,new StepUntil(n5,n3,n201)
    //			,new WhileElt<Number>(n4,b1)
    //       )) { if(!CB$) continue;
    //	          // Statements ...
    //	}
    // ------------------------------------------------------------
	Util.setLine(lineNumber);
	ASSERT_SEMANTICS_CHECKED(this);
	boolean refType=controlVariable.type.isReferenceType();
	String CB="CB$"+lineNumber;
    Util.code(indent+"for(boolean "+CB+":new ForList(");
    char del=' ';
    for(ForListElement elt:forList)
    { String classIdent=(refType)?elt.expr1.type.getJavaRefIdent():"Number";
      Util.code(indent+"   "+del+elt.edCode(classIdent));
      del=',';
    }
    Util.code(indent+"   )) { if(!"+CB+") continue;");
    doStatement.doJavaCoding(indent+"   ");
    Util.code(indent+'}');
  } 
  
  private String edControlVariableByName(String classIdent)
  { String cv=controlVariable.toJavaCode();
    String cast=controlVariable.type.toJavaType();
	String cvName="new $NAME<"+classIdent+">()"+
            "{ public "+classIdent+" put("+classIdent+" x$){"+cv+"=("+cast+")x$; return(x$);};"+
			"  public "+classIdent+" get(){return(("+classIdent+")"+cv+"); }	}";
	return(cvName);
  }
  
  public void print(String indent,String tail)
  { String fl=forList.toString().replace('[',' ').replace(']',' ');
    System.out.println(indent+"FOR "+controlVariable+" "+assignmentOperator+fl+"DO");
    if(doStatement!=null) doStatement.print(indent,";"); }
  
  public String toString()
  { String fl=forList.toString().replace('[',' ').replace(']',' ');
	return("FOR "+controlVariable+" "+assignmentOperator+fl+" DO "+doStatement);
  }
  
  // ************************************************************************************
  // *** ForListElement  --  Single Element
  // ************************************************************************************
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
	public String edCode(String classIdent)
	{ return("new SingleElt<"+classIdent+">("+edControlVariableByName(classIdent)
	    +",new $NAME<"+classIdent+">() { public "+classIdent+" get(){return("+expr1.toJavaCode()+"); }})");
	}
	public String toString() { return(""+expr1); }
  }
  
  // ************************************************************************************
  // *** ForListElement  --  While Element
  // ************************************************************************************
  private class WhileElement extends ForListElement
  { Expression expr2;
	public WhileElement(Expression expr1,Expression expr2) { super(expr1); this.expr2=expr2; }  
	public void doChecking()
	{ if(Option.TRACE_CHECKER) Util.TRACE("BEGIN WhileElement("+this+").doChecking - Current Scope Chain: "+Global.currentScope.edScopeChain());
	  expr1.doChecking();
	  expr2.doChecking(); if(expr2.type!=Type.Boolean) Util.error("While "+expr2+" is not of type Boolean");
	  expr1=TypeConversion.testAndCreate(controlVariable.type,expr1);
	}
	public String edCode(String classIdent)
	{ return("new WhileElt<"+classIdent+">("+edControlVariableByName(classIdent)
			            +",new $NAME<"+classIdent+">() { public "+classIdent+" get(){return("+expr1.toJavaCode()+"); }}"
			            +",new $NAME<Boolean>() { public Boolean get(){return("+expr2.toJavaCode()+"); }})");
	}
	public String toString() { return(""+expr1+" while "+expr2); }
  }
  
  // ************************************************************************************
  // *** ForListElement  --  Step Until Element
  // ************************************************************************************
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
	public String edCode(String classIdent)
	{ expr1.backLink=ForStatement.this; // To ensure $result from functions
	  expr2.backLink=ForStatement.this; // To ensure $result from functions
	  expr3.backLink=ForStatement.this; // To ensure $result from functions
  	  return("new StepUntil("+edControlVariableByName(classIdent)
  	                     +",new $NAME<Number>() { public Number get(){return("+expr1.toJavaCode()+"); }}"
  	                     +",new $NAME<Number>() { public Number get(){return("+expr2.toJavaCode()+"); }}"
  	                     +",new $NAME<Number>() { public Number get(){return("+expr3.toJavaCode()+"); }})");
      
	}
	public String toString() { return(""+expr1+" step "+expr2+ " until "+expr3); }
  }

}
