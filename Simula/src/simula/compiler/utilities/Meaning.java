/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.utilities;

import simula.compiler.syntaxClass.declaration.ConnectionBlock;
import simula.compiler.syntaxClass.declaration.Declaration;
import simula.compiler.syntaxClass.declaration.DeclarationScope;
import simula.compiler.syntaxClass.declaration.SimpleVariableDeclaration;
import simula.compiler.syntaxClass.expression.Expression;

/**
 * Utility class Meaning.
 * <p>
 * Holding the semantic meaning of an identifier.
 * <p>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/utilities/Meaning.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class Meaning {
	/**
	 * True if it was found behind invisible
	 */
	public final boolean foundBehindInvisible; // Behind hidden/protected
	
	/**
	 * The corresponding declaration
	 */
	public final Declaration declaredAs;
	
	/**
	 * Where it was declared
	 */
	public DeclarationScope declaredIn; // Search started here (modified in ConnectionBlock)
	
	/**
	 * Where it was found
	 */
	public final DeclarationScope foundIn; // Search ended here

	/**
	 * Create a new Meaning.
	 * @param declaredAs the corresponding declaration
	 * @param declaredIn where it was declared
	 * @param foundIn where it was found
	 * @param foundBehindInvisible true if it was found behind invisible
	 */
	public Meaning(final Declaration declaredAs,final DeclarationScope declaredIn,final DeclarationScope foundIn,final boolean foundBehindInvisible) {
		this.declaredAs = declaredAs;
		this.declaredIn = declaredIn;
		this.foundIn = foundIn;
		this.foundBehindInvisible = foundBehindInvisible;
	}

	/**
	 * Create a new Meaning.
	 * @param declaredAs the corresponding declaration
	 * @param declaredIn where it was declared
	 */
	public Meaning(final Declaration declaredAs,final DeclarationScope declaredIn) {
		this(declaredAs, declaredIn,null,false);
	}

	/**
	 * Returns the constant element or null.
	 * @return the constant element or null
	 */
	public Expression getConstant() {
		if(declaredAs instanceof SimpleVariableDeclaration simple) {
			if(simple.isConstant()) return(simple.constantElement);
		}
		return(null);
	}

	/**
	 * Returns true if it was declared in a ConnectionBlock.
	 * @return true if it was declared in a ConnectionBlock
	 */
	public boolean isConnected() {
		return (declaredIn instanceof ConnectionBlock);
	}

	/**
	 * Returns the inspected expression or null.
	 * @return the inspected expression or null
	 */
	public Expression getInspectedExpression() {
		if (isConnected())
			 return (((ConnectionBlock) declaredIn).getInspectedExpression());
		else return (null);
	}

	// ***************************************************************************************
	// *** CODING: edUnqualifiedStaticLink
	// ***************************************************************************************
	/**
	 * Coding utility: Edit unqualified static link chain.
	 * @return the resulting string
	 */
	public String edUnqualifiedStaticLink() {
		// Edit staticLink reference
		String staticLink;
		Expression connectedObject = getInspectedExpression();
		if (connectedObject != null)
			staticLink = connectedObject.toJavaCode();
		else {
			staticLink = declaredIn.edCTX();
		}
		return (staticLink);
	}

	// ***************************************************************************************
	// *** CODING: edQualifiedStaticLink
	// ***************************************************************************************
	/**
	 * Coding utility: Edit qualified static link chain.
	 * @return the resulting string
	 */
	public String edQualifiedStaticLink() {
		// Edit staticLink reference
		String staticLink;
		Expression connectedObject = getInspectedExpression();
		if (connectedObject != null)
			staticLink = connectedObject.toJavaCode();
		else {
			staticLink = declaredIn.edCTX();
			String cast = declaredIn.getJavaIdentifier();
			staticLink = "((" + cast + ")" + staticLink + ')';
		}
		return (staticLink);
	}

	@Override
	public String toString() {
		if (declaredAs == null)	return ("NO MEANING");
		return ("DeclaredAs " + declaredAs + ", foundBehindInvisible=" + foundBehindInvisible
				+ "  (ctBlockLevel="+ declaredIn.ctBlockLevel + ", rtBlockLevel="+ declaredIn.rtBlockLevel
				+ ",declaredIn=" + declaredIn + ",foundIn=" + foundIn + ')');
	}

}
