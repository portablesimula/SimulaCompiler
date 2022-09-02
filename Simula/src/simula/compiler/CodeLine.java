/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import simula.compiler.utilities.Util;

/**
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class CodeLine implements Externalizable {
	public String modid;
	public int sourceLineNumber;
	public String codeLine;
	
	public CodeLine(final String modid,final int sourceLineNumber,final String codeLine) {
		this.modid=modid;
		this.sourceLineNumber=sourceLineNumber;
		this.codeLine=codeLine;
	}

	@Override
	public String toString() {
		return("CodeLine["+modid+':'+sourceLineNumber+','+codeLine+']');
	}

	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	public CodeLine() { }
	
	@Override
	public void writeExternal(ObjectOutput oupt) throws IOException {
		Util.TRACE_OUTPUT(""+this);
	    oupt.writeInt(sourceLineNumber);
	    oupt.writeObject(codeLine);
	    oupt.writeObject(modid);
	}
	@Override
	public void readExternal(ObjectInput inpt) throws IOException, ClassNotFoundException {
		sourceLineNumber=inpt.readInt();
		codeLine=(String)inpt.readObject();
		modid=(String)inpt.readObject();
		Util.TRACE_INPUT(""+this);
	}
}
