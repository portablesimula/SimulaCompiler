/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.syntaxClass.declaration.Declaration;
import simula.compiler.syntaxClass.expression.Expression;
import simula.compiler.syntaxClass.statement.Statement;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Util;

/**
 * The class SyntaxClass.
 * <p>
 * The Simula syntax is formally defined in the Simula Standard.
 * Some non-terminal symbols give rise to a Java class with almost the same name.
 * They are all subclasses of the class SyntaxClass.
 * The subclass hierarchy of the Syntax class is described below
 * 
 * <pre>
 *            SyntaxClass
 *               HiddenSpecification 
 *               ProtectedSpecification 
 *               Type 
 *                  OverLoad
 *               Declaration
 *                  ArrayDeclaration 
 *                  DeclarationScope
 *                     BlockDeclaration
 *                        ClassDeclaration 
 *                           PrefixedBlockDeclaration
 *                           StandardClass
 *                        MaybeBlockDeclaration
 *                        ProcedureDeclaration 
 *                           StandardProcedure
 *                           SwitchDeclaration
 *                     ConnectionBlock 
 *                  ExternalDeclaration
 *                  Parameter 
 *                  SimpleVariableDeclaration 
 *                     LabelDeclaration 
 *                  VirtualMatch 
 *                  VirtualSpecification 
 *               Statement
 *                  ActivationStatement
 *                  BlockStatement
 *                  ConditionalStatement
 *                  ConnectionStatement
 *                  DummyStatement
 *                  ForStatement
 *                  GotoStatement
 *                  InnerStatement
 *                  LabeledStatement
 *                  ProgramModule
 *                  StandaloneExpression
 *                  SwitchStatement
 *                  WhileStatement
 *               Expression
 *                  ArithmeticExpression
 *                  AssignmentOperation
 *                  BooleanExpression
 *                  ConditionalExpression
 *                  Constant 
 *                  LocalObject
 *                  ObjectGenerator
 *                  ObjectRelation
 *                  QualifiedObject
 *                  RelationalOperation
 *                  RemoteVariable
 *                  TextExpression
 *                  TypeConversion
 *                  UnaryOperation
 *                  VariableExpression          
 * </pre>
 * 
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/SyntaxClass.java"><b>Source
 * File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 */

public abstract sealed class SyntaxClass permits Declaration, Statement, Expression, HiddenSpecification, ProtectedSpecification, Type {
	/**
	 * Controls semantic checking.
	 * <p>
	 * Set true when the method doChecking() has been completed.
	 */
	private boolean CHECKED = false;

	/**
	 * The source line number
	 */
	public int lineNumber;

	/**
	 * Create a new SyntaxClass.
	 */
	protected SyntaxClass() {
		lineNumber = Global.sourceLineNumber;
	}

	/**
	 * Perform semantic checking.
	 * <p>
	 * This must be redefined in every subclass.
	 */
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())
			return;
		Global.sourceLineNumber = lineNumber;
		String name = this.getClass().getSimpleName();
		Util.IERR("*** NOT IMPLEMENTED: " + "" + name + ".doChecking");
	}

	/**
	 * Set semantic checked.
	 * <p>
	 * Should be called from all doChecking methods to signal that semantic
	 * checking is done.
	 */
	protected void SET_SEMANTICS_CHECKED() {
		CHECKED = true;
	}

	/**
	 * Returns true if semantic checking is done.
	 * 
	 * @return true if semantic checking is done
	 */
	protected boolean IS_SEMANTICS_CHECKED() {
		return (CHECKED);
	}

	/**
	 * Assert that semantic checking done.
	 */
	protected void ASSERT_SEMANTICS_CHECKED() {
		if (!CHECKED)
			Util.error("FATAL error - Semantic checker not called: " + this.getClass().getName() + ", " + this);
		if (this instanceof Declaration decl) {
			if (decl.externalIdent == null)
				Util.error("External Identifier is not set");
		}
	}

	/**
	 * Output possible declaration code.
	 */
	public void doDeclarationCoding() {
	}

	/**
	 * Output Java code.
	 */
	public void doJavaCoding() {
		Global.sourceLineNumber = lineNumber;
		GeneratedJavaClass.code(toJavaCode());
	}

	/**
	 * Generate Java code for this Syntax Class.
	 * 
	 * @return Java code
	 */
	public String toJavaCode() {
		return (toString());
	}

	/**
	 * Utility print method.
	 * 
	 * @param indent number of spaces leading the line
	 */
	public void print(final int indent) {
		Util.println(edIndent(indent) + this);
	}

	/**
	 * Utility print syntax tree method.
	 * 
	 * @param indent number of spaces leading the lines
	 */
	public void printTree(final int indent) {
		Util.IERR("Method printTree need a redefinition in "+this.getClass().getSimpleName());
	}

	/**
	 * Utility: Returns a number of blanks followed by qualification of this
	 * 
	 * @param indent the number of blanks requested
	 * @return the resulting string
	 */
	protected String edTreeIndent(final int indent) {
		int i = indent;
		String s = "";
		while ((i--) > 0)
			s = s + "    ";
		return (s+this.getClass().getSimpleName()+"    ");
	}

	/**
	 * Utility: Returns a number of blanks.
	 * 
	 * @param indent the number of blanks requested
	 * @return a number of blanks.
	 */
	public static String edIndent(final int indent) {
		int i = indent;
		String s = "";
		while ((i--) > 0)
			s = s + "    ";
		return (s);
	}

}
