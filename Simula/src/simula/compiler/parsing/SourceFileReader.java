/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.parsing;

import java.io.IOException;
import java.io.Reader;
import java.util.Stack;

//*************************************************************************************
//**                                                             CLASS SourceFileReader
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
	
	public SourceFileReader(final Reader reader) {
		current=reader;
	}
	
	public int read() {
		int c= -1;
		try { c = current.read();
			  while (c == -1) {
				  close();
				  if (stack.isEmpty()) return (-1);
				  current = stack.pop();
				  c = current.read();
			  }
		} catch (IOException e) {}
		return (c);
	}
	
	public void insert(final Reader reader) {
		stack.push(current); current=reader;
	}
	    
	public void close() {
		try { current.close(); } catch (IOException e) {}
	}

}
