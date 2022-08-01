package simula.runtime;

import java.lang.Thread;

/**
 * Thread Utilities used by Continuation and old fashion Component Threads in RTObect$.
 *
 * @author Øystein Myhre Andersen
 *
 */
public class ThreadUtils {
	
	// **********************************************************************
	// *** Debugging utility: Procedure printThreadList
	// **********************************************************************
	public static void printThreadList() {
		printThreadList(false);
	}
	
	public static synchronized void printThreadList(boolean withStackTrace) {
		Thread[] t = new Thread[50];
		int i = Thread.enumerate(t);
		RT.println("ACTIVE THREAD LIST:");
		for (int j = 0; j < i; j++) {
			Thread T = t[j];
			String msg="  - " + T;
			if (T == Thread.currentThread())
				msg=msg+" = CurrentThread";
			RT.println(msg+"   STATE="+T.getState());
			if(withStackTrace) {
				RT.printSimulaStackTrace(T,0);
				RT.println("");
			}
		}
		//RT.ASSERT(Thread.currentThread()==CUR$.THREAD$,"Invariant: Thread.currentThread()==CUR$.THREAD$");
		RT.println("-----------------------------------------------------------------------------------------------");
	}  

	public static void printStackTrace() {
		StackTraceElement stackTraceElement[] = Thread.currentThread().getStackTrace();
		int n = stackTraceElement.length;
		for (int i = 2; i < n; i++)
			RT.println("   at "+stackTraceElement[i]);
	}

}
