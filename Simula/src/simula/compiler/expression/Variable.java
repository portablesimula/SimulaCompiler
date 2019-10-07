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
import simula.compiler.declaration.ClassDeclaration;
import simula.compiler.declaration.ConnectionBlock;
import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.Parameter;
import simula.compiler.declaration.ProcedureDeclaration;
import simula.compiler.declaration.StandardProcedure;
import simula.compiler.declaration.VirtualSpecification;
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.OverLoad;
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
 * The complete list of subscripts is enclosed by the subscript parentheses ( ).
 * The array component referred to by a subscripted variable is specified by
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
public final class Variable extends Expression {
	public String identifier;
	public Meaning meaning;
	public boolean remotelyAccessed;

	Vector<Expression> params;
	public Vector<Expression> checkedParams; // Set by doChecking
	
	public boolean hasArguments() {
		return(params!=null);
	}
	public String getJavaIdentifier()
	{ return(meaning.declaredAs.getJavaIdentifier());	}
	
	public void setRemotelyAccessed(final Meaning meaning) {
		this.meaning = meaning;
		remotelyAccessed=true;
		this.doChecking();	
		SET_SEMANTICS_CHECKED(); // Checked as remote attribute
	}

	public Meaning getMeaning() {
	  if (meaning == null)
		  meaning = Global.currentScope.findMeaning(identifier);
	  Util.ASSERT(meaning.isNO_MEANING() || meaning.declaredIn!=null,"Invariant");
	  return (meaning);
    }

	public Variable(final String identifier) {
		this.identifier = identifier;
		if (Option.TRACE_PARSE) Util.TRACE("NEW Variable: " + identifier);
	}

	public static Variable parse(final String ident) {
		if (Option.TRACE_PARSE)
			Util.TRACE("Parse Variable, current=" + Parser.currentToken + ", prev="	+ Parser.prevToken);
		Variable variable = new Variable(ident);
		if (Parser.accept(KeyWord.BEGPAR)) {
			variable.params = new Vector<Expression>();
			do {
				Expression par=parseExpression();
				if(par==null) Util.error("Missing parameter identifier");
				variable.params.add(par);
			} while (Parser.accept(KeyWord.COMMA));
			Parser.expect(KeyWord.ENDPAR);
		}
		if (Option.TRACE_PARSE)	Util.TRACE("NEW Variable: " + variable);
		return(variable);
	}

	// Is redefined in Variable, RemoteVariable and TypeConversion
	public Variable getWriteableVariable() { return(this); }

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		Declaration declaredAs=getMeaning().declaredAs;
		if(declaredAs!=null) this.type=declaredAs.type;
		if(meaning.declaredAs instanceof StandardProcedure)	{
		    if(identifier.equalsIgnoreCase("detach")) {
		        if(meaning.declaredIn instanceof ConnectionBlock) {
		    	    ConnectionBlock conn=(ConnectionBlock)meaning.declaredIn;
		    	    conn.classDeclaration.detachUsed=true;
		        } else
		        	if(meaning.declaredIn instanceof ClassDeclaration) {
		        	((ClassDeclaration)meaning.declaredIn).detachUsed=true;
		        } else Util.error("Variable("+identifier+").doChecking:INTERNAL ERROR, "+meaning.declaredIn.getClass().getSimpleName());
		    }
		}
		if(!this.hasArguments()) {
			SET_SEMANTICS_CHECKED();
			return;
		}
		checkedParams = new Vector<Expression>();
		Declaration decl=meaning.declaredAs;
		
