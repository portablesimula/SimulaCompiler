/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.expression;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
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
public class Constant extends Expression {
	public Object value;

	public Constant(Type type, Object value) {
		this.type=type;
		this.value = value;
		if (Option.TRACE_PARSE) Util.TRACE("NEW Constant: "+this);
	}

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Util.setLine(lineNumber);
		this.type.doChecking(Global.currentScope);
		SET_SEMANTICS_CHECKED();
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
		if(type==Type.Character) return("'"+value+"'");
		return (""+value);
	}
	
	private String encode(String s)
	{ StringBuilder b=new StringBuilder();
	  for(char c:s.toCharArray())
	  { if(c=='"') b.append('\\');
		b.append(c);		  
	  }
	  return(b.toString());
	}

	public String toString() {
		String val=value==null?"null":(value.getClass().getSimpleName()+'(' + value+')');
		return("CONSTANT("+type+','+val+')');
	}

}
