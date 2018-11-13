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
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Virtual Quantities.
 * <pre>
 *    VirtualPart  =  VIRTUAL  :  VirtualSpec  ;  {  VirtualSpec  ;  }
 *    VirtualSpec  =  VirtualSpecifier  IdentifierList
 *        |  PROCEDURE  ProcedureIdentifier  IS  ProcedureDeclaration
 *        
 *   	VirtualSpecifier =  [ type ] PROCEDURE
 *    	IdentifierList  =  Identifier  { , Identifier }
 *
 * </pre>
 * NOTE: Virtual labels and switches are not part of this implementation of Simula Standard.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class VirtualSpecification extends Declaration {
	// String identifier; // Inherited
	// Type type; // Inherited: Procedure's type if any
	public ProcedureSpecification procedureSpec; // From: IS ProcedureSpecification
    public ProcedureDeclaration match; // Set during doChecking

	public VirtualSpecification(String identifier, Type type, ProcedureSpecification procedureSpec) {
		super(identifier);
	 	this.externalIdent=identifier;
		this.type=type;
		this.procedureSpec=procedureSpec;
		this.blockKind=BlockKind.Procedure;
		//Util.BREAK("NEW Virtual: "+this);
	}
	
	public static void parseInto(ClassDeclaration block)
	{ Parser.expect(KeyWord.COLON);
      LOOP:while(true) {
		  //Parser.BREAK("Virtual.parse");
		  Type type;
	      if(Parser.accept(KeyWord.SWITCH)) {
	    	  Util.error("Virtual Switch is not part of this Implementation");
	    	  skipSimpleSpecList();
	      }
	      else if(Parser.accept(KeyWord.LABEL)) {
	    	  Util.error("Virtual Label is not part of this Implementation");
	    	  skipSimpleSpecList();
	      }
	      else {
	    	  type=acceptType();
		      //Parser.BREAK("Virtual.parse: type="+type);
	          if(!Parser.accept(KeyWord.PROCEDURE)) break LOOP;
	      
	          String identifier=expectIdentifier();
		      //Parser.BREAK("Virtual.parse: identifier="+identifier);
		      ProcedureSpecification procedureSpec=null;
	          if(Parser.accept(KeyWord.IS)) {
	        	  Type procedureType=acceptType(); Parser.expect(KeyWord.PROCEDURE);
		          //Parser.BREAK("Virtual.parse: IS procedureType="+procedureType); 
		          procedureSpec=ProcedureSpecification.doParseProcedureSpecification(procedureType); 
		          //Parser.BREAK("Virtual.parse: IS procedureSpec="+procedureSpec);
		          block.virtualList.add(new VirtualSpecification(identifier,type,procedureSpec));
	          } else {
	        	  block.virtualList.add(new VirtualSpecification(identifier,type,null));
	    	      if(Parser.accept(KeyWord.COMMA)) parseSimpleSpecList(block,type);
	    	      else Parser.expect(KeyWord.SEMICOLON);
	          }
	      }
	  }
    }
	
	private static void skipSimpleSpecList()
	{ do { expectIdentifier(); } while(Parser.accept(KeyWord.COMMA));  
      Parser.expect(KeyWord.SEMICOLON);	
	}
	
	private static void parseSimpleSpecList(ClassDeclaration block,Type type)
	{ do { String identifier=expectIdentifier();
	       block.virtualList.add(new VirtualSpecification(identifier,type,null));
	  } while(Parser.accept(KeyWord.COMMA));  
      Parser.expect(KeyWord.SEMICOLON);	
	}

	
	public VirtualSpecification(ProcedureDeclaration match) {
		// NOTE: Called during Checking
		this(match.identifier,match.type,null);
		this.match=match;
		//Util.BREAK("NEW Extra-Virtual: "+this);
		SET_SEMANTICS_CHECKED();
	}

	public void setMatch(ProcedureDeclaration match)
	{ this.match=match;
	  //Util.BREAK("Virtual.setMatch: "+match);
	  if(procedureSpec!=null)
	  { if(!procedureSpec.checkCompatible(match))
	    { Util.error("Virtual "+identifier+" is not compatible with Virtual Specification");
		  
	    }
	  }
	}
	
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		// Util.BREAK("Virtual("+this+").doChecking - Current Scope Chain: "+currentScope.edScopeChain());
		if(procedureSpec!=null) procedureSpec.doChecking(this.declaredIn);
		SET_SEMANTICS_CHECKED();
	}

	public void doJavaCoding()
	{ //Util.BREAK("Virtual.doJavaCoding: "+identifier);
  	  ASSERT_SEMANTICS_CHECKED(this);
	  String matchCode="{ throw new RuntimeException(\"No Virtual Match\"); }";
	  if(match!=null)
		  matchCode="{ return(new PRCQNT$(this,"+match.getJavaIdentifier()+".class)); }";
	  JavaModule.code("public PRCQNT$ "+getJavaIdentifier()+"() "+matchCode);
	}
	
	public String toString()
	{ String s="";
	  if(type!=null) s=s+type; else s="NOTYPE";
	  s=s+" "+' '+identifier;
	  if(procedureSpec!=null) s=s+'='+procedureSpec;
	  return(s);
	}

}
