/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass.statement;

import java.util.Vector;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.parsing.Parse;
import simula.compiler.syntaxClass.Type;
import simula.compiler.syntaxClass.declaration.ClassDeclaration;
import simula.compiler.syntaxClass.declaration.ConnectionBlock;
import simula.compiler.syntaxClass.declaration.DeclarationScope;
import simula.compiler.syntaxClass.declaration.SimpleVariableDeclaration;
import simula.compiler.syntaxClass.expression.AssignmentOperation;
import simula.compiler.syntaxClass.expression.Expression;
import simula.compiler.syntaxClass.expression.VariableExpression;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Connection Statement.
 * 
 * <pre>
 * 
 * Simula Standard: 4.8 Connection statement
 *
 *	connection-statement
 *			= INSPECT object-expression when-clause { when-clause } [ otherwise-clause ]
 *			| INSPECT object-expression DO statement [ otherwise-clause ]
 *
 *			when-clause = WHEN class-identifier DO statement
 *
 *			otherwise-clause = OTHERWISE statement
 *
 *
 * The connection statement is implemented using Java's <b>instanceof</b> operator and the
 * if statement. For example, the connection statement:
 * 
 *         <b>inspect</b> x <b>do</b> image:-t;
 *         
 * Where 'x' is declared as a reference to an ImageFile, is compiled to:
 * 
 *         if(x!=null) x.image=t;
 *         
 * Other examples that also use '<b>ref</b>(Imagefile) x' may be:
 * 
 *      1) <b>inspect</b> x <b>do</b> image:-t <b>otherwise</b> t:-<b>notext</b>;
 *      
 *      2) <b>inspect</b> x
 *            <b>when</b> infile <b>do</b> t:-intext(12)
 *            <b>when</b> outfile <b>do</b> outtext(t);
 *            
 *      3) <b>inspect</b> x
 *            <b>when</b> infile <b>do</b> t:-intext(12)
 *            <b>when</b> outfile <b>do</b> outtext(t)
 *         <b>otherwise</b> t:-<b>notext</b>;
 * 
 * These examples are compiled to:
 * 
 *      1) <b>if</b>(x!=<b>null</b>) x.image=t; <b>else</b> t=null;
 *      
 *      2) <b>if</b>(x <b>instanceof</b> RTS_Infile) t=((RTS_Infile)x).intext(12);
 *         <b>else</b> <b>if</b>(x <b>instanceof</b> RTS_Outfile) ((RTS_Outfile)x).outtext(t);
 *          
 *      3) <b>if</b>(x <b>instanceof</b> RTS_Infile) t=((RTS_Infile)x).intext(12);
 *         <b>else</b> <b>if</b>(x <b>instanceof</b> RTS_Outfile) ((RTS_Outfile)x).outtext(t);
 *         <b>else</b> t=null;
 * 
 * </pre>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/statement/ConnectionStatement.java">
 * <b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 */
public final class ConnectionStatement extends Statement {
	
	/**
	 * The inspected object.
	 */
	private final Expression objectExpression;
	
	/**
	 * Utility Variable to hold the evaluated object-expression.
	 */
	private final VariableExpression inspectedVariable;
	
	/**
	 * The inspected variable's declaration.
	 */
	private final SimpleVariableDeclaration inspectVariableDeclaration;
	
	/**
	 * The connection parts. A DoPart or a list of WhenParts.
	 */
	private final Vector<DoPart> connectionPart = new Vector<DoPart>();
	
	/**
	 * The otherwise statement.
	 */
	private final Statement otherwise;
	
	/**
	 * True if this connection statement contains WhenPart(s).
	 */
	private final boolean hasWhenPart;
	
	/**
	 * Utility to help generate unique identifiers to the inspected variable.
	 */
	private static int SEQU = 0;

