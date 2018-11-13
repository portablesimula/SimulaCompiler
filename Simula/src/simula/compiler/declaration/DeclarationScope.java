/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import java.util.Vector;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Util;

public abstract class DeclarationScope extends Declaration {
	
  protected static int currentBlockLevel=0; // Used during doChecking
  public int blockLevel;
  public boolean hasLocalClasses=false;
  public Vector<Declaration> declarationList=new Vector<Declaration>();
  public Vector<LabelDeclaration> labelList=new Vector<LabelDeclaration>();

  // ***********************************************************************************************
  // *** Constructor
  // ***********************************************************************************************
  public DeclarationScope(String ident)
  { super(ident);
	declaredIn=Global.currentScope; Global.currentScope=this;
  }
  
  // ***********************************************************************************************
  // *** Utility: findVisibleAttributeMeaning
  // ***********************************************************************************************
  public Meaning findVisibleAttributeMeaning(String ident)
  { Util.FATAL_ERROR("BlockDeclaration.findVisibleAttributeMeaning: SHOULD BEEN REDEFINED");
	return(null);
  }
	  
  // ***********************************************************************************************
  // *** Utility: findMeaning
  // ***********************************************************************************************
  public Meaning findMeaning(String identifier)
  { //if(identifier.equalsIgnoreCase("ln"))  Util.BREAK("DeclarationScope("+this.identifier+").findMeaning("+identifier+"): scope="+this);
    Meaning meaning=findVisibleAttributeMeaning(identifier);
    //if(identifier.equalsIgnoreCase("ln"))  Util.BREAK("DeclarationScope("+this.identifier+").findMeaning("+identifier+"): meaning1="+meaning);
    //if(identifier.equalsIgnoreCase("ln"))  Util.BREAK("DeclarationScope("+this.identifier+").findMeaning("+identifier+"): declaredIn="+declaredIn);
    //if(identifier.equalsIgnoreCase("ln"))  Util.BREAK("DeclarationScope("+this.identifier+").findMeaning("+identifier+"): ScopeChain="+edScopeChain());
    if(meaning==null && declaredIn!=null) meaning=declaredIn.findMeaning(identifier);
    //if(identifier.equalsIgnoreCase("ln"))  Util.BREAK("DeclarationScope("+this.identifier+").findMeaning("+identifier+"): meaning2="+meaning);
    if(meaning==null) {
      //if(identifier.equalsIgnoreCase("L"))Util.BREAK("DeclarationScope("+this.identifier+").findMeaning("+identifier+") ==> UNDEFINED");
	  Util.error("Undefined variable: "+identifier);
	  meaning=new Meaning(null,null); // Error Recovery: No Meaning
    }
    return(meaning);
  }

  //***********************************************************************************************
  //*** Utility: findThis  --  Follow Static Chain Looking for a Class named 'identifier'
  //***********************************************************************************************
//  public ClassDeclaration findThis(String identifier)
  public DeclarationScope findThis(String identifier)
  { // Util.BREAK("DeclarationScope("+this.identifier+").findThis("+identifier+"):");
    // Util.BREAK("DeclarationScope("+this.identifier+").findThis("+identifier+"): CHECKING "+this);
    //Util.BREAK("DeclarationScope("+this.identifier+").findThis("+identifier+"): CHECKING "+this+", QUAL="+this.getClass().getSimpleName());
	if (this instanceof ClassDeclaration) {
		ClassDeclaration x = (ClassDeclaration) this;
		if (identifier.equalsIgnoreCase(x.identifier)) return (x);
		while ((x = x.getPrefixClass()) != null) {
			// Util.BREAK("DeclarationScope("+this.identifier+").findThis("+identifier+"): CHECKING "+x);
			if (identifier.equalsIgnoreCase(x.identifier)) return (x);
		}
	} else if (this instanceof ConnectionBlock) {
		ConnectionBlock z = (ConnectionBlock)this;
		ClassDeclaration x = (ClassDeclaration) z.classDeclaration;
		if (identifier.equalsIgnoreCase(x.identifier)) return (z);
		while ((x = x.getPrefixClass()) != null) {
			// Util.BREAK("DeclarationScope("+this.identifier+").findThis("+identifier+"): CHECKING "+x);
			if (identifier.equalsIgnoreCase(x.identifier)) return (z);
		}
	}
    if(declaredIn!=null) return(declaredIn.findThis(identifier));
    return(null);
  }

  // ***********************************************************************************************
  // *** Coding Utility: edCTX(contextLevel)
  // ***********************************************************************************************
  public String edCTX()
  {	if(blockLevel==0) return("CTX$");
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
