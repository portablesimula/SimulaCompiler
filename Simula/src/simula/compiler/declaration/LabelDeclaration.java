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
    public Virtual myVirtual; // Set during doChecking
    public int index; // set by BlockDeclaration.doChecking
    public int prefixLevel; // set by BlockDeclaration.doChecking
    
	public LabelDeclaration(String identifier) {
		super(Type.Label,identifier);
	}

	public void doChecking() {
		//Util.BREAK("TypeDeclaration.doChecking("+this+")");
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		DeclarationScope declaredIn=Global.currentScope;
		type.doChecking(declaredIn);
		// Label attributes are implicit specified 'protected'
		if(declaredIn.blockKind==BlockDeclaration.Kind.Class)
			declaredIn.protectedList.add(identifier);
		SET_SEMANTICS_CHECKED();
	}

	public void doJavaCoding(int indent) {
		Global.sourceLineNumber=lineNumber;
		String ident=getJavaIdentifier();
		if(myVirtual==null)
		   Util.code(indent,"final $LABQNT "+ident+"=new $LABQNT(this,"+prefixLevel+','+index+"); // Local Label #"+index+'='+ident);
	}

}
