/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import java.util.Vector;

import simula.compiler.statement.Statement;
import simula.compiler.utilities.Util;

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
//		        return(hasLocalClasses);
	  case PrefixedBlock:
//		  		if(this.hasLocalClasses) return(true);
//		  		ClassDeclaration prfx=((PrefixedBlockDeclaration)this).getPrefixClass();
//		  		if(prfx!=null) return(prfx.isBlockWithLocalClasses());
//		  		return(false);
		  		return(isBlockWithLocalClasses());
	  default: return(false);
	}  
  }
  
  // ***********************************************************************************************
  // *** Coding Utility: codeSTMBody
  // ***********************************************************************************************
  protected void codeSTMBody(int indent)
  { if(!labelList.isEmpty())
	{ Util.code(indent,externalIdent+" THIS$=("+externalIdent+")CUR$;");
      Util.code(indent,"LOOP$:while(JTX$>=0) {"); indent++;
      Util.code(indent,"try {"); indent++;
	  Util.code(indent,"JUMPTABLE$(JTX$); // For ByteCode Engineering");
	}
    for(Statement stm:statements) stm.doJavaCoding(indent);
	if(!labelList.isEmpty())
    { Util.code(indent,"break LOOP$;");
      indent--; Util.code(indent,"}");
      Util.code(indent,"catch($LABQNT q) {"); indent++;
      Util.code(indent,"CUR$=THIS$;");
      Util.code(indent,"if(q.SL$!=CUR$ || q.prefixLevel!="+prefixLevel()+") {"); indent++;
      Util.code(indent,"CUR$.STATE$=OperationalState.terminated;");
      Util.code(indent,"if(RT.Option.GOTO_TRACING) TRACE_GOTO(\"NON-LOCAL\",q);");
      Util.code(indent,"throw(q);");
      indent--; Util.code(indent,"}");
      Util.code(indent,"if(RT.Option.GOTO_TRACING) TRACE_GOTO(\"LOCAL\",q);");
      Util.code(indent,"JTX$=q.index; continue LOOP$; // EG. GOTO Lx"); 
      indent--; Util.code(indent,"}");
      indent--; Util.code(indent,"}");
    }
  }

  public String toString()
  { return(""+identifier+'['+externalIdent+"] BlockDeclaration.Kind="+blockKind); }

}
