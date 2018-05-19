/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.expression;

import java.util.Iterator;
import java.util.Vector;

import simula.compiler.declaration.ArrayDeclaration;
import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.BlockDeclaration;
import simula.compiler.declaration.Parameter;
import simula.compiler.declaration.Virtual;
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.BlockKind;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.OverLoad;
import simula.compiler.utilities.ParameterKind;
import simula.compiler.utilities.ParameterMode;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Subscripted Variable.
 * <pre>
 * Syntax:
 * 
 *	SubscriptedVariable = FunctionDesignator | ArrayElement
 * 
 *  FunctionDesignator = ProcedureIdentifier ( [ ActualParameterPart ] )
 *  
 * 	ActualParameterPart = ActualParameter { , ActualParameter }
 * 		ActualParameter = Expression | ArrayIdentifier1 
 *                      | SwitchIdentifier1 | ProcedureIdentifier1
 * 			Identifier1 = Identifier | RemoteIdentifier
 * 				RemoteIdentifier = SimpleObjectExpression . AttributeIdentifier
 * 								 | TextPrimary . AttributeIdentifier
 *
 *	ArrayElement = ArrayIdentifier [ SubscriptList ]
 *		SubscriptList ::= ArithmeticExpression { , ArithmeticExpression }
 * 
 * </pre>
 * <b>Function designators:</b>
 * <p>
 * A function designator defines a value which results through the application
 * of a given set of rules defined by a procedure declaration (see 5.4) to a
 * fixed set of actual parameters. The rules governing specification of actual
 * parameters are given in 4.6.
 * 
 * Note: Not every procedure declaration defines rules for determining the value
 * of a function designator (cf. 5.4.1).
 * <p>
 * <b>Array elements:</b>
 * <p>
 * Subscripted variables designate values which are components of multi-
 * dimensional arrays. Each arithmetic expression of the subscript list occupies
 * one subscript position of the subscripted variable and is called a subscript.
 * The complete list of subscripts is enclosed by the subscript parentheses ( )
 * . The array component referred to by a subscripted variable is specified by
 * the actual value of its subscripts.
 * <p>
 * Each subscript position acts like a variable of type integer and the
 * evaluation of the subscript is understood to be equivalent to an assignment
 * to this fictitious variable. The value of the subscripted variable is defined
 * only if the actual integer value of each subscript expression is within the
 * associated subscript bounds of the array. A subscript expression value
 * outside its associated bounds causes a run time error.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 */
public class SubscriptedVariable extends Variable {
	Vector<Expression> params = new Vector<Expression>();
	public Vector<Expression> checkedParams; // Set by doChecking

	public SubscriptedVariable(String identifier)
	{ super(identifier);
	  //Util.BREAK("NEW SubscriptedVariable: " + identifier);
	}
	
	public static SubscriptedVariable doParse(String identifier) {
		SubscriptedVariable subscriptedVariable=new SubscriptedVariable(identifier);
		if (Option.TRACE_PARSE)
			Util.TRACE("Parse SubscriptedVariable, current=" + Parser.currentToken+ ", prev=" + Parser.prevToken);
		if (!Parser.accept(KeyWord.ENDPAR)) {
			do { subscriptedVariable.params.add(parseExpression());
			} while (Parser.accept(KeyWord.COMMA));
			Parser.expect(KeyWord.ENDPAR);
		}
		if (Option.TRACE_PARSE)
			Util.TRACE("NEW SubscriptedVariable: " + subscriptedVariable.toString());
		return(subscriptedVariable);
	}
	
