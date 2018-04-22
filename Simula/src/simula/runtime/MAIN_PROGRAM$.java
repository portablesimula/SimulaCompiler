/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import simula.compiler.utilities.Util;

public class MAIN_PROGRAM$ extends Process$ {
	
   // Constructor
    public MAIN_PROGRAM$(RTObject$ staticLink) {
       super(staticLink);
       // Create Class Body
       CODE$=new ClassBody(CODE$,this) {
          public void STM() {
             Util.BREAK("MAIN_PROGRAM$ Before INNER");
             while(true) detach();
       }};
    }
    public MAIN_PROGRAM$ STM() { return((MAIN_PROGRAM$)CODE$.EXEC$()); }
    public MAIN_PROGRAM$ START() { START(this); return(this); }
	
	public String toString()
	{ return("MAIN_PROGRAM$ TERMINATED_="+TERMINATED_); }

}
