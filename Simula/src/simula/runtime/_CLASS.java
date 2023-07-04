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
public abstract class _CLASS extends _BASICIO implements Runnable {
	// Constructor
	public _CLASS(final _RTObject staticLink) {
		super(staticLink);
	}

	// Runnable Body
	public _RTObject _START() {
		beginCoroutine();
		return (this);
	}

	public void run() {
		_STM();
	}

	// *********************************************************************
	// *** BEGIN QPS COMPONENT IN A SEPARATE COROUTINE
	// *********************************************************************
	private void beginCoroutine() {
		// Using Thread or Virtual Thread
		this.CORUT_ = new Coroutine(this);
		if (_RT.Option.QPS_TRACING)
			_RT.TRACE("START " + this.edObjectIdent());
		_RT.ASSERT(_CUR == this, "_CLASS.START:Invariant-1");
		swapCoroutines();
	}

}