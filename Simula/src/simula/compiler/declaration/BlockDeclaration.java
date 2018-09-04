/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import java.util.Vector;

import simula.compiler.JavaModule;
import simula.compiler.statement.Statement;

/**
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public class BlockDeclaration extends DeclarationScope
{ public boolean isMainModule;  // If true; this is the outermost Subblock or Prefixed Block.
  public boolean isContextFree; // If true; all member methods are independent of context
  public boolean isPreCompiled; // If true; this Class/Procedure is Pre-Compiled
  public Vector<Statement> statements=new Vector<Statement>();
    
  
  // ***********************************************************************************************
  // *** CONSTRUCTORS
  // ***********************************************************************************************
  // Used by parseMaybeBlock, i.e. CompoundStatement, SubBlock or PrefixedBlock.
  public BlockDeclaration(String identifier) { super(identifier); } 
  // Used by ClassDeclaration and ProcedureDeclaration
  public BlockDeclaration(String identifier,BlockKind blockKind)
  { super(identifier); this.blockKind=blockKind; } 

  // ***********************************************************************************************
  // *** Utility: prefixLevel
  // ***********************************************************************************************
  protected int prefixLevel() { return(0); } // Needs redefinition for Class and Prefixed Block

  // ***********************************************************************************************
  // *** Coding: isBlockWithLocalClasses
  // ***********************************************************************************************
  public boolean isBlockWithLocalClasses()
  {	if(this.hasLocalClasses) return(true);
    if(this instanceof ClassDeclaration)
	{ ClassDeclaration prfx=((ClassDeclaration)this).getPrefixClass();
	  if(prfx!=null) return(prfx.isBlockWithLocalClasses());
	}
	return(false); 
  }


  // ***********************************************************************************************
  // *** Coding: isQPSystemBlock  -- QPS System is any block with local class(es)
  // ***********************************************************************************************
  public boolean isQPSystemBlock()
  {	switch(blockKind)
	{ case SimulaProgram:
	  case SubBlock:
	  case PrefixedBlock:
		  	   return(isBlockWithLocalClasses());
	  default: return(false);
	}  
  }
  
  // ***********************************************************************************************
  // *** Coding Utility: codeSTMBody
  // ***********************************************************************************************
  protected void codeSTMBody()
  { if(!labelList.isEmpty())
	{ JavaModule.code(externalIdent+" THIS$=("+externalIdent+")CUR$;");
      JavaModule.code("LOOP$:while(JTX$>=0) {");
      JavaModule.code("try {");
	  JavaModule.code("JUMPTABLE$(JTX$); // For ByteCode Engineering");
	}
    for(Statement stm:statements) stm.doJavaCoding();
	if(!labelList.isEmpty())
    { JavaModule.code("break LOOP$;");
      JavaModule.code("}");
      JavaModule.code("catch($LABQNT q) {");
      JavaModule.code("CUR$=THIS$;");
      JavaModule.code("if(q.SL$!=CUR$ || q.prefixLevel!="+prefixLevel()+") {");
      JavaModule.code("CUR$.STATE$=OperationalState.terminated;");
      JavaModule.code("if(RT.Option.GOTO_TRACING) TRACE_GOTO(\"NON-LOCAL\",q);");
      JavaModule.code("throw(q);");
      JavaModule.code("}");
      JavaModule.code("if(RT.Option.GOTO_TRACING) TRACE_GOTO(\"LOCAL\",q);");
      JavaModule.code("JTX$=q.index; continue LOOP$; // EG. GOTO Lx"); 
      JavaModule.code("}");
      JavaModule.code("}");
    }
  }

  public String toString()
  { return(""+identifier+'['+externalIdent+"] BlockDeclaration.Kind="+blockKind); }

}
