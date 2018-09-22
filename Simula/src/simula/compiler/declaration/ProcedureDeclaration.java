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
import simula.compiler.parsing.Parser;
import simula.compiler.statement.Statement;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public class ProcedureDeclaration extends BlockDeclaration
{ public VirtualSpecification myVirtual; // Set during doChecking
  public Vector<Parameter> parameterList=new Vector<Parameter>();
  
  // ***********************************************************************************************
  // *** CONSTRUCTORS
  // ***********************************************************************************************
  public ProcedureDeclaration(String identifier,BlockKind blockKind)
  { super(identifier); this.blockKind=blockKind; } 
  
  
  // ***********************************************************************************************
  // *** Utility: addParameter
  // ***********************************************************************************************
  public void addParameter(Parameter parameter)
  { for(Parameter par:parameterList)
	   	if(par.identifier.equalsIgnoreCase(parameter.identifier))
           { Util.error("Parameter already defined: "+identifier); return; }
    parameterList.add(parameter);
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
  public static ProcedureDeclaration doParseProcedureDeclaration(Type type)
  {	BlockKind blockKind=(Option.standardClass)?BlockKind.Method:BlockKind.Procedure;
   	ProcedureDeclaration block=new ProcedureDeclaration(null,blockKind);
    block.type=type;  
    if(Option.TRACE_PARSE) Parser.TRACE("Parse ProcedureDeclaration, type="+type);
	BlockParser.doParse(block);
    if(Option.TRACE_PARSE) Util.TRACE("END ProcedureDeclaration: "+block);
	//Debug.BREAK("END ProcedureDeclaration: ");
    Global.currentScope=block.declaredIn;
	return(block);
  }



  // ***********************************************************************************************
  // *** Checking
  // ***********************************************************************************************
  public void doChecking()
  { if(IS_SEMANTICS_CHECKED()) return;
 	Global.sourceLineNumber=lineNumber;
 	if(blockKind==BlockKind.Method) externalIdent=this.identifier;
 	else if(externalIdent==null) externalIdent=edJavaClassName();

	currentBlockLevel++; blockLevel=currentBlockLevel;
	//Util.BREAK("ProcedureDeclaration("+identifier+").doChecking: currentBlockLevel="+currentBlockLevel);
	//Util.BREAK("ProcedureDeclaration("+identifier+").doChecking: blockLevel="+blockLevel);
    //Util.BREAK("ProcedureDeclaration("+identifier+").doChecking: declaredIn="+declaredIn);
    Global.currentScope=this;
    
    int prfx=0;//prefixLevel();
    //Util.BREAK("ProcedureDeclaration("+identifier+").doChecking: prefixLevel="+prfx);
    for(Parameter par:this.parameterList) par.setExternalIdentifier(prfx);
    for(Declaration par:this.parameterList) par.doChecking();
    for(Declaration dcl:declarationList) dcl.doChecking();
    for(Statement stm:statements) stm.doChecking();
    int labelIndex=1;
	for(LabelDeclaration label:labelList)
	{ label.prefixLevel=prfx; label.index=labelIndex++;	}

//	if(declaredIn.blockKind==BlockKind.Class)
	if(declaredIn instanceof ClassDeclaration)
    { myVirtual=((ClassDeclaration)declaredIn).findVirtualSpecification(identifier);
      //Util.BREAK("ProcedureDeclaration("+identifier+").doChecking: myVirtual="+myVirtual);
      if(myVirtual!=null)
      { DeclarationScope scope=myVirtual.declaredIn;
        if(scope==declaredIn) myVirtual.setMatch(this);
        else ((ClassDeclaration)declaredIn).virtualList.add(myVirtual=new VirtualSpecification(this)); 
      }
    }
    
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
	for(Parameter parameter:parameterList)
	  if(ident.equalsIgnoreCase(parameter.identifier))
	     return(new Meaning(parameter,this,this,false));
    for(LabelDeclaration label:labelList)
	  if(ident.equalsIgnoreCase(label.identifier))
	     return(new Meaning(label,this,this,false));
    return(null);
  }


  // ***********************************************************************************************
  // *** Coding: doJavaCoding
  // ***********************************************************************************************
  public void doJavaCoding()
  { //Util.BREAK("ProcedureDeclaration.doJavaCoding: "+identifier+", BlockKind="+blockKind);
	ASSERT_SEMANTICS_CHECKED(this);
	if(this.isPreCompiled) return;
	switch(blockKind)
    { case Method: doMethodJavaCoding(); break;  // Procedure coded as a Java Method. 
  	  case Procedure: doProcedureCoding(); break;
   	  default: Util.FATAL_ERROR("Impossible Situation !");
    }
  }

    
  // ***********************************************************************************************
  // *** Coding: METHOD  --   Generate Inline Method code for Procedure.
  // ***********************************************************************************************
  // Generate Inline Method code for Procedure.
  private void doMethodJavaCoding()
  { Global.sourceLineNumber=lineNumber;
    //Util.BREAK("ProcedureDeclaration.doMethodJavaCoding: "+identifier);
  	ASSERT_SEMANTICS_CHECKED(this);
  	Global.currentScope=this;
    String line="public "+((type==null)?"void":type.toJavaType());
  	line=line+' '+getJavaIdentifier()+' '+edFormalParameterList(true);
  	JavaModule.code(line);
  	if(type!=null)
	{ JavaModule.code("   // Declare return value as variable");
	  JavaModule.code("   "+type.toJavaType()+' '+"RESULT$"+'='+type.edDefaultValue()+';');
	}
  	
	JavaModule.code("   TRACE_BEGIN_DCL$(\""+identifier+"\","+Global.sourceLineNumber+");");
	for(Declaration decl:labelList) decl.doJavaCoding();
    for(Declaration decl:declarationList) decl.doJavaCoding();
	JavaModule.code("   TRACE_BEGIN_STM$(\""+identifier+"\","+Global.sourceLineNumber+");");
    for(Statement stm:statements) stm.doJavaCoding();
	JavaModule.code("   TRACE_END_STM$(\""+identifier+"\","+Global.sourceLineNumber+");");
  	if(type!=null) JavaModule.code("   return(RESULT$);");
  	JavaModule.code("}");
  	Global.currentScope=declaredIn;
    }


  // ***********************************************************************************************
  // *** Coding Utility: edFormalParameterList
  // ***********************************************************************************************
  // Also used by subclass StandardProcedure
  public String edFormalParameterList(boolean isMethod)   // Accumulates through prefix-chain when class
  { StringBuilder s=new StringBuilder(); s.append('(');
    boolean withparams=false;
    if(!isMethod) { s.append("RTObject$ staticLink"); withparams=true; }
    for(Declaration par:this.parameterList)
    { if(withparams) s.append(','); withparams=true;
      s.append(((Parameter)par).toJavaType()).append(' ');
      if(isMethod) s.append(par.identifier);
      else s.append('s').append(par.externalIdent); // s to indicate Specified Parameter
    }
    s.append(") {");
    return(s.toString());
  }

  
  // ***********************************************************************************************
  // *** Coding: PROCEDURE
  // ***********************************************************************************************
  // Output .java file for Procedure.
  private void doProcedureCoding()
  {	Global.sourceLineNumber=lineNumber;
    //Util.BREAK("ProcedureDeclaration.doProcedureCoding: "+identifier);
	ASSERT_SEMANTICS_CHECKED(this);
	if(this.isPreCompiled) return;
	JavaModule javaModule=new JavaModule(this);
	Global.javaModules.add(javaModule); 
	javaModule.openJavaOutput();
	Global.currentScope=this;
	JavaModule.code("@SuppressWarnings(\"unchecked\")");
	JavaModule.code("public final class "+getJavaIdentifier()+" extends BASICIO$ {");
	doPrototypeCoding();
	if(blockKind==BlockKind.Procedure  && type!=null)
	{ JavaModule.code("// Declare return value as attribute");
	  JavaModule.code("public "+type.toJavaType()+' '+"RESULT$;");
	  JavaModule.code("public Object RESULT$() { return(RESULT$); }");
	}

	JavaModule.code("// Declare parameters as attributes");
	boolean hasParameter=false;
	for(Parameter par:parameterList)
	{ String tp=par.toJavaType(); hasParameter=true;
	  JavaModule.code("public "+tp+' '+par.externalIdent+';');
	}
	if(!labelList.isEmpty())
	{ JavaModule.code("// Declare local labels");
	  //JavaModule.code("   public int JTX$;"); // Moved to RTObject$
	  for(Declaration decl:labelList) decl.doJavaCoding();
	}
	JavaModule.code("// Declare locals as attributes");
	for(Declaration decl:declarationList) decl.doJavaCoding();
	if(blockKind==BlockKind.Procedure && hasParameter) doCodePrepareFormal();
	doCodeConstructor();
	codeProcedureBody();
	JavaModule.code("}"); // End of Procedure
	Global.currentScope=declaredIn;
	javaModule.closeJavaOutput();
  }
  
  
  // ***********************************************************************************************
  // *** Coding: doPrototypeCoding  --  This code instead of traditional Prototype
  // ***********************************************************************************************
  private void doPrototypeCoding()
  {	//String packetName=SimulaCompiler.packetName;
	JavaModule.code("// ProcedureDeclaration: BlockKind="+blockKind+", BlockLevel="+blockLevel
			  +", hasLocalClasses="+((hasLocalClasses)?"true":"false")
	          +", System="+((isQPSystemBlock())?"true":"false")
//		      +", detachUsed="+((detachUsed)?"true":"false")
		      );
	JavaModule.code("public int prefixLevel() { return(0); }");
	if(isQPSystemBlock())
	JavaModule.code("public boolean isQPSystemBlock() { return(true); }");
//	if(isDetachUsed())
//	JavaModule.code("public boolean isDetachUsed() { return(true); }");
  }
  
  
  // ***********************************************************************************************
  // *** Coding Utility: doCodeConstructor
  // ***********************************************************************************************
  private void doCodeConstructor()
  {	JavaModule.code("// Normal Constructor");
	JavaModule.code("public "+getJavaIdentifier()+edFormalParameterList(false));
	JavaModule.code("super(staticLink);");
	JavaModule.code("// Parameter assignment to locals");
	for(Parameter par:parameterList)
		  JavaModule.code("this."+par.externalIdent+" = s"+par.externalIdent+';');	
	
	JavaModule.code("BBLK();");
	JavaModule.code("// Declaration Code");
    JavaModule.code("TRACE_BEGIN_DCL$(\""+identifier+"\","+Global.sourceLineNumber+");");
	for(Declaration decl:declarationList) decl.doDeclarationCoding();
	JavaModule.code("STM();");		
	JavaModule.code("} // End of Constructor");
  }
  
  
  // ***********************************************************************************************
  // *** Coding Utility: doCodePrepareFormal
  // ***********************************************************************************************
  private void doCodePrepareFormal()
  { JavaModule.code("// Parameter Transmission in case of Formal/Virtual Procedure Call");
  	JavaModule.code("private int $npar=0; // Number of actual parameters transmitted.");
  	JavaModule.code("public "+getJavaIdentifier()+" setPar(Object param) {");
  	JavaModule.code("//Util.BREAK(\"CALL "+getJavaIdentifier()+".setPar: param=\"+param+\", qual=\"+param.getClass().getSimpleName()+\", npar=\"+$npar+\", staticLink=\"+SL$);");
  	JavaModule.code("try {");
  	JavaModule.code("switch($npar++) {");
  	int npar=0;
  	for(Parameter par:parameterList)
  	{ String tp=par.toJavaType();
  	  String typeValue;
  	  if(par.mode==Parameter.Mode.name) typeValue=("("+tp+")param");
  	  else if(par.kind==Parameter.Kind.Array) {
  		  typeValue=("arrayValue(param)");
  		  if(par.mode==Parameter.Mode.value) typeValue=typeValue+".COPY()";
  	  }
  	  else if(par.kind==Parameter.Kind.Procedure) typeValue=("procValue(param)");
  	  else if(par.kind!=Parameter.Kind.Simple) typeValue=("("+tp+")param");
  	  else if(par.type.isArithmeticType()) typeValue=(tp+"Value(param)");
  	  else typeValue=("("+tp+")objectValue(param)");
  	  JavaModule.code("case "+(npar++)+": "+par.externalIdent+"="+typeValue+"; break;");
    }
  	JavaModule.code("default: throw new RuntimeException(\"Wrong number of parameters\");");
  	JavaModule.code("}");
  	JavaModule.code("}");
  	JavaModule.code("catch(ClassCastException e) { throw new RuntimeException(\"Wrong type of parameter: \"+$npar+\" \"+param,e);}");
  	JavaModule.code("return(this);");
  	JavaModule.code("}");
  	JavaModule.code("// Constructor in case of Formal/Virtual Procedure Call");
  	JavaModule.code("public "+getJavaIdentifier()+"(RTObject$ staticLink)");
  	JavaModule.code("{ super(staticLink); }");
  }
  
  // ***********************************************************************************************
  // *** Coding Utility: codeProcedureBody  -- Redefined in SwitchDeclaration
  // ***********************************************************************************************
  public void codeProcedureBody()
  {	JavaModule.code("// Procedure Statements");
    JavaModule.code("public "+getJavaIdentifier()+" STM() {");
	JavaModule.code("TRACE_BEGIN_STM$(\""+identifier+"\","+Global.sourceLineNumber+");");
   	codeSTMBody();
	JavaModule.code("TRACE_END_STM$(\""+identifier+"\","+Global.sourceLineNumber+");");
    JavaModule.code("EBLK();");
    JavaModule.code("return(this);");
    JavaModule.code("} // End of Procedure BODY");
  }


  // ***********************************************************************************************
  // *** Printing Utility: print
  // ***********************************************************************************************
  public void print(String indent,String tail)
  { StringBuilder s=new StringBuilder(indent);
    s.append('[').append(blockLevel).append("] ");
    s.append(blockKind).append(' ').append(identifier);
    s.append('[').append(externalIdent).append("] ");
    s.append(editParameterList());
    System.out.println(s.toString());
	String beg="begin["+edScopeChain()+']';
	indent=indent+"    ";
    System.out.println(indent+beg); 
//    if(!hiddenList.isEmpty()) System.out.println(indent+"   HIDDEN"+hiddenList);
//    if(!protectedList.isEmpty()) System.out.println(indent+"   PROTECTED"+protectedList);
    for(Declaration decl:declarationList) decl.print(indent+"   ",";");
    for(Statement stm:statements) stm.print(indent+"   ",";");
	System.out.println(indent+"end["+edScopeChain()+']'+tail); 
	//Util.BREAK("ProcedureDeclaration.print DONE");
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
  { return(""+identifier+'['+externalIdent+"] BlockKind="+blockKind); }

}
