/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import simula.compiler.JavaModule;
import simula.compiler.parsing.Parser;
import simula.compiler.statement.BlockStatement;
import simula.compiler.statement.Statement;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public final class MaybeBlockDeclaration extends BlockDeclaration
{ 
    
  // ***********************************************************************************************
  // *** CONSTRUCTORS
  // ***********************************************************************************************
  // Used by parseMaybeBlock, i.e. CompoundStatement or SubBlock.
  public MaybeBlockDeclaration(String identifier) { super(identifier); } 
  
  //***********************************************************************************************
  //*** createMaybeBlock
  //***********************************************************************************************
  // Used by ProgramModule
  public static MaybeBlockDeclaration createMaybeBlock()
  {	MaybeBlockDeclaration module=new MaybeBlockDeclaration(Global.sourceName);
	module.isMainModule=true;
	module.blockKind=BlockKind.SimulaProgram;
	module.parseMaybeBlock(); 
    return(module);
  }
  
  //***********************************************************************************************
  //*** Parsing: parseMaybeBlock
  //***********************************************************************************************
  /**
   * Parse CompoundStatement, SubBlock or PrefixedBlock.
   * <pre>
   * Syntax:
   * 
   * Block = CompoundStatement | SubBlock
   * 
   *	 CompoundStatement = BEGIN [ { Statement ; } ] END
   * 	 SubBlock = BEGIN [ { Declaration ; } ]  [ { Statement ; } ] END 
   *
   * </pre>
   * 
   * @param blockPrefix
   */
  public BlockStatement parseMaybeBlock()
  { Statement stm;
	//Debug.BREAK("BEGIN Block: "+this.edScopeChain());
	//Util.BREAK("BlockDeclaration.parseMaybeBlock: BlockPrefix="+blockPrefix);
	if(Option.TRACE_PARSE) Parser.TRACE("Parse MayBeBlock");
	while(Declaration.parseDeclaration(declarationList))
//	{ Parser.expect(KeyWord.SEMICOLON); }
	{ Parser.accept(KeyWord.SEMICOLON); }

    while(!Parser.accept(KeyWord.END))
    { stm=Statement.doParse();
//      Util.BREAK("BlockDeclaration.parseMaybeBlock: stm="+stm);
      if(stm!=null) statements.add(stm);
    }

	if(blockKind!=BlockKind.SimulaProgram)
	{ if(!declarationList.isEmpty())
	  { blockKind=BlockKind.SubBlock;
	    modifyIdentifier("SubBlock"+lineNumber);
	  }
	  else
	  { blockKind=BlockKind.CompoundStatement;
	    modifyIdentifier("CompoundStatement"+lineNumber);
		if(!labelList.isEmpty()) // Label is also declaration
		{ // Special case: Label in a Compound Statement.
		  // Move Label Declaration to nearest enclosing 
          // Block (with other declarations)
			
		  //Util.BREAK("BlockDeclaration.parseMaybeBlock: declaredIn="+declaredIn);
		  DeclarationScope enc=declaredIn;
		  while(enc.declarationList.isEmpty()) enc=enc.declaredIn;
		  //Util.BREAK("BlockDeclaration.parseMaybeBlock: Label is moved to enc="+enc);
		  for(LabelDeclaration lab:labelList) enc.labelList.add(lab);
		  
		  //System.out.println("Resulting Label-List:");
		  //for(LabelDeclaration lab:enc.labelList) System.out.println(lab);
		  
		  labelList.clear();
		}
	  }
	}
	//declarationMap.print("END Block: "+blockName);
	//Debug.BREAK("END Block: "+this.edScopeChain());
	//Util.BREAK("BlockDeclaration.parseMaybeBlock: BlockPrefix="+blockPrefix+", BlockDeclaration.Kind="+blockKind);
	
	Global.currentScope=declaredIn;
	return(new BlockStatement(this));
  }


  // ***********************************************************************************************
  // *** Checking
  // ***********************************************************************************************
  public void doChecking()
  { if(IS_SEMANTICS_CHECKED()) return;
 	Global.sourceLineNumber=lineNumber;
 	if(externalIdent==null) externalIdent=edJavaClassName();

	if(blockKind!=BlockKind.CompoundStatement) currentBlockLevel++;
    blockLevel=currentBlockLevel;
	//Util.BREAK("BlockDeclaration("+identifier+").doChecking: currentBlockLevel="+currentBlockLevel);
	//Util.BREAK("BlockDeclaration("+identifier+").doChecking: blockLevel="+blockLevel);
    //Util.BREAK("BlockDeclaration("+identifier+").doChecking: declaredIn="+declaredIn);
    Global.currentScope=this;
    
    int prfx=0;//prefixLevel();
    //Util.BREAK("BlockDeclaration("+identifier+").doChecking: prefixLevel="+prfx);
    for(Declaration dcl:declarationList) dcl.doChecking();
    for(Statement stm:statements) stm.doChecking();
    
    int labelIndex=1;
	for(LabelDeclaration label:labelList)
	{ label.prefixLevel=prfx; label.index=labelIndex++;	}
    
    Global.currentScope=declaredIn;
	if(blockKind!=BlockKind.CompoundStatement) currentBlockLevel--;
    SET_SEMANTICS_CHECKED();
  }
  
  // ***********************************************************************************************
  // *** Utility: findVisibleAttributeMeaning
  // ***********************************************************************************************
  public Meaning findVisibleAttributeMeaning(String ident)
  { //if(ident.equalsIgnoreCase("ln")) Util.BREAK("DeclarationScope("+identifier+").findVisibleAttributeMeaning("+ident+"): scope="+this);
    //if(ident.equalsIgnoreCase("ln")) Util.BREAK("DeclarationScope("+identifier+").findVisibleAttributeMeaning("+ident+"): declaredIn="+declaredIn);
    for(Declaration declaration:declarationList)
	  if(ident.equalsIgnoreCase(declaration.identifier))
	     return(new Meaning(declaration,this,this,false));
    for(LabelDeclaration label:labelList)
	  if(ident.equalsIgnoreCase(label.identifier))
	     return(new Meaning(label,this,this,false));
    return(null);
  }
  
  
  // ***********************************************************************************************
  // *** Coding: doJavaCoding
  // ***********************************************************************************************
  public void doJavaCoding()
  { //Util.BREAK("BlockDeclaration.doJavaCoding: "+identifier+", BlockDeclaration.Kind="+blockKind);
	ASSERT_SEMANTICS_CHECKED(this);
	if(this.isPreCompiled) return;
	if(blockKind==BlockKind.CompoundStatement)
    	 doCompoundStatementCoding();
	else doSubBlockCoding();
  }

  // ***********************************************************************************************
  // *** Coding: CompoundStatement as Java Subblock
  // ***********************************************************************************************
  private void doCompoundStatementCoding()
  {	Global.sourceLineNumber=lineNumber;
    //Util.BREAK("BlockDeclaration.doSubBlockJavaCoding: "+identifier);
  	ASSERT_SEMANTICS_CHECKED(this);
  	Util.ASSERT(declarationList.isEmpty(),"Invariant");
    Util.ASSERT(labelList.isEmpty(),"Invariant");
  	Global.currentScope=this;
    JavaModule.code("{");
    
//	JavaModule.code("TRACE_BEGIN_DCL$(\""+identifier+"\","+Global.sourceLineNumber+");");
//	for(Declaration decl:labelList) decl.doJavaCoding(indent+1);
    
	JavaModule.code("TRACE_BEGIN_STM$(\""+identifier+"\","+Global.sourceLineNumber+");");
    for(Statement stm:statements) stm.doJavaCoding();
	JavaModule.code("TRACE_END_STM$(\""+identifier+"\","+Global.sourceLineNumber+");");
    JavaModule.code("}");
    Global.currentScope=declaredIn;
  }

  
  // ***********************************************************************************************
  // *** Coding: SUBBLOCK  ==>  .java file 
  // ***********************************************************************************************
  // Output .java file for Class, Procedure, SubBlock and Prefixed Block.
  private void doSubBlockCoding()
  {	Global.sourceLineNumber=lineNumber;
    //Util.BREAK("BlockDeclaration.doBlockJavaCoding: "+identifier);
	ASSERT_SEMANTICS_CHECKED(this);
	JavaModule javaModule=new JavaModule(this);
	//Util.BREAK("Global.javaModules.add: "+javaModule); 
	Global.javaModules.add(javaModule); 
	javaModule.openJavaOutput();
	Global.currentScope=this;
	JavaModule.code("@SuppressWarnings(\"unchecked\")");
	JavaModule.code("public final class "+getJavaIdentifier()+" extends BASICIO$"+" {");
	doPrototypeCoding();
	if(!labelList.isEmpty())
	{ JavaModule.code("// Declare local labels");
	  for(Declaration decl:labelList) decl.doJavaCoding();
	}
	JavaModule.code("// Declare locals as attributes");
	for(Declaration decl:declarationList) decl.doJavaCoding();
	doCodeConstructor();
	doCodeStatements();
	if(this.isMainModule)
	{ JavaModule.code("");
	  JavaModule.code("public static void main(String[] args) {");
	  JavaModule.code("new "+getJavaIdentifier()+"(CTX$).STM();");
	  JavaModule.code("}"); // End of main
	}
	JavaModule.code("}"); // End of SubBlock
	Global.currentScope=declaredIn;
	javaModule.closeJavaOutput();
  }
  
  // ***********************************************************************************************
  // *** Coding: doPrototypeCoding  --  This code instead of traditional Prototype
  // ***********************************************************************************************
  private void doPrototypeCoding()
  {	//String packetName=SimulaCompiler.packetName;
	JavaModule.code("// SubBlock: BlockKind="+blockKind+", BlockLevel="+blockLevel
			  +", hasLocalClasses="+((hasLocalClasses)?"true":"false")
	          +", System="+((isQPSystemBlock())?"true":"false") );
	JavaModule.code("public int prefixLevel() { return(0); }");
	if(isQPSystemBlock())
	JavaModule.code("public boolean isQPSystemBlock() { return(true); }");
  }
  
  
  // ***********************************************************************************************
  // *** Coding Utility: doCodeConstructor
  // ***********************************************************************************************
  private void doCodeConstructor()
  {	JavaModule.code("// Normal Constructor");
    JavaModule.code("public "+getJavaIdentifier()+"(RTObject$ staticLink) {");
	JavaModule.code("super(staticLink);");
    JavaModule.code("BBLK();");
	if(blockKind==BlockKind.SimulaProgram)
			JavaModule.code("BPRG(\""+identifier+"\");");
	JavaModule.code("// Declaration Code");
    JavaModule.code("TRACE_BEGIN_DCL$(\""+identifier+"\","+Global.sourceLineNumber+");");
	for(Declaration decl:declarationList) decl.doDeclarationCoding();
	JavaModule.code("} // End of Constructor");
  }

  // ***********************************************************************************************
  // *** Coding Utility: doCodeStatements
  // ***********************************************************************************************
  private void doCodeStatements()
  {	JavaModule.code("// "+blockKind+" Statements");
	JavaModule.code("public RTObject$ STM() {");
	JavaModule.code("TRACE_BEGIN_STM$(\""+identifier+"\","+Global.sourceLineNumber+");");
    codeSTMBody();
	JavaModule.code("TRACE_END_STM$(\""+identifier+"\","+Global.sourceLineNumber+");");
    JavaModule.code("EBLK();");
	JavaModule.code("return(null);");
    JavaModule.code("} // End of "+blockKind+" Statements");
  }


  // ***********************************************************************************************
  // *** Printing Utility: print
  // ***********************************************************************************************
  public void print(String indent,String tail)
  { StringBuilder s=new StringBuilder(indent);
    s.append('[').append(blockLevel).append("] ");
    s.append(blockKind).append(' ').append(identifier);
    s.append('[').append(externalIdent).append("] ");
    System.out.println(s.toString());
	String beg="begin["+edScopeChain()+']';
	indent=indent+"    ";
    System.out.println(indent+beg); 
//    if(!hiddenList.isEmpty()) System.out.println(indent+"   HIDDEN"+hiddenList);
//    if(!protectedList.isEmpty()) System.out.println(indent+"   PROTECTED"+protectedList);
    for(Declaration decl:declarationList) decl.print(indent+"   ",";");
    for(Statement stm:statements) stm.print(indent+"   ",";");
	System.out.println(indent+"end["+edScopeChain()+']'+tail); 
	//Util.BREAK("BlockDeclaration.print DONE");
  }

  public String toString()
  { return(""+identifier+'['+externalIdent+"] BlockKind="+blockKind); }

}
