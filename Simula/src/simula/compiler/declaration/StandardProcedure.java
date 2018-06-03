/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import simula.compiler.utilities.BlockKind;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

public class StandardProcedure extends BlockDeclaration// ProcedureDeclaration
{ public boolean overloaded;
  public StandardProcedure(DeclarationScope declaredIn,Type type, String ident)
  { super(ident); this.declaredIn=declaredIn; this.type=type; this.blockKind=BlockKind.Method; }

  public StandardProcedure(DeclarationScope declaredIn,Type type, String ident,Parameter param)
  { this(declaredIn,type,ident); addParameter(param); }

  public StandardProcedure(DeclarationScope declaredIn,Type type, String ident,Parameter p1,Parameter p2)
  { this(declaredIn,type,ident,p1); addParameter(p2); }

  public StandardProcedure(DeclarationScope declaredIn,Type type, String ident,Parameter p1,Parameter p2,Parameter p3)
  { this(declaredIn,type,ident,p1,p2); addParameter(p3); }

  public StandardProcedure(DeclarationScope declaredIn,Type type, String ident,Parameter p1,Parameter p2,Parameter p3,Parameter p4)
  { this(declaredIn,type,ident,p1,p2,p3); addParameter(p4); }

  public StandardProcedure(DeclarationScope declaredIn,Type type, String ident,Parameter p1,Parameter p2,Parameter p3,Parameter p4,Parameter p5)
  { this(declaredIn,type,ident,p1,p2,p3,p4); addParameter(p5); }

  public StandardProcedure(DeclarationScope declaredIn,Type type, String ident,Parameter p1,Parameter p2,Parameter p3,Parameter p4,Parameter p5,Parameter p6)
  { this(declaredIn,type,ident,p1,p2,p3,p4,p5); addParameter(p6); }
  
  public void doChecking()
  { if(IS_SEMANTICS_CHECKED()) return;
   	Util.setLine(lineNumber);
  	String name=this.getClass().getSimpleName();
	if(Option.TRACE_CHECKER) Util.TRACE("BEGIN "+name+".doChecking");
	Global.currentScope=declaredIn;
	if(Option.TRACE_CHECKER) Util.TRACE("END StandardProcedure("+toString()+").doChecking - Result type="+this.type);
    SET_SEMANTICS_CHECKED();
  }
  
  public void doJavaCoding(String indent)
  {	Util.setLine(lineNumber);
	ASSERT_SEMANTICS_CHECKED(this);
	Global.currentScope=this;
    
	String modifier="public ";
	// Test om dette er en 'static' metode
	// TODO: Gjør dette litt mere elegant !
	StandardClass stdc=(StandardClass)declaredIn;
	if(stdc.isContextFree) modifier="public static ";
	
    String line=modifier+((type==null)?"void":type.toJavaType());
	line=line+' '+identifier+' '+edFormalParameterList(true); // Treat as Method
	Util.code(indent+line);
	Global.currentScope=declaredIn;
  }

  public String toString()
  { String pfx=""; if(type!=null) pfx=type.toString()+" ";
    return(pfx+"PROCEDURE "+identifier);
  }

}
