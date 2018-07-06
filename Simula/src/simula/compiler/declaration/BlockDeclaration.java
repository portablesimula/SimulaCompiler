/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import java.util.Iterator;
import java.util.Vector;

import simula.compiler.JavaModule;
import simula.compiler.expression.Variable;
import simula.compiler.parsing.Parser;
import simula.compiler.statement.BlockStatement;
import simula.compiler.statement.Statement;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public class BlockDeclaration extends DeclarationScope // Declaration implements Scope
{ public boolean isMainModule;  // If true; this is the outermost Subblock or Prefixed Block.
  public boolean isContextFree; // If true; all member methods are independent of context
  public boolean isPreCompiled; // If true; this Class/Procedure is Pre-Compiled
  public Virtual myVirtual; // Set during doChecking
  public Vector<Statement> statements=new Vector<Statement>();
  
  public enum Kind {
//		ExternalClass,
//		ExternalProcedure,
		StandardClass,
		ConnectionBlock,
		CompoundStatement,
	    SubBlock,
	    Procedure,
	    Method, // Procedure coded as a Java Method. 
	    Class,
	    PrefixedBlock,
	    SimulaProgram,
//	    Switch
	}

  // ***********************************************************************************************
  // *** Utility: findVirtual
  // ***********************************************************************************************
  public Virtual findVirtual(String ident)
  { for(Virtual virtual:virtualList)
        if(ident.equalsIgnoreCase(virtual.identifier)) return(virtual);
    BlockDeclaration prfx=getPrefix();
    if(prfx!=null) return(prfx.findVirtual(ident));
    return(null); 
  }

  
  
//  public String getJavaIdentifier()
//  { if(blockKind==BlockDeclaration.Kind.Method) return(identifier);
//	if(Option.useQualifiedNames) return(edJavaClassName());
//    return(identifier);
//  }
    
  
  // ***********************************************************************************************
  // *** CONSTRUCTORS
  // ***********************************************************************************************
  // Used by parseMaybeBlock, i.e. CompoundStatement, SubBlock or PrefixedBlock.
  public BlockDeclaration(String identifier) { super(identifier); } 
  // Used by ClassDeclaration and ProcedureDeclaration
  public BlockDeclaration(String identifier,BlockDeclaration.Kind blockKind)
  { super(identifier); this.blockKind=blockKind; } 

  public void setStatement(Statement statement)
  { //this.statement=statement;
	statements.add(statement);
  }
  
  //***********************************************************************************************
  //*** createMaybeBlock
  //***********************************************************************************************
  // Used by ProgramModule
  public static BlockDeclaration createMaybeBlock(Variable blockPrefix,String blockIdentifier)
  {	BlockDeclaration module=new BlockDeclaration(Global.sourceName);
	module.isMainModule=true;
	module.blockKind=BlockDeclaration.Kind.SimulaProgram;
	module.blockPrefix=blockPrefix;
	if(blockPrefix!=null) module.blockKind=BlockDeclaration.Kind.PrefixedBlock;
	if(blockPrefix!=null) module.prefix=blockPrefix.identifier;
//	else module.prefix="BASICIO";
	else module.prefix="RTObject";
	module.parseMaybeBlock(blockPrefix); 
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
   * Block = CompoundStatement | SubBlock | PrefixedBlock
   * 
   *	 CompoundStatement = BEGIN [ { Statement ; } ] END
   * 	 SubBlock = BEGIN [ { Declaration ; } ]  [ { Statement ; } ] END 
   *	 PrefixedBlock = prefix BEGIN [ { Declaration ; } ]  [ { Statement ; } ] END 
   *	 CompoundStatement = BEGIN [ { Statement ; } ] END
   *
   * </pre>
   * 
   * @param blockPrefix
   */
  public BlockStatement parseMaybeBlock(Variable blockPrefix)
  { Statement stm;
	if(blockPrefix!=null)
	{ this.blockPrefix=blockPrefix;
      this.prefix=blockPrefix.identifier;
	}
	
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

	if(blockKind!=BlockDeclaration.Kind.SimulaProgram)
	{ if(blockPrefix!=null)
	  { blockKind=BlockDeclaration.Kind.PrefixedBlock;
	    if(!isMainModule) modifyIdentifier(""+blockPrefix.identifier+"$Block"+lineNumber);
	  }
	  else if(!declarationList.isEmpty())
	  { blockKind=BlockDeclaration.Kind.SubBlock;
	    modifyIdentifier("SubBlock"+lineNumber);
	  }
	  else
	  { blockKind=BlockDeclaration.Kind.CompoundStatement;
	    modifyIdentifier("CompoundStatement"+lineNumber);
	  }
	}
	//declarationMap.print("END Block: "+blockName);
	//Debug.BREAK("END Block: "+this.edScopeChain());
	//Util.BREAK("BlockDeclaration.parseMaybeBlock: BlockPrefix="+blockPrefix+", BlockDeclaration.Kind="+blockKind);
	
	Global.currentScope=declaredIn;
	return(new BlockStatement(this));
  }
  

//***********************************************************************************************
//*** Parsing: doParseProcedureSpecification
//***********************************************************************************************
/**
 * Procedure Specification.
 * <pre>
 * Syntax:
 * 
 * ProcedureSpecification
 *     = [ type ] PROCEDURE ProcedureIdentifier ProcedureHead EmptyBody
 *     
 * ProcedureHead
 *     = [ FormalParameterPart ; [ ModePart ]
 *         specification-part  ] ;
 *         
 * ProcedureBody = Statement
 * ProcedureIdentifier = Identifier
 * </pre>
 */
  public static ProcedureSpecification doParseProcedureSpecification(Type type)
  {	BlockDeclaration.Kind blockKind=(Option.standardClass)?BlockDeclaration.Kind.Method:BlockDeclaration.Kind.Procedure;
   	BlockDeclaration block=new BlockDeclaration(null,blockKind);
    block.type=type;  
    if(Option.TRACE_PARSE) Parser.TRACE("Parse ProcedureDeclaration, type="+type);
	BlockParser.doParse(block,false);
    if(Option.TRACE_PARSE) Util.TRACE("END ProcedureDeclaration: "+block);
	//Debug.BREAK("END ProcedureDeclaration: ");
    Global.currentScope=block.declaredIn;
    ProcedureSpecification procedureSpecification=new ProcedureSpecification(block.identifier,type,block.parameterList);
	return(procedureSpecification);
  }
  

//***********************************************************************************************
//*** Parsing: doParseProcedureDeclaration
//***********************************************************************************************
/**
 * Procedure Declaration.
 * <pre>
 * Syntax:
 * 
 * ProcedureDeclaration
 *     = [ type ] PROCEDURE ProcedureIdentifier ProcedureHead ProcedureBody
 *     
 * ProcedureHead
 *     = [ FormalParameterPart ; [ ModePart ]
 *         specification-part  ] ;
 *         
 * ProcedureBody = Statement
 * ProcedureIdentifier = Identifier
 * </pre>
 */
  public static BlockDeclaration doParseProcedureDeclaration(Type type)
  {	BlockDeclaration.Kind blockKind=(Option.standardClass)?BlockDeclaration.Kind.Method:BlockDeclaration.Kind.Procedure;
   	BlockDeclaration block=new BlockDeclaration(null,blockKind);
    block.type=type;  
    if(Option.TRACE_PARSE) Parser.TRACE("Parse ProcedureDeclaration, type="+type);
	BlockParser.doParse(block,false);
    if(Option.TRACE_PARSE) Util.TRACE("END ProcedureDeclaration: "+block);
	//Debug.BREAK("END ProcedureDeclaration: ");
    Global.currentScope=block.declaredIn;
	return(block);
  }

// ***********************************************************************************************
// *** Parsing: doParseClassDeclaration
// ***********************************************************************************************
/**
 * Class Declaration.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 * ClassDeclaration = [ Prefix ] MainPart
 * 
 *	Prefix = ClassIdentifier
 *
 *    MainPart = CLASS ClassIdentifier  ClassHead  ClassBody
 *		ClassIdentifier = Identifier
 *
 *		ClassHead = [ FormalParameterPart ; [ ValuePart ] SpecificationPart ] ;
 *					 [ ProtectionPart ; ] [ VirtualPart ]
 *
 *			FormalParameterPart = "(" FormalParameter { , FormalParameter ")"
 *				FormalParameter = Identifier
 *			ValuePart = VALUE IdentifierList
 *			SpecificationPart = Specifier  IdentifierList ; { Specifier  IdentifierList ; }
 *				Specifier = Type [ ARRAY | PROCEDURE ] | LABEL | SWITCH
 *
 *			ProtectionPart = ProtectionSpecification { ; ProtectionSpecification }
 *				ProtectionSpecification = HIDDEN IdentifierList | HIDDEN PROTECTED IdentifierList
 *										| PROTECTED IdentifierList | PROTECTED HIDDEN IdentifierList
 *
 *			VirtualPart = VIRTUAL: virtual-specification-part
 *				VirtualSpecificationPart = VirtualSpecification ; { VirtualSpecification ; }
 *					VirtualSpecification = VirtualSpecifier IdentifierList
 *						VirtualSpecifier = [ type ] PROCEDURE | LABEL | SWITCH
 *
 *		ClassBody = SplitBody | Statement
 *			SplitBody = BEGIN [ { Declaration ; } ]  [ { Statement ; } ] InnerPart  [ { Statement ; } ] 
 *				InnerPart = [ Label : ] INNER ;
 *
 * </pre>
 */
  public static BlockDeclaration doParseClassDeclaration(String prefix)
  { BlockDeclaration block=new BlockDeclaration(null,BlockDeclaration.Kind.Class);
	block.prefix=prefix;
	block.declaredIn.hasLocalClasses=true;
	//Util.BREAK("BlockDeclaration.doParseClassDeclaration: set hasLocalClasses in="+block.declaredIn);
//	if(block.prefix==null) block.prefix=StandardClass.BASICIO.identifier;
	if(block.prefix==null) block.prefix=StandardClass.CLASS.identifier;

	BlockParser.doParse(block,true);
    
	//Util.BREAK("BlockDeclaration.doParseClassDeclaration: set Type="+Type.Ref(block.identifier));
	block.type=Type.Ref(block.identifier);
    if(Option.TRACE_PARSE) Parser.TRACE("Parse BlockDeclaration");
	if(Option.TRACE_PARSE) Util.TRACE("END BlockDeclaration: "+block);
	Global.currentScope=block.declaredIn;
	return(block);
  }
  
  // ***********************************************************************************************
  // *** Utility: isSubClassOf
  // ***********************************************************************************************
  /**
   * Consider the class definitions:
   * <pre> 
   *      Class A ......;
   *    A Class B ......;
   *    B Class C ......;
   * </pre>
   * Then Class B is a subclass of Class A, While Class C is subclass of both B and A.
   * @param other
   * @return Boolean true iff this class is a subclass of the 'other' class.
   */
  public boolean isSubClassOf(BlockDeclaration other)
  { BlockDeclaration prefixClass=getPrefix();
    //Util.BREAK("ClassDeclaration: ("+this+").isSubClassOf("+other+')');
    if(prefixClass!=null) do
    { //Util.BREAK("ClassDeclaration.isSubClassOf: prefix="+prefixClass);
      if(other==prefixClass)
      { //Util.BREAK("ClassDeclaration: ("+this.identifier+").isSubClassOf("+other.identifier+") Returns TRUE");
    	  return(true);
      }
    } while((prefixClass=prefixClass.getPrefix())!=null);
    //Util.BREAK("ClassDeclaration: ("+this.identifier+").isSubClassOf("+other.identifier+") Returns FALSE");
    return(false);
  }
  
//  // ***********************************************************************************************
//  // *** Utility: isSameOrSubClassOf
//  // ***********************************************************************************************
//  public boolean isSameOrSubClassOf(BlockDeclaration other)
//  { if(this==other) return(true);
//	return(isSubClassOf(other));
//  }
  
  // ***********************************************************************************************
  // *** Utility: ClassParameterIterator - // Iterates through prefix-chain
  // ***********************************************************************************************
  private class ClassParameterIterator implements Iterator<Parameter>,Iterable<Parameter>
  { Iterator<Parameter> prefixIterator;
    Iterator<Parameter> localIterator;
    public ClassParameterIterator()
    { BlockDeclaration prefix=getPrefix();
      if(prefix!=null) prefixIterator=prefix.parameterIterator();
	  localIterator = parameterList.iterator();
    }
	public boolean hasNext()
	{ if(prefixIterator!=null)
	  { if(prefixIterator.hasNext()) return(true);
	    prefixIterator=null;
	  }
	  return(localIterator.hasNext());
	}
	public Parameter next()
	{ if(!hasNext()) return(null);
	  if(prefixIterator!=null) return(prefixIterator.next());
	  return(localIterator.next());
	} 
	
	public Iterator<Parameter> iterator()
	{ return(new ClassParameterIterator()); }
  }
  
  public Iterator<Parameter> parameterIterator()
  { return(new ClassParameterIterator()); }


  // ***********************************************************************************************
  // *** Checking
  // ***********************************************************************************************
  public void doChecking()
  { if(IS_SEMANTICS_CHECKED()) return;
 	Global.sourceLineNumber=lineNumber;
 	
 	// Set External Identifier  TODO: USE_EXTERNAL_IDENTIFIER
 	// this.externalIdent=this.getJavaIdentifier();
 	if(blockKind==BlockDeclaration.Kind.Method) externalIdent=this.identifier;
// 	else externalIdent=edJavaClassName();
// 	else if(blockKind!=BlockDeclaration.Kind.External) externalIdent=edJavaClassName();
 	else if(externalIdent==null) externalIdent=edJavaClassName();

	if(blockKind!=BlockDeclaration.Kind.CompoundStatement) currentBlockLevel++;
    blockLevel=currentBlockLevel;
	//Util.BREAK("BlockDeclaration("+identifier+").doChecking: currentBlockLevel="+currentBlockLevel);
	//Util.BREAK("BlockDeclaration("+identifier+").doChecking: blockLevel="+blockLevel);
    //Util.BREAK("BlockDeclaration("+identifier+").doChecking: declaredIn="+declaredIn);

    if(blockPrefix!=null)
    { Global.currentScope=this.declaredIn;
      blockPrefix.doChecking();
      this.prefix=blockPrefix.identifier;
    }
    Global.currentScope=this;
    
    int prfx=prefixLevel();
    //Util.BREAK("BlockDeclaration("+identifier+").doChecking: prefixLevel="+prfx);
    for(Parameter par:this.parameterList) par.setExternalIdentifier(prfx);
    for(Declaration par:new ClassParameterIterator()) par.doChecking();
    for(Virtual vrt:virtualList) vrt.doChecking();
    for(Declaration dcl:declarationList) dcl.doChecking();
    for(Statement stm:statements) stm.doChecking();
    int labelIndex=1;
	for(LabelDeclaration label:labelList) label.index=labelIndex++;

    myVirtual=declaredIn.findVirtual(identifier);
    //Util.BREAK("BlockDeclaration("+identifier+").doChecking: myVirtual="+myVirtual);
    if(myVirtual!=null)
    { DeclarationScope scope=myVirtual.declaredIn;
      if(scope==declaredIn) myVirtual.setMatch(this);
      else ((BlockDeclaration)declaredIn).virtualList.add(myVirtual=new Virtual(this)); 
    }
    Global.currentScope=declaredIn;
	if(blockKind!=BlockDeclaration.Kind.CompoundStatement) currentBlockLevel--;
    SET_SEMANTICS_CHECKED();
  }

  private int prefixLevel()
  { if(hasNoRealPrefix()) return(0);
	BlockDeclaration prfx=getPrefix();
    if(prfx!=null) return(prfx.prefixLevel()+1);
	return(-1);  
  }
  // ***********************************************************************************************
  // *** Coding: hasNoRealPrefix
  // ***********************************************************************************************
  public boolean hasNoRealPrefix()
  { BlockDeclaration prfx=getPrefix();
    boolean noPrefix=true;
	if(prfx!=null)
	{ noPrefix=false;
	  String prfxString=prfx.identifier;
	  if(prfxString.equalsIgnoreCase("CLASS")) noPrefix=true;
	} 
	return(noPrefix);
  }
  
  // ***********************************************************************************************
  // *** Coding: doPrototypeCoding  --  This code instead of traditional Prototype
  // ***********************************************************************************************
  private void doPrototypeCoding(String indent)
  {	//String packetName=SimulaCompiler.packetName;
	Util.code(indent+"// BlockDeclaration.Kind="+blockKind+", BlockLevel="+blockLevel
			  +", hasLocalClasses="+((hasLocalClasses)?"true":"false")
	          +", System="+((isQPSystemBlock())?"true":"false")
		      +", detachUsed="+((detachUsed)?"true":"false"));
	if(isQPSystemBlock())
	Util.code(indent+"public boolean isQPSystemBlock() { return(true); }");
	if(isDetachUsed())
	Util.code(indent+"public boolean isDetachUsed() { return(true); }");
  }
  


  // ***********************************************************************************************
  // *** Coding: doJavaCoding
  // ***********************************************************************************************
  public void doJavaCoding(String indent)
  { //Util.BREAK("BlockDeclaration.doJavaCoding: "+identifier+", BlockDeclaration.Kind="+blockKind);
	ASSERT_SEMANTICS_CHECKED(this);
	if(this.isPreCompiled) return;
	switch(blockKind)
    { case SimulaProgram:
    	    doBlockJavaCoding(indent); break;
      case CompoundStatement:
    	    doSubBlockJavaCoding(indent); break;
      case Method: // Procedure coded as a Java Method. 
    		doMethodJavaCoding(indent); break;
      case SubBlock:
//    	    doSubBlockJavaCoding(indent); break;
  		    doBlockJavaCoding(indent); break;
      case PrefixedBlock:
  		    doBlockJavaCoding(indent); break;
  	  case Procedure:
		    doBlockJavaCoding(indent); break;
      case Class:
    		doBlockJavaCoding(indent); break;
      case ConnectionBlock:
//    	    Util.NOT_IMPLEMENTED("JavaCoding of ConnectionBlock");
//    	    doSubBlockJavaCoding(indent); break;
   	  default: Util.FATAL_ERROR("Impossible Situation !");
    }
  }

  // ***********************************************************************************************
  // *** Coding: SUBBLOCK as Java Subblock
  // ***********************************************************************************************
  private void doSubBlockJavaCoding(String indent)
  {	Global.sourceLineNumber=lineNumber;
    //Util.BREAK("BlockDeclaration.doSubBlockJavaCoding: "+identifier);
  	ASSERT_SEMANTICS_CHECKED(this);
  	Global.currentScope=this;
    Util.code(indent+'{');
	for(Declaration decl:labelList) decl.doJavaCoding(indent+"   ");
    for(Iterator<Declaration> it=declarationList.iterator();it.hasNext();) it.next().doJavaCoding(indent);
    for(Statement stm:statements) stm.doJavaCoding(indent);
    Util.code(indent+'}');
    Global.currentScope=declaredIn;
  }

    
  // ***********************************************************************************************
  // *** Coding: METHOD  --   Generate Inline Method code for Procedure.
  // ***********************************************************************************************
  // Generate Inline Method code for Procedure.
  private void doMethodJavaCoding(String indent)
  { Global.sourceLineNumber=lineNumber;
    //Util.BREAK("BlockDeclaration.doMethodJavaCoding: "+identifier);
  	ASSERT_SEMANTICS_CHECKED(this);
  	Global.currentScope=this;
    String line="public "+((type==null)?"void":type.toJavaType());
  	line=line+' '+getJavaIdentifier()+' '+edFormalParameterList(true);
  	Util.code(indent+line);
  	if(type!=null)
	{ Util.code(indent+"   // Declare return value as variable");
	  Util.code(indent+"   "+type.toJavaType()+' '+"$result"+'='+type.edDefaultValue()+';');
	}
  	
	for(Declaration decl:labelList) decl.doJavaCoding(indent+"   ");
    for(Declaration decl:declarationList) decl.doJavaCoding(indent+"   ");
    for(Statement stm:statements) stm.doJavaCoding(indent+"   ");
  	if(type!=null) Util.code(indent+"   return($result);");
  	Util.code(indent+'}');
  	Global.currentScope=declaredIn;
    }

  
  // ***********************************************************************************************
  // *** Coding: CLASS, PROCEDURE, SWITCH, SUBBLOCK, PREFIXED BLOCK  ==>  .java file  QPSystem
  // ***********************************************************************************************
  // Output .java file for Class, Procedure, SubBlock and Prefixed Block.
  private void doBlockJavaCoding(String indent)
  {	Global.sourceLineNumber=lineNumber;
    //Util.BREAK("BlockDeclaration.doBlockJavaCoding: "+identifier);
	ASSERT_SEMANTICS_CHECKED(this);
	JavaModule javaModule=new JavaModule(this);
	Global.javaModules.add(javaModule); 
	javaModule.openJavaOutput();
	Global.currentScope=this;
    String line="public class "+getJavaIdentifier();
	if(prefix!=null) line=line+" extends "+getPrefix().getJavaIdentifier();
	else line=line+" extends RTObject$";
	
	Util.code(indent+line+" {");
	doPrototypeCoding(indent+"   ");
	if(blockKind==BlockDeclaration.Kind.Procedure  && type!=null)
	{ Util.code(indent+"   // Declare return value as attribute");
	  Util.code(indent+"   public "+type.toJavaType()+' '+"$result;");
	  Util.code(indent+"   public Object $result() { return($result); }");
	}
//	else if(blockKind==BlockDeclaration.Kind.Switch)
//	{ Util.code(indent+"   // Declare return value as attribute");
//	  Util.code(indent+"   public $LABQNT $result;");
//	  Util.code(indent+"   public Object $result() { return($result); }");
//	}
	
	Util.code(indent+"   // Declare parameters as attributes");
	boolean hasParameter=false;
	for(Parameter par:parameterList)
	{ String tp=par.toJavaType(); hasParameter=true;
//	  Util.code(indent+"   public "+tp+' '+par.identifier+';');
	  Util.code(indent+"   public "+tp+' '+par.externalIdent+';');
	}
	if(!labelList.isEmpty())
	{ Util.code(indent+"   // Declare local labels");
	  Util.code(indent+"   public int $LX;");
	  for(Declaration decl:labelList) decl.doJavaCoding(indent+"   ");
	}
	Util.code(indent+"   // Declare locals as attributes");
	for(Declaration decl:declarationList) decl.doJavaCoding(indent+"   ");
	
    for(Virtual virtual:virtualList) virtual.doJavaCoding(indent+"   ");
	
	if(blockKind==BlockDeclaration.Kind.Procedure && hasParameter) doCodePrepareFormal(indent);
//	if(blockKind==BlockDeclaration.Kind.Switch) doCodePrepareFormal(indent);
	
	doCodeConstructor(indent);

	doCodeStatements(indent);
	
	if(this.isMainModule)
	{ Util.code(indent+"");
	  Util.code(indent+"   public static void main(String[] args) {");
//	  Util.code(indent+"     System.out.println(\"Start Execution of "+getJavaIdentifier()+"\");");
	  Util.code(indent+"     try { new "+getJavaIdentifier()+"(CTX$).STM(); }");
	  Util.code(indent+"     catch($LABQNT q) { System.err.println(\"ERROR: Illegal GOTO \"+q); q.printStackTrace(); }");
	  Util.code(indent+"     catch(Throwable t) { System.err.println(\"ERROR: \"+t.getMessage()); t.printStackTrace(); }");
//	  Util.code(indent+"     System.out.println(\""+getJavaIdentifier()+" Terminates Normally\");");
	  Util.code(indent+"   }"); // End of main
	}
	Util.code(indent+'}'); // End of Class
	
	Global.currentScope=declaredIn;
	javaModule.closeJavaOutput();
  }
  
  
  // ***********************************************************************************************
  // *** Coding Utility: doCodeConstructor
  // ***********************************************************************************************
  private void doCodeConstructor(String indent)
  {	Util.code(indent+"   // Normal Constructor");
	String line="public "+getJavaIdentifier()+edFormalParameterList(false);
	Util.code(indent+"   "+line);
	if(prefix!=null) 
	{ BlockDeclaration prefixClass=this.getPrefix();
	  Util.code(indent+"      "+"super"+prefixClass.edSuperParameterList());
	} else Util.code(indent+"      "+"super(staticLink);");
	Util.code(indent+"      // Parameter assignment to locals");
	for(Parameter par:parameterList)
//		  Util.code(indent+"      this."+par.externalIdent+" = par$"+par.identifier+';');
		  Util.code(indent+"      this."+par.externalIdent+" = s"+par.externalIdent+';');	
	
	switch(blockKind)
	{ case Class:
	  case PrefixedBlock:
		  { if(this.isMainModule)
			  Util.code(indent+"      "+"BPRG(\""+identifier+"\");");
		    else if(hasNoRealPrefix())
			  Util.code(indent+"      BBLK(); // Iff no prefix");
            break;
          }
	  case SubBlock:
	  case Procedure:    Util.code(indent+"      "+"BBLK();");
		
	  default: // Nothing
	}

	Util.code(indent+"      // Declaration Code");
	for(Declaration decl:declarationList) decl.doDeclarationCoding(indent+"   ");
	switch(blockKind)
	{ case Class:
	  case PrefixedBlock: doCodeCreateClassBody(indent+"      "); break;
	  case Procedure: Util.code(indent+"      "+"STM();");		
	  default: // Nothing
	}
	Util.code(indent+"   "+'}'); // End of Constructor
  }
  
  
  // ***********************************************************************************************
  // *** Coding Utility: doCodePrepareFormal
  // ***********************************************************************************************
  private void doCodePrepareFormal(String indent)
  { Util.code(indent+"   // Parameter Transmission in case of Formal/Virtual Procedure Call");
  	Util.code(indent+"   private int $npar=0; // Number of actual parameters transmitted.");
  	Util.code(indent+"   public "+getJavaIdentifier()+" setPar(Object param)");
  	Util.code(indent+"   { //Util.BREAK(\"CALL "+getJavaIdentifier()+".setPar: param=\"+param+\", qual=\"+param.getClass().getSimpleName()+\", npar=\"+$npar+\", staticLink=\"+SL$);");
  	Util.code(indent+"     try { switch($npar++) {");
  	int npar=0;
  	for(Parameter par:parameterList)
  	{ String tp=par.toJavaType();
  	  String typeValue;
  	  if(par.mode==Parameter.Mode.name) typeValue=("("+tp+")param");
//  	  else if(par.kind==Parameter.Kind.Array) typeValue=("("+tp+")param");
  	  else if(par.kind==Parameter.Kind.Array) typeValue=("arrayValue(param)");
  	  else if(par.kind==Parameter.Kind.Procedure) typeValue=("procValue(param)");
  	  else if(par.kind!=Parameter.Kind.Simple) typeValue=("("+tp+")param");
  	  else if(par.type.isArithmeticType()) typeValue=(tp+"Value(param)");
//  	  else typeValue=("("+tp+")param");
  	  else typeValue=("("+tp+")objectValue(param)");
//  	  Util.code(indent+" 	      case "+(npar++)+": "+par.identifier+"="+typeValue+"; break;");
  	  Util.code(indent+" 	      case "+(npar++)+": "+par.externalIdent+"="+typeValue+"; break;");
    }
  	Util.code(indent+" 	      default: throw new RuntimeException(\"Wrong number of parameters\");");
  	Util.code(indent+"     } } catch(ClassCastException e) { throw new RuntimeException(\"Wrong type of parameter: \"+$npar+\" \"+param,e);}");
  	Util.code(indent+"     return(this);");
  	Util.code(indent+"   }");
  	Util.code(indent+"   // Constructor in case of Formal/Virtual Procedure Call");
  	Util.code(indent+"   public "+getJavaIdentifier()+"(RTObject$ staticLink)");
  	Util.code(indent+"   { super(staticLink); }");
  }

  // ***********************************************************************************************
  // *** Coding Utility: doCodeStatements
  // ***********************************************************************************************
  private void doCodeStatements(String indent)
  {	switch(blockKind)
	{ case SubBlock:  codeSubBlockCode(indent); break;
	  case Procedure: codeProcedureBody(indent); break;
	  case Class: codeClassStatements(indent); break;
	  case PrefixedBlock: break; // USES DEFAULT VERSION OF  STM()
	  case SimulaProgram: codeProgramCode(indent); break;
	  default: Util.FATAL_ERROR("Impossible");
	}  
  }
  
  // ***********************************************************************************************
  // *** Coding Utility: codeClassStatements
  // ***********************************************************************************************
  private void codeClassStatements(String indent)
  {	Util.code(indent+"   // Class Statements");
  String classID=this.getJavaIdentifier();
  Util.code(indent+"   public "+classID+" STM() { return(("+classID+")CODE$.EXEC$()); }");
  Util.code(indent+"   public "+classID+" START() { START(this); return(this); }");
  

  }
  
  // ***********************************************************************************************
  // *** Coding Utility: codeProgramCode
  // ***********************************************************************************************
  private void codeProgramCode(String indent)
  {	Util.code(indent+"   // SimulaProgram Statements");
	Util.code(indent+"   public RTObject$ STM() {");
	Util.code(indent+"      BPRG(\""+identifier+"\");");
  
   	codeSTMBody(indent);
    Util.code(indent+"      EBLK();");
  
	Util.code(indent+"      "+"return(null);");
	Util.code(indent+"   }"); // End of SimulaProgram Statements
  }
  
  // ***********************************************************************************************
  // *** Coding Utility: codeSubBlockCode
  // ***********************************************************************************************
  private void codeSubBlockCode(String indent)
  {	Util.code(indent+"   // SubBlock Statements");
	Util.code(indent+"   public RTObject$ STM() {");
    codeSTMBody(indent);
    Util.code(indent+"      EBLK();");
	Util.code(indent+"      return(null);");
    Util.code(indent+"   }"); // End of SubBlock Statements
	}
  
  // ***********************************************************************************************
  // *** Coding Utility: codeProcedureBody  -- Redefined in SwitchDeclaration
  // ***********************************************************************************************
  public void codeProcedureBody(String indent)
  {	Util.code(indent+"   // Procedure Statements");
    Util.code(indent+"   public "+getJavaIdentifier()+" STM() {");
   	codeSTMBody(indent);
    Util.code(indent+"      EBLK();");
    Util.code(indent+"      return(this);");
    Util.code(indent+"   } // End of Procedure BODY");
   	}
  
  // ***********************************************************************************************
  // *** Coding Utility: doCodeCreateClassBody
  // ***********************************************************************************************
  public void doCodeCreateClassBody(String indent)
  {	Util.code(indent+"// Create Class Body");
	Util.code(indent+"CODE$=new ClassBody(CODE$,this) {");
	Util.code(indent+"   public void STM() {");
	
//    for(Statement stm:statements) stm.doJavaCoding(indent+"      ");
   	codeSTMBody(indent);
    
	if(hasNoRealPrefix())
		  Util.code(indent+"      EBLK(); // Iff no prefix");
	else if(this.isMainModule)
		Util.code(indent+"      "+"EBLK();");
	Util.code(indent+"}};");  
  }

  // ***********************************************************************************************
  // *** Coding Utility: codeSTMBody
  // ***********************************************************************************************
  private void codeSTMBody(String indent)
  {	if(!labelList.isEmpty())
	{ Util.code(indent+"       "+externalIdent+" THIS$=("+externalIdent+")CUR$;");
      Util.code(indent+"       LOOP$:while($LX>=0)");
      Util.code(indent+"       { try {");
	}
    doCodeJumpTable(indent+"         "); // Prepare for goto-engineering.
    for(Statement stm:statements) stm.doJavaCoding(indent+"         ");
	if(!labelList.isEmpty())
    { Util.code(indent+"         break LOOP$;");
      Util.code(indent+"       }");
      Util.code(indent+"       catch($LABQNT q) {");
      Util.code(indent+"           CUR$=THIS$;");
      Util.code(indent+"           if(q.SL$!=CUR$)");
      Util.code(indent+"           { CUR$.STATE$=OperationalState.terminated;");
      Util.code(indent+"             if(GOTO_TRACING) TRACE_GOTO(\"NON-LOCAL\",q);");
      Util.code(indent+"             throw(q);");
      Util.code(indent+"           }");
      Util.code(indent+"           if(GOTO_TRACING) TRACE_GOTO(\"LOCAL\",q);");
      Util.code(indent+"           $LX=q.index; continue LOOP$; // EG. GOTO Lx"); 
      Util.code(indent+"       }");
      Util.code(indent+"     }");
    }
  }
  
    
  // ***********************************************************************************************
  // *** Coding Utility: edSuperParameterList
  // ***********************************************************************************************
  private String edSuperParameterList()
  { StringBuilder s=new StringBuilder(); s.append("(staticLink");
    for(Parameter par:new ClassParameterIterator())  // Iterates through prefix-chain
        s.append(",s").append(par.externalIdent); // s to indicate Specified Parameter
    s.append(");"); //runtimeBlockKind=getRTBlockKind();
    return(s.toString());
  }

  // ***********************************************************************************************
  // *** Coding Utility: doCodeJumpTable
  // ***********************************************************************************************
  public void doCodeJumpTable(String indent)
  {	if(labelList.isEmpty()) return;
	Util.code(indent+"switch($LX) {");
	for(LabelDeclaration label:labelList)
//		Util.code(indent+"   case "+label.index+": /* Label:"+label.identifier+" */ break;");
//		Util.code(indent+"   case "+label.index+": JUMP("+label.index+','+label.identifier+"); break;");
//		Util.code(indent+"   case "+label.index+": JUMP("+label.index+','+label.index+"); break;");
		Util.code(indent+"   case "+label.index+": JUMP("+label.index+"); break;");
	Util.code(indent+"   default:");
	Util.code(indent+"}"); // End of main
  }
  

  // ***********************************************************************************************
  // *** Coding Utility: edFormalParameterList
  // ***********************************************************************************************
  // Also used by subclass StandardProcedure
  public String edFormalParameterList(boolean isMethod)   // Accumulates through prefix-chain when class
  { StringBuilder s=new StringBuilder(); s.append('(');
    boolean withparams=false;
    if(!isMethod) { s.append("RTObject$ staticLink"); withparams=true; }
    for(Declaration par:new ClassParameterIterator())  // Iterates through prefix-chain
    { if(withparams) s.append(','); withparams=true;
      s.append(((Parameter)par).toJavaType());
      s.append(' ');
//      if(!isMethod) s.append("par$");
//      s.append(par.identifier);
      if(isMethod) s.append(par.identifier);
      else s.append('s').append(par.externalIdent); // s to indicate Specified Parameter
    }
    s.append(") {");
    return(s.toString());
  }


  // ***********************************************************************************************
  // *** Printing Utility: print
  // ***********************************************************************************************
  public void print(String indent,String tail)
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
    if(!hiddenList.isEmpty()) System.out.println(indent+"   HIDDEN"+hiddenList);
    if(!protectedList.isEmpty()) System.out.println(indent+"   PROTECTED"+protectedList);
    for(Declaration decl:declarationList) decl.print(indent+"   ",";");
    for(Statement stm:statements) stm.print(indent+"   ",";");
	System.out.println(indent+"end["+edScopeChain()+']'+tail); 
	//Util.BREAK("BlockDeclaration.print DONE");
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
    if(!virtualList.isEmpty())
    { s.append(" VIRTUAL: ");
      first=true;
      for(Declaration virt:virtualList)
      { if(!first) s.append(','); s.append(virt); first=false; }
    }
    s.append(';');
    return(s.toString());
  }

  public String toString()
  { return(""+identifier+'['+externalIdent+"] BlockDeclaration.Kind="+blockKind+", BlockPrefix="+blockPrefix); }

}
