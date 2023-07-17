/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.parsing.Parse;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Virtual Quantities.
 * <pre>
 *    VirtualPart  =  VIRTUAL  :  VirtualSpec  ;  {  VirtualSpec  ;  }
 *    VirtualSpec  =  VirtualSpecifier  IdentifierList
 *        |  PROCEDURE  ProcedureIdentifier  IS  ProcedureDeclaration
 *        
 *   	VirtualSpecifier = LABEL | SWITCH |  [ type ] PROCEDURE
 *    	IdentifierList  =  Identifier  { , Identifier }
 *
 * </pre>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/declaration/VirtualSpecification.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class VirtualSpecification extends Declaration implements Externalizable {
	// String identifier; // Inherited
	// String externalIdent; // Inherited
	// Type type; // Inherited: Procedure's type if any

	/**
	 * Virtual Kind.
	 *
	 */
	public enum Kind {
		/**
		 * Virtual procedure.
		 */
		Procedure,
		/**
		 * Virtual label.
		 */
		Label,
		/**
		 * Virtual switch.
		 */
		Switch
	}

	/**
	 * Virtual kind.
	 */
	public Kind kind;
	
	/**
	 * The procedure specification if present.
	 */
	public ProcedureSpecification procedureSpec; // From: IS ProcedureSpecification
	
	/**
	 * Indicates if this virtual has a default match.
	 * <p>
	 * Set during doChecking
	 */
	boolean hasDefaultMatch;

	/**
	 * VirtualSpecification.
	 * @param identifier virtual identifier
	 * @param type the virtual's type
	 * @param kind the vitual Kind
	 * @param procedureSpec the ProcedureSpecification
	 */
	VirtualSpecification(final String identifier, final Type type, final Kind kind,
			final ProcedureSpecification procedureSpec) {
		super(identifier);
		this.declarationKind = Declaration.Kind.VirtualSpecification;
		this.externalIdent = identifier;
		this.type = type;
		this.kind = kind;
		this.procedureSpec = procedureSpec;
//		this.blockKind=BlockKind.Procedure;
	}

	/**
	 * Parse a VirtualSpecification and put it into the given block.
	 * @param block argument block
	 */
	static void parseInto(final ClassDeclaration block) {
		Parse.expect(KeyWord.COLON);
		LOOP: while (true) {
			Type type;
			if (Parse.accept(KeyWord.SWITCH)) {
				parseSimpleSpecList(block, Type.Label, Kind.Switch);
			} else if (Parse.accept(KeyWord.LABEL)) {
				parseSimpleSpecList(block, Type.Label, Kind.Label);
			} else {
				type = acceptType();
				if (!Parse.accept(KeyWord.PROCEDURE))
					break LOOP;

				String identifier = expectIdentifier();
				ProcedureSpecification procedureSpec = null;
				if (Parse.accept(KeyWord.IS)) {
					Type procedureType = acceptType();
					Parse.expect(KeyWord.PROCEDURE);
					procedureSpec = ProcedureSpecification.doParseProcedureSpecification(procedureType);
					block.virtualSpecList
							.add(new VirtualSpecification(identifier, type, Kind.Procedure, procedureSpec));
				} else {
					block.virtualSpecList.add(new VirtualSpecification(identifier, type, Kind.Procedure, null));
					if (Parse.accept(KeyWord.COMMA))
						parseSimpleSpecList(block, type, Kind.Procedure);
					else
						Parse.expect(KeyWord.SEMICOLON);
				}
			}
		}
	}

	private static void parseSimpleSpecList(final ClassDeclaration block, final Type type, final Kind kind) {
		do {
			String identifier = expectIdentifier();
			block.virtualSpecList.add(new VirtualSpecification(identifier, type, kind, null));
		} while (Parse.accept(KeyWord.COMMA));
		Parse.expect(KeyWord.SEMICOLON);
	}

	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())
			return;
		Global.sourceLineNumber = lineNumber;
		if (procedureSpec != null)
			procedureSpec.doChecking(this.declaredIn);
		// Label and switch attributes are implicit specified 'protected'
		if (kind == Kind.Label || kind == Kind.Switch)
			((ClassDeclaration) declaredIn).protectedList
					.add(new ProtectedSpecification((ClassDeclaration) declaredIn, identifier));
		SET_SEMANTICS_CHECKED();
	}

	public String getVirtualIdentifier() {
		ClassDeclaration specifiedIn = (ClassDeclaration) this.declaredIn;
		return (getJavaIdentifier() + '_' + specifiedIn.prefixLevel() + "()");
	}

	// ***********************************************************************************************
	// *** Utility: getVirtualSpecification
	// ***********************************************************************************************
	/**
	 * Get virtual specification.
	 * @param decl 
	 * @return
	 */
	public static VirtualSpecification getVirtualSpecification(final Declaration decl) {
		if (!(decl.declaredIn instanceof ClassDeclaration))
			return (null);
		ClassDeclaration scope = (ClassDeclaration) decl.declaredIn;
		VirtualSpecification virtSpec = scope.searchVirtualSpecList(decl.identifier);
		if (virtSpec != null)
			return (virtSpec);
		scope = scope.getPrefixClass();

		SEARCH: while (scope != null) {
			HiddenSpecification hdn = scope.searchHiddenList(decl.identifier);
			if (hdn != null) {
				scope = hdn.getScopeBehindHidden();
				continue SEARCH;
			}
			virtSpec = scope.searchVirtualSpecList(decl.identifier);
			if (virtSpec != null)
				return (virtSpec);
			scope = scope.getPrefixClass();
		}
		return (null);
	}

	@Override
	public void doJavaCoding() {
		ASSERT_SEMANTICS_CHECKED(this);
		String matchCode = "{ throw new _SimulaRuntimeError(\"No Virtual Match: " + identifier + "\"); }";
		String qnt = (kind == Kind.Label) ? "_LABQNT " : "_PRCQNT ";
		GeneratedJavaClass.code("public " + qnt + getVirtualIdentifier() + matchCode);
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (type != null)
			s.append(type).append(' ');
		if (kind == Kind.Procedure)
			s.append("PROCEDURE ");
		s.append(identifier);
		s.append("[Specified in ").append(declaredIn.identifier).append(']');
		if (procedureSpec != null)
			s.append('=').append(procedureSpec);
		return (s.toString());
	}

	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	/**
	 * Default constructor used by Externalization.
	 */
	public VirtualSpecification() {
		super(null);
		this.declarationKind = Declaration.Kind.VirtualSpecification;
	}

	@Override
	public void writeExternal(ObjectOutput oupt) throws IOException {
		Util.TRACE_OUTPUT("VirtualSpec: " + type + ' ' + identifier + ' ' + kind);
		oupt.writeObject(identifier);
		oupt.writeObject(externalIdent);
		oupt.writeObject(type);
		oupt.writeObject(kind);
		oupt.writeObject(procedureSpec);
	}

	@Override
	public void readExternal(ObjectInput inpt) throws IOException, ClassNotFoundException {
		identifier = (String) inpt.readObject();
		externalIdent = (String) inpt.readObject();
		type = Type.inType(inpt);
		kind = (Kind) inpt.readObject();
		procedureSpec = (ProcedureSpecification) inpt.readObject();
		Util.TRACE_INPUT("VirtualSpec: " + type + ' ' + identifier + ' ' + kind);
	}

}
