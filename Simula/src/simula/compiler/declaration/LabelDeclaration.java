/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

public class LabelDeclaration extends TypeDeclaration {
    public int index; // set by doChecking
    
	public LabelDeclaration(String identifier) {
		super(Type.Label,identifier);
	}

	public void doJavaCoding(String indent) {
		Util.setLine(lineNumber);
		String ident=getJavaIdentifier();
		Util.code(indent+"LABEL "+ident+"=null; // Local Label #"+index);
	}

}
