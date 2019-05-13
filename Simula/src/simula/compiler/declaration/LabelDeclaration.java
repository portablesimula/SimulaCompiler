/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import java.io.Externalizable;

import simula.compiler.JavaModule;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Type;

public final class LabelDeclaration extends TypeDeclaration implements Externalizable {
    public int index; // set by BlockDeclaration.doCheckLabelList
    
	public LabelDeclaration(final String identifier) {
		super(Type.Label,identifier);
	}

	public void doChecking() {
		//Util.BREAK("LabelDeclaration.doChecking("+this+")");
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		DeclarationScope declaredIn=Global.currentScope;
		type.doChecking(declaredIn);
		VirtualSpecification virtSpec=VirtualSpecification.getVirtualSpecification(this);
		//Util.BREAK("LabelDeclaration.doChecking("+identifier+"): virtSpec="+virtSpec);
		if(virtSpec==null) {
			// Label attributes are implicit specified 'protected'
			if(declaredIn.blockKind==BlockKind.Class)
				((ClassDeclaration)declaredIn).protectedList.add(new ProtectedSpecification((ClassDeclaration)declaredIn,identifier));
		} else {
			// This Label is a Virtual Match
			ClassDeclaration decl=(ClassDeclaration)declaredIn;
//			if(decl==virtSpec.specifiedIn) virtSpec.hasDefaultMatch=true;
			if(decl==virtSpec.declaredIn) virtSpec.hasDefaultMatch=true;
		}
		SET_SEMANTICS_CHECKED();
	}

	public void doJavaCoding() {
		Global.sourceLineNumber=lineNumber;
		String ident=getJavaIdentifier();
//		Util.BREAK("LabelDeclaration.doJavaCoding: externalIdent="+this.externalIdent);
		VirtualSpecification virtSpec=VirtualSpecification.getVirtualSpecification(this);
		if(virtSpec!=null)
			 JavaModule.code("public LABQNT$ "+virtSpec.getVirtualIdentifier()+" { return(new LABQNT$(this,"+index+",\""+ident+"\")); }"," // Virtual Label #"+index+'='+ident);
		else JavaModule.code("final LABQNT$ "+ident+"=new LABQNT$(this,"+index+",\""+ident+"\");","Local Label #"+index+'='+ident);
	}

	public String toString() {
		return ("LABEL "+identifier+", index="+index);
	}

	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	public LabelDeclaration() { }

}
