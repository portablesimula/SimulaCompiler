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
  

	protected static final boolean USE_DEPRECATED_QPS_METHODS=false; //true;

	public static class Option {
		public static boolean CODE_STEP_TRACING = false;// true;
		public static boolean BLOCK_TRACING = false;// true;
		public static boolean GOTO_TRACING = false;// true;
		public static boolean THREAD_TRACING = false;// true;
		public static boolean THREADSWAP_TRACING = false;// true;
		public static boolean QPS_TRACING = false; // true;
		public static boolean SML_TRACING = false; // true;
	}
	  
//  public static int nError;
//  public static void error(String msg)
//  { System.err.println(" Error: "+msg);
//    nError++;
//    BREAK("");
//  }
//
//  public static void FATAL_ERROR(String s)
//  { String msg="FATAL error - "+s;
//    System.err.println(msg);
//    try { throw new RuntimeException("FATAL error"); }
//    catch(Exception e) { e.printStackTrace(); }
//    System.exit(-1);
//  }

	public static void warning(String msg) { System.out.println("Simula Runtime Warning: "+msg); }
  
	public static void TRACE(String msg) {
		if (TRACING) {
			Thread THREAD$ = Thread.currentThread();
			System.out.println(THREAD$.toString() + ": " + msg);
			// printStaticContextChain();
			// RT.BREAK("CTX$="+CTX$.edString());
			// RT.ASSERT(CTX$.THREAD$!=null,"CTX$.THREAD$==null");
		}
	}
  
  public static void NOT_IMPLEMENTED(String s)
  { System.err.println("*** NOT IMPLEMENTED: "+s);
    BREAK("Continue ?");
  }
  
//  public static void EXIT()
//  { System.out.println("FORCED EXIT");
//    BREAK("FORCED EXIT");
//    System.exit(-1);
//  }
  
  public static void NoneCheck(Object x)
  { if(x==null) throw new RuntimeException("NONE-CHECK FAILED"); }

  
  public static void ASSERT(boolean test,String msg)
  { if(!test)
    { try { throw new RuntimeException("ASSERT("+msg+") -- FAILED"); }
      catch(Exception e) { e.printStackTrace(); }
      BREAK("Continue ?");
      //System.exit(-1);
    }
  }

  public static void BREAK(String msg)
  { if(BREAKING)
    { if(RT.Option.CODE_STEP_TRACING) {
    	System.out.println(msg+": <");
        try {Thread.sleep(2000); } catch(Exception e) { e.printStackTrace(); }
        return;
      }
	  System.out.println("BREAK: "+msg+"\nContinue ? -- (NO Response ? - re-run as .java)");
      { try
        { char c=(char)System.in.read();
          //System.err.println("INPUT "+c+"  "+(int)c);
          if(c=='Q'||c=='q')
          { //System.err.println("QUIT!");
            try { throw new RuntimeException("QUIT"); }
            catch(Exception e) { e.printStackTrace(); }
          }
          while(System.in.available()>0) System.in.read();
        }
        catch(Exception e) { e.printStackTrace();  System.exit(-1);}
      }
    }
  }
  
	// *********************************************************************
	// *** TRACING AND DEBUGGING UTILITIES
	// *********************************************************************
	
	public static void printStackTrace(int start) {
		StackTraceElement StackTraceElement[] = Thread.currentThread().getStackTrace();
		int n = StackTraceElement.length;
		for (int i = start; i < n; i++) {
			int line = StackTraceElement[i].getLineNumber();
			// String className=StackTraceElement[i].getClassName();
			String fileName = StackTraceElement[i].getFileName();
			String methodName = StackTraceElement[i].getMethodName();
			System.out.println("    IN " + methodName + ' ' + fileName + "(line " + line + ")");// +className);
		}
	}

	public static void printStaticChain(RTObject$ ins) {
		RTObject$ x = ins;
		System.out.println("*** STATIC CHAIN:");
		while (x != null) {
			boolean qps = x.isQPSystemBlock();
			boolean dab = x.isDetachable();
			System.out.println(" - " + x + "[QPSystemBlock=" + qps + ",detachable=" + dab + ",state=" + x.STATE$);
			x = x.SL$;
		}

	}  
	
	public static void printThreadList() {
		Thread[] t = new Thread[50];
		int i = Thread.enumerate(t);
		System.out.println("ACTIVE THREAD LIST:");
		for (int j = 0; j < i; j++) {
			Thread T = t[j];
			System.out.print("  - " + T);
			if (T == Thread.currentThread())
				System.out.print(" = CurrentThread");
			if (T == RTObject$.CUR$.THREAD$)
				System.out.print(" = CUR$.THREAD$");
			System.out.println();
		}
		System.out.println("-------------------");
	}  
  
}
