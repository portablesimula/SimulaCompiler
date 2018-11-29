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

	public ClassDeclaration specifiedIn;  // Class containing Virtual: specification
	
	public ProcedureSpecification procedureSpec; // From: IS ProcedureSpecification
    public boolean hasDefaultMatch; // Set during doChecking

	public VirtualSpecification(ClassDeclaration specifiedIn,String identifier, Type type, ProcedureSpecification procedureSpec) {
		super(identifier);
		this.specifiedIn=specifiedIn;
	 	this.externalIdent=identifier;
		this.type=type;
		this.procedureSpec=procedureSpec;
		this.blockKind=BlockKind.Procedure;
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
		          block.virtualSpecList.add(new VirtualSpecification(block,identifier,type,procedureSpec));
		    	  //Util.BREAK("Class "+block.identifier+" VIRTUAL-LIST="+block.virtualSpecList);
	          } else {
	        	  block.virtualSpecList.add(new VirtualSpecification(block,identifier,type,null));
		    	  //Util.BREAK("Class "+block.identifier+" VIRTUAL-LIST="+block.virtualSpecList);
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
	       block.virtualSpecList.add(new VirtualSpecification(block,identifier,type,null));
	       //Util.BREAK("Class "+block.identifier+" VIRTUAL-LIST="+block.virtualSpecList);
	  } while(Parser.accept(KeyWord.COMMA));  
      Parser.expect(KeyWord.SEMICOLON);	
	}
	
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		// Util.BREAK("Virtual("+this+").doChecking - Current Scope Chain: "+currentScope.edScopeChain());
		if(procedureSpec!=null) procedureSpec.doChecking(this.declaredIn);
		SET_SEMANTICS_CHECKED();
	}

	public String getVirtualIdentifier() {
		return (getJavaIdentifier() + '$' + specifiedIn.prefixLevel());
	}

	public void doJavaCoding()
	{ //Util.BREAK("Virtual.doJavaCoding: "+identifier);
  	  ASSERT_SEMANTICS_CHECKED(this);
	  String matchCode="{ throw new RuntimeException(\"No Virtual Match\"); }";
	  JavaModule.code("public PRCQNT$ "+getVirtualIdentifier()+"() "+matchCode);
	}
	
	public String toString()
	{ StringBuilder s=new StringBuilder();
	  if(type!=null) s.append(type).append(' '); 
	  s.append("PROCEDURE ").append(identifier);
	  if(specifiedIn!=null) {
		  s.append("[Specified in ").append(specifiedIn.identifier).append(']');
	  }
	  if(procedureSpec!=null) s.append('=').append(procedureSpec);
	  return(s.toString());
	}

}
