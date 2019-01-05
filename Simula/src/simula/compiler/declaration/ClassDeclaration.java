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
  public Vector<VirtualSpecification> virtualSpecList=new Vector<VirtualSpecification>();
  public Vector<VirtualMatch> virtualMatchList=new Vector<VirtualMatch>();
//  public Vector<String> hiddenList=new Vector<String>();
  public Vector<ProtectedSpecification> protectedList=new Vector<ProtectedSpecification>();
  public Vector<HiddenSpecification> hiddenList=new Vector<HiddenSpecification>();
  
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
	block.lastLineNumber=Global.sourceLineNumber;
    
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

//    checkProtectedList();
//    checkHiddenList();

    int prfx=prefixLevel();
    //Util.BREAK("ClassDeclaration("+identifier+").doChecking: prefixLevel="+prfx);
    for(Parameter par:this.parameterList) par.setExternalIdentifier(prfx);
    for(Declaration par:new ClassParameterIterator()) par.doChecking();
    for(VirtualSpecification vrt:virtualSpecList) vrt.doChecking();
    for(Declaration dcl:declarationList) dcl.doChecking();
    for(Statement stm:statements) stm.doChecking();
    checkProtectedList();
    checkHiddenList();
	checkLabelList(prfx);
    Global.currentScope=declaredIn;
    currentBlockLevel--;
    SET_SEMANTICS_CHECKED();
