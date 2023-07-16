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
 * Protected Specification.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/declaration/ProtectedSpecification.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class ProtectedSpecification implements Externalizable {
	
	/**
	 * The protected identifier.
	 */
	String identifier;
	
	/**
	 * .
	 */
	ClassDeclaration definedIn;
	
	/**
	 * .
	 */
    HiddenSpecification hiddenBy; // Set during doChecking

    /**
     * Create a new ProtectedSpecification.
     * @param definedIn the class it is defined in
     * @param identifier the protected identifier
     */
	ProtectedSpecification(final ClassDeclaration definedIn,final String identifier) {
		this.definedIn=definedIn;
		this.identifier=identifier;
	}
	
	private Declaration getAttribute() {
		// The Attribute being Protected
		return(definedIn.findLocalAttribute(identifier));
	}
	
	private VirtualSpecification getVirtualSpecification() {
		// The Attribute being Protected may be Virtual
		return(definedIn.searchVirtualSpecList(identifier));
	}
	
	// ***********************************************************************************************
	// *** Utility: doChecking -- Called from ClassDeclaration.checkProtectedList
	// ***********************************************************************************************
	/**
	 * Perform semantic checking.
	 */
	void doChecking() {
		Declaration attribute=getAttribute();
		if(attribute!=null) attribute.isProtected=this;
		else Util.error("No Attribute "+identifier+" match 'protected' specification: "+this);
		VirtualSpecification virtSpec=VirtualSpecification.getVirtualSpecification(attribute);
		if(virtSpec!=null) {
			if( virtSpec.declaredIn != attribute.declaredIn )
				Util.error("A virtual attribute may only be specified protected in the class heading in which the virtual specification occurs.");
		}
		// Virtual specification together with Attribute definition.
		VirtualSpecification vir=getVirtualSpecification();
		if(vir!=null) vir.isProtected=this;
	}

	
	@Override
	public String toString()
	{ StringBuilder s=new StringBuilder();
	  s.append("Protected ").append(identifier);
	  s.append("[ Defined in ");
	  s.append((definedIn!=null)?definedIn.identifier:"UNKNOWN");
	  if(hiddenBy!=null) {
		  s.append(", Hidden by ").append(hiddenBy.identifier);
		  s.append(" defined in ");
		  s.append((hiddenBy.definedIn!=null)?hiddenBy.definedIn.identifier:"MISSING");
	  }
	  s.append("]");
	  return(s.toString());
	}


	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	/**
	 * Default constructor used by Externalization.
	 */
	public ProtectedSpecification() {}

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
