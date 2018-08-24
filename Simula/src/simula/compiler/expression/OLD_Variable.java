/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.expression;

import simula.compiler.declaration.BlockDeclaration;
import simula.compiler.declaration.ConnectionBlock;
import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.LabelDeclaration;
import simula.compiler.declaration.Parameter;
import simula.compiler.declaration.StandardProcedure;
import simula.compiler.declaration.Virtual;
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Variable.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 * Variable = SimpleObjectExpression . Variable | SimpleVariable | SubscriptedVariable
 * 
 * 	SimpleObjectExpression = NONE | Variable | FunctionDesignator | ObjectGenerator
 *                             | LocalObject | QualifiedObject | ( ObjectExpression)
 *                             
 * 	SimpleVariable = Identifier
 * 
 * 	SubscriptedVariable = ArrayIdentifier [ SubscriptList ]
 * 			SubscriptList ::= ArithmeticExpression { , ArithmeticExpression }
 * 
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public class OLD_Variable extends Expression {
	public String identifier;
	public Meaning meaning;
	public boolean remotelyAccessed;
	
	public enum Kind {
		parameter,attribute,label,virtual,standardAttribute,connectedAttribute
	}
	
	public String getJavaIdentifier()
	{ return(meaning.declaredAs.getJavaIdentifier());	}
	
	public void setRemotelyAccessed(Meaning meaning) {
		this.meaning = meaning;
		remotelyAccessed=true;
		this.doChecking();	
		SET_SEMANTICS_CHECKED(); // Checked as remote attribute
	}

	public Meaning getMeaning() {
	  //Util.BREAK("BEGIN Variable("+identifier+").getMeaning - meaning="+meaning);
	  if (meaning == null)
		  meaning = Global.currentScope.findMeaning(identifier);
	  Util.ASSERT(meaning.isNO_MEANING() || meaning.declaredIn!=null,"Invariant");
	  return (meaning);
    }

	public OLD_Variable(String identifier) {
		this.identifier = identifier;
		if (Option.TRACE_PARSE) Util.TRACE("NEW Variable: " + identifier);
		// Util.BREAK("NEW Variable: "+this);
	}

	public static OLD_Variable parse(String ident) {
		if (Option.TRACE_PARSE)
			Util.TRACE("Parse Variable, current=" + Parser.currentToken + ", prev="	+ Parser.prevToken);
		OLD_Variable var = new OLD_Variable(ident);
		if (Parser.accept(KeyWord.BEGPAR))
			var = SubscriptedVariable.doParse(ident);
		return(var);
	}

	// Is redefined in Variable, RemoteVariable and TypeConversion
	public OLD_Variable getWriteableVariable() { return(this); }

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		//Util.BREAK("BEGIN Variable("+identifier+").doChecking - Current Scope Chain: "+currentScope.edScopeChain());
		Declaration declaredAs=getMeaning().declaredAs;
		if(declaredAs!=null) this.type=declaredAs.type;
		//Util.BREAK("END Variable("+identifier+").doChecking: type="+type+", Declared as: "+meaning);
		if(meaning.declaredAs instanceof StandardProcedure)
		{ //Util.BREAK("Variable("+identifier+").doChecking: type="+type+", Declared as: "+meaning);
		  //Util.BREAK("Variable("+identifier+").doChecking: Declared as'Qual: "+meaning.declaredAs.getClass().getSimpleName());
		  //Util.BREAK("Variable("+identifier+").doChecking: Declared in'Qual: "+meaning.declaredIn.getClass().getSimpleName());
//		  if(meaning.declaredAs instanceof StandardProcedure)
		  if(identifier.equalsIgnoreCase("detach"))
		  { //Util.BREAK("Variable("+identifier+").doChecking: type="+type+", Declared as: "+meaning.declaredAs);
		    //Util.BREAK("Variable("+identifier+").doChecking: type="+type+", Declared in: "+meaning.declaredIn);
			meaning.declaredIn.detachUsed=true;
			//Util.BREAK("Variable("+identifier+").doChecking: (Class "+meaning.declaredIn.identifier+").detachUsed=true");
		  }
		}
		SET_SEMANTICS_CHECKED();
	}

	  // Returns true if this expression may be used as a statement.
	  public boolean maybeStatement()
	  {	ASSERT_SEMANTICS_CHECKED(this);
		Declaration declaredAs=meaning.declaredAs;
		BlockDeclaration.Kind blockKind=declaredAs.blockKind;
		//Util.BREAK("Variable.maybeStatement("+identifier+"): meaning="+meaning);
		//Util.BREAK("Variable.maybeStatement("+identifier+"): declaredAs="+declaredAs+", BlockDeclaration.Kind="+blockKind+", qual="+declaredAs.getClass().getSimpleName());
		if(blockKind==BlockDeclaration.Kind.Procedure) return(true);
		if(blockKind==BlockDeclaration.Kind.Method) return(true);
		if(declaredAs instanceof Parameter)
		{ Parameter par=(Parameter)declaredAs;
		  if(par.kind==Parameter.Kind.Procedure) return(true);
		}
		return(false); // Variable, Parameter, Array, Class, Switch
	  }

	// ******************************************************************
	// *** Coding: put
	// ******************************************************************
	// Generate code for putting an value(expression) into this Variable
	public String put(String rightPart) {
		//Util.BREAK("Variable("+this+").put("+rightPart+")");
		String result = this.edVariable(true); // Is a Destination
		//Util.BREAK("Variable("+result+").put("+rightPart+")");
		ASSERT_SEMANTICS_CHECKED(this);
		if(meaning.declaredAs instanceof Parameter
				&& ((Parameter)meaning.declaredAs).mode == Parameter.Mode.name) {
				result = result + ".put(" + rightPart + ')';
		} else
			result = result + '=' + rightPart;
		return (result);
	}

	// ******************************************************************
	// *** Coding: get
	// ******************************************************************
	// Generate code for getting the value of this Variable
	public String get() {
		ASSERT_SEMANTICS_CHECKED(this);
//		Util.BREAK("Variable("+identifier+").get() DeclaredAs="+declaredAs);
//		Util.BREAK("Variable("+identifier+").get() Meaning="+meaning);
		String result = this.edVariable(false); // Not a destination
//		Util.BREAK("Variable("+result+").get() DeclaredAs="+meaning.declaredAs);
		if(meaning.declaredAs instanceof Parameter)
		{ Parameter par=(Parameter)meaning.declaredAs;
		  if(par.mode == Parameter.Mode.name) result = result + ".get()";
		  if(par.kind == Parameter.Kind.Procedure)
		  {	//result = result + ".CPF().STM()";
			Type type=par.type;
			if(type!=null)
			{ result="("+type.toJavaType()+')'+result;
			  result = result + ".CPF().$result()";
			} else result = result + ".CPF()";
		  }
		}
		return (result);
	}
	
	// ******************************************************************
	// *** Coding: edVariable
	// ******************************************************************
	protected String edVariable(boolean destination)
	{ Declaration decl=meaning.declaredAs;
	  String id=decl.getJavaIdentifier();
	  BlockDeclaration.Kind blockKind=decl.blockKind;
	  //Util.BREAK("Variable.edVariable("+id+"): meaning="+meaning+", remotelyAccessed="+remotelyAccessed+", destination="+destination);
	  //Util.BREAK("Variable.edVariable("+id+"): decl="+decl+", BlockDeclaration.Kind="+blockKind+", qual="+decl.getClass().getSimpleName());

	  if(blockKind==BlockDeclaration.Kind.Procedure || blockKind==BlockDeclaration.Kind.Method)
	  { // This Variable is a Procedure-Identifier.
		// When 'destination' it is a variable used to carry the resulting value until the final return.
		// otherwise; it is a no-parameter-procedure/method-call.
		if(destination)
		{ // return("$result");
			BlockDeclaration proc=(BlockDeclaration)meaning.declaredAs;
		    int k=proc.blockLevel;
			if(k==Global.currentScope.blockLevel) return("$result");
		    String cast=proc.getJavaIdentifier();
//		    return("(("+cast+")"+Global.currentScope.edCTX(k)+").$result");
		    return("(("+cast+")"+proc.edCTX()+").$result");
		}
		if(remotelyAccessed)
		{ id=id+"()";
		  if(decl instanceof Virtual) id=id+".CPF()";
		  return(id);
		}
		if(blockKind==BlockDeclaration.Kind.Procedure)
		{ //Util.BREAK("Variable.edVariable("+id+"): decl="+decl+", qual="+decl.getClass().getSimpleName());
		  if(decl instanceof Virtual)
		  { Virtual virtual=(Virtual)decl;
		    //Util.BREAK("Variable.edVariable("+id+"): virtual="+virtual);
		    //Util.BREAK("Variable.edVariable("+id+"): virtual'kind="+virtual.kind);
		    if(virtual.kind==Virtual.Kind.Label) id=id+"()";
		    else id=CallProcedure.virtual(this,virtual,remotelyAccessed); 
		  }
		  else 
		  { BlockDeclaration procedure=(BlockDeclaration)decl;
		    if(procedure.myVirtual!=null)
		         id=CallProcedure.virtual(this,procedure.myVirtual,remotelyAccessed);
		    else id=CallProcedure.normal(this);
		  }
		}
		else if(blockKind==BlockDeclaration.Kind.Method)
		{ //Util.BREAK("Variable.getDisplayedIdentifier2m("+id+"): decl="+decl+", qual="+decl.getClass().getSimpleName());
			if(meaning.declaredAs instanceof StandardProcedure) {
				if(identifier.equalsIgnoreCase("sourceline"))
			  		return(""+Global.sourceLineNumber);	}
			id=CallProcedure.asNormalMethod(this);
		}
		return(id);
	  }
	  else if(decl instanceof LabelDeclaration)
	  { //Util.BREAK("LABEL DECLARATION: "+decl);
	    LabelDeclaration label=(LabelDeclaration)decl;
	    //Util.BREAK("LABEL DECLARATION: myVirtual="+label.myVirtual);
	    if(label.myVirtual!=null) id=id+"()"; // Access Virtual Label as Method
	  }
	  // VANLIG VARIABEL/PARAMETER ...
	  //Util.BREAK("VANLIG VARIABEL/PARAMETER ...");
	  //Util.BREAK("VANLIG VARIABEL/PARAMETER: id="+id);
	  if(remotelyAccessed) return(id);
	  
	  if(meaning.variableKind==Variable.Kind.connectedAttribute)
	  { Expression inspectedVariable=((ConnectionBlock)meaning.declaredIn).getInspectedVariable();
	    //Util.BREAK("Variable.toJavaCode: INSPECT - remoteAttribute="+meaning);
	    if(meaning.foundBehindInvisible)
	    { String remoteCast=meaning.foundIn.getJavaIdentifier();
		  id="(("+remoteCast+")("+inspectedVariable.toJavaCode()+"))."+id;
	    } else id=inspectedVariable.toJavaCode()+"."+id;
	  } else if(!(Option.standardClass && meaning.declaredIn.blockKind==BlockDeclaration.Kind.Method)) {
	    String cast=meaning.declaredIn.getJavaIdentifier();
		int n=meaning.declaredIn.blockLevel;
	    if(meaning.foundBehindInvisible) cast=meaning.foundIn.getJavaIdentifier();
	    else if(n==Global.currentScope.blockLevel) return(id);  // currentScope may be a sub-block  TODO: Check Dette !
//	    id="(("+cast+")"+Global.currentScope.edCTX(n)+")."+id;
	    id="(("+cast+")"+meaning.declaredIn.edCTX()+")."+id;
	  }
	  return(id);
    }

	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED(this);
		return (get());
	}

	public String toString() {
		return ("" + identifier);
	}

}
