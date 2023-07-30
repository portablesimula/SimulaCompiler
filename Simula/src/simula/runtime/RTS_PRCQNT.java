/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
* Procedure quantity.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_PRCQNT.java"><b>Source File</b></a>.
*  
* @author Øystein Myhre Andersen
*/
public final class RTS_PRCQNT {
	
	/**
	 * Static link.
	 */
	final RTS_RTObject staticLink;
	
	/**
	 * The Java class representing the Simula Procedure.
	 */
	final Class<?> procedure;

	// Constructor
	/**
	 * Creeate a new RTS_PRCQNT.
	 * @param SL staticLink
	 * @param procedure procedure class
	 */
	public RTS_PRCQNT(final RTS_RTObject SL, final Class<?> procedure) {
		this.staticLink = SL;
		this.procedure = procedure;
	}

	/**
	 * Call procedure formal.
	 * @return the procedure instance
	 * @throws RTS_SimulaRuntimeError if operation fail
	 */
	public RTS_PROCEDURE CPF() {
		try {
			// Get 'default' constructor: <Procedure>(_RTObject SL);
			Constructor<?> constr = procedure.getConstructor(new Class[] { RTS_RTObject.class });
			Object obj = constr.newInstance(staticLink);
			return ((RTS_PROCEDURE) obj);
		} catch (InvocationTargetException e) {
			Throwable targetException = e.getTargetException();
			if (targetException instanceof RuntimeException) {
				throw (RuntimeException) targetException; // RE-THROW TargetException
			}
			throw new RTS_SimulaRuntimeError("RTS_PRCQNT.CPF: FATAL error (1) - Impossible situation - " + e, e);
		} catch (Throwable e) {
			throw new RTS_SimulaRuntimeError("RTS_PRCQNT.CPF: FATAL error (2) - Impossible situation - " + e, e);
		}
	}

	@Override
	public String toString() {
		return ("Simula RTS_PRCQNT(" + staticLink + ',' + procedure + ')');
	}

}
