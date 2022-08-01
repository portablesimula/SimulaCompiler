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
import simula.compiler.statement.Statement;

/**
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public abstract class BlockDeclaration extends DeclarationScope {
	public int lastLineNumber;
	public boolean isMainModule; // If true; this is the outermost Subblock or Prefixed Block.
	public boolean isContextFree; // If true; all member methods are independent of context
	public boolean isPreCompiled; // If true; this Class/Procedure is Pre-Compiled
	public final Vector<Statement> statements = new Vector<Statement>();

	// ***********************************************************************************************
	// *** CONSTRUCTORS
	// ***********************************************************************************************
	// Used by parseMaybeBlock, i.e. CompoundStatement, SubBlock or PrefixedBlock.
	public BlockDeclaration(String identifier) {
		super(identifier);
	}

	// Used by ClassDeclaration and ProcedureDeclaration
	public BlockDeclaration(final String identifier,final Declaration.Kind declarationKind) {
		super(identifier);
		this.declarationKind = declarationKind;
	}

	// ***********************************************************************************************
	// *** Utility: prefixLevel
	// ***********************************************************************************************
	protected int prefixLevel() {
		return (0);
	} // Needs redefinition for Class and Prefixed Block

	// ***********************************************************************************************
	// *** Checking: doCheckLabelList
	// ***********************************************************************************************
	protected void doCheckLabelList(final ClassDeclaration prefixClass) {
		int labelIndex = (prefixClass == null)?(1) : prefixClass.getNlabels() + 1;
		for (LabelDeclaration label : labelList) label.index = labelIndex++;
	}

	// ***********************************************************************************************
	// *** Coding: isBlockWithLocalClasses
	// ***********************************************************************************************
	public boolean isBlockWithLocalClasses() {
		if (this.hasLocalClasses) return (true);
		if (this instanceof ClassDeclaration) {
			ClassDeclaration prfx = ((ClassDeclaration) this).getPrefixClass();
			if (prfx != null) return (prfx.isBlockWithLocalClasses());
		}
		return (false);
	}

	// ***********************************************************************************************
	// *** Coding: isQPSystemBlock -- QPS System is any block with local class(es)
	// ***********************************************************************************************
	public boolean isQPSystemBlock() {
		switch (declarationKind) {
		case SimulaProgram:
		case SubBlock:
		case PrefixedBlock:
			return (isBlockWithLocalClasses());
		default:
			return (false);
		}
	}

	// ***********************************************************************************************
	// *** Coding Utility: hasLabel
	// ***********************************************************************************************
	protected boolean hasLabel() {
		// Needs redefinition for ClassDeclaration
		return (!labelList.isEmpty());
	}

	// ***********************************************************************************************
	// *** Coding Utility: codeSTMBody
	// ***********************************************************************************************
	protected void codeSTMBody() {
		if (hasLabel()) {
			JavaModule.code(externalIdent + " THIS$=(" + externalIdent + ")CUR$;");
			JavaModule.code("LOOP$:while(JTX$>=0) {");
			JavaModule.code("try {");
			if (hasLabel())
				JavaModule.code("JUMPTABLE$(JTX$);","For ByteCode Engineering");
		}
		codeStatements();
		if (hasLabel()) {
			JavaModule.code("break LOOP$;");
			JavaModule.code("}");
			JavaModule.code("catch(LABQNT$ q) {");
			JavaModule.code("CUR$=THIS$;");
			JavaModule.code("if(q.SL$!=CUR$) {");
			JavaModule.debug("if(RT.Option.GOTO_TRACING) TRACE_GOTO(\"" + identifier + ":NON-LOCAL\",q);");
			JavaModule.code("CUR$.STATE$=OperationalState.terminated;");
			JavaModule.debug("if(RT.Option.GOTO_TRACING) TRACE_GOTO(\"" + identifier + ":RE-THROW\",q);");
			JavaModule.code("throw(q);");
			JavaModule.code("}");
			JavaModule.debug("if(RT.Option.GOTO_TRACING) TRACE_GOTO(\"" + identifier + ":LOCAL\",q);");
			JavaModule.code("JTX$=q.index; continue LOOP$;","EG. GOTO Lx");
			JavaModule.code("}");
			JavaModule.code("}");
		}
	}

	// ***********************************************************************************************
	// *** Coding Utility: codeStatements
	// ***********************************************************************************************
	protected void codeStatements() {
		for (Statement stm : statements) stm.doJavaCoding();
	}

	public String toString() {
		return ("" + identifier + '[' + externalIdent + "] Declaration.Kind=" + declarationKind);
	}

}
