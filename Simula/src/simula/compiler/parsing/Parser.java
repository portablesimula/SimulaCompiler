/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.parsing;

import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Token;
import simula.compiler.utilities.Util;

public class Parser {
	static SimulaScanner simulaScanner;

	public static void open(String fileName) {
		simulaScanner = new SimulaScanner(fileName);
		nextSymb();
	}

	// *********************************************************************************
	// *** Parser Utilities
	// *********************************************************************************

	private static Token savedToken = null; // Used by 'pushBack'
	public static Token prevToken = null;
	public static Token currentToken = null;
	private static boolean endOfFileErrorGiven=false;

	private static void nextSymb() {
		Parser.prevToken = Parser.currentToken;
		if (savedToken == null) {
			Parser.currentToken = simulaScanner.nextToken();
			//Util.BREAK("TOKEN:'" + Parser.currentToken + "'");
			if(Parser.currentToken==null)
		    { if(!endOfFileErrorGiven) Util.warning("Scanning past END-OF-FILE -- Adding extra END Symbol");
		      endOfFileErrorGiven=true;
		      Parser.currentToken = new Token(KeyWord.END);
		    }
		} else {
			Parser.currentToken = savedToken;
			savedToken = null;
			// Util.BREAK("SAVED TOKEN:'" + Parser.currentToken + "'");
		}
	}

	public static void saveCurrentToken() {
		if (savedToken != null)
			error("saveCurrentToken: Already called");
		savedToken = Parser.currentToken;
		Parser.currentToken = Parser.prevToken;
		Parser.prevToken = null;
		// Util.BREAK("SAVED TOKEN:'" + savedToken);
	}

	public static void error(String msg) {
		Util.error(msg);
	}

	public static boolean accept(KeyWord s) {
		if (Parser.currentToken.getKeyWord() == s) {
			nextSymb();
			return (true);
		}
		return (false);
	}

//	public static boolean skipKeyWord(KeyWord s) {
//		if (Parser.currentToken.getKeyWord() == s) {
//			Util.error("Missplaced symbol: "+s+" -- Ignored");
//			nextSymb();
//			return (true);
//		}
//		return (false);
//	}
//
//	public static boolean skipAnyKeyWordExcept(KeyWord s) {
//		KeyWord keyWord=Parser.currentToken.getKeyWord();
//		//Util.BREAK("Parser.skipAnyKeyWordExcept("+s+"): keyWord="+keyWord);
////		if (keyWord != null && keyWord != s) {
//		if (keyWord != null) {
//			Util.error("Missplaced symbol: "+keyWord+" -- Ignored");
//			nextSymb();
//			return (true);
//		}
//		return (false);
//	}

	public static void skipCurrentSymbol() {
		Util.error("Missplaced symbol: "+Parser.currentToken+" -- Ignored");
		nextSymb();
	}
	
	public static KeyWord lastKeyWord()
	{ return(Parser.prevToken.getKeyWord()); }

	public static boolean accept(KeyWord s1,KeyWord s2) {
		return(accept(s1) || accept(s2));
	}

	public static boolean accept(KeyWord s1,KeyWord s2,KeyWord s3) {
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
	

	public static boolean expect(KeyWord s) {
		if (accept(s))
			return (true);
		error("Got symbol '" + Parser.currentToken + "' while expecting Symbol " + s);
		return (false);
	}
	
	public static void TRACE(String msg)
	{ Util.TRACE(msg+", current="+Parser.currentToken+", prev="+Parser.prevToken); }
	
	public static void BREAK(String msg)
	{ Util.BREAK(msg+", current="+Parser.currentToken+", prev="+Parser.prevToken); }


}
