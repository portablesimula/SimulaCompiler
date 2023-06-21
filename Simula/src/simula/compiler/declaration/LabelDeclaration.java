/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import java.io.Externalizable;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Type;

/**
 * 
 * @author Øystein Myhre Andersen
 */
public final class LabelDeclaration extends SimpleVariableDeclaration implements Externalizable {
    public int index; // set by BlockDeclaration.doCheckLabelList
    
	public LabelDeclaration(final String identifier) {
		super(Type.Label,identifier);
	    this.externalIdent="_LABEL"+identifier;
		this.declarationKind=Declaration.Kind.LabelDeclaration;
	}

	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		DeclarationScope declaredIn=Global.getCurrentScope();
		type.doChecking(declaredIn);
		VirtualSpecification virtSpec=VirtualSpecification.getVirtualSpecification(this);
		if(virtSpec==null) {
			// Label attributes are implicit specified 'protected'
			if(declaredIn.declarationKind==Declaration.Kind.Class)
				((ClassDeclaration)declaredIn).protectedList.add(new ProtectedSpecification((ClassDeclaration)declaredIn,identifier));
		} else {
			// This Label is a Virtual Match
			ClassDeclaration decl=(ClassDeclaration)declaredIn;
			if(decl==virtSpec.declaredIn) virtSpec.hasDefaultMatch=true;
		}
		SET_SEMANTICS_CHECKED();
	}

	@Override
	public void doJavaCoding() {
		Global.sourceLineNumber=lineNumber;
		String ident=getJavaIdentifier();
		VirtualSpecification virtSpec=VirtualSpecification.getVirtualSpecification(this);
		if(virtSpec!=null)
			 GeneratedJavaClass.code("public _LABQNT "+virtSpec.getVirtualIdentifier()
			                     +" { return(new _LABQNT(this,"+index+",\""+identifier+"\")); }"," // Virtual Label #"+index+'='+identifier);
		else GeneratedJavaClass.code("final _LABQNT "+ident+"=new _LABQNT(this,"+index+",\""+identifier+"\");","Local Label #"+index+'='+identifier);
	}

	@Override
	public String toString() {
		return ("LABEL "+identifier+", index="+index);
	}

	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	public LabelDeclaration() { }

}