	/**
	 * Create a new ConnectionStatement.
	 * <p>
	 * Pre-Condition: INSPECT  is already read.
	 * @param line the source line number
	 */
	ConnectionStatement(final int line) {
		super(line);
		if (Option.TRACE_PARSE)	Parse.TRACE("Parse ConnectionStatement");
		objectExpression = Expression.expectExpression();
		String ident = "_inspect_" + lineNumber + '_' + (SEQU++);
		inspectedVariable = new VariableExpression(ident);
		inspectVariableDeclaration = new SimpleVariableDeclaration(Type.Ref("RTObject"), ident);
		DeclarationScope scope = Global.getCurrentScope();
		while (scope.declarationKind == null || scope instanceof ConnectionBlock) {
			scope = scope.declaredIn;
		}
		scope.declarationList.add(inspectVariableDeclaration);
		inspectVariableDeclaration.declaredIn=scope;

		boolean hasDoPart=false;
		boolean hasWhenPart=false;
		if (Parse.accept(KeyWord.DO)) {
			hasDoPart = true;
			ConnectionBlock connectionBlock = new ConnectionBlock(inspectedVariable, null);
			connectionBlock.declaredIn=scope;
			Statement statement = Statement.expectStatement();
			connectionPart.add(new DoPart(connectionBlock, statement));
			connectionBlock.end();
		} else {
			while (Parse.accept(KeyWord.WHEN)) {
				String classIdentifier = Parse.expectIdentifier();
				Parse.expect(KeyWord.DO);
				ConnectionBlock connectionBlock = new ConnectionBlock(inspectedVariable, classIdentifier);
				connectionBlock.declaredIn=scope;
				hasWhenPart = true;
				Statement statement = Statement.expectStatement();
				connectionPart.add(new WhenPart(classIdentifier, connectionBlock, statement));
				connectionBlock.end();
			}
		}
		if(!(hasDoPart | hasWhenPart)) Util.error("Incomplete Inspect statement: "+objectExpression);
		Statement otherwise = null;
		if (Parse.accept(KeyWord.OTHERWISE)) otherwise = Statement.expectStatement();
		this.otherwise=otherwise;
		this.hasWhenPart=hasWhenPart;
		if (Option.TRACE_PARSE)	Util.TRACE("Line "+this.lineNumber+": ConnectionStatement: "+this);
	}

	/**
	 * Utility class to hold the single do-part.
	 */
	private class DoPart {
		
		/**
		 * The associated connection block.
		 */
		final ConnectionBlock connectionBlock;

		/**
		 * Create a new do-part.
		 * @param connectionBlock The associated connection block
		 * @param statement the statement after DO
		 */
		private DoPart(final ConnectionBlock connectionBlock,final Statement statement) {
			this.connectionBlock = connectionBlock; // this.statement=statement;
			connectionBlock.setStatement(statement);
			if (Option.TRACE_PARSE)
				Util.TRACE("NEW DoPart: " + toString());
		}

		/**
		 * Perform semantic checking.
		 */
		public void doChecking() {
			Type type = inspectVariableDeclaration.type;
			String refIdentifier = type.getRefIdent();
			if (refIdentifier == null)
				Util.error("The Variable " + inspectedVariable + " is not ref() type");
			connectionBlock.setClassDeclaration(AssignmentOperation.getQualification(refIdentifier));
			connectionBlock.doChecking();
//			SET_SEMANTICS_CHECKED();
		}

		/**
		 * Perform Java coding.
		 * @param first true if coding the first when-part
		 */
		public void doCoding(final boolean first) {
			ASSERT_SEMANTICS_CHECKED();
			connectionBlock.doJavaCoding();
		}

//		/**
//		 * Utility print method.
//		 * @param indent the indent
//		 */
//		public void print(final int indent) {
//	    	String spc=edIndent(indent);
//			Util.println(spc + "DO ");
//			connectionBlock.print(indent);
//		}

		/**
		 * Utility print method.
		 * @param indent the indent
		 */
		public void printTree(final int indent) {
	    	String spc=edTreeIndent(indent);
			Util.println(spc + "DO ");
			connectionBlock.printTree(indent);
		}

		@Override
		public String toString() {
			return (connectionBlock.toString());
		}
	}

	/**
	 * Utility class to hold a when-part.
	 */
	private final class WhenPart extends DoPart {
		/**
		 *  The WHEN class-identifier
		 */
		String classIdentifier;
		
