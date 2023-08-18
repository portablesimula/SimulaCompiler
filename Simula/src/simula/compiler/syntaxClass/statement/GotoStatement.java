/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass.statement;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.syntaxClass.Type;
import simula.compiler.syntaxClass.expression.Expression;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Goto Statement.
 * 
 * <pre>
 * 
 * Simula Standard: 4.5 Goto-statement
 * 
 *  goto-statement = GOTO designational-expression
 *                 | GO TO designational-expression
 *
 * </pre>
 * Java does not support labels like Simula. The Java Virtual Machine (JVM), however, has labels.
 * A JVM-label is simply a relative byte-address within the byte-code of a method. We will use Java's
 * exception handling together with byte code engineering to re-introduce goto in the Java Language.
 * This is done by generating Java-code which is prepared for Byte Code Engineering.
 * <p>
 * See <a href="https://portablesimula.github.io/github.io/doc/SimulaRTS.pdf">Mapping Simula to Java (runtime design)</a> 
 * Sect. 6.1 Goto Statement
 * <p>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/statement/GotoStatement.java">
 * <b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 */
public final class GotoStatement extends Statement {
	/**
	 * The target label.
	 */
	private final Expression label;

	/**
	 * Create a new GotoStatement.
	 * @param line source line
	 */
	GotoStatement(final int line) {
		super(line);
		label = Expression.expectExpression();
		if (Option.TRACE_PARSE) Util.TRACE("Line "+this.lineNumber+": GotoStatement: "+this);
	}

	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		label.doChecking();
		if (label.type != Type.Label)
			Util.error("Goto " + label + ", " + label + " is not a Label");
		label.backLink = this; // To ensure _RESULT from functions
		SET_SEMANTICS_CHECKED();
	}

	@Override
	public void doJavaCoding() {
		Global.sourceLineNumber = lineNumber;
		ASSERT_SEMANTICS_CHECKED();
  		Type type = label.type;
		Util.ASSERT(type == Type.Label, "Invariant");
		GeneratedJavaClass.code("_GOTO(" + label.toJavaCode() + ");","GOTO EVALUATED LABEL");
	}

	@Override
	public void printTree(final int indent) {
		System.out.println(edTreeIndent(indent)+"GOTO "+label);
		label.printTree(indent+1);
	}

	@Override
	public String toString() {
		return ("GOTO " + label);
	}

}
