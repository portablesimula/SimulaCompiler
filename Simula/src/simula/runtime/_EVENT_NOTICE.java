/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

/**
* System class EVENT_NOTICE.
* <p>
* Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/_EVENT_NOTICE.java"><b>Source File</b></a>.
* 
* @author SIMULA Standards Group
* @author Øystein Myhre Andersen
*/
public final class _EVENT_NOTICE extends _Ranking {
	/**
	 * The owning process.
	 */
	final _Process PROC;

	/**
	 * Create a new _EVENT_NOTICE.
	 * 
	 * @param EVTIME the simulated time
	 * @param PROC the owning process
	 */
	public _EVENT_NOTICE(final double EVTIME, final _Process PROC) {
		this.rnk = EVTIME;
		this.PROC = PROC;
	}

	/**
	 * Set this event's simulated time.
	 * 
	 * @param time the simulated time
	 */
	public void SET_EVTIME(double time) {
		rnk = time;
	}

	/**
	 * Returns this event's simulated time.
	 * 
	 * @return this event's simulated time
	 */
	public double EVTIME() {
		return (rnk);
	}

	@Override
	public boolean equals(Object other) {
		_EVENT_NOTICE othr = (_EVENT_NOTICE) other;
		return (PROC == othr.PROC && rnk == othr.rnk);
	}

	@Override
	public String toString() {
		return ("EVENT_NOTICE EVTIME=" + EVTIME() + ", PROC=" + PROC + ", rnk=" + rnk);
	}

}
