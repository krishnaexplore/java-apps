package com.example.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFuturesInDepth {

	//what is completable future ?
	// Asynchronous execution
	// task running -> non blocking
	
	//method call you don't wait to complete it
	// how do you get the results
	
	//Futures
	//
	
	// Future<?> future = call()??
	
	// future.get()
	
	// Lessons from JavaScript
	   // callbacks
	      // lacks consistency
	      // hard to compose
	      // hard to deal with errors
	      // callback hell
	// Promises
	   // may resolve, reject, or be pending (STATE)
	   // data channel and error channel
	   // failure/error is like data
	   // easy to compose
	//Stream
	  // dataflow
	  
	  // what if something goes wrong?
	     // good luck
	 // what about java
	   // completableFuture in java is promises in javascript
	   // stages
	   
	
	public static void main(String args[]) {
		//CompletableFuture<Integer> future = create(); 
		
		//future.
		
		//Famous or popular functional interfaces
		
		//Supplier<T> T get()        -- factories
		//Predicate<T> boolean test(T) -- filter
		//Function<T,R> R apply(T)     -- map
		//Consumer<T> void accept(T) -- forEach -//takes data and eats
		
		
		//future.thenAccept(data -> System.out.println(data));
		//future.thenAccept(System.out::println);
		
		
		//CompletableFuture<Void> future2 = future.thenAccept(data -> System.out.println(data));
		
		/*create().thenAccept( data -> System.out.println(data))
		.thenRun( () -> System.out.println("This never dies"))
		.thenRun( () -> System.out.println("this never born"));*/
		
		/*try {
			System.out.println(create().get()); // bad idea blocking method get()
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		// the best thing to do with get is to forget
		
		//getNow() //impatient 
		
		
		/*System.out.println("in main "+ Thread.currentThread());
		
		CompletableFuture<Integer> future = create();
		
		//sleep(1000);
		
		future.thenAccept(data -> printIt(data));
		System.out.println("here");
		sleep(1000);*/
		
		/*create().thenAccept(data -> printIt(data))
		.thenRun(() -> System.out.println("went well"));*/
		
		create()
		.thenApply(data -> data * 10)
		.thenAccept(data -> System.out.println(data))
		.thenRun(() -> System.out.println("That went well"));
	}
	public static int compute() {
		System.out.println("compute:  "+ Thread.currentThread());
		//sleep(1000);
		return 2;
	}
	public static CompletableFuture<Integer> create(){
		return CompletableFuture.supplyAsync(() -> compute());
	}
	public static void printIt(int value) {
		System.out.println(value + "---print :"+value+"--"+Thread.currentThread());
		System.out.println();
	}
	public static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//thenAccept
	//thenRun
	//thenApply
	   // Stream                            CompletableFuture
	     //0,1, or more                     0 or 1
	     // only data channel               //data channel and error channel
	     // forEach                         //thenAccept
	     // map                             //thenApply //transformation
	
}
