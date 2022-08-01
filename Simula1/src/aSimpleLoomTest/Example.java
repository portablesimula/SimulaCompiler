package aSimpleLoomTest;

import simula.runtime.Coroutine;
import simula.runtime.RT;

public class Example {
	
    public static void main(String[] args) {
//    	example1();
    	example2();
    	example1();
    }

	// *********************************************************************
	// *** EXAMPLE 1: Co-routine with three active phases:
	// *********************************************************************

    public static void example1() {
    	RT.Option.USE_VIRTUAL_THREAD=true;

    	Coroutine corut=new Coroutine(new Runnable() {
    		public void run() {
    			System.out.println("Part 1 - Statements");
    			Coroutine.detach(); // DETACH 1
    			System.out.println("Part 2 - Statements");
    			Coroutine.detach(); // DETACH 2
    			System.out.println("Part 3 - Statements");
    		}});


    	corut.run(); // Vil utføre Part 1.
    	System.out.println("Returns here after first DETACH(Yield)");
    	corut.run(); // Vil utføre Part 2.
    	System.out.println("Returns here after second DETACH(Yield)");
    	corut.run(); // Vil utføre Part 3.
    	System.out.println("Returns here after 'FINAL END'");
    	System.out.println("Next line should be: IllegalStateException: Continuation terminated");
    	corut.run(); // IllegalStateException: Continuation terminated
    }

	// *********************************************************************
	// *** EXAMPLE 2: Chain Execution ( ala' Simulation)
	// *********************************************************************

	static Coroutine next;
	static Coroutine producer=null;
	static Coroutine consumer=null;

	public static void EXECUTE(Coroutine coroutine) {
		next=coroutine;
		while(next!=null) {
			Coroutine n=next; next=null; n.run();
		}
	}
	
	public static void RESUME(Coroutine coroutine) {
		next=coroutine; Coroutine.detach();
	}

    public static void example2() {
    	RT.Option.USE_VIRTUAL_THREAD=true;
    	
		producer=new Coroutine(new Runnable() {
			public void run() {
				System.out.println("Producer:Part 1 - Statements");
				RESUME(consumer);
				System.out.println("Producer:Part 2 - Statements");
				RESUME(consumer);
				System.out.println("Producer:Part 3 - Statements");
				RESUME(consumer);
			}});
    	
		consumer=new Coroutine(new Runnable() {
			public void run() {
				System.out.println("Consumer:Part 1 - Statements");
				RESUME(producer);
				System.out.println("Consumer:Part 2 - Statements");
				RESUME(producer);
				System.out.println("Consumer:Part 3 - Statements");
			}});
		
		
		EXECUTE(producer); // Will start Producer:Part 1.
		System.out.println("End of program\n");
	}

}