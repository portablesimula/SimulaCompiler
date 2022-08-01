package aSimpleLoomTest;

public class Example2 {
//	static final ContinuationScope scope=new ContinuationScope("TST");
//	
//    public static void main(String[] args) {
////    	example1();
//    	example2();
//    	example1();
//    }
//
//	// *********************************************************************
//	// *** EXAMPLE 1: Co-routine with three active phases:
//	// *********************************************************************
//
//    public static void example1() {
//    	
//		Continuation coroutine=new Continuation(scope,new Runnable() {
//			public void run() {
//				System.out.println("Part 1 - Statements");
//				Continuation.yield(scope); // DETACH 1
//				System.out.println("Part 2 - Statements");
//				Continuation.yield(scope); // DETACH 2
//				System.out.println("Part 3 - Statements");
//			}});
//		
//		
//		coroutine.run(); // Vil utføre Part 1.
//		System.out.println("Returns here after first DETACH(Yield)");
//		coroutine.run(); // Vil utføre Part 2.
//		System.out.println("Returns here after second DETACH(Yield)");
//		coroutine.run(); // Vil utføre Part 3.
//		System.out.println("Returns here after 'FINAL END'");
//		System.out.println("Next line should be: IllegalStateException: Continuation terminated");
//		coroutine.run(); // IllegalStateException: Continuation terminated
//	}
//
//
//	// *********************************************************************
//	// *** EXAMPLE 2: Chain Execution ( ala' Simulation)
//	// *********************************************************************
//
//	static Continuation next;
//	static Continuation producer=null;
//	static Continuation consumer=null;
//
//	public static void EXECUTE(Continuation cont) {
//		next=cont;
//		while(next!=null) {
//			Continuation n=next; next=null;	n.run();
//		}
//	}
//	
//	public static void RESUME(Continuation cont) {
//		next=cont; Continuation.yield(scope);
//	}
//
//    public static void example2() {
//    	
//		producer=new Continuation(scope,new Runnable() {
//			public void run() {
//				System.out.println("Producer:Part 1 - Statements");
//				RESUME(consumer);
//				System.out.println("Producer:Part 2 - Statements");
//				RESUME(consumer);
//				System.out.println("Producer:Part 3 - Statements");
//				RESUME(consumer);
//			}});
//    	
//		consumer=new Continuation(scope,new Runnable() {
//			public void run() {
//				System.out.println("Consumer:Part 1 - Statements");
//				RESUME(producer);
//				System.out.println("Consumer:Part 2 - Statements");
//				RESUME(producer);
//				System.out.println("Consumer:Part 3 - Statements");
//			}});
//		
//		
//		EXECUTE(producer); // Will start Producer:Part 1.
//		System.out.println("End of program");
//	}
//
}