/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

/**
 * Utility class RTS_SIMULA_BLOCK.
 * <p>
 * Each and every Simula Class, Prefixed Block, Procedure or
 * Sub-Block is compiled into a Java Class by the Simula Compiler.
 * <p>
 * This java class is used as prefix to a Simula Class, Procedure or Sub-Block.
 * <p>
 * Example:
 * 
 * <pre>
 * 		public class SimulaTest extends RTS_SIMULA_BLOCK {
 * 			...
 * 		}
 * </pre>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_SIMULA_BLOCK.java"><b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 */
public abstract class RTS_SIMULA_BLOCK extends RTS_BASICIO implements Runnable {

	/**
	 * Create a new RTS_SIMULA_BLOCK instance.
	 * 
	 * @param SL staticLink
	 */
	public RTS_SIMULA_BLOCK(final RTS_RTObject SL) {
		super(SL);
	}

	/**
	 * Runnable Body
	 * @return this object
	 */
	public RTS_RTObject _START() {
		beginCoroutine();
		return (this);
	}

	@Override
	public void run() {
		_STM();
	}

	// *********************************************************************
	// *** BEGIN QPS COMPONENT IN A SEPARATE COROUTINE
	// *********************************************************************
	private void beginCoroutine() {
		// Using Thread or Virtual Thread
		this.CORUT_ = new RTS_Coroutine(this);
		if (RTS_COMMON.Option.QPS_TRACING)
			RTS_COMMON.TRACE("START " + this.edObjectIdent());
		swapCoroutines();
	}

}