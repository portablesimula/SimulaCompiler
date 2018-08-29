/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import simula.compiler.expression.Expression;
import simula.compiler.expression.TypeConversion;
import simula.compiler.expression.Variable;
import simula.compiler.statement.Statement;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

public class ConnectionBlock extends DeclarationScope 
{ ClassDeclaration classDeclaration;
  public Variable inspectedVariable;
  Statement statement;
  public ClassDeclaration getClassDeclaration() { return(classDeclaration); } 
  
  
  public Expression getInspectedVariable()
  { Type type=classDeclaration.type;
    //Util.BREAK("ConnectionBlock.getInspectedVariable: classDeclaration="+classDeclaration+", type="+type);
    //Util.BREAK("ConnectionBlock.getInspectedVariable: inspectedVariable="+inspectedVariable+", type="+inspectedVariable.type);
	return((Expression)TypeConversion.testAndCreate(type,inspectedVariable));
  } 
  
  public ConnectionBlock(Variable inspectedVariable)
  { super("Inspect:"+inspectedVariable);
	blockKind=BlockKind.ConnectionBlock;
	this.inspectedVariable=inspectedVariable;
	//Util.BREAK("BEGIN ConnectionBlock: "+this+", Scope="+this.edScopeChain());
	//Util.BREAK("BEGIN ConnectionBlock: inspectedVariable="+inspectedVariable+", Type="+inspectedVariable.type);
  }
  
  public void end() 
  {	if(Option.TRACE_PARSE) Util.TRACE("END ConnectionBlock: "+this.edScopeChain());
	//Debug.BREAK("END ConnectionBlock: "+this.edScopeChain());
    Global.currentScope=declaredIn;
  }

  public void setClassDeclaration(ClassDeclaration classDeclaration)
  { this.classDeclaration=classDeclaration; }
  
  public void setStatement(Statement statement)
  { this.statement=statement; }

  public Meaning findMeaning(String identifier)
  { //if(identifier.equalsIgnoreCase("L"))Util.BREAK("ConnectionBlock("+this.identifier+").findMeaning("+identifier+")");
	Meaning result=classDeclaration.findRemoteAttributeMeaning(identifier);
    //if(identifier.equalsIgnoreCase("L"))Util.BREAK("ConnectionBlock("+this.identifier+").findMeaning("+identifier+") ==> "+result);
    if(result!=null)
        result=new Meaning(Variable.Kind.connectedAttribute
        		,result.declaredAs,this,result.foundIn,result.foundBehindInvisible);
    else if(declaredIn!=null) result=declaredIn.findMeaning(identifier);
	if(result==null) {
	    //if(identifier.equalsIgnoreCase("L"))Util.BREAK("ConnectionBlock("+this.identifier+").findMeaning("+identifier+") ==> UNDEFINED");
		Util.error("Undefined variable: "+identifier);
		result=new Meaning(null,null,null); // Error Recovery: No Meaning
	}
    return(result);
  }

//  public DeclarationScope findThis(String identifier)
//  { DeclarationScope result=null;
// 	//Util.BREAK("DeclarationScope("+this.identifier+").findThis("+identifier+"):");
//	if(identifier.equalsIgnoreCase(classDeclaration.identifier)) return(this);
//    else if(declaredIn!=null) result=declaredIn.findThis(identifier);
//    return(result);
//  }
  
  public void doChecking()
  { if(IS_SEMANTICS_CHECKED()) return;
   	Global.sourceLineNumber=lineNumber;
	
    // Set External Identifier
 	externalIdent=inspectedVariable.identifier+'$'+lineNumber;

 	Global.currentScope=this;	
    blockLevel=currentBlockLevel;
    //Util.BREAK("Begin Checking of "+getScopeName()+" BlockLevel="+getBlockLevel()+" - Current Scope Chain: "+edScopeChain());
    inspectedVariable.doChecking();	
	statement.doChecking();
	Global.currentScope=declaredIn;
	SET_SEMANTICS_CHECKED();
  }
  
  public void doJavaCoding(int indent) {
	Global.sourceLineNumber=lineNumber;
	ASSERT_SEMANTICS_CHECKED(this);
	statement.doJavaCoding(indent+1);  
  }
  
//  public String getJavaIdentifier()
//  {	return(inspectedVariable.toJavaCode()); }
  
  public String toJavaCode()
  {	return(inspectedVariable.toJavaCode()); }
  
  
  // ***********************************************************************************************
  // *** Printing Utility: print
  // ***********************************************************************************************
  public void print(String indent,String tail)
  { StringBuilder s=new StringBuilder(indent);
    s.append('[').append(blockLevel).append("] ");
    s.append(blockKind).append(' ').append(identifier);
    System.out.println(s.toString());
	String beg="begin["+edScopeChain()+']';
	indent=indent+"    ";
    System.out.println(indent+beg); 
    for(Declaration decl:declarationList) decl.print(indent+"   ",";");
    statement.print(indent+"   ",";");
	System.out.println(indent+"end["+edScopeChain()+']'+tail); 
	//Util.BREAK("ConnectionBlock.print DONE");
  }

  
  public String toString() { return("Inspect("+inspectedVariable+") do "+statement); }
}
