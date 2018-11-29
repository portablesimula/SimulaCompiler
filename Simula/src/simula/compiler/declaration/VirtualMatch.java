/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import simula.compiler.JavaModule;

/**
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class VirtualMatch extends Declaration {
	public VirtualSpecification virtualSpec;
    public ProcedureDeclaration match; // Set during doChecking
	
	public VirtualMatch(VirtualSpecification virtualSpec,ProcedureDeclaration match) {
		super(virtualSpec.identifier);
		// NOTE: Called during Checking
		this.virtualSpec=virtualSpec;
		this.match=match;
	}

	public void doJavaCoding()
	{ //Util.BREAK("Virtual.doJavaCoding: "+identifier);
//  	  ASSERT_SEMANTICS_CHECKED(this);
	  String matchCode="{ throw new RuntimeException(\"No Virtual Match\"); }";
	  if(match!=null)
		  matchCode="{ return(new PRCQNT$(this,"+match.getJavaIdentifier()+".class)); }";
//	  JavaModule.code("public PRCQNT$ "+getJavaIdentifier()+"() "+matchCode);
//	  JavaModule.code("public PRCQNT$ "+getJavaIdentifier()+'$'+prefixLevel+"() "+matchCode);
	  JavaModule.code("public PRCQNT$ "+virtualSpec.getVirtualIdentifier()+"() "+matchCode);
	}
	
	public String toString()
	{ StringBuilder s=new StringBuilder();
	  if(match.type!=null) s.append(match.type).append(' '); 
	  s.append("PROCEDURE ").append(match.identifier);
	  
	  if(virtualSpec!=null) {
		  s.append("[Specified by ").append(virtualSpec.identifier).append(']');
	  }
	  return(s.toString());
	}

}
