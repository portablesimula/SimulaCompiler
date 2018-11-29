/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import java.util.Vector;

import simula.compiler.SyntaxClass;
import simula.compiler.parsing.Parser;
import simula.compiler.statement.InnerStatement;
import simula.compiler.statement.Statement;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Common Parser for Class and Procedure Declarations.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 * ProcedureHead = [ FormalParameterPart ; [ ModePart ] ParameterPart  ] ;
 *
 * ClassHead = [ FormalParameterPart ; [ ValuePart ] ParameterPart ] ;
 *			 [ ProtectionPart ; ] [ VirtualPart ]
 *
 *	FormalParameterPart = "(" FormalParameter { , FormalParameter } ")"
 *		FormalParameter = Identifier
 *	
 *	ModePart = ValuePart [ NamePart ] | NamePart [ ValuePart ]
 *		ValuePart = VALUE IdentifierList ;
 *		NamePart  = NAME  IdentifierList ;
 *	
 *	ParameterPart = Parameter ; { Parameter ; }
 *		Parameter = Specifier IdentifierList
 *			Specifier = Type [ ARRAY | PROCEDURE ] | LABEL | SWITCH
 *
 *	ProtectionPart = ProtectionParameter { ; ProtectionParameter }
 *		ProtectionParameter = HIDDEN IdentifierList | HIDDEN PROTECTED IdentifierList
 *								| PROTECTED IdentifierList | PROTECTED HIDDEN IdentifierList
 *
 *	VirtualPart = VIRTUAL: virtual-specification-part
 *		VirtualParameterPart = VirtualParameter ; { VirtualParameter ; }
 *			VirtualParameter = VirtualSpecifier IdentifierList
 *				VirtualSpecifier = [ type ] PROCEDURE | LABEL | SWITCH
 * </pre>
 * 
 * NOTE: Virtual labels and switches are not part of this implementation of Simula Standard.
 * 
 * @author Øystein Myhre Andersen
 */
public abstract class BlockParser extends SyntaxClass
{ 
//  public BlockParser() { }
	 
  public static void doParse(ClassDeclaration block)
  { doParseClassDeclaration(block); }
  
  private static void doParseClassDeclaration(ClassDeclaration block)
  { block.modifyIdentifier(expectIdentifier());
	//Util.BREAK("BEGIN BlockParser: "+block);
    //if(Option.TRACE_PARSE) Parser.BREAK("Begin BlockParser");
	if(Parser.accept(KeyWord.BEGPAR))
	{ if(Parser.accept(KeyWord.ENDPAR)) { Parser.expect(KeyWord.ENDPAR); return; }
	  do //ParameterPart = Parameter ; { Parameter ; }
	  { block.addParameter(new Parameter(expectIdentifier()));
	  } while(Parser.accept(KeyWord.COMMA));  
	  Parser.expect(KeyWord.ENDPAR); Parser.expect(KeyWord.SEMICOLON);
	  // ModePart = ValuePart [ NamePart ] | NamePart [ ValuePart ]
	  //   ValuePart = VALUE IdentifierList ;
	  //   NamePart  = NAME  IdentifierList ;
      if(Parser.accept(KeyWord.VALUE)) { expectModeList(block,block.parameterList,Parameter.Mode.value); Parser.expect(KeyWord.SEMICOLON); }
      // ParameterPart = Parameter ; { Parameter ; }
      //	Parameter = Specifier IdentifierList
      //		Specifier = Type [ ARRAY | PROCEDURE ] | LABEL | SWITCH
      while(acceptParameterSpecifications(block,block.parameterList)) { Parser.expect(KeyWord.SEMICOLON); } 
    } else Parser.expect(KeyWord.SEMICOLON);
	  
    ClassDeclaration cls=(ClassDeclaration)block;
    // ProtectionPart = ProtectionParameter { ; ProtectionParameter }
    //	ProtectionParameter = HIDDEN IdentifierList | HIDDEN PROTECTED IdentifierList
    //							| PROTECTED IdentifierList | PROTECTED HIDDEN IdentifierList
    while(true)
    { if(Parser.accept(KeyWord.HIDDEN))
      { if(Parser.accept(KeyWord.PROTECTED)) expectHiddenProtectedList(cls,true,true);
        else expectHiddenProtectedList(cls,true,false);
      }
      else if(Parser.accept(KeyWord.PROTECTED))
      { if(Parser.accept(KeyWord.HIDDEN)) expectHiddenProtectedList(cls,true,true);
        else expectHiddenProtectedList(cls,false,true);
      }
      else break;
    }
    if(block instanceof ClassDeclaration)
    { // VirtualPart = VIRTUAL: virtual-specification-part
      //	VirtualParameterPart = VirtualParameter ; { VirtualParameter ; }
      //		VirtualParameter = VirtualSpecifier IdentifierList
      //			VirtualSpecifier = [ type ] PROCEDURE | LABEL | SWITCH
      if(Parser.accept(KeyWord.VIRTUAL)) VirtualSpecification.parseInto((ClassDeclaration)block);
    }
    
    if(Parser.accept(KeyWord.BEGIN)) doParseBody(block,true);
    else
    { block.statements.add(Statement.doParse());  
      block.statements.add(new InnerStatement()); // Implicit INNER
    }
  }
 
	 
  public static void doParse(ProcedureDeclaration block)
  { doParseProcedureDeclaration(block); }
  
