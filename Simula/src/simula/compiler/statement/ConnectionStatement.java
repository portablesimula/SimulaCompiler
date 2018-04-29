/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.statement;

import java.util.Enumeration;
import java.util.Vector;

import simula.compiler.declaration.ConnectionBlock;
import simula.compiler.declaration.BlockDeclaration;
import simula.compiler.declaration.DeclarationScope;
import simula.compiler.declaration.TypeDeclaration;
import simula.compiler.expression.BinaryOperation;
import simula.compiler.expression.Expression;
import simula.compiler.expression.Variable;
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Connection Statement.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 * connection-statement = INSPECT object-expression  connection-part [ OTHERWISE statement ]
 *		connection-part = DO statement | selective-part
 *			selective-part = { WHEN <class identifier> DO <statement> }
 *
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public class ConnectionStatement extends Statement
{ Expression objectExpression;
  Variable inspectedVariable;
  TypeDeclaration inspectVariableDeclaration;
  BinaryOperation assignment;
  Vector<DoPart> connectionPart=new Vector<DoPart>();
  Statement otherwise;
  boolean hasWhenPart;

  public ConnectionStatement()
  { if(Option.TRACE_PARSE) Parser.TRACE("Parse ConnectionStatement");
    objectExpression=Expression.parseExpression();
    
    if(objectExpression.getClass() == Variable.class) // objectExpression IS Variable
         inspectedVariable=(Variable)objectExpression;
    else inspectedVariable=createInspectVariable(objectExpression);
    
    if(Parser.accept(KeyWord.DO))
    { ConnectionBlock connectionBlock=new ConnectionBlock(inspectedVariable);
      Statement statement=Statement.doParse();
      connectionPart.add(new DoPart(connectionBlock,statement));
      connectionBlock.end();
    }
    else
    { while(Parser.accept(KeyWord.WHEN))
      { String classIdentifier=expectIdentifier();
        Parser.expect(KeyWord.DO);
        ConnectionBlock connectionBlock=new ConnectionBlock(inspectedVariable);
        hasWhenPart=true;
        Statement statement=Statement.doParse();
        connectionPart.add(new WhenPart(classIdentifier,connectionBlock,statement));
        connectionBlock.end();
      }
    	
    }
    otherwise=null;
    if(Parser.accept(KeyWord.OTHERWISE)) otherwise=Statement.doParse();
    if(Option.TRACE_PARSE) Util.TRACE("END NEW ConnectionStatement: "+toString());
  }
  
  private Variable createInspectVariable(Expression objectExpression)
  { //Util.BREAK("ConnectionStatement.createInspectVariable: type="+objectExpression.type+", objectExpression="+objectExpression);
    String ident="inspect$Object"+lineNumber;
    Variable var=new Variable(ident);
	inspectVariableDeclaration=new TypeDeclaration(Type.Ref("RTObject"),ident);

	//Util.BREAK("ConnectionStatement.createInspectVariable: "+inspectVariableDeclaration);
	//Util.BREAK("ConnectionStatement.createInspectVariable: ADD IT TO "+Global.currentScope);
	DeclarationScope scope=Global.currentScope;
	//Util.BREAK("ConnectionStatement.createInspectVariable: QUAL "+scope.getClass().getSimpleName());
	
	while(scope instanceof ConnectionBlock)
	{ scope=scope.declaredIn;
	  Util.BREAK("ConnectionStatement.createInspectVariable: QUAL "+scope.getClass().getSimpleName());
	}
	
//	currentScope.declaredIn.declarationList.add(inspectVariableDeclaration);
	scope.declarationList.add(inspectVariableDeclaration);
	assignment=new BinaryOperation(var,KeyWord.ASSIGNREF,objectExpression);
	return(var);
  }


  class DoPart
  { String refIdentifier;
    ConnectionBlock connectionBlock;
	public DoPart(ConnectionBlock connectionBlock,Statement statement)
	{ this.connectionBlock=connectionBlock; //this.statement=statement;
	  connectionBlock.setStatement(statement);
	  if(Option.TRACE_PARSE) Util.TRACE("NEW DoPart: " + toString());
	}

	public void doChecking()
	{ Type type=inspectedVariable.type;
	  refIdentifier=type.getRefIdent();
      //Util.BREAK("ConnectionStatement.DoPart.doChecking: ");
	  if(refIdentifier==null) Util.error("The Variable "+inspectedVariable+" is not ref() type");
	  connectionBlock.setClassDeclaration(BinaryOperation.getQualification(refIdentifier));	
	  connectionBlock.doChecking();
	  SET_SEMANTICS_CHECKED();
	}
	
	public void doCoding(String indent,boolean first)
	{ ASSERT_SEMANTICS_CHECKED(this);
	  connectionBlock.doJavaCoding(indent);
	}
	
	public void print(String indent)
	{ System.out.println(indent+"DO ");
	  connectionBlock.print(indent,";");
	}

	public String toString() { return(connectionBlock.toString()); }
  }

  class WhenPart extends DoPart
  { String classIdentifier;
    BlockDeclaration classDeclaration; // Set during checking.
    boolean impossibleWhenPart; // Set by doChecking
	public WhenPart(String classIdentifier,ConnectionBlock connectionBlock,Statement statement)
	{ super(connectionBlock,statement);
	  this.classIdentifier=classIdentifier;
	  if(Option.TRACE_PARSE) Util.TRACE("NEW DoPart: " + toString());
	}

	public void doChecking()
	{ if(classIdentifier==null && objectExpression!=null)
	  { Type type=inspectedVariable.type;
	    classIdentifier=type.getRefIdent();
	    if(classIdentifier==null) Util.error("The Variable "+inspectedVariable+" is not ref() type");
	  }
      //Util.BREAK("ConnectionStatement.WhenPart.doChecking: ");
	  if(classIdentifier!=null)
	  {	classDeclaration=BinaryOperation.getQualification(classIdentifier);
		connectionBlock.setClassDeclaration(classDeclaration);
	  }
	  if(!BinaryOperation.checkCompatability(objectExpression,classIdentifier))
	  { Util.warning("Impossible When Part: "+objectExpression+" is not compatible with "+classIdentifier);
	    impossibleWhenPart=true;
	  }
	  connectionBlock.doChecking();
	}
	
	public void doCoding(String indent,boolean first)
	{ //Util.BREAK("ConnectionStatement.WhenPart.doCoding: statement="+statement.getClass().getName());
	  ASSERT_SEMANTICS_CHECKED(this);
	  String prfx=(first)?indent:indent+"else ";
	  String cid=classDeclaration.getJavaIdentifier();
	  if(!impossibleWhenPart)
	  { Util.code(prfx+"if("+inspectedVariable.toJavaCode()+" instanceof "+cid+") // WHEN "+cid+" DO ");
	    connectionBlock.doJavaCoding(indent);
	  } else Util.code(prfx+"// WHEN "+cid+" DO -- IMPOSSIBLE REMOVED");
	}
	
	public void print(String indent)
	{ System.out.println(indent+"WHEN "+classIdentifier+" DO ");
	  connectionBlock.print(indent,";");
	}
	
	public String toString()
	{ return("WHEN "+classIdentifier+" DO ..."); }//+statement);	}
  }

  public void doChecking()
  { if(IS_SEMANTICS_CHECKED()) return;
    Util.setLine(lineNumber);
    if(Option.TRACE_CHECKER) Util.TRACE("BEGIN ConnectionStatement("+toString()+").doChecking - Current Scope Chain: "+Global.currentScope.edScopeChain());

    objectExpression.doChecking();
    if(inspectVariableDeclaration!=null)
    { Type objType=objectExpression.type;
   	  inspectVariableDeclaration.type=objType;
      //Util.BREAK("ConnectionStatement.doChecking(2): objType="+objType+", inspectedVariable="+inspectedVariable);
    }
    inspectedVariable.doChecking();
    //Util.BREAK("ConnectionStatement.doChecking(3): objType="+inspectedVariable.type+", inspectedVariable="+inspectedVariable);
    if(assignment!=null) assignment.doChecking();
    for(Enumeration<DoPart> e=connectionPart.elements(); e.hasMoreElements();)
    { e.nextElement().doChecking(); }
    if(otherwise!=null) otherwise.doChecking();
	SET_SEMANTICS_CHECKED();
  }
  
  public void doJavaCoding(String indent)
  {	Util.setLine(lineNumber);
	ASSERT_SEMANTICS_CHECKED(this);
    if(assignment!=null) Util.code(indent+assignment.toJavaCode()+';');	
    if(hasWhenPart) Util.code(indent+"//"+"INSPECT "+inspectedVariable);
    else Util.code(indent+"if("+inspectedVariable.toJavaCode()+"!=null) //"+"INSPECT "+inspectedVariable);
    boolean first=true;
    for(Enumeration<DoPart> e=connectionPart.elements(); e.hasMoreElements();)
    { e.nextElement().doCoding(indent,first); first=false; }
    if(otherwise!=null)
    { Util.code(indent+"   else // OTHERWISE ");
      otherwise.doJavaCoding(indent+"      ");
      Util.code(indent+"   // END OTHERWISE ");
    }
    Util.code(indent+"// END INSPECTION ");
  }
  
  // ***********************************************************************************************
  // *** Printing Utility: print
  // ***********************************************************************************************
  public void print(String indent,String tail)
  { System.out.println(indent+"INSPECT "+inspectedVariable);
    for(DoPart doPart:connectionPart) doPart.print(indent);
    if(otherwise!=null)
    { System.out.println(indent+"   OTHERWISE "+otherwise+';'); }
  }

  public String toString()
  { String otherwisePart="";
    if(otherwise!=null) otherwisePart=" OTHERWISE "+otherwise;
	return("INSPECT "+inspectedVariable+" "+connectionPart+otherwisePart);
  }
  
}
