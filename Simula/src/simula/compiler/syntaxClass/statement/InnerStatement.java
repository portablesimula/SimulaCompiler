/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass.statement;

import java.util.Vector;

import simula.compiler.CodeLine;
import simula.compiler.syntaxClass.declaration.ClassDeclaration;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Inner Statement.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 *   inner-statement = INNER
 *
 * </pre>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/statement/InnerStatement.java">
 * <b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 */
public final class InnerStatement extends Statement {

	/**
	 * Create a new InnerStatement.
	 * @param line the source line number
	 */
	 public InnerStatement(final int line) {
		super(line);
		if (Option.TRACE_PARSE) Util.TRACE("Line "+lineNumber+": InnerStatement: "+this);
	}

	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		SET_SEMANTICS_CHECKED();
	}
	
	@Override
	public void doJavaCoding() {
		Global.sourceLineNumber=lineNumber;
		ClassDeclaration cls=(ClassDeclaration)Global.getCurrentScope();
		if(cls.code2==null) cls.code2=new Vector<CodeLine>();
		Global.currentJavaModule.saveCode=cls.code2;
	}

	@Override
	public void print(final int indent) {
    	String spc=edIndent(indent);
		Util.println(spc+"inner"); 
	}
	
	@Override
	public void printTree(final int indent) {
		System.out.println(edTreeIndent(indent)+"INNER ");
	}

	@Override
	public String toString() {
		return ("INNER");
	}

}
