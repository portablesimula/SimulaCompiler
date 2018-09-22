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
 *   	VirtualSpecifier =  [ type ] PROCEDURE  |  LABEL  |  SWITCH
 *    	IdentifierList  =  Identifier  { , Identifier }
 *
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class VirtualSpecification extends Declaration {
	// String identifier; // Inherited
	// Type type; // Inherited: Procedure's type if any
	public VirtualSpecification.Kind kind; // Simple | Procedure
	
	public ProcedureSpecification procedureSpec; // From: IS ProcedureSpecification
//    public BlockDeclaration match; // Set during coChecking
    public Declaration match; // Set during coChecking - Label or Block Declaration

    public enum Kind { Procedure, Label, Switch }

	public VirtualSpecification(String identifier, Type type, VirtualSpecification.Kind kind,ProcedureSpecification procedureSpec) {
		super(identifier);
	 	this.externalIdent=identifier;
		this.type=type;
		this.kind = kind;
		this.procedureSpec=procedureSpec;
		this.blockKind=BlockKind.Procedure; // TODO: For TEST !!!
		//Util.BREAK("NEW Virtual: "+this);
		if(kind==VirtualSpecification.Kind.Label) Util.warning("Goto Virtual label "+identifier+" is not fully implemented, may result in Runtime ERROR");
	}
	
	// VirtualPart  =  VIRTUAL  :  VirtualSpec  ;  {  VirtualSpec  ;  }
	//    VirtualSpec  =  VirtualSpecifier  IdentifierList
	//                 |  PROCEDURE  ProcedureIdentifier  IS  ProcedureDeclaration
	//        
	//   	VirtualSpecifier =  [ type ] PROCEDURE  |  LABEL  |  SWITCH
	//    	IdentifierList  =  Identifier  { , Identifier }
	public static void parseInto(ClassDeclaration block)
	{ Parser.expect(KeyWord.COLON);
      LOOP:while(true) {
		  //Parser.BREAK("Virtual.parse");
		  Type type;
	      if(Parser.accept(KeyWord.SWITCH))	  parseSimpleSpecList(block,Type.Label,VirtualSpecification.Kind.Switch);
	      else if(Parser.accept(KeyWord.LABEL)) parseSimpleSpecList(block,Type.Label,VirtualSpecification.Kind.Label);
	      else {
	    	  type=acceptType();
		      //Parser.BREAK("Virtual.parse: type="+type);
	          if(!Parser.accept(KeyWord.PROCEDURE)) break LOOP;
	          VirtualSpecification.Kind kind=VirtualSpecification.Kind.Procedure;
	      
	          String identifier=expectIdentifier();
		      //Parser.BREAK("Virtual.parse: identifier="+identifier);
		      ProcedureSpecification procedureSpec=null;
	          if(Parser.accept(KeyWord.IS)) {
	        	  Type procedureType=acceptType(); Parser.expect(KeyWord.PROCEDURE);
		          //Parser.BREAK("Virtual.parse: IS procedureType="+procedureType); 
		          procedureSpec=ProcedureSpecification.doParseProcedureSpecification(procedureType); 
		          //Parser.BREAK("Virtual.parse: IS procedureSpec="+procedureSpec);
		          block.virtualList.add(new VirtualSpecification(identifier,type,kind,procedureSpec));
	          } else {
	        	  block.virtualList.add(new VirtualSpecification(identifier,type,kind,null));
	    	      if(Parser.accept(KeyWord.COMMA)) parseSimpleSpecList(block,type,kind);
	    	      else Parser.expect(KeyWord.SEMICOLON);
	          }
	      }
	  }
    }
	
	private static void parseSimpleSpecList(ClassDeclaration block,Type type,VirtualSpecification.Kind kind)
	{ do { String identifier=expectIdentifier();
	       block.virtualList.add(new VirtualSpecification(identifier,type,kind,null));
	  } while(Parser.accept(KeyWord.COMMA));  
      Parser.expect(KeyWord.SEMICOLON);	
	}

	
	public VirtualSpecification(ProcedureDeclaration match) {
		// NOTE: Called during Checking
		this(match.identifier,match.type,VirtualSpecification.Kind.Procedure,null);
		this.match=match;
		//Util.BREAK("NEW Extra-Virtual: "+this);
		SET_SEMANTICS_CHECKED();
	}
	
	public VirtualSpecification(LabelDeclaration match) {
		// NOTE: Called during Checking
		this(match.identifier,match.type,VirtualSpecification.Kind.Label,null);
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

	public void setLabelMatch(LabelDeclaration match)
	{ this.match=match;
	  //Util.BREAK("Virtual.setMatch: Label "+match);
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
	  String quantity=(kind==Kind.Label)?"LABQNT$ ":"PRCQNT$ ";
	  String matchCode="{ throw new RuntimeException(\"No Virtual Match\"); }";
	  if(match!=null)
	  { if(kind==Kind.Label)
	    { // public LABQNT$ L() { return(new LABQNT$(this,prefixLevel,index); // Local Label #1=L
		  LabelDeclaration label=(LabelDeclaration)match;
		  matchCode="{ return(new LABQNT$(this,"+label.prefixLevel+','+label.index+")); } // Local Label #"+label.index+'='+label.identifier;
		  
	    } else
	    { // public PRCQNT$ P() { return(new PRCQNT$(this,VirtualSample$SubBlock9$P.class)); }
		  matchCode="{ return(new PRCQNT$(this,"+match.getJavaIdentifier()+".class)); }";
	    }
	  }
	  JavaModule.code("public "+quantity+getJavaIdentifier()+"() "+matchCode);
	}
	
	public String toString()
	{ String s="";
	  if(type!=null) s=s+type; else s="NOTYPE";
	  s=s+" "+kind+' '+identifier;
	  if(procedureSpec!=null) s=s+'='+procedureSpec;
	  return(s);
	}

}
