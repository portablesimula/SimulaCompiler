/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.parsing;

import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Precedence;
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

	private static int currenLineNumber = 0;
	private static Token savedToken = null; // Used by 'pushBack'
	public static Token prevToken = null;
	public static Token currentToken = null;

	private static void nextSymb() {
		Parser.prevToken = Parser.currentToken;
		if (savedToken == null) {
			while ((Parser.currentToken = simulaScanner.nextToken()) != null) {
				// Util.BREAK("TOKEN:'" + Parser.currentToken + "'");
				if (Parser.currentToken.getKeyWord() != KeyWord.NEWLINE)
					return;
				// Util.BREAK("TOKEN:'" + Parser.currentToken + "' SKIPPED");
				currenLineNumber = (int) Parser.currentToken.getValue();
				Util.setLine(currenLineNumber);
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

	public static int getLineNumber() {
		return (currenLineNumber);
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
	
	public static KeyWord lastKeyWord()
	{ return(Parser.prevToken.getKeyWord()); }

	public static boolean accept(KeyWord s1,KeyWord s2) {
		return(accept(s1) || accept(s2));
	}

	public static boolean accept(KeyWord s1,KeyWord s2,KeyWord s3) {
		return(accept(s1) || accept(s2) || accept(s3));
	}
	
	public static boolean acceptValueRelationalOperator()
	{ // value-relational-operator
	  //     =  <  |  <=  |  =  |  >=  |  >  |  <>
	  if(accept(KeyWord.LT)) return(true);
	  if(accept(KeyWord.LE)) return(true);
	  if(accept(KeyWord.EQ)) return(true);
	  if(accept(KeyWord.GE)) return(true);
	  if(accept(KeyWord.GT)) return(true);
	  if(accept(KeyWord.NE)) return(true);
	  return(false);
	}

	public static boolean acceptBinaryOperator(int level) {
		// TRACE("SimulaParser.acceptBinaryOperator(" + level + ")");
		Object val = Parser.currentToken.getValue();
		if (val != null && val instanceof Precedence) {
			int operatorLevel = ((Precedence) val).getValue();
			if (operatorLevel == level) {
				nextSymb();
				// TRACE("acceptOperator("+Parser.currentToken+','+level+") SUCCESS");
				return (true);
			}
		}
		// TRACE("acceptOperator("+Parser.currentToken+','+level+") FAILED");
		return (false);
	}

	public static boolean acceptOperatorLevel(int level) {
		// TRACE("SimulaParser.acceptBinaryOperator(" + level + ")");
		Object val = Parser.currentToken.getValue();
		if (val != null && val instanceof Precedence) {
			int operatorLevel = ((Precedence) val).getValue();
			if (operatorLevel == level) {
				nextSymb();
				//TRACE("acceptOperator("+Parser.currentToken+','+level+") SUCCESS");
				return (true);
			}
		}
		//TRACE("acceptOperator("+Parser.currentToken+','+level+") FAILED");
		return (false);
	}

	public static boolean acceptUnaryOperator(int level) {
		//TRACE("SimulaParser.acceptUnaryOperator(" + level + ")");
		Object val = Parser.currentToken.getValue();
		if (val != null && val instanceof Precedence) {
			Precedence precedence=(Precedence) val;
			int operatorLevel = precedence.getValue();
			if (precedence.unary && operatorLevel == level) {
				nextSymb();
				//TRACE("acceptUnaryOperator("+Parser.currentToken+','+level+") SUCCESS");
				return (true);
			}
		}
		//TRACE("acceptUnaryOperator("+Parser.currentToken+','+level+") FAILED");
		return (false);
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
