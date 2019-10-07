/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import simula.compiler.expression.Expression;
import simula.compiler.expression.TypeConversion;
import simula.compiler.expression.Variable;
import simula.compiler.statement.Statement;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

public final class ConnectionBlock extends DeclarationScope {
	public final Variable inspectedVariable;
	Statement statement;
	public ClassDeclaration classDeclaration;
	final String whenClassIdentifier;
	public Declaration whenClassDeclaration; // Set during cheching

	public ConnectionBlock(final Variable inspectedVariable,final String whenClassIdentifier) {
		super("Inspect:" + inspectedVariable);
		declarationKind = Declaration.Kind.ConnectionBlock;
		this.inspectedVariable = inspectedVariable;
		this.whenClassIdentifier = whenClassIdentifier;
	}

	public Expression getInspectedVariable() {
		Type type = classDeclaration.type;
		return ((Expression) TypeConversion.testAndCreate(type, inspectedVariable));
	}

	public void end() {
		if (Option.TRACE_PARSE)	Util.TRACE("END ConnectionBlock: " + this.edScopeChain());
	    if(!labelList.isEmpty()) MaybeBlockDeclaration.moveLabelsFrom(this); // Label is also declaration
		Global.currentScope = declaredIn;
	}
	
	public void setClassDeclaration(final ClassDeclaration classDeclaration) {
		this.classDeclaration = classDeclaration;
	}

	public void setStatement(final Statement statement) {
		this.statement = statement;
	}

	public Meaning findMeaning(final String identifier) {
		if (classDeclaration == null && Global.duringParsing)
			return (null); // Still in Pass1(Parser)
		Meaning result = classDeclaration.findRemoteAttributeMeaning(identifier);
		if (result != null) {
			result.declaredIn = this;
		} else if (declaredIn != null)
			result = declaredIn.findMeaning(identifier);
		if (result == null) {
			Util.error("Undefined variable: " + identifier);
			result = new Meaning(null, null); // Error Recovery: No Meaning
		}
		return (result);
	}

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber = lineNumber;
		// Set External Identifier
		externalIdent = inspectedVariable.identifier + '$' + lineNumber;
		Global.currentScope = this;
		blockLevel = currentBlockLevel;
		if (whenClassIdentifier != null) {
			Meaning meaning = findMeaning(whenClassIdentifier);
			whenClassDeclaration = meaning.declaredAs;
		}
		statement.doChecking();
		Global.currentScope = declaredIn;
		SET_SEMANTICS_CHECKED();
	}

	public void doJavaCoding() {
		Global.sourceLineNumber = lineNumber;
		ASSERT_SEMANTICS_CHECKED(this);
		Global.currentScope = this;
		statement.doJavaCoding();
		Global.currentScope = declaredIn;
	}

	public String toJavaCode() {
		String connID = inspectedVariable.toJavaCode();
		Declaration when = whenClassDeclaration;
		if (when == null) return (connID);
		return ("((" + when.getJavaIdentifier() + ')' + connID + ')');
	}

	// ***********************************************************************************************
	// *** Printing Utility: print
	// ***********************************************************************************************
	public void print(final int indent) {
    	String spc=edIndent(indent);
		StringBuilder s = new StringBuilder(indent);
	    s.append('[').append(sourceBlockLevel).append(':').append(blockLevel).append("] ");
		s.append(declarationKind).append(' ').append(identifier);
		Util.println(s.toString());
		String beg = "begin[" + edScopeChain() + ']';
		Util.println(spc + beg);
		for (Declaration decl : declarationList) decl.print(indent + 1);
		statement.print(indent + 1);
		Util.println(spc + "end[" + edScopeChain() + ']');
	}

	public String toString() {
		return ("Inspect(" + inspectedVariable + ") do " + statement);
	}

}