		switch(decl.declarationKind) {
		case ArrayDeclaration:
				ArrayDeclaration array=(ArrayDeclaration)decl;
				this.type=array.type;
				// Check parameters
				if(params.size()!=array.nDim) Util.error("Wrong number of indices to "+array);
				for(Expression actualParameter:params) {
					actualParameter.doChecking();
					Expression checkedParameter=TypeConversion.testAndCreate(Type.Integer,actualParameter);
					checkedParameter.backLink=this;
					checkedParams.add(checkedParameter);
				} break;
				
		case Class:
		case StandardClass:
		case Procedure:
	    case ContextFreeMethod:
	    case StaticMethod:
	    case MemberMethod:
				this.type=decl.type;
				Type overloadedType=this.type;
				Iterator<Parameter> formalIterator;
				if(decl instanceof ClassDeclaration) formalIterator = ((ClassDeclaration)decl).new ClassParameterIterator();
				else formalIterator = ((ProcedureDeclaration)decl).parameterList.iterator();
				if(params!=null) {
					// Check parameters
					Iterator<Expression> actualIterator = params.iterator();
					LOOP:while (actualIterator.hasNext()) {
						if (!formalIterator.hasNext()) {
							Util.error("Wrong number of parameters to " + decl);
							break LOOP;
						}
						Parameter formalParameter = (Parameter)formalIterator.next();
						Type formalType = formalParameter.type;
						Expression actualParameter = actualIterator.next();
						actualParameter.doChecking();
						if(formalType instanceof OverLoad) {
							formalType=actualParameter.type; // AD'HOC for add/subepsilon
							overloadedType=formalType;
						}
						if(formalParameter.kind==Parameter.Kind.Array) {
							if(formalType!=null && formalType!=actualParameter.type && formalType.isArithmeticType())
							Util.error("Parameter Array "+actualParameter+" must be of Type "+formalType);
						}
						Expression checkedParameter=TypeConversion.testAndCreate(formalType,actualParameter);
						checkedParameter.backLink=this;
						checkedParams.add(checkedParameter);
					}
				}
				if (formalIterator.hasNext()) Util.error("Wrong number of parameters to " + decl);
				if(type instanceof OverLoad) this.type=overloadedType;
				break;
				
		case Parameter:
				Parameter spec=(Parameter) decl;
				Parameter.Kind kind=spec.kind;
				Util.ASSERT(kind==Parameter.Kind.Array || kind==Parameter.Kind.Procedure,"Invariant ?");
				this.type=spec.type;
				if(kind==Parameter.Kind.Array) spec.nDim=params.size();
				Iterator<Expression> actualIterator=params.iterator();
				while(actualIterator.hasNext()) {
					Expression actualParameter=actualIterator.next();
					actualParameter.doChecking();
					if(kind==Parameter.Kind.Array) {
						if(!actualParameter.type.isArithmeticType()) Util.error("Illegal index-type");
						Expression checkedParameter=TypeConversion.testAndCreate(Type.Integer,actualParameter);
						checkedParameter.backLink=this;
						checkedParams.add(checkedParameter);
					} else checkedParams.add(actualParameter);
				}
			break;
		case VirtualSpecification:
			VirtualSpecification vspec=(VirtualSpecification) decl;
			this.type=vspec.type;
			Iterator<Expression> pactualIterator=params.iterator();
			while(pactualIterator.hasNext()) {
				Expression actualParameter=pactualIterator.next();
				actualParameter.doChecking();
				checkedParams.add(actualParameter);
			} break;

		default:
			Util.FATAL_ERROR("Variable.doChecking: Impossible - "+decl.declarationKind);
		}
		
