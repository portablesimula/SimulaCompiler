package aSimpleLoomTest;

import java.util.concurrent.Semaphore;

import simula.runtime.RT;
import simula.runtime.ThreadUtils;

//import simula.runtime.ThreadUtils;

public class Koroutine implements Runnable {
    private static final boolean USE_SEMAPHORE = true;//false;//true;
    private static final boolean BREAKING = true;//false;//true;
    private static final boolean DEBUG = true;//false;//true;
    private static final boolean TRACE = true;//false;//true;
	private static Koroutine current;
	private static int SEQU=0;
	private Koroutine caller;
	private String ident="Ident";
	private boolean done;
	private Runnable target;
	private Thread targetThread;
	private Thread callerThread;
    static Semaphore mainSemaphore = new Semaphore(0);
    private Semaphore semaphore = new Semaphore(0);
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

	public Koroutine(Runnable target) {
		this(null,target);
	}
	
	public Koroutine(String ident,Runnable target) {
		this.ident=ident;
		this.target=target;
//		if(this.ident==null) this.ident=getClass().getSimpleName()+'#'+(SEQU++);
		if(this.ident==null) this.ident=target.getClass().getSimpleName()+'#'+(SEQU++);
		if(DEBUG) System.out.println("Coroutine: NEW "+this);
	}

	public boolean isDone() {
		return(done);
	}

    public static Koroutine getCurrentCoroutine() {
        return current;
    }
	
    static int count=0;
	public final void run() {
		if(DEBUG) System.out.println("Coroutine("+ident+").run: BEGIN");
		if (isDone()) throw new IllegalStateException("Coroutine terminated");
		if (caller != null) {
			if (caller != current) 
				throw new IllegalStateException("caller != currentContinuation");
		} else caller = current;
		current=this;
		callerThread=Thread.currentThread();
		prevThread=Thread.currentThread();
		if (targetThread==callerThread) throw new IllegalStateException(this.toString()+".run: Coroutine is already running");
		if(targetThread==null) { // START VIRTUAL THREAD
			if(BREAKING) BREAK(this.toString()+".run: INIT:"+target);
			
			Runnable runner=new Runnable() { public void run() { target.run(); done=true; detach(); }};				
			
			if(TRACE) System.out.println("Coroutine: START VIRTUAL THREAD: "+prevThread.getName()+" ==> "+this.ident);
			if(RT.Option.USE_VIRTUAL_THREAD) {
				targetThread=Thread.startVirtualThread(runner);
			} else {
				targetThread=new Thread(runner);
				targetThread.start();
			}
			targetThread.setName(""+ident);
			targetThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);

		} else {
	    	if(BREAKING) BREAK(this.toString()+".run: CONTINUE:"+target);
	    	//SWAP_THREAD(targetThread);
	        if(TRACE) System.out.println("Coroutine.run: "+prevThread.getName()+" ==> "+targetThread.getName());
	        assert(targetThread!=prevThread);
			if(USE_SEMAPHORE) {
//				resume(caller);
				resume(this);
			} else {
				synchronized (targetThread) { targetThread.notify(); }	// Resume  'nextThread'
			}
		}
		
		if(USE_SEMAPHORE) {
			suspend(caller);			
		} else {
			synchronized (prevThread) {				// Suspend 'prev'
				try { prevThread.wait(); } catch (InterruptedException ex) { ex.printStackTrace(); }
			}
			waitUntilThreadNotRunning(prevThread);
		}
    	
