/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler;

import simula.compiler.declaration.ClassDeclaration;
import simula.compiler.declaration.ConnectionBlock;
import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.ExternalDeclaration;
import simula.compiler.declaration.MaybeBlockDeclaration;
import simula.compiler.declaration.PrefixedBlockDeclaration;
import simula.compiler.declaration.ProcedureDeclaration;
import simula.compiler.declaration.StandardClass;
import simula.compiler.expression.Variable;
import simula.compiler.parsing.Parse;
import simula.compiler.statement.Statement;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Simula Program Module.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/ProgramModule.java"><b>Source File</b></a>.
 * 
 * <pre>
 * 
 * Syntax:
 *
 *		ProgramModule = SimulaProgram | ClassDeclaration | ProcedureDeclaration
 * 
 *			SimulaProgram = [ BlockPrefix ] Block | [ BlockPrefix ] CompoundStatement
 * 
 *				BlockPrefix = ClassIdentifier [ ( ActualParameterList ) ]
 *
 *			ProcedureDeclaration
 *			     = [ type ] PROCEDURE ProcedureIdentifier ProcedureHead ProcedureBody
 *
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public final class ProgramModule extends Statement {
	final private Variable sysin;
	final private Variable sysout;
	
	/**
	 * The module declaration.
	 */
	final Declaration module;

	/**
	 * Returns the module identifier.
	 * @return the module identifier
	 */
	String getIdentifier() { return(module.identifier); }

	/**
	 * Returns the relative file name.
	 * @return the relative file name
	 */
	String getRelativeAttributeFileName() {
		if(module.declarationKind==Declaration.Kind.Class) return(Global.packetName+"/CLASS.AF");
		if(module.declarationKind==Declaration.Kind.Procedure) return(Global.packetName+"/PROCEDURE.AF");
		else return(null);
	}
	  
	/**
	 * Returns true if this program module is executable.
	 * @return true if this program module is executable
	 */
	boolean isExecutable() {
		if(module.declarationKind==Declaration.Kind.SimulaProgram) return(true);
		if(module.declarationKind==Declaration.Kind.PrefixedBlock) return(true);
		else return(false);
	}

	/**
	 * Create a new ProgramModule.
	 */
	ProgramModule() {
		super(0);
		Declaration module=null;
		sysin=new Variable("sysin");
		sysout=new Variable("sysout");
		try	{
			if(Option.TRACE_PARSE) Parse.TRACE("Parse Program");
			Global.setScope(StandardClass.BASICIO);		    	// BASICIO Begin
			new ConnectionBlock(sysin,null)                     	//    Inspect sysin do
			     .setClassDeclaration(StandardClass.Infile);
			new ConnectionBlock(sysout,null)                    	//    Inspect sysout do
			     .setClassDeclaration(StandardClass.Printfile);
			Global.getCurrentScope().sourceBlockLevel=0;
			while(Parse.accept(KeyWord.EXTERNAL)) {
				ExternalDeclaration.doParse(StandardClass.ENVIRONMENT.declarationList);
				Parse.expect(KeyWord.SEMICOLON);
			}
			String ident=Parse.acceptIdentifier();
			if(ident!=null) {
				if(Parse.accept(KeyWord.CLASS)) module=ClassDeclaration.doParseClassDeclaration(ident);
			    else {
			    	Variable blockPrefix=Variable.parse(ident);	
			  	    Parse.expect(KeyWord.BEGIN);
		        	module=new PrefixedBlockDeclaration(null,blockPrefix,true);
			    }
			}
			else if(Parse.accept(KeyWord.BEGIN)) module=MaybeBlockDeclaration.createMainProgramBlock(); 
			else if(Parse.accept(KeyWord.CLASS)) module=ClassDeclaration.doParseClassDeclaration(null);
			else {
				Type type=Parse.acceptType();
			    if(Parse.expect(KeyWord.PROCEDURE)) module=ProcedureDeclaration.doParseProcedureDeclaration(type);
			}
			StandardClass.BASICIO.declarationList.add(module);
		
			if(Option.verbose) Util.TRACE("ProgramModule: END NEW SimulaProgram: "+toString());
		} catch(Throwable e) { Util.IERR("Impossible",e); }
		this.module=module;
	}	

	@Override
	public void doChecking() {
		if(IS_SEMANTICS_CHECKED()) return;
		sysin.doChecking();
		sysout.doChecking();
		module.doChecking();
		SET_SEMANTICS_CHECKED();
	}
  
	@Override
	public void doJavaCoding() { module.doJavaCoding(); }
	
	@Override
	public void print(final int indent) { module.print(0); }
	
	@Override
	public String toString() { return((module==null)?"":""+module.identifier); }
	
}
