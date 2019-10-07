/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.utilities;

import simula.compiler.declaration.ConnectionBlock;
import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.DeclarationScope;
import simula.compiler.editor.RTOption;
import simula.compiler.expression.Expression;

/**
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class Meaning {
	public final boolean foundBehindInvisible; // Behind hidden/protected
	public final Declaration declaredAs;
	public DeclarationScope declaredIn; // Search started here (modified in ConnectionBlock)
	public final DeclarationScope foundIn; // Search ended here

	public Meaning(final Declaration declaredAs,final DeclarationScope declaredIn,final DeclarationScope foundIn,final boolean foundBehindInvisible) {
		this.declaredAs = declaredAs;
		this.declaredIn = declaredIn;
		this.foundIn = foundIn;
		this.foundBehindInvisible = foundBehindInvisible;
	}

	public Meaning(final Declaration declaredAs,final DeclarationScope declaredIn) {
		this(declaredAs, declaredIn,null,false);
	}

	public boolean isConnected() {
		return (declaredIn instanceof ConnectionBlock);
	}

	public Expression getInspectedVariable() {
		if (isConnected())
			 return (((ConnectionBlock) declaredIn).getInspectedVariable());
		else return (null);
	}

	public boolean isNO_MEANING() {
		return (declaredAs == null);
	}

	// ***************************************************************************************
	// *** CODING: edUnqualifiedStaticLink
	// ***************************************************************************************
	public String edUnqualifiedStaticLink() {
		// Edit staticLink reference
		String staticLink;
		Expression connectedObject = getInspectedVariable();
		if (connectedObject != null)
			staticLink = connectedObject.toJavaCode();
		else {
			staticLink = declaredIn.edCTX();
			if (RTOption.DEBUGGING)	{
				String cast = declaredIn.getJavaIdentifier();
				staticLink = "((" + cast + ")" + staticLink + ')';
			}
		}
		return (staticLink);
	}

	// ***************************************************************************************
	// *** CODING: edQualifiedStaticLink
	// ***************************************************************************************
	public String edQualifiedStaticLink() {
		// Edit staticLink reference
		String staticLink;
		Expression connectedObject = getInspectedVariable();
		if (connectedObject != null)
			staticLink = connectedObject.toJavaCode();
		else {
			staticLink = declaredIn.edCTX();
			String cast = declaredIn.getJavaIdentifier();
			staticLink = "((" + cast + ")" + staticLink + ')';
		}
		return (staticLink);
	}

	public String toString() {
		if (declaredAs == null)	return ("NO MEANING");
		return ("DeclaredAs " + declaredAs + ", foundBehindInvisible=" + foundBehindInvisible + "  (blockLevel="
				+ declaredIn.blockLevel + ",declaredIn=" + declaredIn + ",foundIn=" + foundIn + ')');
	}

}
