package simula.runtime.loom;

import simula.runtime.RT;
import simula.runtime.RTObject$;

public class Continuation implements Runnable {
    private static final boolean DEBUG = false;//true;
    private static final boolean BREAKING = false;//true;
	private static Continuation currentContinuation;
    private ContinuationScope scope;
	private Continuation parent;
    private String ident;
//	private boolean done;
	private Runnable target;
	private Thread targetThread;
	private Thread callerThread;
	private RTObject$.UncaughtExceptionHandler uncaughtExceptionHandler;

	public Continuation(ContinuationScope scope, Runnable target) {
		this.scope=scope;
		this.target=target;
		//if(DEBUG) System.out.println("Continuation: NEW "+this);
	}

	public boolean isDone() {
		//return(done);
		if(targetThread==null) return(false);
		return(!targetThread.isAlive());
	}

    public static Continuation getCurrentContinuation(ContinuationScope scope) {
        Continuation cont = currentContinuation;
        while (cont != null && cont.scope != scope) cont = cont.parent;
        return cont;
    }
	
	public final void run() {
		if(DEBUG) System.out.println("Continuation("+ident+").run: BEGIN");
		if (isDone()) throw new IllegalStateException("Continuation terminated");
		if (parent != null) {
			//RT.BREAK(this.toString()+".run: parent="+parent);
			if (parent != currentContinuation) {
				//RT.BREAK(this.toString()+".run: currentContinuation="+currentContinuation);
				throw new IllegalStateException("parent != currentContinuation");
			}
		} else {
			this.parent = currentContinuation;
			//if(parent!=null) RT.BREAK(this.toString()+".run: parent <== "+parent);
		}
		currentContinuation=this;
		callerThread=Thread.currentThread();
		if(targetThread==null) {
//			callerThread=Thread.currentThread(); // TODO: CHECK !!!!
	    	if(BREAKING) RT.BREAK(this.toString()+".run: INIT="+target);
	    	targetThread=new Thread(target,ident);
//	    	targetThread.setUncaughtExceptionHandler(new RTObject$.UncaughtExceptionHandler());
	    	targetThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
	    	RTObject$.START_THREAD(targetThread);
	    	if(BREAKING) RT.BREAK(this.toString()+".run: RETURN after INIT="+target);
		} else {
	    	if(BREAKING) RT.BREAK(this.toString()+".run: RESUME="+target);
	    	RTObject$.swapThreads(targetThread);
	    	if(BREAKING) RT.BREAK(this.toString()+".run: RETURN after RESUME="+target);
		}
		// RETURNS HERE WHEN target Yields
		currentContinuation=this.parent;
//		if(BREAKING) RT.BREAK("Continuation("+ident+").run: RETURNS  done="+isDone());
	}
	
//	@SuppressWarnings("deprecation")
	public static void yield(ContinuationScope scope) {
		if(BREAKING) RT.BREAK("Continuation.yield: currentContinuation="+currentContinuation);
        Continuation cont=currentContinuation;
        while(cont != null && cont.scope != scope) cont=cont.parent;
        if (cont == null) throw new IllegalStateException("Not in scope " + scope);
    	if(BREAKING) RT.BREAK(cont.toString()+".yield: SUSPEND AND RETURN TO "+cont.callerThread);
    	RTObject$.swapThreads(cont.callerThread);        
    	if(BREAKING) RT.BREAK(cont.toString()+".yield: RETURN after SUSPEND AND RETURN TO "+cont.callerThread);
	}

	public void setUncaughtExceptionHandler(RTObject$.UncaughtExceptionHandler h) {
    	this.uncaughtExceptionHandler=h; this.ident=h.obj.edObjectIdent();		
	}
	
	public String toString() {
		return("Continuation("+ident+'['+scope+"])");
	}

}
