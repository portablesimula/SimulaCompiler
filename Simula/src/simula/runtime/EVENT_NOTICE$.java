/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

/**
* 
* @author SIMULA Standards Group
* @author Øystein Myhre Andersen
*/
public final class EVENT_NOTICE$ extends Link$ {
	public double EVTIME;
	public final Process$ PROC;
	private final Simulation$ SIMULATION;

	// Constructor
    public EVENT_NOTICE$(final Simulation$ staticLink,final float EVTIME,final Process$ PROC) {
    	super(staticLink);
    	SIMULATION=staticLink;
    	this.EVTIME = EVTIME;
    	this.PROC = PROC;
    }
	
	
	public EVENT_NOTICE$ suc() {
		return ((SUC instanceof EVENT_NOTICE$)?(EVENT_NOTICE$)SUC:null);
	}

	public EVENT_NOTICE$ pred() {
		return((EVENT_NOTICE$)PRED); // May be Head$
	}

	public void RANK(final boolean BEFORE) {
//		RT.BREAK("EVENT_NOTICE$.RANK: BEFORE="+BEFORE);
		EVENT_NOTICE$ P =(EVENT_NOTICE$)SIMULATION.SQS.last();
//		RT.BREAK("EVENT_NOTICE$.RANK: SQS.last:"+P);
		while(P.EVTIME > EVTIME)
		{ Linkage$ Prv = P.PRED;
		  if(Prv instanceof EVENT_NOTICE$) P=(EVENT_NOTICE$)Prv;
		  else { precede(P); return; }
		}
//		RT.BREAK("EVENT_NOTICE$.RANK: NOT(P.EVTIME > EVTIME):"+P);
		if (BEFORE) while(P.EVTIME == EVTIME)
		{ Linkage$ Prv = P.PRED;
		  if(Prv instanceof EVENT_NOTICE$) P=(EVENT_NOTICE$)Prv;
		  else { precede(P); return; }
		}
//		RT.BREAK("EVENT_NOTICE$.RANK: Follow:"+P);
		follow(P);
	}
	
	public String toString()
	{ return("EVENT_NOTICE$ EVTIME="+EVTIME+", PROC="+PROC); }

}
