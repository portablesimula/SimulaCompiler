/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass.declaration;

import java.util.Vector;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.parsing.Parse;
import simula.compiler.syntaxClass.statement.BlockStatement;
import simula.compiler.syntaxClass.statement.Statement;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Maybe Block Declaration. I.e: CompoundStatement or SubBlock depends on
 * whether it contains declarations.
 * 
 * <pre>
 * Simula Standard: 4.9 Compound statement
 * Simula Standard: 4.9 Blocks
 *  
 *   MaybeBlockDeclaration = compound-statement | subblock
 * 
 *	    compound-statement = BEGIN [ { statement ; } ] END
 *
 * 	    subblock = BEGIN [ { declaration ; } ]  [ { statement ; } ] END
 *
 * </pre>
 * 
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/declaration/MaybeBlockDeclaration.java">
 * <b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 */
public final class MaybeBlockDeclaration extends BlockDeclaration {

	// ***********************************************************************************************
	// *** CONSTRUCTORS
	// ***********************************************************************************************
	// Used by expectMaybeBlock, i.e. CompoundStatement or SubBlock.
	/**
	 * Create a new MaybeBlockDeclaration.
	 * 
	 * @param identifier block identifier
	 */
	public MaybeBlockDeclaration(final String identifier) {
		super(identifier);
	}

	// ***********************************************************************************************
	// *** createMainProgramBlock
	// ***********************************************************************************************
	/**
	 * Create the main program block. Used by ProgramModule.
	 * 
	 * @return the main program block
	 */
	public static MaybeBlockDeclaration createMainProgramBlock() {
		int lineNumber=Parse.prevToken.lineNumber;
		if (Option.TRACE_PARSE)	Util.TRACE("BlockStatement.createMainProgramBlock: line="+lineNumber+" "+Parse.prevToken);
		MaybeBlockDeclaration module = new MaybeBlockDeclaration(Global.sourceName);
		module.isMainModule = true;
		module.declarationKind = Declaration.Kind.SimulaProgram;
		module.expectMaybeBlock(lineNumber);
		return (module);
	}

	// ***********************************************************************************************
	// *** Parsing: expectMaybeBlock
	// ***********************************************************************************************
	/**
	 * Parse CompoundStatement or SubBlock.
	 * 
	 * <pre>
	 * Syntax:
	 * 
	 * Block = CompoundStatement | SubBlock
	 * 
	 *	 CompoundStatement = BEGIN [ { Statement ; } ] END
	 *
	 * 	 SubBlock = BEGIN [ { Declaration ; } ]  [ { Statement ; } ] END
	 *
	 * </pre>
	 * Pre-condition: BEGIN is already read.
	 * @param line source line number
	 * @return a BlockStatement
	 */
	public BlockStatement expectMaybeBlock(int line) {
		this.lineNumber=line;
		if (Option.TRACE_PARSE)	Parse.TRACE("Parse MayBeBlock");
		while (Declaration.acceptDeclaration(declarationList))
			Parse.expect(KeyWord.SEMICOLON);
		while (!Parse.accept(KeyWord.END)) {
			Statement stm = Statement.expectStatement();
			if (stm != null) statements.add(stm);
		}
		if (declarationKind != Declaration.Kind.SimulaProgram) {
			if (!declarationList.isEmpty()) {
				declarationKind = Declaration.Kind.SubBlock;
				modifyIdentifier("SubBlock" + line);
			} else {
				declarationKind = Declaration.Kind.CompoundStatement;
				modifyIdentifier("CompoundStatement" + Global.sourceLineNumber);
				if (!labelList.isEmpty())
					moveLabelsFrom(this); // Label is also declaration
			}
		}
		this.lastLineNumber = Global.sourceLineNumber;
		Global.setScope(declaredIn);
		return (new BlockStatement(this));
	}

