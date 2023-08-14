/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import simula.runtime.RTS_RTObject.RTS_BOUNDS;

/**
 * Utility class ARRAY.
 * <p>
 * This class provides an abstract superclass for Simula arrays.
 * The implementation technique used is called 'dope vector indexing'. The dope vector is
 * calculated in the constructor based on the array bound pairs.
 * A fictitious base is also Calculated.
 * This base is the relative address of the array element (0,0, ... 0).
 * <p>
 * See <a href="https://portablesimula.github.io/github.io/doc/SimulaRTS.pdf">Mapping Simula to Java (runtime design)</a> 
 * Sect. 3.4 Array Quantities
 * <p>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_ARRAY.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public abstract class RTS_ARRAY {
	/**
	 * The initilal BOUND pairs
	 */
	public final RTS_BOUNDS[] BOUNDS;
	/**
	 * The initial calculated SIZE
	 */
	public final int SIZE;
	/**
	 *  The fictitious base. This base is the relative address of the array element (0,0, ... 0).
	 */
	private final int BASE;
	/**
	 * The DOPE Vector
	 */
	private final int[] DOPE;

	/**
	 * Create an _ARRAY with the given BOUNDS.
	 * 
	 * @param BOUNDS the ARRAY BOUNDS
	 */
	public RTS_ARRAY(final RTS_BOUNDS... BOUNDS) {
		this.BOUNDS = BOUNDS;
		DOPE = new int[BOUNDS.length];
		DOPE[0] = 1;
		int SIZE = BOUNDS[0].SIZE;
		int BASE = BOUNDS[0].LB * DOPE[0];
		for (int i = 1; i < BOUNDS.length; i++) {
			DOPE[i] = BOUNDS[i - 1].SIZE * DOPE[i - 1];
			BASE = BASE + BOUNDS[i].LB * DOPE[i];
			SIZE = SIZE * BOUNDS[i].SIZE;
		}
		this.SIZE = SIZE;
		this.BASE = BASE;
	}

	/**
	 * Returns the number of dimensions for this _ARRAY
	 * @return the number of dimensions
	 */
	public int nDim() {
		return (BOUNDS.length);
	}

	/**
	 * Return the size of the underlying ELT[] array
	 * @return the size of the underlying ELT[] array
	 */
	public int size() {
		return (SIZE);
	}

	/**
	 * The procedure "lowerbound" returns the lower (upper) bound of the dimension of
	 * the given array corresponding to the given index. The first dimension has index one, the next two,
	 * etc. An index less than one or greater than the number of dimensions of the given array constitutes
	 * a run time error
	 * @param i the given index
	 * @return lowerbound of index i
	 */
	public int lowerBound(int i) {
		return (BOUNDS[i].LB);
	}

	/**
	 * The procedure "upperbound" returns the lower (upper) bound of the dimension of
	 * the given array corresponding to the given index. The first dimension has index one, the next two,
	 * etc. An index less than one or greater than the number of dimensions of the given array constitutes
	 * a run time error
	 * @param i the given index
	 * @return upperbound of index i
	 */
	public int upperBound(int i) {
		return (BOUNDS[i].LB + BOUNDS[i].SIZE - 1);
	}

	/**
	 * Abstract method redefined for all subclass &lt;type>_ARRAY
	 * @return a copy of this _ARRAY
	 */
	public abstract RTS_ARRAY COPY();

	/**
	 * General method to calculate index to the ELT array.
	 * @param x the indicies
	 * @return the calculated index
	 */
	public int index(int... x) {
		int idx = 0;
		for (int k = 0; k < x.length; k++) {
			if (x[k] < lowerBound(k) || x[k] > upperBound(k))
				throw new RTS_SimulaRuntimeError(
						"Array index(" + (k + 1) + ") = " + x[k] + " is outside bounds " + BOUNDS[k]);
			idx = idx + (x[k] * DOPE[k]);
		}
		return (idx - BASE);
	}

	/**
	 * Returns a string representation of the object.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ARRAY");
		char sep = '[';
		for (int i = 0; i < BOUNDS.length; i++) {
			sb.append(sep).append(BOUNDS[i]);
			sep = ',';
		}
		sb.append("] nDIM=").append(BOUNDS.length);
		sb.append(", SIZE=").append(SIZE);
		sb.append(", BASE=").append(BASE);
		sb.append(", DOPE=");
		sep = '[';
		for (int i = 0; i < BOUNDS.length; i++) {
			sb.append(sep).append(DOPE[i]);
			sep = ',';
		}
		sb.append("]");
		return (sb.toString());
	}

}
