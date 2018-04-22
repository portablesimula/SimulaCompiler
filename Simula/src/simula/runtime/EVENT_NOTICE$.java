/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import simula.compiler.utilities.Util;

public class EVENT_NOTICE$ extends Link$ {
	public double EVTIME;
	public Process$ PROC;
	public Simulation$ SIMULATION;

	// Constructor
    public EVENT_NOTICE$(Simulation$ staticLink,float EVTIME,Process$ PROC) {
       super(staticLink);
	   SIMULATION=staticLink;
       this.EVTIME = EVTIME;
       this.PROC = PROC;
       CODE$=new ClassBody(CODE$,this) {
          public void STM() {
             if(inner!=null) inner.STM();
       }};
    }
	
	
	public EVENT_NOTICE$ suc() {
//		return ((suc().getClass() == EVENT_NOTICE$.class) ? (EVENT_NOTICE$) suc()	: null);
		return ((SUC instanceof EVENT_NOTICE$)?(EVENT_NOTICE$)SUC:null);
	}

	public EVENT_NOTICE$ pred() {
		return((EVENT_NOTICE$)PRED);
	}

	public void RANK(boolean BEFORE_) {
		Util.BREAK("EVENT_NOTICE$.RANK: SIMULATION="+SIMULATION);
		Util.BREAK("EVENT_NOTICE$.RANK: SIMULATION.SQS="+SIMULATION.SQS);
		EVENT_NOTICE$ P =(EVENT_NOTICE$)SIMULATION.SQS.last();
		while(P.EVTIME > EVTIME) P = P.pred();
		if (BEFORE_) while(P.EVTIME == EVTIME) P = P.pred();
		follow(P);
	}
	
	public String toString()
	{ return("EVENT_NOTICE$ EVTIME="+EVTIME+", PROC="+PROC); }

}
