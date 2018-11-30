/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import simula.compiler.utilities.Util;

/**
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class HiddenSpecification {
	public String identifier;
	public ClassDeclaration definedIn;
    private ProtectedSpecification protectedBy; // Set during doChecking
    public ProtectedSpecification getProtectedBy() {
    	if(protectedBy==null) doChecking();
    	return(protectedBy);
    }

	public HiddenSpecification(ClassDeclaration definedIn,String identifier) {
		this.definedIn=definedIn;
		this.identifier=identifier;
	}
	
	// ***********************************************************************************************
	// *** Utility: doChecking -- Called from ClassDeclaration.checkHiddenList
	// ***********************************************************************************************
	public void doChecking() {
	    protectedBy=getMatchingProtected();
	    if(protectedBy!=null) protectedBy.hiddenBy=this;
	}
	
	// ***********************************************************************************************
	// *** Utility: getMatchingProtected -- Find protected attribute and update pointers
	// ***********************************************************************************************
	private ProtectedSpecification getMatchingProtected() {
	    //Util.BREAK("HiddenSpecification("+identifier+").getMatchingProtected(): definedIn="+definedIn);
	    ClassDeclaration scope=this.definedIn;
  	    ProtectedSpecification gotProtected=scope.searchProtectedList(identifier);
  	    if(gotProtected!=null) {
  	    	//Util.BREAK("HiddenSpecification("+identifier+").getMatchingProtected(): FOUND HIDDEN PROTECTED="+gotProtected);
  	    	return(gotProtected);
  	    }
	    scope=scope.getPrefixClass();
	    SEARCH:while(scope!=null)
		{ //Util.BREAK("HiddenSpecification("+identifier+").getMatchingProtected(): SEARCHING: "+scope);
	      HiddenSpecification gotHidden=findHidden(scope,identifier);
	      if(gotHidden!=null) {
	    	  //Util.BREAK("HiddenSpecification("+identifier+").getMatchingProtected(): FOUND HIDDEN="+gotHidden);
	    	  scope=gotHidden.getScopeBehindHidden();
	    	  continue SEARCH;
	      }
    	  gotProtected=scope.searchProtectedList(identifier);
    	  if(gotProtected!=null) {
    		  //Util.BREAK("HiddenSpecification("+identifier+").getMatchingProtected(): FOUND SINGLE PROTECTED="+gotProtected);
    		  return(gotProtected);
    	  }
	      scope=scope.getPrefixClass();
		}
		Util.error(identifier+" is specified HIDDEN without being PROTECTED");
		return(null);
	}

	// ***********************************************************************************************
	// *** Utility: getScopeBehindHidden -- Search backwards from 'hidden' ...
	// ***********************************************************************************************
	public ClassDeclaration getScopeBehindHidden() {
		ProtectedSpecification protectedBy=getProtectedBy();
		ClassDeclaration definedIn=protectedBy.definedIn;
//		Declaration atr=definedIn.findLocalAttribute(this.identifier);
//		if(atr instanceof ProcedureDeclaration) {
//			ProcedureDeclaration proc=(ProcedureDeclaration)atr;
//			VirtualSpecification virtSpec=proc.getVirtualSpecification();
//			if(virtSpec!=null) {
//				return(virtSpec.specifiedIn.getPrefixClass());
//			}
//		}
		return(definedIn.getPrefixClass());
	}
	
	// ***********************************************************************************************
	// *** Utility: findHidden -- Search Protected-list for 'ident'
	// ***********************************************************************************************
	private static HiddenSpecification findHidden(ClassDeclaration scope,String ident)
	{ for(HiddenSpecification hdn:scope.hiddenList) if(ident.equalsIgnoreCase(hdn.identifier))
	  { //Util.BREAK("HiddenSpecification.findHidden("+ident+"): FOUND");
	      return(hdn);
	  }
	  return(null);
	}

	
	public String toString()
	{ StringBuilder s=new StringBuilder();
	  s.append("Hidden ").append(identifier);
	  //public ClassDeclaration definedIn;
	  s.append("[Defined in ");
	  s.append((definedIn!=null)?definedIn.identifier:"UNKNOWN");
	  if(protectedBy!=null) {
		  //public ProtectedSpecification protectedBy; // Set during doChecking
		  s.append(", Protected by ").append(protectedBy.identifier);
		  s.append("[defined in ");
		  s.append((protectedBy.definedIn!=null)?protectedBy.definedIn.identifier:"MISSING");
		  s.append("]");
	  }
	  s.append("]");
	  return(s.toString());
	}

}