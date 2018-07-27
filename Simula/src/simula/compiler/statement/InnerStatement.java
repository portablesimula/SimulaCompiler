package simula.compiler.statement;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.Util;

/**
 * Inner Statement.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 *   InnerStatement = INNER
 *
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public class InnerStatement extends Statement {

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		SET_SEMANTICS_CHECKED();
	}
	
	public void doJavaCoding(int indent) {
		Global.sourceLineNumber=lineNumber;
		Util.code(indent,"if(inner!=null) {");
		Util.code(indent,"   inner.STM();");
		Util.code(indent,"   TRACE_BEGIN_STM_AFTER_INNER$(\""+Global.currentScope.identifier+"\","+Global.sourceLineNumber+");");
		Util.code(indent,"}");
	}

	public void print(String indent, String tail) {
		System.out.println(indent+"inner"); 
	}

	public String toString() {
		return ("INNER");
	}

}
