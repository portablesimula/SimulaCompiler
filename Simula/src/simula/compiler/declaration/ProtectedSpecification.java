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
public final class ProtectedSpecification {
	public String identifier;
	public ClassDeclaration definedIn;
    public HiddenSpecification hiddenBy; // Set during doChecking

	public ProtectedSpecification(ClassDeclaration definedIn,String identifier) {
		this.definedIn=definedIn;
		this.identifier=identifier;
	}
	
	public Declaration getAttribute() {
		// The Attribute being Protected
		return(definedIn.findLocalAttribute(identifier));
	}
	
	public VirtualSpecification getVirtualSpecification() {
		// The Attribute being Protected may be Virtual
		return(definedIn.searchVirtualSpecList(identifier));
	}
	
	// ***********************************************************************************************
	// *** Utility: doChecking -- Called from ClassDeclaration.checkProtectedList
	// ***********************************************************************************************
	public void doChecking() {
		Declaration attribute=getAttribute();
		//Util.BREAK("ProtectedSpecification("+identifier+").doChecking: attribute="+attribute+" FOUND in "+definedIn);
		if(attribute!=null) attribute.isProtected=this;
		else Util.error("No Attribute "+identifier+" match 'protected' specification: "+this);
		//
		if(attribute instanceof ProcedureDeclaration) {
			VirtualSpecification virtSpec=((ProcedureDeclaration)attribute).getVirtualSpecification();
			if(virtSpec!=null) {
				if( virtSpec.specifiedIn != attribute.declaredIn )
					Util.error("A virtual attribute may only be specified protected in the class heading in which the virtual specification occurs.");
			}
		}
		// Virtual specification together with Attribute definition.
		VirtualSpecification vir=getVirtualSpecification();
		//Util.BREAK("ProtectedSpecification("+identifier+").doChecking: virtual="+vir+", declaredIn="+((vir!=null)?vir.declaredIn:"MISSING"));
		if(vir!=null) vir.isProtected=this;
	}

	
	public String toString()
	{ StringBuilder s=new StringBuilder();
	  s.append("Protected ").append(identifier);
	  //public ClassDeclaration definedIn;
	  s.append("[ Defined in ");
	  s.append((definedIn!=null)?definedIn.identifier:"UNKNOWN");
	  if(hiddenBy!=null) {
		  //public ProtectedSpecification protectedBy; // Set during doChecking
		  s.append(", Hidden by ").append(hiddenBy.identifier);
		  s.append(" defined in ");
		  s.append((hiddenBy.definedIn!=null)?hiddenBy.definedIn.identifier:"MISSING");
	  }
	  s.append("]");
	  return(s.toString());
	}

}
