/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import java.util.Vector;

import simula.compiler.utilities.Util;

/**
 * Declaration List.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/declaration/DeclarationList.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 */
public class DeclarationList extends Vector<Declaration> {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Identifier.
	 */
	public final String identifier;

	DeclarationList(String identifier) {
		this.identifier=identifier;
	}
	
	/**
	 * Find a declaration in this DeclarationList
	 * @param identifier declaration identifier
	 * @return the resulting Declaration
	 */
	public Declaration find(String identifier) {
		for(Declaration d:this)
			if(d.identifier.equals(identifier)) return(d);
		return(null);
	}
	
	@Override
	public boolean add(Declaration dcl) {
		Declaration d=find(dcl.identifier);
		if(d!=null) {
			Util.warning("Multiple declarations with the same name: "+dcl.identifier);
			return(false);			
		}
		super.addElement(dcl);
		return(true);
	}

	/**
	 * Utility print method.
	 * @param title the title
	 */
	public void print(String title) {
		Util.println("DeclarationList: "+identifier+" -- "+title);
		for(Declaration decl:this) Util.println(decl.toString());
	}
}
