package com.example.demo;

import java.util.concurrent.CompletableFuture;

import EDU.oswego.cs.dl.util.concurrent.SyncSortedMap;

public class CF2 {

	public static void main(String[] args) {
		
		/*CompletableFuture<Integer> future = 
				new CompletableFuture<Integer>();
		
		
		future	.thenApply( data -> data * 2)
				.thenApply( data -> data + 1 )
				.thenAccept( data -> System.out.println(data));
		
		System.out.println( "built the pipeline");
		
		sleep(1000);
		
		future.complete(2);
		
		sleep(1000);*/
		
		//dealing with exception --oops
		
		
		//example 2
		
		/*create()
		.thenAccept( data -> System.out.println(data));
		*/
		
		/*create()
		.thenApply(data -> data * 2)
		.thenAccept(data -> System.out.println(data));
		*/
		
		//exceptionally -> catch
		
		// 
		
		
		/*create2()
		.thenApply(data -> data * 2)
		.thenAccept(data -> System.out.println(data))
		.exceptionally(throwable -> handleException(throwable));
		*/
		
		/*CompletableFuture<Integer> future = new CompletableFuture<Integer>();
		
		
		future
			.thenApply( data -> data * 2)
			.exceptionally(throwable -> handleException2(throwable))
			.thenApply( data -> data + 1)
			.thenAccept( data -> System.out.println(data));
		
		System.out.println("built the pipeline");
		
		sleep(1000);
		
		future.complete(2);
		
		sleep(1000);*/
		
		/*CompletableFuture<Integer> future = new CompletableFuture<Integer>();
		
		
		future
			.thenApply( data -> data * 2)
			.exceptionally(throwable -> handleException2(throwable))
			.thenApply( data -> data + 1)
			.thenAccept( data -> System.out.println(data));
		
		System.out.println("built the pipeline");
		
		sleep(1000);
		
		future.completeExceptionally( new RuntimeException("don't tell the boss"));
		
		sleep(1000);
		*/
		
/*CompletableFuture<Integer> future = new CompletableFuture<Integer>();
		
		
		future
			.thenApply( data -> data * 2)
			.exceptionally(throwable -> handleException2(throwable))
			.thenApply( data -> data + 1)
			.thenAccept( data -> System.out.println(data));
		
		System.out.println("built the pipeline");
		
		sleep(1000);
		if(Math.random() > 0.75)
			future.completeExceptionally( new RuntimeException("don't tell the boss"));
		else 
			future.complete(2);
		sleep(1000);
		
		*/
		
		//thenCombine
		
		create(2)
		.thenCombine(create(3),  (result,result2) -> result + result2)
		.thenAccept( data -> System.out.println(data));
		
	}
	
	public static CompletableFuture<Integer> create(int number){
		return CompletableFuture.supplyAsync(() -> number);
	}
	
	public static int handleException2(Throwable throwable) {
		System.out.println("ERROR: "+throwable);
		return 0;
	}
	
	public static Void handleException(Throwable throwable) {
		System.out.println(throwable);
		throw new RuntimeException("it is beyond all hope");
	}
	
	public static int compute() {
		return 2;
	}
	
	public static int compute2() {
		throw new RuntimeException(" some thing went wrong");
		//return 2;
	}
	
	public static CompletableFuture<Integer> create(){
		return CompletableFuture.supplyAsync(() -> compute());
	}
	public static CompletableFuture<Integer> create2(){
		return CompletableFuture.supplyAsync(() -> compute2());
	}
	
	private static boolean sleep(int ms) {
		try {
			Thread.sleep(ms);
			return true;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
