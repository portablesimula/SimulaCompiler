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
import simula.compiler.statement.Statement;
import simula.compiler.utilities.Global;

/**
 * Block Declaration.
 * <p>
 * This class is prefix to ClassDeclaration, ProcedureDeclaration and MaybeBlockDeclaration.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/declaration/BlockDeclaration.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 */
public abstract class BlockDeclaration extends DeclarationScope {
	protected boolean isMainModule; // If true; this is the outermost Subblock or Prefixed Block.
	protected final Vector<Statement> statements = new Vector<Statement>();

	/**
	 * Last source line number
	 */
	public int lastLineNumber;
	
	/**
	 * If true; all member methods are independent of context
	 */
	public boolean isContextFree;
	
	/**
	 * If true; this Class/Procedure is Pre-Compiled
	 */
	public boolean isPreCompiled;

	// ***********************************************************************************************
	// *** CONSTRUCTORS
	// ***********************************************************************************************
	// Used by parseMaybeBlock, i.e. CompoundStatement, SubBlock or PrefixedBlock.
	protected BlockDeclaration(String identifier) {
		super(identifier);
	}

	// Used by ClassDeclaration and ProcedureDeclaration
	private BlockDeclaration(final String identifier,final Declaration.Kind declarationKind) {
		super(identifier);
		this.declarationKind = declarationKind;
	}

	// ***********************************************************************************************
	// *** Utility: prefixLevel
	// ***********************************************************************************************
//	protected int prefixLevel() {
//		return (0);
//	} // Needs redefinition for Class and Prefixed Block

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
	protected boolean isBlockWithLocalClasses() {
		if (this.hasLocalClasses) return (true);
		if (this instanceof ClassDeclaration cls) {
			ClassDeclaration prfx = cls.getPrefixClass();
			if (prfx != null) return (prfx.isBlockWithLocalClasses());
		}
		return (false);
	}

	// ***********************************************************************************************
	// *** Coding: isQPSystemBlock -- QPS System is any block with local class(es)
	// ***********************************************************************************************
	protected boolean isQPSystemBlock() {
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
	// *** Coding Utility: AD'HOC Leading Label
	// ***********************************************************************************************
	protected Vector<String> labelcode;
	
	/**
	 * Coding Utility: AD'HOC Leading Label
	 * @param labelcode argument
	 */
	public void addLeadingLabel(String labelcode) {
		if(this.labelcode==null) this.labelcode=new Vector<String>();
		this.labelcode.add(labelcode);
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
			GeneratedJavaClass.code(externalIdent + " _THIS=(" + externalIdent + ")_CUR;");
			GeneratedJavaClass.code("_LOOP:while(_JTX>=0) {");
			GeneratedJavaClass.code("try {");
			GeneratedJavaClass.code("_JUMPTABLE(_JTX);","For ByteCode Engineering");
			Global.currentJavaModule.mustDoByteCodeEngineering=true;
		}
		codeStatements();
		if (hasLabel()) {
			GeneratedJavaClass.code("break _LOOP;");
			GeneratedJavaClass.code("}");
			GeneratedJavaClass.code("catch(_LABQNT q) {");
			GeneratedJavaClass.code("_CUR=_THIS;");
			GeneratedJavaClass.code("if(q._SL!=_CUR) {");
			GeneratedJavaClass.debug("if(_RT.Option.GOTO_TRACING) TRACE_GOTO(\"" + identifier + ":NON-LOCAL\",q);");
			GeneratedJavaClass.code("_CUR.STATE_=OperationalState.terminated;");
			GeneratedJavaClass.debug("if(_RT.Option.GOTO_TRACING) TRACE_GOTO(\"" + identifier + ":RE-THROW\",q);");
			GeneratedJavaClass.code("throw(q);");
			GeneratedJavaClass.code("}");
			GeneratedJavaClass.debug("if(_RT.Option.GOTO_TRACING) TRACE_GOTO(\"" + identifier + ":LOCAL\",q);");
			GeneratedJavaClass.code("_JTX=q.index; continue _LOOP;","EG. GOTO Lx");
			GeneratedJavaClass.code("}");
			GeneratedJavaClass.code("}");
		}
	}

	// ***********************************************************************************************
	// *** Coding Utility: codeStatements
	// ***********************************************************************************************
	protected void codeStatements() {
		boolean duringSTM_Coding=Global.duringSTM_Coding;
		Global.duringSTM_Coding=true;
		for (Statement stm : statements) stm.doJavaCoding();
		Global.duringSTM_Coding=duringSTM_Coding;
	}

	@Override
	public String toString() {
		return ("" + identifier + '[' + externalIdent + "] Declaration.Kind=" + declarationKind);
	}

}
