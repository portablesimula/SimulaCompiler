/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import simula.compiler.syntaxClass.declaration.ClassDeclaration;
import simula.compiler.utilities.Token;

/**
 * Utility class OverLoad.
 * <p>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/utilities/OverLoad.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class OverLoad extends Type {
	
	/**
	 * The overloaded types.
	 */
	private Type[] type;
	
	/**
	 * Create a new OverLoad type list.
	 * @param type the types
	 */
	public OverLoad(final Type... type)
	{  super("OverLoad");
	   this.type=type;
	}
	
	@Override
	public String toString()
	{ StringBuilder s=new StringBuilder();
	  s.append("OverLoad(");
	  boolean first=true;
	  if(type!=null)
		  for(Type t:type) { if(!first) s.append(','); first=false; s.append(t); }
	  s.append(')');
	  return(s.toString());
	}


	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	/**
	 * Default constructor used by Externalization.
	 */
	public OverLoad() {} // Externalization


	@Override
	public void writeExternal(ObjectOutput oupt) throws IOException {
		oupt.writeObject(key);
		oupt.writeObject(qual);
		oupt.writeObject(type);
	}

	@Override
	public void readExternal(ObjectInput inpt) throws IOException, ClassNotFoundException {
		key=(Token)inpt.readObject();
		qual=(ClassDeclaration) inpt.readObject();
		type=(Type[])inpt.readObject();
	}

}
