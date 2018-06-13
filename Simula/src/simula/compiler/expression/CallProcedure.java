/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.expression;

import java.util.Iterator;

import simula.compiler.SyntaxClass;
import simula.compiler.declaration.BlockDeclaration;
import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.Parameter;
import simula.compiler.declaration.ProcedureSpecification;
import simula.compiler.declaration.Virtual;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;
import simula.compiler.expression.Variable;

/**
 * 
 * Coding Utilities
 * 
 * @author Øystein Myhre Andersen
 *
 */
public class CallProcedure {
	
	// ********************************************************************
	// *** CallProcedure.normal
	// ********************************************************************
	/**
	 * CallProcedure.normal
	 * 
	 * @param variable
	 * @return
	 */
	public static String normal(Variable variable)
    { StringBuilder s=new StringBuilder();
	  //Util.BREAK("CallProcedure.normal: variable="+variable);
	  Meaning meaning=variable.meaning;
	  Declaration decl=meaning.declaredAs;
	  BlockDeclaration procedure = (BlockDeclaration) decl;
	  s.append("new ").append(decl.getJavaIdentifier());
	  String staticLink=meaning.edStaticLink();
      // Generate Parameter Transmission
      s.append(edProcedureParameters(variable,staticLink,procedure)); 
      // Check if part of expression
	  if(decl.type!=null && variable.backLink!=null) s.append(".$result");
	  return(s.toString());
    }
	
