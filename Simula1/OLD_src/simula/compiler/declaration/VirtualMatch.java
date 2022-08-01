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

import simula.compiler.JavaModule;
import simula.compiler.utilities.Util;

/**
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class VirtualMatch extends Declaration implements Externalizable {
	public VirtualSpecification virtualSpec; // Set during doChecking
    public ProcedureDeclaration match;       // Set during doChecking
	
	public VirtualMatch(final VirtualSpecification virtualSpec,final ProcedureDeclaration match) {
		super(virtualSpec.identifier);
		this.declarationKind=Declaration.Kind.VirtualMatch;
		// NOTE: Called during Checking
		this.virtualSpec=virtualSpec;
		this.match=match;
	}

	public void doJavaCoding(){
	    String matchCode="{ throw new RuntimeException(\"No Virtual Match: "+identifier+"\"); }";
	    if(match!=null)
		    matchCode="{ return(new PRCQNT$(this,"+match.getJavaIdentifier()+".class)); }";
	    JavaModule.code("public PRCQNT$ "+virtualSpec.getVirtualIdentifier()+" "+matchCode);
	}
	
	public String toString() {
		StringBuilder s=new StringBuilder();
	    if(match.type!=null) s.append(match.type).append(' '); 
	    s.append("PROCEDURE ").append(match.identifier);
	    if(virtualSpec!=null)
		    s.append("[Specified by ").append(virtualSpec.identifier).append(']');
	    return(s.toString());
	}

	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	public VirtualMatch() {
		super(null);
		this.declarationKind=Declaration.Kind.VirtualMatch;
	}

	@Override
	public void writeExternal(ObjectOutput oupt) throws IOException {
		Util.TRACE_OUTPUT("VirtualMatch: "+identifier);
	    oupt.writeObject(identifier);
	    oupt.writeObject(externalIdent);
	}

	@Override
	public void readExternal(ObjectInput inpt) throws IOException, ClassNotFoundException {
		identifier=(String)inpt.readObject();
		externalIdent=(String)inpt.readObject();
		Util.TRACE_INPUT("VirtualMatch: "+identifier);
		match=((ClassDeclaration) this.declaredIn).findLocalProcedure(identifier);
		if(match!=null) {
			virtualSpec=VirtualSpecification.getVirtualSpecification(match);  // AdHoc
		} else
	  	Util.error("Malformed Attribute File (at VirtualMatch "+identifier+")");
	}

}
