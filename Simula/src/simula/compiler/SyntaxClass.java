/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler;

import simula.compiler.declaration.Declaration;
import simula.compiler.parsing.Parse;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Token;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * The class SyntaxClass.
 * <p>
 * The Simula Compiler uses Recursive Descent Parsing. Each syntax class is a subclass of this class.
 * <p>
 * A NonTerminal object represents non terminal symbol in the formal syntax.
 * <p>
 * Parsing descends in a top-down manner, until the final nonterminal has been processed.
 * The parsing process depends on a global variable, currentToken, which contains the current symbol
 * from the input, and the function nextSymb, which updates currentToken when called.
 * <p>
 * For further description of Recursive Descent Parsing
 * see <a href="https://en.wikipedia.org/wiki/Recursive_descent_parser">Wikipedia</a>.
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
 * 
 * @author Øystein Myhre Andersen
 */

public abstract class SyntaxClass { 
	private boolean CHECKED = false; // Set true when doChecking(), put or get is called
	
	/**
	 * The type
	 */
	public Type type = null;
	
	/**
	 * The source line number
	 */
	public int lineNumber;

	protected SyntaxClass() {
		lineNumber = Global.sourceLineNumber;
	}

	protected static String acceptIdentifier() {
		Token token = Parse.currentToken;
		if (Parse.accept(KeyWord.IDENTIFIER))
			return (token.getIdentifier().toString());
		return (null);
	}

	protected static String expectIdentifier() {
		Token token = Parse.currentToken;
		if (acceptIdentifier() != null)
			return (token.getIdentifier().toString());
		Util.error("Got symbol " + token + " while expecting an Identifier");
		return (null);
	}  

  
    protected static Type acceptType() {
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
     * Perform semantic checking.
     * <p>
     * This must be redefined in every subclass.
     */
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber = lineNumber;
		String name = this.getClass().getSimpleName();
		Util.NOT_IMPLEMENTED("" + name + ".doChecking");
	}

	// Should be called from all doChecking,put,get methods
	// to signal that semantic checking is done.
	protected void SET_SEMANTICS_CHECKED() {
		CHECKED = true;
	}

	protected boolean IS_SEMANTICS_CHECKED() {
		return (CHECKED);
	}

	protected void ASSERT_SEMANTICS_CHECKED(final Object obj) {
		if (!CHECKED) Util.error("FATAL error - Semantic checker not called: " + obj.getClass().getName() + ", " + obj);
		if (this instanceof Declaration decl) {
			if (decl.externalIdent == null)	Util.error("External Identifier is not set");
		}
	}

	/**
	 * Output possible declaration code.
	 */
	public void doDeclarationCoding() {
	}

	/**
	 * Output Java code.
	 */
	public void doJavaCoding() {
		Global.sourceLineNumber = lineNumber;
		GeneratedJavaClass.code(toJavaCode());
	}

	/**
	 * Generate Java code for this Syntax Class.
	 * @return Java code
	 */
	public String toJavaCode() {
		return (toString());
	}

	/**
	 * Utility print method.
	 * @param indent number of spaces leading the line
	 */
	public void print(final int indent) {
		Util.println(edIndent(indent) + this);
	}
	
	protected String edIndent(final int indent) {
		int i=indent; String s="";
		while((i--)>0) s=s+"    ";
		return(s);  
	}

}