	// ********************************************************************
	// *** CallProcedure.remote
	// ********************************************************************
	/**
	 * CallProcedure.remote
	 *   
	 * @param obj Object Expression before DOT
	 * @param procedure Procedure Declaration
	 * @param func Function Designator, may be subscripted
	 * @return
	 */
	public static String remote(Expression obj,BlockDeclaration procedure,Variable func,SyntaxClass backLink)
	{ //Util.BREAK("CallProcedure.remote: obj="+obj);
	  //Util.BREAK("CallProcedure.procedure: procedure="+procedure);
	  //Util.BREAK("CallProcedure.procedure: procedure.myVirtual="+procedure.myVirtual);
	  if(procedure.myVirtual!=null)
	  { // Call Remote Virtual Procedure
		return(remoteVirtual(obj,func,procedure.myVirtual,backLink));
	  }
	  else if(procedure.blockKind==BlockDeclaration.Kind.Method)
	  { // Call Remote Method
		return(asRemoteMethod(obj,procedure,func,backLink));
	  }
	  String call="new "+procedure.getJavaIdentifier();
	  String staticLink=obj.get();
	  //Util.BREAK("CallProcedure.remote: staticLink="+staticLink);
	  
	  call=call+edProcedureParameters(func,staticLink,procedure);
	  
	  //Util.BREAK("CallProcedure.remote: procedure.type="+procedure.type);
	  //Util.BREAK("CallProcedure.remote: backLink="+backLink);
	  if(procedure.type!=null && backLink!=null) call=call+".$result";
	  return(call);
	}

	
	// ********************************************************************
	// *** CallProcedure.asRemoteMethod
	// ********************************************************************
	/**
	 * CallProcedure.remote
	 *   
	 * @param obj Object Expression before DOT
	 * @param procedure Procedure Declaration
	 * @param func Function Designator, may be subscripted
	 * @return
	 */
	private static String asRemoteMethod(Expression obj,BlockDeclaration procedure,Variable func,SyntaxClass backLink)
	{ //Util.BREAK("CallProcedure.asRemoteMethod: obj="+obj);
	  //Util.BREAK("CallProcedure.asRemoteMethod: procedure="+procedure);
	  //Util.BREAK("CallProcedure.asRemoteMethod: procedure.declaredIn="+procedure.declaredIn);
	  //Util.BREAK("CallProcedure.asRemoteMethod: func="+func);
	  
	  BlockDeclaration declaredIn=(BlockDeclaration)procedure.declaredIn;
	  if(declaredIn.isContextFree)
	  { // Call Static Member Method
	    String cast=declaredIn.getJavaIdentifier();
	    String params=edProcedureParameters(func,obj.toJavaCode(),procedure);
	    String methodCall=cast+'.'+procedure.getJavaIdentifier()+params;
	    //Util.BREAK("CallProcedure.asRemoteMethod: Result="+methodCall);
	    return(methodCall);
	  }
	  // Call Ordinary Member Method
	  String params=edProcedureParameters(func,null,procedure);
	  String methodCall=obj.toJavaCode()+'.'+procedure.getJavaIdentifier()+params;
	  //Util.BREAK("CallProcedure.asRemoteMethod: Result="+methodCall);
	  return(methodCall);
	}

	
	// ********************************************************************
	// *** CallProcedure.asNormalMethod
	// ********************************************************************
	/**
	 * CallProcedure.asNormalMethod
	 * 
	 * @param params
	 * @return
	 */
	public static String asNormalMethod(Variable variable)
	{ 
	  Meaning meaning=variable.meaning;
	  BlockDeclaration procedure = (BlockDeclaration) meaning.declaredAs;
	  //Util.BREAK("CallProcedure.asNormalMethod: "+meaning+", Qual="+meaning.declaredAs.getClass().getSimpleName());
	  String params=edProcedureParameters(variable,null,procedure);
	  
	  String methodCall=meaning.declaredAs.getJavaIdentifier()+params;
	  if(meaning.variableKind==Variable.Kind.connectedAttribute)
//	  {	String connID=meaning.declaredIn.getJavaIdentifier();  
	  {	String connID=meaning.declaredIn.toJavaCode();   // TODO: CORR TO_JAVA_CODE
		return(connID+'.'+methodCall);
	  }
	  //Util.BREAK("CallProcedure.asNormalMethod: "+methodCall);
	  BlockDeclaration staticLink=(BlockDeclaration)meaning.declaredAs.declaredIn;
	  //Util.BREAK("CallProcedure.asNormalMethod: staticLink="+staticLink);
	  //Util.BREAK("CallProcedure.asNormalMethod: isContextFree="+staticLink.isContextFree);
	  //Util.BREAK("CallProcedure.asNormalMethod: remotelyAccessed="+variable.remotelyAccessed);
	  if(!staticLink.isContextFree)
	  { //String castIdent=staticLink.getJavaIdentifier();
	    //Util.BREAK("CallProcedure.asNormalMethod: staticLink.blockLevel="+staticLink.blockLevel);
		BlockDeclaration currentModule=Global.currentJavaModule.blockDeclaration; // Class, Procedure, ...
		//Util.BREAK("CallProcedure.asNormalMethod: currentModule.blockLevel="+currentModule.blockLevel);
		//Util.BREAK("CallProcedure.asNormalMethod: meaning="+meaning);
		//Util.BREAK("CallProcedure.asNormalMethod: meaning.blockLevel="+meaning.declaredIn.blockLevel);
		String castIdent=meaning.declaredIn.getJavaIdentifier();
	    int n=meaning.declaredIn.blockLevel;
		if(n!=currentModule.blockLevel)
               methodCall="(("+castIdent+")"+Global.currentScope.edCTX(n)+")."+methodCall;
	  }
	  //Util.BREAK("CallProcedure.asNormalMethod: Result="+methodCall);
	  return(methodCall);
	}

	// ********************************************************************
	// *** CallProcedure.formal
	// ********************************************************************
	/**
	 * CallProcedure.formal
	 * 
	 * @param variable
	 * @param par
	 * @return
	 */
//	public static String formal(Variable variable,Type type,String ident)
	public static String formal(Variable variable,Parameter par)
	{ //return("<IDENT>.CPF().setPar(4).setpar(3.14).STM()");
	  String ident=par.getJavaIdentifier();
	  if(par.mode==Parameter.Mode.name) ident=ident+".get()";
	  return(codeCPF(ident,variable,null));
	}

