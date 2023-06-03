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
import java.util.Vector;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.parsing.Parser;
import simula.compiler.statement.Statement;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * 
 * @author Øystein Myhre Andersen
 */
public class ProcedureDeclaration extends BlockDeclaration implements Externalizable {
	public Vector<Parameter> parameterList = new Vector<Parameter>();
	public VirtualMatch myVirtual; // Set during doChecking

	// ***********************************************************************************************
	// *** CONSTRUCTORS
	// ***********************************************************************************************
	public ProcedureDeclaration(final String identifier,final Declaration.Kind declarationKind) {
		super(identifier);
		this.declarationKind = declarationKind;
	}

	// ***********************************************************************************************
	// *** Parsing: doParseProcedureDeclaration
	// ***********************************************************************************************
	/**
	 * Procedure Declaration.
	 * 
	 * <pre>
	 * Syntax:
	 * 
	 * ProcedureDeclaration
	 *     = [ type ] PROCEDURE ProcedureIdentifier ProcedureHead ProcedureBody
	 *     
	 * ProcedureIdentifier = Identifier
	 * 
	 * ProcedureHead
	 *     = ProcedureIdentifier [ FormalParameterPart ; [ ModePart ] ProcedureSpecificationPart  ] ;
	 *         
	 * ProcedureHead = [ FormalParameterPart ; [ ModePart ] ParameterPart  ] ;
	 *
	 *	FormalParameterPart = "(" FormalParameter { , FormalParameter } ")"
	 *		FormalParameter = Identifier
	 *	
	 *	ModePart = ValuePart [ NamePart ] | NamePart [ ValuePart ]
	 *		ValuePart = VALUE IdentifierList ;
	 *		NamePart  = NAME  IdentifierList ;
	 *	
	 *	ProcedureSpecificationPart = ProcedureSpecifier IdentifierList ; { ProcedureSpecifier IdentifierList ; }
	 *		ProcedureSpecifier = Type | [Type] ARRAY | [Type] PROCEDURE ] | LABEL | SWITCH
	 *
	 * ProcedureBody = Statement
	 * 
	 * </pre>
	 */
	public static ProcedureDeclaration doParseProcedureDeclaration(final Type type) {
		Declaration.Kind declarationKind = Declaration.Kind.Procedure;
		ProcedureDeclaration block = new ProcedureDeclaration(null, declarationKind);
		block.lineNumber=Parser.prevToken.lineNumber;
		block.type = type;
		if (Option.TRACE_PARSE)	Parser.TRACE("Parse ProcedureDeclaration, type=" + type);
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
			if (Parser.accept(KeyWord.NAME)) {
				expectModeList(block, block.parameterList, Parameter.Mode.name);
				Parser.expect(KeyWord.SEMICOLON);
			}
			if (Parser.accept(KeyWord.VALUE)) {
				expectModeList(block, block.parameterList, Parameter.Mode.value);
				Parser.expect(KeyWord.SEMICOLON);
			}
			// ParameterPart = Parameter ; { Parameter ; }
			// Parameter = Specifier IdentifierList
			// Specifier = Type [ ARRAY | PROCEDURE ] | LABEL | SWITCH
			while (acceptProcedureParameterSpecifications(block, block.parameterList)) {
				Parser.expect(KeyWord.SEMICOLON);
			}
		} else Parser.expect(KeyWord.SEMICOLON);
		if (Parser.accept(KeyWord.BEGIN))
			doParseBody(block);
		else block.statements.add(Statement.doParse());


