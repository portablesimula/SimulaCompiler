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
import simula.compiler.declaration.ArrayDeclaration;
import simula.compiler.declaration.BlockDeclaration;
import simula.compiler.declaration.ClassDeclaration;
import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.DeclarationScope;
import simula.compiler.declaration.LabelDeclaration;
import simula.compiler.declaration.Parameter;
import simula.compiler.declaration.ProcedureDeclaration;
import simula.compiler.declaration.ProcedureSpecification;
import simula.compiler.declaration.StandardProcedure;
import simula.compiler.declaration.SimpleVariableDeclaration;
import simula.compiler.declaration.VirtualSpecification;
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
public final class CallProcedure {
	
	// ********************************************************************
	// *** CallProcedure.normal
	// ********************************************************************
	/**
	 * CallProcedure.normal
	 * 
	 * @param variable
	 * @return
	 */
	public static String normal(final Variable variable)
    { StringBuilder s=new StringBuilder();
	  Meaning meaning=variable.meaning;
	  Declaration decl=meaning.declaredAs;
	  ProcedureDeclaration procedure = (ProcedureDeclaration) decl;
	  s.append("new ").append(decl.getJavaIdentifier());
	  String staticLink=meaning.edUnqualifiedStaticLink();
      // Generate Parameter Transmission
      s.append(edProcedureParameters(variable,staticLink,procedure)); 
      // Check if part of expression
	  if(decl.type!=null && variable.backLink!=null) s.append(".RESULT$");
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
	public static String remote(final Expression obj,final ProcedureDeclaration procedure,final Variable func,final SyntaxClass backLink)
	{ if(procedure.myVirtual!=null)
	  { // Call Remote Virtual Procedure
		return(remoteVirtual(obj,func,procedure.myVirtual.virtualSpec));
	  }
	  else if(procedure.declarationKind==Declaration.Kind.ContextFreeMethod) // TODO: CHECK DETTE
	  { // Call Remote Method
		return(asRemoteMethod(obj,procedure,func,backLink));
	  }
	  else if(procedure.declarationKind==Declaration.Kind.StaticMethod) // TODO: CHECK DETTE
	  { // Call Remote Method
		return(asRemoteMethod(obj,procedure,func,backLink));
	  }
	  else if(procedure.declarationKind==Declaration.Kind.MemberMethod) // TODO: CHECK DETTE
	  { // Call Remote Method
		return(asRemoteMethod(obj,procedure,func,backLink));
	  }
	  String call="new "+procedure.getJavaIdentifier();
	  String staticLink=obj.get();	  
	  call=call+edProcedureParameters(func,staticLink,procedure);
	  if(procedure.type!=null && backLink!=null) call=call+".RESULT$";
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
	private static String asRemoteMethod(final Expression obj,final ProcedureDeclaration procedure,final Variable func,final SyntaxClass backLink)
	{ BlockDeclaration declaredIn=(BlockDeclaration)procedure.declaredIn;
	  if(declaredIn.isContextFree)
	  { // Call Static Member Method
	    String cast=declaredIn.getJavaIdentifier();
	    String params=edProcedureParameters(func,obj.toJavaCode(),procedure);
	    String methodCall=cast+'.'+procedure.getJavaIdentifier()+params;
	    return(methodCall);
	  }
	  // Call Ordinary Member Method
	  String params=edProcedureParameters(func,null,procedure);
	  String methodCall=obj.toJavaCode()+'.'+procedure.getJavaIdentifier()+params;
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
	public static String asNormalMethod(final Variable variable)
	{ 
	  Meaning meaning=variable.meaning;
	  ProcedureDeclaration procedure = (ProcedureDeclaration) meaning.declaredAs;
	  String params=edProcedureParameters(variable,null,procedure);
	  
	  String methodCall=meaning.declaredAs.getJavaIdentifier()+params;
	  if(meaning.isConnected())
	  {	DeclarationScope declaredIn=meaning.declaredIn;
	  	String connID=declaredIn.toJavaCode();
	    return(connID+'.'+methodCall);
	  }
	  BlockDeclaration staticLink=(BlockDeclaration)meaning.declaredAs.declaredIn;
	  if(!staticLink.isContextFree)
	  { BlockDeclaration currentModule=Global.currentJavaModule.blockDeclaration; // Class, Procedure, ...
		String castIdent=meaning.declaredIn.getJavaIdentifier();
	    int n=meaning.declaredIn.blockLevel;
		if(n!=currentModule.blockLevel)
            methodCall="(("+castIdent+")"+meaning.declaredIn.edCTX()+")."+methodCall;
	  }
	  return(methodCall);
	}
	
	// ********************************************************************
	// *** CallProcedure.asStaticMethod
	// ********************************************************************
	/**
	 * CallProcedure.asStaticMethod
	 * 
	 * @param params
	 * @return
	 */
	public static String asStaticMethod(final Variable variable,final boolean isContextFree)
	{ 
	  Meaning meaning=variable.meaning;
	  ProcedureDeclaration procedure = (ProcedureDeclaration) meaning.declaredAs;
	  BlockDeclaration staticLink=(BlockDeclaration)meaning.declaredAs.declaredIn;
	  String staticLinkString=null;
	  if(!isContextFree)staticLinkString=staticLink.edCTX();
	  String params=edProcedureParameters(variable,staticLinkString,procedure);
	  
	  String methodCall=meaning.declaredAs.getJavaIdentifier()+params;
	  if(meaning.isConnected())
	  {	String connID=meaning.declaredIn.toJavaCode();
		return(connID+'.'+methodCall);
	  }
	  if(!isContextFree)
	  { BlockDeclaration currentModule=Global.currentJavaModule.blockDeclaration; // Class, Procedure, ...
		String castIdent=meaning.declaredIn.getJavaIdentifier();
	    int n=meaning.declaredIn.blockLevel;
		if(n!=currentModule.blockLevel)
            methodCall="(("+castIdent+")"+meaning.declaredIn.edCTX()+")."+methodCall;
	  }
	  return(methodCall);
	}

	// ********************************************************************
	// *** CallProcedure.formal
	// ********************************************************************
	/**
	 * CallProcedure.formal
	 * 
	 * @param variable
	 * @param par declared as parameter 'par'
	 * @return
	 */
	public static String formal(final Variable variable,final Parameter par)
	{ //return("<IDENT>.CPF().setPar(4).setpar(3.14).ENT$()");
	  String ident=variable.edIdentifierAccess(false);
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
	public static String virtual(final Variable variable,final VirtualSpecification virtual,final boolean remotelyAccessed) {
		//return("<IDENT>.CPF().setPar(4).setpar(3.14).ENT$()");
	    String ident=virtual.getVirtualIdentifier();
	    if(virtual.kind==VirtualSpecification.Kind.Label) return(ident);
	    if(variable.meaning.isConnected()) {
	    	String conn=variable.meaning.declaredIn.toJavaCode();
	        ident=conn+"."+ident;
	    } else if(!remotelyAccessed) {
		    String staticLink=variable.meaning.edQualifiedStaticLink();
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
	public static String remoteVirtual(final Expression obj,final Variable variable,final VirtualSpecification virtual)
	{ //return("<Object>.<IDENT>.CPF().setPar(4).setpar(3.14).ENT$()");
	  String ident=obj.get()+'.'+virtual.getVirtualIdentifier();
	  return(codeCPF(ident,variable,virtual.procedureSpec));
	}
	
	// ********************************************************************
	// *** codeCPF
	// ********************************************************************
	private static String codeCPF(final String ident,final Variable variable,final ProcedureSpecification procedureSpec)
	{ StringBuilder s=new StringBuilder();
	  if(procedureSpec!=null) s.append(codeCSVP(ident,variable,procedureSpec));
	  else
	  { s.append(ident).append(".CPF()");
	    if(variable.hasArguments())
	    { for(Expression actualParameter:variable.checkedParams)
	      { actualParameter.backLink=actualParameter;  // To ensure RESULT$ from functions
	        s.append(".setPar(");
		    Type formalType=actualParameter.type;
		    Parameter.Kind kind=Parameter.Kind.Simple;  // Default, see below
		    if((actualParameter instanceof Variable) && !(((Variable)actualParameter).hasArguments()))
		    { Variable var=(Variable)actualParameter;
		      Declaration decl=var.meaning.declaredAs;
			  if(decl instanceof StandardProcedure) {
				  if(decl.identifier.equalsIgnoreCase("sourceline")) {
					  actualParameter=new Constant(Type.Integer,Global.sourceLineNumber);
					  actualParameter.doChecking();
				  }
			  }
			  else if(decl instanceof SimpleVariableDeclaration) kind=Parameter.Kind.Simple;
			  else if(decl instanceof Parameter) kind=((Parameter)decl).kind;
			  else if(decl instanceof ProcedureDeclaration) kind=Parameter.Kind.Procedure;
			  else if(decl instanceof ArrayDeclaration) kind=Parameter.Kind.Array;
			  else if(decl instanceof LabelDeclaration) kind=Parameter.Kind.Label;
			  else if(decl instanceof ClassDeclaration) kind=Parameter.Kind.Simple; // Error Recovery
			  else Util.FATAL_ERROR("TODO: Flere sånne tilfeller ???");
		    }
		    Parameter.Mode mode=Parameter.Mode.name; // NOTE: ALL PARAMETERS BY'NAME !!!
		    s.append(doParameterTransmition(formalType,kind,mode,actualParameter));
		    s.append(')');
	      }
		  s.append(".ENT$()"); // Only when any parameter
	    }
	  }
	  Type resultType=variable.type;
	  if(procedureSpec!=null) resultType=procedureSpec.type;
	  if(resultType!=null && variable.backLink!=null)
	  { boolean partOfExpression=true;
	    if(variable.backLink instanceof RemoteVariable)
	    { RemoteVariable binOper=(RemoteVariable)variable.backLink;
	      // NOTE: Standalone <expression>.<function> should not be casted
	      if(binOper.backLink==null) partOfExpression=false;
	    }
	    if(partOfExpression)
		{ s.append(".RESULT$()");
	      String callVirtual=s.toString();
	      String cast=resultType.toJavaType();
		  if(resultType.isArithmeticType())
			   return(cast+"Value("+callVirtual+")");
		  else return("(("+cast+")("+callVirtual+"))");
		}
	  }
	  return(s.toString());
	}
	
	// ********************************************************************
	// *** codeCSVP  -- Call Specified Virtual Procedure
	// ********************************************************************
	private static String codeCSVP(final String ident,final Variable variable,final ProcedureSpecification procedureSpec)
	{ StringBuilder s=new StringBuilder();
	  s.append(ident).append(".CPF()");
	  if(variable.hasArguments())
	  { Iterator<Parameter> formalIterator = procedureSpec.parameterList.iterator(); // If class also over prefix-chain
		Iterator<Expression> actualIterator = variable.checkedParams.iterator();
		while(actualIterator.hasNext())
		{ Expression actualParameter = actualIterator.next();
		  Parameter formalParameter = (Parameter)formalIterator.next();
	      s.append(".setPar(");
		  Type formalType=formalParameter.type;
		  Parameter.Kind kind=formalParameter.kind;  
		  Parameter.Mode mode=formalParameter.mode;
		  s.append(doParameterTransmition(formalType,kind,mode,actualParameter));
		  s.append(')');
		}
		s.append(".ENT$()"); // Only when any parameter
	  }
	  return(s.toString());
	}
	
	// ********************************************************************
	// *** edProcedureParameters
	// ********************************************************************
	private static String edProcedureParameters(final Variable variable,final String staticLink,final ProcedureDeclaration procedure)
	{ StringBuilder s = new StringBuilder();
	  boolean prevPar=false;
	  s.append('(');
	  if(staticLink!=null)  { s.append(staticLink); prevPar=true; }
	  if(variable.hasArguments())
	  { Iterator<Parameter> formalIterator = procedure.parameterList.iterator();
	    Iterator<Expression> actualIterator = variable.checkedParams.iterator();
	    while(actualIterator.hasNext())
	    { Expression actualParameter = actualIterator.next();
		  Parameter formalParameter = (Parameter)formalIterator.next();
		  if(formalParameter.nDim>0) {
			  int aDim=getNdim(actualParameter);
			  if(aDim<1) Util.warning("Parameter Array "+actualParameter+" remains unchecked. Java or Runtime errors may occur");
			  else if(aDim!=formalParameter.nDim) Util.error("Parameter Array "+actualParameter+" has wrong number of dimensions");
		  }
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
	
    private static int getNdim(final Expression actualParameter) {
    	Variable aVar=null;
    	if(actualParameter instanceof RemoteVariable) aVar=((RemoteVariable)actualParameter).var;
    	else if(actualParameter instanceof Variable) aVar=(Variable)actualParameter;
    	else return(-1); // Unchecked
    	Meaning meaning=aVar.meaning;
    	if(meaning.declaredAs instanceof Parameter) {
    		Parameter par=(Parameter)meaning.declaredAs;
    		return(par.nDim);    		
    	} else if(meaning.declaredAs instanceof ArrayDeclaration) {
    		ArrayDeclaration aArray=(ArrayDeclaration)meaning.declaredAs;
    		return(aArray.nDim);
    	}
    	return(-1);
    }
	
	// ********************************************************************
	// *** doParameterTransmition
	// ********************************************************************
	private static String doParameterTransmition(final Type formalType,final Parameter.Kind kind,final Parameter.Mode mode,final Expression actualParameter) {
		StringBuilder s = new StringBuilder();
		switch(kind) {
		    case Simple: doSimpleParameter(s,formalType,mode,actualParameter); break;
		    case Procedure: doProcedureParameter(s,formalType,mode,actualParameter); break;
		    case Array: doArrayParameter(s,formalType,mode,actualParameter); break;
		    case Label:
		    	String labQuant=actualParameter.toJavaCode();
		    	if(mode==Parameter.Mode.name) {
			    	  s.append("new NAME$<LABQNT$>()");
				      s.append("{ public LABQNT$ get() { return("+labQuant+"); }");
				      s.append(" }");
			    }
			    else s.append(labQuant);
			    break;
		    default:	
		}
		return(s.toString());
	}

	
	// ********************************************************************
	// *** doSimpleParameter -- Simple Variable as Actual Parameter
	// ********************************************************************
	private static void doSimpleParameter(final StringBuilder s,final Type formalType,final Parameter.Mode mode,final Expression actualParameter) {
		if(mode==null) // Simple Type/Ref/Text by Default
		  	s.append(actualParameter.toJavaCode());
		else if(mode==Parameter.Mode.value) { // Simple Type/Ref/Text by Value
		        if(formalType==Type.Text)
		    	     s.append("copy(").append(actualParameter.toJavaCode()).append(')');
		        else s.append(actualParameter.toJavaCode());
		} else if(formalType==Type.Label) {
		    	String labQuant=actualParameter.toJavaCode();
		    	if(mode==Parameter.Mode.name) {
			    	  s.append("new NAME$<LABQNT$>()");
				      s.append("{ public LABQNT$ get() { return("+labQuant+"); }");
				      s.append(" }");
			    }
			    else s.append(labQuant);
		} else { // Simple Type/Ref/Text by Name
		    String javaTypeClass=formalType.toJavaTypeClass();
		    Variable writeableVariable=actualParameter.getWriteableVariable();
		    if(writeableVariable!=null) {
		    	s.append("new NAME$<"+javaTypeClass+">()");
		    	s.append("{ public "+javaTypeClass+" get() { return("+actualParameter.get()+"); }");
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
      			    String putValue=TypeConversion.mayBeConvert(actualType,writeableVariable.type,"y");
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
		    	s.append("new NAME$<"+javaTypeClass+">()");
		    	s.append("{ public "+javaTypeClass+" get() { return("+actualParameter.get()+"); }");
		    	s.append(" }");
		      }
		}
	}

	
	// ********************************************************************
	// *** doArrayParameter -- Array as Actual Parameter
	// ********************************************************************
	private static void doArrayParameter(final StringBuilder s,final Type formalType,final Parameter.Mode mode,final Expression actualParameter) {
		if(mode==Parameter.Mode.value) {
		    Util.warning("Array-Parameter by value is not (fully) implemented");
		    s.append(actualParameter.toJavaCode()).append(".COPY()");
		}
		else if(mode==Parameter.Mode.name) {
		    String arrObj="ARRAY$<?>";
			s.append("new NAME$<"+arrObj+">()");
			s.append("{ public "+arrObj+" get() { return("+actualParameter.toJavaCode()+"); }");
			s.append(" }");
		} else s.append(actualParameter.toJavaCode());
	}
	
	
	// ********************************************************************
	// *** doProcedureParameter -- Procedure as Actual Parameter
	// ********************************************************************
	private static void doProcedureParameter(final StringBuilder s, final Type formalType, final Parameter.Mode mode, final Expression actualParameter) {
		String procQuant = edProcedureQuant(mode,actualParameter);
		if (mode == Parameter.Mode.name) {
			// --- EXAMPLE -------------------------------------------------------------------------
			// r = new ParamSample$Q(this, new NAME$<PRCQNT$>() {
			//     public PRCQNT$ get() {
			//         return (new PRCQNT$(ParamSample.this, ParamSample$P.class));
			//     }
			// }).RESULT$;
			// -------------------------------------------------------------------------------------
			s.append("new NAME$<PRCQNT$>()");
			s.append("{ public PRCQNT$ get() { return(" + procQuant + "); }");
			s.append(" }");
		} else s.append(procQuant);
	}
	
	// ********************************************************************
	// *** edProcedureQuant
	// ********************************************************************
	private static String edProcedureQuant(final Parameter.Mode mode, final Expression actualParameter) {
	    if (actualParameter instanceof Variable) {
			Variable var = (Variable) actualParameter;
			Declaration decl=var.meaning.declaredAs;
	    	String staticLink=var.meaning.edQualifiedStaticLink();
	    	String procIdent = decl.getJavaIdentifier();
			String procQuant = "new PRCQNT$(" + staticLink + "," + procIdent + ".class)";
			if (decl instanceof Parameter) {
				Parameter par = (Parameter) decl;
				procQuant = ((Variable) actualParameter).getJavaIdentifier();
				if (par.mode == Parameter.Mode.name)
					procQuant = procQuant + ".get()";
			} else if (decl instanceof ProcedureDeclaration) {
				ProcedureDeclaration procedure = (ProcedureDeclaration) decl;
    	    	if(procedure.myVirtual!=null) {
    	    		VirtualSpecification vir = procedure.myVirtual.virtualSpec;
    				procQuant=staticLink+'.'+vir.getVirtualIdentifier();
    	    	}
			} else if (decl instanceof VirtualSpecification) {
				VirtualSpecification vir = (VirtualSpecification) decl;
				procQuant=staticLink+'.'+vir.getVirtualIdentifier();
			} else Util.FATAL_ERROR("TODO: Flere sånne(1) tilfeller ???  QUAL="+decl.getClass().getSimpleName());
			return(procQuant);
	    } else if (actualParameter instanceof RemoteVariable) {
			// Check for <ObjectExpression> DOT <Variable>
			RemoteVariable rem = (RemoteVariable) actualParameter;
			String staticLink = rem.obj.toJavaCode();
			Variable var = rem.var;
			Declaration decl=var.meaning.declaredAs;
			if (decl instanceof VirtualSpecification) {
				VirtualSpecification vir = (VirtualSpecification) decl;
				return(staticLink+'.'+vir.getVirtualIdentifier());
			} else if (decl instanceof ProcedureDeclaration) {
				ProcedureDeclaration procedure = (ProcedureDeclaration) decl;
    	    	if(procedure.myVirtual!=null) {
    	    		VirtualSpecification vir = procedure.myVirtual.virtualSpec;
    				return(staticLink+'.'+vir.getVirtualIdentifier());
    	    	}
			} else Util.FATAL_ERROR("TODO: Flere sånne(2) tilfeller ???  QUAL="+decl.getClass().getSimpleName());
			String procIdent = var.meaning.declaredAs.getJavaIdentifier();
			return("new PRCQNT$(" + staticLink + "," + procIdent + ".class)");
		} else Util.error("Illegal Procedure Expression as Actual Parameter: " + actualParameter);
	    return("UNKNOWN"); // Error recovery
	}

}
