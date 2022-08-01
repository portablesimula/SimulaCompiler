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
import simula.compiler.declaration.LabelDeclaration;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Meaning;
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
public final class LabeledStatement extends Statement {
	private final Vector<String> labels;
	private final Statement statement;

	public LabeledStatement(final Vector<String> labels,final Statement statement) {
		this.labels = labels;
		this.statement = statement;
	}

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		statement.doChecking();
		for (String label:labels) {
			Meaning meaning = Global.currentScope.findMeaning(label);
			try {
			   LabelDeclaration decl=(LabelDeclaration)meaning.declaredAs;
			   decl.doChecking();
			} catch(Exception e) { Util.error("Label "+label+" not found"); }			
		}
		SET_SEMANTICS_CHECKED();
	}

	public void doJavaCoding() {
		Global.sourceLineNumber=lineNumber;
		ASSERT_SEMANTICS_CHECKED(this);
		for (String label:labels) {
			Meaning meaning = Global.currentScope.findMeaning(label);
			LabelDeclaration decl=(LabelDeclaration)meaning.declaredAs;
			JavaModule.code("LABEL$("+decl.index+",\""+decl.identifier+"\");");
		}
		statement.doJavaCoding();
	}

	public String toString() {
		return ("" + labels + ':');
	}

}
