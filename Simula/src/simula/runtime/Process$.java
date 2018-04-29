/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

/**
 * <pre>
 * link class process;
 *      begin ref (EVENT_NOTICE) EVENT;
 *         Boolean TERMINATED;
 *         Boolean procedure idle;              idle := EVENT==none;
 *         Boolean procedure terminated;  terminated := TERMINATED;
 *
 *         long real procedure evtime;
 *            if idle then  error("..." ! No Evtime for idle process)
 *            else evtime := EVENT.EVTIME;
 *
 *         ref (process) procedure nextev;
 *            nextev :- if  idle or else EVENT.suc == none then none
 *                     else EVENT.suc.PROC;
 *
 *         detach;
 *         inner;
 *         TERMINATED:= true;
 *         passivate;
 *         error("..." ! Terminated process;)
 *     end process;
 * </pre>
 * 
 * An object of a class prefixed by "process" is called a process object. A
 * process object has the properties of "link" and, in addition, the capability
 * to be represented in the sequencing set and to be manipulated by certain
 * sequencing statements which may modify its "process state". The possible
 * process states are: active, suspended, passive and terminated.
 * <p>
 * When a process object is generated it immediately becomes detached and its
 * reactivation point positioned in front of the first statement of its user-
 * defined operation rule. The process object remains detached throughout its
 * dynamic scope.
 * <p>
 * The procedure "idle" has the value true if the process object is not
 * currently represented in the sequencing set. It is said to be in the passive
 * or terminated state depending on the value of the procedure "terminated". An
 * idle process object is passive if its reactivation point is at a user-defined
 * prefix level. If and when the PSC passes through the final end of the
 * user-defined part of the body, it proceeds to the final operations at the
 * prefix level of the class "process", and the value of the procedure
 * "terminated" becomes true. (Although the process state "terminated" is not
 * strictly equivalent to the corresponding basic concept defined in chapter 7,
 * an implementation may treat a terminated process object as terminated in the
 * strict sense). A process object currently represented in the sequencing set
 * is said to be "suspended", unless it is represented by the event notice at
 * the lower end of the sequencing set. In the latter case it is active. A
 * suspended process is scheduled to become active at the system time indicated
 * by the attribute EVTIME of its event notice. This time value may be accessed
 * through the procedure "evtime". The procedure "nextev" references the process
 * object, if any, represented by the next event notice in the sequencing set.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 */
public class Process$ extends Link$ {
	public boolean isDetachable() {
		return (true);
	}

	public EVENT_NOTICE$ EVENT = null;
	public boolean TERMINATED$ = false;
	private static int SEQU = 0; // Used by SIM_TRACE
	private int sequ = 0; // Used by SIM_TRACE

	// Constructor
	public Process$(RTObject$ staticLink) {
		super(staticLink);
		sequ = SEQU++;
		CODE$ = new ClassBody(CODE$, this) {
			public void STM() {
				// Util.BREAK("Process$ Before INNER");
				detach();
				if (inner != null)
					inner.STM();
				// Util.BREAK("Process$ After INNER");
				TERMINATED$ = true;
				((Simulation$) SL$).passivate();
				throw new RuntimeException("INTERNAL error:  Process passes through final end.");
			}
		};
	}

	public Process$ STM() {
		return ((Process$) CODE$.EXEC$());
	}

	public Process$ START() {
		START(this);
		return (this);
	}

	public boolean idle() {
		return (EVENT == null);
	}

	public boolean terminated() {
		return (TERMINATED$);
	}

	public double evtime() {
		if (idle())
			throw new RuntimeException("Process.Evtime:  The process is idle.");
		return (EVENT.EVTIME);
	}

	public Process$ nextev() {
		if (idle())
			return (null);
		EVENT_NOTICE$ suc = EVENT.suc();
		if (suc == null)
			return (null);
		return (suc.PROC);
	}

	public String toSimpleString() {
		return (this.getClass().getSimpleName() + "#" + sequ);
	}

	public String toString() {
		return ("Process$(" + this.getClass().getSimpleName() + ") TERMINATED$=" + TERMINATED$);
	}

}
