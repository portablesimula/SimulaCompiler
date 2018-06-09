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
import simula.compiler.declaration.Parameter;
import simula.compiler.declaration.StandardProcedure;
import simula.compiler.declaration.Virtual;
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.BlockKind;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.ParameterKind;
import simula.compiler.utilities.ParameterMode;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;
import simula.compiler.utilities.VariableKind;

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
public class Variable extends Expression {
	public String identifier;
	public Meaning meaning;
	public boolean remotelyAccessed;
	
	public String getJavaIdentifier()
	{ return(meaning.declaredAs.getJavaIdentifier());	}
	
	public void setRemotelyAccessed(Meaning meaning) {
		this.meaning = meaning;
		remotelyAccessed=true;
		this.doChecking();	
		SET_SEMANTICS_CHECKED(); // Checked as remote attribute
	}

	public Meaning getMeaning() {
	  if (meaning == null)
		  meaning = Global.currentScope.findMeaning(identifier);
	  Util.ASSERT(meaning.declaredIn!=null,"Invariant");
	  return (meaning);
    }

	public Variable(String identifier) {
		this.identifier = identifier;
		if (Option.TRACE_PARSE) Util.TRACE("NEW Variable: " + identifier);
		// Util.BREAK("NEW Variable: "+this);
	}

	public static Variable parse(String ident) {
		if (Option.TRACE_PARSE)
			Util.TRACE("Parse Variable, current=" + Parser.currentToken + ", prev="	+ Parser.prevToken);
		Variable var = new Variable(ident);
		if (Parser.accept(KeyWord.BEGPAR))
			var = SubscriptedVariable.doParse(ident);
		return(var);
	}

	// Is redefined in Variable, RemoteVariable and TypeConversion
	public Variable getWriteableVariable() { return(this); }

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Util.setLine(lineNumber);
		//Util.BREAK("BEGIN Variable("+identifier+").doChecking - Current Scope Chain: "+currentScope.edScopeChain());
		this.type=getMeaning().declaredAs.type;
		//Util.BREAK("END Variable("+identifier+").doChecking: type="+type+", Declared as: "+meaning);
		if(identifier.equalsIgnoreCase("detach"))
		{ //Util.BREAK("Variable("+identifier+").doChecking: type="+type+", Declared as: "+meaning);
		  //Util.BREAK("Variable("+identifier+").doChecking: Declared as'Qual: "+meaning.declaredAs.getClass().getSimpleName());
		  //Util.BREAK("Variable("+identifier+").doChecking: Declared in'Qual: "+meaning.declaredIn.getClass().getSimpleName());
		  if(meaning.declaredAs instanceof StandardProcedure)
		  { //Util.BREAK("Variable("+identifier+").doChecking: type="+type+", Declared as: "+meaning.declaredAs);
		    //Util.BREAK("Variable("+identifier+").doChecking: type="+type+", Declared in: "+meaning.declaredIn);
			meaning.declaredIn.detachUsed=true;
			//Util.BREAK("Variable("+identifier+").doChecking: (Class "+meaning.declaredIn.identifier+").detachUsed=true");
		  }
		}
		SET_SEMANTICS_CHECKED();
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
				&& ((Parameter)meaning.declaredAs).mode == ParameterMode.name) {
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
		  if(par.mode == ParameterMode.name) result = result + ".get()";
		  if(par.kind == ParameterKind.Procedure)
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
	  BlockKind blockKind=decl.blockKind;
	  //Util.BREAK("Variable.edVariable("+id+"): meaning="+meaning+", remotelyAccessed="+remotelyAccessed+", destination="+destination);
	  //Util.BREAK("Variable.edVariable("+id+"): decl="+decl+", BlockKind="+blockKind+", qual="+decl.getClass().getSimpleName());
	  int n=meaning.declaredIn.blockLevel;

	  if(blockKind==BlockKind.Procedure || blockKind==BlockKind.Method)
	  { // This Variable is a Procedure-Identifier.
		// When 'destination' it is a variable used to carry the resulting value until the final return.
		// otherwise; it is a no-parameter-procedure/method-call.
		if(destination)
		{ // return("$result");
			BlockDeclaration proc=(BlockDeclaration)meaning.declaredAs;
		    int k=proc.blockLevel;
			if(k==Global.currentScope.blockLevel) return("$result");
		    String cast=proc.getJavaIdentifier();
		    return("(("+cast+")"+Global.currentScope.edCTX(k)+").$result");
		}
		if(remotelyAccessed)
		{ id=id+"()";
		  if(decl instanceof Virtual) id=id+".CPF()";
		  return(id);
		}
		if(blockKind==BlockKind.Procedure)
		{ //Util.BREAK("Variable.edVariable("+id+"): decl="+decl+", qual="+decl.getClass().getSimpleName());
		  if(decl instanceof Virtual)
		  { Virtual virtual=(Virtual)decl;
	         id=CallProcedure.virtual(this,virtual,remotelyAccessed); 
		  }
		  else 
		  { BlockDeclaration procedure=(BlockDeclaration)decl;
		    if(procedure.myVirtual!=null)
		         id=CallProcedure.virtual(this,procedure.myVirtual,remotelyAccessed);
		    else id=CallProcedure.normal(this);
		  }
		}
		else if(blockKind==BlockKind.Method)
		{ //Util.BREAK("Variable.getDisplayedIdentifier2m("+id+"): decl="+decl+", qual="+decl.getClass().getSimpleName());
	      id=CallProcedure.asNormalMethod(this);
		}
		return(id);
	  }
	  // VANLIG VARIABEL/PARAMETER ...
	  //Util.BREAK("VANLIG VARIABEL/PARAMETER ...");
	  //Util.BREAK("VANLIG VARIABEL/PARAMETER: id="+id);
	  if(remotelyAccessed) return(id);
	  
	  if(meaning.variableKind==VariableKind.connectedAttribute)
	  { Expression inspectedVariable=((ConnectionBlock)meaning.declaredIn).getInspectedVariable();
	    //Util.BREAK("Variable.toJavaCode: INSPECT - remoteAttribute="+meaning);
	    if(meaning.foundBehindInvisible)
	    { String remoteCast=meaning.foundIn.getJavaIdentifier();
		  id="(("+remoteCast+")("+inspectedVariable.toJavaCode()+"))."+id;
	    } else id=inspectedVariable.toJavaCode()+"."+id;
	  } else if(!(Option.standardClass && meaning.declaredIn.blockKind==BlockKind.Method)) {
	    String cast=meaning.declaredIn.getJavaIdentifier();
	    if(meaning.foundBehindInvisible) cast=meaning.foundIn.getJavaIdentifier();
	    else if(n==Global.currentScope.blockLevel) return(id);  // currentScope may be a sub-block  TODO: Check Dette !
	    id="(("+cast+")"+Global.currentScope.edCTX(n)+")."+id;
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
