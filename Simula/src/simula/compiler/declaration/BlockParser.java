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

import simula.compiler.SyntaxClass;
import simula.compiler.parsing.Parser;
import simula.compiler.statement.InnerStatement;
import simula.compiler.statement.Statement;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.ParameterKind;
import simula.compiler.utilities.ParameterMode;
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
 * @author Øystein Myhre Andersen
 */
public abstract class BlockParser extends SyntaxClass
{ 
//  public BlockParser() { }
 
  public static void doParse(BlockDeclaration block,boolean inClass)
  { block.modifyIdentifier(expectIdentifier());
	//Util.BREAK("BEGIN BlockParser: "+block);
    //if(Option.TRACE_PARSE) Parser.BREAK("Begin BlockParser");
	if(Parser.accept(KeyWord.BEGPAR))
	{ if(Parser.accept(KeyWord.ENDPAR)) { Parser.expect(KeyWord.ENDPAR); return; }
	  do //ParameterPart = Parameter ; { Parameter ; }
	  { block.parameterList.add(new Parameter(expectIdentifier()));
	  } while(Parser.accept(KeyWord.COMMA));  
	  Parser.expect(KeyWord.ENDPAR); Parser.expect(KeyWord.SEMICOLON);
	  // ModePart = ValuePart [ NamePart ] | NamePart [ ValuePart ]
	  //   ValuePart = VALUE IdentifierList ;
	  //   NamePart  = NAME  IdentifierList ;
      if(Parser.accept(KeyWord.VALUE)) { expectModeList(block,ParameterMode.value); Parser.expect(KeyWord.SEMICOLON); }
      if(!inClass) // Parameter by NAME is not defined for Classes
      { if(Parser.accept(KeyWord.NAME))  { expectModeList(block,ParameterMode.name); Parser.expect(KeyWord.SEMICOLON); }
        if(Parser.accept(KeyWord.VALUE)) { expectModeList(block,ParameterMode.value); Parser.expect(KeyWord.SEMICOLON); }
      }
      // ParameterPart = Parameter ; { Parameter ; }
      //	Parameter = Specifier IdentifierList
      //		Specifier = Type [ ARRAY | PROCEDURE ] | LABEL | SWITCH
      while(acceptParameterSpecifications(block)) { Parser.expect(KeyWord.SEMICOLON); } 
    } else Parser.expect(KeyWord.SEMICOLON);
	  
    if(inClass) // HIDDEN, PROTECTED and VIRTUAL is not defined for Procedures
    { // ProtectionPart = ProtectionParameter { ; ProtectionParameter }
      //	ProtectionParameter = HIDDEN IdentifierList | HIDDEN PROTECTED IdentifierList
      //							| PROTECTED IdentifierList | PROTECTED HIDDEN IdentifierList
      while(true)
      { if(Parser.accept(KeyWord.HIDDEN))
        { if(Parser.accept(KeyWord.PROTECTED)) expectHiddenProtectedList(block,true,true);
          expectHiddenProtectedList(block,true,false);
        }
        else if(Parser.accept(KeyWord.PROTECTED))
        { if(Parser.accept(KeyWord.HIDDEN)) expectHiddenProtectedList(block,true,true);
          expectHiddenProtectedList(block,false,true);
        }
        else break;
      }
      // VirtualPart = VIRTUAL: virtual-specification-part
      //	VirtualParameterPart = VirtualParameter ; { VirtualParameter ; }
      //		VirtualParameter = VirtualSpecifier IdentifierList
      //			VirtualSpecifier = [ type ] PROCEDURE | LABEL | SWITCH
      if(Parser.accept(KeyWord.VIRTUAL))
      { Parser.expect(KeyWord.COLON);
        // VirtualParameterPart
    	//     = VirtualParameter ; { VirtualParameter ; }
        while(acceptVirtualSpecifications(block)) { Parser.expect(KeyWord.SEMICOLON); } 
      }
    }
    
    if(Parser.accept(KeyWord.BEGIN)) doParseBody(block,inClass);
    else
    { block.setStatement(Statement.doParse());
      if(inClass) block.statements.add(new InnerStatement()); // Implicit INNER
    }
  }
  
