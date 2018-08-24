/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import java.util.Vector;

import simula.compiler.expression.Variable;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Util;

public abstract class DeclarationScope extends Declaration {
	
  protected static int currentBlockLevel=0; // Used during doChecking
  public int blockLevel;

  public boolean hasLocalClasses=false;
  public boolean detachUsed=false; // Set true when attribute procedure 'detach' is used in/on this class.
  
  public Variable blockPrefix; // Block Prefix in case of Prefixed Block.
  public String prefix; // Class Prefix in case of a SubClass or Prefixed Block.
  public Vector<Parameter> parameterList=new Vector<Parameter>();
  public Vector<Declaration> declarationList=new Vector<Declaration>();
  public Vector<Virtual> virtualList=new Vector<Virtual>();
  public Vector<String> hiddenList=new Vector<String>();
  public Vector<String> protectedList=new Vector<String>();
  public Vector<LabelDeclaration> labelList=new Vector<LabelDeclaration>();

  Virtual findVirtual(String ident) { return(null); }  // Needs redefinition

  // ***********************************************************************************************
  // *** Constructor
  // ***********************************************************************************************
  public DeclarationScope(String ident)
  { super(ident);
	declaredIn=Global.currentScope; Global.currentScope=this;
	
//	if(this instanceof StandardClass
//	|| this instanceof StandardProcedure);
//	else Util.BREAK("NEW DeclarationScope("+ident+")="+this.getClass().getSimpleName()+", ScopeChain="+edScopeChain());
  }
  
//  public String toString()
//  { return("SCOPE: "+identifier);
//	  
//  }
  
  // ***********************************************************************************************
  // *** Utility: addParameter
  // ***********************************************************************************************
  public void addParameter(Parameter parameter)
  { for(Parameter par:parameterList)
	   	if(par.identifier.equalsIgnoreCase(parameter.identifier))
           { Util.error("Parameter already defined: "+identifier); return; }
    parameterList.add(parameter);
  }
  	  
  // ***********************************************************************************************
  // *** Utility: findMeaning
  // ***********************************************************************************************
  public Meaning findMeaning(String identifier)
  { //if(identifier.equalsIgnoreCase("ln"))  Util.BREAK("DeclarationScope("+this.identifier+").findMeaning("+identifier+"): scope="+this);
	Meaning meaning=findVisibleAttributeMeaning(identifier);
//	if(identifier.equalsIgnoreCase("ln"))  Util.BREAK("DeclarationScope("+this.identifier+").findMeaning("+identifier+"): meaning1="+meaning);
//	if(identifier.equalsIgnoreCase("ln"))  Util.BREAK("DeclarationScope("+this.identifier+").findMeaning("+identifier+"): declaredIn="+declaredIn);
//	if(identifier.equalsIgnoreCase("ln"))  Util.BREAK("DeclarationScope("+this.identifier+").findMeaning("+identifier+"): ScopeChain="+edScopeChain());
	if(meaning==null && declaredIn!=null) meaning=declaredIn.findMeaning(identifier);
//	if(identifier.equalsIgnoreCase("ln"))  Util.BREAK("DeclarationScope("+this.identifier+").findMeaning("+identifier+"): meaning2="+meaning);
	if(meaning==null) {
	    //if(identifier.equalsIgnoreCase("L"))Util.BREAK("DeclarationScope("+this.identifier+").findMeaning("+identifier+") ==> UNDEFINED");
		Util.error("Undefined variable: "+identifier);
		meaning=new Meaning(null,null,null); // Error Recovery: No Meaning
	}
    return(meaning);
  }

//  // ***********************************************************************************************
//  // *** Utility: findAttributeMeaning
//  // ***********************************************************************************************
//  public Meaning findAttributeMeaning_OLD(String ident)
//  { //Util.BREAK("DeclarationScope("+identifier+").findAttribute("+ident+"): scope="+declaredIn);
//    for(Parameter parameter:parameterList)
//        if(ident.equalsIgnoreCase(parameter.identifier)) return(new Meaning(Variable.Kind.parameter,parameter,this));
//    for(Declaration declaration:declarationList)
//	    if(ident.equalsIgnoreCase(declaration.identifier)) return(new Meaning(Variable.Kind.attribute,declaration,this));
//    for(LabelDeclaration label:labelList)
//	    if(ident.equalsIgnoreCase(label.identifier)) return(new Meaning(Variable.Kind.label,label,this));
//    for(Virtual virtual:virtualList)
//	    if(ident.equalsIgnoreCase(virtual.identifier)) return(new Meaning(Variable.Kind.virtual,virtual,this)); 
//    BlockDeclaration prfx=getPrefix();
//    if(prfx!=null)
//    { Meaning meaning=prfx.findAttributeMeaning(ident);
//      if(meaning!=null) meaning.declaredIn=this;
//      return(meaning);
//    }
//    return(null);
//  }

