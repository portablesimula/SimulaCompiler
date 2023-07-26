/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

/**
 * System class MAIN_PROGRAM
 * <pre>
 *  process class MAIN_PROGRAM;
             begin
                while true do detach
             end MAIN PROGRAM;
 * </pre>
 * 
 * It is desirable that the main component of a simulation model, i.e. the
 * "simulation" block instance, should respond to the sequencing procedures of
 * 12.4 as if it were itself a process object. This is accomplished by having a
 * process object of the class MAIN_PROGRAM as a permanent component of the
 * quasi-parallel system.
 * <p>
 * The process object represents the main component with respect to the
 * sequencing procedures. Whenever it becomes operative, the PSC (and OSC)
 * immediately enter the main component as a result of the "detach" statement
 * (cf. 7.3.1). The procedure "current" references this process object whenever
 * the main component is active.
 * <p>
 * A simulation model is initialized by generating the MAIN_PROGRAM object and
 * scheduling an active phase for it at system time zero. Then the PSC proceeds
 * to the first user-defined statement of the "simulation" block.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_MAIN_PROGRAM.java"><b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 */
public final class RTS_MAIN_PROGRAM extends RTS_Process {

	// Constructor
	/**
	 * Create a new _MAIN_PROGRAM.
	 * @param SL staticLink
	 */
	public RTS_MAIN_PROGRAM(final RTS_RTObject SL) {
		super(SL);
	}

	// Class Statements
	@Override
	public RTS_MAIN_PROGRAM _STM() {
		while (true)
			detach();
	}

	@Override
	public String toString() {
		return ("MAIN_PROGRAM TERMINATED=" + terminated());
	}

}
