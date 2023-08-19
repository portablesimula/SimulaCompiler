/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.parsing;

import java.io.Reader;

import simula.compiler.syntaxClass.Type;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Token;
import simula.compiler.utilities.Util;

/**
 * The Simula Parser Utilities.
 * <p>
 * It contains all static utilities for parsing Simula Syntax.
 * <p>
 * The Simula Compiler uses Recursive Descent Parsing. Each syntax class is a
 * subclass of this class.
 * <p>
 * A NonTerminal object represents non terminal symbol in the formal syntax.
 * <p>
 * Parsing descends in a top-down manner, until the final nonterminal has been
 * processed. The parsing process depends on a global variable, currentToken,
 * which contains the current symbol from the input, and the function nextToken,
 * which updates currentToken when called.
 * <p>
 * For further description of Recursive Descent Parsing see <a href=
 * "https://en.wikipedia.org/wiki/Recursive_descent_parser">Wikipedia</a>.
 *
 * <pre>
 * 
 * ***********************************************************************	
 *  META-SYNTAX:
 *  
 *       MetaSymbol                    Meaning
 *       
 *           =                     is defined to be
 *           |                     alternatively
 *         [ x ]                   0 or 1 instance of x
 *         { x }                   0 or more instances of x
 *       ( x | y )                 grouping: either x or y
 *          xyz                    the terminal symbol xyz
 *     MetaIdentifier              a non terminal symbol
 * ***********************************************************************
 * </pre>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/parsing/Parse.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class Parse {
	
	/**
	 * The saved Token used by 'pushBack'
	 */
	private static Token savedToken; // Used by 'pushBack'
	
	/**
	 * Indicate that endOfFile error is given
	 */
	private static boolean endOfFileErrorGiven;
	
	/**
	 * The SimulaScanner
	 */
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

		nextToken();
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
	 * Advance to next Token.
	 */
	public static void nextToken() {
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
		        nextToken();
			}
	}

	/**
	 * Test to accept a KeyWord.
	 * <p>
	 * Test currentToken against each given key.
	 * If accepted 'nextToken' is called,
	 * thus setting prevToken.
	 * @param key t the given keywords
	 * @return true if a keyword is accepted, false otherwise.
	 */
	public static boolean accept(final KeyWord... key) {
		for (int i = 0; i < key.length; i++)
			if (Parse.currentToken.getKeyWord() == key[i]) {
				nextToken();
				return (true);
			}
		return (false);
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
	 * Skip misplaced current symbol.
	 */
	public static void skipMisplacedCurrentSymbol() {
		Util.error("Misplaced symbol: "+Parse.currentToken+" -- Ignored");
		nextToken();
	}
	
	/**
	 * Test to accept an identifier.
	 * @return the identifier or null
	 */
	public static String acceptIdentifier() {
		if (Parse.accept(KeyWord.IDENTIFIER))
			return (Parse.prevToken.getIdentifier());
		return (null);
	}

	/**
	 * Test to expect an identifier.
	 * <p>
	 * If failing to do so, an error is printed.
	 * @return the identifier or null
	 */
	public static String expectIdentifier() {
		Token token = Parse.currentToken;
		if (acceptIdentifier() != null)
			return (token.getIdentifier());
		Util.error("Got symbol " + token + " while expecting an Identifier");
		return (null);
	}  

  
	/**
	 * Test to accept a Type.
	 * @return the type or null
	 */
	public static Type acceptType() {
		Type type=null; //Type.Notype;
		if(Parse.accept(KeyWord.BOOLEAN)) type=Type.Boolean;
		else if(Parse.accept(KeyWord.CHARACTER)) type=Type.Character;
		else if(Parse.accept(KeyWord.INTEGER)) type=Type.Integer;
		else if(Parse.accept(KeyWord.SHORT)) { Parse.expect(KeyWord.INTEGER); type=Type.Integer; }
		else if(Parse.accept(KeyWord.REAL)) type=Type.Real;
		else if(Parse.accept(KeyWord.LONG)) { Parse.expect(KeyWord.REAL); type=Type.LongReal; }
		else if(Parse.accept(KeyWord.TEXT)) type=Type.Text;
		else if(Parse.accept(KeyWord.REF))	{
			Parse.expect(KeyWord.BEGPAR); Token classIdentifier=Parse.currentToken;
			Parse.expect(KeyWord.IDENTIFIER); Parse.expect(KeyWord.ENDPAR); 
			type=Type.Ref(classIdentifier.toString()); 
		}
		return(type);  
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
	 * Utility TRACE.
	 * @param msg a message
	 */
	public static void TRACE(final String msg) {
		Util.TRACE(msg + ", current=" + Parse.currentToken + ", prev=" + Parse.prevToken);
	}
	

}
