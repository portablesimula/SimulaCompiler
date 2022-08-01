/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.lang.RuntimeException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
* 
* @author Øystein Myhre Andersen
*/
public final class PRCQNT$ {
	final RTObject$ staticLink;
	final Class<?> procedure;

	// Constructor
	public PRCQNT$(final RTObject$ staticLink,final Class<?> procedure) {
		this.staticLink = staticLink;
		this.procedure = procedure;
	}

	public PROC$ CPF() {
		try {
			// Get 'default' constructor:  <Procedure>(RTObject$ SL);
			Constructor<?> constr = procedure.getConstructor(new Class[] { RTObject$.class });
			Object obj = constr.newInstance(staticLink);
			return ((PROC$) obj);
		} catch (InvocationTargetException e) {
			Throwable targetException = e.getTargetException();
			if (targetException instanceof RuntimeException) {
				throw (RuntimeException) targetException; // RE-THROW TargetException
			}
			throw new RuntimeException("PRCQNT$.CPF: FATAL error (1) - Impossible situation - " + e, e);
		} catch (Throwable e) {
			throw new RuntimeException("PRCQNT$.CPF: FATAL error (2) - Impossible situation - " + e, e);
		}
	}

	public String toString() {
		return ("Simula PRCQNT$(" + staticLink + ',' + procedure + ')');
	}

}
