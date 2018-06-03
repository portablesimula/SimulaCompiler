/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import simula.compiler.utilities.BlockKind;
import simula.compiler.utilities.ParameterKind;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

public class Virtual extends Declaration {
	// String identifier; // Inherited
	// Type type; // Inherited: Procedure's type if any
	public ParameterKind kind; // Simple | Procedure
    public BlockDeclaration match; // Set during coChecking

	public Virtual(String identifier, Type type, ParameterKind kind) {
		super(identifier);
		this.type=type;
		this.kind = kind;
		this.blockKind=BlockKind.Procedure; // TODO: For TEST !!!
		Util.BREAK("NEW Virtual: "+this);
	}

	public Virtual(BlockDeclaration match) {
		// NOTE: Called during Checking
		this(match.identifier,match.type,ParameterKind.Procedure);
		this.match=match;
		Util.BREAK("NEW Extra-Virtual: "+this);
		SET_SEMANTICS_CHECKED();
	}

	public void setMatch(BlockDeclaration match)
	{ this.match=match;	}
	
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Util.setLine(lineNumber);
		// Util.BREAK("Virtual("+this+").doChecking - Current Scope Chain: "+currentScope.edScopeChain());
		// TODO: ??? hva checker vi ?
		SET_SEMANTICS_CHECKED();
	}

	public void doJavaCoding(String indent)
	{ Util.BREAK("Virtual.doJavaCoding: "+identifier);
  	  ASSERT_SEMANTICS_CHECKED(this);
  	  // public $PRCQNT P() { return(new $PRCQNT(this,VirtualSample$SubBlock9$P.class)); }
	  String quantity=(type==Type.Label)?"$LABQNT ":"$PRCQNT ";
	  String matchCode="{ throw new RuntimeException(\"No Virtual Match\"); }";
	  if(match!=null) matchCode="{ return(new $PRCQNT(this,"+match.getJavaIdentifier()+".class)); }";
	  Util.code(indent+"public "+quantity+getJavaIdentifier()+"() "+matchCode);
	}
	
	public String toString()
	{ String s="";
	  if(type!=null) s=s+type; else s="NOTYPE";
	  if(kind==null) s=s+" NOKIND";
	  else if(kind!=ParameterKind.Simple) s=s+" "+kind;
	  return(s+' '+identifier);
	}

}
