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
import simula.compiler.SyntaxClass;
import simula.compiler.declaration.LabelDeclaration;
import simula.compiler.declaration.MaybeBlockDeclaration;
import simula.compiler.declaration.PrefixedBlockDeclaration;
import simula.compiler.expression.Expression;
import simula.compiler.expression.Variable;
import simula.compiler.parsing.Parser;
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
 *         =  { label : }  UnconditionalStatement
 *         |  { label : }  ConditionalStatement
 *         |  { label : }  ForStatement
 * 
 *     UnconditionalStatement
 *         =  AssignmentStatement  NOTE: Treated as a binary operation
 *         |  WhileStatement
 *         |  GotoStatement
 *         |  ProcedureStatement
 *         |  ObjectGenerator
 *         |  ConnectionStatement
 *         |  CompoundStatement
 *         |  Block
 *         |  DummyStatement
 *         |  ActivationStatement
 * 
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public abstract class Statement extends SyntaxClass {
	
	protected Statement(int line) {
		lineNumber=line;
//		if(Option.TESTING) System.out.println("Statement.New "+this.getClass().getSimpleName()+": Line "+lineNumber+": "+this);
	}

	public static Statement doParse() {
		Vector<String> labels = null;
		int lineNumber=Parser.currentToken.lineNumber;
		if (Option.TRACE_PARSE)
			Util.TRACE("Statement.doParse: LabeledStatement: lineNumber="+lineNumber+", current=" + Parser.currentToken	+ ", prev=" + Parser.prevToken);
		String ident = acceptIdentifier();
		while (Parser.accept(KeyWord.COLON)) {
			if (ident != null) {
				if (labels == null)	labels = new Vector<String>();
				labels.add(ident);
				LabelDeclaration label = new LabelDeclaration(ident);
				Global.getCurrentScope().labelList.add(label);
			} else Util.error("Missplaced ':'");
			ident = acceptIdentifier();
		}
		if(ident!=null) Parser.saveCurrentToken(); // Not Label: Pushback
		Statement statement = doUnlabeledStatement();
		if (labels != null && statement != null)
			statement = new LabeledStatement(lineNumber,labels, statement);
		return (statement);
	}

	@SuppressWarnings("incomplete-switch")
	private static Statement doUnlabeledStatement() {
		int lineNumber=Parser.currentToken.lineNumber;
		if (Option.TRACE_PARSE)
			Util.TRACE("Statement.doUnlabeledStatement: lineNumber="+lineNumber+", current=" + Parser.currentToken	+ ", prev=" + Parser.prevToken);
		switch(Parser.currentToken.getKeyWord()) {
		    case BEGIN: Parser.nextSymb(); return (new MaybeBlockDeclaration(null).parseMaybeBlock(lineNumber));
		    case IF:    Parser.nextSymb(); return (new ConditionalStatement(lineNumber));
		    case GOTO:  Parser.nextSymb(); return (new GotoStatement(lineNumber));
		    case GO:    Parser.nextSymb(); 
				        if (!Parser.accept(KeyWord.TO))	Util.error("Missing 'TO' after 'GO'");
				        return (new GotoStatement(lineNumber));
		    case FOR:        Parser.nextSymb(); return (new ForStatement(lineNumber));
		    case WHILE:      Parser.nextSymb(); return (new WhileStatement(lineNumber));
		    case INSPECT:    Parser.nextSymb(); return (new ConnectionStatement(lineNumber));
		    case SWITCH:	 if(Option.EXTENSIONS) {
		    					Parser.nextSymb(); return (new SwitchStatement(lineNumber));
		    				 }
		    case ACTIVATE:   Parser.nextSymb(); return (new ActivationStatement(lineNumber));
		    case REACTIVATE: Parser.nextSymb(); return (new ActivationStatement(lineNumber));
		    case INNER:      Parser.nextSymb(); return (new InnerStatement(lineNumber));
		    case SEMICOLON:  Parser.nextSymb(); return (new DummyStatement(lineNumber)); // Dummy Statement
		    case END:        return (new DummyStatement(lineNumber)); // Dummy Statement, keep END
		
		    case IDENTIFIER: case NEW: case THIS: case BEGPAR:
		         Expression expr = Expression.parseExpression();
		         if(expr!=null) {
		        	 if(expr instanceof Variable var) {
		        		 if (Parser.accept(KeyWord.BEGIN))
		        			 return new BlockStatement(new PrefixedBlockDeclaration(null,var,false));
		        	 }
		        	 return (new StandaloneExpression(lineNumber,expr));
		         }
//		    default:
//		    	Parser.skipMissplacedCurrentSymbol();
//		    	return(new DummyStatement(lineNumber));
		}
    	Parser.skipMissplacedCurrentSymbol();
    	return(new DummyStatement(lineNumber));
	}

	@Override
	public void doJavaCoding() {
		Global.sourceLineNumber=lineNumber;
		ASSERT_SEMANTICS_CHECKED(this);
		GeneratedJavaClass.code(toJavaCode() + ';');
	}

}
