package simula.runtime.loom;

import java.lang.InterruptedException;
import java.lang.RuntimeException;
import java.lang.Thread;

import simula.runtime.RT;
import simula.runtime.RTObject$;

/**
 * Thread Utilities used by Continuation and old fashion Component Threads in RTObect$.
 *
 * @author Øystein Myhre Andersen
 *
 */
public class ThreadUtils {
	public static RuntimeException PENDING_EXCEPTION$=null;

    
	// *********************************************************************
	// *** BASIC PRIMITIVE: START_THREAD
	// *********************************************************************
    public static void START_THREAD(final Thread next) {
//    	if(RT.DEBUGGING)
    		checkThreads(next);
        Thread current=Thread.currentThread();
        if(RT.Option.THREAD_TRACING) RT.TRACE("Continuation.START_THREAD: "+current.getName()+" ==> "+next.getName());
        prevThread=current;
        next.start();				// Start   'next'
        synchronized (current) {	// Suspend 'prev'
        	try { current.wait(); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        //System.out.println("Continuation.START_THREAD: CONTINUE: "+prev.getName());
    	waitUntilPrevThreadNotRunning();
        wakeupThread(next); // Continue here after suspend
    }
    
	// *********************************************************************
	// *** BASIC PRIMITIVE: SWAP_THREAD
	// *********************************************************************
    public static void SWAP_THREAD(final Thread next) {
//    	if(RT.DEBUGGING)
    		checkThreads(next);
        Thread current=Thread.currentThread();
        if(RT.Option.THREAD_TRACING) RT.TRACE("Continuation.SWAP_THREAD: "+current.getName()+" ==> "+next.getName());
        prevThread=current;
        RT.ASSERT(next!=current,"Continuation.SWAP_THREAD: next==current: "+current.getName());
        synchronized (next) { next.notify(); }	// Resume  'next'
        synchronized (current) {				// Suspend 'prev'
        	try { current.wait(); } catch (InterruptedException ex) { ex.printStackTrace(); }
        }
        //System.out.println("Continuation.SWAP_THREAD: CONTINUE: "+current.getName());
    	waitUntilPrevThreadNotRunning();
        wakeupThread(next); // Continue here after suspend
    }

	// *********************************************************************
	// *** BASIC PRIMITIVE: END_THREAD
	// *********************************************************************
	public static void END_THREAD(final Thread next) { 
//    	if(RT.DEBUGGING)
    		checkThreads(next);
        Thread current=Thread.currentThread();
        if(RT.Option.THREAD_TRACING) RT.TRACE("Continuation.END_THREAD: "+current.getName()+" ==> "+next.getName());
        prevThread=current;
		synchronized (next) { next.notify(); } // Resume 'next'
		// Let currentThread return from run()
        //System.out.println("Continuation.END_THREAD: CONTINUE: "+prev.getName());
    }
    
	// *********************************************************************
	// *** THREAD: waitUntilPrevThreadNotRunning
	// *********************************************************************
    private static Thread prevThread;
    private static void waitUntilPrevThreadNotRunning() {
        if(prevThread!=null) {
//        	int count=10; // To prevent DeadLock
//        	while((count--)>0 && prevThread.getState()==Thread.State.RUNNABLE) {
//        		//Thread.yield(); 
//        		try { Thread.sleep(0,1); } catch (InterruptedException e) { e.printStackTrace(); }
//        		//try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
//        	}
//    		if(prevThread.getState()==Thread.State.RUNNABLE) {
//    			System.out.println("****************** ERROR: waitUntilPrevThreadNotRunning FAILED ******************");
//    			System.out.println("Current Thread: "+Thread.currentThread()+", State="+Thread.currentThread().getState());
//    			System.out.println("Prev    Thread: "+prevThread+", State="+prevThread.getState());
//    		}
    		waitUntilThreadNotRunning(prevThread);
        	prevThread=null;
        }
    }
    
	// *********************************************************************
	// *** THREAD: waitUntilThreadNotRunning
	// *********************************************************************
    private static void waitUntilThreadNotRunning(Thread thread) {
    	int count=10; // To prevent DeadLock
    	int nano=1;
    	while((count--)>0 && thread.getState()==Thread.State.RUNNABLE) {
    		//Thread.yield(); 
    		try { Thread.sleep(0,nano); } catch (InterruptedException e) { e.printStackTrace(); }
    		//try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
    		nano=nano*4; // Sleep longer and longer ...
    	}
    	if(thread.getState()==Thread.State.RUNNABLE) {
    		System.out.println("****************** ERROR: waitUntilThreadNotRunning("+nano+") FAILED ******************");
    		System.out.println("Current Thread: "+Thread.currentThread()+", State="+Thread.currentThread().getState());
    		System.out.println("This    Thread: "+thread+", State="+thread.getState());
    	}
    }

	// *********************************************************************
	// *** THREAD: wakeupThread
	// *********************************************************************
	private static void wakeupThread(final Thread next) {
		//checkMaxOneRunableSimulaThread();
		Thread curr=Thread.currentThread();
		if (RT.Option.THREAD_TRACING) RT.TRACE("Continuation.wakeupThread: WAKEUP "+curr);
		if (PENDING_EXCEPTION$ != null) {
			RuntimeException t = PENDING_EXCEPTION$;
			PENDING_EXCEPTION$ = null;
			if (RT.Option.GOTO_TRACING) RT.TRACE("Continuation.wakeupThread: Re-throw " + t);
			if(t!=null) throw (t);
		}
		if(RT.DEBUGGING) {
			if (RT.Option.THREAD_TRACING)	RT.TRACE("Continuation.wakeupThread: END " + curr);
			//if (RT.Option.THREAD_TRACING)	RT.printThreadList();
			// RT.TRACE("END swapThread: PREV="+curr+", Thread.STATE="+prev.getState());
			// RT.TRACE("END swapThread: NEXT="+next+", Thread.STATE="+next.getState());
			RT.ASSERT(curr.getState()==Thread.State.RUNNABLE,"Continuation.wakeupThread: Invariant-3");
			while(next.getState()==Thread.State.RUNNABLE) Thread.yield();  
			RT.ASSERT(next.getState()!=Thread.State.RUNNABLE,"Continuation.wakeupThread: Invariant-4");
			//checkMaxOneRunableSimulaThread();
		}
	}
	
	// *********************************************************************
	// *** THREAD: checkThreads - current running and next not running
	// *********************************************************************
	private static boolean alreadyGotInvariant2=false;
	private static void checkThreads(final Thread next) {
		Thread prev=Thread.currentThread();
		// RT.TRACE("BEGIN swapThread: PREV="+prev+", Thread.STATE="+prev.getState());
		// RT.TRACE("BEGIN swapThread: NEXT="+next+", Thread.STATE="+next.getState());
		if(RT.DEBUGGING) RT.ASSERT(prev.getState()==Thread.State.RUNNABLE,"Continuation.swapThreads: Invariant-1");

		//RT.ASSERT(next.getState()!=Thread.State.RUNNABLE,"Continuation.swapThreads: Invariant-2"); // DENNE KOMMER HOS EYVIND, KAREL og GUNNAR ?
		if(next.getState()==Thread.State.RUNNABLE) {
			waitUntilThreadNotRunning(next);
			if(next.getState()==Thread.State.RUNNABLE) {
				System.out.println("****************** ERROR: Continuation.swapThreads: Invariant-2 FAILED ******************");
				System.out.println("Current Thread: "+Thread.currentThread()+", State="+Thread.currentThread().getState());
				System.out.println("Next    Thread: "+next+", State="+next.getState());
				if(next.getState()==Thread.State.RUNNABLE) {
					RT.println("****************** REPEATED ERROR: Continuation.swapThreads: Invariant-2 FAILED ******************");
					RT.println("Current Object: "+RTObject$.CUR$.edObjectAttributes());
					RT.printStaticChain(RTObject$.CUR$);
					RT.println("Current Thread: "+Thread.currentThread()+", State="+Thread.currentThread().getState());
					RT.println("Next    Thread: "+next+", State="+next.getState());
					printStackTrace();
					printThreadList(true);
					RT.println("***********************************************************************************************");
					if(!alreadyGotInvariant2) RT.BREAK("Continue ?"); alreadyGotInvariant2=true;
				}
			}
		}
	}
	
	

//	// **********************************************************************
//	// *** Debugging utility: checkMaxOneRunableSimulaThread
//	// **********************************************************************
//	private static synchronized void checkMaxOneRunableSimulaThread() {
//		Thread[] t = new Thread[50];
//		Thread[] runnable=new Thread[50];
//		int i = Thread.enumerate(t);
//		int nRun=0;
//		for (int j = 0; j < i; j++) {
//			Thread T = t[j];
//			if(T.getState()==Thread.State.RUNNABLE) {
//				runnable[nRun]=T;
//				nRun++;
//			}
//		}
//		if(nRun!=1) {
//			RT.println("*** CHECKING MAX ONE RUNABLE SIMULA THREAD: ***");
//			RT.println("IMPOSSIBLE SITUATION: Number of RUNNABLE SimulaTherads = "+nRun);
//			for(int k=0;k<nRun;k++)
//			{ Thread T=runnable[k];
//				String msg="  - " + T;
//				if (T == Thread.currentThread())
//					msg=msg+" = CurrentThread";
//				if (T == RTObject$.CUR$.THREAD$)
//					msg=msg+" = CUR$.THREAD$";
//				RT.println(msg+"   STATE="+T.getState());
//				
//			}
//			printThreadList(true);
//			//Util.BREAK("IMPOSSIBLE SITUATION: Number of RUNNABLE SimulaTherads = "+nRun);
//			System.exit(-1);
//		}
//		//RT.ASSERT(Thread.currentThread()==CUR$.THREAD$,"Invariant: Thread.currentThread()==CUR$.THREAD$");
//	}  

	
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
//			if (T == RTObject$.CUR$.THREAD$)
//				msg=msg+" = CUR$.THREAD$";
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
