/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.statement;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.BlockDeclaration;
import simula.compiler.declaration.ClassDeclaration;
import simula.compiler.declaration.PrefixedBlockDeclaration;
import simula.compiler.expression.Expression;
import simula.compiler.expression.Variable;
import simula.compiler.utilities.Global;

/**
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class BlockStatement extends Statement {
	public final BlockDeclaration blockDeclaration;

	public String getJavaIdentifier() {
		return (blockDeclaration.getJavaIdentifier());
	}

	public BlockStatement(final BlockDeclaration blockDeclaration) {
		this.blockDeclaration = blockDeclaration;
	}
	
	public boolean isCompoundStatement() {
		return(blockDeclaration.declarationKind == Declaration.Kind.CompoundStatement);
	}

	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		blockDeclaration.doChecking();
		SET_SEMANTICS_CHECKED();
	}

	public void addLeadingLabel(String labelcode) {
		blockDeclaration.addLeadingLabel(labelcode);
	}
	
	@Override
	public void doJavaCoding() {
		Global.sourceLineNumber=lineNumber;
		ASSERT_SEMANTICS_CHECKED(this);
		if(blockDeclaration.declarationKind!=Declaration.Kind.CompoundStatement)
		{ String staticLink=blockDeclaration.declaredIn.edCTX();
		  StringBuilder s = new StringBuilder();
		  s.append("new ").append(getJavaIdentifier()).append('(');
		  s.append(staticLink);
		  if(blockDeclaration instanceof PrefixedBlockDeclaration)
		  { Variable blockPrefix=((PrefixedBlockDeclaration)blockDeclaration).blockPrefix;
			if(blockPrefix.hasArguments())
			  for (Expression par:blockPrefix.checkedParams) {
			   s.append(',').append(par.toJavaCode());
		    }
		  }
		  s.append(')');
		  if(blockDeclaration.declarationKind==Declaration.Kind.PrefixedBlock && ((ClassDeclaration)blockDeclaration).isDetachUsed())
			   s.append(".START$();");
		  else s.append(".STM$();");
		  GeneratedJavaClass.code(s.toString());
		}
		blockDeclaration.doJavaCoding();
	}

	@Override
	public void print(final int indent) {
		blockDeclaration.print(indent);
	}

	@Override
	public String toString() {
		return ("CALL " + blockDeclaration);
	}

}
