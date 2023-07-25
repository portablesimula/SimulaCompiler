/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package make.setup;

/**
 * A set of all static Utility Methods
 */
public final class Util { 

	public static void IERR(final String msg) {
		System.out.println("Internal error - " + msg);
		Thread.dumpStack();
		System.exit(-1);
	}

	public static void println(final String s) {
		System.out.println(s);
	}  
  
  
}
