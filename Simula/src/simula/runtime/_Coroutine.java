package simula.runtime;

import java.util.concurrent.Semaphore;

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
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 *
 */
public class _Coroutine implements Runnable {
	private static _Coroutine current;
	private _Coroutine caller;
	private boolean done;
	private Runnable target;
	private Thread targetThread;
	private Thread callerThread;
    private static Semaphore mainSemaphore = new Semaphore(0); // Used to suspend/resume main (platform) Thread
    private Semaphore semaphore = new Semaphore(0);            // Used to suspend/resume this coroutine's Thread
    public static long threadCount;
	public static RuntimeException _PENDING_EXCEPTION=null;    // Used to propagate exceptions to caller
	
	Thread.UncaughtExceptionHandler uncaughtExceptionHandler=new Thread.UncaughtExceptionHandler() {
        public void uncaughtException(Thread thread, Throwable e) {
        	if(e instanceof RuntimeException) _PENDING_EXCEPTION=(RuntimeException)e;
        	else _PENDING_EXCEPTION=new RuntimeException(e);
            done=true; detach();
    }};

	public _Coroutine(Runnable target) {
		this.target=target;
	}

	public boolean isDone() {
		return(done);
	}

    public static _Coroutine getCurrentCoroutine() {
        return current;
    }
	
    static int count=0;
	@SuppressWarnings("preview")
	public final void run() {
		if (isDone()) throw new IllegalStateException("Coroutine terminated");
		if (caller != null) {
			if (caller != current) 
				throw new IllegalStateException("caller != currentCoroutine");
		} else caller = current;
		current=this;
		callerThread=Thread.currentThread();
		if (targetThread==callerThread) throw new IllegalStateException(this.toString()+".run: Coroutine is already running");
		if(targetThread==null) { // START VIRTUAL THREAD
			Runnable runner=new Runnable() { public void run() {
					target.run();
					done=true; detach();
				}};				
			threadCount++;
//			if(_RT.Option.USE_VIRTUAL_THREAD) {
				targetThread=Thread.startVirtualThread(runner);
//			} else {
//				targetThread=new Thread(runner);
//				targetThread.start();
//			}
			targetThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
		} else {
	        resume(this);
		}
		suspend(caller);			
		// Continue here after suspend
		current=this.caller;
	}

	public static void detach() {
        _Coroutine cur=current;
        if (cur == null) throw new IllegalStateException("Not within a Coroutine");
        resume(cur.caller);
        if(!cur.isDone()) suspend(cur);
	}

	
	// *********************************************************************
	// *** COROUTINE: suspend
	// *********************************************************************
    private static void suspend(_Coroutine coroutine) {
    	Semaphore semaphore=(coroutine==null)?_Coroutine.mainSemaphore:coroutine.semaphore;
 		try { semaphore.acquire(); } catch (InterruptedException e) { e.printStackTrace(); }
        // Continue here when the semaphore is released by 'resume'
		if (_PENDING_EXCEPTION != null) {
			RuntimeException t = _PENDING_EXCEPTION;
			_PENDING_EXCEPTION = null;
			if(t!=null) throw (t);
		}
    }
	
	// *********************************************************************
	// *** COROUTINE: resume
	// *********************************************************************
    private static void resume(_Coroutine coroutine) {
    	Semaphore semaphore=(coroutine==null)?_Coroutine.mainSemaphore:coroutine.semaphore;
    	semaphore.release();
    }
    
    public String toString() {
    	return(target.getClass().getSimpleName());
    }

}
