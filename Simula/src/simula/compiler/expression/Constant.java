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
	        	case PLUS: result=rhn.intValue();
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
	        	case PLUS   -> result=lhn.intValue() + rhn.intValue();
	        	case MINUS  -> result=lhn.intValue() - rhn.intValue();
	        	case MUL    -> result=lhn.intValue() * rhn.intValue();
	        	case INTDIV -> result=lhn.intValue() / rhn.intValue();
        		case EXP    -> result=Util.IPOW(lhn.intValue(),rhn.intValue());
        		default     -> Util.IERR("Unexpected value: " + opr);
			}
		} else if(type==Type.Real) {
			switch(opr) {
        		case PLUS  -> result=lhn.floatValue() + rhn.floatValue();
        		case MINUS -> result=lhn.floatValue() - rhn.floatValue();
        		case MUL   -> result=lhn.floatValue() * rhn.floatValue();
        		case DIV   -> result=lhn.floatValue() / rhn.floatValue();
        		case EXP   -> result=Math.pow(lhn.floatValue(),rhn.floatValue());
        		default    -> Util.IERR("Unexpected value: " + opr);
			}
		} else if(type==Type.LongReal) {
			switch(opr) {
				case PLUS  -> result=lhn.doubleValue() + rhn.doubleValue();
				case MINUS -> result=lhn.doubleValue() - rhn.doubleValue();
				case MUL   -> result=lhn.doubleValue() * rhn.doubleValue();
				case DIV   -> result=lhn.doubleValue() / rhn.doubleValue();
				case EXP   -> result=Math.pow(lhn.doubleValue(),rhn.doubleValue());
        		default    -> Util.IERR("Unexpected value: " + opr);
			}
		}
		if(result==null) Util.FATAL_ERROR("Impossible");
		return(new Constant(type,result));
    }
    
	@Override
    public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		this.type.doChecking(Global.getCurrentScope());
		SET_SEMANTICS_CHECKED();
	}

    // Returns true if this expression may be used as a statement.
    public boolean maybeStatement() {
    	ASSERT_SEMANTICS_CHECKED(this);
		return(false);  
    }

	@Override
	public String toJavaCode() {
		//ASSERT_SEMANTICS_CHECKED(this); // ØM: Ad'Hoc
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
			if(c < 32) {
				if (c == '\"') b.append("\\\"");
				else if (c == '\\') b.append("\\\\");
				else if (c == '\n') b.append("\\n");
				else if (c == '\r') b.append("\\r");
				else if (c == '\t') b.append("\\t");
				else if (c == '\b') b.append("\\b");
				else if (c == '\f') b.append("\\f");
				else if (c == '\'') b.append("\\'");
				else appendHex(b,c);
			} else if(c == 92) b.append("\\\\");
			  else if(c > 90 & c < 97) appendHex(b,c);
			  else if(c == 92) b.append("\\");
			  else if(c > 123) appendHex(b,c);
			  else if (c == '\"') b.append("\\\"");
			  else b.append(c);
		}
		return (b.toString());
	}
	
	private void appendHex(StringBuilder b,char c) {
		String hex=Integer.toHexString(c);
		switch(hex.length()) {
		case 1-> hex="000"+hex;
		case 2-> hex="00"+hex;
		case 3-> hex="0"+hex;
		}
		b.append("\\u"+hex);	
	}

	@Override
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
