/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.utilities;

public class OverLoad extends Type {
	Type[] type;
	
	public OverLoad(Type... type)
	{  super("OverLoad");
	   this.type=type;
	}
	
	public String toString()
	{ StringBuilder s=new StringBuilder();
	  s.append("OverLoad(");
	  boolean first=true;
	  for(Type t:type) { if(!first) s.append(','); first=false; s.append(t); }
	  s.append(')');
	  return(s.toString());
	}

}
