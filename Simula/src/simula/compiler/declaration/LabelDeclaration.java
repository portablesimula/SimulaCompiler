/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

public class LabelDeclaration extends TypeDeclaration {
    public int index; // set by BlockDeclaration.doChecking
    
	public LabelDeclaration(String identifier) {
		super(Type.Label,identifier);
	}

	public void doChecking() {
		//Util.BREAK("TypeDeclaration.doChecking("+this+")");
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		type.doChecking(Global.currentScope);
//		if(constantElement!=null)
//		{ constantElement.doChecking();
//	      constantElement=TypeConversion.testAndCreate(type,constantElement);
//		}
		SET_SEMANTICS_CHECKED();
	}

	public void doJavaCoding(int indent) {
		Global.sourceLineNumber=lineNumber;
		String ident=getJavaIdentifier();
		Util.code(indent,"final $LABQNT "+ident+"=new $LABQNT(this,"+index+"); // Local Label #"+index+'='+ident);
	}

}
