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
import simula.compiler.expression.Variable;
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
      Util.BREAK("ProcedureDeclaration("+identifier+").doChecking: myVirtual="+myVirtual);
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
	     return(new Meaning(Variable.Kind.attribute,declaration,this,this,false));
	for(Parameter parameter:parameterList)
	  if(ident.equalsIgnoreCase(parameter.identifier))
	     return(new Meaning(Variable.Kind.parameter,parameter,this,this,false));
    for(LabelDeclaration label:labelList)
	  if(ident.equalsIgnoreCase(label.identifier))
	     return(new Meaning(Variable.Kind.label,label,this,this,false));
    return(null);
  }


  // ***********************************************************************************************
  // *** Coding: doJavaCoding
  // ***********************************************************************************************
  public void doJavaCoding(int indent)
  { //Util.BREAK("ProcedureDeclaration.doJavaCoding: "+identifier+", BlockKind="+blockKind);
	ASSERT_SEMANTICS_CHECKED(this);
	if(this.isPreCompiled) return;
	switch(blockKind)
    { case Method: doMethodJavaCoding(indent); break;  // Procedure coded as a Java Method. 
  	  case Procedure: doProcedureCoding(indent); break;
   	  default: Util.FATAL_ERROR("Impossible Situation !");
    }
  }

    
  // ***********************************************************************************************
  // *** Coding: METHOD  --   Generate Inline Method code for Procedure.
  // ***********************************************************************************************
  // Generate Inline Method code for Procedure.
  private void doMethodJavaCoding(int indent)
  { Global.sourceLineNumber=lineNumber;
    //Util.BREAK("ProcedureDeclaration.doMethodJavaCoding: "+identifier);
  	ASSERT_SEMANTICS_CHECKED(this);
  	Global.currentScope=this;
    String line="public "+((type==null)?"void":type.toJavaType());
  	line=line+' '+getJavaIdentifier()+' '+edFormalParameterList(true);
  	Util.code(indent,line);
  	if(type!=null)
	{ Util.code(indent,"   // Declare return value as variable");
	  Util.code(indent,"   "+type.toJavaType()+' '+"$result"+'='+type.edDefaultValue()+';');
	}
  	
	Util.code(indent,"   TRACE_BEGIN_DCL$(\""+identifier+"\","+Global.sourceLineNumber+");");
	for(Declaration decl:labelList) decl.doJavaCoding(indent+1);
    for(Declaration decl:declarationList) decl.doJavaCoding(indent+1);
	Util.code(indent,"   TRACE_BEGIN_STM$(\""+identifier+"\","+Global.sourceLineNumber+");");
    for(Statement stm:statements) stm.doJavaCoding(indent+1);
	Util.code(indent,"   TRACE_END_STM$(\""+identifier+"\","+Global.sourceLineNumber+");");
  	if(type!=null) Util.code(indent,"   return($result);");
  	Util.code(indent,"}");
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
  private void doProcedureCoding(int indent)
  {	Global.sourceLineNumber=lineNumber;
    //Util.BREAK("ProcedureDeclaration.doProcedureCoding: "+identifier);
	ASSERT_SEMANTICS_CHECKED(this);
	if(this.isPreCompiled) return;
	JavaModule javaModule=new JavaModule(this);
	Global.javaModules.add(javaModule); 
	javaModule.openJavaOutput();
	Global.currentScope=this;
	int savedIndent=indent; indent=0;
	Util.code(indent,"public class "+getJavaIdentifier()+" extends BASICIO$ {");
	indent++;
	doPrototypeCoding(indent);
	if(blockKind==BlockKind.Procedure  && type!=null)
	{ Util.code(indent,"// Declare return value as attribute");
	  Util.code(indent,"public "+type.toJavaType()+' '+"$result;");
	  Util.code(indent,"public Object $result() { return($result); }");
	}

	Util.code(indent,"// Declare parameters as attributes");
	boolean hasParameter=false;
	for(Parameter par:parameterList)
	{ String tp=par.toJavaType(); hasParameter=true;
	  Util.code(indent,"public "+tp+' '+par.externalIdent+';');
	}
	if(!labelList.isEmpty())
	{ Util.code(indent,"// Declare local labels");
	  //Util.code(indent,"   public int JTX$;"); // Moved to RTObject$
	  for(Declaration decl:labelList) decl.doJavaCoding(indent);
	}
	Util.code(indent,"// Declare locals as attributes");
	for(Declaration decl:declarationList) decl.doJavaCoding(indent);
	if(blockKind==BlockKind.Procedure && hasParameter) doCodePrepareFormal(indent);
	doCodeConstructor(indent);
	codeProcedureBody(indent);
	indent--; Util.code(indent,"}"); // End of Procedure
	indent=savedIndent;
	Global.currentScope=declaredIn;
	javaModule.closeJavaOutput();
  }
  
  
  // ***********************************************************************************************
  // *** Coding: doPrototypeCoding  --  This code instead of traditional Prototype
  // ***********************************************************************************************
  private void doPrototypeCoding(int indent)
  {	//String packetName=SimulaCompiler.packetName;
	Util.code(indent,"// ProcedureDeclaration: BlockKind="+blockKind+", BlockLevel="+blockLevel
			  +", hasLocalClasses="+((hasLocalClasses)?"true":"false")
	          +", System="+((isQPSystemBlock())?"true":"false")
//		      +", detachUsed="+((detachUsed)?"true":"false")
		      );
	Util.code(indent,"public int prefixLevel() { return(0); }");
	if(isQPSystemBlock())
	Util.code(indent,"public boolean isQPSystemBlock() { return(true); }");
//	if(isDetachUsed())
//	Util.code(indent,"public boolean isDetachUsed() { return(true); }");
  }
  
  
  // ***********************************************************************************************
  // *** Coding Utility: doCodeConstructor
  // ***********************************************************************************************
  private void doCodeConstructor(int indent)
  {	Util.code(indent,"// Normal Constructor");
	Util.code(indent,"public "+getJavaIdentifier()+edFormalParameterList(false));
	indent++;
	Util.code(indent,"super(staticLink);");
	Util.code(indent,"// Parameter assignment to locals");
	for(Parameter par:parameterList)
		  Util.code(indent,"this."+par.externalIdent+" = s"+par.externalIdent+';');	
	
	Util.code(indent,"BBLK();");
	Util.code(indent,"// Declaration Code");
    Util.code(indent,"TRACE_BEGIN_DCL$(\""+identifier+"\","+Global.sourceLineNumber+");");
	for(Declaration decl:declarationList) decl.doDeclarationCoding(indent);
	Util.code(indent,"STM();");		
	indent--; Util.code(indent,"} // End of Constructor");
  }
  
  
  // ***********************************************************************************************
  // *** Coding Utility: doCodePrepareFormal
  // ***********************************************************************************************
  private void doCodePrepareFormal(int indent)
  { Util.code(indent,"// Parameter Transmission in case of Formal/Virtual Procedure Call");
  	Util.code(indent,"private int $npar=0; // Number of actual parameters transmitted.");
  	Util.code(indent,"public "+getJavaIdentifier()+" setPar(Object param) {"); indent++;
  	Util.code(indent,"//Util.BREAK(\"CALL "+getJavaIdentifier()+".setPar: param=\"+param+\", qual=\"+param.getClass().getSimpleName()+\", npar=\"+$npar+\", staticLink=\"+SL$);");
  	Util.code(indent,"try {"); indent++;
  	Util.code(indent,"switch($npar++) {"); indent++;
  	int npar=0;
  	for(Parameter par:parameterList)
  	{ String tp=par.toJavaType();
  	  String typeValue;
  	  if(par.mode==Parameter.Mode.name) typeValue=("("+tp+")param");
  	  else if(par.kind==Parameter.Kind.Array) typeValue=("arrayValue(param)");
  	  else if(par.kind==Parameter.Kind.Procedure) typeValue=("procValue(param)");
  	  else if(par.kind!=Parameter.Kind.Simple) typeValue=("("+tp+")param");
  	  else if(par.type.isArithmeticType()) typeValue=(tp+"Value(param)");
  	  else typeValue=("("+tp+")objectValue(param)");
  	  Util.code(indent,"case "+(npar++)+": "+par.externalIdent+"="+typeValue+"; break;");
    }
  	Util.code(indent,"default: throw new RuntimeException(\"Wrong number of parameters\");");
  	indent--; Util.code(indent,"}");
  	indent--; Util.code(indent,"}");
  	Util.code(indent,"catch(ClassCastException e) { throw new RuntimeException(\"Wrong type of parameter: \"+$npar+\" \"+param,e);}");
  	Util.code(indent,"return(this);");
  	indent--; Util.code(indent,"}");
  	Util.code(indent,"// Constructor in case of Formal/Virtual Procedure Call");
  	Util.code(indent,"public "+getJavaIdentifier()+"(RTObject$ staticLink)");
  	Util.code(indent,"{ super(staticLink); }");
  }
  
  // ***********************************************************************************************
  // *** Coding Utility: codeProcedureBody  -- Redefined in SwitchDeclaration
  // ***********************************************************************************************
  public void codeProcedureBody(int indent)
  {	Util.code(indent,"// Procedure Statements");
    Util.code(indent,"public "+getJavaIdentifier()+" STM() {"); indent++;
	Util.code(indent,"TRACE_BEGIN_STM$(\""+identifier+"\","+Global.sourceLineNumber+");");
   	codeSTMBody(indent);
	Util.code(indent,"TRACE_END_STM$(\""+identifier+"\","+Global.sourceLineNumber+");");
    Util.code(indent,"EBLK();");
    Util.code(indent,"return(this);");
    indent--; Util.code(indent,"} // End of Procedure BODY");
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
