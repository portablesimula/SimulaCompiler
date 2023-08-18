/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass.statement;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.syntaxClass.declaration.BlockDeclaration;
import simula.compiler.syntaxClass.declaration.ClassDeclaration;
import simula.compiler.syntaxClass.declaration.Declaration;
import simula.compiler.syntaxClass.declaration.PrefixedBlockDeclaration;
import simula.compiler.syntaxClass.expression.Expression;
import simula.compiler.syntaxClass.expression.VariableExpression;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * BlockStatement.
 * <pre>
 * Simula Standard: 4.10 Blocks
 * 
 *   block
 *      = subblock
 *      | prefixed-block
 *      
 *         subblock = BEGIN declaration { ; declaration } ; statement { ; statement } END
 *         
 *         prefixed-block
 *            = block-prefix main-block
 *            
 *            block-prefix
 *               = class-identifier [ actual-parameter-part ]
 *               
 *            main-block
 *            
 *               = block
 *               | BEGIN statement { ; statement } END
 * </pre>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/statement/BlockStatement.java">
 * <b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public final class BlockStatement extends Statement {
	
	/**
	 * The associated block declaration.
	 */
	private final BlockDeclaration blockDeclaration;

	/**
	 * Create a new BlockStatement.
	 * @param blockDeclaration the BlockDeclaration
	 */
	public BlockStatement(final BlockDeclaration blockDeclaration) {
		super(blockDeclaration.lineNumber);
		this.blockDeclaration = blockDeclaration;
		if (Option.TRACE_PARSE) Util.TRACE("Line "+lineNumber+": BlockStatement: "+this);
	}
	
	/**
	 * Check if this BlockStatement is a CompoundStatement.
	 * @return true if this BlockStatement is a CompoundStatement
	 */
	boolean isCompoundStatement() {
		return(blockDeclaration.declarationKind == Declaration.Kind.CompoundStatement);
	}

	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		blockDeclaration.doChecking();
		SET_SEMANTICS_CHECKED();
	}

	/**
	 * Add a leading label to this BlockStatement.
	 * @param labelcode the label code
	 */
	void addLeadingLabel(String labelcode) {
		blockDeclaration.addLeadingLabel(labelcode);
	}
	
	@Override
	public void doJavaCoding() {
		Global.sourceLineNumber=lineNumber;
		ASSERT_SEMANTICS_CHECKED();
		if(blockDeclaration.declarationKind!=Declaration.Kind.CompoundStatement) {
			String staticLink=blockDeclaration.declaredIn.edCTX();
			StringBuilder s = new StringBuilder();
			s.append("new ").append(blockDeclaration.getJavaIdentifier()).append('(');
			s.append(staticLink);
			if(blockDeclaration instanceof PrefixedBlockDeclaration pref) {
				VariableExpression blockPrefix=pref.blockPrefix;
				if(blockPrefix.hasArguments())
					for (Expression par:blockPrefix.checkedParams) {
						s.append(',').append(par.toJavaCode());
					}
			}
			s.append(')');
			if(blockDeclaration.declarationKind==Declaration.Kind.PrefixedBlock && ((ClassDeclaration)blockDeclaration).isDetachUsed())
				s.append("._START();");
			else s.append("._STM();");
			GeneratedJavaClass.code(s.toString());
		}
		blockDeclaration.doJavaCoding();
	}

	@Override
	public void print(final int indent) {
		blockDeclaration.print(indent);
	}
	
	@Override
	public void printTree(final int indent) {
		blockDeclaration.printTree(indent);
	}

	@Override
	public String toString() {
		return ("BLOCK " + blockDeclaration);
	}

}
