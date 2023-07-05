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
* @author Øystein Myhre Andersen
*/
public abstract class _PROC extends _BASICIO {
	protected int _nParLeft; // Number of actual parameters left to be transmitted.

	// Constructor
	public _PROC(final _RTObject staticLink) {
		super(staticLink);
	}

	// Constructor in case of Formal/Virtual Procedure Call
	public _PROC(final _RTObject staticLink, int nPar) {
		super(staticLink);
		this._nParLeft = nPar;
	}

	/**
	 * This method is virtual and must be redefined in all procedure blocks with
	 * parameters.
	 * 
	 * @param obj Procedure's Parameter Value Object
	 * @return this object
	 */
	public _PROC setPar(final Object obj) {
		return (this);
	}

	/**
	 * This method is virtual and must be redefined in all type procedure blocks
	 * 
	 * @return
	 */
	public Object _RESULT() {
		return (null);
	}

	public _PROC _ENT() {
		// Enter Formal Procedure
		if (_nParLeft != 0)
			throw new _SimulaRuntimeError("Too few parameters");
		BBLK();
		_STM();
		return (this);
	}

}