	// ********************************************************************
	// *** CallProcedure.virtual
	// ********************************************************************
	/**
	 * CallProcedure.virtual
	 * 
	 * @param variable
	 * @param ident
	 * @return
	 */
	public static String virtual(Variable variable,Virtual virtual,boolean remotelyAccessed)
	{ //return("<IDENT>.CPF().setPar(4).setpar(3.14).STM()");
	  String ident=virtual.getJavaIdentifier()+"()";
	  //Util.BREAK("CallProcedure.virtual: ident="+ident);
	  //Util.BREAK("CallProcedure.virtual: variable="+variable);
	  //Util.BREAK("CallProcedure.virtual: variable.meaning="+variable.meaning);
	  //Util.BREAK("CallProcedure.virtual: virtual="+virtual);
	  //Util.BREAK("CallProcedure.virtual: staticLink="+variable.meaning.edStaticLink());
	  //Util.BREAK("CHECK DETTE TILFELLET(CallProcedure.virtual)"); System.exit(-1);
	  if(variable.meaning.variableKind==Variable.Kind.connectedAttribute)
//	  { String conn=variable.meaning.declaredIn.getJavaIdentifier();
	  { String conn=variable.meaning.declaredIn.toJavaCode();   // TODO: CORR TO_JAVA_CODE
	    ident=conn+"."+ident;
	  } else if(!remotelyAccessed) {
		  String staticLink=variable.meaning.edStaticLink();
	      ident=staticLink+"."+ident;
	  }
	  return(codeCPF(ident,variable,virtual.procedureSpec));
	}

	// ********************************************************************
	// *** CallProcedure.remoteVirtual
	// ********************************************************************
	/**
	 * CallProcedure.remoteVirtual
	 * 
	 * @param obj Object Expression before DOT
	 * @param variable
	 * @param virtual Virtual Specification
	 * @param remotelyAccessed
	 * @return
	 */
	public static String remoteVirtual(Expression obj,Variable variable,Virtual virtual,SyntaxClass backLink)
	{ //return("<Object>.<IDENT>.CPF().setPar(4).setpar(3.14).STM()");
	  String ident=obj.get()+'.'+virtual.getJavaIdentifier()+"()";
	  
	  //Util.BREAK("CallProcedure.remoteVirtual: ident="+ident);
	  //Util.BREAK("CallProcedure.remoteVirtual: variable="+variable);
	  //Util.BREAK("CallProcedure.remoteVirtual: backLink="+backLink);
	  //Util.BREAK("CallProcedure.remoteVirtual: variable.meaning="+variable.meaning);
	  //Util.BREAK("CallProcedure.remoteVirtual: virtual="+virtual);
	  //Util.BREAK("CallProcedure.remoteVirtual: staticLink="+variable.meaning.edStaticLink());
	  
	  return(codeCPF(ident,variable,virtual.procedureSpec));
	}
	
	// ********************************************************************
	// *** codeCPF
	// ********************************************************************
	private static String codeCPF(String ident,Variable variable,ProcedureSpecification procedureSpec)
	{ StringBuilder s=new StringBuilder();
	  //Util.BREAK("CallProcedure.codeCPF: ident="+ident);
	  if(procedureSpec!=null) s.append(codeCSVP(ident,variable,procedureSpec));
	  else
	  { s.append(ident).append(".CPF()");
	    if(variable instanceof SubscriptedVariable)
	    { SubscriptedVariable func=(SubscriptedVariable)variable;
	      for(Expression actualParameter:func.checkedParams)
	      { actualParameter.backLink=actualParameter;  // To ensure $result from functions
	        s.append(".setPar(");
		    Type formalType=actualParameter.type;
		    Parameter.Kind kind=Parameter.Kind.Simple;            // TODO: USIKKER På DETTE !!!
		    //Util.BREAK("CallProcedure.codeCPF: actualParameter="+actualParameter);
		    if((actualParameter instanceof Variable) && !(actualParameter instanceof SubscriptedVariable))
		    { Variable var=(Variable)actualParameter;
//		      Util.BREAK("CallProcedure.codeCPF: actualParameter'meaning="+var.meaning);
//		      Util.BREAK("CallProcedure.codeCPF: actualParameter'declaredAs="+var.meaning.declaredAs);
//		      Util.BREAK("CallProcedure.codeCPF: actualParameter'declaredAs'Qual="+var.meaning.declaredAs.getClass().getSimpleName());
		      Declaration decl=var.meaning.declaredAs;
		      if(decl instanceof Parameter) kind=((Parameter)decl).kind;  // TODO: Flere sånne tilfeller ???
		      if(decl instanceof BlockDeclaration) kind=Parameter.Kind.Procedure;  // TODO: Flere sånne tilfeller ???
		    }
		    Parameter.Mode mode=Parameter.Mode.name; // NOTE: ALL PARAMETERS BY'NAME !!!
		    s.append(doParameterTransmition(formalType,kind,mode,actualParameter));
		    s.append(')');
	      }
		  s.append(".STM()"); // Only when any parameter
	    }
	  }
	  if(variable.type!=null && variable.backLink!=null)
	  { boolean partOfExpression=true;
	    if(variable.backLink instanceof RemoteVariable)
	    { RemoteVariable binOper=(RemoteVariable)variable.backLink;
	      //Util.BREAK("CallProcedure.codeCPF: binOper="+binOper);
	      //Util.BREAK("CallProcedure.codeCPF: binOper.backLink="+binOper.backLink);
	      // NOTE: Standalone <expression>.<function> should not be casted
	      if(binOper.backLink==null) partOfExpression=false;
	    }
	    if(partOfExpression)
		{ s.append(".$result()");
	      String callVirtual=s.toString();
	      String cast=variable.type.toJavaType();
		  if(variable.type.isArithmeticType())
			   return(cast+"Value("+callVirtual+")");
		  else return("(("+cast+")("+callVirtual+"))");
		}
	  }
	  return(s.toString());
	}
	
