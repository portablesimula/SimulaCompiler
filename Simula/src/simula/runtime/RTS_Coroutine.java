/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.util.concurrent.Semaphore;

/**
 * Utility class Coroutine.
 *  <pre>
 *  Implementing Coroutines using Virtual Threads and Semaphores
 *
 *  public class Coroutine implements Runnable {
 *      public Coroutine(Runnable target)
 *		public static Coroutine getCurrentCoroutine()
 *      public final void run()
 *      public static void detach()
 *      public boolean isDone()
 *      ....
 *  }
 * 
 *  More info: https://wiki.openjdk.java.net/display/loom/Main
 * </pre>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_Coroutine.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public class RTS_Coroutine implements Runnable {
	
	/**
	 * The current Coroutine
	 */
	private static RTS_Coroutine current;
	
	/**
	 * The caller
	 */
	private RTS_Coroutine caller;
	
	/**
	 * True if all actions are done.
	 */
	private boolean done;
	
	/**
	 * The runnable target
	 */
	private Runnable target;
	
	/**
	 * The target thread
	 */
	private Thread targetThread;
	
	/**
	 * The caller thread
	 */
	private Thread callerThread;
	
	/**
	 * Semaphore used to suspend/resume main (platform) Thread
	 */
	private static Semaphore mainSemaphore = new Semaphore(0);
	
	/**
	 * Semaphore used to suspend/resume this coroutine's Thread
	 */
	private Semaphore semaphore = new Semaphore(0);
	
	/**
	 * Used to propagate exceptions to caller.
	 */
	public static RuntimeException _PENDING_EXCEPTION = null;

	/**
	 * The UncaughtExceptionHandler.
	 */
	Thread.UncaughtExceptionHandler uncaughtExceptionHandler = new Thread.UncaughtExceptionHandler() {
		public void uncaughtException(Thread thread, Throwable e) {
			if (e instanceof RuntimeException)
				_PENDING_EXCEPTION = (RuntimeException) e;
			else
				_PENDING_EXCEPTION = new RuntimeException(e);
			done = true;
			detach();
		}
	};

	/**
	 * Create a new Coroutine with the given target.
	 * 
	 * @param target a runnable target
	 */
	public RTS_Coroutine(Runnable target) {
		this.target = target;
	}

	/**
	 * Returns true if target is terminated.
	 * @return true if target is terminated
	 */
	public boolean isDone() {
		return (done);
	}

	/**
	 * Returns the current Coroutine.
	 * @return the current Coroutine
	 */
	public static RTS_Coroutine getCurrentCoroutine() {
		return current;
	}

	/**
	 * Start or resume this Coroutine.
	 */
	@Override
	public final void run() {
		if (isDone())
			throw new IllegalStateException("Coroutine terminated");
		if (caller != null) {
			if (caller != current)
				throw new IllegalStateException("caller != currentCoroutine");
		} else
			caller = current;
		current = this;
		callerThread = Thread.currentThread();
		if (targetThread == callerThread)
			throw new IllegalStateException(this.toString() + ".run: Coroutine is already running");
		if (targetThread == null) { // START VIRTUAL THREAD
			Runnable runner = new Runnable() {
				public void run() {
					target.run();
					done = true;
					detach();
				}
			};
//			if(_RT.Option.USE_VIRTUAL_THREAD) {
			targetThread = Thread.startVirtualThread(runner);
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
		current = this.caller;
	}

	/**
	 * Detach this Coroutine.
	 */
	public static void detach() {
		RTS_Coroutine cur = current;
		if (cur == null)
			throw new IllegalStateException("Not within a Coroutine");
		resume(cur.caller);
		if (!cur.isDone())
			suspend(cur);
	}

	// *********************************************************************
	// *** COROUTINE: suspend
	// *********************************************************************
	/**
	 * Suspend the given Coroutine
	 * @param coroutine the given Coroutine
	 */
	private static void suspend(RTS_Coroutine coroutine) {
		Semaphore semaphore = (coroutine == null) ? RTS_Coroutine.mainSemaphore : coroutine.semaphore;
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Continue here when the semaphore is released by 'resume'
		if (_PENDING_EXCEPTION != null) {
			RuntimeException t = _PENDING_EXCEPTION;
			_PENDING_EXCEPTION = null;
			throw (t);
		}
	}

	// *********************************************************************
	// *** COROUTINE: resume
	// *********************************************************************
	/**
	 * Resume the given Coroutine
	 * @param coroutine the given Coroutine
	 */
	private static void resume(RTS_Coroutine coroutine) {
		Semaphore semaphore = (coroutine == null) ? RTS_Coroutine.mainSemaphore : coroutine.semaphore;
		semaphore.release();
	}

	@Override
	public String toString() {
		return (target.getClass().getSimpleName());
	}

}
