/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import simula.compiler.JavaModule;
import simula.compiler.expression.Expression;
import simula.compiler.expression.Variable;
import simula.compiler.parsing.Parser;
import simula.compiler.statement.BlockStatement;
import simula.compiler.statement.Statement;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public final class PrefixedBlockDeclaration extends ClassDeclaration {
	public Variable blockPrefix; // Block Prefix in case of Prefixed Block.

	// ***********************************************************************************************
	// *** CONSTRUCTOR
	// ***********************************************************************************************
	public PrefixedBlockDeclaration(String identifier) {
		super(identifier);
	}

	// ***********************************************************************************************
	// *** createPrefixedBlock
	// ***********************************************************************************************
	// Used by ProgramModule
	public static PrefixedBlockDeclaration createPrefixedBlock(final Variable blockPrefix) {
		PrefixedBlockDeclaration module = new PrefixedBlockDeclaration(Global.sourceName);
		module.isMainModule = true;
		module.blockKind = BlockKind.SimulaProgram;
		module.blockPrefix = blockPrefix;
		if (blockPrefix != null) {
			module.prefix = blockPrefix.identifier;
			module.blockKind = BlockKind.PrefixedBlock;
		} else module.prefix = "BASICIO";
		module.parsePrefixedBlock(blockPrefix);
		return (module);
	}

	// ***********************************************************************************************
	// *** Parsing: parsePrefixedBlock
	// ***********************************************************************************************
	/**
	 * Parse PrefixedBlock.
	 * 
	 * <pre>
	 * Syntax:
	 * 
	 *	 PrefixedBlock = prefix BEGIN [ { Declaration ; } ]  [ { Statement ; } ] END
	 *
	 * </pre>
	 * 
	 * @param blockPrefix
	 */
	public BlockStatement parsePrefixedBlock(final Variable blockPrefix) {
		Statement stm;
		if (blockPrefix != null) {
			this.blockPrefix = blockPrefix;
			this.prefix = blockPrefix.identifier;
		}
		// Util.BREAK("PrefixedBlockDeclaration.parseMaybeBlock: BlockPrefix="+blockPrefix);
		if (Option.TRACE_PARSE)	Parser.TRACE("Parse MayBeBlock");
		while (Declaration.parseDeclaration(declarationList)) Parser.accept(KeyWord.SEMICOLON);
		while (!Parser.accept(KeyWord.END)) {
			stm = Statement.doParse();
			// Util.BREAK("PrefixedBlockDeclaration.parseMaybeBlock: stm="+stm);
			if (stm != null) statements.add(stm);
		}
		if (blockKind != BlockKind.SimulaProgram) {
			if (blockPrefix != null) {
				blockKind = BlockKind.PrefixedBlock;
				if(isMainModule)
					 modifyIdentifier(Global.sourceName);
				else modifyIdentifier("" + Global.sourceName + "$PBLK" + lineNumber);
				this.externalIdent = this.identifier;
			} else if (!declarationList.isEmpty()) {
				blockKind = BlockKind.SubBlock;
				modifyIdentifier("SubBlock" + lineNumber);
			} else {
				blockKind = BlockKind.CompoundStatement;
				modifyIdentifier("CompoundStatement" + lineNumber);
				if (!labelList.isEmpty()) { // Label is also declaration
				    // Special case: Label in a Compound Statement.
					// Move Label Declaration to nearest enclosing
					// Block (with other declarations)

					// Util.BREAK("PrefixedBlockDeclaration.parseMaybeBlock: declaredIn="+declaredIn);
					DeclarationScope enc = declaredIn;
					while (enc.declarationList.isEmpty()) enc = enc.declaredIn;
					// Util.BREAK("PrefixedBlockDeclaration.parseMaybeBlock: Label is moved to enc="+enc);
					for (LabelDeclaration lab : labelList) enc.labelList.add(lab);
					labelList.clear();
				}
			}
		}
		this.lastLineNumber = Global.sourceLineNumber;
		Global.currentScope = declaredIn;
		return (new BlockStatement(this));
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
		// Util.BREAK("PrefixedBlockDeclaration("+identifier+").doChecking: blockPrefix="+blockPrefix);
		// Util.BREAK("PrefixedBlockDeclaration("+identifier+").doChecking: currentBlockLevel="+currentBlockLevel);
		// Util.BREAK("PrefixedBlockDeclaration("+identifier+").doChecking: blockLevel="+blockLevel);
		// Util.BREAK("PrefixedBlockDeclaration("+identifier+").doChecking: declaredIn="+declaredIn);

		if (blockPrefix != null) {
			Global.currentScope = this.declaredIn;
			blockPrefix.doChecking();
			this.prefix = blockPrefix.identifier;
			this.getPrefixClass().doChecking();
		}
		Global.currentScope = this;
		Util.ASSERT(parameterList.isEmpty(), "Invariant");
		Util.ASSERT(virtualSpecList.isEmpty(), "Invariant");
		Util.ASSERT(hiddenList.isEmpty(), "Invariant");
		Util.ASSERT(protectedList.isEmpty(), "Invariant");

		for (Declaration dcl : declarationList)	dcl.doChecking();
		for (Statement stm : statements) stm.doChecking();
		doCheckLabelList(this.getPrefixClass());
		Global.currentScope = declaredIn;
		currentBlockLevel--;
		SET_SEMANTICS_CHECKED();
	}

	// ***********************************************************************************************
	// *** Coding: doJavaCoding
	// ***********************************************************************************************
	public void doJavaCoding() {
		Global.sourceLineNumber = lineNumber;
		// Util.BREAK("PrefixedBlockDeclaration.doJavaCoding: "+identifier);
		ASSERT_SEMANTICS_CHECKED(this);
		JavaModule javaModule = new JavaModule(this);
		Global.currentScope = this;
		JavaModule.code("@SuppressWarnings(\"unchecked\")");
		String line = "public final class " + getJavaIdentifier();
		if (prefix != null)
			 line = line + " extends " + getPrefixClass().getJavaIdentifier();
		else line = line + " extends BASICIO$";
		JavaModule.code(line + " {");
		JavaModule.debug("// PrefixedBlockDeclaration: BlockKind=" + blockKind + ", BlockLevel=" + blockLevel
				+ ", firstLine=" + lineNumber + ", lastLine=" + lastLineNumber + ", hasLocalClasses="
				+ ((hasLocalClasses) ? "true" : "false") + ", System=" + ((isQPSystemBlock()) ? "true" : "false")
				+ ", detachUsed=" + ((detachUsed) ? "true" : "false"));
//		JavaModule.code("public int prefixLevel() { return(0); }");
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
		// for(VirtualSpecification virtual:virtualSpecList) virtual.doJavaCoding();
		for (VirtualMatch match : virtualMatchList)	match.doJavaCoding();
		doCodeConstructor();
		codeClassStatements();

		if (this.isMainModule) {
			JavaModule.code("");
			JavaModule.code("public static void main(String[] args) {");
			JavaModule.debug("//System.setProperty(\"file.encoding\",\"UTF-8\");");
			JavaModule.code("RT.setRuntimeOptions(args);");
			StringBuilder s = new StringBuilder();
			s.append("new " + getJavaIdentifier() + "(CTX$");
			if (blockPrefix != null && blockPrefix.hasArguments()) {
				for (Expression par : blockPrefix.checkedParams) {
					s.append(',').append(par.toJavaCode());
				}
			}
			s.append(").STM$();");
			JavaModule.code("" + s);
			JavaModule.code("}", "End of main");
		}
		javaModule.codeProgramInfo();
		JavaModule.code("}", "End of Class");
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
		} else JavaModule.code("super(staticLink);");
		JavaModule.debug("// Parameter assignment to locals");
		for (Parameter par : parameterList)
			JavaModule.code("this." + par.externalIdent + " = s" + par.externalIdent + ';');
		if (this.isMainModule)
			JavaModule.code("BPRG(\"" + identifier + "\");");
		JavaModule.debug("// Declaration Code");
		JavaModule.debug("TRACE_BEGIN_DCL$(\"" + identifier + "\"," + Global.sourceLineNumber + ");");
		for (Declaration decl : declarationList) decl.doDeclarationCoding();
		JavaModule.code("}");
	}

	// ***********************************************************************************************
	// *** Printing Utility: print
	// ***********************************************************************************************
	public void print(final int indent) {
    	String spc=edIndent(indent);
		StringBuilder s = new StringBuilder(spc);
		s.append('[').append(sourceBlockLevel).append(':').append(blockLevel).append("] ");
		if (prefix != null)	s.append(prefix).append(' ');
		s.append(blockKind).append(' ').append(identifier);
		s.append('[').append(externalIdent).append("] ");
		s.append(editParameterList());
		Util.println(s.toString());
		String beg = "begin[" + edScopeChain() + ']';
		Util.println(spc + beg);
		for (Declaration decl : declarationList) decl.print(indent + 1);
		for (Statement stm : statements) stm.print(indent + 1);
		Util.println(spc + "end[" + edScopeChain() + ']');
		// Util.BREAK("PrefixedBlockDeclaration.print DONE");
	}

	// ***********************************************************************************************
	// *** Printing Utility: editParameterList
	// ***********************************************************************************************
	private String editParameterList() {
		StringBuilder s = new StringBuilder();
		s.append('(');
		boolean first = true;
		for (Parameter par : parameterList) {
			if (!first)	s.append(',');
			s.append(par);
			first = false;
		}
		s.append(')');
		s.append(';');
		return (s.toString());
	}

	public String toString() {
		return ("" + identifier + '[' + externalIdent + "] BlockKind=" + blockKind + ", BlockPrefix=" + blockPrefix);
	}

}
