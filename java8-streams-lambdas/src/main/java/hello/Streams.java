package com.example.demo;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;
import java.util.Arrays;

public class Streams {

	
	//https://www.youtube.com/watch?v=0hQvWIdwnw4
	
	
	//imperative style the structure of sequential code is
	//very different from structure of concurrent code
	
	//using streams the structure of sequential code is identical to the 
	//structure of concurrent code
	
	public static void main(String args[]) throws InterruptedException {
		
		List<Integer> numbers = Arrays
				.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
		
		/*numbers.parallelStream()
		.map(e -> transform(e))
		.forEach(System.out::println);*/
		
		//use(numbers.stream());
		
		/*numbers.stream()
		.filter(e-> check(e))
		.forEachOrdered(e -> {} );*/
		
		//numbers.stream().reduce(0,add(e,e2))
		
		//System.out.println(Runtime.getRuntime().availableProcessors());
		//System.out.println(ForkJoinPool.commonPool());
		
		/*numbers.parallelStream()
		.map( e -> transform(e))
		.forEach(e -> {});*/
		
		//Configure - good news/bad news
		//-Djava.util.concurrent.ForkJoinPool.common.parallellism=100
		
		//
		
		process(numbers.parallelStream().map( e->transform(e)));
		
		
		
	}
	
	public static void process(Stream<Integer> stream) throws InterruptedException {
		
		//stream.forEach( e -> {});
		
		ForkJoinPool pool = new ForkJoinPool(100);
		pool.submit( () -> stream.forEach( e -> {}));
		pool.shutdown();
		pool.awaitTermination(10, TimeUnit.SECONDS);
	}
	public static int add(int a, int b) {
		int result = a + b;
		return result;
	}
	public static boolean check(int number) {
		System.out.println("c: "+number+"--"+Thread.currentThread());;
		sleep(1000);
		return true;
	}
	public static int transform(int number) {
		
		System.out.println("t: "+number+ "--"+ Thread.currentThread());
		sleep(1000);
		return number * 1;
	}
	public static void printit(int number) {
		System.out.println("P: "+number+"--"+Thread.currentThread());;
	}
	public static boolean sleep(int ms) {
		try {
			Thread.sleep(ms);
		}catch(Exception e) {
			return false;
		}
		return true;    
	}
	
	public static void use(Stream<Integer> stream) {
		//step1
		/**stream.parallel()
		.map((e) -> transform(e))
		.forEach(System.out::println);
		*/
		
		stream.parallel()
		.map((e) -> transform(e))
		.reduce((Integer t, Integer u) ->{return u;}

		);
		
		
		
		// there is no segments b/w parallel and sequential
		
		//Streams
		// Sequential vs Parallel
		// sequential or parallel (either one)
		// no segments
		
		//Reactive Stream
		// sync vs async
		
		//Depends
		// subscribeOn - no segments
		// observeOn - segments
		
		// we solve one set of problems only to create a
		// new set of problems
		
		//Java 1 - Threads
		//Java 5 - ExecutorServices
		
		//Pool induced deadlock
		
		// Work Stealing pool
		//Java 7 Fork Join Pool
		// Obsering the threads
		
		//Some methods are inherently ordered
		// SOme methods are unordered may have an ordered counter part
		
		
		
		//reduce does not take an initial value, it takes an itentity value
		
		//int + identity is 0  x+0 = x
		//int * identity is 1  x*1 = x
		
		//what we work with should be a monoid
		
		
		//using streams in parallel
		
		//How many threads can i create?//bad question
		//how much food can i eat?
		
		//how much food should i eat?
		//how many threads should i create?
		
		//computation intensive vs IO intesive
		
		
		// for computation intensive
		   // #Threads <= #of cores
		
		// for IO Intensive
		
		//Threads may be greater than #of cores?? -- p
		
		// T <=   # of cores
		//         ---------------
		//        1 - blocking factor
		//        0 <= blocking factor < 1
		
		
		         
		
	}
	
}
