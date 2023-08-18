/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import simula.compiler.syntaxClass.declaration.ClassDeclaration;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Util;

/**
 * Hidden Specification.
 * <pre>
 * Syntax: 
 *     protection-specification
 *         = hidden identifier-list
 *         | protected identifier-list
 *         | hidden protected identifier-list
 *         | protected hidden identifier-list
 * </pre>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/declaration/HiddenSpecification.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class HiddenSpecification extends SyntaxClass implements Externalizable {

	/**
	 * The hidden identifier.
	 */
	public String identifier;

	/**
	 * The class in which this HiddenSpecification occur.
	 */
	ClassDeclaration definedIn;
	
	/**
	 * The ProtectedSpecification set during doChecking
	 */
	private ProtectedSpecification protectedBy; // Set during doChecking

	/**
	 * Returns the ProtectedSpecification which protect this hidden.
	 * @return the ProtectedSpecification which protect this hidden.
	 */
	private ProtectedSpecification getProtectedBy() {
		if (protectedBy == null)
			doChecking();
		return (protectedBy);
	}

	/**
	 * Create a new HiddenSpecification.
	 * 
	 * @param definedIn  the class where Hidden is specified
	 * @param identifier the hidden identifier
	 */
	public HiddenSpecification(final ClassDeclaration definedIn, final String identifier) {
		this.definedIn = definedIn;
		this.identifier = identifier;
	}

	// ***********************************************************************************************
	// *** Utility: doChecking -- Called from ClassDeclaration.checkHiddenList
	// ***********************************************************************************************
	/**
	 * Perform semantic checking.
	 * <p>
	 * Called from ClassDeclaration.checkHiddenList.
	 */
	public void doChecking() {
		protectedBy = getMatchingProtected();
		if (protectedBy != null)
			protectedBy.hiddenBy = this;
	}

	// ***********************************************************************************************
	// *** Utility: getMatchingProtected -- Find protected attribute and update pointers
	// ***********************************************************************************************
	/**
	 * Find protected attribute and update pointers.
	 * @return the resulting ProtectedSpecification
	 */
	private ProtectedSpecification getMatchingProtected() {
		ClassDeclaration scope = this.definedIn;
		ProtectedSpecification gotProtected = scope.searchProtectedList(identifier);
		if (gotProtected != null) {
			return (gotProtected);
		}
		scope = scope.getPrefixClass();
		SEARCH: while (scope != null) {
			HiddenSpecification gotHidden = findHidden(scope, identifier);
			if (gotHidden != null) {
				scope = gotHidden.getScopeBehindHidden();
				continue SEARCH;
			}
			gotProtected = scope.searchProtectedList(identifier);
			if (gotProtected != null) {
				return (gotProtected);
			}
			scope = scope.getPrefixClass();
		}
		Util.error(identifier + " is specified HIDDEN without being PROTECTED");
		return (null);
	}

	// ***********************************************************************************************
	// *** Utility: getScopeBehindHidden -- Search backwards from 'hidden' ...
	// ***********************************************************************************************
	/**
	 * Utility: Get scope behind hidden.
	 * 
	 * @return the ClassDeclaration found
	 */
	public ClassDeclaration getScopeBehindHidden() {
		ProtectedSpecification protectedBy = getProtectedBy();
		ClassDeclaration definedIn = protectedBy.definedIn;
		return (definedIn.getPrefixClass());
	}

	// ***********************************************************************************************
	// *** Utility: findHidden -- Search hidden-list for 'ident'
	// ***********************************************************************************************
	/**
	 * Search scope's hidden-list for 'ident'
	 * @param scope the given scope
	 * @param ident the given ident
	 * @return the resulting HiddenSpecification
	 */
	private static HiddenSpecification findHidden(final ClassDeclaration scope, final String ident) {
		for (HiddenSpecification hdn : scope.hiddenList)
			if (Util.equals(ident, hdn.identifier))
				return (hdn);
		return (null);
	}

	public void printTree(int indent) {
		System.out.println(SyntaxClass.edIndent(indent)+this.getClass().getSimpleName()+"    "+this);
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("Hidden ").append(identifier);
		s.append("[Defined in ");
		s.append((definedIn != null) ? definedIn.identifier : "UNKNOWN");
		if (protectedBy != null) {
			// public ProtectedSpecification protectedBy; // Set during doChecking
			s.append(", Protected by ").append(protectedBy.identifier);
			s.append("[defined in ");
			s.append((protectedBy.definedIn != null) ? protectedBy.definedIn.identifier : "MISSING");
			s.append("]");
		}
		s.append("]");
		return (s.toString());
	}

	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	/**
	 * Default constructor used by Externalization.
	 */
	public HiddenSpecification() {
	}

	@Override
	public void writeExternal(ObjectOutput oupt) throws IOException {
		Util.TRACE_OUTPUT("ProtectedSpecification: " + identifier);
		oupt.writeObject(identifier);
	}

	@Override
	public void readExternal(ObjectInput inpt) throws IOException, ClassNotFoundException {
		identifier = (String) inpt.readObject();
		this.definedIn = (ClassDeclaration) Global.getCurrentScope();
		Util.TRACE_INPUT("ProtectedSpecification: " + identifier);
	}


}
