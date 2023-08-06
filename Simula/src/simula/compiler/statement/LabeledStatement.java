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
import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.LabelDeclaration;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
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
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/statement/LabeledStatement.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 */
public final class LabeledStatement extends Statement {
	private final Vector<String> labels;
	private final Statement statement;

	/**
	 * Create a new LabeledStatement.
	 * @param line the source line number
	 * @param labels the label identifiers
	 * @param statement the labeled statement
	 */
	LabeledStatement(final int line,final Vector<String> labels,final Statement statement) {
		super(line);
		this.labels = labels;
		this.statement = statement;
		if (Option.TRACE_PARSE) Util.TRACE("Line "+lineNumber+": LabeledStatement: "+this);
	}

	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		statement.doChecking();
		for (String label:labels) {
			Meaning meaning = Global.getCurrentScope().findMeaning(label);
			Declaration decl=meaning.declaredAs;
			if(!(decl instanceof LabelDeclaration)) {
				Util.warning("Label "+label+" can be confused with "
						+decl.getClass().getSimpleName()+" "+decl.identifier+" at line "+decl.lineNumber+')');
			}
			decl.doChecking();
		}
		SET_SEMANTICS_CHECKED();
	}

	@Override
	public void doJavaCoding() {
		Global.sourceLineNumber=lineNumber;
		ASSERT_SEMANTICS_CHECKED();
		GeneratedJavaClass.code("{");
		for (String label:labels) {
			Meaning meaning=Global.getCurrentScope().findLabelMeaning(label);
			LabelDeclaration decl=(LabelDeclaration)meaning.declaredAs;
			String labelcode;
			if(Option.USE_FILE_CLASS_API > 0)
				 labelcode="_SIM_LABEL("+decl.index+");";
			else labelcode="_LABEL("+decl.index+",\""+decl.identifier+"\");";
			if(statement instanceof BlockStatement stat) {
				BlockStatement blockStatement=stat;
				if(blockStatement.isCompoundStatement())
				    blockStatement.addLeadingLabel(labelcode);
				else {
					if(Option.USE_FILE_CLASS_API==2) GeneratedJavaClass.code("_PRE_LABEL()");
					GeneratedJavaClass.code(labelcode);
				}
			}
			else {
				if(Option.USE_FILE_CLASS_API==2) GeneratedJavaClass.code("_PRE_LABEL();");
				GeneratedJavaClass.code(labelcode);
			}
		}
		statement.doJavaCoding();
		GeneratedJavaClass.code("}");	}

	@Override
	public String toString() {
		return ("" + labels + ':');
	}

}
