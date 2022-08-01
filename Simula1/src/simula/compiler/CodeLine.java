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
	public int sourceLineNumber;
	public String codeLine;
	
	public CodeLine(final int sourceLineNumber,final String codeLine) {
		this.sourceLineNumber=sourceLineNumber;
		this.codeLine=codeLine;
	}

	@Override
	public String toString() {
		return("CodeLine["+sourceLineNumber+','+codeLine+']');
	}

	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	public CodeLine() { }
	
	@Override
	public void writeExternal(ObjectOutput oupt) throws IOException {
		Util.TRACE_OUTPUT("CodeLine: "+sourceLineNumber+' '+codeLine);
	    oupt.writeInt(sourceLineNumber);
	    oupt.writeObject(codeLine);
	}
	@Override
	public void readExternal(ObjectInput inpt) throws IOException, ClassNotFoundException {
		sourceLineNumber=inpt.readInt();
		codeLine=(String)inpt.readObject();
		Util.TRACE_INPUT("CodeLine: "+sourceLineNumber+' '+codeLine);
	}
}
