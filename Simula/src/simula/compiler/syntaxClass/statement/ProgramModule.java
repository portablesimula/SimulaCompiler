/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass.statement;

import simula.compiler.parsing.Parse;
import simula.compiler.syntaxClass.Type;
import simula.compiler.syntaxClass.declaration.ClassDeclaration;
import simula.compiler.syntaxClass.declaration.ConnectionBlock;
import simula.compiler.syntaxClass.declaration.Declaration;
import simula.compiler.syntaxClass.declaration.DeclarationScope;
import simula.compiler.syntaxClass.declaration.ExternalDeclaration;
import simula.compiler.syntaxClass.declaration.MaybeBlockDeclaration;
import simula.compiler.syntaxClass.declaration.PrefixedBlockDeclaration;
import simula.compiler.syntaxClass.declaration.ProcedureDeclaration;
import simula.compiler.syntaxClass.declaration.StandardClass;
import simula.compiler.syntaxClass.expression.VariableExpression;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Simula Program Module.
 * <p>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/statement/ProgramModule.java">
 * <b>Source File</b></a>.
 * 
 * <pre>
 * 
 * Simula Standard: Chapter 6 Program Modules
 *
 *      SIMULA-source-module
 *         = [ external-head ] ( program | procedure-declaration | class-declaration )
 *         
 *         external-head = external-declaration ; { external-declaration ; }
 *         
 *            external-declaration = external-procedure-declaration | external-class-declaration
 *            
 *			program = [ block-prefix ] block | [ block-prefix ] compound-statement
 * 
 *				block-prefix = class-identifier [ ( actual-parameter-part ) ]
 *
 *			procedure-declaration
 *			     = [ type ] PROCEDURE procedure-identifier procedure-head procedure-body
 *
 * </pre>
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 */
public final class ProgramModule extends Statement {
	
	/**
	 * The Variable SYSIN.
	 */
	final private VariableExpression sysin;
	
	/**
	 * The Variable SYSOUT.
	 */
	final private VariableExpression sysout;
	
	/**
	 * The module declaration.
	 */
	public final DeclarationScope module;

	/**
	 * Returns the module identifier.
	 * @return the module identifier
	 */
	public String getIdentifier() { return(module.identifier); }

	/**
	 * Returns the relative file name.
	 * @return the relative file name
	 */
	public String getRelativeAttributeFileName() {
		if(module.declarationKind==Declaration.Kind.Class) return(Global.packetName+"/CLASS.AF");
		if(module.declarationKind==Declaration.Kind.Procedure) return(Global.packetName+"/PROCEDURE.AF");
		else return(null);
	}
	  
	/**
	 * Returns true if this program module is executable.
	 * @return true if this program module is executable
	 */
	public boolean isExecutable() {
		if(module.declarationKind==Declaration.Kind.SimulaProgram) return(true);
		if(module.declarationKind==Declaration.Kind.PrefixedBlock) return(true);
		else return(false);
	}

	/**
	 * Create a new ProgramModule.
	 */
	public ProgramModule() {
		super(0);
		DeclarationScope module=null;
		sysin=new VariableExpression("sysin");
		sysout=new VariableExpression("sysout");
		try	{
			if(Option.TRACE_PARSE) Parse.TRACE("Parse Program");
			Global.setScope(StandardClass.BASICIO);		    	// BASICIO Begin
			new ConnectionBlock(sysin,null)                     	//    Inspect sysin do
			     .setClassDeclaration(StandardClass.Infile);
			new ConnectionBlock(sysout,null)                    	//    Inspect sysout do
			     .setClassDeclaration(StandardClass.Printfile);
			Global.getCurrentScope().sourceBlockLevel=0;
			while(Parse.accept(KeyWord.EXTERNAL)) {
				ExternalDeclaration.expectExternalHead(StandardClass.ENVIRONMENT.declarationList);
				Parse.expect(KeyWord.SEMICOLON);
			}
			String ident=Parse.acceptIdentifier();
			if(ident!=null) {
				if(Parse.accept(KeyWord.CLASS)) module=ClassDeclaration.expectClassDeclaration(ident);
			    else {
			    	VariableExpression blockPrefix=VariableExpression.expectVariable(ident);	
			    	
			  	    Parse.expect(KeyWord.BEGIN);
		        	module=PrefixedBlockDeclaration.expectPrefixedBlock(blockPrefix,true);
			    }
			}
			else if(Parse.accept(KeyWord.BEGIN)) module=MaybeBlockDeclaration.createMainProgramBlock(); 
			else if(Parse.accept(KeyWord.CLASS)) module=ClassDeclaration.expectClassDeclaration(null);
			else {
				Type type=Parse.acceptType();
			    if(Parse.expect(KeyWord.PROCEDURE)) module=ProcedureDeclaration.expectProcedureDeclaration(type);
			}
			StandardClass.BASICIO.declarationList.add(module);
		
			if(Option.verbose) Util.TRACE("ProgramModule: END NEW SimulaProgram: "+toString());
		} catch(Throwable e) { Util.IERR("Impossible",e); }
		this.module=module;
//		if(Option.PRINT_SYNTAX_TREE) module.printTree(0);
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
	public void printTree(int indent) {
		System.out.println("=========== Resulting Syntax Tree after Checking ================");
		module.printTree(0);
		System.out.println("=================================================================");
	}
	
	@Override
	public String toString() { return((module==null)?"":""+module.identifier); }
	
}
