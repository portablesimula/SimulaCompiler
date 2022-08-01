/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.parsing;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;

import simula.compiler.utilities.Token;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * A Default Scanner
 * 
 * @author Øystein Myhre Andersen
 *
 */
public class DefaultScanner { 
    private LineNumberReader lineNumberReader;

    //********************************************************************************
    //*** CONSTRUCTORS: Scanner
    //********************************************************************************
	public DefaultScanner() {}
	/**
	 * Constructs a new Default Scanner that produces Tokens scanned from the specified
	 * source.
	 * 
	 * @param reader The character source to scan
	 */
	public DefaultScanner(final Reader reader) {
		this.lineNumberReader=new LineNumberReader(reader);
	}


    //********************************************************************************
    //**	                                                                 nextToken 
    //********************************************************************************
	public Token nextToken() {
    	String line=null;
		try { line = lineNumberReader.readLine(); } catch (IOException e) {}
		if(line==null) {
        	if(Option.TRACE_SCAN) Util.BREAK("GOT END-OF-FILE");
        	return(null);
		}
		return(new Token(line+'\n',KeyWord.NEWLINE,lineNumberReader.getLineNumber()));
//		return(new Token(line+'\n',KeyWord.IDENTIFIER,lineNumberReader.getLineNumber()));
	}

}
