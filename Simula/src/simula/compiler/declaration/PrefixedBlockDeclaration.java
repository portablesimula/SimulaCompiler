/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import simula.compiler.JavaModule;
import simula.compiler.expression.Expression;
import simula.compiler.expression.Variable;
import simula.compiler.parsing.Parser;
import simula.compiler.statement.BlockStatement;
import simula.compiler.statement.Statement;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;
import simula.runtime.RT;

/**
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public final class PrefixedBlockDeclaration extends ClassDeclaration // BlockDeclaration
{ 
  public Variable blockPrefix; // Block Prefix in case of Prefixed Block.
    
  // ***********************************************************************************************
  // *** CONSTRUCTOR
  // ***********************************************************************************************
  public PrefixedBlockDeclaration(String identifier) { super(identifier); } 
  
  //***********************************************************************************************
  //*** createMaybeBlock
  //***********************************************************************************************
  // Used by ProgramModule
  public static PrefixedBlockDeclaration createPrefixedBlock(Variable blockPrefix)
  {	PrefixedBlockDeclaration module=new PrefixedBlockDeclaration(Global.sourceName);
	module.isMainModule=true;
	module.blockKind=BlockKind.SimulaProgram;
	module.blockPrefix=blockPrefix;
	if(blockPrefix!=null) module.blockKind=BlockKind.PrefixedBlock;
	if(blockPrefix!=null) module.prefix=blockPrefix.identifier;
	else module.prefix="BASICIO";
	module.parsePrefixedBlock(blockPrefix); 
    return(module);
  }
  
  //***********************************************************************************************
  //*** Parsing: parsePrefixedBlock
  //***********************************************************************************************
  /**
   * Parse PrefixedBlock.
   * <pre>
   * Syntax:
   * 
   *	 PrefixedBlock = prefix BEGIN [ { Declaration ; } ]  [ { Statement ; } ] END
   *
   * </pre>
   * 
   * @param blockPrefix
   */
  public BlockStatement parsePrefixedBlock(Variable blockPrefix)
  { Statement stm;
	if(blockPrefix!=null)
	{ this.blockPrefix=blockPrefix;
      this.prefix=blockPrefix.identifier;
	}
	
	//Debug.BREAK("BEGIN Block: "+this.edScopeChain());
	//Util.BREAK("PrefixedBlockDeclaration.parseMaybeBlock: BlockPrefix="+blockPrefix);
	if(Option.TRACE_PARSE) Parser.TRACE("Parse MayBeBlock");
	while(Declaration.parseDeclaration(declarationList))
//	{ Parser.expect(KeyWord.SEMICOLON); }
	{ Parser.accept(KeyWord.SEMICOLON); }

    while(!Parser.accept(KeyWord.END))
    { stm=Statement.doParse();
//      Util.BREAK("PrefixedBlockDeclaration.parseMaybeBlock: stm="+stm);
      if(stm!=null) statements.add(stm);
    }

	if(blockKind!=BlockKind.SimulaProgram)
	{ if(blockPrefix!=null)
	  { blockKind=BlockKind.PrefixedBlock;
	    modifyIdentifier(""+Global.sourceName+"$PBLK"+lineNumber);
	    this.externalIdent=this.identifier;
	  }
	  else if(!declarationList.isEmpty())
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
			
		  //Util.BREAK("PrefixedBlockDeclaration.parseMaybeBlock: declaredIn="+declaredIn);
		  DeclarationScope enc=declaredIn;
		  while(enc.declarationList.isEmpty()) enc=enc.declaredIn;
		  //Util.BREAK("PrefixedBlockDeclaration.parseMaybeBlock: Label is moved to enc="+enc);
		  for(LabelDeclaration lab:labelList) enc.labelList.add(lab);
		  
		  //System.out.println("Resulting Label-List:");
		  //for(LabelDeclaration lab:enc.labelList) System.out.println(lab);
		  
		  labelList.clear();
		}
	  }
	}
	this.lastLineNumber=Global.sourceLineNumber;
	//declarationMap.print("END Block: "+blockName);
	//Debug.BREAK("END Block: "+this.edScopeChain());
	//Util.BREAK("PrefixedBlockDeclaration.parseMaybeBlock: BlockPrefix="+blockPrefix+", BlockKind="+blockKind);
	
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
	currentBlockLevel++; blockLevel=currentBlockLevel;