	public void doChecking()
    { if(IS_SEMANTICS_CHECKED()) return;
		Util.setLine(lineNumber);
		//Util.BREAK("BEGIN SubscriptedVariable("+identifier+").doChecking");
		super.doChecking();
		
		checkedParams = new Vector<Expression>();
		Declaration decl=meaning.declaredAs;
		//Util.BREAK("BEGIN SubscriptedVariable("+identifier+").doChecking: meaning="+meaning);
		if(decl instanceof ArrayDeclaration) // Declared Array
		{ ArrayDeclaration array=(ArrayDeclaration)decl;
		  this.type=array.type;
		  // Check parameters
		  Iterator<ArrayDeclaration.BoundPair> formalIterator=array.getBoundPairList().iterator();
		  Iterator<Expression> actualIterator=params.iterator();
		  while(actualIterator.hasNext())
		  { if(!formalIterator.hasNext()) Util.error("Wrong number of indices to "+array);
		    ArrayDeclaration.BoundPair formalParameter=formalIterator.next();
//		    Type formalType=Type.Integer;
		    if(Option.TRACE_CHECKER) Util.TRACE("Formal Parameter: "+formalParameter);
		    Expression actualParameter=actualIterator.next();
		    actualParameter.doChecking();
			Expression checkedParameter=TypeConversion.testAndCreate(Type.Integer,actualParameter);
			checkedParameter.backLink=this;
			checkedParams.add(checkedParameter);
		  }
		  if(formalIterator.hasNext()) Util.error("Wrong number of indices to "+array);
		}
		else
		if(decl instanceof BlockDeclaration) // Declared Procedure or Prefix class or Prefixed Block
		{	BlockDeclaration block = (BlockDeclaration) decl;
			//Util.BREAK("SubscriptedVariable("+identifier+") blockHead="+blockHead);
			this.type=block.type;
			Type overloadedType=this.type;
			// Check parameters
			Iterator<Parameter> formalIterator = block.parameterIterator();
			Iterator<Expression> actualIterator = params.iterator();
			//Util.BREAK("SubscriptedVariable("+identifier+").doChecking: Params="+params);
			while (actualIterator.hasNext()) {
				if (!formalIterator.hasNext()) Util.error("Wrong number of parameters to " + block);
				Parameter formalParameter = (Parameter)formalIterator.next();
				Type formalType = formalParameter.type;
				//Util.BREAK("Formal Parameter: " + formalParameter + ", Formal Type=" + formalType);
				Expression actualParameter = actualIterator.next();
				//Util.BREAK("Actual Parameter: " + actualParameter);
				actualParameter.doChecking();
				//Util.BREAK("Actual Parameter: " + actualParameter.type + " "	+ actualParameter + ", Actual Type=" + actualParameter.type);
				if(Global.OVERLOADING && formalType instanceof OverLoad)
				{ //Util.BREAK("SubscriptedVariable.doChecking(1): "+this);
				  formalType=actualParameter.type; // TODO: AD'HOC for add/subepsilon
				  overloadedType=formalType;
				}
				Expression checkedParameter=TypeConversion.testAndCreate(formalType,actualParameter);
				checkedParameter.backLink=this;
				checkedParams.add(checkedParameter);
				//Util.BREAK("SubscriptedVariable("+identifier+").doChecking().addCheckedParam: "+checkedParams);
			}
			if (formalIterator.hasNext()) Util.error("Wrong number of parameters to " + block);
			if(Global.OVERLOADING && type instanceof OverLoad)
			{ //Util.BREAK("SubscriptedVariable.doChecking(2): "+this);
			  this.type=overloadedType;
			}
			
    	} else if (decl instanceof Parameter) // Parameter Array, Procedure, ... ???
		{ Parameter spec=(Parameter) decl;
    	  ParameterKind kind=spec.kind;
    	  //Util.BREAK("SubscriptedVariable.doChecking: kind="+kind);
    	  Util.ASSERT(kind==ParameterKind.Array || kind==ParameterKind.Procedure,"Invariant ?");
    	  {	this.type=spec.type;
//    	    Util.warning("SubscriptedVariable("+identifier+") - Parameter Checking is postponed to Runtime");
    	    Iterator<Expression> actualIterator=params.iterator();
    	    while(actualIterator.hasNext())
    	    { Expression actualParameter=actualIterator.next();
    	      actualParameter.doChecking();
    	      if(kind==ParameterKind.Array && !actualParameter.type.isArithmeticType()) Util.error("Illegal index-type");
    	      
    		  //checkedParams.add(actualParameter);
    	      if(kind==ParameterKind.Array)
  			  { Expression checkedParameter=TypeConversion.testAndCreate(Type.Integer,actualParameter);
  			    checkedParameter.backLink=this;
  			    checkedParams.add(checkedParameter);
  			  } else checkedParams.add(actualParameter);
    	    }
    	  }
    	} else if (decl instanceof Virtual) // Parameter Array, Procedure, ... ???
		{ Virtual spec=(Virtual) decl;
      	  { this.type=spec.type;
      	    Util.warning("SubscriptedVariable("+identifier+") - Parameter Checking is postponed to Runtime");
      	    Iterator<Expression> actualIterator=params.iterator();
      	    while(actualIterator.hasNext())
      	    { Expression actualParameter=actualIterator.next();
      	      actualParameter.doChecking();
      		  checkedParams.add(actualParameter);
      	    }
      	  }
		}
	    else Util.FATAL_ERROR("Umulig å komme hit ??");
		if (Option.TRACE_CHECKER)
			Util.TRACE("END SubscriptedVariable(" + identifier+ ").doChecking: type=" + type);
	    //Util.BREAK("END SubscriptedVariable("+identifier+").doChecking: type=" + type+", checkedParams="+checkedParams);
		SET_SEMANTICS_CHECKED();
	}
		