        wakeupThread(targetThread); // Continue here after suspend
    	if(BREAKING) BREAK(this.toString()+".run: RETURNS HERE WHEN target Yields: target="+target);
		current=this.caller;
	}

	public static void detach() {
		if(BREAKING) BREAK("Coroutine.detach: current="+current);
        Koroutine cur=current;
        if (cur == null) throw new IllegalStateException("Not within a Coroutine");
    	Thread nextThread=cur.callerThread;
    	prevThread=Thread.currentThread();
        assert(nextThread!=prevThread);
		if(USE_SEMAPHORE) {
			resume(cur.caller);
		} else {
			synchronized (nextThread) { nextThread.notify(); }	// Resume  'nextThread'
		}
    	if(BREAKING) BREAK(cur.toString()+".detach: RETURN TO "+cur.callerThread);
        if(TRACE) System.out.println("Koroutine.detach: "+prevThread.getName()+" ==> "+nextThread.getName());
        if(!cur.isDone()) {
			if(USE_SEMAPHORE) {
	        	suspend(cur);
			} else {
	            synchronized (prevThread) {				// Suspend 'prev'
	            	try { prevThread.wait(); } catch (InterruptedException ex) { ex.printStackTrace(); }
	            }
	        	waitUntilThreadNotRunning(prevThread);				
			}
        	
            wakeupThread(nextThread); // Continue here after suspend
        }
    	if(BREAKING) BREAK(cur.toString()+".detach: RETURN after RETURN TO "+cur.callerThread);
	}

	
	// *********************************************************************
	// *** COROUTINE: suspend
	// *********************************************************************
    private static void suspend(Koroutine coroutine) {
    	Semaphore semaphore=(coroutine==null)?Koroutine.mainSemaphore:coroutine.semaphore;
    	if(BREAKING) BREAK("Coroutine.suspend: Stop on "+((coroutine==null)?"Main":"Coroutine")+" Semaphore="+semaphore);
 		try { semaphore.acquire(); } catch (InterruptedException e) { e.printStackTrace(); }
    	if(BREAKING) BREAK("Coroutine.suspend: Continue "+((coroutine==null)?"Main":"Coroutine")+" Semaphore="+semaphore);
    }
	
	// *********************************************************************
	// *** COROUTINE: resume
	// *********************************************************************
    private static void resume(Koroutine coroutine) {
    	Semaphore semaphore=(coroutine==null)?Koroutine.mainSemaphore:coroutine.semaphore;
    	if(BREAKING) BREAK("Coroutine.resume: Release "+((coroutine==null)?"Main":"Coroutine")+" Semaphore="+semaphore);
    	semaphore.release();
    	if(BREAKING) BREAK("Coroutine.resume: After Release "+((coroutine==null)?"Main":"Coroutine")+" Semaphore="+semaphore);
    }
	
	// *********************************************************************
	// *** THREAD: waitUntilPrevThreadNotRunning
	// *********************************************************************
    private static Thread prevThread;
    private static void waitUntilThreadNotRunning(Thread prevThread) {
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
	
	
    public static void main(String[] args) {
//    	try { mainSemaphore.acquire(); } catch (InterruptedException e) { e.printStackTrace(); }
    	if(BREAKING) BREAK("Coroutine.main: BEGIN MainSemaphore="+mainSemaphore);
//    		example1();
//    		example2();
    		example1();
    }

	// *********************************************************************
	// *** EXAMPLE 1: Co-routine with three active phases:
	// *********************************************************************

    public static void example1() {
    	
    	RT.Option.USE_VIRTUAL_THREAD=false;
    	
    	Koroutine corut=new Koroutine("Test",new Runnable() {
			public void run() {
				System.out.println("Part 1 - Statements");
				Koroutine.detach(); // DETACH 1
				System.out.println("Part 2 - Statements");
				Koroutine.detach(); // DETACH 2
				System.out.println("Part 3 - Statements");
			}});
		
		
//    	try {
//    		mainLock.lock();
    		corut.run(); // Vil utføre Part 1.
    		System.out.println("Returns here after first DETACH(Yield)");
    		corut.run(); // Vil utføre Part 2.
    		System.out.println("Returns here after second DETACH(Yield)");
    		corut.run(); // Vil utføre Part 3.
    		System.out.println("Returns here after 'FINAL END'");
    		System.out.println("Next line should be: IllegalStateException: Continuation terminated");
    		corut.run(); // IllegalStateException: Continuation terminated
//    	} finally { mainLock.unlock(); }
	}


}