  // ***********************************************************************************************
  // *** Utility: findRemoteAttributeMeaning
  // ***********************************************************************************************
  public Meaning findRemoteAttributeMeaning(String ident)
  {return(findRemoteAttributeMeaning(ident,false)); } 
  
  public Meaning findRemoteAttributeMeaning(String ident,boolean behindProtected)
  { //if(ident.equalsIgnoreCase("detach"))Util.BREAK("DeclarationScope("+identifier+").findRemoteAttributeMeaning("+ident+"): scope="+this);
	boolean prtected=false;
    for(String prct:protectedList)
    	if(ident.equalsIgnoreCase(prct))
   	    { if(!withinScope(this)) behindProtected=prtected=true;
   	      break;
    	}
    //Util.BREAK("DeclarationScope("+identifier+").findRemoteAttributeMeaning("+ident+"): prtected="+prtected);
    if(!prtected)
    { for(Parameter parameter:parameterList)
        if(ident.equalsIgnoreCase(parameter.identifier))
        	return(new Meaning(Variable.Kind.parameter,parameter,this,this,behindProtected));
      for(Declaration declaration:declarationList)
	    if(ident.equalsIgnoreCase(declaration.identifier))
	    	return(new Meaning(Variable.Kind.attribute,declaration,this,this,behindProtected));
      for(LabelDeclaration label:labelList)
	    if(ident.equalsIgnoreCase(label.identifier))
	    	return(new Meaning(Variable.Kind.label,label,this,this,behindProtected));
      for(Virtual virtual:virtualList)
	    if(ident.equalsIgnoreCase(virtual.identifier))
	    	return(new Meaning(Variable.Kind.virtual,virtual,this,this,behindProtected)); 
    }
    //Util.BREAK("NOT FOUND - DeclarationScope("+identifier+").findRemoteAttributeMeaning("+ident+"): scope="+declaredIn);
    
//    if( ((BlockDeclaration)this).hasNoRealPrefix()) return(null);  // TODO: SIKKER PÅ DETTE ?
    
    BlockDeclaration prfx=getPrefix();
    if(prfx!=null)
    { Meaning meaning=prfx.findRemoteAttributeMeaning(ident,behindProtected);
      if(meaning!=null) meaning.declaredIn=this;
      return(meaning);
    }
    return(null);
  }
  
  
  // ***********************************************************************************************
  // *** Utility: withinScope -- Used by findRemoteAttributeMeaning
  // ***********************************************************************************************
  private static boolean withinScope(DeclarationScope otherScope)
  { DeclarationScope scope=Global.currentScope;
	while(scope!=null)
	{ if(scope==otherScope) return(true);
	  BlockDeclaration prfx=scope.getPrefix();
	  while(prfx!=null)
	  { if(prfx==otherScope) return(true);
	    prfx=prfx.getPrefix();
	  }
	  scope=scope.declaredIn;
	}
	return(false);
  }
  
  // ***********************************************************************************************
  // *** Utility: findVisibleAttributeMeaning
  // ***********************************************************************************************
  public Meaning findVisibleAttributeMeaning(String ident)
  { //if(ident.equalsIgnoreCase("ln")) Util.BREAK("DeclarationScope("+identifier+").findVisibleAttributeMeaning("+ident+"): scope="+this);
    //if(ident.equalsIgnoreCase("ln")) Util.BREAK("DeclarationScope("+identifier+").findVisibleAttributeMeaning("+ident+"): declaredIn="+declaredIn);
	boolean searchBehindHidden=false;
	DeclarationScope scope=this;
	SEARCH:while(scope!=null)
    { //if(ident.equalsIgnoreCase("adHoc00")) Util.BREAK("DeclarationScope("+scope+").findVisibleAttributeMeaning("+ident+"): scope="+scope);
//	  for(Parameter parameter:scope.parameterList)
//      if(ident.equalsIgnoreCase(parameter.identifier))
//        { DeclarationScope hiddenScope=scope.getHidden(ident);
//          if(hiddenScope==null) return(new Meaning(Variable.Kind.parameter,parameter,this,scope,searchBehindHidden));
//          scope=scope.getScopeBehindHidden(ident); continue SEARCH;
//        }
      for(Declaration declaration:scope.declarationList)
	    if(ident.equalsIgnoreCase(declaration.identifier))
	    { DeclarationScope hiddenScope=scope.getHidden(ident);
          if(hiddenScope==null) return(new Meaning(Variable.Kind.attribute,declaration,this,scope,searchBehindHidden));
          scope=scope.getScopeBehindHidden(ident); continue SEARCH;
	    }
	  for(Parameter parameter:scope.parameterList)
	      if(ident.equalsIgnoreCase(parameter.identifier))
	        { DeclarationScope hiddenScope=scope.getHidden(ident);
	          if(hiddenScope==null) return(new Meaning(Variable.Kind.parameter,parameter,this,scope,searchBehindHidden));
	          scope=scope.getScopeBehindHidden(ident); continue SEARCH;
	        }
      for(LabelDeclaration label:scope.labelList)
	    if(ident.equalsIgnoreCase(label.identifier))
	    { DeclarationScope hiddenScope=scope.getHidden(ident);
          if(hiddenScope==null)	return(new Meaning(Variable.Kind.label,label,this,scope,searchBehindHidden));
          scope=scope.getScopeBehindHidden(ident); continue SEARCH;
	    }
      for(Virtual virtual:scope.virtualList)
	    if(ident.equalsIgnoreCase(virtual.identifier))
	    { DeclarationScope hiddenScope=scope.getHidden(ident);
          if(hiddenScope==null)	return(new Meaning(Variable.Kind.virtual,virtual,this,scope,searchBehindHidden));
          scope=scope.getScopeBehindHidden(ident); continue SEARCH;
	    }
      
      if(scope.getHidden(ident)==null) scope=scope.getPrefix();
      else { scope=scope.getScopeBehindHidden(ident); searchBehindHidden=true; }
	}
    return(null);
  }

