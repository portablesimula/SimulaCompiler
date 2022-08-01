/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import java.util.Vector;

import simula.compiler.JavaModule;
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
		MaybeBlockDeclaration module = new MaybeBlockDeclaration(Global.sourceName+'$');
		module.isMainModule = true;
		module.declarationKind = Declaration.Kind.SimulaProgram;
		module.parseMaybeBlock();
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
	public BlockStatement parseMaybeBlock() {
		Statement stm;
		if (Option.TRACE_PARSE)	Parser.TRACE("Parse MayBeBlock");
		while (Declaration.parseDeclaration(declarationList))
			Parser.accept(KeyWord.SEMICOLON);
		while (!Parser.accept(KeyWord.END)) {
			stm = Statement.doParse();
			if (stm != null) statements.add(stm);
		}
		if (declarationKind != Declaration.Kind.SimulaProgram) {
			if (!declarationList.isEmpty()) {
				declarationKind = Declaration.Kind.SubBlock;
				modifyIdentifier("SubBlock" + lineNumber);
			} else {
				declarationKind = Declaration.Kind.CompoundStatement;
				modifyIdentifier("CompoundStatement" + lineNumber);
				if (!labelList.isEmpty())
					moveLabelsFrom(this); // Label is also declaration
			}
		}
		this.lastLineNumber = Global.sourceLineNumber;
		Global.currentScope = declaredIn;
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
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber = lineNumber;
		if (externalIdent == null) externalIdent = edJavaClassName();
		if (declarationKind != Declaration.Kind.CompoundStatement) currentBlockLevel++;
		blockLevel = currentBlockLevel;
		Global.currentScope = this;
		for (Declaration dcl : declarationList)	dcl.doChecking();
		for (Statement stm : statements) stm.doChecking();
		doCheckLabelList(null);
		Global.currentScope = declaredIn;
		if (declarationKind != Declaration.Kind.CompoundStatement) currentBlockLevel--;
		SET_SEMANTICS_CHECKED();
	}

	// ***********************************************************************************************
	// *** Utility: findVisibleAttributeMeaning
	// ***********************************************************************************************
	public Meaning findVisibleAttributeMeaning(final String ident) {
		for (Declaration declaration : declarationList)
			if (ident.equalsIgnoreCase(declaration.identifier))
				return (new Meaning(declaration, this, this, false));
		for (LabelDeclaration label : labelList)
			if (ident.equalsIgnoreCase(label.identifier))
				return (new Meaning(label, this, this, false));
		return (null);
	}

	// ***********************************************************************************************
	// *** Coding: doJavaCoding
	// ***********************************************************************************************
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
		Global.currentScope = this;
		JavaModule.code("{");
		for (Statement stm : statements) stm.doJavaCoding();
		JavaModule.code("}");
		Global.currentScope = declaredIn;
	}

	// ***********************************************************************************************
	// *** Coding: SUBBLOCK ==> .java file
	// ***********************************************************************************************
	private void doSubBlockCoding() {
		Global.sourceLineNumber = lineNumber;
		ASSERT_SEMANTICS_CHECKED(this);
		JavaModule javaModule = new JavaModule(this);
		Global.currentScope = this;
		JavaModule.code("@SuppressWarnings(\"unchecked\")");
		JavaModule.code("public final class " + getJavaIdentifier() + " extends BASICIO$" + " {");
		JavaModule.debug("// SubBlock: Kind=" + declarationKind + ", BlockLevel=" + blockLevel + ", firstLine="
				+ lineNumber + ", lastLine=" + lastLineNumber + ", hasLocalClasses="
				+ ((hasLocalClasses) ? "true" : "false") + ", System=" + ((isQPSystemBlock()) ? "true" : "false"));
		if (isQPSystemBlock())
			JavaModule.code("public boolean isQPSystemBlock() { return(true); }");
		if (!labelList.isEmpty()) {
			JavaModule.debug("// Declare local labels");
			for (Declaration decl : labelList) decl.doJavaCoding();
		}
		JavaModule.debug("// Declare locals as attributes");
		for (Declaration decl : declarationList) decl.doJavaCoding();
		doCodeConstructor();
		doCodeStatements();
		if (this.isMainModule) {
			JavaModule.code("");
			JavaModule.code("public static void main(String[] args) {");
			JavaModule.debug("//System.setProperty(\"file.encoding\",\"UTF-8\");");
			JavaModule.code("RT.setRuntimeOptions(args);");
			JavaModule.code("new " + getJavaIdentifier() + "(CTX$).STM$();");
			JavaModule.code("}", "End of main");
		}
		javaModule.codeProgramInfo();
		JavaModule.code("}", "End of SubBlock");
		Global.currentScope = declaredIn;
		javaModule.closeJavaOutput();
	}

	// ***********************************************************************************************
	// *** Coding Utility: doCodeConstructor
	// ***********************************************************************************************
	private void doCodeConstructor() {
		JavaModule.debug("// Normal Constructor");
		JavaModule.code("public " + getJavaIdentifier() + "(RTObject$ staticLink) {");
		JavaModule.code("super(staticLink);");
		JavaModule.code("BBLK();");
		if (declarationKind == Declaration.Kind.SimulaProgram) JavaModule.code("BPRG(\"" + identifier + "\");");
		JavaModule.debug("// Declaration Code");
		for (Declaration decl : declarationList) decl.doDeclarationCoding();
		JavaModule.code("}");
	}

	// ***********************************************************************************************
	// *** Coding Utility: doCodeStatements
	// ***********************************************************************************************
	private void doCodeStatements() {
		JavaModule.debug("// " + declarationKind + " Statements");
		JavaModule.code("public RTObject$ STM$() {");
		codeSTMBody();
		JavaModule.code("EBLK();");
		JavaModule.code("return(this);");
		JavaModule.code("}", "End of " + declarationKind + " Statements");
	}

	// ***********************************************************************************************
	// *** Printing Utility: print
	// ***********************************************************************************************
	public void print(final int indent) {
    	String spc=edIndent(indent);
		StringBuilder s = new StringBuilder(spc);
		s.append('[').append(sourceBlockLevel).append(':').append(blockLevel).append("] ");
		s.append(declarationKind).append(' ').append(identifier);
		s.append('[').append(externalIdent).append("] ");
		Util.println(s.toString());
		String beg = "begin[" + edScopeChain() + ']';
		Util.println(spc + beg);
		for (Declaration decl : declarationList) decl.print(indent + 1);
		for (Statement stm : statements) stm.print(indent + 1);
		Util.println(spc + "end[" + edScopeChain() + ']');
	}

	public String toString() {
		return ("" + identifier + '[' + externalIdent + "] Kind=" + declarationKind);
	}

}
