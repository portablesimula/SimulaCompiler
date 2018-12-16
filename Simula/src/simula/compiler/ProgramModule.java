/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler;

import simula.compiler.declaration.BlockKind;
import simula.compiler.declaration.ClassDeclaration;
import simula.compiler.declaration.ConnectionBlock;
import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.MaybeBlockDeclaration;
import simula.compiler.declaration.PrefixedBlockDeclaration;
import simula.compiler.declaration.ProcedureDeclaration;
import simula.compiler.declaration.StandardClass;
import simula.compiler.expression.Variable;
import simula.compiler.parsing.Parser;
import simula.compiler.statement.Statement;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Simula Program.
 * 
 * <pre>
 * 
 * Syntax:
 *
 * ProgramModule = SimulaPrpgram | ClassDeclaration | ProcedureDeclaration
 * 
 * SimulaProgram = [ BlockPrefix ] Block | [ BlockPrefix ] CompoundStatement
 * 
 *	 BlockPrefix = ClassIdentifier [ ( ActualParameterList ) ]
 *
 * ProcedureDeclaration
 *     = [ type ] PROCEDURE ProcedureIdentifier ProcedureHead ProcedureBody
 *
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public final class ProgramModule extends Statement
{ Declaration module;
  Variable sysin;
  Variable sysout;
  
  public String getRelativeAttributeFileName()
  { if(module.blockKind==BlockKind.Class) return(Global.packetName+"/CLASS.AF");
	if(module.blockKind==BlockKind.Procedure) return(Global.packetName+"/PROCEDURE.AF");
	else return(null);
  }
  
  public boolean isExecutable()
  { if(module.blockKind==BlockKind.SimulaProgram) return(true);
	if(module.blockKind==BlockKind.PrefixedBlock) return(true);
	else return(false);
  }

  public ProgramModule()
  { try
	{ if(Option.TRACE_PARSE) Parser.TRACE("Parse Program");
//	  SimpleParser.nextSymb();  // Flytta til SimpleParse.open
	
	  Global.currentScope=StandardClass.BASICIO;     // BASICIO Begin
	  sysin=new Variable("sysin");
	  new ConnectionBlock(sysin)                     //    Inspect sysin do
	     .setClassDeclaration(StandardClass.InFile);
	  sysout=new Variable("sysout");
	  new ConnectionBlock(sysout)                    //    Inspect sysout do
	     .setClassDeclaration(StandardClass.PrintFile);
	  String ident=acceptIdentifier();
	  if(ident!=null)
	  { if(Parser.accept(KeyWord.CLASS)) module=ClassDeclaration.doParseClassDeclaration(ident);
	    else
	    { Variable blockPrefix=Variable.parse(ident);	
	  	  Parser.expect(KeyWord.BEGIN);
	  	  module=PrefixedBlockDeclaration.createPrefixedBlock(blockPrefix); 
	    }
	  }
	  else if(Parser.accept(KeyWord.BEGIN)) module=MaybeBlockDeclaration.createMaybeBlock(); 
	  else if(Parser.accept(KeyWord.CLASS)) module=ClassDeclaration.doParseClassDeclaration(null);
	  else
	  { Type type=acceptType();
	    if(Parser.expect(KeyWord.PROCEDURE)) module=ProcedureDeclaration.doParseProcedureDeclaration(type);
	  }
	  StandardClass.BASICIO.declarationList.add(module);

	  if(Option.verbose) Util.TRACE("ProgramModule: END NEW SimulaProgram: "+toString());
    } catch(Throwable e) { e.printStackTrace();  /*System.exit(-1);*/ }
  }	

  public void doChecking()
  { if(IS_SEMANTICS_CHECKED()) return;
    sysin.doChecking();
    sysout.doChecking();
    module.doChecking();
	SET_SEMANTICS_CHECKED();
  }
  
  public void doJavaCoding() { module.doJavaCoding(); }
  public void print(String indent) { module.print(""); }
  public String toString() { return(""+module.externalIdent); }
  public String getIdentifier() { return(module.identifier); }
}