	// ********************************************************************
	// *** codeCSVP  -- Call Specified Virtual Procedure
	// ********************************************************************
	private static String codeCSVP(String ident,Variable variable,ProcedureSpecification procedureSpec)
	{ StringBuilder s=new StringBuilder();
	  //Util.BREAK("CallProcedure.codeCPF: ident="+ident);
	  s.append(ident).append(".CPF()");
	  if(variable instanceof SubscriptedVariable)
	  { Iterator<Parameter> formalIterator = procedureSpec.parameterList.iterator(); // If class also over prefix-chain
		Iterator<Expression> actualIterator = ((SubscriptedVariable)variable).checkedParams.iterator();
		while(actualIterator.hasNext())
		{ Expression actualParameter = actualIterator.next();
		  //Util.BREAK("CallProcedure.edProcedureParameters("+variable.identifier+").get: Actual Parameter: " + actualParameter);
		  Parameter formalParameter = (Parameter)formalIterator.next();
		  //Util.BREAK("CallProcedure.edProcedureParameters("+variable.identifier+").get: Formal Parameter: " + formalParameter);
	      s.append(".setPar(");
		  Type formalType=formalParameter.type;
		  Parameter.Kind kind=formalParameter.kind;  
		  Parameter.Mode mode=formalParameter.mode;
		  s.append(doParameterTransmition(formalType,kind,mode,actualParameter));
		  s.append(')');
		}
		s.append(".STM()"); // Only when any parameter
	  }
	  return(s.toString());
	}
	
