/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass.declaration;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.syntaxClass.SyntaxClass;
import simula.compiler.utilities.Util;

/**
 * Virtual match.
 * <p>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/declaration/VirtualMatch.java">
 * <b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class VirtualMatch extends Declaration implements Externalizable {
	
	/**
	 * The matching ProcedureDeclaration. Set during doChecking.
	 */
	private ProcedureDeclaration match; // Set during doChecking

	/**
	 * The virtual specification. Set during doChecking.
	 */
	public VirtualSpecification virtualSpec; // Set during doChecking

	/**
	 * Create a new VirtualSpecification.
	 * @param virtualSpec the virtual specification
	 * @param match a matching ProcedureDeclaration
	 */
	VirtualMatch(final VirtualSpecification virtualSpec, final ProcedureDeclaration match) {
		super(virtualSpec.identifier);
		this.declarationKind = Declaration.Kind.VirtualMatch;
		// NOTE: Called during Checking
		this.virtualSpec = virtualSpec;
		this.match = match;
	}

	@Override
	public void doJavaCoding() {
		String matchCode = "{ throw new RTS_SimulaRuntimeError(\"No Virtual Match: " + identifier + "\"); }";
		if (match != null)
			matchCode = "{ return(new RTS_PRCQNT(this," + match.getJavaIdentifier() + ".class)); }";
		GeneratedJavaClass.code("public RTS_PRCQNT " + virtualSpec.getVirtualIdentifier() + " " + matchCode);
	}

	public void printTree(int indent) {
		System.out.println(SyntaxClass.edIndent(indent)+this.getClass().getSimpleName()+"    "+this);
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (match.type != null)
			s.append(match.type).append(' ');
		s.append("PROCEDURE ").append(match.identifier);
		if (virtualSpec != null)
			s.append("[Specified by ").append(virtualSpec.identifier).append(']');
		return (s.toString());
	}

	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	/**
	 * Default constructor used by Externalization.
	 */
	public VirtualMatch() {
		super(null);
		this.declarationKind = Declaration.Kind.VirtualMatch;
	}

	@Override
	public void writeExternal(ObjectOutput oupt) throws IOException {
		Util.TRACE_OUTPUT("VirtualMatch: " + identifier);
		oupt.writeObject(identifier);
		oupt.writeObject(externalIdent);
	}

	@Override
	public void readExternal(ObjectInput inpt) throws IOException, ClassNotFoundException {
		identifier = (String) inpt.readObject();
		externalIdent = (String) inpt.readObject();
		Util.TRACE_INPUT("VirtualMatch: " + identifier);
		match = ((ClassDeclaration) this.declaredIn).findLocalProcedure(identifier);
		if (match != null) {
			virtualSpec = VirtualSpecification.getVirtualSpecification(match); // AdHoc
		} else
			Util.error("Malformed Attribute File (at VirtualMatch " + identifier + ")");
	}

}
