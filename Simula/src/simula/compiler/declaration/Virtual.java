/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

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
 *   	VirtualSpecifier =  [ type ] PROCEDURE  |  LABEL  |  SWITCH
 *    	IdentifierList  =  Identifier  { , Identifier }
 *
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 *
 */
public class Virtual extends Declaration {
	// String identifier; // Inherited
	// Type type; // Inherited: Procedure's type if any
	public Virtual.Kind kind; // Simple | Procedure
	
	public ProcedureSpecification procedureSpec; // From: IS ProcedureSpecification
//    public BlockDeclaration match; // Set during coChecking
    public Declaration match; // Set during coChecking - Label or Block Declaration

    public enum Kind { Procedure, Label, Switch }

	public Virtual(String identifier, Type type, Virtual.Kind kind,ProcedureSpecification procedureSpec) {
		super(identifier);
	 	this.externalIdent=identifier;
		this.type=type;
		this.kind = kind;
		this.procedureSpec=procedureSpec;
		this.blockKind=BlockDeclaration.Kind.Procedure; // TODO: For TEST !!!
		//Util.BREAK("NEW Virtual: "+this);
		if(kind==Virtual.Kind.Label) Util.warning("Goto Virtual label "+identifier+" is not fully implemented, may result in Runtime ERROR");
	}
	
	// VirtualPart  =  VIRTUAL  :  VirtualSpec  ;  {  VirtualSpec  ;  }
	//    VirtualSpec  =  VirtualSpecifier  IdentifierList
	//                 |  PROCEDURE  ProcedureIdentifier  IS  ProcedureDeclaration
	//        
	//   	VirtualSpecifier =  [ type ] PROCEDURE  |  LABEL  |  SWITCH
	//    	IdentifierList  =  Identifier  { , Identifier }
	public static void parseInto(BlockDeclaration block)
	{ Parser.expect(KeyWord.COLON);
      LOOP:while(true) {
		  //Parser.BREAK("Virtual.parse");
		  Type type;
	      if(Parser.accept(KeyWord.SWITCH))	  parseSimpleSpecList(block,Type.Label,Virtual.Kind.Switch);
	      else if(Parser.accept(KeyWord.LABEL)) parseSimpleSpecList(block,Type.Label,Virtual.Kind.Label);
	      else {
	    	  type=acceptType();
		      //Parser.BREAK("Virtual.parse: type="+type);
	          if(!Parser.accept(KeyWord.PROCEDURE)) break LOOP;
	          Virtual.Kind kind=Virtual.Kind.Procedure;
	      
	          String identifier=expectIdentifier();
		      //Parser.BREAK("Virtual.parse: identifier="+identifier);
		      ProcedureSpecification procedureSpec=null;
	          if(Parser.accept(KeyWord.IS)) {
	        	  Type procedureType=acceptType(); Parser.expect(KeyWord.PROCEDURE);
		          //Parser.BREAK("Virtual.parse: IS procedureType="+procedureType); 
		          procedureSpec=BlockDeclaration.doParseProcedureSpecification(procedureType); 
		          //Parser.BREAK("Virtual.parse: IS procedureSpec="+procedureSpec);
		          block.virtualList.add(new Virtual(identifier,type,kind,procedureSpec));
	          } else {
	        	  block.virtualList.add(new Virtual(identifier,type,kind,null));
	    	      if(Parser.accept(KeyWord.COMMA)) parseSimpleSpecList(block,type,kind);
	    	      else Parser.expect(KeyWord.SEMICOLON);
	          }
	      }
	  }
    }
	
	private static void parseSimpleSpecList(BlockDeclaration block,Type type,Virtual.Kind kind)
	{ do { String identifier=expectIdentifier();
	       block.virtualList.add(new Virtual(identifier,type,kind,null));
	  } while(Parser.accept(KeyWord.COMMA));  
      Parser.expect(KeyWord.SEMICOLON);	
	}

	
	public Virtual(BlockDeclaration match) {
		// NOTE: Called during Checking
		this(match.identifier,match.type,Virtual.Kind.Procedure,null);
		this.match=match;
		//Util.BREAK("NEW Extra-Virtual: "+this);
		SET_SEMANTICS_CHECKED();
	}
	
	public Virtual(LabelDeclaration match) {
		// NOTE: Called during Checking
		this(match.identifier,match.type,Virtual.Kind.Label,null);
		this.match=match;
		//Util.BREAK("NEW Extra-Virtual: "+this);
		SET_SEMANTICS_CHECKED();
	}

	public void setMatch(BlockDeclaration match)
	{ this.match=match;
	  //Util.BREAK("Virtual.setMatch: "+match);
	  if(procedureSpec!=null)
	  { if(!procedureSpec.checkCompatible(match))
	    { Util.error("Virtual "+identifier+" is not compatible with Virtual Specification");
		  
	    }
	  }
	}

	public void setLabelMatch(LabelDeclaration match)
	{ this.match=match;
	  //Util.BREAK("Virtual.setMatch: Label "+match);
	}
	
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		// Util.BREAK("Virtual("+this+").doChecking - Current Scope Chain: "+currentScope.edScopeChain());
		// TODO: ??? hva checker vi ?
		if(procedureSpec!=null) procedureSpec.doChecking(this.declaredIn);
		SET_SEMANTICS_CHECKED();
	}

	public void doJavaCoding(int indent)
	{ //Util.BREAK("Virtual.doJavaCoding: "+identifier);
  	  ASSERT_SEMANTICS_CHECKED(this);
	  String quantity=(kind==Kind.Label)?"$LABQNT ":"$PRCQNT ";
	  String matchCode="{ throw new RuntimeException(\"No Virtual Match\"); }";
	  if(match!=null)
	  { if(kind==Kind.Label)
	    { // public $LABQNT L() { return(new $LABQNT(this,prefixLevel,index); // Local Label #1=L
		  LabelDeclaration label=(LabelDeclaration)match;
		  matchCode="{ return(new $LABQNT(this,"+label.prefixLevel+','+label.index+")); } // Local Label #"+label.index+'='+label.identifier;
		  
	    } else
	    { // public $PRCQNT P() { return(new $PRCQNT(this,VirtualSample$SubBlock9$P.class)); }
		  matchCode="{ return(new $PRCQNT(this,"+match.getJavaIdentifier()+".class)); }";
	    }
	  }
  	  
	  Util.code(indent,"public "+quantity+getJavaIdentifier()+"() "+matchCode);
	}
	
	public String toString()
	{ String s="";
	  if(type!=null) s=s+type; else s="NOTYPE";
	  s=s+" "+kind+' '+identifier;
	  if(procedureSpec!=null) s=s+'='+procedureSpec;
	  return(s);
	}

}
