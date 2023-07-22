/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.parsing;

import java.io.Reader;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Token;
import simula.compiler.utilities.Util;

/**
 * The Simula Parser Utilities.
 * <p>
 * It contains all static utilities for parsing Simula Syntax.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/parsing/Parse.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class Parse {
	private static Token savedToken; // Used by 'pushBack'
	private static boolean endOfFileErrorGiven;
	private static SimulaScanner simulaScanner;
	
	/**
	 * The previous Token.
	 */
	public static Token prevToken;
	
	/**
	 * The current Token.
	 */
	public static Token currentToken;
	
	/**
	 * Default constructor.
	 */
	Parse(){}

	// *********************************************************************************
	// *** Initiate
	// *********************************************************************************
	/**
	 * Initiate Parsing utilities.
	 * @param reader the source file reader.
	 */
	public static void initiate(final Reader reader) {
		simulaScanner = new SimulaScanner(reader,false);
		prevToken = null;
		currentToken = null;
		savedToken = null; // Used by 'pushBack'
		endOfFileErrorGiven=false;

		nextSymb();
	}

	// *********************************************************************************
	// *** Close
	// *********************************************************************************
	/**
	 * Close the Simula scanner.
	 */
	public static void close() {
		simulaScanner.close();
		simulaScanner = null;
	}

	// *********************************************************************************
	// *** Parser Utilities
	// *********************************************************************************
	/**
	 * Save current Token
	 */
	public static void saveCurrentToken() {
		if (savedToken != null) Util.IERR("saveCurrentToken: Already called");
		savedToken = Parse.currentToken;
		Parse.currentToken = Parse.prevToken;
		Parse.prevToken = null;
	}

	/**
	 * Test to accept the given KeyWord.
	 * <p>
	 * If it is accepted 'nextSymb' is called.
	 * @param key t the given KeyWord
	 * @return true if the keyword is accepted, false otherwise.
	 */
	public static boolean accept(final KeyWord key) {
		if (Parse.currentToken.getKeyWord() == key) {
			nextSymb();
			return (true);
		}
		return (false);
	}

	/**
	 * Skip misplaced current symbol.
	 */
	public static void skipMisplacedCurrentSymbol() {
		Util.error("Misplaced symbol: "+Parse.currentToken+" -- Ignored");
		nextSymb();
	}

	/**
	 * Test to accept any of the given KeyWords.
	 * <p>
	 * If it is accepted 'nextSymb' is called.
	 * @param key1 a KeyWord
	 * @param key2 a KeyWord
	 * @return true if any of the keywords are accepted, false otherwise.
	 */
	public static boolean accept(final KeyWord key1,final KeyWord key2) {
		return(accept(key1) || accept(key2));
	}

	/**
	 * Test to accept any of the given KeyWords.
	 * <p>
	 * If it is accepted 'nextSymb' is called.
	 * @param key1 a KeyWord
	 * @param key2 a KeyWord
	 * @param key3 a KeyWord
	 * @return true if any of the keywords are accepted, false otherwise.
	 */
	public static boolean accept(final KeyWord key1,final KeyWord key2,final KeyWord key3) {
		return(accept(key1) || accept(key2) || accept(key3));
	}
	
	/**
	 * Test to accept a postfix operator ( DOT, IS, IN, QUA).
	 * @return true if the keyword is accepted, false otherwise.
	 */
	public static boolean acceptPostfixOprator() {
		//   DOT | IS | IN | QUA
		if(accept(KeyWord.DOT)) return(true);
		if(accept(KeyWord.IS)) return(true);
		if(accept(KeyWord.IN)) return(true);
		if(accept(KeyWord.QUA)) return(true);
		return(false);
	}
	
	/**
	 * Test to accept a relational operator.
	 * <pre>
		 value-relational-operator
		     =  &lt;  |  &lt;=  |  =  |  >=  |  >  |  &lt;> | == | =/=
	 * </pre>
	 * @return true if the keyword is accepted, false otherwise.
	 */
	public static boolean acceptRelationalOperator() {
		if(accept(KeyWord.LT)) return(true);
		if(accept(KeyWord.LE)) return(true);
		if(accept(KeyWord.EQ)) return(true);
		if(accept(KeyWord.GE)) return(true);
		if(accept(KeyWord.GT)) return(true);
		if(accept(KeyWord.NE)) return(true);
		if(accept(KeyWord.NER)) return(true);
		if(accept(KeyWord.EQR)) return(true);
		return(false);
	}


	/**
	 * Expect the given KeyWord.
	 * <p>
	 * If it is not accepted an error message is given.
	 * @param key a keyword
	 * @return true if the keyword was accepted, otherwise false
	 */
	public static boolean expect(final KeyWord key) {
		if (accept(key)) return (true);
		Util.error("Got symbol '" + Parse.currentToken + "' while expecting KeyWord " + key.toLowerCase());
		return (false);
	}
	
	/**
	 * Utility TRACE.
	 * @param msg a message
	 */
	public static void TRACE(final String msg) {
		Util.TRACE(msg + ", current=" + Parse.currentToken + ", prev=" + Parse.prevToken);
	}
	
	/**
	 * Advance to next symbol.
	 */
	public static void nextSymb() {
		Parse.prevToken = Parse.currentToken;
		if (savedToken == null) {
			Parse.currentToken = simulaScanner.nextToken();
			if (Parse.currentToken == null) {
				if (!endOfFileErrorGiven) {
					//Util.warning("Possible scanning past END-OF-FILE");
				}
				endOfFileErrorGiven = true;
				Parse.currentToken = new Token(KeyWord.END);
			}
		} else {
			Parse.currentToken = savedToken;
			savedToken = null;
		}
		if(Parse.currentToken.getKeyWord()==KeyWord.IDENTIFIER)
			if(Parse.prevToken!=null && Parse.prevToken.getKeyWord()==KeyWord.IDENTIFIER) {
				Util.error("Misplaced identifier "+Parse.currentToken+" directly after the identifier "+Parse.prevToken+" - Ignored");
		        nextSymb();
			}
	}
	

}
