/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.utilities;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import simula.compiler.declaration.ClassDeclaration;

public final class OverLoad extends Type {
	private Type[] type;
	
	public OverLoad(final Type... type)
	{  super("OverLoad");
	   this.type=type;
	}
	
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
	public OverLoad() {} // Externalization


	@Override
	public void writeExternal(ObjectOutput oupt) throws IOException {
		oupt.writeObject(key);
		if(NYTT_OPPLEGG) Util.IERR("");
		else oupt.writeObject(qual);
		oupt.writeObject(type);
	}

	@Override
	public void readExternal(ObjectInput inpt) throws IOException, ClassNotFoundException {
		key=(Token)inpt.readObject();
		if(NYTT_OPPLEGG) Util.IERR("");
		else qual=(ClassDeclaration) inpt.readObject();
		type=(Type[])inpt.readObject();
	}

}
