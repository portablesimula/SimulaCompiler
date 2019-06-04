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

	public ClassDeclaration getClassDeclaration() {
		return (classDeclaration);
	}

	final String whenClassIdentifier;
	public Declaration whenClassDeclaration; // Set during cheching

	public Expression getInspectedVariable() {
		Type type = classDeclaration.type;
		// Util.BREAK("ConnectionBlock.getInspectedVariable:
		// classDeclaration="+classDeclaration+", type="+type);
		// Util.BREAK("ConnectionBlock.getInspectedVariable:
		// inspectedVariable="+inspectedVariable+", type="+inspectedVariable.type);
		return ((Expression) TypeConversion.testAndCreate(type, inspectedVariable));
	}

	public ConnectionBlock(final Variable inspectedVariable,final String whenClassIdentifier) {
		super("Inspect:" + inspectedVariable);
		// Global.currentScope=this;
		blockKind = BlockKind.ConnectionBlock;
		this.inspectedVariable = inspectedVariable;
		this.whenClassIdentifier = whenClassIdentifier;
		// Util.BREAK("BEGIN ConnectionBlock: "+this+", Scope="+this.edScopeChain());
		// Util.BREAK("BEGIN ConnectionBlock: inspectedVariable="+inspectedVariable+",
		// Type="+inspectedVariable.type);
	}

	public void end() {
		if (Option.TRACE_PARSE)	Util.TRACE("END ConnectionBlock: " + this.edScopeChain());
		// Debug.BREAK("END ConnectionBlock: "+this.edScopeChain());
	    if(!labelList.isEmpty()) MaybeBlockDeclaration.moveLabelsFrom(this); // Label is also declaration
		Global.currentScope = declaredIn;
	}
	
	

	public void setClassDeclaration(final ClassDeclaration classDeclaration) {
		// Util.BREAK("ConnectionBlock("+this.identifier+").setClassDeclaration("+classDeclaration.identifier+")");
		this.classDeclaration = classDeclaration;
	}

	public void setStatement(final Statement statement) {
		this.statement = statement;
	}

	public Meaning findMeaning(final String identifier) {
		// if(identifier.equalsIgnoreCase("ELT")) Util.BREAK("ConnectionBlock("+this.identifier+").findMeaning("+identifier+") classDeclaration="+classDeclaration);
		if (classDeclaration == null && Global.duringParsing)
			return (null); // Still in Pass1(Parser)
		Meaning result = classDeclaration.findRemoteAttributeMeaning(identifier);
		// if(identifier.equalsIgnoreCase("L"))Util.BREAK("ConnectionBlock("+this.identifier+").findMeaning("+identifier+") ==> "+result);
		if (result != null) {
			result.declaredIn = this;
		} else if (declaredIn != null)
			result = declaredIn.findMeaning(identifier);
		if (result == null) {
			//if(identifier.equalsIgnoreCase("ELT")) Util.BREAK("ConnectionBlock(" + this.identifier + ").findMeaning(" + identifier + ") ==> UNDEFINED");
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
			// Util.BREAK("ConnectionBlock("+this.identifier+").doChecking:
			// meaning="+meaning);
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
		// return (inspectedVariable.toJavaCode());
		String connID = inspectedVariable.toJavaCode();
		Declaration when = whenClassDeclaration;
		if (when == null)
			return (connID);
		return ("((" + when.getJavaIdentifier() + ')' + connID + ')');
	}

	// ***********************************************************************************************
	// *** Printing Utility: print
	// ***********************************************************************************************
	public void print(final int indent) {
    	String spc=edIndent(indent);
		StringBuilder s = new StringBuilder(indent);
	    s.append('[').append(sourceBlockLevel).append(':').append(blockLevel).append("] ");
		s.append(blockKind).append(' ').append(identifier);
		Util.println(s.toString());
		String beg = "begin[" + edScopeChain() + ']';
		Util.println(spc + beg);
		for (Declaration decl : declarationList) decl.print(indent + 1);
		statement.print(indent + 1);
		Util.println(spc + "end[" + edScopeChain() + ']');
		// Util.BREAK("ConnectionBlock.print DONE");
	}

	public String toString() {
		return ("Inspect(" + inspectedVariable + ") do " + statement);
	}

}