	// **********************************************************************************************
	// *** CODE: put - Generate code for putting an value(expression) into this SubscriptedVariable
	// **********************************************************************************************
	public String put(String rightPart)
	{ ASSERT_SEMANTICS_CHECKED(this);
	  return(this.toJavaCode()+"="+rightPart);
	}

	// **********************************************************************************************
	// *** CODE: get - Generate code for getting the value of this SubscriptedVariable
	// **********************************************************************************************
	public String get()
	{ //Util.BREAK("SubscriptedVariable("+identifier+").get: meaning="+meaning);
	  ASSERT_SEMANTICS_CHECKED(this);
	  StringBuilder s = new StringBuilder();
	  Expression connectedObject=meaning.getInspectedVariable();
	  Declaration decl=meaning.declaredAs;
	  if(decl instanceof ArrayDeclaration) // Declared Array
	  { //ArrayDeclaration array=(ArrayDeclaration)decl;
	    //Util.BREAK("SubscriptedVariable("+identifier+").get: ArrayDeclaration="+array);
	    int nDim=0;
	    s.append(edVariable(false)).append(".Elt"); //[x-M.LB[1]]");
		for(Expression ix:checkedParams) {
		     String index="["+ix.toJavaCode()+"-"+edVariable(false)+".LB["+(nDim++)+"]]";
		     s.append(index);
		}
	  }
	  else
	  if(decl instanceof BlockDeclaration) // Declared Procedure
	  {	BlockDeclaration procedure = (BlockDeclaration) decl;
	    BlockKind blockKind=decl.blockKind;
	    //Util.BREAK("SubscriptedVariable3("+identifier+").get: blockKind="+blockKind);
	    if(blockKind==BlockKind.Method) // Standard Procedure
	       s.append(CallProcedure.asNormalMethod(this));
	    else if(procedure.myVirtual!=null)
	       s.append(CallProcedure.virtual(this,procedure.myVirtual,remotelyAccessed));
	    else if(blockKind==BlockKind.Procedure || blockKind==BlockKind.Switch)
	       s.append(CallProcedure.normal(this));
	    else Util.FATAL_ERROR("Umulig å komme hit ??");
	    
	  }
	  else if (decl instanceof Parameter) // Parameter Array, Procedure, ... ???
	  {	//if(connectedObject!=null) s.append(connectedObject.toJavaCode()).append('.');
	    Parameter par=(Parameter)decl;
		ParameterKind kind=par.kind;  
		if(kind==ParameterKind.Array) // Parameter Array
		{ int nDim=0;
		  //if(connectedObject!=null) s.append(connectedObject.toJavaCode()).append('.');
	      String var=edVariable(false);
		  if(connectedObject!=null) var=connectedObject.toJavaCode()+'.'+var;
	  	  if(par.mode==ParameterMode.name) var=var+".get()";
	  	  StringBuilder ixs=new StringBuilder();
	  	  String dimBrackets="";
	  	  for(Expression ix:checkedParams) {
			  String index="["+ix.toJavaCode()+"-"+var+".LB["+(nDim++)+"]]"; 
			  ixs.append(index);
			  dimBrackets=dimBrackets+"[]";
		  }
	  	  String eltType=type.toJavaType();
	  	  String cast="$ARRAY<"+eltType+dimBrackets+">";
	  	  String castedVar="(("+cast+")"+var+")";
	  	  s.append(castedVar).append(".Elt").append(ixs);
		}
		else if(kind==ParameterKind.Procedure) // Parameter Procedure
	    { if(connectedObject!=null) s.append(connectedObject.toJavaCode()).append('.');
		  if(par.mode==ParameterMode.value)
	          Util.error("Parameter "+this+" by Value is not allowed - Rewrite Program");
		  else // Procedure By Reference or Name.
	      	  s.append(CallProcedure.formal(this,par)); 
		}
	  }
	  else if (decl instanceof Virtual) // Virtual Procedure
	       s.append(CallProcedure.virtual(this,(Virtual)decl,remotelyAccessed));
	  else Util.FATAL_ERROR("Umulig å komme hit ??");
	  String result=s.toString();
	  return(result);
	}
	
	public String toJavaCode()
	{ return(this.get()); }

	
	public String toString() {
		return (("" + identifier + params).replace('[', '(').replace(']', ')'));
	}
	
}
