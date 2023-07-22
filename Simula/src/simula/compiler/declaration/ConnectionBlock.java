/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.expression.Expression;
import simula.compiler.expression.TypeConversion;
import simula.compiler.expression.Variable;
import simula.compiler.statement.Statement;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Connection Block.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/declaration/ConnectionBlock.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 */
public final class ConnectionBlock extends DeclarationScope {
	private Statement statement;
	private final String whenClassIdentifier;
	private Declaration whenClassDeclaration; // Set during cheching
	
	/**
	 * The inspected variable.
	 */
	public final Variable inspectedVariable;
	
	/**
	 * The when class identifier
	 */
	public ClassDeclaration classDeclaration;

	/**
	 * Create a new ConnectionBlock.
	 * @param inspectedVariable the inspected variable
	 * @param whenClassIdentifier the when class identifier
	 */
	public ConnectionBlock(final Variable inspectedVariable,final String whenClassIdentifier) {
		super("Connection block at line " + (Global.sourceLineNumber-1));
		declarationKind = Declaration.Kind.ConnectionBlock;
		this.inspectedVariable = inspectedVariable;
		this.whenClassIdentifier = whenClassIdentifier;
	}

	/**
	 * Get inspected expression.
	 * @return inspected expression.
	 */
	public Expression getInspectedExpression() {
		Type type = classDeclaration.type;
		return ((Expression) TypeConversion.testAndCreate(type, inspectedVariable));
	}

	/**
	 * Connection block end.
	 */
	public void end() {
		if (Option.TRACE_PARSE)	Util.TRACE("END ConnectionBlock: " + this.edScopeChain());
	    if(!labelList.isEmpty()) MaybeBlockDeclaration.moveLabelsFrom(this); // Label is also declaration
		Global.setScope(declaredIn);
	}
	
	/**
	 * Set the Connected ClassDecleration.
	 * @param classDeclaration the Connected ClassDecleration.
	 */
	public void setClassDeclaration(final ClassDeclaration classDeclaration) {
		this.classDeclaration = classDeclaration;
	}

	/**
	 * Set the Connection Statement.
	 * @param statement the Connection Statement
	 */
	public void setStatement(final Statement statement) {
		this.statement = statement;
	}

	@Override
	public Meaning findMeaning(final String identifier) {
		if (classDeclaration == null && Global.duringParsing) return (null); // Still in Pass1(Parser)
		Meaning result=null;
		if(classDeclaration!=null) result = classDeclaration.findRemoteAttributeMeaning(identifier);
		if (result != null) {
			result.declaredIn = this;
		} else if (declaredIn != null) {
			result = declaredIn.findMeaning(identifier);
		}
		if (result == null) {
			Util.error("Undefined variable: " + identifier);
			result = new Meaning(null, null); // Error Recovery: No Meaning
		}
		return (result);
	}

	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber = lineNumber;
		// Set External Identifier
		externalIdent = inspectedVariable.identifier + '_' + lineNumber;
		Global.enterScope(this);
			rtBlockLevel = currentRTBlockLevel;
			if (whenClassIdentifier != null) {
				Meaning meaning = findMeaning(whenClassIdentifier);
				whenClassDeclaration = meaning.declaredAs;
			}
			statement.doChecking();
		Global.exitScope();
		SET_SEMANTICS_CHECKED();
	}

	@Override
	public void doJavaCoding() {
		Global.sourceLineNumber = lineNumber;
		ASSERT_SEMANTICS_CHECKED();
		Global.enterScope(this);
		GeneratedJavaClass.code("{");
		statement.doJavaCoding();
		GeneratedJavaClass.code("}");
		Global.exitScope();
	}

	@Override
	public String toJavaCode() {
		String connID = inspectedVariable.toJavaCode();
		Declaration when = whenClassDeclaration;
		if (when == null) return (connID);
		return ("((" + when.getJavaIdentifier() + ')' + connID + ')');
	}

	// ***********************************************************************************************
	// *** Printing Utility: print
	// ***********************************************************************************************
	@Override
	public void print(final int indent) {
    	String spc=edIndent(indent);
		StringBuilder s = new StringBuilder(indent);
	    s.append('[').append(sourceBlockLevel).append(':').append(rtBlockLevel).append("] ");
		s.append(declarationKind).append(' ').append(identifier);
		Util.println(s.toString());
		String beg = "begin[" + edScopeChain() + ']';
		Util.println(spc + beg);
		for (Declaration decl : declarationList) decl.print(indent + 1);
		statement.print(indent + 1);
		Util.println(spc + "end[" + edScopeChain() + ']');
	}

	@Override
	public String toString() {
		return ("Inspect(" + inspectedVariable + ") do " + statement);
	}

}
