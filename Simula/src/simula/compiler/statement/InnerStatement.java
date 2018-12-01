package simula.compiler.statement;

import simula.compiler.JavaModule;
import simula.compiler.utilities.Global;

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
public final class InnerStatement extends Statement {

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		SET_SEMANTICS_CHECKED();
	}
	
	public void doJavaCoding() {
		Global.sourceLineNumber=lineNumber;
		JavaModule.code("if(inner!=null) {");
		JavaModule.code("inner.STM$();");
		JavaModule.code("TRACE_BEGIN_STM_AFTER_INNER$(\""+Global.currentScope.identifier+"\","+Global.sourceLineNumber+");");
		JavaModule.code("}");
	}

	public void print(String indent) {
		System.out.println(indent+"inner"); 
	}

	public String toString() {
		return ("INNER");
	}

}
