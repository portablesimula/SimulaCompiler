package simula.runtime;

import java.lang.Thread;

/**
 * Thread Utilities used by Continuation and old fashion Component Threads in _RTObect.
 *
 * @author Øystein Myhre Andersen
 *
 */
public class _ThreadUtils {
	
	// **********************************************************************
	// *** Debugging utility: Procedure printThreadList
	// **********************************************************************
	public static void printThreadList() {
		printThreadList(false);
	}
	
	public static synchronized void printThreadList(boolean withStackTrace) {
		Thread[] t = new Thread[50];
		int i = Thread.enumerate(t);
		_RT.println("ACTIVE THREAD LIST:");
		for (int j = 0; j < i; j++) {
			Thread T = t[j];
			String msg="  - " + T;
			if (T == Thread.currentThread())
				msg=msg+" = CurrentThread";
			_RT.println(msg+"   STATE="+T.getState());
			if(withStackTrace) {
				_RT.printSimulaStackTrace(T,0);
				_RT.println("");
			}
		}
		//_RT.ASSERT(Thread.currentThread()==_CUR._THREAD,"Invariant: Thread.currentThread()==_CUR._THREAD");
		_RT.println("-----------------------------------------------------------------------------------------------");
	}  

	public static void printStackTrace() {
		StackTraceElement stackTraceElement[] = Thread.currentThread().getStackTrace();
		int n = stackTraceElement.length;
		for (int i = 2; i < n; i++)
			_RT.println("   at "+stackTraceElement[i]);
	}

}
