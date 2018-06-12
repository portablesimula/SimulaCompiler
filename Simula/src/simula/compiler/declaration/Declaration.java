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
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Declaration.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 * Declaration = TypeDeclaration | ArrayDeclaration | SwitchDeclaration
 *             | ProcedureDeclaration | ClassDeclaration | ExternalDeclaration
 *             
 *		TypeDeclaration = Type IdentifierList
 *
 *   	Type ::= BOOLEAN | CHARACTER | INTEGER | REAL | REF(ClassIdentifier) | TEXT
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public class Declaration extends SyntaxClass
{ public String identifier; // Simula Identifier from Source Text
  public String externalIdent; // External Identifier set by doChecking
  public DeclarationScope declaredIn;  // The DeclarationScope in which this Declaration is defined.
  public BlockDeclaration.Kind blockKind;

  public final String getJavaIdentifier() { return(this.externalIdent); }  // May be redefined

  public void modifyIdentifier(String newIdentifier)
  { //Util.BREAK("Declaration.modifyIdentifier: "+identifier+" ==> "+newIdentifier);
	this.identifier=newIdentifier;
    checkAlreadyDefined();
  }
    
  // ***********************************************************************************************
  // *** Constructor
  // ***********************************************************************************************
  public Declaration(String identifier)
  { this.identifier=identifier;
    this.externalIdent=identifier; // May be overwritten in doChecking()
    declaredIn=Global.currentScope;
    checkAlreadyDefined();
  }
  
  private void checkAlreadyDefined()
  { boolean illegal=false;
    if(identifier==null) return;
    if(declaredIn==null) return;
    if(declaredIn instanceof StandardClass) return;
    if(declaredIn instanceof StandardProcedure) return;
    for(Declaration decl:declaredIn.parameterList)
    	if(decl.identifier.equalsIgnoreCase(identifier)) { illegal=true; break;}
    for(Declaration decl:declaredIn.declarationList)
    	if(decl.identifier.equalsIgnoreCase(identifier)) { illegal=true; break;}
    if(illegal) Util.error(identifier+" is alrerady defined in "+declaredIn);
  }
  
  public static boolean parseDeclaration(Vector<Declaration> declarationList)
  { if(Option.TRACE_PARSE) Parser.TRACE("Parse Declaration");
    String prefix=acceptIdentifier();
    if(prefix!=null)
    { if(Parser.accept(KeyWord.CLASS)) declarationList.add(BlockDeclaration.doParseClassDeclaration(prefix)); 
      else
      { Parser.saveCurrentToken(); // Identifier is NOT a class prefix.
        return(false);
      }
    }  
    else if(Parser.accept(KeyWord.ARRAY)) ArrayDeclaration.parse(Type.Real,declarationList);  // Default type real for arrays
    else if(Parser.accept(KeyWord.PROCEDURE)) declarationList.add(BlockDeclaration.doParseProcedureDeclaration(null));
    else if(Parser.accept(KeyWord.CLASS)) declarationList.add(BlockDeclaration.doParseClassDeclaration(null));
    else if(Parser.accept(KeyWord.SWITCH)) declarationList.add(new SwitchDeclaration());
//    else if(Parser.accept(KeyWord.EXTERNAL)) declarationList.add(ExternalDeclaration.doParse());
    else if(Parser.accept(KeyWord.EXTERNAL)) ExternalDeclaration.doParse(declarationList);
    else
    { Type type=acceptType(); if(type==null) return(false);
      TypeDeclaration.parse(type,declarationList);
      if(Option.TRACE_PARSE) Parser.TRACE("Parse Declaration(2)");
    }
    return(true);
  }
  
  // ***********************************************************************************************
  // *** Utility: isCompatibleClasses -- Used by IS/IN/QUA-checking and Inspect WHEN
  // ***********************************************************************************************
  public boolean isCompatibleClasses(Declaration other)
  { if (!(this instanceof BlockDeclaration)) Util.error(""+ this + " is not a class");
	if (!(other instanceof BlockDeclaration)) Util.error("" + other + " is not a class");
	  
	if(((BlockDeclaration)this).isSubClassOf((BlockDeclaration)other)) return(true);
	return(((BlockDeclaration)other).isSubClassOf((BlockDeclaration)this));
  }


}
