/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.expression;

import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.TypeDeclaration;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Constant.
 * <p>
 * All constants are treated by the Lexicographical Scanner.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 *   Constant = UnsignedNumber | String | Character | NONE | NOTEXT | Label ???
 *   
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 * @see simula.compiler.parsing.SimulaScanner
 */
public final class Constant extends Expression {
	public Object value;

	public Constant(Type type, Object value) {
		this.type=type;
		this.value = value;
		//if (Option.TRACE_PARSE) Util.TRACE("NEW Constant: "+this);
	}
	
    public static Constant createRealType(Object value)
    { Type type=Type.Real;
      if(value instanceof Double) type=Type.LongReal;
      return(new Constant(type,value));
    }

    
    private static Type getType(Number n) {
    	if(n instanceof Integer) return(Type.Integer);
    	if(n instanceof Long) return(Type.Integer);
    	if(n instanceof Float) return(Type.Real);
    	return(Type.LongReal);
    }
    
    public static Constant evaluate(KeyWord opr,Number rhn) { 
    	Type type=getType(rhn);
		Number result=null;
		if(type==Type.Integer) {
			switch(opr) {
	        	case PLUS: result=rhn.intValue(); break;
	        	case MINUS: result= - rhn.intValue(); break;
	        	default:
			}
		} else if(type==Type.Real) {
			switch(opr) {
        		case PLUS: result=rhn.floatValue(); break;
        		case MINUS: result= - rhn.floatValue(); break;
        		default:
			}
		} else if(type==Type.LongReal) {
			switch(opr) {
				case PLUS: result=rhn.doubleValue(); break;
				case MINUS: result= - rhn.doubleValue(); break;
				default:
			}
		}
		if(result==null) Util.FATAL_ERROR("Impossible");
		return(new Constant(type,result));
    }
  
    public static Constant evaluate(Number lhn,KeyWord opr,Number rhn) { 
    	Type type=Type.arithmeticTypeConversion(getType(lhn),getType(rhn));
		if(opr==KeyWord.DIV && type==Type.Integer) type=Type.Real;
		//Util.BREAK("ArithmeticOperation.NEW: type="+type);
		Number result=null;
		if(type==Type.Integer) {
			switch(opr) {
	        	case PLUS: result=lhn.intValue() + rhn.intValue(); break;
	        	case MINUS: result=lhn.intValue() - rhn.intValue(); break;
	        	case MUL: result=lhn.intValue() * rhn.intValue(); break;
	        	case INTDIV: result=lhn.intValue() / rhn.intValue(); break;
        		case EXP: result=Util.IPOW(lhn.intValue(),rhn.intValue()); break;
	        	default:
			}
		} else if(type==Type.Real) {
			switch(opr) {
        		case PLUS: result=lhn.floatValue() + rhn.floatValue(); break;
        		case MINUS: result=lhn.floatValue() - rhn.floatValue(); break;
        		case MUL: result=lhn.floatValue() * rhn.floatValue(); break;
        		case DIV: result=lhn.floatValue() / rhn.floatValue(); break;
        		case EXP: result=Math.pow(lhn.floatValue(),rhn.floatValue()); break;
        		default:
			}
		} else if(type==Type.LongReal) {
			switch(opr) {
				case PLUS: result=lhn.doubleValue() + rhn.doubleValue(); break;
				case MINUS: result=lhn.doubleValue() - rhn.doubleValue(); break;
				case MUL: result=lhn.doubleValue() * rhn.doubleValue(); break;
				case DIV: result=lhn.doubleValue() / rhn.doubleValue(); break;
				case EXP: result=Math.pow(lhn.doubleValue(),rhn.doubleValue()); break;
				default:
			}
		}
		if(result==null) Util.FATAL_ERROR("Impossible");
		return(new Constant(type,result));
    }
  
    public static Number getNumber(Expression x) {
	    if(x instanceof Constant) {
		    Object value=((Constant)x).value;
		    //System.out.println("ArithmeticOperation.getNumber: value="+value+", QUAL="+value.getClass().getSimpleName());
		    if(value instanceof Number) return((Number)value);
	    }
	    if(x instanceof Variable) {
		    Variable var=(Variable)x;
//		    Meaning meaning=var.meaning;
		    Meaning meaning=Global.currentScope.findMeaning(var.identifier);
//		    //System.out.println("ArithmeticOperation.getNumber: meaning="+meaning);
		    if(meaning==null) return(null);
		    Declaration declaredAs=meaning.declaredAs;
		    //System.out.println("ArithmeticOperation.getNumber: declaredAs="+declaredAs+", QUAL="+declaredAs.getClass().getSimpleName());
		    if(declaredAs instanceof TypeDeclaration) {
			    TypeDeclaration tp=(TypeDeclaration)declaredAs;
			    Expression constElt=tp.constantElement;
			    //System.out.println("ArithmeticOperation.getNumber: constElt="+constElt);
			    if(constElt!=null) {
				    //System.out.println("ArithmeticOperation.getNumber: constElt="+constElt+", QUAL="+constElt.getClass().getSimpleName());
				    if(constElt instanceof Constant) {
					    Object value=((Constant)constElt).value;
					    //System.out.println("ArithmeticOperation.getNumber: value="+value+", QUAL="+value.getClass().getSimpleName());
					    if(value instanceof Number) return((Number)value);
				    }
			    }
		    }
		    return(null);
	    }
	    return(null);
    }

    
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		this.type.doChecking(Global.currentScope);
		SET_SEMANTICS_CHECKED();
	}

	  // Returns true if this expression may be used as a statement.
	  public boolean maybeStatement()
	  {	ASSERT_SEMANTICS_CHECKED(this);
		return(false);  
	  }

	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED(this);
		//Util.BREAK("Constant.toJavaCode: "+this);
		if(type==Type.Text)
		{ if(value==null) return("null");
		  String val=value.toString();
          val=encode(val);
		  return("new TXT$(\""+val+"\")");
		}
		if(type==Type.Character) {
			//Util.BREAK("Constant.toJavaCode: value="+value+", QUAL="+value.getClass().getSimpleName());
			char charValue=((Character)value).charValue();
			if(charValue=='\\') return("'\\\\'");
			int intValue=(int)charValue;
//			return("'"+value+"'");
//			return(""+intValue);
			if(intValue!='\'' && intValue>32 && intValue<127) return("'"+value+"'");
			return("((char)"+intValue+')');
		}
		if(type==Type.Integer)  return (""+((Number)value).intValue());
		if(type==Type.Real)     return (""+((Number)value).floatValue()+'f');
		if(type==Type.LongReal) return (""+((Number)value).doubleValue()+'d');
		return (""+value);
	}
	
	private String encode(String s) {
		StringBuilder b = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (c == '"') b.append('\\');
			else if (c == '\\') b.append('\\');
			b.append(c);
		}
		return (b.toString());
	}

	public String toString() {
		String val=value==null?"null":(value.getClass().getSimpleName()+'(' + value+')');
		return("CONSTANT("+type+','+val+')');
	}

}
