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
import simula.compiler.syntaxClass.HiddenSpecification;
import simula.compiler.syntaxClass.ProtectedSpecification;
import simula.compiler.syntaxClass.SyntaxClass;
import simula.compiler.syntaxClass.Type;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Util;

/**
 * Virtual Quantities.
 * <pre>
 * Simula Standard: 5.5.3 Virtual quantities
 * 
 *    virtual-part  =  VIRTUAL  :  virtual-spec  ;  {  virtual-spec  ;  }
 *    
 *    virtual-spec  =  virtual-specifier  identifier-list
 *                  |  PROCEDURE  procedure-identifier  procedure-specification
 *                  
 *      procedure-specification =  IS  procedure-declaration
 *        
 *   	virtual-specifier = LABEL | SWITCH |  [ type ] PROCEDURE
 *   
 *    	identifier-list  =  identifier  { , identifier }
 *
 * </pre>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/declaration/VirtualSpecification.java">
 * <b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
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
	 * Parse a virtual-part and put it into the given class.
	 * <pre>
	 * Syntax:
	 * 
	 *      virtual-part = VIRTUAL: virtual-spec ; { virtual-spec ; }
	 *         virtual-spec
	 *             = virtual-specifier identifier-list
	 *             | PROCEDURE procedure-identifier  procedure-specification
	 *             
	 *                virtual-Specifier = [ type ] PROCEDURE | LABEL | SWITCH
	 *                
	 *                identifier-list = identifier { , identifier }
	 *                
	 *                procedure-specification = IS procedure-declaration
	 *
	 * </pre>
	 * Precondition: VIRTUAL  is already read.
	 * @param cls the ClassDeclaration
	 */
	static void expectVirtualPart(final ClassDeclaration cls) {
		Parse.expect(KeyWord.COLON);
		LOOP: while (true) {
			Type type;
			if (Parse.accept(KeyWord.SWITCH)) {
				expectIdentifierList(cls, Type.Label, Kind.Switch);
			} else if (Parse.accept(KeyWord.LABEL)) {
				expectIdentifierList(cls, Type.Label, Kind.Label);
			} else {
				type = Parse.acceptType();
				if (!Parse.accept(KeyWord.PROCEDURE))
					break LOOP;

				String identifier = Parse.expectIdentifier();
				ProcedureSpecification procedureSpec = null;
				if (Parse.accept(KeyWord.IS)) {
					Type procedureType = Parse.acceptType();
					Parse.expect(KeyWord.PROCEDURE);
					procedureSpec = ProcedureSpecification.expectProcedureSpecification(procedureType);
					cls.virtualSpecList
							.add(new VirtualSpecification(identifier, type, Kind.Procedure, procedureSpec));
				} else {
					cls.virtualSpecList.add(new VirtualSpecification(identifier, type, Kind.Procedure, null));
					if (Parse.accept(KeyWord.COMMA))
						expectIdentifierList(cls, type, Kind.Procedure);
					else
						Parse.expect(KeyWord.SEMICOLON);
				}
			}
		}
		if(cls.virtualSpecList.size()==0) Util.error("Missing virtual specifier after VIRTUAL:");
	}

	/**
	 * Parse a virtual identifier list.
	 * <pre>
	 * Syntax:
	 * 
	 *        identifier-list = identifier { , identifier
	 * </pre>
	 * @param cls the ClassDeclaration
	 * @param type the specifiers type
	 * @param kind the specifiers kind
	 */
	private static void expectIdentifierList(final ClassDeclaration cls, final Type type, final Kind kind) {
		do {
			String identifier = Parse.expectIdentifier();
			cls.virtualSpecList.add(new VirtualSpecification(identifier, type, kind, null));
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

	/**
	 * Returns the virtual identifier used i Java code.
	 * @return the virtual identifier used i Java code
	 */
	public String getVirtualIdentifier() {
		ClassDeclaration specifiedIn = (ClassDeclaration) this.declaredIn;
		return (getJavaIdentifier() + '_' + specifiedIn.prefixLevel() + "()");
	}

	// ***********************************************************************************************
	// *** Utility: getVirtualSpecification
	// ***********************************************************************************************
	/**
	 * Get virtual specification.
	 * @param decl the declaration to search for
	 * @return a VirtualSpecification or null
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
		ASSERT_SEMANTICS_CHECKED();
		String matchCode = "{ throw new RTS_SimulaRuntimeError(\"No Virtual Match: " + identifier + "\"); }";
		String qnt = (kind == Kind.Label) ? "RTS_LABEL " : "RTS_PRCQNT ";
		GeneratedJavaClass.code("public " + qnt + getVirtualIdentifier() + matchCode);
	}

	public void printTree(int indent) {
		System.out.println(SyntaxClass.edIndent(indent)+this.getClass().getSimpleName()+"    "+this);
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
