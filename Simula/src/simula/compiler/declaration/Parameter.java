/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.Token;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

public class Parameter extends Declaration
{ 
//String identifier;  // Inherited
  public Parameter.Mode mode;
//  Type type;  // Inherited 
  public Parameter.Kind kind;
  
  public enum Mode {
	    value     // Procedure parameter transfer mode
	  , name      // Procedure parameter transfer mode
  }

  public enum Kind {
	  Simple
	  , Procedure
	  , Array
	  , Label
	  , Switch
  }


  public Parameter(String identifier)
  { super(identifier); }
  
  public Parameter(String identifier,Type type,Parameter.Kind kind)
  { super(identifier);
//	externalIdent="p$"+identifier;
    this.type=type; this.kind=kind;
    //Util.BREAK("NEW Parameter: "+this);
  }
  
  public boolean equals(Object other)
  {	if(!(other instanceof Parameter)) return(false);
	Parameter otherPar=(Parameter)other;
    //Util.BREAK("Parameter.equals: This type="+type);
    //Util.BREAK("Parameter.equals: Othr type="+otherPar.type);
    //Util.BREAK("Parameter.equals: TypeEquals="+type.equals(otherPar.type));
	if(!type.equals(otherPar.type)) return(false);
	if(kind!=otherPar.kind) return(false);
	if(mode!=otherPar.mode) return(false);
	return(true);
  }
  
  public void setMode(Parameter.Mode mode)
  {	if(this.mode!=null)
	Util.error("Parameter "+identifier+" is already specified by"+this.mode);
	this.mode=mode;
  }

  public void setTypeAndKind(Type type,Parameter.Kind kind)
  { this.type=type; this.kind=kind; }

  public void doChecking()
  { if(IS_SEMANTICS_CHECKED()) return;
    Global.sourceLineNumber=lineNumber;
	externalIdent="p$"+identifier;
    //Util.BREAK("CHECKING Parameter: "+this);
 	//Util.BREAK("Parameter("+this.toString()+").doChecking: Current Scope Chain: "+currentScope.edScopeChain());
	//Util.BREAK("Parameter("+this.toString()+").doChecking: type="+type);
    if(type!=null) type.doChecking(Global.currentScope.declaredIn);
    if(!legalTransmitionMode())
  	   Util.error("Illegal transmission mode: "+mode+' '+kind+' '
			  +identifier+" by "+((mode!=null)?mode:"default")+" is not allowed");
    SET_SEMANTICS_CHECKED();	  
  }
	
  /**
  * The available transmission modes for the different kinds of parameters to procedures.
  * <pre>
  *     --------------------------------------------------------------
  *    |                       |         Transmission modes           |
  *    |   Parameter           | - - - - - - - - - - - - - - - - - - -|
  *    |                       |  by value | by reference |  by name  |
  *    |--------------------------------------------------------------|
  *    |   value type          |     D     |       I      |     O     |
  *    |   object ref. type    |     I     |       D      |     O     |
  *    |   text                |     O     |       D      |     O     |
  *    |   value type array    |     O     |       D      |     O     |
  *    |   reference type array|     I     |       D      |     O     |
  *    |   procedure           |     I     |       D      |     O     |
  *    |   type procedure      |     I     |       D      |     O     |
  *    |   label               |     I     |       D      |     O     |
  *    |   switch              |     I     |       D      |     O     |
  *     --------------------------------------------------------------
  *
  *        D:  default mode       O:  optional mode       I:  illegal
  * </pre>
  */
  private boolean legalTransmitionMode()
  { 
	  //Util.BREAK("Parameter: "+kind+' '+type+' '+formalParameter.identifier+" by "+((mode!=null)?mode:"default"));
    boolean illegal=false;
	  switch(kind)
	  { case Simple: 
		  if(type==Type.Text) break; // Simple Text	 
		  else if(type.isReferenceType()) { if(mode==Parameter.Mode.value) illegal=true; } // Simple ref(ClassIdentifier)
		  else if(mode==null) mode=Parameter.Mode.value; // Simple Type Integer, Real, Character
		  break;
	    case Array:
	    	if(type.isReferenceType() && mode==Parameter.Mode.value) illegal=true;
	    	break;
	    case Procedure:
	    case Label:
	    case Switch:
	    	if(mode==Parameter.Mode.value) illegal=true;
	    	break;
	    default:	
	  }
	  return(!illegal);
	}
  
  public String toJavaType()
  { ASSERT_SEMANTICS_CHECKED(this);
    if(mode==Parameter.Mode.name)
    { switch(kind)
      { case Simple:
    	  if(type==Type.Label) return("$NAME<$LABQNT>");
    	  return("$NAME<"+type.toJavaTypeClass()+">");
        case Procedure: return("$NAME<$PRCQNT>");
    	case Label:     return("$NAME<$LABQNT>");
//    	case Array:		return("$NAME<$ARRAY<"+type.toJavaType()+"[]>>");
    	case Array:		return("$NAME<$ARRAY<?>>");
    	case Switch:    return("$NAME<$PRCQNT>");
      }
    }
//    if(kind==Parameter.Kind.Array) return("$ARRAY<"+type.toJavaType()+"[]>");
    if(kind==Parameter.Kind.Array) return("$ARRAY<?>");
    if(kind==Parameter.Kind.Procedure) return("$PRCQNT");
    if(kind==Parameter.Kind.Label) return("$LABQNT");
	return(type.toJavaType());
  }
  
  public String toJavaCode()
//  { return(toJavaType() + ' ' + identifier); }
  { return(toJavaType() + ' ' + externalIdent); }

  public String toString()
  {	String s="";
    if(type!=null) s=s+type; else s="NOTYPE";
    if(mode!=null) s=""+mode+" "+type;
    if(kind==null) s=s+" NOKIND";
    else if(kind!=Parameter.Kind.Simple) s=s+" "+kind;
  	return(s+' '+identifier+"("+externalIdent+')');
  }

}
