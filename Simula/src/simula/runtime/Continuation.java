package simula.runtime;


public class Continuation implements Runnable {
	private String ident;
	private boolean done;
	private static Continuation currentContinuation;
	private Runnable target;
	private Thread targetThread;
	private boolean running;
	public Continuation(ContinuationScope scope, Runnable target,String ident) {
		this.target=target;
		this.ident=ident;
		System.out.println("Continuation: CONSTRUCTING "+ident);
	}

	public boolean isDone() { return(done); }
	
	@SuppressWarnings("deprecation")
	public final void run() {
		System.out.println("Continuation("+ident+").run: BEGIN");
		if (done) throw new IllegalStateException("Continuation terminated");
		currentContinuation=this;
		if(targetThread==null) {
			System.out.println("Continuation("+ident+").run: Start NEW Thread="+target);
			targetThread=new Thread(target);
			targetThread.start();
		} else {
			System.out.println("Continuation("+ident+").run: Resume Thread="+target);
			targetThread.resume();
		}
		running=true;
		// ...
		while (running && targetThread.isAlive()) {
			Thread.yield();
			try {
				System.out.println("Continuation("+ident+").run: Sleeping,   running="+running+", targetThread.isAlive()="+targetThread.isAlive());
				Thread.sleep(5000);
				System.out.println("Continuation("+ident+").run: Processing, running="+running+", targetThread.isAlive()="+targetThread.isAlive());
			} catch (InterruptedException e) {
				e.printStackTrace();
				running = false;
			}
		}
		if(!targetThread.isAlive()) {
			done=true;
			targetThread=null;
		}
		System.out.println("Continuation("+ident+").run: RETURNS  done="+done);
	}
	
	@SuppressWarnings("deprecation")
	public static void yield(ContinuationScope scope) {
		System.out.println("Continuation.yield: currentContinuation="+currentContinuation);
//		RT.BREAK("Continuation.yield: currentContinuation="+currentContinuation);
		if(currentContinuation!=null) {
			currentContinuation.running=false;
			Thread targetThread=currentContinuation.targetThread;
			currentContinuation=null;
			targetThread.interrupt();
			targetThread.suspend();
			//  Thread.State getState()
			while(targetThread.getState()==Thread.State.RUNNABLE) Thread.yield();
		}
	}
	
	public String toString() {
		return("Continuation("+ident+')');
	}

}
