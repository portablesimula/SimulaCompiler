/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import simula.runtime.RTS_RTObject.RTS_NAME;

/**
 * Utility class RandomDrawing.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_RandomDrawing.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public abstract class RTS_RandomDrawing {

	/**
	 * Utility constant: 2**31
	 */
	private static final int    TWO_POW_31    = 0x80000000; // 2**31

	/**
	 * Utility constant: 2**31 - 1
	 */
	private static final double TWO_POW_31M1D = 0x7FFFFFFF; // 2**31 - 1
	
	/**
	 * Utility constant: 5**(2*6+1)
	 */
	private static final int    MULTIPLIER    = 1220703125; // 5**(2*6+1)

	/**
	 * Default constructor
	 */
	private RTS_RandomDrawing() {}
	
	/**
	 * Procedure basicDRAW.
	 * <pre>
	 * The routine will replace the value of the specified integer variable U
	 * by a new value according to an implementation defined algorithm, which
	 * satisfy the condition stated in the Simula standard 9.9.1
	 * 
	 * For positive values of U a linear congruential sequence:
	 * 
	 * 		U(i+1) = remainder ((U(i) * 5**(2*p+1)) // 2**n)
	 * 
	 * is used with n=31 and p=6: 5**(2*6+1) = 1220703125.
	 * 
	 * The returned real number is computed as U(i+1) / (2**n-1)
	 * 
	 *
	 * If U is negative a socalled "antithetic drawing" should be obtained by
	 * computing U' and val' from -U in the same manner as for positive U.
	 * 
	 * The new values will then be
	 * 
	 * 		U' = remainder (( -U(i) * 5**(2*p+1)) // 2**n )
	 * 		U(i+1) = - U'
	 *		return val' = 1.0 - U' / (2**n-1)
	 *
	 * In this case the new value of U will also be negative,
	 * while the returned real still lies in the interval &lt;0,1>.
	 * 
	 * If the initial U is zero, U is replaced by System.currentTimeMillis()
	 * Then U is forced to be an odd number by: U = U | 1
	 * 
	 * See: Donald E. Knuth, The Art of Computer Programming, Volume 2,
	 *      Seminumerical Algorithms, Section 3.2.1.
	 * </pre>
	 * 
	 * @param U The pseudo random number (seed) by name.
	 * @return Returns the next pseudorandom, uniformly distributed value between
	 *         0.0 and 1.0
	 */
	public static double basicDRAW(final RTS_NAME<Integer> U) {
		long seed = U.get();
		if (seed == 0)
			seed = System.currentTimeMillis();
		if (seed > 0) {
			seed = ((seed | 1) * MULTIPLIER) % TWO_POW_31;
			U.put((int) seed);
			return (((double) seed) / TWO_POW_31M1D);
		} else { // Antithetic drawing
			seed = (((-seed) | 1) * MULTIPLIER) % TWO_POW_31;
			U.put((int) -seed);
			return (1.0d - ((double) seed) / TWO_POW_31M1D);
		}
	}

}
