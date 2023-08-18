/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass.declaration;

import simula.compiler.syntaxClass.Type;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Standard Procedure.
 * <p>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/declaration/StandardProcedure.java">
 * <b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 */
public final class StandardProcedure extends ProcedureDeclaration {
	
	/**
	 * Create a new StandardProcedure without parameters.
	 * @param declaredIn the enclosing scope
	 * @param kind the declaration kind
	 * @param type the procedure's type
	 * @param ident the procedure identifier
	 */
	StandardProcedure(DeclarationScope declaredIn,Declaration.Kind kind,Type type, String ident) {
		super(ident,kind); this.declaredIn=declaredIn; this.type=type; }

	/**
	 * Create a new StandardProcedure with parameters.
	 * @param declaredIn the enclosing scope
	 * @param kind the declaration kind
	 * @param type the procuedre's type
	 * @param ident the procedure identifier
	 * @param param the parameters
	 */
	StandardProcedure(DeclarationScope declaredIn,Declaration.Kind kind,Type type, String ident,Parameter... param) {
		this(declaredIn,kind,type,ident);
		for(int i=0;i<param.length;i++) param[i].into(parameterList); }

	@Override
	public void doChecking() {
		if(IS_SEMANTICS_CHECKED()) return;
		Global.enterScope(this);
		Global.sourceLineNumber=lineNumber;
		String name=this.getClass().getSimpleName();
		if(Option.TRACE_CHECKER) Util.TRACE("BEGIN "+name+".doChecking");
		Global.exitScope();
		if(Option.TRACE_CHECKER) Util.TRACE("END StandardProcedure("+toString()+").doChecking - Result type="+this.type);
		SET_SEMANTICS_CHECKED();
	}

	@Override
	public String toString() {
		String pfx=""; if(type!=null) pfx=type.toString()+" ";
		return(pfx+"PROCEDURE "+identifier);
	}


	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	/**
	 * Default constructor used by Externalization.
	 */
	public StandardProcedure() {}

}
