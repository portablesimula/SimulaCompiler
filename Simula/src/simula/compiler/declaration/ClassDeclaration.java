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
import java.util.Iterator;
import java.util.Vector;

import simula.compiler.JavaModule;
import simula.compiler.CodeLine;
import simula.compiler.parsing.Parser;
import simula.compiler.statement.InnerStatement;
import simula.compiler.statement.Statement;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public class ClassDeclaration extends BlockDeclaration implements Externalizable {
	public String prefix; // Class Prefix in case of a SubClass or Prefixed Block.
	public boolean detachUsed = false; // Set true when attribute procedure 'detach' is used in/on this class.
	public Vector<Parameter> parameterList = new Vector<Parameter>();
	public Vector<VirtualSpecification> virtualSpecList = new Vector<VirtualSpecification>();
	public Vector<VirtualMatch> virtualMatchList = new Vector<VirtualMatch>();
	public Vector<ProtectedSpecification> protectedList = new Vector<ProtectedSpecification>();
	public Vector<HiddenSpecification> hiddenList = new Vector<HiddenSpecification>();
	public Vector<CodeLine> code1; // Statement code before inner
	public Vector<CodeLine> code2; // Statement code after inner

	// ***********************************************************************************************
	// *** CONSTRUCTORS
	// ***********************************************************************************************
//	protected ClassDeclaration(final String identifier,final  BlockKind blockKind) {
//		super(DeclarationKind.ClassDeclaration,identifier);
//		this.blockKind = blockKind;
//	}

	public ClassDeclaration(String identifier) {
		super(identifier);
		this.declarationKind=Declaration.Kind.Class;
	}

	// ***********************************************************************************************
	// *** Parsing: doParseClassDeclaration
	// ***********************************************************************************************
	/**
	 * Class Declaration.
	 * 
	 * <pre>
	 * 
	 * Syntax:
	 * 
	 * ClassDeclaration = [ Prefix ] MainPart
	 * 
	 *	Prefix = ClassIdentifier
	 *
	 *    MainPart = CLASS ClassIdentifier  ClassHead  ClassBody
	 *		ClassIdentifier = Identifier
	 *
	 *		ClassHead = [ FormalParameterPart ; [ ValuePart ] SpecificationPart ] ;
	 *				    [ ProtectionPart ; ] [ VirtualPart ]
	 *
	 *			FormalParameterPart = "(" FormalParameter { , FormalParameter } ")"
	 *				FormalParameter = Identifier
	 *
	 *			ValuePart = VALUE IdentifierList
	 *
	 *			SpecificationPart = ClassParameterSpecifier  IdentifierList ; { ClassParameterSpecifier  IdentifierList ; }
	 *				ClassParameterSpecifier = Type | [Type] ARRAY 
	 *
	 *			ProtectionPart = ProtectionSpecification { ; ProtectionSpecification }
	 *				ProtectionSpecification = HIDDEN IdentifierList | HIDDEN PROTECTED IdentifierList
	 *										| PROTECTED IdentifierList | PROTECTED HIDDEN IdentifierList
	 *
	 *			VirtualPart = VIRTUAL: virtual-specification-part
	 *				VirtualSpecificationPart = VirtualSpecification ; { VirtualSpecification ; }
	 *					VirtualSpecification = VirtualSpecifier IdentifierList
	 *						VirtualSpecifier = [ type ] PROCEDURE | LABEL | SWITCH
	 *
	 *		ClassBody = SplitBody | Statement
	 *			SplitBody = BEGIN [ { Declaration ; } ]  [ { Statement ; } ] InnerPart  [ { Statement ; } ] 
	 *				InnerPart = [ Label : ] INNER ;
	 *
	 * </pre>
	 */
	public static ClassDeclaration doParseClassDeclaration(final String prefix) {
		ClassDeclaration block = new ClassDeclaration(null);
		block.prefix = prefix;
		block.declaredIn.hasLocalClasses = true;
		if (block.prefix == null)
			block.prefix = StandardClass.CLASS.identifier;
		block.modifyIdentifier(expectIdentifier());
		if (Parser.accept(KeyWord.BEGPAR)) {
			do { // ParameterPart = Parameter ; { Parameter ; }
				new Parameter(expectIdentifier()).into(block.parameterList);
			} while (Parser.accept(KeyWord.COMMA));
			Parser.expect(KeyWord.ENDPAR);
			Parser.expect(KeyWord.SEMICOLON);
			// ModePart = ValuePart [ NamePart ] | NamePart [ ValuePart ]
			// ValuePart = VALUE IdentifierList ;
			// NamePart = NAME IdentifierList ;
			if (Parser.accept(KeyWord.VALUE)) {
				expectModeList(block, block.parameterList, Parameter.Mode.value);
				Parser.expect(KeyWord.SEMICOLON);
			}
			// ParameterPart = Parameter ; { Parameter ; }
			// Parameter = Specifier IdentifierList
			// Specifier = Type [ ARRAY | PROCEDURE ] | LABEL | SWITCH
			while (acceptClassParameterSpecifications(block, block.parameterList)) {
				Parser.expect(KeyWord.SEMICOLON);
			}
		} else
			Parser.expect(KeyWord.SEMICOLON);

		// ProtectionPart = ProtectionParameter { ; ProtectionParameter }
		// ProtectionParameter = HIDDEN IdentifierList | HIDDEN PROTECTED IdentifierList
		// | PROTECTED IdentifierList | PROTECTED HIDDEN IdentifierList
		while (true) {
			if (Parser.accept(KeyWord.HIDDEN)) {
				if (Parser.accept(KeyWord.PROTECTED))
					expectHiddenProtectedList(block, true, true);
				else
					expectHiddenProtectedList(block, true, false);
			} else if (Parser.accept(KeyWord.PROTECTED)) {
				if (Parser.accept(KeyWord.HIDDEN))
					expectHiddenProtectedList(block, true, true);
				else
					expectHiddenProtectedList(block, false, true);
			} else
				break;
		}
		// VirtualPart = VIRTUAL: virtual-specification-part
		// VirtualParameterPart = VirtualParameter ; { VirtualParameter ; }
		// VirtualParameter = VirtualSpecifier IdentifierList
		// VirtualSpecifier = [ type ] PROCEDURE | LABEL | SWITCH
		if (Parser.accept(KeyWord.VIRTUAL))
			VirtualSpecification.parseInto(block);

		if (Parser.accept(KeyWord.BEGIN))
			doParseBody(block);
		else {
			block.statements.add(Statement.doParse());
			block.statements.add(new InnerStatement()); // Implicit INNER
		}
		block.lastLineNumber = Global.sourceLineNumber;
		block.type = Type.Ref(block.identifier);
		if (Option.TRACE_PARSE)	Parser.TRACE("Parse ClassDeclaration");
		if (Option.TRACE_PARSE)	Util.TRACE("END ClassDeclaration: " + block);
		Global.currentScope = block.declaredIn;
		return (block);
	}
	
	// ***********************************************************************************************
	// *** PARSING: expectModeList
	// ***********************************************************************************************
	private static void expectModeList(final BlockDeclaration block, final Vector<Parameter> parameterList,final Parameter.Mode mode) {
		do {
			String identifier = expectIdentifier();
			Parameter parameter = null;
			for (Parameter par : parameterList)
				if (identifier.equalsIgnoreCase(par.identifier)) {
					parameter = par;
					break;
				}
			if (parameter == null) {
				Util.error("Identifier " + identifier + " is not defined in this scope");
				parameter = new Parameter(identifier);
			}
			parameter.setMode(mode);
		} while (Parser.accept(KeyWord.COMMA));
	}
	
	// ***********************************************************************************************
	// *** PARSING: acceptClassParameterSpecifications
	// ***********************************************************************************************
	private static boolean acceptClassParameterSpecifications(final BlockDeclaration block,final Vector<Parameter> parameterList) {
		// ClassParameter = ClassParameterSpecifier IdentifierList
		// ClassParameterSpecifier = Type | [Type] ARRAY 
		if (Option.TRACE_PARSE)
			Parser.TRACE("Parse ParameterSpecifications");
		Type type;
		Parameter.Kind kind = Parameter.Kind.Simple;
		type = acceptType();
		if (Parser.accept(KeyWord.ARRAY)) {
			if (type == null) {
				// See Simula Standard 5.2 -
				// If no type is given the type real is understood.
				type=Type.Real;
			}
			kind = Parameter.Kind.Array;
		}
		if (type == null) return (false);
		do {
			String identifier = expectIdentifier();
			Parameter parameter = null;
			for (Parameter par : parameterList)
				if (identifier.equalsIgnoreCase(par.identifier)) { parameter = par;	break; }
			if (parameter == null) {
				Util.error("Identifier " + identifier + " is not defined in this scope");
				parameter = new Parameter(identifier);
			}
			parameter.setTypeAndKind(type, kind);
		} while (Parser.accept(KeyWord.COMMA));
		return (true);
	}

	// ***********************************************************************************************
	// *** PARSING: expectHiddenProtectedList
	// ***********************************************************************************************
	private static boolean expectHiddenProtectedList(final ClassDeclaration block, final boolean hidden,final boolean prtected) {
		do {
			String identifier = expectIdentifier();
			if (hidden)	block.hiddenList.add(new HiddenSpecification(block, identifier));
			if (prtected) block.protectedList.add(new ProtectedSpecification(block, identifier));
		} while (Parser.accept(KeyWord.COMMA));
		Parser.expect(KeyWord.SEMICOLON);
		return (true);
	}

	// ***********************************************************************************************
	// *** PARSING: doParseBody
	// ***********************************************************************************************
	private static void doParseBody(final BlockDeclaration block) {
		Statement stm;
		if (Option.TRACE_PARSE)	Parser.TRACE("Parse Block");
		while (Declaration.parseDeclaration(block.declarationList)) {
			Parser.accept(KeyWord.SEMICOLON);
		}

		Statement inner = new InnerStatement();
		Vector<Statement> stmList = block.statements;
		while (!Parser.accept(KeyWord.END)) {
			stm = Statement.doParse();
			if (stm != null) stmList.add(stm);
			if (Parser.accept(KeyWord.INNER)) {
				if (inner == null) Util.error("Max one INNER per Block");
				else stmList.add(inner);
				inner = null;
			}
		}
		if (inner != null) stmList.add(inner); // Implicit INNER
	}

	// ***********************************************************************************************
	// *** Utility: isSubClassOf
	// ***********************************************************************************************
	/**
	 * Consider the class definitions:
	 * 
	 * <pre>
	 *  
	 *      Class A ......;
	 *    A Class B ......;
	 *    B Class C ......;
	 * </pre>
	 * 
	 * Then Class B is a subclass of Class A, While Class C is subclass of both B
	 * and A.
	 * 
	 * @param other
	 * @return Boolean true iff this class is a subclass of the 'other' class.
	 */
	public boolean isSubClassOf(final ClassDeclaration other) {
		ClassDeclaration prefixClass = getPrefixClass();
		if (prefixClass != null)
			do { if (other == prefixClass) return(true);
			} while ((prefixClass = prefixClass.getPrefixClass()) != null);
		return (false);
	}

	// ***********************************************************************************************
	// *** Checking
	// ***********************************************************************************************
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber = lineNumber;
		if (externalIdent == null) externalIdent = edJavaClassName();
		currentBlockLevel++;
		blockLevel = currentBlockLevel;
		Global.currentScope = this;
		ClassDeclaration prefixClass = null;
		if (!hasNoRealPrefix()) {
			prefixClass = getPrefixClass();
			if (prefixClass.declarationKind != Declaration.Kind.StandardClass) {
				if (sourceBlockLevel != prefixClass.sourceBlockLevel)
					Util.error("Subclass on a deeper block level not allowed.");
			}
		}
		int prfx = prefixLevel();
		for (Parameter par : this.parameterList) par.setExternalIdentifier(prfx);
		for (Declaration par : new ClassParameterIterator()) par.doChecking();
		for (VirtualSpecification vrt : virtualSpecList) vrt.doChecking();
		for (Declaration dcl : declarationList)	dcl.doChecking();
		for (Statement stm : statements) stm.doChecking();
		checkProtectedList();
		checkHiddenList();
		doCheckLabelList(prefixClass);
		Global.currentScope = declaredIn;
		currentBlockLevel--;
		SET_SEMANTICS_CHECKED();
	}

	// ***********************************************************************************************
	// *** Utility: checkHiddenList
	// ***********************************************************************************************
	private void checkHiddenList() {
		for (HiddenSpecification hdn : hiddenList)
			hdn.doChecking();
	}

	// ***********************************************************************************************
	// *** Utility: checkProtectedList
	// ***********************************************************************************************
	private void checkProtectedList() {
		for (ProtectedSpecification pct : protectedList) {
			pct.doChecking();
		}
	}

	// ***********************************************************************************************
	// *** Utility: searchVirtualSpecList -- - Search VirtualSpec-list for 'ident'
	// ***********************************************************************************************
	public VirtualSpecification searchVirtualSpecList(final String ident) {
		for (VirtualSpecification virtual : virtualSpecList) {
			if (ident.equalsIgnoreCase(virtual.identifier)) return (virtual);
		} return (null);
	}

	// ***********************************************************************************************
	// *** Utility: prefixLevel
	// ***********************************************************************************************
	public int prefixLevel() {
		if (hasNoRealPrefix()) return (0);
		ClassDeclaration prfx = getPrefixClass();
		if (prfx != null)
			return (prfx.prefixLevel() + 1);
		return (-1);
	}

	// ***********************************************************************************************
	// *** Utility: getNlabels
	// ***********************************************************************************************
	public int getNlabels() {
		if (hasNoRealPrefix())
			return (labelList.size());
		return (labelList.size() + getPrefixClass().getNlabels());
	}

	// ***********************************************************************************************
	// *** Utility: findClassAttribute
	// ***********************************************************************************************
	public Declaration findClassAttribute(final String ident) {
		ClassDeclaration scope = this;
		while (scope != null) {
			Declaration atr = scope.findLocalAttribute(ident);
			if (atr != null) return (atr);
			scope = scope.getPrefixClass();
		}
		return (null);
	}

	// ***********************************************************************************************
	// *** Utility: findLocalAttribute
	// ***********************************************************************************************
	public Declaration findLocalAttribute(final String ident) {
		for (Parameter parameter : parameterList)
			if (ident.equalsIgnoreCase(parameter.identifier)) return (parameter);
		for (Declaration declaration : declarationList)
			if (ident.equalsIgnoreCase(declaration.identifier))	return (declaration);
		for (LabelDeclaration label : labelList)
			if (ident.equalsIgnoreCase(label.identifier)) return (label);
		for (VirtualMatch match : virtualMatchList)
			if (ident.equalsIgnoreCase(match.identifier)) return (match);
		for (VirtualSpecification virtual : virtualSpecList)
			if (ident.equalsIgnoreCase(virtual.identifier))	return (virtual);
		// if(ident.equalsIgnoreCase("P")) Util.BREAK("ClassDeclaration("+identifier+").findLocalAttribute("+ident+"): NOT FOUND");
		return (null);
	}

	// ***********************************************************************************************
	// *** Utility: findLocalProcedure
	// ***********************************************************************************************
	public ProcedureDeclaration findLocalProcedure(final String ident) {
		for (Declaration decl : declarationList)
			if (ident.equalsIgnoreCase(decl.identifier)) {
				if (decl instanceof ProcedureDeclaration)
					 return ((ProcedureDeclaration) decl);
				else return (null);
			}
		return (null);
	}

	// ***********************************************************************************************
	// *** Utility: findRemoteAttributeMeaning
	// ***********************************************************************************************
	public Meaning findRemoteAttributeMeaning(final String ident) {
		boolean behindProtected = false;
		ClassDeclaration scope = this;
		Declaration decl = scope.findLocalAttribute(ident);
		if (decl != null) {
			boolean prtected = decl.isProtected != null;
			VirtualSpecification virtSpec = VirtualSpecification.getVirtualSpecification(decl);
			if (virtSpec != null && virtSpec.isProtected != null) prtected = true;
			if (!prtected) return(new Meaning(decl, this, scope, behindProtected));
		}
SEARCH: while (scope != null) {
			HiddenSpecification hdn = scope.searchHiddenList(ident);
			if (hdn != null) {
				scope = hdn.getScopeBehindHidden();
				behindProtected = true;
				continue SEARCH;
			}
			Declaration decl2 = scope.findLocalAttribute(ident);
			if (decl2 != null) {
				boolean prtected = decl2.isProtected != null;
				if (withinScope(scope)) prtected = false;
				if (!prtected) return(new Meaning(decl2, this, scope, behindProtected));
				behindProtected = true;
			}
			scope = scope.getPrefixClass();
		}
		return (null);
	}

	// ***********************************************************************************************
	// *** Utility: searchProtectedList - Search Protected-list for 'ident'
	// ***********************************************************************************************
	public ProtectedSpecification searchProtectedList(final String ident) {
		for (ProtectedSpecification pct : protectedList)
			if (ident.equalsIgnoreCase(pct.identifier))	return (pct);
		return (null);
	}

	// ***********************************************************************************************
	// *** Utility: withinScope -- Used by findRemoteAttributeMeaning
	// ***********************************************************************************************
	private static boolean withinScope(final DeclarationScope otherScope) {
		DeclarationScope scope = Global.currentScope;
		while (scope != null) {
			if (scope == otherScope) return (true);
			if (scope instanceof ClassDeclaration) {
				ClassDeclaration prfx = ((ClassDeclaration) scope).getPrefixClass();
				while (prfx != null) {
					if (prfx == otherScope)	return (true);
					prfx = prfx.getPrefixClass();
				}
			}
			scope = scope.declaredIn;
		}
		return (false);
	}

	// ***********************************************************************************************
	// *** Utility: findVisibleAttributeMeaning
	// ***********************************************************************************************
	public Meaning findVisibleAttributeMeaning(final String ident) {
		boolean searchBehindHidden = false;
		ClassDeclaration scope = this;
		Declaration decl = scope.findLocalAttribute(ident);
		if (decl != null) {
			Meaning meaning = new Meaning(decl, this, scope, searchBehindHidden);
			return (meaning);
		}
		scope = scope.getPrefixClass();
SEARCH: while (scope != null) {
			HiddenSpecification hdn = scope.searchHiddenList(ident);
			if (hdn != null) {
				scope = hdn.getScopeBehindHidden();
				searchBehindHidden = true;
				continue SEARCH;
			}
			decl = scope.findLocalAttribute(ident);
			if (decl != null) {
				Meaning meaning = new Meaning(decl, this, scope, searchBehindHidden);
				return (meaning);
			}
			scope = scope.getPrefixClass();
		}
		return (null);
	}

	// ***********************************************************************************************
	// *** Utility: searchHiddenList -- Search Hidden-list for 'ident'
	// ***********************************************************************************************
	HiddenSpecification searchHiddenList(final String ident) {
		for (HiddenSpecification hdn : hiddenList)
			if (ident.equalsIgnoreCase(hdn.identifier))	return (hdn);
		return (null);
	}

	// ***********************************************************************************************
	// *** Utility: getPrefixClass
	// ***********************************************************************************************
	public ClassDeclaration getPrefixClass() {
		if (prefix == null)	return (null);
		Meaning meaning = declaredIn.findMeaning(prefix);
		if (meaning == null) Util.error("Undefined prefix: " + prefix);
		Declaration decl = meaning.declaredAs;
		if (decl == this) Util.error("Class prefix chain loops");
		if (decl instanceof ClassDeclaration) return ((ClassDeclaration) decl);
		if (decl instanceof StandardClass) return ((ClassDeclaration) decl);
		Util.error("Prefix " + prefix + " is not a Class");
		return (null);
	}

	// ***********************************************************************************************
	// *** Coding Utility: hasNoRealPrefix
	// ***********************************************************************************************
	public boolean hasNoRealPrefix() {
		ClassDeclaration prfx = getPrefixClass();
		boolean noPrefix = true;
		if (prfx != null) {
			noPrefix = false;
			String prfxString = prfx.identifier;
			if (prfxString.equalsIgnoreCase("CLASS")) noPrefix = true;
		}
		return (noPrefix);
	}

	// ***********************************************************************************************
	// *** Coding: isDetachUsed -- If the 'detach' attribute is used
	// ***********************************************************************************************
	/**
	 * KOMMENTAR FRA Stein: Ta utgangspunkt i hvilke klasser man har kalt "detach"
	 * i, altså kvalifikasjonen av de X som er brukt i "X.detach". Men da må man jo
	 * også holde greie på hvilke slike som har forekommet i eksterne "moduler" (som
	 * f.eks. SIMULATION), uten at det burde være problematisk.
	 * 
	 * @return
	 */
	public boolean isDetachUsed() {
		// TRAVERSER PREFIX LOOKING FOR (detachUsed==true)
		if (this.detachUsed) return (true);
		if (this instanceof ClassDeclaration) {
			ClassDeclaration prfx = ((ClassDeclaration) this).getPrefixClass();
			if (prfx != null) return (prfx.isDetachUsed());
		}
		return (false);
	}

	// ***********************************************************************************************
	// *** Utility: ClassParameterIterator - // Iterates through prefix-chain
	// ***********************************************************************************************
	public final class ClassParameterIterator implements Iterator<Parameter>, Iterable<Parameter> {
		Iterator<Parameter> prefixIterator;
		Iterator<Parameter> localIterator;

		public ClassParameterIterator() {
			ClassDeclaration prefix = getPrefixClass();
			if (prefix != null)	prefixIterator = prefix.parameterIterator();
			localIterator = parameterList.iterator();
		}

		public boolean hasNext() {
			if (prefixIterator != null) {
				if (prefixIterator.hasNext()) return (true);
				prefixIterator = null;
			}
			return (localIterator.hasNext());
		}

		public Parameter next() {
			if (!hasNext())	return (null);
			if (prefixIterator != null)	return (prefixIterator.next());
			return (localIterator.next());
		}

		public Iterator<Parameter> iterator() {
			return (new ClassParameterIterator());
		}
	}

	public Iterator<Parameter> parameterIterator() {
		return (new ClassParameterIterator());
	}

	// ***********************************************************************************************
	// *** Coding: doJavaCoding
	// ***********************************************************************************************
	public void doJavaCoding() {
		ASSERT_SEMANTICS_CHECKED(this);
		if (this.isPreCompiled)	return;
		Global.sourceLineNumber = lineNumber;
		JavaModule javaModule = new JavaModule(this);
		Global.currentScope = this;
		JavaModule.code("@SuppressWarnings(\"unchecked\")");
		String line = "public class " + getJavaIdentifier();
		if (prefix != null)
			 line = line + " extends " + getPrefixClass().getJavaIdentifier();
		else line = line + " extends BASICIO$";
		JavaModule.code(line + " {");
		JavaModule.debug("// ClassDeclaration: Kind=" + declarationKind + ", BlockLevel=" + blockLevel + ", PrefixLevel="
					+ prefixLevel() + ", firstLine=" + lineNumber + ", lastLine=" + lastLineNumber + ", hasLocalClasses="
					+ ((hasLocalClasses) ? "true" : "false") + ", System=" + ((isQPSystemBlock()) ? "true" : "false")
					+ ", detachUsed=" + ((detachUsed) ? "true" : "false"));
		if (isQPSystemBlock())
			JavaModule.code("public boolean isQPSystemBlock() { return(true); }");
		if (isDetachUsed())
			JavaModule.code("public boolean isDetachUsed() { return(true); }");
		JavaModule.debug("// Declare parameters as attributes");
		for (Parameter par : parameterList) {
			String tp = par.toJavaType();
			JavaModule.code("public " + tp + ' ' + par.externalIdent + ';');
		}
		if (!labelList.isEmpty()) {
			JavaModule.debug("// Declare local labels");
			for (Declaration decl : labelList) decl.doJavaCoding();
		}
		JavaModule.debug("// Declare locals as attributes");
		for (Declaration decl : declarationList) decl.doJavaCoding();

		for (VirtualSpecification virtual : virtualSpecList) {
			if (!virtual.hasDefaultMatch) virtual.doJavaCoding();
		}
		for (VirtualMatch match : virtualMatchList)	match.doJavaCoding();
		doCodeConstructor();
		codeClassStatements();
		javaModule.codeProgramInfo();
		JavaModule.code("}","End of Class");
		Global.currentScope = declaredIn;
		javaModule.closeJavaOutput();
	}

	// ***********************************************************************************************
	// *** Coding Utility: doCodeConstructor
	// ***********************************************************************************************
	private void doCodeConstructor() {
		JavaModule.debug("// Normal Constructor");
		JavaModule.code("public " + getJavaIdentifier() + edFormalParameterList(false));
		if (prefix != null) {
			ClassDeclaration prefixClass = this.getPrefixClass();
			JavaModule.code("super" + prefixClass.edSuperParameterList());
		} else
			JavaModule.code("super(staticLink);");
		JavaModule.debug("// Parameter assignment to locals");
		for (Parameter par : parameterList)
			JavaModule.code("this." + par.externalIdent + " = s" + par.externalIdent + ';');

		if (hasNoRealPrefix()) JavaModule.code("BBLK(); // Iff no prefix");

		JavaModule.debug("// Declaration Code");
		for (Declaration decl : declarationList) decl.doDeclarationCoding();
		JavaModule.code("}");
	}

	// ***********************************************************************************************
	// *** Coding Utility: edFormalParameterList
	// ***********************************************************************************************
	// Also used by subclass StandardProcedure
	public String edFormalParameterList(final boolean isMethod) {
		// Accumulates through prefix-chain when class
		StringBuilder s = new StringBuilder();
		s.append('(');
		boolean withparams = false;
		if (!isMethod) {
			s.append("RTObject$ staticLink");
			withparams = true;
		}
		for (Declaration par : new ClassParameterIterator()) {
			// Iterates through prefix-chain
			if (withparams)	s.append(',');
			withparams = true;
			s.append(((Parameter) par).toJavaType());
			s.append(' ');
			if (isMethod) s.append(par.identifier);
			else s.append('s').append(par.externalIdent); // s to indicate Specified Parameter
		}
		s.append(") {");
		return (s.toString());
	}

	// ***********************************************************************************************
	// *** Coding Utility: hasLabel
	// ***********************************************************************************************
	protected boolean hasLabel() {
		if (!labelList.isEmpty()) return (true);
		if (!this.hasNoRealPrefix()) {
			ClassDeclaration prfx = this.getPrefixClass();
			if (prfx != null) return (prfx.hasLabel());
		}
		return (false);
	}

	// ***********************************************************************************************
	// *** Coding Utility: saveClassStms
	// ***********************************************************************************************
	public void saveClassStms() {
		if (code1 == null) {
			code1 = new Vector<CodeLine>();
			Global.currentJavaModule.saveCode = code1;
			for (Statement stm : statements) stm.doJavaCoding();
			Global.currentJavaModule.saveCode = null;
		}
	}

	// ***********************************************************************************************
	// *** Coding Utility: codeStatements
	// ***********************************************************************************************
	public void codeStatements() {
		writeCode1(); // Write code before inner
		writeCode2(); // Write code after inner
		// listSavedCode();
	}

	// ***********************************************************************************************
	// *** Coding Utility: writeCode1 -- Write code before inner
	// ***********************************************************************************************
	protected void writeCode1() {
		if (!this.hasNoRealPrefix()) {
			ClassDeclaration prfx = this.getPrefixClass();
			if (prfx != null) prfx.writeCode1();
		}
		saveClassStms();
		JavaModule.debug("// Class " + this.identifier + ": Code before inner");
		for (CodeLine c : code1) JavaModule.code(c);
	}

	// ***********************************************************************************************
	// *** Coding Utility: writeCode2 -- Write code after inner
	// ***********************************************************************************************
	protected void writeCode2() {
		if (code2 != null) {
			JavaModule.debug("// Class " + this.identifier + ": Code after inner");
			for (CodeLine c : code2) JavaModule.code(c);
		}
		if (!this.hasNoRealPrefix()) {
			ClassDeclaration prfx = this.getPrefixClass();
			if (prfx != null) prfx.writeCode2();
		}
	}


	// ***********************************************************************************************
	// *** Coding Utility: listSavedCode
	// ***********************************************************************************************
