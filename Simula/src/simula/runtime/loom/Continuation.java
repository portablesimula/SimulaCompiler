package simula.runtime.loom;

import java.lang.IllegalStateException;
import java.lang.Runnable;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.System;
import java.lang.Thread;
import java.lang.Throwable;

import simula.runtime.RT;

/**
 *  <pre>
 *  Emulating Delimited Continuation using Threads
 *
 *  public class Continuation implements Runnable {
 *      public Continuation(ContinuationScope scope, Runnable target)
 *      public final void run()
 *      public static void yield(ContinuationScope scope)
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
public class Continuation implements Runnable {
    private static final boolean TESTING = false;//true;
    private static final boolean BREAKING = false;//true;
	private static Continuation currentContinuation;
	private static int SEQU=0;
    private ContinuationScope scope;
	private Continuation parent;
    private String ident="Ident";
	private boolean done;
	private Runnable target;
	private Thread targetThread;
	private Thread callerThread;
	
	private Thread.UncaughtExceptionHandler uncaughtExceptionHandler=new Thread.UncaughtExceptionHandler() {
        public void uncaughtException(Thread thread, Throwable e) {
        	if(TESTING) {
        		RT.println("Thread["+thread.getName()+"]: UNCAUGHT EXCEPTION: "+e);
                e.printStackTrace(); ThreadUtils.printThreadList(); 
        	}
        	if(e instanceof RuntimeException) ThreadUtils.PENDING_EXCEPTION$=(RuntimeException)e;
        	else ThreadUtils.PENDING_EXCEPTION$=new RuntimeException(e);
            done=true; yield(scope);
    }};

	public Continuation(ContinuationScope scope, Runnable target) {
		this.ident="Continuation#"+(SEQU++);
		this.scope=scope;
		this.target=target;
		if(TESTING) System.out.println("Continuation: NEW "+this);
	}

	public boolean isDone() {
		return(done);
	}

    public static Continuation getCurrentContinuation(ContinuationScope scope) {
        Continuation cont = currentContinuation;
        while (cont != null && cont.scope != scope) cont = cont.parent;
        return cont;
    }
	
	public final void run() {
		if(TESTING) System.out.println("Continuation("+ident+").run: BEGIN");
		if (isDone()) throw new IllegalStateException("Continuation terminated");
		if (parent != null) {
			if (parent != currentContinuation) 
				throw new IllegalStateException("parent != currentContinuation");
		} else parent = currentContinuation;
		currentContinuation=this;
		callerThread=Thread.currentThread();
		if (targetThread==callerThread) throw new IllegalStateException(this.toString()+".run: Continuation is already running");
		if(targetThread==null) {
	    	if(BREAKING) RT.BREAK(this.toString()+".run: INIT:"+target);
	    	Runnable runner=new Runnable() { public void run() {	target.run(); done=true; yield(scope); }};
	    	targetThread=new Thread(runner,ident);
	    	targetThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
	    	ThreadUtils.START_THREAD(targetThread);
	    	if(BREAKING) RT.BREAK(this.toString()+".run: RETURN after INIT:"+target);
		} else {
	    	if(BREAKING) RT.BREAK(this.toString()+".run: CONTINUE:"+target);
	    	ThreadUtils.SWAP_THREAD(targetThread);
	    	if(BREAKING) RT.BREAK(this.toString()+".run: RETURN after CONTINUE:"+target);
		}
		// RETURNS HERE WHEN target Yields
		currentContinuation=this.parent;
	}
	
	public static void yield(ContinuationScope scope) {
		if(BREAKING) RT.BREAK("Continuation.yield: currentContinuation="+currentContinuation);
        Continuation cont=currentContinuation;
        while(cont != null && cont.scope != scope) cont=cont.parent;
        if (cont == null) throw new IllegalStateException("Not in scope " + scope);
        if(cont.isDone()) {
        	if(BREAKING) RT.BREAK(cont.toString()+".yield: IS_DONE AND RETURN TO "+cont.callerThread);
        	ThreadUtils.END_THREAD(cont.callerThread);                	
        } else {
        	if(BREAKING) RT.BREAK(cont.toString()+".yield: SUSPEND AND RETURN TO "+cont.callerThread);
        	ThreadUtils.SWAP_THREAD(cont.callerThread);
        	if(BREAKING) RT.BREAK(cont.toString()+".yield: RETURN after SUSPEND AND RETURN TO "+cont.callerThread);
        }
	}
	
	public String toString() {
		return(ident+'['+scope+"]");
	}

}