	// ********************************************************************
	// *** edProcedureParameters
	// ********************************************************************
	private static String edProcedureParameters(Variable variable,String staticLink,BlockDeclaration procedure)
	{ StringBuilder s = new StringBuilder();
	  boolean prevPar=false;
	  s.append('(');
	  if(staticLink!=null)  { s.append(staticLink); prevPar=true; }
	  if(variable instanceof SubscriptedVariable)
	  { Iterator<Parameter> formalIterator = procedure.parameterIterator(); // If class also over prefix-chain
	    Iterator<Expression> actualIterator = ((SubscriptedVariable)variable).checkedParams.iterator();
	    while(actualIterator.hasNext())
	    { Expression actualParameter = actualIterator.next();
		  //Util.BREAK("CallProcedure.edProcedureParameters("+variable.identifier+").get: Actual Parameter: " + actualParameter);
		  Parameter formalParameter = (Parameter)formalIterator.next();
		  //Util.BREAK("CallProcedure.edProcedureParameters("+variable.identifier+").get: Formal Parameter: " + formalParameter);
		  if(prevPar) s.append(','); prevPar=true;
		  Type formalType=formalParameter.type;
		  Parameter.Kind kind=formalParameter.kind;  
		  Parameter.Mode mode=formalParameter.mode;
		  s.append(doParameterTransmition(formalType,kind,mode,actualParameter));
	    }
	  }
	  s.append(')');
	  return(s.toString());
	}

	
	// ********************************************************************
	// *** doParameterTransmition
	// ********************************************************************
	private static String doParameterTransmition(Type formalType,Parameter.Kind kind,Parameter.Mode mode,Expression actualParameter)
	{ StringBuilder s = new StringBuilder();
	  //Util.BREAK("CallProcedure.doParameterTransmition: FORMAL "+kind+' '+type+' '+formalParameter.identifier+" by "+((mode!=null)?mode:"default"));
	  //Util.BREAK("CallProcedure.doParameterTransmition: ACTUAL "+actualParameter);
	  //Util.BREAK("CallProcedure.doParameterTransmition: ACTUAL'Qual "+actualParameter.getClass().getSimpleName());
	  
	  switch(kind)
	  { case Simple: doSimpleParameter(s,formalType,mode,actualParameter); break;
	    case Procedure: doProcedureParameter(s,formalType,mode,actualParameter); break;
	    case Array: doArrayParameter(s,formalType,mode,actualParameter); break;
	    case Label:
	   	    String staticLink=edStaticLink(actualParameter);
	    	String labQuant="new $LABQNT("+staticLink+","+actualParameter.toJavaCode()+")";
	    	if(mode==Parameter.Mode.name) {
		    	  s.append("new $NAME<$LABQNT>()");
			      s.append("{ public $LABQNT get() { return("+labQuant+"); }");
			      s.append(" }");
		    }
		    else s.append(labQuant);
		    break;
	    case Switch:
	    	s.append(actualParameter.toJavaCode());
	    	break;
	    default:	
	  }
	  return(s.toString());
	}

	
	// ********************************************************************
	// *** doSimpleParameter -- Simple Variable as Actual Parameter
	// ********************************************************************
	private static void doSimpleParameter(StringBuilder s,Type formalType,Parameter.Mode mode,Expression actualParameter)
	{ //Util.BREAK("CallProcedure.doSimpleParameter: FORMAL "+kind+' '+type+' '+formalParameter.identifier+" by "+((mode!=null)?mode:"default"));
	  //Util.BREAK("CallProcedure.doSimpleParameter: ACTUAL "+actualParameter);
	  //Util.BREAK("CallProcedure.doSimpleParameter: ACTUAL'Qual "+actualParameter.getClass().getSimpleName());
	  
		    if(mode==null) // Simple Type/Ref/Text by Default
		    	s.append(actualParameter.toJavaCode());
		    else if(mode==Parameter.Mode.value)  // Simple Type/Ref/Text by Value
		    { if(formalType==Type.Text)
		    	   s.append("copy(").append(actualParameter.toJavaCode()).append(')');
		      else s.append(actualParameter.toJavaCode());
		    }
		    else if(formalType==Type.Label) {
		   	    String staticLink=edStaticLink(actualParameter);
		    	String labQuant="new $LABQNT("+staticLink+","+actualParameter.toJavaCode()+")";
		    	if(mode==Parameter.Mode.name) {
			    	  s.append("new $NAME<$LABQNT>()");
				      s.append("{ public $LABQNT get() { return("+labQuant+"); }");
				      s.append(" }");
			    }
			    else s.append(labQuant);
		    }
		    else  // Simple Type/Ref/Text by Name
		    { String javaTypeClass=formalType.toJavaTypeClass();
		      Variable writeableVariable=actualParameter.getWriteableVariable();
		      if(writeableVariable!=null)
		      {	s.append("new $NAME<"+javaTypeClass+">()");
		    	s.append("{ public "+javaTypeClass+" get() { return("+actualParameter.get()+"); }");
//			    Util.BREAK("CallProcedure.doSimpleParameter: Actual Parameter: " + actualParameter);
//			    Util.BREAK("CallProcedure.doSimpleParameter: Actual Parameter'var: " + writeableVariable);
//			    Util.BREAK("CallProcedure.doSimpleParameter: Actual Parameter'Meaning: " + writeableVariable.meaning);
//			    Util.BREAK("CallProcedure.doSimpleParameter: Actual Parameter'Semantic: " + writeableVariable.meaning.declaredAs);
//			    Util.BREAK("CallProcedure.doSimpleParameter: Actual Parameter'Semantic'Qual: " + writeableVariable.meaning.declaredAs.getClass().getSimpleName());
				if(!(writeableVariable.meaning.declaredAs instanceof BlockDeclaration))
                { Type actualType=actualParameter.type;
				  String rhs="("+actualType.toJavaType()+")x$";
                  if(actualParameter instanceof TypeConversion)
                  { // --------------------------------------------------
                	// Generate something like:
                	//  
                	//  public Float put(Float x$) {
                	//     float y=x$; 
					//	   n=(int) ( (float) y+0.5);
					//	   return(y);
                	//  }
                    // --------------------------------------------------
        			//Util.BREAK("CallProcedure.doSimpleParameter: rhs="+rhs);
      			    //Util.BREAK("CallProcedure.doSimpleParameter: var="+var);
      			    //Util.BREAK("CallProcedure.doSimpleParameter: actualType="+actualType);
      			    //Util.BREAK("CallProcedure.doSimpleParameter: formalType="+formalType);
      			    //Util.BREAK("CallProcedure.doSimpleParameter: var.type="+var.type);
      			    String putValue=TypeConversion.mayBeConvert(actualType,writeableVariable.type,"y");
      			    //Util.BREAK("CallProcedure.doSimpleParameter: putValue="+putValue);
                    s.append(" public "+javaTypeClass+" put("+javaTypeClass+" x$)");
                    s.append("{ "+formalType.toJavaType()+" y=x$; ");
                    s.append(writeableVariable.toJavaCode()).append(putValue);
                    s.append("return(y); }");
                  }
                  else
                  { // --------------------------------------------------
                	// Generate something like:
                	//  
          			//  public Double put(Double x$) {
        			//	   return (r = (double) x$);
                	//  }
                    // --------------------------------------------------
                	s.append(" public "+javaTypeClass+" put("+javaTypeClass+" x$)"
                          +" { return("+actualParameter.put(rhs)+"); }");
		    	  }
                }
		    	s.append(" }");
		      }		    	  
		      else
		      {
		    	s.append("new $NAME<"+javaTypeClass+">()");
//		    	s.append("{ public "+javaTypeClass+" get() { return("+actualParameter.toJavaCode()+"); }");
		    	s.append("{ public "+javaTypeClass+" get() { return("+actualParameter.get()+"); }");
		    	s.append(" }");
		      }
		    }
	}

	
	// ********************************************************************
	// *** doArrayParameter -- Array as Actual Parameter
	// ********************************************************************
	private static void doArrayParameter(StringBuilder s,Type formalType,Parameter.Mode mode,Expression actualParameter)
	{ //Util.BREAK("CallProcedure.doArrayParameter: FORMAL "+kind+' '+type+' '+formalParameter.identifier+" by "+((mode!=null)?mode:"default"));
	  //Util.BREAK("CallProcedure.doArrayParameter: ACTUAL "+actualParameter);
	  //Util.BREAK("CallProcedure.doArrayParameter: ACTUAL'Qual "+actualParameter.getClass().getSimpleName());
	  // Value Type:      by  Value - Reference - Name
	  // Reference Type:  by          Reference - Name
	  //Util.BREAK("CallProcedure.doArrayParameter: actualParameter="+actualParameter);
	  //Util.BREAK("CallProcedure.doArrayParameter: actualParameter'QUAL="+actualParameter.getClass().getSimpleName());
//	  if(actualParameter instanceof Variable)
//	  { Variable var=(Variable)actualParameter;
//	  	//Util.BREAK("CallProcedure.doArrayParameter: actualParameter'meaning="+var.meaning);
//	  	Declaration decl=var.meaning.declaredAs;
//	  	//Util.BREAK("CallProcedure.doArrayParameter: actualParameter'declaredAs="+decl);
//	  	//Util.BREAK("CallProcedure.doArrayParameter: actualParameter'declaredAs'QUAL="+decl.getClass().getSimpleName());
//	  }
	  if(mode==Parameter.Mode.value) {
	    Util.warning("Array-Parameter by value is not (fully) implemented");
	    s.append(actualParameter.toJavaCode()).append(".COPY()");
	  }
	  else if(mode==Parameter.Mode.name) {
//	    String arrObj="$ARRAY<"+formalType.toJavaType()+"[]>";  // TODO: NEW ARRAY CODE  FEIL: BARE ONE-DIMENSIONAL !!!!
	    String arrObj="$ARRAY<?>";
		s.append("new $NAME<"+arrObj+">()");
		s.append("{ public "+arrObj+" get() { return("+actualParameter.toJavaCode()+"); }");
		s.append(" }");
	  } else s.append(actualParameter.toJavaCode());
	}
	
