/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import simula.runtime._RTObject._BOUNDS;

/*
 * See <a href="doc/SimulaRTS.pdf">Mapping Simula to Java (runtime design)</a> 
 * Sect. 3.4 Array Quantities
 * 
 * @author Øystein Myhre Andersen
 *
 */
public abstract class _ARRAY {
	public final _BOUNDS[] BOUNDS;
	public final int SIZE;
	private final int BASE;
	private final int[] DOPE;

	public _ARRAY(final _BOUNDS... BOUNDS) {
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

	public int nDim() {
		return (BOUNDS.length);
	}

	public int size() {
		return (SIZE);
	}

	public int lowerBound(int i) {
		return (BOUNDS[i].LB);
	}

	public int upperBound(int i) {
		return (BOUNDS[i].LB + BOUNDS[i].SIZE - 1);
	}

	public abstract _ARRAY COPY();

	public int index(int... x) {
		int idx = 0;
		for (int k = 0; k < x.length; k++) {
			if (x[k] < lowerBound(k) || x[k] > upperBound(k))
				throw new _SimulaRuntimeError(
						"Array index(" + (k + 1) + ") = " + x[k] + " is outside bounds " + BOUNDS[k]);
			idx = idx + (x[k] * DOPE[k]);
		}
		return (idx - BASE);
	}

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
