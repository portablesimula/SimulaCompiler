package aSimpleLoomTest;

import simula.runtime.RT;
import simula.runtime.ThreadUtils;

/**
 *  <pre>
 *  Implementing Coroutines using Virtual Threads
 *
 *  public class Coroutine implements Runnable {
 *      public Coroutine(Runnable target)
 *      public final void run()
 *      public static void detach()
 *      public boolean isDone()
 *      ....
 *  }
 * 
 *  More info: https://wiki.openjdk.java.net/display/loom/Main
 *     source: http://hg.openjdk.java.net/loom/loom/file/c3e1c6edebac/src/java.base/share/classes/java/lang/Continuation.java
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 *
 */
public class CoroutinePREV implements Runnable {
    private static final boolean BREAKING = false;//true;
    private static final boolean DEBUG = false;//true;
    private static final boolean TRACE = false;//true;
	private static CoroutinePREV current;
	private static int SEQU=0;
	private CoroutinePREV parent;
	private String ident="Ident";
	private boolean done;
	private Runnable target;
	private Thread targetThread;
	private Thread callerThread;
	public static RuntimeException PENDING_EXCEPTION$=null;
	
	Thread.UncaughtExceptionHandler uncaughtExceptionHandler=new Thread.UncaughtExceptionHandler() {
        public void uncaughtException(Thread thread, Throwable e) {
        	if(DEBUG) {
        		System.out.println("Thread["+thread.getName()+"]: UNCAUGHT EXCEPTION: "+e);
                e.printStackTrace(); ThreadUtils.printThreadList(); 
        	}
        	if(e instanceof RuntimeException) PENDING_EXCEPTION$=(RuntimeException)e;
        	else PENDING_EXCEPTION$=new RuntimeException(e);
            done=true; detach();
    }};

	public CoroutinePREV(Runnable target) {
		this(null,target);
	}
	
	public CoroutinePREV(String ident,Runnable target) {
		this.ident=ident;
		this.target=target;
//		if(this.ident==null) this.ident=getClass().getSimpleName()+'#'+(SEQU++);
		if(this.ident==null) this.ident=target.getClass().getSimpleName()+'#'+(SEQU++);
		if(DEBUG) System.out.println("Coroutine: NEW "+this);
	}

	public boolean isDone() {
		return(done);
	}

    public static CoroutinePREV getCurrentCoroutine() {
        return current;
    }
	
