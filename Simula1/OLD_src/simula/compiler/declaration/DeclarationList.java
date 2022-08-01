package simula.compiler.declaration;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Vector;

import simula.compiler.utilities.Util;

public class DeclarationList extends Vector<Declaration> implements Externalizable {
	
	private static final long serialVersionUID = 1L;
	public String identifier;

	public DeclarationList(String identifier) {
		this.identifier=identifier;
	}
	
	public Declaration find(String identifier) {
		for(Declaration d:this) if(d.identifier.equals(identifier)) {
			return(d);
		} return(null);
	}
	
	public boolean add(Declaration dcl) {
		Declaration d=find(dcl.identifier);
		if(d!=null) {
			Util.warning("Multiple declarations with the same name: "+dcl+" and "+d);
			return(false);			
		}
		super.addElement(dcl);
		return(true);
	}
	
	public boolean addUnique(Declaration dcl) {
		Declaration d=find(dcl.identifier);
		if(d!=null) {
			return(false);			
		}
		super.addElement(dcl);
		return(true);
	}


	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	public DeclarationList() {
//		super(null);
//		this.declarationKind=Declaration.Kind.SimpleVariableDeclaration;
	}

	@Override
	public void writeExternal(ObjectOutput oupt) throws IOException {
		Util.TRACE_OUTPUT("DeclarationList: "+identifier);
	    oupt.writeObject(identifier);
	    oupt.writeObject(this.size());
	    for(Declaration d:this) {
		    oupt.writeObject(d);	    	
	    }
	}

	@Override
	public void readExternal(ObjectInput inpt) throws IOException, ClassNotFoundException {
		identifier=(String)inpt.readObject();
		int n=(int)inpt.readObject();
		for(int i=0;i<n;i++) {
			Declaration d=(Declaration)inpt.readObject();
			this.addUnique(d);
		}
	    Util.TRACE_INPUT("DeclarationList: "+identifier);
	}

}
