/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

public final class StandardProcedure extends ProcedureDeclaration {
	public boolean overloaded;
	public StandardProcedure(DeclarationScope declaredIn,Declaration.Kind kind,Type type, String ident)
	{ super(ident,kind); this.declaredIn=declaredIn; this.type=type; }

	public StandardProcedure(DeclarationScope declaredIn,Declaration.Kind kind,Type type, String ident,Parameter... param) {
		this(declaredIn,kind,type,ident);
		for(int i=0;i<param.length;i++) param[i].into(parameterList);
	}

	@Override
	public void doChecking() {
		if(_ISSEMANTICS_CHECKED()) return;
		Global.enterScope(this);
		Global.sourceLineNumber=lineNumber;
		String name=this.getClass().getSimpleName();
		if(Option.TRACE_CHECKER) Util.TRACE("BEGIN "+name+".doChecking");
		Global.exitScope();
		if(Option.TRACE_CHECKER) Util.TRACE("END StandardProcedure("+toString()+").doChecking - Result type="+this.type);
		SET_SEMANTICS_CHECKED();
	}

	@Override
	public String toString()
	{ String pfx=""; if(type!=null) pfx=type.toString()+" ";
	return(pfx+"PROCEDURE "+identifier);
	}


	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	public StandardProcedure() {
	}

}
