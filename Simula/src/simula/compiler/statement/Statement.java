/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.statement;

import java.util.Vector;

import simula.compiler.JavaModule;
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
	
	public static Statement doParse() {
		Vector<String> labels = null;
		if (Option.TRACE_PARSE)
			Util.TRACE("Parse Statement, current=" + Parser.currentToken + ", prev=" + Parser.prevToken);
		String ident = acceptIdentifier();
		while (Parser.accept(KeyWord.COLON)) {
			if (ident != null) {
				if (labels == null)	labels = new Vector<String>();
				labels.add(ident);
				LabelDeclaration label = new LabelDeclaration(ident);
				Global.currentScope.labelList.add(label);
			} else Util.error("Missplaced ':'");
			ident = acceptIdentifier();
		}
		if(ident!=null) Parser.saveCurrentToken(); // Not Label: Pushback
		Statement statement = doUnlabeledStatement();
		if (labels != null && statement != null)
			statement = new LabeledStatement(labels, statement);
		return (statement);
	}

	private static Statement doUnlabeledStatement() {
		if (Option.TRACE_PARSE)
			Util.TRACE("Statement.doUnlabeledStatement, current=" + Parser.currentToken	+ ", prev=" + Parser.prevToken);
		switch(Parser.currentToken.getKeyWord()) {
		    case BEGIN: Parser.nextSymb(); return (new MaybeBlockDeclaration(null).parseMaybeBlock());
		    case IF:    Parser.nextSymb(); return (new ConditionalStatement());
		    case GOTO:  Parser.nextSymb(); return (new GotoStatement());
		    case GO:    Parser.nextSymb(); 
				        if (!Parser.accept(KeyWord.TO))	Util.error("Missing 'TO' after 'GO'");
				        return (new GotoStatement());
		    case FOR:        Parser.nextSymb(); return (new ForStatement());
		    case WHILE:      Parser.nextSymb(); return (new WhileStatement());
		    case INSPECT:    Parser.nextSymb(); return (new ConnectionStatement());
		    case SWITCH:     Parser.nextSymb(); return (new SwitchStatement());
		    case ACTIVATE:   Parser.nextSymb(); return (new ActivationStatement());
		    case REACTIVATE: Parser.nextSymb(); return (new ActivationStatement());
		    case INNER:      Parser.nextSymb(); return (new InnerStatement());
		    case SEMICOLON:  Parser.nextSymb(); return (new DummyStatement()); // Dummy Statement
		    case END:        return (new DummyStatement()); // Dummy Statement, keep END
		
		    case IDENTIFIER: case NEW: case THIS: case BEGPAR:
		         Expression expr = Expression.parseExpression();
		         if(expr!=null) {
		        	 if(expr instanceof Variable)
		        	 { if (Parser.accept(KeyWord.BEGIN))
		        		 return new BlockStatement(new PrefixedBlockDeclaration(null,(Variable)expr,false));
		        	 }
		        	 return (new StandaloneExpression(expr));
		         }
		    default:
		    	Parser.skipMissplacedCurrentSymbol();
		    	return(new DummyStatement());
		}
	}

	public void doJavaCoding() {
		Global.sourceLineNumber=lineNumber;
		ASSERT_SEMANTICS_CHECKED(this);
		JavaModule.code(toJavaCode() + ';');
	}

}
