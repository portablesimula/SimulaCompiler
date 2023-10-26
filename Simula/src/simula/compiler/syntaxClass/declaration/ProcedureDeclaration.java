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
import java.util.Vector;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.parsing.Parse;
import simula.compiler.syntaxClass.Type;
import simula.compiler.syntaxClass.statement.Statement;
import simula.compiler.utilities.DeclarationList;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Procedure Declaration.
 * <pre>
 * Simula Standard: 5.4 Procedure declaration
 * 
 *      procedure-declaration
 *          = [ type ] PROCEDURE procedure-heading ; procedure-body
 *      
 *            procedure-heading
 *                = procedure-identifier [ formal-parameter-part ; [ mode-part ] specification-part ] 
 *                
 *               procedure-identifier = identifier
 *                
 *               formal-parameter-part = "(" formal-parameter { , formal-parameter } ")"
 *            
 *                  formal-parameter = identifier
 *            
 *               specification-part = specifier identifier-list { ; specifier identifier-list }
 *            
 *                  specifier
 *                      = type [ ARRAY | PROCEDURE ]
 *                      | LABEL
 *                      | SWITCH 
 *                
 *               mode-part
 *                   = name-part [ value-part ]
 *                   | value-part [ name-part ]
 *            
 *                  name-part = NAME identifier-list ;
 *            
 *                  value-part = VALUE identifier-list ;
 *            
 *               identifier-list = identifier { , identifier }
 *                
 *            procedure-body = statement
 * </pre>
 * This class is prefix to StandardProcedure and SwitchDeclaration.
 * <p>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/declaration/ProcedureDeclaration.java">
 * <b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 */
