/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.nio.charset.Charset;

/**
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class RT { 
	private static final boolean BREAKING=true;//false;//true;
	private static final boolean TRACING=true;//false;//true;
	public static final boolean USE_QPS_LOOM=false;//true;//false;
  
	public static RTConsole console;
  
	public static int numberOfEditOverflows;

	public static TerminateException EXIT_EXCEPTION$ = new TerminateException("EXIT");

	public static class Option {
		public static boolean VERBOSE = false;//true;
		public static boolean USE_CONSOLE=false;//true;
		public static boolean CODE_STEP_TRACING = false;// true;
		public static boolean BLOCK_TRACING = false;// true;
		public static boolean GOTO_TRACING = false;// true;
		public static boolean THREAD_TRACING = false;// true;
		public static boolean THREADSWAP_TRACING = false;// true;
		public static boolean QPS_TRACING = false; // true;
		public static boolean SML_TRACING = false; // true;
	}
	  
	public static void setRuntimeOptions(String[] args) {

		for(int i=0;i<args.length;i++) {
			System.out.println("RT.setRuntimeOptions: arg="+args[i]);
			String arg=args[i];
			if(arg.equalsIgnoreCase("-VERBOSE")) Option.VERBOSE=true;
			if(arg.equalsIgnoreCase("-USE_CONSOLE")) Option.USE_CONSOLE=true;
			if(arg.equalsIgnoreCase("-CODE_STEP_TRACING")) Option.CODE_STEP_TRACING=true;
			if(arg.equalsIgnoreCase("-BLOCK_TRACING")) Option.BLOCK_TRACING=true;
			if(arg.equalsIgnoreCase("-GOTO_TRACING")) Option.GOTO_TRACING=true;
			if(arg.equalsIgnoreCase("-THREAD_TRACING")) Option.THREAD_TRACING=true;
			if(arg.equalsIgnoreCase("-THREADSWAP_TRACING")) Option.THREADSWAP_TRACING=true;
			if(arg.equalsIgnoreCase("-QPS_TRACING")) Option.QPS_TRACING=true;
			if(arg.equalsIgnoreCase("-SML_TRACING")) Option.SML_TRACING=true;
		}
		//listRuntimeOptions();
	}
		  
	public static void listRuntimeOptions() {
		System.out.println("file.encoding="+System.getProperty("file.encoding"));
		System.out.println("defaultCharset="+Charset.defaultCharset());
		System.out.println("VERBOSE="+Option.VERBOSE);
		System.out.println("USE_CONSOLE="+Option.USE_CONSOLE);
		System.out.println("CODE_STEP_TRACING="+Option.CODE_STEP_TRACING);
		System.out.println("BLOCK_TRACING="+Option.BLOCK_TRACING);
		System.out.println("GOTO_TRACING="+Option.GOTO_TRACING);
		System.out.println("THREAD_TRACING="+Option.THREAD_TRACING);
		System.out.println("THREADSWAP_TRACING="+Option.THREADSWAP_TRACING);
		System.out.println("QPS_TRACING="+Option.QPS_TRACING);
		System.out.println("SML_TRACING="+Option.SML_TRACING);
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
		if(console!=null) console.write(s+'\n');
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
		println("*** NOT IMPLEMENTED: " + s);
		BREAK("Press [ENTER] Continue or [Q] for a Stack-Trace");
	}

	public static void NoneCheck(Object x) {
		if (x == null && !RTObject$.SHUTING_DOWN$)
			throw new RuntimeException("NONE-CHECK FAILED");
	}
  
	public static void ASSERT(boolean test, String msg) {
		if (!test) {
			println("ASSERT(" + msg + ") -- FAILED");
			BREAK("Press [ENTER] Continue or [Q] for a Stack-Trace");
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
			println("BREAK: " + msg);
		    InFile$ sysin=RTObject$.SYSIN$;
			if(console!=null) {
//				try {
				    sysin.inimage();
				    char c=sysin.inchar();
					if (c == 'Q' || c == 'q') { // System.err.println("QUIT!");
						println("STACK-TRACE");
						printStackTrace();
						ENVIRONMENT$.printStackTrace(2);
					}
//				} catch (Exception e) {
//					e.printStackTrace();
//					System.exit(-1);
//				}
			}
		}
	}

	public static void printStackTrace() {
		StackTraceElement stackTraceElement[] = Thread.currentThread().getStackTrace();
		int n = stackTraceElement.length;
		for (int i = 2; i < n; i++)
			println("   at "+stackTraceElement[i]);
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
