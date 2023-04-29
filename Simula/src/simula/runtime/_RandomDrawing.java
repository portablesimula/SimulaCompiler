package simula.runtime;

import simula.runtime._RTObject._NAME;

public class _RandomDrawing {
	
    private static final int    TWO_POW_31    = 0x80000000; // 2**31
    private static final double TWO_POW_31M1D = 0x7FFFFFFF; // 2**31 - 1
    private static final int    MULTIPLIER    = 1220703125; // 5**(2*6+1)

	/**
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
	 * while the returned real still lies in the interval <0,1>.
	 * 
	 * See: Donald E. Knuth, The Art of Computer Programming, Volume 2,
	 *      Seminumerical Algorithms, Section 3.2.1.
	 * </pre>
	 * 
	 * @param U The pseudo random number (seed) by name.
	 * @return Returns the next pseudorandom, uniformly distributed value between 0.0 and 1.0
	 * @throws _SimulaRuntimeError U is not an odd integer
	 */
	public static double basicDRAW(final _NAME<Integer> U) {
		long seed=U.get();
		if((seed & 1) == 0)
			throw new _SimulaRuntimeError("Basic Drawing: Seed("+seed+") is not an odd integer");
		if(seed > 0) {
			seed = (seed * MULTIPLIER) % TWO_POW_31;
			U.put((int) seed);
			return(((double)seed) / TWO_POW_31M1D); 
		} else { // Antithetic drawing
			seed = (-seed * MULTIPLIER) % TWO_POW_31;
			U.put((int) -seed);
			return( 1.0d - ((double)seed) / TWO_POW_31M1D ); 
		}
	}


	/**
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
	 * The returned real number is computed as U(i+1)/n.
	 * 
	 *
	 * If U is negative a socalled "antithetic drawing" should be obtained by
	 * computing U' and val' from -U in the same manner as for positive U.
	 * 
	 * The new values will then be
	 * 
	 * 		U' = remainder (( -U(i) * 5**(2*p+1)) // 2**n)
	 * 		U(i+1) = - U'
	 *		real val' := U'/n.
	 *		val' := if val' <> 0 then 1-val' else 0;
	 *
	 * In this case the new value of U will also be negative,
	 * while the returned real still lies in the interval [0,1>.
	 * 
	 * See: Donald E. Knuth, The Art of Computer Programming, Volume 2,
	 *      Seminumerical Algorithms, Section 3.2.1.
	 * </pre>
	 * 
	 * @param U The pseudo random number (seed) by name.
	 * @return A real number in the interval [0,1>, such that 0 <= val < 1.
	 */
	public static double basicDRAW1(_NAME<Integer> U) {
		long seed=U.get();
		if((seed & 1) == 0)
			throw new _SimulaRuntimeError("Basic Drawing: Seed is not an odd integer");
		if(seed > 0) {
			seed = (seed * MULTIPLIER) % TWO_POW_31;
			U.put((int) seed);
			return(((double)seed) / TWO_POW_31M1D); 
		} else { // Antithetic drawing
			seed = (-seed * MULTIPLIER) % TWO_POW_31;
			U.put((int) -seed);
			double val = ((double)seed) / TWO_POW_31M1D; 
			if(val==0) {
				System.out.println("_RandomDrawing.basicDRAW: seed="+seed+" ==> sample="+val);
				System.exit(0);
			}
			return( (val == 0)? 0 : 1.0d - val );
		}
	}

	public static void main(String[] args) {
		class ENCL extends _RTObject {
			public ENCL() {	super(null); }
		}

		_NAME<Integer> U=new ENCL().new _NAME<Integer>() {
			int val;
			public Integer put(final Integer x) { val=x; return(x); }
			public Integer get() { return(val); }
		};
		
//		test();
		U.put(-20155689);
//		U.put(455470315);
		
//		for(int i=0;i<Integer.MAX_VALUE;i++) {
		for(int i=0;i<200;i++) {
			int prev=U.get();
			double sample=basicDRAW(U);
			int next=U.get();
			System.out.println("_RandomDrawing.basicDRAW: seed="+prev+" ==> "+next+"  sample="+sample);
		}
		System.out.println("_RandomDrawing.basicDRAW: END");
	}
	
	private static void test() {
		for(int n=1;n<=30;n++) System.out.println("2**"+n+" = "+Long.toHexString(_ENVIRONMENT._IPOW_EXACT(2,n)));
		for(int p=1;p<=6;p++) System.out.println("5**(2*"+p+"+1) = "+_ENVIRONMENT._IPOW_EXACT(5,2*p+1));
		System.out.println("MAXINT="+Integer.MAX_VALUE);
//		System.out.println("0x7FFFFFFF  = "+0x7FFFFFFFL+" == 2**31 - 1");
//		System.out.println("0x7FFFFFFF  = "+0x7FFFFFFFL+" == 2**31 - 1");
//		System.out.println("0x100000000 = "+0x100000000L+" == "+TWO_POW_31L);
//		System.out.println("((double)0xFFFFFFFFL) / TWO_POW_31M1D = "+((double)0xFFFFFFFFL) / TWO_POW_31M1D);
//		System.out.println("((double)0xFFFFL) / TWO_POW_31M1D = "+((double)0xFFFFL) / TWO_POW_31M1D);
//		System.out.println("((double)0xFL) / TWO_POW_31M1D = "+((double)0xFL) / TWO_POW_31M1D);
//		System.out.println("((double)0L) / TWO_POW_31M1D = "+((double)0L) / TWO_POW_31M1D);
	}

}
