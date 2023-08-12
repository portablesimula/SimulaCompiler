/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.statement;

import java.util.Vector;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.ProgramModule;
import simula.compiler.SyntaxClass;
import simula.compiler.declaration.LabelDeclaration;
import simula.compiler.declaration.MaybeBlockDeclaration;
import simula.compiler.declaration.PrefixedBlockDeclaration;
import simula.compiler.expression.Expression;
import simula.compiler.expression.Variable;
import simula.compiler.parsing.Parse;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Statement.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 *  Statement
 *         =  { label : }  unconditional-statement
 *         |  { label : }  conditional-statement
 *         |  { label : }  for-statement
 * 
 *     Unconditional-statement
 *         =  assignment-statement  NOTE: Treated as a binary operation
 *         |  while-statement
 *         |  goto-statement
 *         |  procedure-statement
 *         |  object-generator
 *         |  connection-statement
 *         |  compound-statement
 *         |  block
 *         |  dummy-statement
 *         |  activation-statement
 * 
 * </pre>
 * 
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/statement/Statement.java"><b>Source
 * File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 */
public abstract sealed class Statement extends SyntaxClass permits InnerStatement, ActivationStatement, BlockStatement,
		ConditionalStatement, ConnectionStatement, DummyStatement, ForStatement, GotoStatement, LabeledStatement,
		StandaloneExpression, SwitchStatement, WhileStatement, ProgramModule {

	/**
	 * Create a new Statement.
	 * @param line the source line number
	 */
	protected Statement(int line) {
		lineNumber=line;
	}

	/**
	 * Parse a statement.
	 * @return the statement
	 */
	public static Statement expectStatement() {
		Vector<String> labels = null;
		int lineNumber=Parse.currentToken.lineNumber;
		if (Option.TRACE_PARSE)
			Util.TRACE("Statement.doParse: LabeledStatement: lineNumber="+lineNumber+", current=" + Parse.currentToken	+ ", prev=" + Parse.prevToken);
		String ident = Parse.acceptIdentifier();
		while (Parse.accept(KeyWord.COLON)) {
			if (ident != null) {
				if (labels == null)	labels = new Vector<String>();
				labels.add(ident);
				LabelDeclaration label = new LabelDeclaration(ident);
				Global.getCurrentScope().labelList.add(label);
			} else Util.error("Missplaced ':'");
			ident = Parse.acceptIdentifier();
		}
		if(ident!=null) Parse.saveCurrentToken(); // Not Label: Pushback
		Statement statement = expectUnlabeledStatement();
		if (labels != null && statement != null)
			statement = new LabeledStatement(lineNumber,labels, statement);
		return (statement);
	}

	/**
	 * Parse Utility: Expect a statement.
	 * @return the resulting statement
	 */
	@SuppressWarnings("incomplete-switch")
	private static Statement expectUnlabeledStatement() {
		int lineNumber=Parse.currentToken.lineNumber;
		if (Option.TRACE_PARSE)
			Util.TRACE("Statement.doUnlabeledStatement: lineNumber="+lineNumber+", current=" + Parse.currentToken	+ ", prev=" + Parse.prevToken);
		switch(Parse.currentToken.getKeyWord()) {
		    case BEGIN: Parse.nextSymb(); return (new MaybeBlockDeclaration(null).parseMaybeBlock(lineNumber));
		    case IF:    Parse.nextSymb(); return (new ConditionalStatement(lineNumber));
		    case GOTO:  Parse.nextSymb(); return (new GotoStatement(lineNumber));
		    case GO:    Parse.nextSymb(); 
				        if (!Parse.accept(KeyWord.TO))	Util.error("Missing 'TO' after 'GO'");
				        return (new GotoStatement(lineNumber));
		    case FOR:        Parse.nextSymb(); return (new ForStatement(lineNumber));
		    case WHILE:      Parse.nextSymb(); return (new WhileStatement(lineNumber));
		    case INSPECT:    Parse.nextSymb(); return (new ConnectionStatement(lineNumber));
		    case SWITCH:	 if(Option.EXTENSIONS) {
		    					Parse.nextSymb(); return (new SwitchStatement(lineNumber));
		    				 }
		    case ACTIVATE:   Parse.nextSymb(); return (new ActivationStatement(lineNumber));
		    case REACTIVATE: Parse.nextSymb(); return (new ActivationStatement(lineNumber));
		    case INNER:      Parse.nextSymb(); return (new InnerStatement(lineNumber));
		    case SEMICOLON:  Parse.nextSymb(); return (new DummyStatement(lineNumber)); // Dummy Statement
		    case END:        return (new DummyStatement(lineNumber)); // Dummy Statement, keep END
		
		    case IDENTIFIER: case NEW: case THIS: case BEGPAR:
		         Expression expr = Expression.acceptExpression();
		         if(expr!=null) {
		        	 if(expr instanceof Variable var) {
		        		 if (Parse.accept(KeyWord.BEGIN))
		        			 return new BlockStatement(new PrefixedBlockDeclaration(var,false));
		        	 }
		        	 return (new StandaloneExpression(lineNumber,expr));
		         }
		}
    	Parse.skipMisplacedCurrentSymbol();
    	return(new DummyStatement(lineNumber));
	}

	@Override
	public void doJavaCoding() {
		Global.sourceLineNumber=lineNumber;
		ASSERT_SEMANTICS_CHECKED();
		GeneratedJavaClass.code(toJavaCode() + ';');
	}

}
