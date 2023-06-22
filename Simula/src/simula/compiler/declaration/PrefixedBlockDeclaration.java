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
	 *		prefix = class-identifier [ actual-parameter-part ]
	 *
	 * </pre>
	 */
	public PrefixedBlockDeclaration(String identifier,final Variable blockPrefix,boolean isMainModule) {
		super(identifier);
		this.lineNumber=Parser.prevToken.lineNumber;
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
		else modifyIdentifier("" + Global.sourceName + "_PBLK" + lineNumber);
		this.externalIdent = this.identifier;
		this.lastLineNumber = Global.sourceLineNumber;
		if(Option.TESTING) System.out.println("Line "+this.lineNumber+": PrefixedBlockDeclaration: "+this);
		Global.setScope(declaredIn);
	}

	// ***********************************************************************************************
	// *** Checking
	// ***********************************************************************************************
	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber = lineNumber;
		if (externalIdent == null) externalIdent = edJavaClassName();
		currentRTBlockLevel++;
		rtBlockLevel = currentRTBlockLevel;
		if (blockPrefix != null) {
			Global.enterScope(this.declaredIn);
			blockPrefix.doChecking();
			this.prefix = blockPrefix.identifier;
			ClassDeclaration prefix=this.getPrefixClass();
			if(prefix!=null) prefix.doChecking();
			Global.exitScope();
		}
		Global.enterScope(this);
		Util.ASSERT(parameterList.isEmpty(), "Invariant");
		Util.ASSERT(virtualSpecList.isEmpty(), "Invariant");
		Util.ASSERT(hiddenList.isEmpty(), "Invariant");
		Util.ASSERT(protectedList.isEmpty(), "Invariant");

		for (Declaration dcl : declarationList)	dcl.doChecking();
		for (Statement stm : statements) stm.doChecking();
		doCheckLabelList(this.getPrefixClass());
		Global.exitScope();
		currentRTBlockLevel--;
		SET_SEMANTICS_CHECKED();
	}

	// ***********************************************************************************************
	// *** Coding: doJavaCoding
	// ***********************************************************************************************
	@Override
	public void doJavaCoding() {
		Global.sourceLineNumber = lineNumber;
		ASSERT_SEMANTICS_CHECKED(this);
		GeneratedJavaClass javaModule = new GeneratedJavaClass(this);
		Global.enterScope(this);
		Global.duringSTM_Coding=false;
		GeneratedJavaClass.code("@SuppressWarnings(\"unchecked\")");
		String line = "public final class " + getJavaIdentifier();
		if (prefix != null)
			 line = line + " extends " + getPrefixClass().getJavaIdentifier();
		else line = line + " extends _BASICIO";
		GeneratedJavaClass.code(line + " {");
		GeneratedJavaClass.debug("// PrefixedBlockDeclaration: Kind=" + declarationKind + ", BlockLevel=" + rtBlockLevel
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
		boolean duringSTM_Coding=Global.duringSTM_Coding;
		Global.duringSTM_Coding=true;
		codeClassStatements();
		Global.duringSTM_Coding=duringSTM_Coding;

		if (this.isMainModule) {
			GeneratedJavaClass.code("");
			GeneratedJavaClass.code("public static void main(String[] args) {");
			GeneratedJavaClass.debug("//System.setProperty(\"file.encoding\",\"UTF-8\");");
			GeneratedJavaClass.code("_RT.setRuntimeOptions(args);");
			StringBuilder s = new StringBuilder();
			s.append("new " + getJavaIdentifier() + "(CTX_");
			if (blockPrefix != null && blockPrefix.hasArguments()) {
				for (Expression par : blockPrefix.checkedParams) {
					s.append(',').append(par.toJavaCode());
				}
			}
			s.append(")._STM();");
			GeneratedJavaClass.code("" + s);
			GeneratedJavaClass.code("}", "End of main");
		}
		javaModule.codeProgramInfo();
		GeneratedJavaClass.code("}", "End of Class");
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
	@Override
	public void print(final int indent) {
    	String spc=edIndent(indent);
		StringBuilder s = new StringBuilder(spc);
		s.append('[').append(sourceBlockLevel).append(':').append(rtBlockLevel).append("] ");
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

	@Override
	public String toString() {
		return ("" + identifier + '[' + externalIdent + "] Kind=" + declarationKind + ", BlockPrefix=" + blockPrefix);
	}

}