//	Util.BREAK("PrefixedBlockDeclaration("+identifier+").doChecking: blockPrefix="+blockPrefix);
//	Util.BREAK("PrefixedBlockDeclaration("+identifier+").doChecking: currentBlockLevel="+currentBlockLevel);
//	Util.BREAK("PrefixedBlockDeclaration("+identifier+").doChecking: blockLevel="+blockLevel);
//  Util.BREAK("PrefixedBlockDeclaration("+identifier+").doChecking: declaredIn="+declaredIn);

    if(blockPrefix!=null)
    { Global.currentScope=this.declaredIn;
      blockPrefix.doChecking();
      this.prefix=blockPrefix.identifier;
      this.getPrefixClass().doChecking();
    }
    Global.currentScope=this;
    Util.ASSERT(parameterList.isEmpty(),"Invariant");
    Util.ASSERT(virtualSpecList.isEmpty(),"Invariant");
    Util.ASSERT(hiddenList.isEmpty(),"Invariant");
    Util.ASSERT(protectedList.isEmpty(),"Invariant");
    
    int prfx=prefixLevel();
    for(Declaration dcl:declarationList) dcl.doChecking();
    for(Statement stm:statements) stm.doChecking();
	checkLabelList(prfx);
    Global.currentScope=declaredIn;
	if(blockKind!=BlockKind.CompoundStatement) currentBlockLevel--;
    SET_SEMANTICS_CHECKED();
  }
  
  // ***********************************************************************************************
  // *** Coding: doJavaCoding
  // ***********************************************************************************************
  public void doJavaCoding()
  {	Global.sourceLineNumber=lineNumber;
    //Util.BREAK("PrefixedBlockDeclaration.doJavaCoding: "+identifier);
	ASSERT_SEMANTICS_CHECKED(this);
	JavaModule javaModule=new JavaModule(this);
	//Util.BREAK("Global.javaModules.add: "+javaModule); 
	Global.javaModules.add(javaModule); 
	javaModule.openJavaOutput();
	Global.currentScope=this;
	JavaModule.code("@SuppressWarnings(\"unchecked\")");
    String line="public final class "+getJavaIdentifier();
	if(prefix!=null) line=line+" extends "+getPrefixClass().getJavaIdentifier();
	else line=line+" extends BASICIO$";
	JavaModule.code(line+" {");
	doPrototypeCoding();
	JavaModule.code("// Declare parameters as attributes");
	for(Parameter par:parameterList)
	{ String tp=par.toJavaType(); 
	  JavaModule.code("public "+tp+' '+par.externalIdent+';');
	}
	if(!labelList.isEmpty())
	{ JavaModule.code("// Declare local labels");
	  //JavaModule.code("   public int JTX$;"); // Moved to RTObject$
	  for(Declaration decl:labelList) decl.doJavaCoding();
	}
	JavaModule.code("// Declare locals as attributes");
	for(Declaration decl:declarationList) decl.doJavaCoding();
//    for(VirtualSpecification virtual:virtualSpecList) virtual.doJavaCoding();
    for(VirtualMatch match:virtualMatchList) match.doJavaCoding();
	doCodeConstructor();
	//doCodeStatements(indent); // PrefixedBlock: USES DEFAULT VERSION OF  STM$()
	if(this.isMainModule)
	{ JavaModule.code("");
	  JavaModule.code("public static void main(String[] args) {");
	  JavaModule.code("RT.setRuntimeOptions(args);");
	  StringBuilder s=new StringBuilder();
	  s.append("new "+getJavaIdentifier()+"(CTX$");
	  if(blockPrefix!=null && blockPrefix.hasArguments())
	  {	for (Expression par:blockPrefix.checkedParams) {
		   s.append(',').append(par.toJavaCode());
	    }
	  }
	  s.append(").STM$();");
	  JavaModule.code(""+s);
	  JavaModule.code("}"); // End of main
	}
	javaModule.codeProgramInfo();
	JavaModule.code("}"); // End of Class
	Global.currentScope=declaredIn;
	javaModule.closeJavaOutput();
  }

  
  // ***********************************************************************************************
  // *** Coding: doPrototypeCoding  --  This code instead of traditional Prototype
  // ***********************************************************************************************
  private void doPrototypeCoding()
  {	//String packetName=SimulaCompiler.packetName;
	JavaModule.code("// PrefixedBlockDeclaration: BlockKind="+blockKind+", BlockLevel="+blockLevel
			  +", firstLine="+lineNumber+", lastLine="+lastLineNumber
			  +", hasLocalClasses="+((hasLocalClasses)?"true":"false")
	          +", System="+((isQPSystemBlock())?"true":"false")
		      +", detachUsed="+((detachUsed)?"true":"false"));
	JavaModule.code("public int prefixLevel() { return(0); }");
	if(isQPSystemBlock())
	JavaModule.code("public boolean isQPSystemBlock() { return(true); }");
	if(isDetachUsed())
	JavaModule.code("public boolean isDetachUsed() { return(true); }");
  }
  
  
  // ***********************************************************************************************
  // *** Coding Utility: doCodeConstructor
  // ***********************************************************************************************
  private void doCodeConstructor()
  {	JavaModule.code("// Normal Constructor");
	JavaModule.code("public "+getJavaIdentifier()+edFormalParameterList(false));
	if(prefix!=null) 
	{ ClassDeclaration prefixClass=this.getPrefixClass();
	  JavaModule.code("super"+prefixClass.edSuperParameterList());
	} else JavaModule.code("super(staticLink);");
	JavaModule.code("// Parameter assignment to locals");
	for(Parameter par:parameterList)
		  JavaModule.code("this."+par.externalIdent+" = s"+par.externalIdent+';');	
	if(this.isMainModule) JavaModule.code("BPRG(\""+identifier+"\");");
	JavaModule.code("// Declaration Code");
    JavaModule.code("TRACE_BEGIN_DCL$(\""+identifier+"\","+Global.sourceLineNumber+");");
	for(Declaration decl:declarationList) decl.doDeclarationCoding();
	doCodeCreateClassBody();
	JavaModule.code("} // End of Constructor");
  }


  // ***********************************************************************************************
  // *** Printing Utility: print
  // ***********************************************************************************************
  public void print(String indent)
  { StringBuilder s=new StringBuilder(indent);
    s.append('[').append(blockLevel).append("] ");
    if(prefix!=null) s.append(prefix).append(' ');
    s.append(blockKind).append(' ').append(identifier);
    s.append('[').append(externalIdent).append("] ");
    s.append(editParameterList());
    System.out.println(s.toString());
	String beg="begin["+edScopeChain()+']';
	indent=indent+"    ";
    System.out.println(indent+beg); 
    for(Declaration decl:declarationList) decl.print(indent+"   ");
    for(Statement stm:statements) stm.print(indent+"   ");
	System.out.println(indent+"end["+edScopeChain()+']'); 
	//Util.BREAK("PrefixedBlockDeclaration.print DONE");
  }
  
  // ***********************************************************************************************
  // *** Printing Utility: editParameterList
  // ***********************************************************************************************
  private String editParameterList()
  { StringBuilder s=new StringBuilder(); s.append('(');
    boolean first=true;
    for(Parameter par:parameterList)
    { if(!first) s.append(','); s.append(par); first=false; }
    s.append(')');
    s.append(';');
    return(s.toString());
  }

  public String toString()
  { return(""+identifier+'['+externalIdent+"] BlockKind="+blockKind+", BlockPrefix="+blockPrefix); }

}
