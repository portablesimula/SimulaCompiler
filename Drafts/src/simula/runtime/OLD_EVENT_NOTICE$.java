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
public final class OLD_EVENT_NOTICE$ extends Link$ {
	public double EVTIME;
	public final Process$ PROC;
	private final Simulation$ SIMULATION;

	// Constructors
    public OLD_EVENT_NOTICE$(final Simulation$ staticLink,final float EVTIME,final Process$ PROC) {
    	super(staticLink);
    	SIMULATION=staticLink;
    	this.EVTIME = EVTIME;
    	this.PROC = PROC;
    }
    
	public OLD_EVENT_NOTICE$ suc() {
		return ((SUC instanceof OLD_EVENT_NOTICE$)?(OLD_EVENT_NOTICE$)SUC:null);
	}

	public OLD_EVENT_NOTICE$ pred() {
		return((OLD_EVENT_NOTICE$)PRED); // May be Head$
	}

	public void RANK(final boolean BEFORE) {
//		RT.BREAK("EVENT_NOTICE$.RANK: BEFORE="+BEFORE);
		OLD_EVENT_NOTICE$ P =(OLD_EVENT_NOTICE$)SIMULATION.OLD_SQS.last();
//		RT.BREAK("EVENT_NOTICE$.RANK: SQS.last:"+P);
		while(P.EVTIME > EVTIME)
		{ Linkage$ Prv = P.PRED;
		  if(Prv instanceof OLD_EVENT_NOTICE$) P=(OLD_EVENT_NOTICE$)Prv;
		  else { precede(P); return; }
		}
//		RT.BREAK("EVENT_NOTICE$.RANK: NOT(P.EVTIME > EVTIME):"+P);
		if (BEFORE) while(P.EVTIME == EVTIME)
		{ Linkage$ Prv = P.PRED;
		  if(Prv instanceof OLD_EVENT_NOTICE$) P=(OLD_EVENT_NOTICE$)Prv;
		  else { precede(P); return; }
		}
//		RT.BREAK("EVENT_NOTICE$.RANK: Follow:"+P);
		follow(P);
	}
	
	public String toString()
	{ return("EVENT_NOTICE$ EVTIME="+EVTIME+", PROC="+PROC); }

}
