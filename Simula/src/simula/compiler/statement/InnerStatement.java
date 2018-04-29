package simula.compiler.statement;

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

//	public InnerStatement() {
//	}

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Util.setLine(lineNumber);
		SET_SEMANTICS_CHECKED();
	}
	
	public void doJavaCoding(String indent) {
		Util.setLine(lineNumber);
		Util.code(indent + "if(inner!=null) inner.STM();");
	}

	public void print(String indent, String tail) {
		System.out.println(indent+"inner"); 
	}

	public String toString() {
		return ("INNER");
	}

}