//	protected void listSavedCode() {
//		System.out.println("ClassDeclaration.listSavedCode: Class " + identifier);
//		for (CodeLine c : code1) {
//			System.out.println("Line: " + c.sourceLineNumber + " " + c.codeLine);
//		}
//		if (code2 == null)
//			System.out.println("ClassDeclaration.listSavedCode: Class " + identifier + " NO CODE After inner");
//		else {
//			System.out.println("ClassDeclaration.listSavedCode: Class " + identifier + " After inner");
//			for (CodeLine c : code2) {
//				System.out.println("Line: " + c.sourceLineNumber + " " + c.codeLine);
//			}
//		}
//	}

	// ***********************************************************************************************
	// *** Coding Utility: codeClassStatements
	// ***********************************************************************************************
	protected void codeClassStatements() {
		JavaModule.debug("// Class Statements");
		JavaModule.code("public "+getJavaIdentifier()+" STM$() {");
		codeSTMBody();
		JavaModule.code("EBLK();");
		JavaModule.code("return(this);");
		JavaModule.code("}","End of Class Statements");
	}

	// ***********************************************************************************************
	// *** Coding Utility: edSuperParameterList
	// ***********************************************************************************************
	protected String edSuperParameterList() {
		StringBuilder s = new StringBuilder();
		s.append("(staticLink");
		for (Parameter par : new ClassParameterIterator()) // Iterates through prefix-chain
			s.append(",s").append(par.externalIdent); // s to indicate Specified Parameter
		s.append(");");
		return (s.toString());
	}

	// ***********************************************************************************************
	// *** Printing Utility: print
	// ***********************************************************************************************
	public void print(final int indent) {
    	String spc=edIndent(indent);
		StringBuilder s = new StringBuilder(spc);
		s.append('[').append(sourceBlockLevel).append(':').append(blockLevel).append("] ");
		if (prefix != null)	s.append(prefix).append(' ');
		s.append(declarationKind).append(' ').append(identifier);
		s.append('[').append(externalIdent).append("] ");
		s.append(Parameter.editParameterList(parameterList));
		Util.println(s.toString());
		if (!virtualSpecList.isEmpty())	Util.println(spc + "    VIRTUAL-SPEC" + virtualSpecList);
		if (!virtualMatchList.isEmpty()) Util.println(spc + "    VIRTUAL-MATCH" + virtualMatchList);
		if (!hiddenList.isEmpty()) Util.println(spc + "    HIDDEN" + hiddenList);
		if (!protectedList.isEmpty()) Util.println(spc + "    PROTECTED" + protectedList);
		String beg = "begin[" + edScopeChain() + ']';
		Util.println(spc + beg);
		for (Declaration decl : declarationList) decl.print(indent + 1);
		for (Statement stm : statements) stm.print(indent + 1);
		Util.println(spc + "end[" + edScopeChain() + ']');
	}

	public String toString() {
		return ("" + identifier + '[' + externalIdent + "] DeclarationKind=" + declarationKind);
	}


	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	public ClassDeclaration() {
		super(null);
	}

	@Override
	public void writeExternal(ObjectOutput oupt) throws IOException {
		Util.TRACE_OUTPUT("BEGIN Write ClassDeclaration: "+identifier);
		oupt.writeObject(identifier);
		oupt.writeObject(externalIdent);
		oupt.writeObject(type);
		oupt.writeInt(blockLevel);
		oupt.writeObject(prefix);
		oupt.writeBoolean(hasLocalClasses);
		oupt.writeBoolean(detachUsed);
		
		oupt.writeObject(parameterList);
		oupt.writeObject(virtualSpecList);
		oupt.writeObject(hiddenList);
		oupt.writeObject(protectedList);
		oupt.writeObject(labelList);
		oupt.writeObject(declarationList);
//		oupt.writeObject(virtualMatchList);
		oupt.writeObject(code1);
		oupt.writeObject(code2);

		Util.TRACE_OUTPUT("END Write ClassDeclaration: "+identifier);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void readExternal(ObjectInput inpt) throws IOException, ClassNotFoundException {
		declarationKind=Declaration.Kind.Class;
		Util.TRACE_INPUT("BEGIN Read ClassDeclaration: "+identifier+", Declared in: "+this.declaredIn);
		identifier=(String)inpt.readObject();
		externalIdent=(String)inpt.readObject();
		type=Type.inType(inpt);
		blockLevel=inpt.readInt();
		prefix=(String)inpt.readObject();
		hasLocalClasses=inpt.readBoolean();
		detachUsed=inpt.readBoolean();
		
		parameterList=(Vector<Parameter>) inpt.readObject();
		virtualSpecList=(Vector<VirtualSpecification>) inpt.readObject();
		hiddenList=(Vector<HiddenSpecification>) inpt.readObject();
		protectedList=(Vector<ProtectedSpecification>) inpt.readObject();
		labelList=(Vector<LabelDeclaration>) inpt.readObject();
		declarationList=(Vector<Declaration>) inpt.readObject();
//		virtualMatchList=(Vector<VirtualMatch>) inpt.readObject();
		code1=(Vector<CodeLine>) inpt.readObject();
		code2=(Vector<CodeLine>) inpt.readObject();
		Util.TRACE_INPUT("END Read ClassDeclaration: "+identifier+", Declared in: "+this.declaredIn);
		Global.currentScope = this.declaredIn;
	}

}