	/**
	 * Utility: Moves labels from the givent block.
	 * <p>
	 * Special case: Labels in a CompoundStatement or ConnectionBlock.
	 * <p>
	 * Move Label Declaration to nearest enclosing Block which is not
	 * a CompoundStatement or ConnectionBlock.
	 * @param block the block containing labels to be moved
	 */
	static void moveLabelsFrom(DeclarationScope block) {
		DeclarationScope declaredIn = block.declaredIn;
		Vector<LabelDeclaration> labelList = block.labelList;
		DeclarationScope enc = declaredIn;
		while (enc.declarationKind == Declaration.Kind.CompoundStatement
				&& enc.declarationKind == Declaration.Kind.ConnectionBlock
				&& enc.declarationList.isEmpty())
			enc = enc.declaredIn;
		for (LabelDeclaration lab : labelList) enc.labelList.add(lab);
		labelList.clear();
	}

	// ***********************************************************************************************
	// *** Checking
	// ***********************************************************************************************
	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber = lineNumber;
		if (externalIdent == null) externalIdent = edJavaClassName();
		if (declarationKind != Declaration.Kind.CompoundStatement) currentRTBlockLevel++;
		rtBlockLevel = currentRTBlockLevel;
		Global.enterScope(this);
		for (Declaration dcl : declarationList)	dcl.doChecking();
		for (Statement stm : statements) stm.doChecking();
		doCheckLabelList(null);
		Global.exitScope();
		if (declarationKind != Declaration.Kind.CompoundStatement) currentRTBlockLevel--;
		SET_SEMANTICS_CHECKED();
	}

	// ***********************************************************************************************
	// *** Utility: findVisibleAttributeMeaning
	// ***********************************************************************************************
	@Override
	public Meaning findVisibleAttributeMeaning(final String ident) {
		if(Option.TRACE_FIND_MEANING>0) Util.println("BEGIN Checking MayBeBlock for "+ident+" ================================== "+identifier+" ==================================");
		for (Declaration declaration : declarationList) {
			if(Option.TRACE_FIND_MEANING>1) Util.println("Checking Local "+declaration);
			if (Util.equals(ident, declaration.identifier))
				return (new Meaning(declaration, this, this, false));
		}
		for (LabelDeclaration label : labelList) {
			if(Option.TRACE_FIND_MEANING>1) Util.println("Checking Label "+label);
			if (Util.equals(ident, label.identifier))
				return (new Meaning(label, this, this, false));
		}
		if(Option.TRACE_FIND_MEANING>0) Util.println("ENDOF Checking MayBeBlock for "+ident+" ================================== "+identifier+" ==================================");
		return (null);
	}

	// ***********************************************************************************************
	// *** Coding: doJavaCoding
	// ***********************************************************************************************
	@Override
	public void doJavaCoding() {
		ASSERT_SEMANTICS_CHECKED();
		if (this.isPreCompiled)	return;
		if (declarationKind == Declaration.Kind.CompoundStatement)
			 doCompoundStatementCoding();
		else doSubBlockCoding();
	}

	// ***********************************************************************************************
	// *** Coding: CompoundStatement as Java Subblock
	// ***********************************************************************************************
	/**
	 * Code utility: Code compound statement
	 */
	private void doCompoundStatementCoding() {
		Global.sourceLineNumber = lineNumber;
		ASSERT_SEMANTICS_CHECKED();
		Util.ASSERT(declarationList.isEmpty(), "Invariant");
		Util.ASSERT(labelList.isEmpty(), "Invariant");
		Global.enterScope(this);
		GeneratedJavaClass.code("{");
		if(labelcodeList!=null) {
			for(String labCode:labelcodeList) {
				if(Option.USE_FILE_CLASS_API==2) GeneratedJavaClass.code("_PRE_LABEL();");
				GeneratedJavaClass.code(labCode);
			}
		}
		for (Statement stm : statements) stm.doJavaCoding();
		GeneratedJavaClass.code("}");
		Global.exitScope();
	}

	// ***********************************************************************************************
	// *** Coding: SUBBLOCK ==> .java file
	// ***********************************************************************************************
	/**
	 * Code utility: Code sub-block
	 */
	private void doSubBlockCoding() {
		Global.sourceLineNumber = lineNumber;
		ASSERT_SEMANTICS_CHECKED();
		GeneratedJavaClass javaModule = new GeneratedJavaClass(this);
		Global.enterScope(this);
		Global.duringSTM_Coding=false;
		GeneratedJavaClass.code("@SuppressWarnings(\"unchecked\")");
		GeneratedJavaClass.code("public final class " + getJavaIdentifier() + " extends RTS_BASICIO" + " {");
		GeneratedJavaClass.debug("// SubBlock: Kind=" + declarationKind + ", BlockLevel=" + rtBlockLevel + ", firstLine="
				+ lineNumber + ", lastLine=" + lastLineNumber + ", hasLocalClasses="
				+ ((hasLocalClasses) ? "true" : "false") + ", System=" + ((isQPSystemBlock()) ? "true" : "false"));
		if (isQPSystemBlock())
			GeneratedJavaClass.code("public boolean isQPSystemBlock() { return(true); }");
		if (!labelList.isEmpty()) {
			GeneratedJavaClass.debug("// Declare local labels");
			for (Declaration decl : labelList) decl.doJavaCoding();
		}
		GeneratedJavaClass.debug("// Declare locals as attributes");
		for (Declaration decl : declarationList) decl.doJavaCoding();
		doCodeConstructor();
		boolean duringSTM_Coding=Global.duringSTM_Coding;
		Global.duringSTM_Coding=true;
		doCodeStatements();
		Global.duringSTM_Coding=duringSTM_Coding;
		if (this.isMainModule) {
			GeneratedJavaClass.code("");
			GeneratedJavaClass.code("public static void main(String[] args) {");
			GeneratedJavaClass.debug("//System.setProperty(\"file.encoding\",\"UTF-8\");");
			GeneratedJavaClass.code("RTS_COMMON.setRuntimeOptions(args);");
			GeneratedJavaClass.code("new " + getJavaIdentifier() + "(_CTX)._STM();");
			GeneratedJavaClass.code("}", "End of main");
		}
		javaModule.codeProgramInfo();
		GeneratedJavaClass.code("}", "End of SubBlock");
		Global.exitScope();
		javaModule.closeJavaOutput();
	}

	// ***********************************************************************************************
	// *** Coding Utility: doCodeConstructor
	// ***********************************************************************************************
	/**
	 * Code utility: Code constructor
	 */
	private void doCodeConstructor() {
		GeneratedJavaClass.debug("// Normal Constructor");
		GeneratedJavaClass.code("public " + getJavaIdentifier() + "(RTS_RTObject staticLink) {");
		GeneratedJavaClass.code("super(staticLink);");
		GeneratedJavaClass.code("BBLK();");
		if (declarationKind == Declaration.Kind.SimulaProgram) GeneratedJavaClass.code("BPRG(\"" + identifier + "\");");
		GeneratedJavaClass.debug("// Declaration Code");
		for (Declaration decl : declarationList) decl.doDeclarationCoding();
		GeneratedJavaClass.code("}");
	}

	// ***********************************************************************************************
	// *** Coding Utility: doCodeStatements
	// ***********************************************************************************************
	/**
	 * Code utility: Code statements
	 */
	private void doCodeStatements() {
		GeneratedJavaClass.debug("// " + declarationKind + " Statements");
		GeneratedJavaClass.code("@Override");
		GeneratedJavaClass.code("public RTS_RTObject _STM() {");
		codeSTMBody();
		GeneratedJavaClass.code("EBLK();");
		GeneratedJavaClass.code("return(this);");
		GeneratedJavaClass.code("}", "End of " + declarationKind + " Statements");
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
		Util.println(s.toString());
		String beg = "begin[" + edScopeChain() + ']';
		Util.println(spc + beg);
		for (Declaration decl : declarationList) decl.print(indent + 1);
		for (Statement stm : statements) stm.print(indent + 1);
		Util.println(spc + "end[" + edScopeChain() + ']');
	}
	
	@Override
	public void printTree(final int indent) {
		System.out.println(edTreeIndent(indent)+"BLOCK "+identifier);
		printDeclarationList(indent+1);
		printStatementList(indent+1);
	}

	@Override
	public String toString() {
		return (identifier + '[' + externalIdent + "] Kind=" + declarationKind);
	}

}
