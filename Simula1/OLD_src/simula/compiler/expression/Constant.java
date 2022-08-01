/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.expression;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
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
public final class Constant extends Expression implements Externalizable {
	public Object value;

	public Constant(final Type type,final Object value) {
		this.type=type;
		this.value = value;
	}
	
    public static Constant createRealType(final Object value)
    { Type type=Type.Real;
      if(value instanceof Double) type=Type.LongReal;
      return(new Constant(type,value));
    }
    
    private static Type getType(final Number n) {
    	if(n instanceof Integer) return(Type.Integer);
    	if(n instanceof Long) return(Type.Integer);
    	if(n instanceof Float) return(Type.Real);
    	return(Type.LongReal);
    }
    
    public static Constant evaluate(final KeyWord opr,final Number rhn) { 
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
  
    public static Constant evaluate(final Number lhn,final KeyWord opr,final Number rhn) { 
    	Type type=Type.arithmeticTypeConversion(getType(lhn),getType(rhn));
		if(opr==KeyWord.DIV && type==Type.Integer) type=Type.Real;
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
    
    public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		this.type.doChecking(Global.currentScope);
		SET_SEMANTICS_CHECKED();
	}

    // Returns true if this expression may be used as a statement.
    public boolean maybeStatement() {
    	ASSERT_SEMANTICS_CHECKED(this);
		return(false);  
    }

	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED(this);
		if(type==Type.Text)
		{ if(value==null) return("null");
		  String val=value.toString();
          val=encode(val);
		  return("new TXT$(\""+val+"\")");
		}
		if(type==Type.Character) {
			char charValue=((Character)value).charValue();
			if(charValue=='\\') return("'\\\\'");
			int intValue=(int)charValue;
			if(intValue!='\'' && intValue>32 && intValue<127) return("'"+value+"'");
			return("((char)"+intValue+')');
		}
		if(type==Type.Integer)  return (""+((Number)value).intValue());
		if(type==Type.Real)     return (""+((Number)value).floatValue()+'f');
		if(type==Type.LongReal) return (""+((Number)value).doubleValue()+'d');
		return (""+value);
	}
	
	private String encode(final String s) {
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

	
	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	public Constant() {}

	@Override
	public void writeExternal(ObjectOutput oupt) throws IOException {
		Util.TRACE_OUTPUT("Constant: "+type+' '+value);
		oupt.writeObject(type);
		oupt.writeObject(value);
	}

	@Override
	public void readExternal(ObjectInput inpt) throws IOException, ClassNotFoundException {
		type=Type.inType(inpt);
		value=inpt.readObject();
		Util.TRACE_INPUT("Constant: "+type+' '+value);
	}

}