    static int count=0;
	public final void run() {
		if(DEBUG) System.out.println("Coroutine("+ident+").run: BEGIN");
		if (isDone()) throw new IllegalStateException("Coroutine terminated");
		if (parent != null) {
			if (parent != current) 
				throw new IllegalStateException("parent != currentContinuation");
		} else parent = current;
		current=this;
		callerThread=Thread.currentThread();
		if (targetThread==callerThread) throw new IllegalStateException(this.toString()+".run: Coroutine is already running");
		if(targetThread==null) { // START VIRTUAL THREAD
			if(BREAKING) BREAK(this.toString()+".run: INIT:"+target);
			Runnable runner=new Runnable() { public void run() {	target.run(); done=true; detach(); }};
			Thread current=Thread.currentThread();
			if(TRACE) System.out.println("Coroutine: START VIRTUAL THREAD: "+current.getName()+" ==> "+this.ident);
			prevThread=current;
			
			if(RT.Option.USE_VIRTUAL_THREAD) {
				targetThread=Thread.startVirtualThread(runner);
			} else {
				targetThread=new Thread(runner);
				targetThread.start();
			}
			targetThread.setName(""+ident);
			if(TRACE) System.out.println("Coroutine: TARGET THREAD(1): "+targetThread);
			
			targetThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);

			synchronized (current) {	// Suspend 'prev'
				try { current.wait(); } catch (InterruptedException e) { e.printStackTrace(); }
			}
			if(TRACE) System.out.println("Coroutine: TARGET THREAD(2): "+targetThread);
			waitUntilPrevThreadNotRunning();
			if(TRACE) System.out.println("Coroutine: TARGET THREAD(3): "+targetThread);
			wakeupThread(this.targetThread); // Continue here after suspend
			if(TRACE) System.out.println("Coroutine: TARGET THREAD(5): "+targetThread);
			//printStackTrace();

			if(BREAKING) BREAK(this.toString()+".run: RETURN after INIT:"+target);
		} else {
	    	if(BREAKING) BREAK(this.toString()+".run: CONTINUE:"+target);
	    	SWAP_THREAD(targetThread);
	    	if(BREAKING) BREAK(this.toString()+".run: RETURN after CONTINUE:"+target);
		}
		// RETURNS HERE WHEN target Yields
		current=this.parent;
	}

	public static void detach() {
		if(BREAKING) BREAK("Coroutine.datach: current="+current);
        CoroutinePREV cur=current;
        if (cur == null) throw new IllegalStateException("Not within a Coroutine");
        if(cur.isDone()) { // END THREAD
        	if(BREAKING) BREAK(cur.toString()+".detach: IS_DONE AND RETURN TO "+cur.callerThread);
        	Thread current=Thread.currentThread();
        	Thread next=cur.callerThread;
        	if(TRACE) System.out.println("Coroutine.END_THREAD: "+current.getName()+" ==> "+next.getName());
        	prevThread=current;
        	synchronized (next) { next.notify(); } // Resume 'next'
        } else {
        	if(BREAKING) BREAK(cur.toString()+".detach: SUSPEND AND RETURN TO "+cur.callerThread);
        	SWAP_THREAD(cur.callerThread);
        	if(BREAKING) BREAK(cur.toString()+".detach: RETURN after SUSPEND AND RETURN TO "+cur.callerThread);
        }
	}

	// *********************************************************************
	// *** BASIC PRIMITIVE: SWAP_THREAD
	// *********************************************************************
    private static void SWAP_THREAD(final Thread next) {
        Thread current=Thread.currentThread();
        if(TRACE) System.out.println("Coroutine.SWAP_THREAD: "+current.getName()+" ==> "+next.getName());
        prevThread=current;
        assert(next!=current);
        synchronized (next) { next.notify(); }	// Resume  'next'
        if(TRACE) System.out.println("Coroutine.SWAP_THREAD(2): "+current.getName()+" ==> "+next.getName());
        synchronized (current) {				// Suspend 'prev'
            if(TRACE) System.out.println("Coroutine.SWAP_THREAD(3): "+current.getName()+" ==> "+next.getName());
        	try { current.wait(); } catch (InterruptedException ex) { ex.printStackTrace(); }
        }
        if(TRACE) System.out.println("Coroutine.SWAP_THREAD(4): "+current.getName()+" ==> "+next.getName());
    	waitUntilPrevThreadNotRunning();
        wakeupThread(next); // Continue here after suspend
    }

	
	// *********************************************************************
	// *** THREAD: waitUntilPrevThreadNotRunning
	// *********************************************************************
    private static Thread prevThread;
    private static void waitUntilPrevThreadNotRunning() {
        if(prevThread!=null) {
        	int count=10; // To prevent DeadLock
        	while((count--)>0 && prevThread.getState()==Thread.State.RUNNABLE) {
        		try { Thread.sleep(0,1); } catch (InterruptedException e) { e.printStackTrace(); }
        	}
        	prevThread=null;
        }
    }

	// *********************************************************************
	// *** THREAD: wakeupThread
	// *********************************************************************
	private static void wakeupThread(final Thread next) {
		Thread curr=Thread.currentThread();
		if (TRACE) System.out.println("Coroutine.wakeupThread: WAKEUP "+curr);
		if (PENDING_EXCEPTION$ != null) {
			RuntimeException t = PENDING_EXCEPTION$;
			PENDING_EXCEPTION$ = null;
			if (TRACE) System.out.println("Coroutine.wakeupThread: Re-throw " + t);
			if(t!=null) throw (t);
		}
		if(DEBUG) {
			if (TRACE)	System.out.println("Coroutine.wakeupThread: END " + curr);
			assert(curr.getState()==Thread.State.RUNNABLE);
			while(next.getState()==Thread.State.RUNNABLE) Thread.yield();  
			assert(next.getState()!=Thread.State.RUNNABLE);
		}
	}

	public static void BREAK(final String title) {
		BREAK("BREAK", title);
	}

	public static void BREAK(final String id, final String title) {
		if(BREAKING) {
			try {
//				System.err.println(id + " " + Global.sourceLineNumber + ": " + title + ": <");
				System.out.println(id + ": " + title + ": <");
				char c=(char) System.in.read();
				if (c == 'Q' || c == 'q') {
					System.out.println("STACK-TRACE");
					printStackTrace();
				}
				while (System.in.available() > 0) System.in.read();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
	}

	public static void printStackTrace() {
		StackTraceElement stackTraceElement[] = Thread.currentThread().getStackTrace();
		int n = stackTraceElement.length;
		for (int i = 2; i < n; i++)
			System.out.println("   at "+stackTraceElement[i]);
	}
	
	public String toString() {
		return(ident);
	}

}
