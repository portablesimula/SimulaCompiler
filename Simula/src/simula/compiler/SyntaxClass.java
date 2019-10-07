/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler;

import simula.compiler.declaration.Declaration;
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Token;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * A NonTerminal object represents non terminal symbol in the formal syntax.
 *
 * Parsing descends in a top-down manner, until the final nonterminal has been processed.
 * The parsing process depends on a global variable, currentToken, which contains the current symbol
 * from the input, and the function nextSymb, which updates currentToken when called.
 * 
 * For further description of Recursive Descent Parsing
 * see <a href="https://en.wikipedia.org/wiki/Recursive_descent_parser">Wikipedia</a>.
 *
 * <pre>
 * 
 * ***********************************************************************	
 *  META-SYNTAX:
 *  
 *       MetaSymbol                    Meaning
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
	public Type type = null;
	public final int lineNumber;

	protected SyntaxClass() {
		lineNumber = Global.sourceLineNumber;
	}

	public static String acceptIdentifier() {
		Token token = Parser.currentToken;
		if (Parser.accept(KeyWord.IDENTIFIER))
			return (token.getIdentifier().toString());
		return (null);
	}

	public static String expectIdentifier() {
		Token token = Parser.currentToken;
		if (acceptIdentifier() != null)
			return (token.getIdentifier().toString());
		Util.error("Got symbol " + token + " while expecting an Identifier");
		return (null);
	}  

  
    public static Type acceptType() {
    	Type type=null; //Type.Notype;
    	if(Parser.accept(KeyWord.BOOLEAN)) type=Type.Boolean;
    	else if(Parser.accept(KeyWord.CHARACTER)) type=Type.Character;
    	else if(Parser.accept(KeyWord.INTEGER)) type=Type.Integer;
		else if(Parser.accept(KeyWord.SHORT)) { Parser.expect(KeyWord.INTEGER); type=Type.Integer; }
		else if(Parser.accept(KeyWord.REAL)) type=Type.Real;
		else if(Parser.accept(KeyWord.LONG)) { Parser.expect(KeyWord.REAL); type=Type.LongReal; }
		else if(Parser.accept(KeyWord.TEXT)) type=Type.Text;
		else if(Parser.accept(KeyWord.REF))	{
			Parser.expect(KeyWord.BEGPAR); Token classIdentifier=Parser.currentToken;
			Parser.expect(KeyWord.IDENTIFIER); Parser.expect(KeyWord.ENDPAR); 
			type=Type.Ref(classIdentifier.toString()); 
		}
		return(type);  
    }

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
		if (this instanceof Declaration) {
			Declaration decl = (Declaration) this;
			if (decl.externalIdent == null)	Util.error("External Identifier is not set");
		}
	}

	public void doDeclarationCoding() {
	}

	public void doJavaCoding() {
		Global.sourceLineNumber = lineNumber;
		JavaModule.code(toJavaCode());
	}

	public String toJavaCode() {
		return (toString());
	}

	public void print(final int indent) {
		Util.println(edIndent(indent) + this);
	}
	
	protected String edIndent(final int indent) {
		int i=indent; String s="";
		while((i--)>0) s=s+"    ";
		return(s);  
	}

}
