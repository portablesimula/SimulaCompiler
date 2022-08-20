/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.parsing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Stack;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.Util;

//*************************************************************************************
//**                                                            CLASS SourceFileReader
//*************************************************************************************

/**
* Input Utilities for the Simula Scanner.
* 
* @author Øystein Myhre Andersen
*
*/
public final class SourceFileReader {
	private final Stack<Reader> stack=new Stack<Reader>();
	private Reader current; // current source file reader;
	private final Stack<String> nameStack=new Stack<String>();
	private final Stack<Integer> lineStack=new Stack<Integer>();
	
	public SourceFileReader(final Reader reader) {
		current=reader;
	}
	
	public int read() {
		int c= -1;
		try { c = current.read();
			  while (c == -1) {
				  close();
				  if (stack.isEmpty()) return (-1);
				  forceEOF();
				  c = current.read();
			  }
		} catch (IOException e) {}
		return (c);
	}
	
	public void insert(final File file) {
		lineStack.push(Global.sourceLineNumber); Global.sourceLineNumber=1;
	    try {
			Reader reader=new InputStreamReader(new FileInputStream(file),Global._CHARSET);
			nameStack.push(Global.insertName);
			Global.insertName=file.getName();
			stack.push(current); current=reader;
	    } catch(IOException e) { Util.INTERNAL_ERROR("Impossible",e); }
	}
	
	public void forceEOF() {
		Global.insertName=nameStack.pop();
		Global.sourceLineNumber=lineStack.pop();
		current = stack.pop();
	}
	    
	public void close() {
		try { current.close(); } catch (IOException e) {}
	}

}