		if (Option.TRACE_CHECKER)
			Util.TRACE("END Variable(" + identifier+ ").doChecking: type=" + type);
		SET_SEMANTICS_CHECKED();
	}

	// Returns true if this variable may be used as a statement.
	public boolean maybeStatement()
	  {	ASSERT_SEMANTICS_CHECKED(this);
	    if(meaning==null) return(false); // Error Recovery
		Declaration declaredAs=meaning.declaredAs;
	    if(declaredAs==null) return(false); // Error Recovery
		switch(declaredAs.declarationKind) {
			case Procedure: return(true);
//			case ExternalProcedure: return(true);
			case ContextFreeMethod: return(true);
			case StaticMethod: return(true);
			case MemberMethod: return(true);
			case Parameter:
				Parameter par=(Parameter)declaredAs;
				return(par.kind==Parameter.Kind.Procedure);
			case VirtualSpecification:
				VirtualSpecification vir=(VirtualSpecification)declaredAs;
				return(vir.kind==VirtualSpecification.Kind.Procedure);
		    default:
		}
		return(false); // Variable, Parameter, Array, Class, Switch
	  }

	  
	  
	  

	// ******************************************************************
	// *** Coding: toJavaCode
	// ******************************************************************
	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED(this);
		return (get());
	}
	  
	// ******************************************************************
	// *** Coding: put
	// ******************************************************************
	// Generate code for putting an value(expression) into this Variable
	public String put(final String rightPart) {
		ASSERT_SEMANTICS_CHECKED(this);
		String lhs = this.editVariable(true); // Is a Destination
		if(meaning.declaredAs instanceof Parameter) {
			Parameter par=(Parameter)meaning.declaredAs;
			if(par.kind==Parameter.Kind.Simple && par.mode == Parameter.Mode.name) {
				return(lhs+".put("+rightPart+')');
			}
		}
		return(lhs+'='+rightPart);
	}

	// ******************************************************************
	// *** Coding: get
	// ******************************************************************
	// Generate code for getting the value of this Variable
	public String get() {
		ASSERT_SEMANTICS_CHECKED(this);
		String result = this.editVariable(false); // Not a destination
		return (result);
	}
	
	
	// ******************************************************************
	// *** Coding: editVariable
	// ******************************************************************
	private String editVariable(final boolean destination) {
		Declaration decl=meaning.declaredAs;
	    ASSERT_SEMANTICS_CHECKED(this);
	    Expression inspectedVariable=meaning.getInspectedVariable();
	    
	    if(decl.identifier.equalsIgnoreCase("L1")) {
	    	Util.BREAK("Variable.editVariable: decl="+decl+", QUAL="+decl.getClass().getSimpleName()+", declarationKind="+decl.declarationKind);
	    }

	    StringBuilder s;
		switch(decl.declarationKind) {
		
		case ArrayDeclaration:
	    	s = new StringBuilder();
	    	s.append(edIdentifierAccess(false));
	    	if(this.hasArguments()) { // Array Element Access
	    		int nDim=0;
	    		s.append(".Elt"); //[x-M.LB[1]]");
	    		for(Expression ix:checkedParams) {
	    			String index="["+ix.toJavaCode()+"-"+edIdentifierAccess(false)+".LB["+(nDim++)+"]]";
	    			s.append(index);
	    		}
	    	}
	    	return(s.toString());
	    	
		case Class:
		case StandardClass:
	    	Util.error("Illegal use of class identifier: "+decl.identifier);
	    	return(edIdentifierAccess(destination));
		
		case LabelDeclaration:
	    	VirtualSpecification virtSpec=VirtualSpecification.getVirtualSpecification(decl);
	    	if(virtSpec!=null) return(edIdentifierAccess(virtSpec.getVirtualIdentifier(),destination));
	    	return(edIdentifierAccess(destination));
	
		case Parameter:
	    	s = new StringBuilder();
	    	Parameter par=(Parameter)decl;
	    	switch(par.kind) {
	    	    case Array: // Parameter Array
	    	    	int nDim=0;
	    	    	String var=edIdentifierAccess(false);
	    	    	if(inspectedVariable!=null) var=inspectedVariable.toJavaCode()+'.'+var;
	    	    	if(par.mode==Parameter.Mode.name) var=var+".get()";
	    	    	if(this.hasArguments()) {
	    	    		StringBuilder ixs=new StringBuilder();
	    	    		String dimBrackets="";
	    	    		for(Expression ix:checkedParams) {
	    	    			String index="["+ix.toJavaCode()+"-"+var+".LB["+(nDim++)+"]]"; 
	    	    			ixs.append(index);
	    	    			dimBrackets=dimBrackets+"[]";
	    	    		}
	    	    		String eltType=type.toJavaType();
	    	    		String cast="ARRAY$<"+eltType+dimBrackets+">";
	    	    		String castedVar="(("+cast+")"+var+")";
	    	    		s.append(castedVar).append(".Elt").append(ixs);
	    	    	} else s.append(var);
	    	    	break;
	    	    case Procedure: // Parameter Procedure
	    	    	if(inspectedVariable!=null) s.append(inspectedVariable.toJavaCode()).append('.');
	    	    	if(par.mode==Parameter.Mode.value)
	    	    		Util.error("Parameter "+this+" by Value is not allowed - Rewrite Program");
	    	    	else // Procedure By Reference or Name.
	    	    		s.append(CallProcedure.formal(this,par)); 
	    	    	break;
	    	    case Simple:
	    	    case Label:
	    	    	s.append(edIdentifierAccess(destination)); // Kind: Simple/Label
	    	    	if(!destination && par.mode == Parameter.Mode.name) s.append(".get()");
	    	}
	    	return(s.toString());
		
   	    case ContextFreeMethod:
    	    // Standard Library Procedure
   	    	if(identifier.equalsIgnoreCase("sourceline"))
   	    		return(""+Global.sourceLineNumber);
   	    	if(destination) return("RESULT$");
   	    	return(CallProcedure.asStaticMethod(this,true));
   	    	
   	    case StaticMethod:
   	    	if(destination) return("RESULT$");
   	    	return(CallProcedure.asStaticMethod(this,false));
   	    	
   	    case MemberMethod:
   	    	if(destination) return("RESULT$");
   	    	return(CallProcedure.asNormalMethod(this));
   	    	
   	    case Procedure:
//     		case ExternalProcedure:
   	    	// This Variable is a Procedure-Identifier.
   	    	// When 'destination' it is a variable used to carry the resulting value until the final return.
   	    	// otherwise; it is a ordinary procedure-call.
   	    	if(destination) { // return("RESULT$");
   	    		ProcedureDeclaration proc=(ProcedureDeclaration)meaning.declaredAs;
   	    		ProcedureDeclaration found=Global.currentScope.findProcedure(proc.identifier);
   	    		if(found!=null) {
    	    		if(found.blockLevel==Global.currentScope.blockLevel) return("RESULT$");
    	    		String cast=found.getJavaIdentifier();
    	    		return("(("+cast+")"+found.edCTX()+").RESULT$");
   	    		} else Util.error("Can't assign to procedure "+proc.identifier);
    	    		    
   	    	}
   	    	ProcedureDeclaration procedure = (ProcedureDeclaration) decl;
   	    	if(procedure.myVirtual!=null)
   	    		 return(CallProcedure.virtual(this,procedure.myVirtual.virtualSpec,remotelyAccessed));
   	    	else return(CallProcedure.normal(this));
	
		case SimpleVariableDeclaration:
	    	return(edIdentifierAccess(destination));
	
		case VirtualSpecification:
	    	VirtualSpecification virtual=(VirtualSpecification)decl;
	    	return(CallProcedure.virtual(this,virtual,remotelyAccessed)); 
	
		default:
			Util.FATAL_ERROR("Variable.editVariable: Impossible - "+decl.declarationKind);
		}
	    return(null);
		
	}

	
	// ***********************************************************************
	// *** Coding: edIdentifierAccess
	// ***********************************************************************
	public String edIdentifierAccess(boolean destination) {
		Declaration decl = meaning.declaredAs;
		String id = decl.getJavaIdentifier();
		return (edIdentifierAccess(id, destination));
	}

	private String edIdentifierAccess(String id,boolean destination) {
		if(remotelyAccessed) return(id);
		if(meaning.isConnected()) {
			Expression inspectedVariable=((ConnectionBlock)meaning.declaredIn).getInspectedVariable();
			if(meaning.foundBehindInvisible) {
				String remoteCast=meaning.foundIn.getJavaIdentifier();
				id="(("+remoteCast+")("+inspectedVariable.toJavaCode()+"))."+id;
			} else id=inspectedVariable.toJavaCode()+"."+id;
		} else if(!( meaning.declaredIn.declarationKind==Declaration.Kind.ContextFreeMethod // TODO: CHECK DETTE
				  || meaning.declaredIn.declarationKind==Declaration.Kind.StaticMethod
				  || meaning.declaredIn.declarationKind==Declaration.Kind.MemberMethod
				 )) {
			String cast=meaning.declaredIn.getJavaIdentifier();
			int n=meaning.declaredIn.blockLevel;
			if(meaning.foundBehindInvisible) cast=meaning.foundIn.getJavaIdentifier();
			else if(n==Global.currentScope.blockLevel) return(id);  // currentScope may be a sub-block  TODO: Check Dette !
			id="(("+cast+")"+meaning.declaredIn.edCTX()+")."+id;
		}
		return(id);		  
	}
	
	// ***********************************************************************
	// *** Utility: toString
	// ***********************************************************************
	public String toString() {
		if(params==null) return ("" + identifier);
		else return (("" + identifier + params).replace('[', '(').replace(']', ')'));
	}

}
