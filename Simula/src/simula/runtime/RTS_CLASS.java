/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

/**
 * Utility class RTS_CLASS - Fictituous outermost prefix.
 * <p>
 * Any class that has no (textually given) prefix is by definition prefixed
 * by a fictitious class whose only attribute is:
 * <pre>
 *                     procedure detach; ... ; (see 7.3.1)
 * </pre>
 * Thus every class object or instance of a prefixed block has this attribute.
 * <p>
 * This java class is used as prefix to a Simula Class.
 * <p>
 * Example:
 * 
 * <pre>
 * 		public class SimulaTest extends RTS_CLASS {
 * 			...
 * 		}
 * </pre>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_CLASS.java"><b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 */
public abstract class RTS_CLASS extends RTS_BASICIO implements Runnable {

	/**
	 * Create a new RTS_CLASS instance.
	 * 
	 * @param SL staticLink
	 */
	public RTS_CLASS(final RTS_RTObject SL) {
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
	/**
	 * Begin a QPS component in a separate coroutine.
	 */
	private void beginCoroutine() {
		// Using Thread or Virtual Thread
		this._CORUT = new RTS_Coroutine(this);
		if (RTS_COMMON.Option.QPS_TRACING)
			RTS_COMMON.TRACE("START " + this.edObjectIdent());
		swapCoroutines();
	}

}