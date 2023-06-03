/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import java.util.Vector;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.parsing.Parser;
import simula.compiler.statement.BlockStatement;
import simula.compiler.statement.Statement;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public final class MaybeBlockDeclaration extends BlockDeclaration {

	// ***********************************************************************************************
	// *** CONSTRUCTORS
	// ***********************************************************************************************
	// Used by parseMaybeBlock, i.e. CompoundStatement or SubBlock.
	public MaybeBlockDeclaration(final String identifier) {
		super(identifier);
	}

	// ***********************************************************************************************
	// *** createMaybeBlock
	// ***********************************************************************************************
	// Used by ProgramModule
	public static MaybeBlockDeclaration createMaybeBlock() {
		int lineNumber=Parser.prevToken.lineNumber;
		if(Option.TESTING) System.out.println("BlockStatement.createMaybeBlock: line="+lineNumber+" "+Parser.prevToken);
		MaybeBlockDeclaration module = new MaybeBlockDeclaration("_Block_"+Global.sourceName);
		module.isMainModule = true;
		module.declarationKind = Declaration.Kind.SimulaProgram;
		module.parseMaybeBlock(lineNumber);
		return (module);
	}

	// ***********************************************************************************************
	// *** Parsing: parseMaybeBlock
	// ***********************************************************************************************
	/**
	 * Parse CompoundStatement, SubBlock or PrefixedBlock.
	 * 
	 * <pre>
	 * Syntax:
	 * 
	 * Block = CompoundStatement | SubBlock
	 * 
	 *	 CompoundStatement = BEGIN [ { Statement ; } ] END
	 * 	 SubBlock = BEGIN [ { Declaration ; } ]  [ { Statement ; } ] END
	 *
	 * </pre>
	 * 
	 * @param blockPrefix
	 */
	public BlockStatement parseMaybeBlock(int line) {
		this.lineNumber=line;
		if (Option.TRACE_PARSE)	Parser.TRACE("Parse MayBeBlock");
		//if(Option.TESTING) System.out.println("BlockStatement.parseMaybeBlock: "+this);
		while (Declaration.parseDeclaration(declarationList))
			Parser.accept(KeyWord.SEMICOLON);
		while (!Parser.accept(KeyWord.END)) {
			Statement stm = Statement.doParse();
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

	public static void moveLabelsFrom(DeclarationScope block) {
		// Special case: Labels in a CompoundStatement or ConnectionBlock.
		// Move Label Declaration to nearest enclosing Block which is not
		// a CompoundStatement or ConnectionBlock.
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
		if (_ISSEMANTICS_CHECKED())	return;
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
		//Util.BREAK("MaybeBlockDeclaration.findVisibleAttributeMeaning: "+identifier+", Lookup ident="+ident);
		if(Option.TRACE_FIND>0) Util.message("BEGIN Checking MayBeBlock for "+ident+" ================================== "+identifier+" ==================================");
		for (Declaration declaration : declarationList) {
			if(Option.TRACE_FIND>1) Util.message("Checking Local "+declaration);
			if (Util.equals(ident, declaration.identifier))
				return (new Meaning(declaration, this, this, false));
		}
		for (LabelDeclaration label : labelList) {
			if(Option.TRACE_FIND>1) Util.message("Checking Label "+label);
			if (Util.equals(ident, label.identifier))
				return (new Meaning(label, this, this, false));
		}
		if(Option.TRACE_FIND>0) Util.message("ENDOF Checking MayBeBlock for "+ident+" ================================== "+identifier+" ==================================");
		return (null);
	}

	// ***********************************************************************************************
	// *** Coding: doJavaCoding
	// ***********************************************************************************************
	@Override
	public void doJavaCoding() {
		ASSERT_SEMANTICS_CHECKED(this);
		if (this.isPreCompiled)	return;
		if (declarationKind == Declaration.Kind.CompoundStatement)
			 doCompoundStatementCoding();
		else doSubBlockCoding();
	}

	// ***********************************************************************************************
	// *** Coding: CompoundStatement as Java Subblock
	// ***********************************************************************************************
	private void doCompoundStatementCoding() {
		Global.sourceLineNumber = lineNumber;
		ASSERT_SEMANTICS_CHECKED(this);
		Util.ASSERT(declarationList.isEmpty(), "Invariant");
		Util.ASSERT(labelList.isEmpty(), "Invariant");
		Global.enterScope(this);
		GeneratedJavaClass.code("{");
		if(labelcode!=null) {
			for(String labCode:labelcode) GeneratedJavaClass.code(labCode);
		}
		for (Statement stm : statements) stm.doJavaCoding();
		GeneratedJavaClass.code("}");
		Global.exitScope();
	}

	// ***********************************************************************************************
	// *** Coding: SUBBLOCK ==> .java file
	// ***********************************************************************************************
	private void doSubBlockCoding() {
		Global.sourceLineNumber = lineNumber;
		ASSERT_SEMANTICS_CHECKED(this);
		GeneratedJavaClass javaModule = new GeneratedJavaClass(this);
		Global.enterScope(this);
		Global.duringSTM_Coding=false;
		GeneratedJavaClass.code("@SuppressWarnings(\"unchecked\")");
		GeneratedJavaClass.code("public final class " + getJavaIdentifier() + " extends _BASICIO" + " {");
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
			GeneratedJavaClass.code("_RT.setRuntimeOptions(args);");
			GeneratedJavaClass.code("new " + getJavaIdentifier() + "(CTX_)._STM();");
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
	private void doCodeConstructor() {
		GeneratedJavaClass.debug("// Normal Constructor");
		GeneratedJavaClass.code("public " + getJavaIdentifier() + "(_RTObject staticLink) {");
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
	private void doCodeStatements() {
		GeneratedJavaClass.debug("// " + declarationKind + " Statements");
		GeneratedJavaClass.code("public _RTObject _STM() {");
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
	public String toString() {
		return (identifier + '[' + externalIdent + "] Kind=" + declarationKind);
	}

}