	// ********************************************************************
	// *** doProcedureParameter -- Procedure as Actual Parameter
	// ********************************************************************
	private static void doProcedureParameter(StringBuilder s,Type formalType,Parameter.Mode mode,Expression actualParameter)
	{ //Util.BREAK("CallProcedure.doProcedureParameter: FORMAL "+kind+' '+type+' '+formalParameter.identifier+" by "+((mode!=null)?mode:"default"));
	  //Util.BREAK("CallProcedure.doProcedureParameter: ACTUAL "+actualParameter);
	  //Util.BREAK("CallProcedure.doProcedureParameter: ACTUAL'Qual "+actualParameter.getClass().getSimpleName());
	  
	  String staticLink=null;
	  String procIdent=null;
   	  { if(actualParameter instanceof RemoteVariable)
   	    { // Check for <ObjectExpression> DOT <Variable>
   		  RemoteVariable dotOperation=(RemoteVariable)actualParameter;
   	      { staticLink=dotOperation.lhs.toJavaCode();
   	        if(dotOperation.rhs instanceof Variable)
   	             procIdent=((Variable)dotOperation.rhs).meaning.declaredAs.getJavaIdentifier();
   	        else Util.FATAL_ERROR("Impossible");
   	      }
   	    } else if(actualParameter instanceof Variable)
	   	{ procIdent=((Variable)actualParameter).meaning.declaredAs.getJavaIdentifier();
		  //Util.BREAK("CallProcedure.doProcedureParameter("+procIdent+") Actual Parameter: " + actualParameter);
		  //Util.BREAK("CallProcedure.doProcedureParameter("+procIdent+") Actual Parameter'Qual: " + actualParameter.getClass().getSimpleName());
	   	  staticLink=edStaticLink(actualParameter);
 	    } else if(actualParameter instanceof ConditionalExpression)
 	    {
 	      Util.NOT_IMPLEMENTED("Conditional Procedure Expression: "+actualParameter);
 	    }
	    if(staticLink==null) Util.error("Illegal Procedure Expression: "+actualParameter);
	   	
	    String procQuant="new $PRCQNT("+staticLink+","+procIdent+".class)";
		if(actualParameter instanceof Variable)
		{ Variable var=(Variable)actualParameter;
		  //Util.BREAK("CallProcedure.doProcedureParameter("+procIdent+") Actual Parameter'Type: " + var.type);
		  //Util.BREAK("CallProcedure.doProcedureParameter("+procIdent+") Actual Parameter'Meaning: " + var.meaning);
			  
		  //Util.BREAK("CallProcedure.doProcedureParameter("+procIdent+") Actual Parameter'Semantic: " + var.meaning.declaredAs);
		  if(var.meaning.declaredAs instanceof Parameter)
		  { Parameter par=(Parameter)var.meaning.declaredAs;
			procQuant=((Variable) actualParameter).getJavaIdentifier();
			if(par.mode==Parameter.Mode.name) procQuant=procQuant+".get()";  // TODO:SE OVER EN GANG TIL !
		  }
		}
	    if(mode==Parameter.Mode.name)
		{ // --- EXAMPLE -------------------------------------------------------------------------
	      //	r = new ParamSample$Q(this, new $NAME<$PRCQNT>() {
	      //		public $PRCQNT get() {
	      //			return (new $PRCQNT(ParamSample.this, ParamSample$P.class));
	      //		}
	      //	}).$result;
          // -------------------------------------------------------------------------------------
	      //Util.BREAK("CallProcedure.doProcedureParameter: actualParameter="+actualParameter+", qual="+actualParameter.getClass().getSimpleName());
	      s.append("new $NAME<$PRCQNT>()");
		  s.append("{ public $PRCQNT get() { return("+procQuant+"); }");
		  s.append(" }");
	    }
	    else s.append(procQuant);
	  }
	}
	
	// ********************************************************************
	// *** edStaticLink
	// ********************************************************************
	private static String edStaticLink(Expression actualParameter)
	{ //Util.BREAK("SubscriptedVariable.edStaticLink: actualParameter="+actualParameter+", qual="+actualParameter.getClass().getSimpleName());
      if(actualParameter instanceof Variable)
      {	Variable apar=(Variable)actualParameter;
    	return(apar.meaning.edStaticLink());
      }
      Util.error("Actual parameter "+actualParameter+" is not implemented");
	  return("UNKNOWN.this");   // TEMP !!!!!!!
	}


}
