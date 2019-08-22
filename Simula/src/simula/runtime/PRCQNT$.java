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
		// RT.BREAK("CPF: procedure=" + procedure + ", Qual=" + procedure.getClass().getSimpleName());
		try {
			Constructor<?> constr = procedure.getConstructor(new Class[] { RTObject$.class });
			// RT.BREAK("CPF2: constr=" + constr + ", Qual=" + procedure.getClass().getSimpleName());
			Object obj = constr.newInstance(staticLink);
			// RT.BREAK("CPF5: obj=" + obj + ", Qual=" + obj.getClass().getSimpleName());
			return ((PROC$) obj);
		} catch (InvocationTargetException e) {
			// e.printStackTrace();
			// RT.BREAK("CPF3 cause=" + e.getCause());
			// RT.BREAK("CPF3 TargetException=" + e.getTargetException());
			Throwable targetException = e.getTargetException();
			if (targetException instanceof RuntimeException) {
				// RT.BREAK("CPF3 RE-THROW TargetException=" + e.getTargetException());
				throw (RuntimeException) targetException;
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
