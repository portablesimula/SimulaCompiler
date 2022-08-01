/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.expression.Expression;
import simula.compiler.expression.Variable;
import simula.compiler.parsing.Parser;
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
	public final Variable blockPrefix; // Block Prefix

	// ***********************************************************************************************
	// *** CONSTRUCTOR
	// ***********************************************************************************************
	/**
	 * PrefixedBlock.
	 * 
	 * <pre>
	 * Syntax:
	 * 
	 *	 PrefixedBlock = prefix BEGIN [ { Declaration ; } ]  [ { Statement ; } ] END
	 *
	 * </pre>
	 * 
	 * @param identifier
	 * @param blockPrefix
	 * @param isMainModule
	 */
	public PrefixedBlockDeclaration(String identifier,final Variable blockPrefix,boolean isMainModule) {
		super(identifier);
		this.declarationKind=Declaration.Kind.PrefixedBlock;
		Util.ASSERT(blockPrefix != null,"blockPrefix == null");
		this.blockPrefix = blockPrefix;
		this.prefix = blockPrefix.identifier;
		this.isMainModule=isMainModule;
		if (Option.TRACE_PARSE)	Parser.TRACE("Parse PrefixedBlock");
		while (Declaration.parseDeclaration(declarationList)) Parser.accept(KeyWord.SEMICOLON);
		while (!Parser.accept(KeyWord.END)) {
			Statement stm = Statement.doParse();
			if (stm != null) statements.add(stm);
		}
		if(isMainModule)
		     modifyIdentifier(Global.sourceName);
		else modifyIdentifier("" + Global.sourceName + "$PBLK" + lineNumber);
		this.externalIdent = this.identifier;
		this.lastLineNumber = Global.sourceLineNumber;
//		Global.currentScope = declaredIn;
		Global.setScope(declaredIn);
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
		if (blockPrefix != null) {
//			Global.currentScope = this.declaredIn;
			Global.enterScope(this.declaredIn);
			blockPrefix.doChecking();
			this.prefix = blockPrefix.identifier;
			this.getPrefixClass().doChecking();
			Global.exitScope();
		}
//		Global.currentScope = this;
		Global.enterScope(this);
		Util.ASSERT(parameterList.isEmpty(), "Invariant");
		Util.ASSERT(virtualSpecList.isEmpty(), "Invariant");
		Util.ASSERT(hiddenList.isEmpty(), "Invariant");
		Util.ASSERT(protectedList.isEmpty(), "Invariant");

		for (Declaration dcl : declarationList)	dcl.doChecking();
		for (Statement stm : statements) stm.doChecking();
		doCheckLabelList(this.getPrefixClass());
//		Global.currentScope = declaredIn;
		Global.exitScope();
		currentBlockLevel--;
		SET_SEMANTICS_CHECKED();
	}

	// ***********************************************************************************************
	// *** Coding: doJavaCoding
	// ***********************************************************************************************
	public void doJavaCoding() {
		Global.sourceLineNumber = lineNumber;
		ASSERT_SEMANTICS_CHECKED(this);
		GeneratedJavaClass javaModule = new GeneratedJavaClass(this);
//		Global.currentScope = this;
		Global.enterScope(this);
		GeneratedJavaClass.code("@SuppressWarnings(\"unchecked\")");
		String line = "public final class " + getJavaIdentifier();
		if (prefix != null)
			 line = line + " extends " + getPrefixClass().getJavaIdentifier();
		else line = line + " extends BASICIO$";
		GeneratedJavaClass.code(line + " {");
		GeneratedJavaClass.debug("// PrefixedBlockDeclaration: Kind=" + declarationKind + ", BlockLevel=" + blockLevel
				+ ", firstLine=" + lineNumber + ", lastLine=" + lastLineNumber + ", hasLocalClasses="
				+ ((hasLocalClasses) ? "true" : "false") + ", System=" + ((isQPSystemBlock()) ? "true" : "false")
				+ ", detachUsed=" + ((detachUsed) ? "true" : "false"));
		if (isQPSystemBlock())
			GeneratedJavaClass.code("public boolean isQPSystemBlock() { return(true); }");
		if (isDetachUsed())
			GeneratedJavaClass.code("public boolean isDetachUsed() { return(true); }");
		GeneratedJavaClass.debug("// Declare parameters as attributes");
		for (Parameter par : parameterList) {
			String tp = par.toJavaType();
			GeneratedJavaClass.code("public " + tp + ' ' + par.externalIdent + ';');
		}
		if (!labelList.isEmpty()) {
			GeneratedJavaClass.debug("// Declare local labels");
			for (Declaration decl : labelList) decl.doJavaCoding();
		}
		GeneratedJavaClass.debug("// Declare locals as attributes");
		for (Declaration decl : declarationList) decl.doJavaCoding();
		for (VirtualMatch match : virtualMatchList)	match.doJavaCoding();
		doCodeConstructor();
		codeClassStatements();

		if (this.isMainModule) {
			GeneratedJavaClass.code("");
			GeneratedJavaClass.code("public static void main(String[] args) {");
			GeneratedJavaClass.debug("//System.setProperty(\"file.encoding\",\"UTF-8\");");
			GeneratedJavaClass.code("RT.setRuntimeOptions(args);");
			StringBuilder s = new StringBuilder();
			s.append("new " + getJavaIdentifier() + "(CTX$");
			if (blockPrefix != null && blockPrefix.hasArguments()) {
				for (Expression par : blockPrefix.checkedParams) {
					s.append(',').append(par.toJavaCode());
				}
			}
			s.append(").STM$();");
			GeneratedJavaClass.code("" + s);
			GeneratedJavaClass.code("}", "End of main");
		}
		javaModule.codeProgramInfo();
		GeneratedJavaClass.code("}", "End of Class");
//		Global.currentScope = declaredIn;
		Global.exitScope();
		javaModule.closeJavaOutput();
	}

	// ***********************************************************************************************
	// *** Coding Utility: doCodeConstructor
	// ***********************************************************************************************
	private void doCodeConstructor() {
		GeneratedJavaClass.debug("// Normal Constructor");
		GeneratedJavaClass.code("public " + getJavaIdentifier() + edFormalParameterList(false));
		if (prefix != null) {
			ClassDeclaration prefixClass = this.getPrefixClass();
			GeneratedJavaClass.code("super" + prefixClass.edSuperParameterList());
		} else GeneratedJavaClass.code("super(staticLink);");
		GeneratedJavaClass.debug("// Parameter assignment to locals");
		for (Parameter par : parameterList)
			GeneratedJavaClass.code("this." + par.externalIdent + " = s" + par.externalIdent + ';');
		if (this.isMainModule)
			GeneratedJavaClass.code("BPRG(\"" + identifier + "\");");
		GeneratedJavaClass.debug("// Declaration Code");
		for (Declaration decl : declarationList) decl.doDeclarationCoding();
		GeneratedJavaClass.code("}");
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
		String beg = "begin[" + edScopeChain() + ']';
		Util.println(spc + beg);
		for (Declaration decl : declarationList) decl.print(indent + 1);
		for (Statement stm : statements) stm.print(indent + 1);
		Util.println(spc + "end[" + edScopeChain() + ']');
	}

	public String toString() {
		return ("" + identifier + '[' + externalIdent + "] Kind=" + declarationKind + ", BlockPrefix=" + blockPrefix);
	}

}