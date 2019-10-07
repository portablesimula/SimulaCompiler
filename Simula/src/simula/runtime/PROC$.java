/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.lang.RuntimeException;

/**
* 
* @author Øystein Myhre Andersen
*/
public abstract class PROC$ extends BASICIO$ {
    protected int $nParLeft; // Number of actual parameters left to be transmitted.

    // Constructor
	public PROC$(final RTObject$ staticLink) {
		super(staticLink);
	}

	// Constructor in case of Formal/Virtual Procedure Call
	public PROC$(final RTObject$ staticLink,int nPar) {
		super(staticLink);
		this.$nParLeft=nPar;
	}
	
	/**
	 * This method is virtual and must be redefined in all procedure blocks with parameters.
	 * 
	 * @param obj Procedure's Parameter Value Object
	 * @return this object
	 */
	public PROC$ setPar(final Object obj) { return (this); }

	/**
	 * This method is virtual and must be redefined in all type procedure blocks
	 * 
	 * @return
	 */
	public Object RESULT$() { return (null); }

	public PROC$ ENT$() {
		// Enter Formal Procedure
		if($nParLeft!=0) throw new RuntimeException("Too few parameters");
		BBLK();
		STM$();
		return (this);
	}

}