  private static void doParseBody(BlockDeclaration block,boolean inClass)
  { Statement stm;
	//Debug.BREAK("BEGIN Block: "+this.edScopeChain());
    if(Option.TRACE_PARSE) Parser.TRACE("Parse Block");
    while(Declaration.parseDeclaration(block.declarationList))
//    { Parser.expect(KeyWord.SEMICOLON); }
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

  private static void expectModeList(BlockDeclaration block,ParameterMode mode)
  { do
	{ String identifier=expectIdentifier();
	  Parameter parameter=null;
      for(Parameter par:block.parameterList)
           if(identifier.equalsIgnoreCase(par.identifier)) { parameter=par; break; }
	  if(parameter==null)
	  { Util.error("Identifier "+identifier+" is not defined in this scope");
	    parameter=new Parameter(identifier);
	  }
	  parameter.setMode(mode);
	} while(Parser.accept(KeyWord.COMMA));  
  }
  
  private static boolean acceptParameterSpecifications(BlockDeclaration block)
  { // Parameter = Specifier IdentifierList
	// Specifier = Type [ ARRAY | PROCEDURE ] | LABEL | SWITCH
	if(Option.TRACE_PARSE) Parser.TRACE("Parse ParameterSpecifications");
	Type type;
	ParameterKind kind=ParameterKind.Simple;
    if(Parser.accept(KeyWord.SWITCH))  type=Type.LabelQuantity; 
    else if(Parser.accept(KeyWord.LABEL)) type=Type.LabelQuantity; 
    else if(Parser.accept(KeyWord.PROCEDURE)) { type=null; kind=ParameterKind.Procedure; }
    else
    { type=acceptType(); if(type==null) return(false);    	
      if(Parser.accept(KeyWord.ARRAY)) kind=ParameterKind.Array; 
      else if(Parser.accept(KeyWord.PROCEDURE)) kind=ParameterKind.Procedure;
    }
    do
    { String identifier=expectIdentifier();
//	  Parameter parameter=(Parameter)block.parameterList.lookup(identifier);
	  Parameter parameter=null;
      for(Parameter par:block.parameterList)
           if(identifier.equalsIgnoreCase(par.identifier)) { parameter=par; break; }
	  if(parameter==null)
	  { Util.error("Identifier "+identifier+" is not defined in this scope");
	    parameter=new Parameter(identifier);
	  }
	  parameter.setTypeAndKind(type,kind);
    } while(Parser.accept(KeyWord.COMMA));  
    return(true);
  }
  
  private static boolean expectHiddenProtectedList(BlockDeclaration block,boolean hidden,boolean prtected)
  { //Util.BREAK("BlockParser.expectHiddenProtectedList: Hidden="+hidden+", Protected="+prtected);
    do
    { String identifier=expectIdentifier();
      if(hidden) block.hiddenList.add(identifier);
      if(prtected) block.protectedList.add(identifier);
    } while(Parser.accept(KeyWord.COMMA));  
    //Util.BREAK("BlockParser.expectHiddenProtectedList: HiddenList="+block.hiddenList);
    //Util.BREAK("BlockParser.expectHiddenProtectedList: ProtectedList="+block.protectedList);
    Parser.expect(KeyWord.SEMICOLON); 
    return(true);
  }

  private static boolean acceptVirtualSpecifications(BlockDeclaration block)
  {	// VirtualParameter = VirtualSpecifier IdentifierList
	// VirtualSpecifier = [ Type ] PROCEDURE | LABEL | SWITCH
	//Parser.BREAK("BlockParser.acceptVirtualSpecifications");
	Type type;
	ParameterKind kind=ParameterKind.Simple;
    if(Parser.accept(KeyWord.SWITCH))  type=Type.LabelQuantity; 
    else if(Parser.accept(KeyWord.LABEL)) type=Type.LabelQuantity; 
    else
    { type=acceptType();
      if(Parser.accept(KeyWord.PROCEDURE)) kind=ParameterKind.Procedure;
      else return(false);
    }
    do
    { String identifier=expectIdentifier();
      block.virtualList.add(new Virtual(identifier,type,kind));
    } while(Parser.accept(KeyWord.COMMA));  
    
    return(true);
  }

  public void doChecking(BlockDeclaration block)
  { if(IS_SEMANTICS_CHECKED()) return;
    Global.currentScope=block;
    for(Iterator<Parameter> it=block.parameterIterator();it.hasNext();)
    { Parameter parameter=(Parameter)it.next();
      parameter.doChecking();
      if(parameter.type==null && parameter.kind!=ParameterKind.Procedure)
    	  Util.error("Missing specification of parameter: "+parameter.identifier);
    }
    SET_SEMANTICS_CHECKED();
  }

}