public sealed class ProcedureDeclaration extends BlockDeclaration implements Externalizable
permits StandardProcedure, SwitchDeclaration {
	
	/**
	 * Parameter list.
	 */
	public Vector<Parameter> parameterList = new Vector<Parameter>();
	
	/**
	 * Virtual Match indicator. 
	 * <p>
	 * If myVirtual != null, this Procedure is a Virtual Match.
	 * <p>
	 * Set during doChecking.
	 */
	public VirtualMatch myVirtual; // Set during doChecking

	// ***********************************************************************************************
	// *** CONSTRUCTORS
	// ***********************************************************************************************
	/**
	 * Create a new ProcedureDeclaration.
	 * @param identifier procedure identifier
	 * @param declarationKind procedure or switch
	 */
	protected ProcedureDeclaration(final String identifier,final Declaration.Kind declarationKind) {
		super(identifier);
		this.declarationKind = declarationKind;
	}

	// ***********************************************************************************************
	// *** Parsing: expectProcedureDeclaration
	// ***********************************************************************************************
	/**
	 * Parse and build a ProcedureDeclaration.
	 * 
	 * <pre>
	 * Syntax:
	 * 
	 *      procedure-declaration
	 *          = [ type ] PROCEDURE procedure-heading ; procedure-body
	 *      
	 *            procedure-heading
	 *                = procedure-identifier [ formal-parameter-part ; [ mode-part ] specification-part ] 
	 *                
	 *            procedure-identifier = identifier
	 * </pre>
	 * 
	 * Precondition: [ type ] PROCEDURE is already read.
	 * 
	 * @param type procedure's type
	 * @return a newly created ProcedureDeclaration
	 */
	public static ProcedureDeclaration expectProcedureDeclaration(final Type type) {
		Declaration.Kind declarationKind = Declaration.Kind.Procedure;
		ProcedureDeclaration proc = new ProcedureDeclaration(null, declarationKind);
		proc.lineNumber=Parse.prevToken.lineNumber;
		proc.type = type;
		if (Option.TRACE_PARSE)	Parse.TRACE("Parse ProcedureDeclaration, type=" + type);
		proc.modifyIdentifier(Parse.expectIdentifier());
		if (Parse.accept(KeyWord.BEGPAR)) {
			expectFormalParameterPart(proc.parameterList);
			Parse.expect(KeyWord.SEMICOLON);
			while(acceptModePart(proc.parameterList));
			expectSpecificationPart(proc);
		} else Parse.expect(KeyWord.SEMICOLON);
		expectProcedureBody(proc);

		proc.lastLineNumber = Global.sourceLineNumber;
		if (Option.TRACE_PARSE)	Util.TRACE("Line "+proc.lineNumber+": ProcedureDeclaration: "+proc);
		Global.setScope(proc.declaredIn);
		return (proc);
	}
	
	/**
	 * Parse Utility: Accept mode-part and set matching parameter's mode.
	 * <pre>
	 *   mode-part
	 *      = name-part [ value-part ]
	 *      | value-part [ name-part ]
	 *            
	 *   name-part = NAME identifier-list ;
	 *            
	 *   value-part = VALUE identifier-list ;
	 *            
	 *   identifier-list = identifier { , identifier }
	 * </pre>
	 * @param pList the parameter list
	 */
	private static boolean acceptModePart(Vector<Parameter> pList) {
		if (Parse.accept(KeyWord.VALUE, KeyWord.NAME)) {
			Parameter.Mode mode = (Parse.prevToken.getKeyWord() == KeyWord.VALUE)
					? Parameter.Mode.value
					: Parameter.Mode.name;
			do {
				String identifier = Parse.expectIdentifier();
				Parameter parameter = null;
				for (Parameter par : pList)
					if (Util.equals(identifier, par.identifier)) {
						parameter = par;
						break;
					}
				if (parameter == null) {
					Util.error("Identifier " + identifier + " is not defined in this scope");
					parameter = new Parameter(identifier);
				}
				parameter.setMode(mode);
			} while (Parse.accept(KeyWord.COMMA));
			Parse.expect(KeyWord.SEMICOLON);
			return(true);
		}
		return(false);
	}
	
	/**
	 * Parse Utility: Accept Procedure Parameter specification-part updating Parameter's type and kind.
	 * <pre>
	 * Syntax:
	 * 
	 *     specification-part
     *           = specifier identifier-list { ; specifier identifier-list }
	 *     
	 *        specifier = Type | [Type] ARRAY | [Type] PROCEDURE ] | LABEL | SWITCH
	 * </pre>
	 * @param proc the procedure declaration
	 */
	private static void expectSpecificationPart(ProcedureDeclaration proc) {
		if (Option.TRACE_PARSE)	Parse.TRACE("Parse ParameterSpecifications");
		LOOP: while(true) {
			Type type;
			Parameter.Kind kind = Parameter.Kind.Simple;
			if (Parse.accept(KeyWord.SWITCH)) {
				type = Type.Label;
				kind = Parameter.Kind.Procedure;
			} else if (Parse.accept(KeyWord.LABEL))
				type = Type.Label;
			else {
				type = Parse.acceptType();
				//if (type == null) return (false);
				if (Parse.accept(KeyWord.ARRAY)) {
					if (type == null) {
						// See Simula Standard 5.2 -
						// If no type is given the type real is understood.
						type=Type.Real;
					}
					kind = Parameter.Kind.Array;
				}
				else if (Parse.accept(KeyWord.PROCEDURE)) kind = Parameter.Kind.Procedure;
				else if(type == null) break LOOP;
			}
			do {
				String identifier = Parse.expectIdentifier();
				Parameter parameter = null;
				for (Parameter par : proc.parameterList)
					if (Util.equals(identifier,par.identifier)) { parameter = par; break; }
				if (parameter == null) {
					Util.error("Identifier " + identifier + " is not defined in this scope");
					parameter = new Parameter(identifier);
				}
				parameter.setTypeAndKind(type, kind);
			} while (Parse.accept(KeyWord.COMMA));
			Parse.expect(KeyWord.SEMICOLON);
			continue LOOP;
		}
		for (Parameter par : proc.parameterList) {
			if (par.kind != null)
				switch (par.kind) {
				case Array:
				case Label:
				case Procedure:
					break; // OK
				case Simple:
				default:
					if (par.type == null)
						Util.error("Missing specification of parameter: " + par.identifier);
				}
		}
	}

	/**
	 * Parse Utility: Expect procedure-body.
	 * In case of a compound-statement, updating the procedure's declaration and statement lists.
	 * <pre>
	 * Syntax:
	 *                
	 *        procedure-body = statement
	 * </pre>
	 * 
	 * @param proc the procedure
	 */
	private static void expectProcedureBody(ProcedureDeclaration proc) {
		if (Parse.accept(KeyWord.BEGIN)) {
//			expectStatementBodyBlock(proc);
			// BEGIN declaration { ; declaration } statement { ; statement } END
			Statement stm;
			if (Option.TRACE_PARSE)	Parse.TRACE("Parse Procedure Block");
			while (Declaration.acceptDeclaration(proc.declarationList)) {
				Parse.accept(KeyWord.SEMICOLON);
			}
			Vector<Statement> stmList = proc.statements;
			while (!Parse.accept(KeyWord.END)) {
				stm = Statement.expectStatement();
				if (stm != null) stmList.add(stm);
			}
		}
		else proc.statements.add(Statement.expectStatement());
	}

	// ***********************************************************************************************
	// *** Checking
	// ***********************************************************************************************
	@Override
	public void doChecking() {
		if(isPreCompiled && !isBlockLevelUpdated)
			updateBlockLevels(DeclarationScope.currentRTBlockLevel);
		if (IS_SEMANTICS_CHECKED())
			return;
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
		if(Option.TRACE_FIND_MEANING>0) Util.println("BEGIN Checking Procedure for "+ident+" ================================== "+identifier+" ==================================");
		for (Declaration declaration : declarationList) {
			if(Option.TRACE_FIND_MEANING>1) Util.println("Checking Local "+declaration);
			if (Util.equals(ident, declaration.identifier))
				return (new Meaning(declaration, this, this, false));
		}
		for (Parameter parameter : parameterList) {
			if(Option.TRACE_FIND_MEANING>1) Util.println("Checking Parameter "+parameter);
			if (Util.equals(ident, parameter.identifier))
				return (new Meaning(parameter, this, this, false));
		}
		for (LabelDeclaration label : labelList) {
			if(Option.TRACE_FIND_MEANING>1) Util.println("Checking Label "+label);
			if (Util.equals(ident, label.identifier))
				return (new Meaning(label, this, this, false));
		}
		if(Option.TRACE_FIND_MEANING>0) Util.println("ENDOF Checking Procedure for "+ident+" ================================== "+identifier+" ==================================");
		return (null);
	}

	// ***********************************************************************************************
	// *** Coding: doJavaCoding
	// ***********************************************************************************************
	@Override
	public void doJavaCoding() {
		ASSERT_SEMANTICS_CHECKED();
		if (this.isPreCompiled)	return;
		switch (declarationKind) {
		case ContextFreeMethod -> doMethodJavaCoding("static ", false);
		case MemberMethod -> doMethodJavaCoding("", true);
		case Procedure -> doProcedureCoding();
		default -> Util.IERR("Impossible Situation !");
		}
	}

	// ***********************************************************************************************
	// *** Coding: METHOD -- Generate Inline Method code for Procedure.
	// ***********************************************************************************************
	/**
	 * Generate Inline Method code for Procedure.
	 * @param modifier mthod modifier: "static " or ""
	 * @param addStaticLink add static link as 0'th parameter
	 */
	private void doMethodJavaCoding(final String modifier,final boolean addStaticLink) {
		Global.sourceLineNumber = lineNumber;
		ASSERT_SEMANTICS_CHECKED();
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
	/**
	 * Edit the formal parameter list
	 * @param isInlineMethod true if generating an inline method, otherwise false
	 * @param addStaticLink add static link as 0'th parameter
	 * @return the resulting Java code
	 */
	private String edFormalParameterList(final boolean isInlineMethod,final boolean addStaticLink) {
		// Accumulates through prefix-chain when class
		StringBuilder s = new StringBuilder();
		s.append('(');
		boolean withparams = false;
		if (addStaticLink) {
			s.append("RTS_RTObject _SL");
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
	/**
	 * Generate java source code for this Procedure.
	 */
	private void doProcedureCoding() {
		Global.sourceLineNumber = lineNumber;
		ASSERT_SEMANTICS_CHECKED();
		if (this.isPreCompiled)	return;
		GeneratedJavaClass javaModule = new GeneratedJavaClass(this);
		Global.enterScope(this);
		GeneratedJavaClass.code("@SuppressWarnings(\"unchecked\")");
		GeneratedJavaClass.code("public final class " + getJavaIdentifier() + " extends RTS_PROCEDURE {");
		GeneratedJavaClass.debug("// ProcedureDeclaration: Kind=" + declarationKind + ", BlockLevel=" + rtBlockLevel
					+ ", firstLine=" + lineNumber + ", lastLine=" + lastLineNumber + ", hasLocalClasses="
					+ ((hasLocalClasses) ? "true" : "false") + ", System=" + ((isQPSystemBlock()) ? "true" : "false"));
		if (isQPSystemBlock())
			GeneratedJavaClass.code("public boolean isQPSystemBlock() { return(true); }");
		if (declarationKind == Declaration.Kind.Procedure && type != null) {
			GeneratedJavaClass.debug("// Declare return value as attribute");
			GeneratedJavaClass.code("public " + type.toJavaType() + ' ' + "_RESULT;");
			GeneratedJavaClass.code("@Override");
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
	/**
	 * Generate Java source code for the constructor.
	 */
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
	/**
	 * Generate Java source code prepared for 'call formal procedure'.
	 */
	private void doCodePrepareFormal() {
		GeneratedJavaClass.debug("// Parameter Transmission in case of Formal/Virtual Procedure Call");
		GeneratedJavaClass.code("@Override");
		GeneratedJavaClass.code("public " + getJavaIdentifier() + " setPar(Object param) {");
//		GeneratedJavaClass.debug("//Util.BREAK(\"CALL " + getJavaIdentifier()
//				+ ".setPar: param=\"+param+\", qual=\"+param.getClass().getSimpleName()+\", npar=\"+_nParLeft+\", staticLink=\"+_SL);");
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
		GeneratedJavaClass.code("default: throw new RTS_SimulaRuntimeError(\"Too many parameters\");");
		GeneratedJavaClass.code("}");
		GeneratedJavaClass.code("}");
		GeneratedJavaClass.code("catch(ClassCastException e) { throw new RTS_SimulaRuntimeError(\"Wrong type of parameter: \"+param,e);}");
		GeneratedJavaClass.code("return(this);");
		GeneratedJavaClass.code("}");
		GeneratedJavaClass.debug("// Constructor in case of Formal/Virtual Procedure Call");
		GeneratedJavaClass.code("public " + getJavaIdentifier() + "(RTS_RTObject _SL) {");
		GeneratedJavaClass.code("super(_SL,"+parameterList.size()+");","Expecting "+parameterList.size()+" parameters");
		GeneratedJavaClass.code("}");
	}

	// ***********************************************************************************************
	// *** Coding Utility: codeProcedureBody -- Redefined in SwitchDeclaration
	// ***********************************************************************************************
	/**
	 * Coding Utility: codeProcedureBody. Redefined in SwitchDeclaration.
	 */
	protected void codeProcedureBody() {
		boolean duringSTM_Coding=Global.duringSTM_Coding;
		Global.duringSTM_Coding=true;
		GeneratedJavaClass.debug("// Procedure Statements");
		GeneratedJavaClass.code("@Override");
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
	public void printTree(final int indent) {
		String typeID=(type==null)?"":type.toString()+" ";
		System.out.println(edTreeIndent(indent)+typeID+"PROCEDURE "+identifier);
		for(Parameter p:parameterList) p.printTree(indent+1);
		printDeclarationList(indent+1);
		printStatementList(indent+1);
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
	/**
	 * Default constructor used by Externalization.
	 */
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
		Global.setScope(this.declaredIn);
	}

}