		block.lastLineNumber = Global.sourceLineNumber;
		if (Option.TRACE_PARSE)	Util.TRACE("END ProcedureDeclaration: " + block);
		if(Option.TESTING) System.out.println("Line "+block.lineNumber+": ProcedureDeclaration: "+block);
		Global.setScope(block.declaredIn);
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
				if (Util.equals(identifier, par.identifier)) {
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
	// *** PARSING: acceptProcedureParameterSpecifications
	// ***********************************************************************************************
	private static boolean acceptProcedureParameterSpecifications(final BlockDeclaration block,final Vector<Parameter> parameterList) {
		// ProcedureParameter = ProcedureParameterSpecifier IdentifierList
		// ProcedureParameterSpecifier = Type | [Type] ARRAY | [Type] PROCEDURE ] | LABEL | SWITCH
		if (Option.TRACE_PARSE)	Parser.TRACE("Parse ParameterSpecifications");
		Type type;
		Parameter.Kind kind = Parameter.Kind.Simple;
		if (Parser.accept(KeyWord.SWITCH)) {
			type = Type.Label;
			kind = Parameter.Kind.Procedure;
		} else if (Parser.accept(KeyWord.LABEL))
			type = Type.Label;
		else {
			type = acceptType();
			//if (type == null) return (false);
			if (Parser.accept(KeyWord.ARRAY)) {
				if (type == null) {
					// See Simula Standard 5.2 -
					// If no type is given the type real is understood.
					type=Type.Real;
				}
				kind = Parameter.Kind.Array;
			}
			else if (Parser.accept(KeyWord.PROCEDURE)) kind = Parameter.Kind.Procedure;
			else if(type == null) return (false);
		}
		do {
			String identifier = expectIdentifier();
			Parameter parameter = null;
			for (Parameter par : parameterList)
				if (Util.equals(identifier,par.identifier)) { parameter = par; break; }
			if (parameter == null) {
				Util.error("Identifier " + identifier + " is not defined in this scope");
				parameter = new Parameter(identifier);
			}
			parameter.setTypeAndKind(type, kind);
		} while (Parser.accept(KeyWord.COMMA));
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
		Vector<Statement> stmList = block.statements;
		while (!Parser.accept(KeyWord.END)) {
			stm = Statement.doParse();
			if (stm != null) stmList.add(stm);
		}
	}

	// ***********************************************************************************************
	// *** Checking
	// ***********************************************************************************************
	@Override
	public void doChecking() {
		if (_ISSEMANTICS_CHECKED())	return;
		Global.sourceLineNumber = lineNumber;
		if (declarationKind == Declaration.Kind.ContextFreeMethod) externalIdent = this.identifier;
		if (declarationKind == Declaration.Kind.MemberMethod) externalIdent = this.identifier;
		else if (externalIdent == null)	externalIdent = edJavaClassName();

		currentRTBlockLevel++;
		rtBlockLevel = currentRTBlockLevel;
		Global.enterScope(this);
			int prfx = 0;// prefixLevel();
			if (declarationKind == Declaration.Kind.Procedure)
				for (Parameter par : this.parameterList) par.setExternalIdentifier(prfx);
			for (Declaration par : this.parameterList) par.doChecking();
			for (Declaration dcl : declarationList)	dcl.doChecking();
			for (Statement stm : statements) stm.doChecking();
			doCheckLabelList(null);
			VirtualSpecification virtualSpec = VirtualSpecification.getVirtualSpecification(this);
			if (virtualSpec != null) {
				// This Procedure is a Virtual Match
				myVirtual = new VirtualMatch(virtualSpec, this);
				ClassDeclaration decl = (ClassDeclaration) declaredIn;
				decl.virtualMatchList.add(myVirtual);
				if (decl == virtualSpec.declaredIn) virtualSpec.hasDefaultMatch = true;
			}
		Global.exitScope();
		currentRTBlockLevel--;
		SET_SEMANTICS_CHECKED();
	}

	// ***********************************************************************************************
	// *** Utility: findVisibleAttributeMeaning
	// ***********************************************************************************************
	@Override
	public Meaning findVisibleAttributeMeaning(final String ident) {
		//Util.BREAK("ProcedureDeclaration.findVisibleAttributeMeaning: "+identifier+", Lookup ident="+ident);
		if(Option.TRACE_FIND>0) Util.message("BEGIN Checking Procedure for "+ident+" ================================== "+identifier+" ==================================");
		for (Declaration declaration : declarationList) {
			if(Option.TRACE_FIND>1) Util.message("Checking Local "+declaration);
			if (Util.equals(ident, declaration.identifier))
				return (new Meaning(declaration, this, this, false));
		}
		for (Parameter parameter : parameterList) {
			if(Option.TRACE_FIND>1) Util.message("Checking Parameter "+parameter);
			if (Util.equals(ident, parameter.identifier))
				return (new Meaning(parameter, this, this, false));
		}
		for (LabelDeclaration label : labelList) {
			if(Option.TRACE_FIND>1) Util.message("Checking Label "+label);
			if (Util.equals(ident, label.identifier))
				return (new Meaning(label, this, this, false));
		}
		if(Option.TRACE_FIND>0) Util.message("ENDOF Checking Procedure for "+ident+" ================================== "+identifier+" ==================================");
		return (null);
	}

	// ***********************************************************************************************
	// *** Coding: doJavaCoding
	// ***********************************************************************************************
	@Override
	public void doJavaCoding() {
		ASSERT_SEMANTICS_CHECKED(this);
		if (this.isPreCompiled)	return;
		switch (declarationKind) {
		case ContextFreeMethod -> doMethodJavaCoding("static ", false);
		case MemberMethod -> doMethodJavaCoding("", true);
		case Procedure -> doProcedureCoding();
		default -> Util.FATAL_ERROR("Impossible Situation !");
		}
	}

	// ***********************************************************************************************
	// *** Coding: METHOD -- Generate Inline Method code for Procedure.
	// ***********************************************************************************************
	// Generate Inline Method code for Procedure.
	private void doMethodJavaCoding(final String modifier,final boolean addStaticLink) {
		Global.sourceLineNumber = lineNumber;
		Util.BREAK("ProcedureDeclaration.doMethodJavaCoding: " + identifier);
		ASSERT_SEMANTICS_CHECKED(this);
		Global.enterScope(this);
		String line = "public " + modifier + ((type == null) ? "void" : type.toJavaType());
		line = line + ' ' + getJavaIdentifier() + ' ' + edFormalParameterList(true, addStaticLink);
		GeneratedJavaClass.code(line);
		if (type != null) {
			GeneratedJavaClass.debug("// Declare return value as variable");
			GeneratedJavaClass.code(type.toJavaType() + ' ' + "_RESULT" + '=' + type.edDefaultValue() + ';');
		}
		for (Declaration decl : labelList) decl.doJavaCoding();
		for (Declaration decl : declarationList) decl.doJavaCoding();
		for (Statement stm : statements) stm.doJavaCoding();
		if (type != null) GeneratedJavaClass.code("return(_RESULT);");
		GeneratedJavaClass.code("}");
		Global.exitScope();
	}

	// ***********************************************************************************************
	// *** Coding Utility: edFormalParameterList
	// ***********************************************************************************************
	// Also used by subclass StandardProcedure
	public String edFormalParameterList(final boolean isInlineMethod,final boolean addStaticLink) {
		// Accumulates through prefix-chain when class
		StringBuilder s = new StringBuilder();
		s.append('(');
		boolean withparams = false;
		if (addStaticLink) {
			s.append("_RTObject _SL");
			withparams = true;
		}
		for (Declaration par : this.parameterList) {
			if (withparams)	s.append(',');
			withparams = true;
			s.append(((Parameter) par).toJavaType()).append(' ');
			if (isInlineMethod)
				 s.append(par.identifier);
			else s.append('s').append(par.externalIdent); // s to indicate Specified Parameter
		}
		s.append(") {");
		return (s.toString());
	}

	// ***********************************************************************************************
	// *** Coding: PROCEDURE
	// ***********************************************************************************************
	private void doProcedureCoding() {
		Global.sourceLineNumber = lineNumber;
		ASSERT_SEMANTICS_CHECKED(this);
		if (this.isPreCompiled)	return;
		GeneratedJavaClass javaModule = new GeneratedJavaClass(this);
		Global.enterScope(this);
		GeneratedJavaClass.code("@SuppressWarnings(\"unchecked\")");
		GeneratedJavaClass.code("public final class " + getJavaIdentifier() + " extends _PROC {");
		GeneratedJavaClass.debug("// ProcedureDeclaration: Kind=" + declarationKind + ", BlockLevel=" + rtBlockLevel
					+ ", firstLine=" + lineNumber + ", lastLine=" + lastLineNumber + ", hasLocalClasses="
					+ ((hasLocalClasses) ? "true" : "false") + ", System=" + ((isQPSystemBlock()) ? "true" : "false"));
		if (isQPSystemBlock())
			GeneratedJavaClass.code("public boolean isQPSystemBlock() { return(true); }");
		if (declarationKind == Declaration.Kind.Procedure && type != null) {
			GeneratedJavaClass.debug("// Declare return value as attribute");
			GeneratedJavaClass.code("public " + type.toJavaType() + ' ' + "_RESULT;");
			GeneratedJavaClass.code("public Object _RESULT() { return(_RESULT); }");
		}
		GeneratedJavaClass.debug("// Declare parameters as attributes");
		boolean hasParameter = false;
		for (Parameter par : parameterList) {
			String tp = par.toJavaType();
			hasParameter = true;
			GeneratedJavaClass.code("public " + tp + ' ' + par.externalIdent + ';');
		}
		if (!labelList.isEmpty()) {
			GeneratedJavaClass.debug("// Declare local labels");
			for (Declaration decl : labelList) decl.doJavaCoding();
		}
		GeneratedJavaClass.debug("// Declare locals as attributes");
		for (Declaration decl : declarationList) decl.doJavaCoding();
		if (declarationKind == Declaration.Kind.Procedure && hasParameter) doCodePrepareFormal();
		doCodeConstructor();
		codeProcedureBody();
		javaModule.codeProgramInfo();
		GeneratedJavaClass.code("}", "End of Procedure");
		Global.exitScope();
		javaModule.closeJavaOutput();
	}

	// ***********************************************************************************************
	// *** Coding Utility: doCodeConstructor
	// ***********************************************************************************************
	private void doCodeConstructor() {
		GeneratedJavaClass.debug("// Normal Constructor");
		GeneratedJavaClass.code("public " + getJavaIdentifier() + edFormalParameterList(false, true));
		GeneratedJavaClass.code("super(_SL);");
		GeneratedJavaClass.debug("// Parameter assignment to locals");
		for (Parameter par : parameterList)
			GeneratedJavaClass.code("this." + par.externalIdent + " = s" + par.externalIdent + ';');
		GeneratedJavaClass.code("BBLK();");
		GeneratedJavaClass.debug("// Declaration Code");
		for (Declaration decl : declarationList) decl.doDeclarationCoding();
		GeneratedJavaClass.code("_STM();");
		GeneratedJavaClass.code("}");
	}

	// ***********************************************************************************************
	// *** Coding Utility: doCodePrepareFormal
	// ***********************************************************************************************
	private void doCodePrepareFormal() {
		GeneratedJavaClass.debug("// Parameter Transmission in case of Formal/Virtual Procedure Call");
		GeneratedJavaClass.code("public " + getJavaIdentifier() + " setPar(Object param) {");
		GeneratedJavaClass.debug("//Util.BREAK(\"CALL " + getJavaIdentifier()
				+ ".setPar: param=\"+param+\", qual=\"+param.getClass().getSimpleName()+\", npar=\"+_nParLeft+\", staticLink=\"+_SL);");
		GeneratedJavaClass.code("try {");
		GeneratedJavaClass.code("switch(_nParLeft--) {");
		int nPar = 0;
		for (Parameter par : parameterList) {
			String tp = par.toJavaType();
			String typeValue;
			if (par.mode == Parameter.Mode.name) typeValue = ("(" + tp + ")param");
			else if (par.kind == Parameter.Kind.Array) {
				typeValue = ("arrayValue(param)");
				if (par.mode == Parameter.Mode.value) typeValue = typeValue + ".COPY()";
			} else if (par.kind == Parameter.Kind.Procedure) typeValue = ("procValue(param)");
			else if (par.kind != Parameter.Kind.Simple)	typeValue = ("(" + tp + ")param");
			else if (par.type.isArithmeticType()) typeValue = (tp + "Value(param)");
			else typeValue = ("(" + tp + ")objectValue(param)");
			GeneratedJavaClass.code("case " + ( parameterList.size() - (nPar++)) + ": " + par.externalIdent + "=" + typeValue + "; break;");
		}
		GeneratedJavaClass.code("default: throw new _SimulaRuntimeError(\"Too many parameters\");");
		GeneratedJavaClass.code("}");
		GeneratedJavaClass.code("}");
		GeneratedJavaClass.code("catch(ClassCastException e) { throw new _SimulaRuntimeError(\"Wrong type of parameter: \"+param,e);}");
		GeneratedJavaClass.code("return(this);");
		GeneratedJavaClass.code("}");
		GeneratedJavaClass.debug("// Constructor in case of Formal/Virtual Procedure Call");
		GeneratedJavaClass.code("public " + getJavaIdentifier() + "(_RTObject _SL) {");
		GeneratedJavaClass.code("super(_SL,"+parameterList.size()+");","Expecting "+parameterList.size()+" parameters");
		GeneratedJavaClass.code("}");
	}

	// ***********************************************************************************************
	// *** Coding Utility: codeProcedureBody -- Redefined in SwitchDeclaration
	// ***********************************************************************************************
	public void codeProcedureBody() {
		boolean duringSTM_Coding=Global.duringSTM_Coding;
		Global.duringSTM_Coding=true;
		GeneratedJavaClass.debug("// Procedure Statements");
		GeneratedJavaClass.code("public " + getJavaIdentifier() + " _STM() {");
		codeSTMBody();
		GeneratedJavaClass.code("EBLK();");
		GeneratedJavaClass.code("return(this);");
		GeneratedJavaClass.code("}", "End of Procedure BODY");
		Global.duringSTM_Coding=duringSTM_Coding;
	}

	// ***********************************************************************************************
	// *** Printing Utility: print
	// ***********************************************************************************************
	@Override
	public void print(final int indent) {
    	String spc=edIndent(indent);
		StringBuilder s = new StringBuilder(spc);
		s.append('[').append(sourceBlockLevel).append(':').append(rtBlockLevel).append("] ");
		s.append(declarationKind).append(' ').append(identifier);
		s.append('[').append(externalIdent).append("] ");
		s.append(Parameter.editParameterList(parameterList));
		s.append("  isProtected=").append(isProtected);
		Util.println(s.toString());
		String beg = "begin[" + edScopeChain() + ']';
		Util.println(spc + beg);
		for (Declaration decl : declarationList) decl.print(indent + 1);
		for (Statement stm : statements) stm.print(indent + 1);
		Util.println(spc + "end[" + edScopeChain() + ']');
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(identifier).append("[externalIdent=").append(externalIdent).append("] Kind=")
		.append(declarationKind).append(", QUAL=").append(this.getClass().getSimpleName()).append(", HashCode=").append(hashCode());
		if (isProtected != null) {
			s.append(", Protected by ").append(isProtected.identifier);
			s.append(" defined in ");
			s.append((isProtected.definedIn != null) ? isProtected.definedIn.identifier : "MISSING");
		}
		return (s.toString());
	}

	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	public ProcedureDeclaration() {	super(null); }

	@Override
	public void writeExternal(ObjectOutput oupt) throws IOException {
		Util.TRACE_OUTPUT("BEGIN Write ProcedureDeclaration: "+identifier);
		oupt.writeObject(identifier);
		oupt.writeObject(externalIdent);
		oupt.writeObject(type);
		oupt.writeObject(declarationKind);
		oupt.writeInt(rtBlockLevel);
		oupt.writeBoolean(hasLocalClasses);

		oupt.writeObject(parameterList);
		oupt.writeObject(labelList);
		oupt.writeObject(declarationList);
		Util.TRACE_OUTPUT("END Write ProcedureDeclaration: "+identifier);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void readExternal(ObjectInput inpt) throws IOException, ClassNotFoundException {
//		declarationKind=Declaration.Kind.Procedure;
		Util.TRACE_INPUT("BEGIN Read ProcedureDeclaration: "+identifier+", Declared in: "+this.declaredIn);
		identifier=(String)inpt.readObject();
		externalIdent=(String)inpt.readObject();
		type=Type.inType(inpt);
		declarationKind=(Kind) inpt.readObject();
		rtBlockLevel=inpt.readInt();
		hasLocalClasses=inpt.readBoolean();
		
		parameterList=(Vector<Parameter>) inpt.readObject();
		labelList=(Vector<LabelDeclaration>) inpt.readObject();
		declarationList=(DeclarationList) inpt.readObject();
		Util.TRACE_INPUT("END Read ProcedureDeclaration: "+identifier+", Declared in: "+this.declaredIn);
//		Global.currentScope = this.declaredIn;
		Global.setScope(this.declaredIn);
	}

}
