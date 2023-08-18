/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass.declaration;

import java.io.Externalizable;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.syntaxClass.ProtectedSpecification;
import simula.compiler.syntaxClass.Type;
import simula.compiler.utilities.Global;

/**
 * Label Declaration.
 * <p>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/declaration/LabelDeclaration.java">
 * <b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 */
public final class LabelDeclaration extends SimpleVariableDeclaration implements Externalizable {
	/**
	 * The label index. Set by BlockDeclaration.doCheckLabelList.
	 */
	public int index;

	/**
	 * Create a new Label Declaration.
	 * 
	 * @param identifier label identifier
	 */
	public LabelDeclaration(final String identifier) {
		super(Type.Label, identifier);
		this.externalIdent = "_LABEL_" + identifier;
		this.declarationKind = Declaration.Kind.LabelDeclaration;
	}

	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())
			return;
		Global.sourceLineNumber = lineNumber;
		DeclarationScope declaredIn = Global.getCurrentScope();
		type.doChecking(declaredIn);
		VirtualSpecification virtSpec = VirtualSpecification.getVirtualSpecification(this);
		if (virtSpec == null) {
			// Label attributes are implicit specified 'protected'
			if (declaredIn.declarationKind == Declaration.Kind.Class)
				((ClassDeclaration) declaredIn).protectedList
						.add(new ProtectedSpecification((ClassDeclaration) declaredIn, identifier));
		} else {
			// This Label is a Virtual Match
			ClassDeclaration decl = (ClassDeclaration) declaredIn;
			if (decl == virtSpec.declaredIn)
				virtSpec.hasDefaultMatch = true;
		}
		SET_SEMANTICS_CHECKED();
	}

	@Override
	public void doJavaCoding() {
		Global.sourceLineNumber = lineNumber;
		String ident = getJavaIdentifier();
		VirtualSpecification virtSpec = VirtualSpecification.getVirtualSpecification(this);
		if (virtSpec != null)
			GeneratedJavaClass.code("public RTS_LABEL " + virtSpec.getVirtualIdentifier()
					+ " { return(new RTS_LABEL(this," + index + ",\"" + identifier + "\")); }",
					" // Virtual Label #" + index + '=' + identifier);
		else
			GeneratedJavaClass.code(
					"final RTS_LABEL " + ident + "=new RTS_LABEL(this," + index + ",\"" + identifier + "\");",
					"Local Label #" + index + '=' + identifier);
	}

	@Override
	public String toString() {
		return ("LABEL " + identifier + ", index=" + index);
	}

	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	/**
	 * Default constructor used by Externalization.
	 */
	public LabelDeclaration() {
	}

}
