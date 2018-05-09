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
import simula.compiler.utilities.VariableKind;

public abstract class DeclarationScope extends Declaration {
	
  public int blockLevel;

  public boolean hasLocalClasses=false;
  public boolean detachUsed=false; // Set true when attribute procedure 'detach' is used in/on this class.
  
  public Variable blockPrefix; // Block Prefix in case of Prefixed Block.
  public String prefix; // Class Prefix in case of a SubClass or Prefixed Block.
  public Vector<Parameter> parameterList=new Vector<Parameter>();
  public Vector<Declaration> declarationList=new Vector<Declaration>();
  public Vector<Virtual> virtualList=new Vector<Virtual>();
  public Vector<LabelDeclaration> labelList=new Vector<LabelDeclaration>();

  Virtual findVirtual(String ident) { return(null); }  // Needs redefinition

  // ***********************************************************************************************
  // *** Constructor
  // ***********************************************************************************************
  public DeclarationScope(String ident)
  { super(ident);
	declaredIn=Global.currentScope; Global.currentScope=this;
  }
  	  
  // ***********************************************************************************************
  // *** Utility: findMeaning
  // ***********************************************************************************************
  public Meaning findMeaning(String identifier)
  {	//Util.BREAK("DeclarationScope("+identifier+").findDefinition("+identifier+"): scope="+declaredIn);
	Meaning meaning=findAttributeMeaning(identifier);
	if(meaning==null && declaredIn!=null) meaning=declaredIn.findMeaning(identifier);
	if(meaning==null) Util.error("Undefined variable: "+identifier);
    return(meaning);
  }

  // ***********************************************************************************************
  // *** Utility: findAttributeMeaning
  // ***********************************************************************************************
  public Meaning findAttributeMeaning(String ident)
  { //Util.BREAK("DeclarationScope("+identifier+").findAttribute("+ident+"): scope="+declaredIn);
    for(Parameter parameter:parameterList)
        if(ident.equalsIgnoreCase(parameter.identifier)) return(new Meaning(VariableKind.parameter,parameter,this));
    for(Declaration declaration:declarationList)
	    if(ident.equalsIgnoreCase(declaration.identifier)) return(new Meaning(VariableKind.attribute,declaration,this));
    for(LabelDeclaration label:labelList)
	    if(ident.equalsIgnoreCase(label.identifier)) return(new Meaning(VariableKind.label,label,this));
    for(Virtual virtual:virtualList)
	    if(ident.equalsIgnoreCase(virtual.identifier)) return(new Meaning(VariableKind.virtual,virtual,this)); 
    BlockDeclaration prfx=getPrefix();
    if(prfx!=null)
    { Meaning meaning=prfx.findAttributeMeaning(ident);
      if(meaning!=null) meaning.declaredIn=this;
      return(meaning);
    }
    return(null);
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
  public DeclarationScope findThis(String identifier)
  { DeclarationScope result=null;
   	//Util.BREAK("DeclarationScope("+this.identifier+").findThis("+identifier+"):");
	if(identifier.equalsIgnoreCase(this.identifier)) result=this;
    else if(declaredIn!=null) result=declaredIn.findThis(identifier);
    return(result);
  }

  // ***********************************************************************************************
  // *** Coding Utility: edCTX(blockLevel)
  // ***********************************************************************************************
  public String edCTX(int blockLevel)
  { if(blockLevel==0) return("CTX$");
    if(blockLevel==1) return("PRG$");
    return("CV$["+blockLevel+"]");
  }

  // ***********************************************************************************************
  // *** Coding: isQPSystemBlock  -- QPS System is any block with local class(es)
  // ***********************************************************************************************
  public boolean isQPSystemBlock()
  {	switch(blockKind)
	{ case SimulaProgram:
	  case SubBlock:
	  case PrefixedBlock:
		       return(hasLocalClasses);
	  default: return(false);
	}  
  }

  // ***********************************************************************************************
  // *** Coding: isDetachUsed  -- If the 'detach' attribute is used
  // ***********************************************************************************************
  /**
   * Ta utgangspunkt i hvilke klasser man har kalt "detach" i, alts� kvalifikasjonen av de X som er
   * brukt i "X.detach".  Men da m� man jo ogs� holde greie p� hvilke slike som har forekommet i
   * eksterne "moduler" (som f.eks. SIMULATION), uten at det burde v�re problematisk. 
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
