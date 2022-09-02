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
import simula.compiler.declaration.ClassDeclaration;
import simula.compiler.declaration.ConnectionBlock;
import simula.compiler.declaration.DeclarationScope;
import simula.compiler.declaration.SimpleVariableDeclaration;
import simula.compiler.expression.AssignmentOperation;
import simula.compiler.expression.Expression;
import simula.compiler.expression.Variable;
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Connection Statement.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 * connection-statement = INSPECT object-expression  connection-part [ OTHERWISE statement ]
 *		connection-part = DO statement | selective-part
 *			selective-part = { WHEN <class identifier> DO <statement> }
 *
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public final class ConnectionStatement extends Statement {
	private final Expression objectExpression;
	private final Variable inspectedVariable;
	private final SimpleVariableDeclaration inspectVariableDeclaration;
	private final Vector<DoPart> connectionPart = new Vector<DoPart>();
	private final Statement otherwise;
	private final boolean hasWhenPart;
	private static int SEQU = 0;

	public ConnectionStatement(final int line) {
		super(line);
		if (Option.TRACE_PARSE)	Parser.TRACE("Parse ConnectionStatement");
		objectExpression = Expression.parseExpression();
		String ident = "_inspect_" + lineNumber + '_' + (SEQU++);
		inspectedVariable = new Variable(ident);
		inspectVariableDeclaration = new SimpleVariableDeclaration(Type.Ref("RTObject"), ident);
		DeclarationScope scope = Global.getCurrentScope();
		while (scope.declarationKind == null || scope instanceof ConnectionBlock)
			scope = scope.declaredIn;
		scope.declarationList.add(inspectVariableDeclaration);

		boolean hasWhenPart=false;
		if (Parser.accept(KeyWord.DO)) {
			ConnectionBlock connectionBlock = new ConnectionBlock(inspectedVariable, null);
			Statement statement = Statement.doParse();
			connectionPart.add(new DoPart(connectionBlock, statement));
			connectionBlock.end();
		} else {
			while (Parser.accept(KeyWord.WHEN)) {
				String classIdentifier = expectIdentifier();
				Parser.expect(KeyWord.DO);
				ConnectionBlock connectionBlock = new ConnectionBlock(inspectedVariable, classIdentifier);
				hasWhenPart = true;
				Statement statement = Statement.doParse();
				connectionPart.add(new WhenPart(classIdentifier, connectionBlock, statement));
				connectionBlock.end();
			}
		}
		Statement otherwise = null;
		if (Parser.accept(KeyWord.OTHERWISE)) otherwise = Statement.doParse();
		this.otherwise=otherwise;
		this.hasWhenPart=hasWhenPart;
		if (Option.TRACE_PARSE)	Util.TRACE("END NEW ConnectionStatement: " + toString());
		if(Option.TESTING) System.out.println("Line "+this.lineNumber+": ConnectionStatement: "+this);
	}

	private class DoPart {
		final ConnectionBlock connectionBlock;

		public DoPart(final ConnectionBlock connectionBlock,final Statement statement) {
			this.connectionBlock = connectionBlock; // this.statement=statement;
			connectionBlock.setStatement(statement);
			if (Option.TRACE_PARSE)
				Util.TRACE("NEW DoPart: " + toString());
		}

		public void doChecking() {
			Type type = inspectVariableDeclaration.type;
			String refIdentifier = type.getRefIdent();
			if (refIdentifier == null)
				Util.error("The Variable " + inspectedVariable + " is not ref() type");
			connectionBlock.setClassDeclaration(AssignmentOperation.getQualification(refIdentifier));
			connectionBlock.doChecking();
			SET_SEMANTICS_CHECKED();
		}

		public void doCoding(final boolean first) {
			ASSERT_SEMANTICS_CHECKED(this);
			connectionBlock.doJavaCoding();
		}

		public void print(final int indent) {
	    	String spc=edIndent(indent);
			Util.println(spc + "DO ");
			connectionBlock.print(indent);
		}

		@Override
		public String toString() {
			return (connectionBlock.toString());
		}
	}

	private final class WhenPart extends DoPart {
		String classIdentifier; // Set during checking.
		ClassDeclaration classDeclaration; // Set during checking.
		boolean impossibleWhenPart; // Set by doChecking

		public WhenPart(final String classIdentifier,final ConnectionBlock connectionBlock,final Statement statement) {
			super(connectionBlock, statement);
			this.classIdentifier = classIdentifier;
			if (Option.TRACE_PARSE)
				Util.TRACE("NEW DoPart: " + toString());
		}

		@Override
		public void doChecking() {
			if (classIdentifier == null) { // && objectExpression!=null)
				Type type = inspectVariableDeclaration.type;
				classIdentifier = type.getRefIdent();
				if (classIdentifier == null)
					Util.error("The Variable " + inspectedVariable + " is not ref() type");
			}
			if (classIdentifier != null) {
				classDeclaration = AssignmentOperation.getQualification(classIdentifier);
				connectionBlock.setClassDeclaration(classDeclaration);
			}
			if (!AssignmentOperation.checkCompatability(objectExpression, classIdentifier)) {
				Util.warning("Impossible When Part: " + objectExpression + " is not compatible with " + classIdentifier);
				impossibleWhenPart = true;
			}
			connectionBlock.doChecking();
		}

		@Override
		public void doCoding(final boolean first) {
			ASSERT_SEMANTICS_CHECKED(this);
			String prfx = (first) ? "" : "else ";
			String cid = classDeclaration.getJavaIdentifier();
			if (!impossibleWhenPart) {
				GeneratedJavaClass.code(prfx + "if(" + inspectedVariable.toJavaCode() + " instanceof " + cid + ") {","WHEN "	+ cid + " DO ");
				connectionBlock.doJavaCoding();
				GeneratedJavaClass.code("}");
			} else
				GeneratedJavaClass.code(prfx,"WHEN " + cid + " DO -- IMPOSSIBLE REMOVED");
		}

		@Override
		public void print(final int indent) {
	    	String spc=edIndent(indent);
			Util.println(spc + "WHEN " + classIdentifier + " DO ");
			connectionBlock.print(indent);
		}

		@Override
		public String toString() {
			return ("WHEN " + classIdentifier + " DO ..."); // +statement);
		}
	}

	@Override
	public void doChecking() {
		if (_ISSEMANTICS_CHECKED())	return;
		Global.sourceLineNumber = lineNumber;
		if (Option.TRACE_CHECKER)
			Util.TRACE("BEGIN ConnectionStatement(" + toString() + ").doChecking - Current Scope Chain: " + Global.getCurrentScope().edScopeChain());
		objectExpression.doChecking();
		Type exprType = objectExpression.type;
		exprType.doChecking(Global.getCurrentScope());
		inspectVariableDeclaration.type = exprType;
		inspectedVariable.type = exprType;
		inspectedVariable.doChecking();
		for(DoPart part:connectionPart) part.doChecking();
		if (otherwise != null) otherwise.doChecking();
		SET_SEMANTICS_CHECKED();
	}

	@Override
	public void doJavaCoding() {
		Global.sourceLineNumber = lineNumber;
		ASSERT_SEMANTICS_CHECKED(this);
		GeneratedJavaClass.code("{");
		GeneratedJavaClass.debug("// BEGIN INSPECTION ");
		Expression assignment = new AssignmentOperation(inspectedVariable, KeyWord.ASSIGNREF, objectExpression);
		assignment.doChecking();
		GeneratedJavaClass.code(assignment.toJavaCode() + ';');
		if (hasWhenPart)
			 GeneratedJavaClass.code(" //{","NEW INSPECT " + inspectedVariable);
		else GeneratedJavaClass.code("if(" + inspectedVariable.toJavaCode() + "!=null) {","NEW INSPECT " + inspectedVariable);
		boolean first = true;
		for(DoPart part:connectionPart) { part.doCoding(first);	first = false; }
		if (!hasWhenPart) GeneratedJavaClass.code("}");
		if (otherwise != null) {
			GeneratedJavaClass.code("else {","OTHERWISE ");
			otherwise.doJavaCoding();
			GeneratedJavaClass.code("}","END OTHERWISE ");
		}
		// JavaModule.debug("// END INSPECTION ");
		GeneratedJavaClass.code("}");
	}

	// ***********************************************************************************************
	// *** Printing Utility: print
	// ***********************************************************************************************
	@Override
	public void print(final int indent) {
    	String spc=edIndent(indent);
		// if(assignment!=null) assignment.print(indent);
		Util.println(spc + "INSPECT " + inspectedVariable);
		for (DoPart doPart : connectionPart) doPart.print(indent);
		if (otherwise != null) Util.println(spc + "   OTHERWISE " + otherwise + ';');
	}

	@Override
	public String toString() {
		String otherwisePart = (otherwise == null)?"":" OTHERWISE " + otherwise;
		return ("INSPECT " + inspectedVariable + " " + connectionPart + otherwisePart);
	}

}
