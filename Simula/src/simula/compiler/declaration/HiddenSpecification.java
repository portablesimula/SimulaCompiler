/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.Util;

/**
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class HiddenSpecification implements Externalizable {
	String identifier;
	ClassDeclaration definedIn;
    private ProtectedSpecification protectedBy; // Set during doChecking
    private ProtectedSpecification getProtectedBy() {
    	if(protectedBy==null) doChecking();
    	return(protectedBy);
    }

	HiddenSpecification(final ClassDeclaration definedIn,final String identifier) {
		this.definedIn=definedIn;
		this.identifier=identifier;
	}
	
	// ***********************************************************************************************
	// *** Utility: doChecking -- Called from ClassDeclaration.checkHiddenList
	// ***********************************************************************************************
	void doChecking() {
	    protectedBy=getMatchingProtected();
	    if(protectedBy!=null) protectedBy.hiddenBy=this;
	}
	
	// ***********************************************************************************************
	// *** Utility: getMatchingProtected -- Find protected attribute and update pointers
	// ***********************************************************************************************
	private ProtectedSpecification getMatchingProtected() {
	    ClassDeclaration scope=this.definedIn;
  	    ProtectedSpecification gotProtected=scope.searchProtectedList(identifier);
  	    if(gotProtected!=null) {
  	    	return(gotProtected);
  	    }
	    scope=scope.getPrefixClass();
	    SEARCH:while(scope!=null) {
	    	HiddenSpecification gotHidden=findHidden(scope,identifier);
	    	if(gotHidden!=null) {
	    		scope=gotHidden.getScopeBehindHidden();
	    		continue SEARCH;
	    	}
	    	gotProtected=scope.searchProtectedList(identifier);
	    	if(gotProtected!=null) {
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
	ClassDeclaration getScopeBehindHidden() {
		ProtectedSpecification protectedBy=getProtectedBy();
		ClassDeclaration definedIn=protectedBy.definedIn;
		return(definedIn.getPrefixClass());
	}
	
	// ***********************************************************************************************
	// *** Utility: findHidden -- Search Protected-list for 'ident'
	// ***********************************************************************************************
	private static HiddenSpecification findHidden(final ClassDeclaration scope,final String ident)
	{ for(HiddenSpecification hdn:scope.hiddenList)
		if(Util.equals(ident, hdn.identifier)) return(hdn);
	  return(null);
	}

	
	@Override
	public String toString()
	{ StringBuilder s=new StringBuilder();
	  s.append("Hidden ").append(identifier);
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


	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	public HiddenSpecification() {}

	@Override
	public void writeExternal(ObjectOutput oupt) throws IOException {
		Util.TRACE_OUTPUT("ProtectedSpecification: "+identifier);
		oupt.writeObject(identifier);
	}

	@Override
	public void readExternal(ObjectInput inpt) throws IOException, ClassNotFoundException {
		identifier=(String)inpt.readObject();
		this.definedIn=(ClassDeclaration)Global.getCurrentScope();
		Util.TRACE_INPUT("ProtectedSpecification: "+identifier);
	}

}
