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
 *
 */
public final class RT
{ 
  private static final boolean BREAKING=true;//false;//true;
  private static final boolean TRACING=true;//false;//true;
  
  public static int numberOfEditOverflows;

  public static TerminateException EXIT_EXCEPTION$ = new TerminateException("EXIT");

	public static class Option {
		public static boolean CODE_STEP_TRACING = false;// true;
		public static boolean BLOCK_TRACING = false;// true;
		public static boolean GOTO_TRACING = false;// true;
		public static boolean THREAD_TRACING = false;// true;
		public static boolean THREADSWAP_TRACING = false;// true;
		public static boolean QPS_TRACING = false; // true;
		public static boolean SML_TRACING = false; // true;
	}
	  
	
    
	// ************************************************************
	// *** TerminateException
	// ************************************************************
	static class TerminateException extends RuntimeException
	{ static final long serialVersionUID=1234;
	  public TerminateException(String msg) { super(msg); }
	}

	public static void println(String s) {
		System.out.println(s);
	}
	
	public static void warning(String msg) {
		println("Simula Runtime Warning: "+msg);
		ENVIRONMENT$.printStackTrace(0);
	}
  
	public static void TRACE(String msg) {
		if (TRACING) {
			Thread THREAD$ = Thread.currentThread();
			println(THREAD$.toString() + ": " + msg);
			// printStaticContextChain();
			// RT.BREAK("CTX$="+CTX$.edString());
			// RT.ASSERT(CTX$.THREAD$!=null,"CTX$.THREAD$==null");
		}
	}
  
	// SIMULA RUNTIME ERROR: NOT IMPLEMENTED:
	public static void NOT_IMPLEMENTED(String s) {
		System.err.println("*** NOT IMPLEMENTED: " + s);
		BREAK("Continue ?");
	}

	public static void NoneCheck(Object x) {
		if (x == null)
			throw new RuntimeException("NONE-CHECK FAILED");
	}
  
	public static void ASSERT(boolean test, String msg) {
		if (!test) {
			try {
				throw new RuntimeException("ASSERT(" + msg + ") -- FAILED");
			} catch (Exception e) {
				e.printStackTrace();
			}
			BREAK("Continue ?");
			// System.exit(-1);
		}
	}

	public static void ASSERT_CUR$(RTObject$ obj, String msg) {
		if (RTObject$.CUR$ != obj) {
			// println("RTObject.EBLK: CUR$="+CUR$.edObjectIdent());
			// println("RTObject.EBLK: this="+this.edObjectIdent());
			println(msg + ": CUR$=" + RTObject$.CUR$.edObjectAttributes());
			println(msg + ":  obj=" + obj.edObjectAttributes());
			RT.ASSERT(RTObject$.CUR$ == obj, msg);
		}
	}

	public static void BREAK(String msg) {
		if (BREAKING) {
			if (RT.Option.CODE_STEP_TRACING) {
				println(msg + ": <");
				try { Thread.sleep(2000);
				} catch (Exception e) {	e.printStackTrace(); }
				return;
			}
			println("BREAK: " + msg + "\nContinue ? -- (NO Response ? - re-run as .java)");
			try {
				char c = (char) System.in.read();
				// System.err.println("INPUT "+c+" "+(int)c);
				if (c == 'Q' || c == 'q') { // System.err.println("QUIT!");
					try {
						throw new RuntimeException("QUIT");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				while (System.in.available() > 0)
					System.in.read();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
	}

	// *********************************************************************
	// *** TRACING AND DEBUGGING UTILITIES
	// *********************************************************************

    public static void testCurrentThread() {
    	if(Thread.currentThread()!=RTObject$.CUR$.THREAD$) {
    		ENVIRONMENT$.printThreadList(true);
    	}
    }
  
	public static void printStaticChain(RTObject$ ins) {
		RTObject$ x = ins;
		println("*** STATIC CHAIN:");
		while (x != null) {
			boolean qps = x.isQPSystemBlock();
			boolean dab = x.isDetachable();
			println(" - " + x + "[QPSystemBlock=" + qps + ",detachable=" + dab + ",state=" + x.STATE$);
			x = x.SL$;
		}

	}  
  
}
