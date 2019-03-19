package simula.runtime.loom;

import java.lang.Runnable;
import java.lang.String;
import java.lang.System;
import java.lang.Thread;
import java.lang.Throwable;

import simula.runtime.RT;

public class Example {
	static final ContinuationScope scope=new ContinuationScope("TST");
	
    public static void main(String[] args) {
    	Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			public void uncaughtException(Thread t, Throwable e) {
                RT.println("Example.main GOT UNCAUGHT EXCEPTION: "+e.getMessage());
                ThreadUtils.printStackTrace();
                ThreadUtils.printThreadList(); 
                System.exit(-1);
 			}});

//    	example1();
    	example2();
    	ThreadUtils.printThreadList(true);
    }
	
    public static void example1() {
    	
		Continuation coroutine=new Continuation(scope,new Runnable() {
			public void run() {
				System.out.println("Part 1 - Statements");
				Continuation.yield(scope); // DETACH 1
				System.out.println("Part 2 - Statements");
				Continuation.yield(scope); // DETACH 2
				System.out.println("Part 3 - Statements");
			}});
		
		
		coroutine.run(); // Vil utføre Part 1.
		System.out.println("Kommer hit etter første DETACH(Yield)");
		coroutine.run(); // Vil utføre Part 2.
		System.out.println("Kommer hit etter andre DETACH(Yield)");
		coroutine.run(); // Vil utføre Part 3.
		System.out.println("Kommer hit etter 'FINAL END'");
		coroutine.run(); // IllegalStateException: Continuation terminated
	}


	static Continuation next;
	static Continuation producer=null;
	static Continuation consumer=null;

	public static void EXECUTE(Continuation cont) {
		next=cont;
		while(next!=null) {
			Continuation n=next; next=null;	n.run();
		}
	}
	
	public static void RESUME(Continuation cont) {
		next=cont; Continuation.yield(scope);
	}

    public static void example2() {
    	
		producer=new Continuation(scope,new Runnable() {
			public void run() {
				System.out.println("Producer:Part 1 - Statements");
				RESUME(consumer);
				System.out.println("Producer:Part 2 - Statements");
				int i=0;
				i=i/i;
				RESUME(consumer);
				System.out.println("Producer:Part 3 - Statements");
				RESUME(consumer);
			}});
    	
		consumer=new Continuation(scope,new Runnable() {
			public void run() {
				System.out.println("Consumer:Part 1 - Statements");
				RESUME(producer);
				System.out.println("Consumer:Part 2 - Statements");
				RESUME(producer);
				System.out.println("Consumer:Part 3 - Statements");
			}});
		
		
		EXECUTE(producer); // Vil starte med Producer:Part 1.
		System.out.println("Kommer hit til slutt");
	}

}