  private static void doParseProcedureDeclaration(ProcedureDeclaration block)
  { block.modifyIdentifier(expectIdentifier());
	//Util.BREAK("BEGIN BlockParser: "+block);
    //if(Option.TRACE_PARSE) Parser.BREAK("Begin BlockParser");
	if(Parser.accept(KeyWord.BEGPAR))
	{ if(Parser.accept(KeyWord.ENDPAR)) { Parser.expect(KeyWord.ENDPAR); return; }
	  do //ParameterPart = Parameter ; { Parameter ; }
	  { block.addParameter(new Parameter(expectIdentifier()));
	  } while(Parser.accept(KeyWord.COMMA));  
	  Parser.expect(KeyWord.ENDPAR); Parser.expect(KeyWord.SEMICOLON);
	  // ModePart = ValuePart [ NamePart ] | NamePart [ ValuePart ]
	  //   ValuePart = VALUE IdentifierList ;
	  //   NamePart  = NAME  IdentifierList ;
      if(Parser.accept(KeyWord.VALUE)) { expectModeList(block,block.parameterList,Parameter.Mode.value); Parser.expect(KeyWord.SEMICOLON); }
      if(Parser.accept(KeyWord.NAME))  { expectModeList(block,block.parameterList,Parameter.Mode.name); Parser.expect(KeyWord.SEMICOLON); }
      if(Parser.accept(KeyWord.VALUE)) { expectModeList(block,block.parameterList,Parameter.Mode.value); Parser.expect(KeyWord.SEMICOLON); }
      // ParameterPart = Parameter ; { Parameter ; }
      //	Parameter = Specifier IdentifierList
      //		Specifier = Type [ ARRAY | PROCEDURE ] | LABEL | SWITCH
      while(acceptParameterSpecifications(block,block.parameterList)) { Parser.expect(KeyWord.SEMICOLON); } 
    } else Parser.expect(KeyWord.SEMICOLON);
    
    if(Parser.accept(KeyWord.BEGIN)) doParseBody(block,false);
    else block.statements.add(Statement.doParse());  
  }
  
  private static void doParseBody(BlockDeclaration block,boolean inClass)
  { Statement stm;
	//Debug.BREAK("BEGIN Block: "+this.edScopeChain());
    if(Option.TRACE_PARSE) Parser.TRACE("Parse Block");
    while(Declaration.parseDeclaration(block.declarationList))
    { Parser.accept(KeyWord.SEMICOLON); }
    
    Statement inner=new InnerStatement();
    Vector<Statement> stmList=block.statements;
    while(!Parser.accept(KeyWord.END))
    { stm=Statement.doParse(); if(stm!=null) stmList.add(stm);
      if(Parser.accept(KeyWord.INNER))
      { if(inner==null) Util.error("Max one INNER per Block");
      else stmList.add(inner); inner=null;
      }
    }
    if(inClass && inner!=null) stmList.add(inner); // Implicit INNER
  }

  private static void expectModeList(BlockDeclaration block,Vector<Parameter> parameterList,Parameter.Mode mode)
  { do
	{ String identifier=expectIdentifier();
	  Parameter parameter=null;
      for(Parameter par:parameterList)
           if(identifier.equalsIgnoreCase(par.identifier)) { parameter=par; break; }
	  if(parameter==null)
	  { Util.error("Identifier "+identifier+" is not defined in this scope");
	    parameter=new Parameter(identifier);
	  }
	  parameter.setMode(mode);
	} while(Parser.accept(KeyWord.COMMA));  
  }
  
  private static boolean acceptParameterSpecifications(BlockDeclaration block,Vector<Parameter> parameterList)
  { // Parameter = Specifier IdentifierList
	// Specifier = Type [ ARRAY | PROCEDURE ] | LABEL | SWITCH
	if(Option.TRACE_PARSE) Parser.TRACE("Parse ParameterSpecifications");
	Type type;
	Parameter.Kind kind=Parameter.Kind.Simple;
    if(Parser.accept(KeyWord.SWITCH)) { type=Type.Label; kind=Parameter.Kind.Procedure; } 
    else if(Parser.accept(KeyWord.LABEL)) type=Type.Label; 
    else if(Parser.accept(KeyWord.PROCEDURE)) { type=null; kind=Parameter.Kind.Procedure; }
    else
    { type=acceptType(); if(type==null) return(false);    	
      if(Parser.accept(KeyWord.ARRAY)) kind=Parameter.Kind.Array; 
      else if(Parser.accept(KeyWord.PROCEDURE)) kind=Parameter.Kind.Procedure;
    }
    do
    { String identifier=expectIdentifier();
	  Parameter parameter=null;
      for(Parameter par:parameterList)
           if(identifier.equalsIgnoreCase(par.identifier)) { parameter=par; break; }
	  if(parameter==null)
	  { Util.error("Identifier "+identifier+" is not defined in this scope");
	    parameter=new Parameter(identifier);
	  }
	  parameter.setTypeAndKind(type,kind);
    } while(Parser.accept(KeyWord.COMMA));  
    return(true);
  }
  
  private static boolean expectHiddenProtectedList(ClassDeclaration block,boolean hidden,boolean prtected)
  { //Util.BREAK("BlockParser.expectHiddenProtectedList: Hidden="+hidden+", Protected="+prtected);
    do
    { String identifier=expectIdentifier();
      if(hidden) block.hiddenList.add(new HiddenSpecification(block,identifier));
      if(prtected) {
    	  block.protectedList.add(new ProtectedSpecification(block,identifier));
    	  //Util.BREAK("Class "+block.identifier+" PROTECTED-LIST="+block.protectedList);
      }
    } while(Parser.accept(KeyWord.COMMA));  
    //Util.BREAK("BlockParser.expectHiddenProtectedList: HiddenList="+block.hiddenList);
    //Util.BREAK("BlockParser.expectHiddenProtectedList: ProtectedList="+block.protectedList);
    Parser.expect(KeyWord.SEMICOLON); 
    return(true);
  }

}

