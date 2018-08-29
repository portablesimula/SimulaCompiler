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
public class ClassDeclaration extends BlockDeclaration
{     
  public String prefix; // Class Prefix in case of a SubClass or Prefixed Block.
  public boolean detachUsed=false; // Set true when attribute procedure 'detach' is used in/on this class.
  public Vector<Parameter> parameterList=new Vector<Parameter>();
  public Vector<VirtualSpecification> virtualList=new Vector<VirtualSpecification>();
  public Vector<String> hiddenList=new Vector<String>();
  public Vector<String> protectedList=new Vector<String>();
  
  // ***********************************************************************************************
  // *** CONSTRUCTORS
  // ***********************************************************************************************
  public ClassDeclaration(String identifier,BlockKind blockKind)
  { super(identifier); this.blockKind=blockKind; } 
  public ClassDeclaration(String identifier)
  { super(identifier); } 
  
  
  // ***********************************************************************************************
  // *** Utility: addParameter
  // ***********************************************************************************************
  public void addParameter(Parameter parameter)
  { for(Parameter par:parameterList)
	   	if(par.identifier.equalsIgnoreCase(parameter.identifier))
           { Util.error("Parameter already defined: "+identifier); return; }
    parameterList.add(parameter);
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
  public static ClassDeclaration doParseClassDeclaration(String prefix)
  { ClassDeclaration block=new ClassDeclaration(null,BlockKind.Class);
	block.prefix=prefix;
	block.declaredIn.hasLocalClasses=true;
	//Util.BREAK("ClassDeclaration.doParseClassDeclaration: set hasLocalClasses in="+block.declaredIn);
	if(block.prefix==null) block.prefix=StandardClass.CLASS.identifier;

	BlockParser.doParse(block);
    
	//Util.BREAK("ClassDeclaration.doParseClassDeclaration: set Type="+Type.Ref(block.identifier));
	block.type=Type.Ref(block.identifier);
    if(Option.TRACE_PARSE) Parser.TRACE("Parse ClassDeclaration");
	if(Option.TRACE_PARSE) Util.TRACE("END ClassDeclaration: "+block);
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
  public boolean isSubClassOf(ClassDeclaration other)
  { ClassDeclaration prefixClass=getPrefixClass();
    //Util.BREAK("ClassDeclaration: ("+this+").isSubClassOf("+other+')');
    if(prefixClass!=null) do
    { //Util.BREAK("ClassDeclaration.isSubClassOf: prefix="+prefixClass);
      if(other==prefixClass)
      { //Util.BREAK("ClassDeclaration: ("+this.identifier+").isSubClassOf("+other.identifier+") Returns TRUE");
    	  return(true);
      }
    } while((prefixClass=prefixClass.getPrefixClass())!=null);
    //Util.BREAK("ClassDeclaration: ("+this.identifier+").isSubClassOf("+other.identifier+") Returns FALSE");
    return(false);
  }
  
//  // ***********************************************************************************************
//  // *** Utility: isSameOrSubClassOf
//  // ***********************************************************************************************
//  public boolean isSameOrSubClassOf(ClassDeclaration other)
//  { if(this==other) return(true);
//	return(isSubClassOf(other));
//  }


  // ***********************************************************************************************
  // *** Checking
  // ***********************************************************************************************
  public void doChecking()
  { if(IS_SEMANTICS_CHECKED()) return;
 	Global.sourceLineNumber=lineNumber;
	if(externalIdent==null) externalIdent=edJavaClassName();
    //Util.BREAK("ClassDeclaration("+identifier+").doChecking: externalIdent="+externalIdent);

	currentBlockLevel++; blockLevel=currentBlockLevel;
	//Util.BREAK("ClassDeclaration("+identifier+").doChecking: currentBlockLevel="+currentBlockLevel);
	//Util.BREAK("ClassDeclaration("+identifier+").doChecking: blockLevel="+blockLevel);
    //Util.BREAK("ClassDeclaration("+identifier+").doChecking: declaredIn="+declaredIn);
    Global.currentScope=this;
    
    int prfx=prefixLevel();
    //Util.BREAK("ClassDeclaration("+identifier+").doChecking: prefixLevel="+prfx);
    for(Parameter par:this.parameterList) par.setExternalIdentifier(prfx);
    for(Declaration par:new ClassParameterIterator()) par.doChecking();
    for(VirtualSpecification vrt:virtualList) vrt.doChecking();
    for(Declaration dcl:declarationList) dcl.doChecking();
    for(Statement stm:statements) stm.doChecking();
	checkLabelList(prfx);
    Global.currentScope=declaredIn;
	if(blockKind!=BlockKind.CompoundStatement) currentBlockLevel--;
    SET_SEMANTICS_CHECKED();
  }

  // ***********************************************************************************************
  // *** Utility: checkLabelList
  // ***********************************************************************************************
  protected void checkLabelList(int prfx) {
	  int labelIndex=1;
	  for(LabelDeclaration label:labelList)	{
		  label.prefixLevel=prfx; label.index=labelIndex++;
	      //Util.BREAK("ClassDeclaration("+identifier+").doChecking: Treat Label("+label.identifier+")="+label);
	      label.myVirtual=findVirtualSpecification(label.identifier);
	      //Util.BREAK("ClassDeclaration("+identifier+").doChecking: Find Virtual Label("+label.identifier+")="+label.myVirtual);
	      if(label.myVirtual!=null) {
	    	  DeclarationScope scope=label.myVirtual.declaredIn;
	          //Util.BREAK("ClassDeclaration("+identifier+").doChecking: Find Virtual Label("+label.identifier+"): scope="+scope);
	          //Util.BREAK("ClassDeclaration("+identifier+").doChecking: Find Virtual Label("+label.identifier+"): label.declaredIn="+label.declaredIn);
	          if(scope==label.declaredIn) label.myVirtual.setLabelMatch(label);
	          else ((ClassDeclaration)label.declaredIn).virtualList.add(new VirtualSpecification(label)); 
	          
	      }
	  }
  }

  // ***********************************************************************************************
  // *** Utility: findVirtualSpecification
  // ***********************************************************************************************
  public VirtualSpecification findVirtualSpecification(String ident)
  { //Util.BREAK("ClassDeclaration("+identifier+").findVirtualSpecification("+ident+"):");
	for(VirtualSpecification virtual:virtualList)
        if(ident.equalsIgnoreCase(virtual.identifier)) {
            //Util.BREAK("ClassDeclaration("+identifier+").findVirtualSpecification("+ident+"): Result="+virtual);
        	return(virtual);
        }
    ClassDeclaration prfx=getPrefixClass();
    //Util.BREAK("ClassDeclaration("+identifier+").findVirtualSpecification("+ident+"): prfx="+prfx);
    if(prfx!=null) return(prfx.findVirtualSpecification(ident));
    //Util.BREAK("ClassDeclaration("+identifier+").findVirtualSpecification("+ident+"): NOT FOUND");
    return(null); 
  }

  // ***********************************************************************************************
  // *** Utility: prefixLevel
  // ***********************************************************************************************
  protected int prefixLevel()
  { if(hasNoRealPrefix()) return(0);
	ClassDeclaration prfx=getPrefixClass();
    if(prfx!=null) return(prfx.prefixLevel()+1);
	return(-1);  
  }
  

  // ***********************************************************************************************
  // *** Utility: findRemoteAttributeMeaning
  // ***********************************************************************************************
  public Meaning findRemoteAttributeMeaning(String ident)
  {return(findRemoteAttributeMeaning(ident,false)); } 
  
  public Meaning findRemoteAttributeMeaning(String ident,boolean behindProtected)
  { //if(ident.equalsIgnoreCase("detach"))Util.BREAK("DeclarationScope("+identifier+").findRemoteAttributeMeaning("+ident+"): scope="+this);
	boolean prtected=false;
    for(String prct:protectedList)
    	if(ident.equalsIgnoreCase(prct))
   	    { if(!withinScope(this)) behindProtected=prtected=true;
   	      break;
    	}
    //Util.BREAK("DeclarationScope("+identifier+").findRemoteAttributeMeaning("+ident+"): prtected="+prtected);
    if(!prtected)
    { for(Parameter parameter:parameterList)
        if(ident.equalsIgnoreCase(parameter.identifier))
        	return(new Meaning(Variable.Kind.parameter,parameter,this,this,behindProtected));
      for(Declaration declaration:declarationList)
	    if(ident.equalsIgnoreCase(declaration.identifier))
	    	return(new Meaning(Variable.Kind.attribute,declaration,this,this,behindProtected));
      for(LabelDeclaration label:labelList)
	    if(ident.equalsIgnoreCase(label.identifier))
	    	return(new Meaning(Variable.Kind.label,label,this,this,behindProtected));
      for(VirtualSpecification virtual:virtualList)
	    if(ident.equalsIgnoreCase(virtual.identifier))
	    	return(new Meaning(Variable.Kind.virtual,virtual,this,this,behindProtected)); 
    }
    //Util.BREAK("NOT FOUND - DeclarationScope("+identifier+").findRemoteAttributeMeaning("+ident+"): scope="+declaredIn);
    
//    if( ((BlockDeclaration)this).hasNoRealPrefix()) return(null);  // TODO: SIKKER PÅ DETTE ?
    
    ClassDeclaration prfx=getPrefixClass();
    if(prfx!=null)
    { Meaning meaning=prfx.findRemoteAttributeMeaning(ident,behindProtected);
      if(meaning!=null) meaning.declaredIn=this;
      return(meaning);
    }
    return(null);
  }
  
  
  // ***********************************************************************************************
  // *** Utility: withinScope -- Used by findRemoteAttributeMeaning
  // ***********************************************************************************************
  private static boolean withinScope(DeclarationScope otherScope)
  { DeclarationScope scope=Global.currentScope;
	while(scope!=null)
	{ if(scope==otherScope) return(true);
	  if(scope instanceof ClassDeclaration)
	  { ClassDeclaration prfx=((ClassDeclaration)scope).getPrefixClass();
	    while(prfx!=null)
	    { if(prfx==otherScope) return(true);
	      prfx=prfx.getPrefixClass();
	    }
	  }
	  scope=scope.declaredIn;
	}
	return(false);
  }
  
  // ***********************************************************************************************
  // *** Utility: findVisibleAttributeMeaning
  // ***********************************************************************************************
  public Meaning findVisibleAttributeMeaning(String ident)
  { //if(ident.equalsIgnoreCase("ln")) Util.BREAK("DeclarationScope("+identifier+").findVisibleAttributeMeaning("+ident+"): scope="+this);
    //if(ident.equalsIgnoreCase("ln")) Util.BREAK("DeclarationScope("+identifier+").findVisibleAttributeMeaning("+ident+"): declaredIn="+declaredIn);
	boolean searchBehindHidden=false;
	ClassDeclaration scope=this;
	SEARCH:while(scope!=null)
    { //if(ident.equalsIgnoreCase("adHoc00")) Util.BREAK("DeclarationScope("+scope+").findVisibleAttributeMeaning("+ident+"): scope="+scope);
//	  for(Parameter parameter:scope.parameterList)
//      if(ident.equalsIgnoreCase(parameter.identifier))
//        { DeclarationScope hiddenScope=scope.getHidden(ident);
//          if(hiddenScope==null) return(new Meaning(Variable.Kind.parameter,parameter,this,scope,searchBehindHidden));
//          scope=scope.getScopeBehindHidden(ident); continue SEARCH;
//        }
      for(Declaration declaration:scope.declarationList)
	    if(ident.equalsIgnoreCase(declaration.identifier))
	    { ClassDeclaration hiddenScope=scope.getHidden(ident);
          if(hiddenScope==null) return(new Meaning(Variable.Kind.attribute,declaration,this,scope,searchBehindHidden));
          scope=scope.getScopeBehindHidden(ident); continue SEARCH;
	    }
	  for(Parameter parameter:scope.parameterList)
	      if(ident.equalsIgnoreCase(parameter.identifier))
	        { DeclarationScope hiddenScope=scope.getHidden(ident);
	          if(hiddenScope==null) return(new Meaning(Variable.Kind.parameter,parameter,this,scope,searchBehindHidden));
	          scope=scope.getScopeBehindHidden(ident); continue SEARCH;
	        }
      for(LabelDeclaration label:scope.labelList)
	    if(ident.equalsIgnoreCase(label.identifier))
	    { DeclarationScope hiddenScope=scope.getHidden(ident);
          if(hiddenScope==null)	return(new Meaning(Variable.Kind.label,label,this,scope,searchBehindHidden));
          scope=scope.getScopeBehindHidden(ident); continue SEARCH;
	    }
      for(VirtualSpecification virtual:scope.virtualList)
	    if(ident.equalsIgnoreCase(virtual.identifier))
	    { DeclarationScope hiddenScope=scope.getHidden(ident);
          if(hiddenScope==null)	return(new Meaning(Variable.Kind.virtual,virtual,this,scope,searchBehindHidden));
          scope=scope.getScopeBehindHidden(ident); continue SEARCH;
	    }
      
      if(scope.getHidden(ident)==null) scope=scope.getPrefixClass();
      else { scope=scope.getScopeBehindHidden(ident); searchBehindHidden=true; }
	}
    return(null);
  }

  // ***********************************************************************************************
  // *** Utility: getHidden  --  Used by findVisibleAttributeMeaning
  // ***********************************************************************************************
  // Search backwards through prefix chain - find hidden
  // then return the scope where it was specified hidden.
  // If no HIDDEN was found - return null
  public ClassDeclaration getHidden(String ident)
  { ClassDeclaration prfx=getPrefixClass();
    //Util.BREAK("DeclarationScope("+identifier+").getHidden("+ident+"): scope="+this+", prefix="+prfx);
	if(prfx==null) return(null);
    for(String hdn:prfx.hiddenList) if(ident.equalsIgnoreCase(hdn))
    { //Util.BREAK("DeclarationScope("+identifier+").getHidden("+ident+"): FOUND - scope="+prfx);
      return(prfx);
    }
    return(prfx.getHidden(ident));
  }

  // ***********************************************************************************************
  // *** Utility: getScopeBehindHidden  --  Used by findVisibleAttributeMeaning
  // ***********************************************************************************************
  // Search for protected backwards through prefix chain starting with this scope
  // - find corresponding protected
  // then return the scope prefix to where it was specified protected.
  // If no PROTECTED was found - Runtime Error
  private ClassDeclaration getScopeBehindHidden(String ident)
  { ClassDeclaration scope=this;
    //Util.BREAK("DeclarationScope("+identifier+").getScopeBehindHidden("+ident+"): scope="+scope);
    while(scope!=null)
	{ ClassDeclaration prfx=scope.getPrefixClass();
      for(String ptc:scope.protectedList) if(ident.equalsIgnoreCase(ptc)) return(prfx);
      scope=prfx;
      //Util.BREAK("DeclarationScope("+identifier+").getScopeBehindHidden("+ident+"): scope="+scope);
	}
	throw new RuntimeException(ident+" is specified HIDDEN without being PROTECTED");
  }
  
// ***********************************************************************************************
// *** Utility: getPrefixClass
// ***********************************************************************************************
public ClassDeclaration getPrefixClass()
{ //Util.BREAK("DeclarationScope.getPrefixClass: "+prefix);
	if(prefix==null) return(null);
  //Util.BREAK("DeclarationScope.getPrefixClass("+prefix+") Search in "+declaredIn);
  Meaning meaning=declaredIn.findMeaning(prefix);
  //Util.BREAK("DeclarationScope.getPrefixClass("+prefix+") Search in "+declaredIn+", Result="+meaning);
  if(meaning==null) Util.error("Undefined prefix: "+prefix);
  Declaration decl=meaning.declaredAs;
  if(decl==this) Util.error("Class prefix chain loops");
  if(decl instanceof ClassDeclaration) return((ClassDeclaration)decl); 
  if(decl instanceof StandardClass) return((ClassDeclaration)decl); 
  Util.error("Prefix "+prefix+" is not a Class, but "+decl.getClass().getSimpleName());
  return(null);
}

// ***********************************************************************************************
// *** Coding Utility: hasNoRealPrefix
// ***********************************************************************************************
public boolean hasNoRealPrefix()
{ ClassDeclaration prfx=getPrefixClass();
  boolean noPrefix=true;
	if(prfx!=null)
	{ noPrefix=false;
	  String prfxString=prfx.identifier;
	  if(prfxString.equalsIgnoreCase("CLASS")) noPrefix=true;
	} 
	return(noPrefix);
}

// ***********************************************************************************************
// *** Coding: isDetachUsed  -- If the 'detach' attribute is used
// ***********************************************************************************************
/**
 * KOMMENTAR FRA Stein:
 * Ta utgangspunkt i hvilke klasser man har kalt "detach" i, altså kvalifikasjonen av de X som er
 * brukt i "X.detach".  Men da må man jo også holde greie på hvilke slike som har forekommet i
 * eksterne "moduler" (som f.eks. SIMULATION), uten at det burde være problematisk. 
 *  
 * @return
 */
public boolean isDetachUsed()
{	//TRAVERSER PREFIX LOOKING FOR  (detachUsed==true)
	if(this.detachUsed) return(true);
  if(this instanceof ClassDeclaration)
	{ ClassDeclaration prfx=((ClassDeclaration)this).getPrefixClass();
	  if(prfx!=null) return(prfx.isDetachUsed());
	}
	return(false);
}


// ***********************************************************************************************
// *** Utility: ClassParameterIterator - // Iterates through prefix-chain
// ***********************************************************************************************
public class ClassParameterIterator implements Iterator<Parameter>,Iterable<Parameter>
{ Iterator<Parameter> prefixIterator;
  Iterator<Parameter> localIterator;
  public ClassParameterIterator()
  { ClassDeclaration prefix=getPrefixClass();
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
  // *** Coding: doJavaCoding
  // ***********************************************************************************************
  public void doJavaCoding(int indent)
  { //Util.BREAK("ClassDeclaration.doJavaCoding: "+identifier+", BlockKind="+blockKind);
	ASSERT_SEMANTICS_CHECKED(this);
	if(this.isPreCompiled) return;
	Global.sourceLineNumber=lineNumber;
	JavaModule javaModule=new JavaModule(this);
	//Util.BREAK("Global.javaModules.add: "+javaModule); 
	Global.javaModules.add(javaModule); 
	javaModule.openJavaOutput();
	Global.currentScope=this;
	int savedIndent=indent; indent=0;
    String line="public class "+getJavaIdentifier();
	if(prefix!=null) line=line+" extends "+getPrefixClass().getJavaIdentifier();
	else line=line+" extends BASICIO$";
	Util.code(indent,line+" {");
	indent++;
	doPrototypeCoding(indent);
	if(blockKind==BlockKind.Procedure  && type!=null)
	{ Util.code(indent,"// Declare return value as attribute");
	  Util.code(indent,"public "+type.toJavaType()+' '+"$result;");
	  Util.code(indent,"public Object $result() { return($result); }");
	}
	Util.code(indent,"// Declare parameters as attributes");
	for(Parameter par:parameterList)
	{ String tp=par.toJavaType();
	  Util.code(indent,"public "+tp+' '+par.externalIdent+';');
	}
	if(!labelList.isEmpty())
	{ Util.code(indent,"// Declare local labels");
	  //Util.code(indent,"   public int JTX$;"); // Moved to RTObject$
	  for(Declaration decl:labelList) decl.doJavaCoding(indent);
	}
	Util.code(indent,"// Declare locals as attributes");
	for(Declaration decl:declarationList) decl.doJavaCoding(indent);
    for(VirtualSpecification virtual:virtualList) virtual.doJavaCoding(indent);
	doCodeConstructor(indent);
	codeClassStatements(indent);
	indent--; Util.code(indent,"}"); // End of Class
	indent=savedIndent;	
	Global.currentScope=declaredIn;
	javaModule.closeJavaOutput();
  }
  
  // ***********************************************************************************************
  // *** Coding: doPrototypeCoding  --  This code instead of traditional Prototype
  // ***********************************************************************************************
  private void doPrototypeCoding(int indent)
  {	//String packetName=SimulaCompiler.packetName;
	Util.code(indent,"// ClassDeclaration: BlockKind="+blockKind+", BlockLevel="+blockLevel+", PrefixLevel="+prefixLevel()
			  +", hasLocalClasses="+((hasLocalClasses)?"true":"false")
	          +", System="+((isQPSystemBlock())?"true":"false")
		      +", detachUsed="+((detachUsed)?"true":"false"));
	Util.code(indent,"public int prefixLevel() { return("+prefixLevel()+"); }");
	if(isQPSystemBlock())
	Util.code(indent,"public boolean isQPSystemBlock() { return(true); }");
	if(isDetachUsed())
	Util.code(indent,"public boolean isDetachUsed() { return(true); }");
  }
    
  // ***********************************************************************************************
  // *** Coding Utility: doCodeConstructor
  // ***********************************************************************************************
  private void doCodeConstructor(int indent)
  {	Util.code(indent,"// Normal Constructor");
	Util.code(indent,"public "+getJavaIdentifier()+edFormalParameterList(false));
	indent++;
	if(prefix!=null) 
	{ ClassDeclaration prefixClass=this.getPrefixClass();
	  Util.code(indent,"super"+prefixClass.edSuperParameterList());
	} else Util.code(indent,"super(staticLink);");
	Util.code(indent,"// Parameter assignment to locals");
	for(Parameter par:parameterList)
//		  Util.code(indent,"      this."+par.externalIdent+" = par$"+par.identifier+';');
		  Util.code(indent,"this."+par.externalIdent+" = s"+par.externalIdent+';');	
	
    if(hasNoRealPrefix())
		  Util.code(indent,"BBLK(); // Iff no prefix");

	Util.code(indent,"// Declaration Code");
    Util.code(indent,"TRACE_BEGIN_DCL$(\""+identifier+"\","+Global.sourceLineNumber+");");
	for(Declaration decl:declarationList) decl.doDeclarationCoding(indent);
	switch(blockKind)
	{ case Class:
	  case PrefixedBlock: doCodeCreateClassBody(indent); break;
	  case Procedure: Util.code(indent,"STM();");		
	  default: // Nothing
	}
	indent--;
	Util.code(indent,"} // End of Constructor");
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
  // *** Coding Utility: doCodeCreateClassBody
  // ***********************************************************************************************
  public void doCodeCreateClassBody(int indent)
  {	Util.code(indent,"// Create Class Body");
	Util.code(indent,"CODE$=new ClassBody(CODE$,this,"+prefixLevel()+") {"); indent++;
	Util.code(indent,"public void STM() {"); indent++;
	Util.code(indent,"TRACE_BEGIN_STM$(\""+identifier+"\","+Global.sourceLineNumber+",inner);");
   	codeSTMBody(indent);
	Util.code(indent,"TRACE_END_STM$(\""+identifier+"\","+Global.sourceLineNumber+");");
    
	if(hasNoRealPrefix())
		  Util.code(indent,"EBLK(); // Iff no prefix");
	else if(this.isMainModule)
		Util.code(indent,"EBLK();");
	indent--; Util.code(indent,"}");  
	indent--; Util.code(indent,"};");
  }
  
  
  // ***********************************************************************************************
  // *** Coding Utility: codeClassStatements
  // ***********************************************************************************************
  private void codeClassStatements(int indent)
  {	Util.code(indent,"// Class Statements");
    String classID=this.getJavaIdentifier();
    Util.code(indent,"public "+classID+" STM() { return(("+classID+")CODE$.EXEC$()); }");
    Util.code(indent,"public "+classID+" START() { START(this); return(this); }");
  }
    
  // ***********************************************************************************************
  // *** Coding Utility: edSuperParameterList
  // ***********************************************************************************************
  protected String edSuperParameterList()
  { StringBuilder s=new StringBuilder(); s.append("(staticLink");
    for(Parameter par:new ClassParameterIterator())  // Iterates through prefix-chain
        s.append(",s").append(par.externalIdent); // s to indicate Specified Parameter
    s.append(");"); //runtimeBlockKind=getRTBlockKind();
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
	//Util.BREAK("ClassDeclaration.print DONE");
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
  { return(""+identifier+'['+externalIdent+"] BlockKind="+blockKind); }

}
