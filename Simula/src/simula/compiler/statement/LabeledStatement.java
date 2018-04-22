/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.statement;

import java.util.Vector;

import simula.compiler.utilities.Util;

/**
 * Labeled Statement.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 * LabelStatement =  Label : { Label : } Statement 
 * 
 * 	Label = Identifier
 *
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public class LabeledStatement extends Statement {
	private Vector<String> labels;
	private Statement statement;

	public LabeledStatement(Vector<String> labels, Statement statement) {
		this.labels = labels;
		this.statement = statement;
	}

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		statement.doChecking();
		SET_SEMANTICS_CHECKED();
	}

	public void doJavaCoding(String indent) {
		Util.setLine(lineNumber);
		ASSERT_SEMANTICS_CHECKED(this);
		for (String label:labels) {
			String line = label + "=new LABEL(\"" + label + "\");";
			//Util.BREAK("Statement.doLabelCoding: " + line);
			Util.code(indent + line);
		}
		statement.doJavaCoding(indent);
	}

	public String toString() {
		return ("" + labels + ':');
	}

}
