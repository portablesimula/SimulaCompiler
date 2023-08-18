/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass.declaration;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import simula.compiler.GeneratedJavaClass;
import simula.compiler.parsing.Parse;
import simula.compiler.syntaxClass.Type;
import simula.compiler.syntaxClass.expression.Constant;
import simula.compiler.syntaxClass.expression.Expression;
import simula.compiler.syntaxClass.expression.TypeConversion;
import simula.compiler.utilities.DeclarationList;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Simple Variable Declaration.
 * 
 * <pre>
 * 
 * Simula Standard: 5.1 Simple variable declarations
 * 
 *  simple-variable-declaration
 *        =  type  type-list
 *
 *    type-list
 *        =  type-list-element  { , type-list-element }
 *
 *    type-list-element
 *        =  identifier
 *        |  constant-element 
 * 
 *    constant-element
 *        =  identifier  "="  value-expression
 *        |  identifier  "="  text-expression
 *   
 * </pre>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/declaration/SimpleVariableDeclaration.java">
 * <b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 */
public sealed class SimpleVariableDeclaration extends Declaration implements Externalizable permits LabelDeclaration {
	// String identifier; // Inherited
	// String externalIdent; // Inherited
	// Type type; // Inherited

	/**
	 * Constant indicator. Is used to prevent assignment of a new value.
	 */
	private boolean constant;

	/**
	 * The constant initial value.
	 */
	public Expression constantElement;

	/**
	 * Create a new SimpleVariableDeclaration.
	 * 
	 * @param type       the variable type
	 * @param identifier the variable identifier
	 */
	public SimpleVariableDeclaration(final Type type, final String identifier) {
		super(identifier);
		this.declarationKind = Declaration.Kind.SimpleVariableDeclaration;
		this.type = type;
	}

	/**
	 * Create a new SimpleVariableDeclaration.
	 * 
	 * @param type            the variable type
	 * @param identifier      the variable identifier
	 * @param constant        the constant indicator
	 * @param constantElement a constant initial value
	 */
	SimpleVariableDeclaration(final Type type, final String identifier, final boolean constant,
			final Constant constantElement) {
		this(type, identifier);
		this.constant = constant;
		this.constantElement = constantElement;
	}

	/**
	 * Constant indicator. Is used to prevent assignment of a new value.
	 * 
	 * @return the constant indicator
	 */
	public boolean isConstant() {
		return (constant || constantElement != null);
	}

	/**
	 * Parse a simple variable declaration.
	 * <pre>
	 * 
	 * Syntax:
	 * 
	 *  simple-variable-declaration
	 *        =  type  type-list
	 *
	 *    type-list
	 *        =  type-list-element  { , type-list-element }
	 *
	 *    type-list-element
	 *        =  identifier
	 *        |  constant-element 
	 * 
	 *    constant-element
	 *        =  identifier  "="  value-expression
	 *        |  identifier  "="  text-expression
	 *   
	 * </pre>
	 * Precodition: Type  is already read.
	 * @param type            the variable type
	 * @param declarationList the declaration list to update
	 */
	static void expectSimpleVariable(final Type type, final DeclarationList declarationList) {
		// identifier-list = identifier { , identifier }
		if (Option.TRACE_PARSE)
			Parse.TRACE("Parse IdentifierList");
			do {
				String ident = Parse.expectIdentifier();
				SimpleVariableDeclaration typeDeclaration = new SimpleVariableDeclaration(type, ident);
				if (Parse.accept(KeyWord.EQ))
					typeDeclaration.constantElement = Expression.expectExpression();
				declarationList.add(typeDeclaration);
			} while (Parse.accept(KeyWord.COMMA));
	}

	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())
			return;
		Global.sourceLineNumber = lineNumber;
		type.doChecking(Global.getCurrentScope());
		if (constantElement != null) {
			constantElement.doChecking();
			constantElement = TypeConversion.testAndCreate(type, constantElement);
			constantElement.type = type;
			constantElement.backLink = this;
		}
		if (Global.getCurrentScope() instanceof ClassDeclaration cls) {
			if (cls.prefixLevel() > 0)
				externalIdent = identifier + '_' + cls.prefixLevel();
			else
				externalIdent = identifier;
		}
		SET_SEMANTICS_CHECKED();
	}

	@Override
	public void doDeclarationCoding() {
		if (constantElement != null && !(constantElement instanceof Constant)) {
			// Initiate Final Variable
			String value = constantElement.toJavaCode();
			GeneratedJavaClass.code(getJavaIdentifier() + '=' + value + ';');
		}
	}

	@Override
	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED();
		String modifier = "public ";
		if (this.isConstant())
			modifier = modifier + "final ";
		if (constantElement != null) {
			constantElement = TypeConversion.testAndCreate(type, constantElement.evaluate());
			constantElement.doChecking();
			if (constantElement instanceof Constant) {
				String value = constantElement.toJavaCode();
				String putValue = TypeConversion.mayBeConvert(constantElement.type, type, value);
				return (modifier + type.toJavaType() + ' ' + getJavaIdentifier() + putValue);
			} else {
				return (modifier + type.toJavaType() + ' ' + getJavaIdentifier() + ';');
			}
		}
		String value = type.edDefaultValue();
		return (modifier + type.toJavaType() + ' ' + getJavaIdentifier() + '=' + value + ';');
	}
	
	@Override
	public void printTree(final int indent) {
		System.out.println(edTreeIndent(indent)+this);
	}

	@Override
	public String toString() {
		String s = "" + type + ' ' + identifier;
		if (constantElement != null)
			s = s + " = " + constantElement.toString();
		return (s);
	}

	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	/**
	 * Default constructor used by Externalization.
	 */
	public SimpleVariableDeclaration() {
		super(null);
		this.declarationKind = Declaration.Kind.SimpleVariableDeclaration;
	}

	@Override
	public void writeExternal(ObjectOutput oupt) throws IOException {
		Util.TRACE_OUTPUT(
				"Variable: " + type + ' ' + identifier + ", constant=" + isConstant() + ", const=" + constantElement);
		oupt.writeObject(identifier);
		oupt.writeObject(externalIdent);
		oupt.writeObject(type);
		oupt.writeBoolean(isConstant());
		if (constantElement instanceof Constant)
			oupt.writeObject(constantElement);
		else
			oupt.writeObject(null);
	}

	@Override
	public void readExternal(ObjectInput inpt) throws IOException, ClassNotFoundException {
		identifier = (String) inpt.readObject();
		externalIdent = (String) inpt.readObject();
		type = Type.inType(inpt);
		constant = inpt.readBoolean();
		constantElement = (Constant) inpt.readObject();
		Util.TRACE_INPUT("Variable: " + type + ' ' + identifier + ", constant=" + constant + ", constantElement="
				+ constantElement);
	}
}
