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
public final class _EVENT_NOTICE extends _Ranking {
	public final _Process PROC;

	// Constructors
    public _EVENT_NOTICE(final double EVTIME,final _Process PROC) {
    	this.rnk=EVTIME;
    	this.PROC = PROC;
    }
    
    public void SET_EVTIME(double time) {
		rnk=time;
    }
    
    public double EVTIME() {
		return(rnk);
    }
	
    public boolean equals(_EVENT_NOTICE other) {
    	_RT.ASSERT(false,"USED !!!!");
    	return(PROC==other.PROC && rnk==other.rnk);
    }
	
	public String toString() {
		return("EVENT_NOTICE EVTIME="+EVTIME()+", PROC="+PROC+", rnk="+rnk);
	}

}