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
import simula.compiler.utilities.ParameterKind;
import simula.compiler.utilities.ParameterMode;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

public class Parameter extends Declaration
{ 
//String identifier;  // Inherited
  public ParameterMode mode;
//  Type type;  // Inherited 
  public ParameterKind kind;

  public Parameter(String identifier)
  { super(identifier); }
  
  public Parameter(String identifier,Type type,ParameterKind kind)
  { super(identifier); this.type=type; this.kind=kind; }
  
  public void setMode(ParameterMode mode)
  {	if(this.mode!=null)
	Util.error("Parameter "+identifier+" is already specified by"+this.mode);
	this.mode=mode;
  }

  public void setTypeAndKind(Type type,ParameterKind kind)
  { this.type=type; this.kind=kind; }

  public void doChecking()
  { if(IS_SEMANTICS_CHECKED()) return;
    Util.setLine(lineNumber);
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
		  else if(type.isReferenceType()) { if(mode==ParameterMode.value) illegal=true; } // Simple ref(ClassIdentifier)
		  else if(mode==null) mode=ParameterMode.value; // Simple Type Integer, Real, Character
		  break;
	    case Array:
	    	if(type.isReferenceType() && mode==ParameterMode.value) illegal=true;
	    	break;
	    case Procedure:
	    case Label:
	    case Switch:
	    	if(mode==ParameterMode.value) illegal=true;
	    	break;
	    default:	
	  }
	  return(!illegal);
	}
  
  public String toJavaType()
  { ASSERT_SEMANTICS_CHECKED(this);
    if(mode==ParameterMode.name)
    { switch(kind)
      { case Simple:
    	  if(type==Type.Label) return("$NAME<$LABQNT>");
    	  return("$NAME<"+type.toJavaTypeClass()+">");
        case Procedure: return("$NAME<$PRCQNT>");
    	case Label:     return("$NAME<$LABQNT>");
    	case Array:		return("$NAME<$ARRAY<"+type.toJavaType()+"[]>>");
    	case Switch:    return("$NAME<$PRCQNT>");
      }
    }
    if(kind==ParameterKind.Array) return("$ARRAY<"+type.toJavaType()+"[]>");
    if(kind==ParameterKind.Procedure) return("$PRCQNT");
    if(kind==ParameterKind.Label) return("$LABQNT");
	return(type.toJavaType());
  }
  
  public String toJavaCode()
  { return(toJavaType() + ' ' + identifier); }

  public String toString()
  {	String s="";
    if(type!=null) s=s+type; else s="NOTYPE";
    if(mode!=null) s=""+mode+" "+type;
    if(kind==null) s=s+" NOKIND";
    else if(kind!=ParameterKind.Simple) s=s+" "+kind;
  	return(s+' '+identifier);
  }

}
