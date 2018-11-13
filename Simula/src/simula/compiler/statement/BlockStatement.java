/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.statement;

import simula.compiler.JavaModule;
import simula.compiler.declaration.BlockDeclaration;
import simula.compiler.declaration.BlockKind;
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
	public BlockDeclaration blockDeclaration;

	public String getJavaIdentifier() {
		return (blockDeclaration.getJavaIdentifier());
	}

	public BlockStatement(BlockDeclaration blockDeclaration) {
		this.blockDeclaration = blockDeclaration;
	}

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())
			return;
		blockDeclaration.doChecking();
		SET_SEMANTICS_CHECKED();
	}

	public void doJavaCoding() {
		Global.sourceLineNumber=lineNumber;
		ASSERT_SEMANTICS_CHECKED(this);

		//Util.BREAK("BlockStatement.doJavaCoding: blockKind="+blockDeclaration.blockKind+", QUAL="+blockDeclaration.getClass().getSimpleName());
		if(blockDeclaration.blockKind!=BlockKind.CompoundStatement)
		{ String staticLink=blockDeclaration.declaredIn.edCTX();
		  StringBuilder s = new StringBuilder();
		  s.append("new ").append(getJavaIdentifier()).append('(');
		  s.append(staticLink);

//		  if(blockPrefix!=null && blockPrefix.hasArguments())
//		  {	for (Expression par:blockPrefix.checkedParams) {
//			   s.append(',').append(par.toJavaCode());
//		    }
//		  }

		  if(blockDeclaration instanceof PrefixedBlockDeclaration)
		  { Variable blockPrefix=((PrefixedBlockDeclaration)blockDeclaration).blockPrefix;
			if(blockPrefix.hasArguments())
			  for (Expression par:blockPrefix.checkedParams) {
			   s.append(',').append(par.toJavaCode());
		    }
		  }
		  s.append(')');
		  if(blockDeclaration instanceof ClassDeclaration && ((ClassDeclaration)blockDeclaration).isDetachUsed())  // TODO: ER DETTE MULIG ?
			   s.append(".START();");
		  else s.append(".STM$();");
		  JavaModule.code(s.toString());
		}
		blockDeclaration.doJavaCoding();
	}

	public void print(String indent, String tail) {
		blockDeclaration.print(indent, tail);
	}

	public String toString() {
		return ("CALL " + blockDeclaration);
	}

}
