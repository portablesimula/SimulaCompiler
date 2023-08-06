/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import java.util.Vector;

import simula.compiler.SyntaxClass;
import simula.compiler.parsing.Parse;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Declaration.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 * Declaration = TypeDeclaration | ArrayDeclaration | SwitchDeclaration
 *             | ProcedureDeclaration | ClassDeclaration | ExternalDeclaration
 *             
 *		TypeDeclaration = Type IdentifierList
 *
 *   	Type ::= BOOLEAN | CHARACTER | INTEGER | REAL | REF(ClassIdentifier) | TEXT
 * </pre>
 * 
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/declaration/Declaration.java"><b>Source
 * File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 */
public abstract sealed class Declaration extends SyntaxClass
permits DeclarationScope, ExternalDeclaration, Parameter, SimpleVariableDeclaration,
        VirtualSpecification, VirtualMatch, ArrayDeclaration {

	/**
	 * Indicates that this declaration is protected.
	 */
	protected ProtectedSpecification isProtected; // Set during Checking

	/**
	 * Simula Identifier from Source Text
	 */
	public String identifier;

	/**
	 * External Identifier set by doChecking
	 */
	public String externalIdent;

	/**
	 * The DeclarationScope in which this Declaration is defined.
	 */
	public DeclarationScope declaredIn;

	/**
	 * The declarationKind.
	 */
	public Kind declarationKind;

	/**
	 * The declarationKind
	 *
	 */
	public enum Kind {
		/**
		 * Standard Class.
		 */
		StandardClass,
		/**
		 * Connection Block.
		 */
		ConnectionBlock,
		/**
		 * Compound Statement.
		 */
		CompoundStatement,
		/**
		 * Subblock.
		 */
		SubBlock,
		/**
		 * Normal Simula Procedure implemented as a Java Class
		 */
		Procedure, // Normal Simula Procedure implemented as a Java Class
		/**
		 * Procedure coded as a Java Member Method.
		 */
		MemberMethod, // Procedure coded as a Java Member Method.
		/**
		 * Procedure treated as a Java Static Method.
		 */
		ContextFreeMethod, // Treated as a Java Static Method.
		/**
		 * Class.
		 */
		Class,
		/**
		 * Prefixed Block.
		 */
		PrefixedBlock,
		/**
		 * Simula Program.
		 */
		SimulaProgram,

		/**
		 * Array Declaration.
		 */
		ArrayDeclaration,

		/**
		 * Virtual Specification.
		 */
		VirtualSpecification,

		/**
		 * Virtual Match.
		 */
		VirtualMatch,
		/**
		 * Parameter.
		 */
		Parameter,
		/**
		 * Label Declaration
		 */
		LabelDeclaration,
		/**
		 * Simple Variable Declaration.
		 */
		SimpleVariableDeclaration,
		/**
		 * External Declaration.
		 */
		ExternalDeclaration,
	}

	// ***********************************************************************************************
	// *** Constructor
	// ***********************************************************************************************
	/**
	 * Create a new Declaration.
	 * 
	 * @param identifier the given identifier
	 */
	protected Declaration(final String identifier) {
		this.identifier = identifier;
		this.externalIdent = identifier; // May be overwritten in doChecking()
		declaredIn = Global.getCurrentScope();
		checkAlreadyDefined();
	}

	/**
	 * Returns the Java identifier for this declaration.
	 * 
	 * @return the Java identifier for this declaration
	 */
	public final String getJavaIdentifier() {
		return (this.externalIdent);
	} // May be redefined

	/**
	 * Modify the identifier of this class.
	 * 
	 * @param newIdentifier the new identifier
	 */
	protected void modifyIdentifier(final String newIdentifier) {
		this.identifier = newIdentifier;
		checkAlreadyDefined();
	}

	private void checkAlreadyDefined() {
		boolean error = false;
		boolean warning = false;
		if (identifier == null)
			return;
		if (declaredIn == null)
			return;
		if (declaredIn instanceof StandardClass)
			return;
		if (declaredIn instanceof StandardProcedure)
			return;
		Vector<Parameter> parameterList;
		if (declaredIn instanceof ProcedureDeclaration proc)
			parameterList = proc.parameterList;
		else if (declaredIn instanceof ClassDeclaration cls)
			parameterList = cls.parameterList;
		else
			parameterList = null; // No parameters

		if (parameterList != null) {
			for (Declaration decl : parameterList)
				if (Util.equals(decl.identifier, identifier)) {
					warning = true;
					break;
				}
		}
		LOOP: for (Declaration decl : declaredIn.declarationList) {
			if (decl == null)
				return; // Error recovery
			if (decl.identifier == null)
				return; // Error recovery
			if (Util.equals(decl.identifier, identifier)) {
				error = true;
				break LOOP;
			}
		}
		if (error)
			Util.error(identifier + " is alrerady defined in " + declaredIn.identifier);
		else if (warning)
			Util.warning(identifier + " is alrerady defined in " + declaredIn.identifier);
	}

	/**
	 * Parse a declaration and add it to the given declaration list.
	 * 
	 * @param declarationList the given declaration list
	 * @return true if a declaration was found, false otherwise
	 */
	protected static boolean parseDeclaration(final DeclarationList declarationList) {
		if (Option.TRACE_PARSE)
			Parse.TRACE("Parse Declaration");
		String prefix = Parse.acceptIdentifier();
		if (prefix != null) {
			if (Parse.accept(KeyWord.CLASS))
				declarationList.add(ClassDeclaration.doParseClassDeclaration(prefix));
			else {
				Parse.saveCurrentToken(); // Identifier is NOT a class prefix.
				return (false);
			}
		} else if (Parse.accept(KeyWord.ARRAY))
			ArrayDeclaration.parse(Type.Real, declarationList); // Default type real for arrays
		else if (Parse.accept(KeyWord.PROCEDURE))
			declarationList.add(ProcedureDeclaration.doParseProcedureDeclaration(null));
		else if (Parse.accept(KeyWord.PRIOR)) {
			Util.warning("Keyword 'prior' ignored - prior procedure is not implemented");
			Type type = Parse.acceptType();
			Parse.expect(KeyWord.PROCEDURE);
			declarationList.add(ProcedureDeclaration.doParseProcedureDeclaration(type));
		} else if (Parse.accept(KeyWord.CLASS))
			declarationList.add(ClassDeclaration.doParseClassDeclaration(null));
		else if (Parse.accept(KeyWord.SWITCH)) {
			String ident = Parse.acceptIdentifier();
			if (ident == null) {
				// Switch Statement
				Parse.saveCurrentToken();
				return (false);
			}
			declarationList.add(new SwitchDeclaration(ident));
		} else if (Parse.accept(KeyWord.EXTERNAL))
			ExternalDeclaration.doParse(declarationList);
		else {
			Type type = Parse.acceptType();
			if (type == null)
				return (false);
			SimpleVariableDeclaration.parse(type, declarationList);
			if (Option.TRACE_PARSE)
				Parse.TRACE("Parse Declaration(2)");
		}
		return (true);
	}

	// ***********************************************************************************************
	// *** Utility: isCompatibleClasses -- Used by IS/IN/QUA-checking and Inspect WHEN
	// ***********************************************************************************************
	/**
	 * Check if these classes are isCompatible.
	 * 
	 * @param other the other ClassDeclaration
	 * @return the resulting boolean value
	 */
	public boolean isCompatibleClasses(final Declaration other) {
		if (!(this instanceof ClassDeclaration))
			Util.error("" + this + " is not a class");
		if (!(other instanceof ClassDeclaration))
			Util.error("" + other + " is not a class");

		if (((ClassDeclaration) this).isSubClassOf((ClassDeclaration) other))
			return (true);
		return (((ClassDeclaration) other).isSubClassOf((ClassDeclaration) this));
	}

}