		/**
		 * The class declaration correspondig to the class identifier.
		 * Set during checking.
		 */
		ClassDeclaration classDeclaration;
		
		/**
		 * Indicator to signal an impossible when-part.
		 * Set during checking if object-expression is not compatible with the WHEN class.
		 */
		boolean impossibleWhenPart; // Set by doChecking

		/**
		 * Create a new when-part.
		 * @param classIdentifier the WHEN class-identifier
		 * @param connectionBlock The associated connection block
		 * @param statement the statement after DO
		 */
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
			if (!AssignmentOperation.checkCompatibility(objectExpression, classIdentifier)) {
				Util.warning("Impossible When Part: " + objectExpression + " is not compatible with " + classIdentifier);
				impossibleWhenPart = true;
			}
			connectionBlock.doChecking();
		}

		@Override
		public void doCoding(final boolean first) {
			ASSERT_SEMANTICS_CHECKED();
			String prfx = (first) ? "" : "else ";
			String cid = classDeclaration.getJavaIdentifier();
			if (!impossibleWhenPart) {
				GeneratedJavaClass.code(prfx + "if(" + inspectedVariable.toJavaCode() + " instanceof " + cid + ") {","WHEN "	+ cid + " DO ");
				connectionBlock.doJavaCoding();
				GeneratedJavaClass.code("}");
			} else
				GeneratedJavaClass.code(prfx,"WHEN " + cid + " DO -- IMPOSSIBLE REMOVED");
		}

//		@Override
//		public void print(final int indent) {
//	    	String spc=edIndent(indent);
//			Util.println(spc + "WHEN " + classIdentifier + " DO ");
//			connectionBlock.printTree(indent);
//		}

		@Override
		public String toString() {
			return ("WHEN " + classIdentifier + " DO ..."); // +statement);
		}
	}

	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
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
		ASSERT_SEMANTICS_CHECKED();
		GeneratedJavaClass.code("{");
		GeneratedJavaClass.debug("// BEGIN INSPECTION ");
		Expression assignment = new AssignmentOperation(inspectedVariable, KeyWord.ASSIGNREF, objectExpression);
		assignment.doChecking();
		GeneratedJavaClass.code(assignment.toJavaCode() + ';');
		if (!hasWhenPart) GeneratedJavaClass.code("if(" + inspectedVariable.toJavaCode() + "!=null) {","INSPECT " + inspectedVariable);
		boolean first = true;
		for(DoPart part:connectionPart) { part.doCoding(first);	first = false; }
		if (!hasWhenPart) GeneratedJavaClass.code("}");
		if (otherwise != null) {
			GeneratedJavaClass.code("else {","OTHERWISE ");
			otherwise.doJavaCoding();
			GeneratedJavaClass.code("}","END OTHERWISE ");
		}
		// JavaModule.debug("// END INSPECTION ");
		GeneratedJavaClass.code("}","END INSPECTION");
	}
	
	@Override
	public void printTree(final int indent) {
		System.out.println(edTreeIndent(indent)+"INSPECT " + inspectedVariable);
		for (DoPart doPart : connectionPart) doPart.printTree(indent+1);
		if(otherwise != null) {
			System.out.println(edTreeIndent(indent)+"OTHERWISE");
			otherwise.printTree(indent+1);
		}
	}

	// ***********************************************************************************************
	// *** Printing Utility: print
	// ***********************************************************************************************
	@Override
	public void print(final int indent) {
    	String spc=edIndent(indent);
		// if(assignment!=null) assignment.print(indent);
		Util.println(spc + "INSPECT " + inspectedVariable);
		for (DoPart doPart : connectionPart) doPart.printTree(indent);
		if (otherwise != null) Util.println(spc + "   OTHERWISE " + otherwise + ';');
	}

	@Override
	public String toString() {
		String otherwisePart = (otherwise == null)?"":" OTHERWISE " + otherwise;
		return ("INSPECT " + inspectedVariable + " " + connectionPart + otherwisePart);
	}

}
