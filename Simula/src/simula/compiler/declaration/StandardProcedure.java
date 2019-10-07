/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

public final class StandardProcedure extends ProcedureDeclaration
{ public boolean overloaded;
  public StandardProcedure(DeclarationScope declaredIn,Declaration.Kind kind,Type type, String ident)
  { super(ident,kind); this.declaredIn=declaredIn; this.type=type; }

  public StandardProcedure(DeclarationScope declaredIn,Declaration.Kind kind,Type type, String ident,Parameter param)
  { this(declaredIn,kind,type,ident); param.into(parameterList); }

  public StandardProcedure(DeclarationScope declaredIn,Declaration.Kind kind,Type type, String ident,Parameter p1,Parameter p2)
  { this(declaredIn,kind,type,ident,p1); p2.into(parameterList); }

  public StandardProcedure(DeclarationScope declaredIn,Declaration.Kind kind,Type type, String ident,Parameter p1,Parameter p2,Parameter p3)
  { this(declaredIn,kind,type,ident,p1,p2); p3.into(parameterList); }

  public StandardProcedure(DeclarationScope declaredIn,Declaration.Kind kind,Type type, String ident,Parameter p1,Parameter p2,Parameter p3,Parameter p4)
  { this(declaredIn,kind,type,ident,p1,p2,p3); p4.into(parameterList); }

  public StandardProcedure(DeclarationScope declaredIn,Declaration.Kind kind,Type type, String ident,Parameter p1,Parameter p2,Parameter p3,Parameter p4,Parameter p5)
  { this(declaredIn,kind,type,ident,p1,p2,p3,p4); p5.into(parameterList); }

  public StandardProcedure(DeclarationScope declaredIn,Declaration.Kind kind,Type type, String ident,Parameter p1,Parameter p2,Parameter p3,Parameter p4,Parameter p5,Parameter p6)
  { this(declaredIn,kind,type,ident,p1,p2,p3,p4,p5); p6.into(parameterList); }
  
  public void doChecking()
  { if(IS_SEMANTICS_CHECKED()) return;
   	Global.sourceLineNumber=lineNumber;
  	String name=this.getClass().getSimpleName();
	if(Option.TRACE_CHECKER) Util.TRACE("BEGIN "+name+".doChecking");
	Global.currentScope=declaredIn;
	if(Option.TRACE_CHECKER) Util.TRACE("END StandardProcedure("+toString()+").doChecking - Result type="+this.type);
    SET_SEMANTICS_CHECKED();
  }

  public String toString()
  { String pfx=""; if(type!=null) pfx=type.toString()+" ";
    return(pfx+"PROCEDURE "+identifier);
  }

}
