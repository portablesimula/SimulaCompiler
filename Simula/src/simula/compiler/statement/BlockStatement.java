/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.statement;

import simula.compiler.declaration.BlockDeclaration;
import simula.compiler.expression.Expression;
import simula.compiler.expression.SubscriptedVariable;
import simula.compiler.expression.Variable;
import simula.compiler.utilities.BlockKind;
import simula.compiler.utilities.Util;

/**
 * 
 * @author Øystein Myhre Andersen
 *
 */
public class BlockStatement extends Statement {
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

	public void doJavaCoding(String indent) {
		Util.setLine(lineNumber);
		ASSERT_SEMANTICS_CHECKED(this);

		//Util.BREAK("BlockStatement.doJavaCoding: blockKind="+blockDeclaration.blockKind);
		if(blockDeclaration.blockKind!=BlockKind.CompoundStatement)
		{ //String staticLink="this"; // TODO: Usikker på dette
		  String staticLink=blockDeclaration.edCTX(blockDeclaration.blockLevel-1);
		  Variable blockPrefix=blockDeclaration.blockPrefix;
		  StringBuilder s = new StringBuilder();
		  s.append("new ").append(getJavaIdentifier()).append('(');
		  s.append(staticLink);

		  if(blockPrefix instanceof SubscriptedVariable)
		  {	for (Expression par:((SubscriptedVariable)blockPrefix).checkedParams) {
			   s.append(',').append(par.toJavaCode());
		    }
		  }
		  s.append(')');
		  if(blockDeclaration.isDetachUsed()) 
			   s.append(".START();");
		  else s.append(".STM();");
		  Util.code(indent+s.toString());
		}
		blockDeclaration.doJavaCoding(indent);
	}

	public void print(String indent, String tail) {
		blockDeclaration.print(indent, tail);
	}

	public String toString() {
		return ("CALL " + blockDeclaration);
	}

}
