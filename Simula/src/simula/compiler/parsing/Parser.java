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
 * All static utilities for parsing Simula Syntax
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class Parser {
	public static Token prevToken;
	public static Token currentToken;
	private static Token savedToken; // Used by 'pushBack'
	private static boolean endOfFileErrorGiven;
	private static SimulaScanner simulaScanner;

	// *********************************************************************************
	// *** Open
	// *********************************************************************************
	public static void open(final Reader reader) {
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
	public static void close() {
		simulaScanner.close();
		simulaScanner = null;
	}

	// *********************************************************************************
	// *** Parser Utilities
	// *********************************************************************************
	public static void saveCurrentToken() {
		if (savedToken != null) Util.FATAL_ERROR("saveCurrentToken: Already called");
		savedToken = Parser.currentToken;
		Parser.currentToken = Parser.prevToken;
		Parser.prevToken = null;
	}

	public static boolean accept(final KeyWord s) {
		if (Parser.currentToken.getKeyWord() == s) {
			nextSymb();
			return (true);
		}
		return (false);
	}

	public static boolean skipMissplacedSymbol(final KeyWord s) {
		if (Parser.accept(s)) {
			Util.error("Misplaced symbol: "+s+" -- Ignored");
			return (true);
		}
		return (false);
	}

	public static void skipMissplacedCurrentSymbol() {
		Util.error("Misplaced symbol: "+Parser.currentToken+" -- Ignored");
		nextSymb();
	}
	
	public static KeyWord lastKeyWord()
	{ return(Parser.prevToken.getKeyWord()); }

	public static boolean accept(final KeyWord s1,final KeyWord s2) {
		return(accept(s1) || accept(s2));
	}

	public static boolean accept(final KeyWord s1,final KeyWord s2,final KeyWord s3) {
		return(accept(s1) || accept(s2) || accept(s3));
	}
	
	public static boolean acceptPostfixOprator()
	{ //   DOT | IS | IN | QUA
	  if(accept(KeyWord.DOT)) return(true);
	  if(accept(KeyWord.IS)) return(true);
	  if(accept(KeyWord.IN)) return(true);
	  if(accept(KeyWord.QUA)) return(true);
	  return(false);
	}
	
	public static boolean acceptRelationalOperator()
	{ // value-relational-operator
	  //     =  <  |  <=  |  =  |  >=  |  >  |  <> | == | =/=
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
	

	public static boolean expect(final KeyWord s) {
		if (accept(s)) return (true);
		Util.error("Got symbol '" + Parser.currentToken + "' while expecting Symbol " + s);
		return (false);
	}
	
	public static void TRACE(final String msg) {
		Util.TRACE(msg + ", current=" + Parser.currentToken + ", prev=" + Parser.prevToken);
	}

	public static void BREAK(final String msg) {
		Util.BREAK(msg + ", current=" + Parser.currentToken + ", prev=" + Parser.prevToken);
	}
	
	public static void nextSymb() {
		Parser.prevToken = Parser.currentToken;
		if (savedToken == null) {
			Parser.currentToken = simulaScanner.nextToken();
			if (Parser.currentToken == null) {
				if (!endOfFileErrorGiven) {
					//Util.warning("Possible scanning past END-OF-FILE");
				}
				endOfFileErrorGiven = true;
				Parser.currentToken = new Token(KeyWord.END);
			}
		} else {
			Parser.currentToken = savedToken;
			savedToken = null;
		}
		if(Parser.currentToken.getKeyWord()==KeyWord.IDENTIFIER)
			if(Parser.prevToken!=null && Parser.prevToken.getKeyWord()==KeyWord.IDENTIFIER) {
				Util.error("Misplaced identifier "+Parser.currentToken+" directly after "+Parser.prevToken+" - Ignored");
		        nextSymb();
			}
	}
	

}