  // ***********************************************************************************************
  // *** Utility: getHidden  --  Used by findVisibleAttributeMeaning
  // ***********************************************************************************************
  // Search backwards through prefix chain - find hidden
  // then return the scope where it was specified hidden.
  // If no HIDDEN was found - return null
  public DeclarationScope getHidden(String ident)
  { BlockDeclaration prfx=getPrefix();
    //Util.BREAK("DeclarationScope("+identifier+").getHidden("+ident+"): scope="+this+", prefix="+prfx);
	if(prfx==null) return(null);
    for(String hdn:prfx.hiddenList) if(ident.equalsIgnoreCase(hdn))
    { //Util.BREAK("DeclarationScope("+identifier+").getHidden("+ident+"): FOUND - scope="+prfx);
      return(prfx);
    }
    return(prfx.getHidden(ident));
  }

  // ***********************************************************************************************
  // *** Utility: getScopeBehindHidden  --  Used by findVisibleAttributeMeaning
  // ***********************************************************************************************
  // Search for protected backwards through prefix chain starting with this scope
  // - find corresponding protected
  // then return the scope prefix to where it was specified protected.
  // If no PROTECTED was found - Runtime Error
  private DeclarationScope getScopeBehindHidden(String ident)
  { DeclarationScope scope=this;
    //Util.BREAK("DeclarationScope("+identifier+").getScopeBehindHidden("+ident+"): scope="+scope);
    while(scope!=null)
	{ BlockDeclaration prfx=scope.getPrefix();
      for(String ptc:scope.protectedList) if(ident.equalsIgnoreCase(ptc)) return(prfx);
      scope=prfx;
      //Util.BREAK("DeclarationScope("+identifier+").getScopeBehindHidden("+ident+"): scope="+scope);
	}
	throw new RuntimeException(ident+" is specified HIDDEN without being PROTECTED");
  }
    
  // ***********************************************************************************************
  // *** Utility: getPrefix
  // ***********************************************************************************************
  public BlockDeclaration getPrefix()
  { //Util.BREAK("DeclarationScope.getPrefix: "+prefix);
	if(prefix==null) return(null);
    //Util.BREAK("DeclarationScope.getPrefix("+prefix+") Search in "+declaredIn);
    Meaning meaning=declaredIn.findMeaning(prefix);
    //Util.BREAK("DeclarationScope.getPrefix("+prefix+") Search in "+declaredIn+", Result="+meaning);
    if(meaning==null) Util.error("Undefined prefix: "+prefix);
    Declaration decl=meaning.declaredAs;
    if(decl==this) Util.error("Class prefix chain loops");
    if(decl instanceof BlockDeclaration) return((BlockDeclaration)decl); 
    if(decl instanceof StandardClass) return((BlockDeclaration)decl); 
    Util.error("Prefix "+prefix+" is not a Class, but "+decl.getClass().getSimpleName());
    return(null);
  }