//    print("","");
  }
  
  // ***********************************************************************************************
  // *** Utility: checkHiddenList
  // ***********************************************************************************************
  private void checkHiddenList() {
	  for(HiddenSpecification hdn:hiddenList)
		  hdn.doChecking();
  }
  
  // ***********************************************************************************************
  // *** Utility: checkProtectedList
  // ***********************************************************************************************
  private void checkProtectedList() {
	  for(ProtectedSpecification pct:protectedList) {
		  pct.doChecking();
	  }
  }

  // ***********************************************************************************************
  // *** Utility: checkLabelList
  // ***********************************************************************************************
  protected void checkLabelList(int prfx) {
	  int labelIndex=1;
	  for(LabelDeclaration label:labelList)	{
		  label.prefixLevel=prfx; label.index=labelIndex++;
	  }
  }

  // ***********************************************************************************************
  // *** Utility: searchVirtualSpecList  --    -  Search VirtualSpec-list for 'ident'
  // ***********************************************************************************************
  public VirtualSpecification searchVirtualSpecList(String ident)
  { //Util.BREAK("ClassDeclaration("+identifier+").searchVirtualSpecList("+ident+"):");
	for(VirtualSpecification virtual:virtualSpecList)
        if(ident.equalsIgnoreCase(virtual.identifier)) {
            //Util.BREAK("ClassDeclaration("+identifier+").searchVirtualSpecList("+ident+"): Result="+virtual);
        	return(virtual);
        }
    //Util.BREAK("ClassDeclaration("+identifier+").searchVirtualSpecList("+ident+"): NOT FOUND");
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
  // *** Utility: findClassAttribute
  // ***********************************************************************************************
  public Declaration findClassAttribute(String ident) {
	  ClassDeclaration scope=this;
	  while(scope!=null) {
		  Declaration atr=scope.findLocalAttribute(ident);
		  if(atr!=null) return(atr);
		  scope=scope.getPrefixClass();
	  }
	  return(null);
  }
  
  // ***********************************************************************************************
  // *** Utility: findLocalAttribute
  // ***********************************************************************************************
  public Declaration findLocalAttribute(String ident) {
	  //if(ident.equalsIgnoreCase("P")) Util.BREAK("ClassDeclaration("+identifier+").findLocalAttribute("+ident+"): scope="+this);
	  for(Parameter parameter:parameterList)
	        if(ident.equalsIgnoreCase(parameter.identifier))  	return(parameter);
	  for(Declaration declaration:declarationList)
		    if(ident.equalsIgnoreCase(declaration.identifier)) 	return(declaration);
	  for(LabelDeclaration label:labelList)
		    if(ident.equalsIgnoreCase(label.identifier)) return(label);
	  for(VirtualMatch match:virtualMatchList)
		    if(ident.equalsIgnoreCase(match.identifier)) {
		  	    //if(ident.equalsIgnoreCase("P")) Util.BREAK("ClassDeclaration("+identifier+").findLocalAttribute("+ident+"): FOUND MATCH="+match);
		    	return(match); 
		    }
	  for(VirtualSpecification virtual:virtualSpecList)
		    if(ident.equalsIgnoreCase(virtual.identifier)) return(virtual); 
	  //if(ident.equalsIgnoreCase("P")) Util.BREAK("ClassDeclaration("+identifier+").findLocalAttribute("+ident+"): NOT FOUND");
	  return(null);
  }
  
  // ***********************************************************************************************
  // *** Utility: findLocalProcedure
  // ***********************************************************************************************
  public ProcedureDeclaration findLocalProcedure(String ident) {
	  //if(ident.equalsIgnoreCase("P")) Util.BREAK("ClassDeclaration("+identifier+").findLocalProcedure("+ident+"): scope="+this);
	  for(Declaration decl:declarationList)
		    if(ident.equalsIgnoreCase(decl.identifier)) {
		    	if(decl instanceof ProcedureDeclaration) return((ProcedureDeclaration)decl);
		    	else return(null);
		    }
	  return(null);
  }
  
  // ***********************************************************************************************
  // *** Utility: findRemoteAttributeMeaning
  // ***********************************************************************************************
  public Meaning findRemoteAttributeMeaning(String ident) {
	  //if(ident.equalsIgnoreCase("P"))Util.BREAK("ClassDeclaration("+identifier+").findRemoteAttributeMeaning("+ident+"): scope="+this);
  
	  boolean behindProtected=false;
	  ClassDeclaration scope=this;
	  
	  Declaration decl=scope.findLocalAttribute(ident);
	  if(decl!=null) {
		  boolean prtected=decl.isProtected!=null;
		  //Util.BREAK("ClassDeclaration("+identifier+").findRemoteAttributeMeaning("+ident+"): protected="+prtected);
		  if(decl instanceof ProcedureDeclaration) {
			  VirtualSpecification virtSpec=((ProcedureDeclaration)decl).getVirtualSpecification();
			  if(virtSpec!=null && virtSpec.isProtected!=null) prtected=true;
		  }
		  if(!prtected) {
			  Meaning meaning=new Meaning(decl,this,scope,behindProtected); 
			  //Util.BREAK("ClassDeclaration("+identifier+").findRemoteAttributeMeaning("+ident+"): DIRECT RESULT="+meaning);
			  return(meaning);
		  }
	  }
	  
	  SEARCH:while(scope!=null) {
		  HiddenSpecification hdn = scope.searchHiddenList(ident);
		  //Util.BREAK("ClassDeclaration(" + identifier + ").findRemoteAttributeMeaning: hdn=" + hdn);
		  if (hdn != null) {
			  scope = hdn.getScopeBehindHidden();
			  behindProtected=true;
			  continue SEARCH;
		  }
		  Declaration decl2=scope.findLocalAttribute(ident);
		  if(decl2!=null) {
			  boolean prtected=decl2.isProtected!=null;
			  //Util.BREAK("ClassDeclaration("+identifier+").findRemoteAttributeMeaning("+ident+"): protected="+prtected);
			  if(withinScope(scope)) {
				  //Util.BREAK("ClassDeclaration("+identifier+").findRemoteAttributeMeaning("+ident+"): protected=null for local attribute");
				  prtected=false;  
			  }
			  if(!prtected) {
				  Meaning meaning=new Meaning(decl2,this,scope,behindProtected); 
				  //Util.BREAK("ClassDeclaration("+identifier+").findRemoteAttributeMeaning("+ident+"): RESULT="+meaning);
				  return(meaning);
			  }
			  behindProtected=true;
		  }
		  scope=scope.getPrefixClass();
	  }
	  return(null);
  }
  
  // ***********************************************************************************************
  // *** Utility: searchProtectedList  -  Search Protected-list for 'ident'
  // ***********************************************************************************************
  public ProtectedSpecification searchProtectedList(String ident)
  { //Util.BREAK("ClassDeclaration("+identifier+").searchProtectedList("+ident+"): protectedList="+protectedList);
	for(ProtectedSpecification pct:protectedList) if(ident.equalsIgnoreCase(pct.identifier))
    { //Util.BREAK("ClassDeclaration("+identifier+").searchProtectedList("+ident+"): FOUND in "+this);
      return(pct);
    }
    //Util.BREAK("ClassDeclaration("+identifier+").searchProtectedList("+ident+"): NOT FOUND");
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
  { //if(ident.equalsIgnoreCase("p")) Util.BREAK("ClassDeclaration("+identifier+").findVisibleAttributeMeaning("+ident+"): scope="+this);
	boolean searchBehindHidden=false;
	ClassDeclaration scope=this;
    Declaration decl=scope.findLocalAttribute(ident);
    if(decl!=null) {
		  Meaning meaning=new Meaning(decl,this,scope,searchBehindHidden);
		  //if(ident.equalsIgnoreCase("p")) Util.BREAK("ClassDeclaration("+identifier+").findVisibleAttributeMeaning("+ident+"): FOUND DIRECT meaning="+meaning+", scope="+scope);
		  return(meaning);    	
    }
    scope=scope.getPrefixClass();
    
    SEARCH:while(scope!=null)
    { HiddenSpecification hdn = scope.searchHiddenList(ident);
	  //Util.BREAK("ProcedureDeclaration(" + identifier + ").getVirtualSpecification: hdn=" + hdn);
	  if (hdn != null) {
		  scope = hdn.getScopeBehindHidden();
		  searchBehindHidden=true;
		  continue SEARCH;
	  }
      decl=scope.findLocalAttribute(ident);
      if(decl!=null) {
  		  Meaning meaning=new Meaning(decl,this,scope,searchBehindHidden);
  		  //if(ident.equalsIgnoreCase("p")) Util.BREAK("ClassDeclaration("+identifier+").findVisibleAttributeMeaning("+ident+"): FOUND meaning="+meaning+", scope="+scope);
  		  return(meaning);    	
      }
      scope=scope.getPrefixClass();
    }
	//if(ident.equalsIgnoreCase("p")) Util.BREAK("ClassDeclaration("+identifier+").findVisibleAttributeMeaning("+ident+"): NOT FOUND");
    return(null);
  }
  
  
  // ***********************************************************************************************
  // *** Utility: searchHiddenList -- Search Hidden-list for 'ident'
  // ***********************************************************************************************
  HiddenSpecification searchHiddenList(String ident)
  { for(HiddenSpecification hdn:hiddenList) if(ident.equalsIgnoreCase(hdn.identifier))
    { //Util.BREAK("ClassDeclaration("+identifier+").searchHiddenList("+ident+"): FOUND="+hdn);
      return(hdn);
    }
    return(null);
  }
  
// ***********************************************************************************************
// *** Utility: getPrefixClass
// ***********************************************************************************************
public ClassDeclaration getPrefixClass()
{ //Util.BREAK("ClassDeclaration.getPrefixClass: "+prefix);
	if(prefix==null) return(null);
  //Util.BREAK("ClassDeclaration.getPrefixClass("+prefix+") Search in "+declaredIn);
  Meaning meaning=declaredIn.findMeaning(prefix);
  //Util.BREAK("ClassDeclaration.getPrefixClass("+prefix+") Search in "+declaredIn+", Result="+meaning);
  if(meaning==null) Util.error("Undefined prefix: "+prefix);
  Declaration decl=meaning.declaredAs;
  if(decl==this) Util.error("Class prefix chain loops");
  if(decl instanceof ClassDeclaration) return((ClassDeclaration)decl); 
  if(decl instanceof StandardClass) return((ClassDeclaration)decl); 
  Util.error("Prefix "+prefix+" is not a Class");
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
	public final class ClassParameterIterator implements Iterator<Parameter>, Iterable<Parameter> {
		Iterator<Parameter> prefixIterator;
		Iterator<Parameter> localIterator;

		public ClassParameterIterator() {
			ClassDeclaration prefix = getPrefixClass();
			if (prefix != null)
				prefixIterator = prefix.parameterIterator();
			localIterator = parameterList.iterator();
		}

		public boolean hasNext() {
			if (prefixIterator != null) {
				if (prefixIterator.hasNext())
					return (true);
				prefixIterator = null;
			}
			return (localIterator.hasNext());
		}

		public Parameter next() {
			if (!hasNext())
				return (null);
			if (prefixIterator != null)
				return (prefixIterator.next());
			return (localIterator.next());
		}

		public Iterator<Parameter> iterator() {
			return (new ClassParameterIterator());
		}
	}

	public Iterator<Parameter> parameterIterator() {
		return (new ClassParameterIterator());
	}  

  // ***********************************************************************************************
  // *** Coding: doJavaCoding
  // ***********************************************************************************************
  public void doJavaCoding()
  { //Util.BREAK("ClassDeclaration.doJavaCoding: "+identifier+", BlockKind="+blockKind);
	ASSERT_SEMANTICS_CHECKED(this);
	if(this.isPreCompiled) return;
	Global.sourceLineNumber=lineNumber;
	JavaModule javaModule=new JavaModule(this);
	//Util.BREAK("Global.javaModules.add: "+javaModule); 
	Global.javaModules.add(javaModule); 
	javaModule.openJavaOutput();
	Global.currentScope=this;
	JavaModule.code("@SuppressWarnings(\"unchecked\")");
    String line="public class "+getJavaIdentifier();
	if(prefix!=null) line=line+" extends "+getPrefixClass().getJavaIdentifier();
	else line=line+" extends BASICIO$";
	JavaModule.code(line+" {");
	doPrototypeCoding();
	if(blockKind==BlockKind.Procedure  && type!=null)
	{ JavaModule.code("// Declare return value as attribute");
	  JavaModule.code("public "+type.toJavaType()+' '+"RESULT$;");
	  JavaModule.code("public Object RESULT$() { return(RESULT$); }");
	}
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
	
    for(VirtualSpecification virtual:virtualSpecList) {
    	if(!virtual.hasDefaultMatch) virtual.doJavaCoding();
    }
	
    for(VirtualMatch match:virtualMatchList) match.doJavaCoding();
	doCodeConstructor();
	codeClassStatements();
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
	JavaModule.code("// ClassDeclaration: BlockKind="+blockKind+", BlockLevel="+blockLevel+", PrefixLevel="+prefixLevel()
			  +", firstLine="+lineNumber+", lastLine="+lastLineNumber
			  +", hasLocalClasses="+((hasLocalClasses)?"true":"false")
	          +", System="+((isQPSystemBlock())?"true":"false")
		      +", detachUsed="+((detachUsed)?"true":"false"));
	JavaModule.code("public int prefixLevel() { return("+prefixLevel()+"); }");
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
//		  JavaModule.code("      this."+par.externalIdent+" = par$"+par.identifier+';');
		  JavaModule.code("this."+par.externalIdent+" = s"+par.externalIdent+';');	
	
    if(hasNoRealPrefix())
		  JavaModule.code("BBLK(); // Iff no prefix");

	JavaModule.code("// Declaration Code");
    JavaModule.code("TRACE_BEGIN_DCL$(\""+identifier+"\","+Global.sourceLineNumber+");");
	for(Declaration decl:declarationList) decl.doDeclarationCoding();
	switch(blockKind)
	{ case Class:
	  case PrefixedBlock: doCodeCreateClassBody(); break;
	  case Procedure: JavaModule.code("STM$();");		
	  default: // Nothing
	}
	JavaModule.code("} // End of Constructor");
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
  public void doCodeCreateClassBody()
  {	JavaModule.code("// Create Class Body");
	JavaModule.code("CODE$=new ClassBody(CODE$,this,"+prefixLevel()+") {");
	JavaModule.code("public void STM$() {");
	JavaModule.code("TRACE_BEGIN_STM$(\""+identifier+"\","+Global.sourceLineNumber+",inner);");
   	codeSTMBody();
	JavaModule.code("TRACE_END_STM$(\""+identifier+"\","+Global.sourceLineNumber+");");
    
	if(hasNoRealPrefix())
		  JavaModule.code("EBLK(); // Iff no prefix");
	else if(this.isMainModule && !(this instanceof PrefixedBlockDeclaration))
		JavaModule.code("EBLK(); // Main Module");
	JavaModule.code("}");  
	JavaModule.code("};");
  }
  
  
  // ***********************************************************************************************
  // *** Coding Utility: codeClassStatements
  // ***********************************************************************************************
  private void codeClassStatements()
  {	JavaModule.code("// Class Statements");
    String classID=this.getJavaIdentifier();
    JavaModule.code("public "+classID+" STM$() { return(("+classID+")CODE$.EXEC$()); }");
    JavaModule.code("public "+classID+" START() { START(this); return(this); }");
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
  public void print(String indent)
  { StringBuilder s=new StringBuilder(indent);
    s.append('[').append(blockLevel).append("] ");
    if(prefix!=null) s.append(prefix).append(' ');
    s.append(blockKind).append(' ').append(identifier);
    s.append('[').append(externalIdent).append("] ");
    s.append(editParameterList());
    System.out.println(s.toString());
    if(!virtualSpecList.isEmpty()) System.out.println(indent+"    VIRTUAL-SPEC"+virtualSpecList);
    if(!virtualMatchList.isEmpty()) System.out.println(indent+"    VIRTUAL-MATCH"+virtualMatchList);
    if(!hiddenList.isEmpty()) System.out.println(indent+"    HIDDEN"+hiddenList);
    if(!protectedList.isEmpty()) System.out.println(indent+"    PROTECTED"+protectedList);
	String beg="begin["+edScopeChain()+']';
	indent=indent+"    ";
    System.out.println(indent+beg); 
    for(Declaration decl:declarationList) decl.print(indent+"   ");
    for(Statement stm:statements) stm.print(indent+"   ");
	System.out.println(indent+"end["+edScopeChain()+']'); 
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