  // ***********************************************************************************************
  // *** Utility: findThis
  // ***********************************************************************************************
//  private DeclarationScope OLD_findThis(String identifier)
//  { DeclarationScope result=null;
//   	Util.BREAK("DeclarationScope("+this.identifier+").findThis("+identifier+"):");
//	if(identifier.equalsIgnoreCase(this.identifier)) result=this;
//    else if(declaredIn!=null) result=declaredIn.findThis(identifier);
//    return(result);
//  }
  public DeclarationScope findThis(String identifier)
  { 
//   	Util.BREAK("DeclarationScope("+this.identifier+").findThis("+identifier+"):");
//   	Util.BREAK("DeclarationScope("+this.identifier+").findThis("+identifier+"): CHECKING "+this);
	if(identifier.equalsIgnoreCase(this.identifier)) return(this);
	
	DeclarationScope x=this;
	while((x=x.getPrefix())!=null)
	{
//	   	Util.BREAK("DeclarationScope("+this.identifier+").findThis("+identifier+"): CHECKING "+x);
		if(identifier.equalsIgnoreCase(x.identifier)) return(x);
	}	
    if(declaredIn!=null) return(declaredIn.findThis(identifier));
    return(null);
  }

  // ***********************************************************************************************
  // *** Coding Utility: edCTX(contextLevel)
  // ***********************************************************************************************
  public String edCTX()
  {
	if(blockLevel==0) return("CTX$");
//    if(blockLevel==1) return("PRG$");  // TODO: Eget navn for hver separat kompilering -- eller ???
	
    int curLevel=Global.currentScope.blockLevel;
//    Util.BREAK("DeclarationScope.edCTX: Current="+Global.currentScope);
//    Util.BREAK("DeclarationScope.edCTX: Current'Qual="+Global.currentScope.getClass().getSimpleName());
//    Util.BREAK("DeclarationScope.edCTX: Current'BlockLevel="+curLevel);
//    Util.BREAK("DeclarationScope.edCTX: Current'Enc'BlockLevel="+Global.currentScope.declaredIn.blockLevel);
    Util.ASSERT(curLevel >= Global.currentScope.declaredIn.blockLevel,"Invariant");
    if(blockLevel==curLevel) return("CUR$");
    String ret="CUR$";
    while(blockLevel<(curLevel--)) ret=ret+".SL$";
    return("("+ret+')');
  }

  // ***********************************************************************************************
  // *** Coding: isBlockWithLocalClasses
  // ***********************************************************************************************
  public boolean isBlockWithLocalClasses()
  {	if(this.hasLocalClasses) return(true);
	DeclarationScope prfx=getPrefix();
	if(prfx!=null) return(prfx.isBlockWithLocalClasses());
	return(false); 
  }


  // ***********************************************************************************************
  // *** Coding: isQPSystemBlock  -- QPS System is any block with local class(es)
  // ***********************************************************************************************
  public boolean isQPSystemBlock()
  {	switch(blockKind)
	{ case SimulaProgram:
	  case SubBlock:
		        return(hasLocalClasses);
	  case PrefixedBlock:
		  		if(this.hasLocalClasses) return(true);
		  		DeclarationScope prfx=getPrefix();
		  		if(prfx!=null) return(prfx.isBlockWithLocalClasses());
		  		return(false);
	  default: return(false);
	}  
  }
  // ***********************************************************************************************
  // *** Coding: isDetachUsed  -- If the 'detach' attribute is used
  // ***********************************************************************************************
  /**
   * KOMMENTAR FRA Stein:
   * Ta utgangspunkt i hvilke klasser man har kalt "detach" i, altså kvalifikasjonen av de X som er
   * brukt i "X.detach".  Men da må man jo også holde greie på hvilke slike som har forekommet i
   * eksterne "moduler" (som f.eks. SIMULATION), uten at det burde være problematisk. 
   *  
   * @return
   */
  public boolean isDetachUsed()
  {	//TRAVERSER PREFIX LOOKING FOR  (detachUsed==true)
	if(this.detachUsed) return(true);
	DeclarationScope prfx=getPrefix();
	if(prfx!=null) return(prfx.isDetachUsed());
	return(false);
  }
	  
  // ***********************************************************************************************
  // *** Print Utility: edScopeChain
  // ***********************************************************************************************
  public String edScopeChain()
  { if(declaredIn==null) return(identifier);
    String encName=declaredIn.edScopeChain();
	return(identifier+'.'+encName);
  }
	  
  // ***********************************************************************************************
  // *** Utility: edJavaClassName
  // ***********************************************************************************************
  public String edJavaClassName()
  { DeclarationScope scope=this;
    String id=null;
    while(scope!=null)
    { if((scope instanceof BlockDeclaration)
    		&& !(scope instanceof StandardClass)
    		&& !(scope instanceof StandardProcedure))
      { if(id==null) id=scope.identifier;
        else id=scope.identifier+'$'+id;
      }
      scope=scope.declaredIn;
    }
    //Util.BREAK("DeclarationScope.edJavaClassName("+identifier+") ==> "+id);
    return(id);
  }

}
