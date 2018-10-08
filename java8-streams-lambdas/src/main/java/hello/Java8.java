package hello;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Java8 {

	
	public static void main(String args[]) {
		
		//* what is lamda expression ?
		/**
		 * annomous function
		 *
		
		Thread thread = new Thread(new Runnable() {
			public void run() {
				System.out.println("In antoher thread");
			}// lot of cermony
		});
		
		thread.start();
		
		System.out.println("In Main");*/
		
		//Function has 4 things
		/*1 name,
		  2 parmater list 
		  3 body 
		  4 return type
		
		/*
		 * Thread thread = new Thread(() -> System.out.println(" in thread")); 
		 *
		
		thread.start();
		System.out.println("In Main");
		*/
		
		//Lamdas under the hood -- weightloss program
		
		
		//scala , groovy creates annomous classes
		
		/*Thread th;
		th = new Thread( () -> System.out.println("In other"));
		th = new Thread( () -> System.out.println("In other"));
		th = new Thread( () -> System.out.println("In other"));
		th = new Thread( () -> System.out.println("In other"));
		th.start();
		System.out.println("In Main");*/
		//invokeDynamic
		// function pointers finally available in java
		
		//javap -c Sample
		
		//from imperative
		
		//List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		//external iterators
		// size or length?
		// i++ or ++i ?
		//
		/*for(int i=0; i<numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}
		
		for(int e: numbers) {
			System.out.println(e);
		}*/
		
		//internal iterators
		/*numbers.forEach(new Consumer<Integer>() {
			public void accept(Integer value) {
				System.out.println(value);
			}
		});*/
		
		//numbers.forEach( (Integer value) -> System.out.println(value));
		//numbers.forEach((value) -> System.out.println(value)); // never say to obivous
		// java 8 has type inference, finally, hold your tweets, but only for lamda expressions
		//paraenthesis is optional, but only for one parameters lambdas
		
		//numbers.forEach( System.out::println ); // 
		
		//while lambdas are really cute, keep them that way.
		//lambdas are glue code : http://blog.agiledeveloper.com/2015/06/lambdas-are-glue-code.html
		//
		
		
		//A peek at method references : directly pass to something else
		
		//parameter can be argument
		
		//numbers.forEach( e -> System.out.println(e));
		//numbers.forEach(System.out::println);
		
		//parameter can be argument to as static method
		//numbers.stream().map( String::valueOf).forEach(System.out::println);
		
		
		/*numbers.stream().map(e -> String.valueOf(e))
		                .map(String::toString)
		                .forEach(System.out::println);*/
		
		//System.out.println(numbers.stream().reduce(0, (total, e) -> Integer.sum(e, total)));
		
		//System.out.println( numbers.stream().reduce(0, Integer::sum) ); //two parameters as arguments
		
		//System.out.println ( numbers.stream().map(String::valueOf)
		  //              .reduce("", (carry, str) -> carry.concat(str)) ); //two parameters, one as target the other as an argument
		
		
		//System.out.println( numbers.stream().map(String::valueOf).reduce("", String::concat) );
		
		
		
		//function composition
		
		//List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		//given the values, double the even numbers and total
		
		/*int result = 0;
		for(int e: numbers) {
			if(e%2==0) {
				result += e *2;
			}
		}
		System.out.println(result);
		
		
		System.out.println( 
				numbers
		.stream()
		.filter( e -> e % 2 == 0)
		.map(e -> e * 2)
		.reduce(0, Integer::sum)
		);
		
		System.out.println(
		numbers
		.stream()
		.filter( e -> e % 2 == 0 )
		.mapToInt( e -> e * 2 )
		.sum()
		);
		*/
		
		//Sequencing
		/**Timeit.code( () ->
 				System.out.println(numbers.stream()
		       .filter( e-> e%2==0)
		       .mapToInt(e -> compute( e ))
		       .sum()
		));*/
		
		//Parallelizing it
		/**Timeit.code( () -> 
		            System.out.println(
		            		numbers
		            		.parallelStream()
		            		.filter(e -> e % 2 == 0)
		            		.mapToInt(e -> compute(e))
		            		.sum()
		            	)
		            );*/
		
		//Stream as Abstraction 
		
		//filter - take elements from stream block some and some let go
		//filter: 0<=number of elements in the output <=number of elements in the input
		//input : Stream<T> filter takes Predicate<T>
		
		//map : transforms values
		//number of output == number of input
		//no guarantee on the type of the output with respect to the type of the input
		// Parameter : Stream<T> map takes Function<T,R> to return Stream<R>
		// map(e->e*2.0) input is Integer output stream Float
		// both filter and map stay within their swimlanes
		
		//reduce cuts across the swimlanes
		     
		/**
		 * 
		 *
		     filter  map       reduce
------------------------------------------------------		     
		x1    |                  
------------------------------------------------------
		x2    ->      x2'       +
------------------------------------------------------		
		x3    |
------------------------------------------------------		
		x4    ->      x4'       +
------------------------------------------------------		
		*/
		
		
		//reduce on Stream<T> takes two paramters
		//first parametr is of type T
		//Second parametr is of type BiFunction<R,T,R> to produce a result of R 
		
		//specialized reduce functions
		//Sum - Reduce operation
		//collect -> 
		
		//List<Integer> numbers2 = Arrays.asList(1,2,3,4,5,1,2,3,4,5);
		
		
		
		//double the values and put that into a list
		//wrong way to do this
		
		/*List<Integer> doubleOfEven = new ArrayList<>();
		numbers2.stream().filter( e -> e % 2 ==0 )
		.map(e -> e * 2)
		.forEach( e -> doubleOfEven.add(e));
		System.out.println(doubleOfEven);*/
		
		//mutability is ok, sharing is nice, shared mutability is devils work
		
		//friends don't let friends do shared mutation
		
		//better way
		
		/**List<Integer> doubleOfEven2 =
				numbers2.stream()
				.filter(e -> e % 2 == 0)
				.map(e -> e * 2)
				.collect(Collectors.toList());
		
		System.out.println(doubleOfEven2);*/
		
		
		//List<PersonJava8> people = createPeople();
		
		//create a Map with name and age as key, and the person as value.
		
		/*System.out.println(
				people.stream()
				      .collect( toMap(
				    		  person -> person.getName() + "-" + person.getAge(),
				    		  person -> person
				    		  ))
		);*/
		
		//given a list of groupy by their name
		
		/*System.out.println(
				people.stream()
				.collect( groupingBy(PersonJava8::getName))
				);*/
		
		//given a list of people, create a map where their name is the key and 
		//value is all the ages of people with that name
		//
		
		
		/*System.out.println( 
				people.stream()
				      .collect( groupingBy(
				    		  
				    		  PersonJava8::getName, mapping(PersonJava8::getAge, toList())
				    		  
				    		  )));*/
		
		//List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
		//given an ordered list find the double of the first even number greater than 3
		
		/*int result = 0;
		for(int e : numbers) {
			if( e > 3 && e % 2 == 0) {
				result = e * 2;
				break;
			}
		}
		System.out.println(result);*/
		//performance
		//How much work?  8 units work
		// 
		
		/*System.out.println( 
					numbers.stream()
					.filter(Java8::isGT3)
					.filter(Java8::isEven)
					.map( Java8::doubleIt)
					.findFirst()
				);
		*/
		//How  much work? 20 + 17 + 9 +   = 46 (computation) units - this not true
		
		
		// Streams are lazy
		// intermidiate operations
		//terminal operations
		// stream pipeline evaluated any call terminal operations
		
		//easier to maintain /cute/ easier to change/ same performance
		
		//lazy evalulation is possible only if the functions don't have side effect
		
		//characteristics of a stream, sized, ordered, distinct, sorted
		
		
		/*List<Integer> numbers = Arrays.asList(1,2,3,4,5,1,2,3,4,5);
		
		numbers.stream()
		       .filter(e -> e % 2 ==0)
		       .forEach(System.out::println);
		
		//sized, ordered, non-distinct, non-sorted
		
		numbers.stream()
	       .filter(e -> e % 2 ==0)
	       .sorted()
	       .forEach(System.out::println);
		
		numbers.stream()
	       .filter(e -> e % 2 ==0)
	       .distinct()
	       .forEach(System.out::println);
	       
	     */
		
		//infinte stream
		
		//Stream.iterate(100, e -> e +1);
		
		//Given a number k, and a count n, find the total of double of n
		// Even numbers starting with k, where sqrt of each number is > 20
		
		
		int k = 121;
		int n = 51;
		System.out.println(compute(k,n));

	}
	
	public static int compute(int k, int n) {
		/*int result = 0;
		
		int index = k;
		int count = 0;
		while(count < n) {
			if(index % 2 == 0 && Math.sqrt(index) > 20) {
				result  += index *2;
				count++;
			}
			index++;
		}
		
		return result;*/
		
		return Stream.iterate(k,  e-> e+1)  //unbounded, lazy
		      .filter(e -> e % 2 == 0) //unbounded, lazy
		      .filter(e -> Math.sqrt(e) > 20) //unbounded, lazy
		      .mapToInt( e -> e * 2) //unbouded, lazy
		      .limit(n) //sized, lazy
		      .sum();  // terminal
	}
	
	public static boolean isGT3(int number) {
		System.out.println("isGT3 : " + ( number ));
		return number > 3;
	}
	public static boolean isEven(int number) {
		System.out.println("isEVEn : "+number);
		return number % 2 == 0;
	}
	public static int doubleIt(int number) {
		System.out.println("double it : "+number);
		return number * 2;
	}
	
	public static List<PersonJava8> createPeople(){
		return Arrays.asList( new PersonJava8("Sara", "FEMALE", 28),
				new PersonJava8("Sara", "FEMALE", 22),
				new PersonJava8("Bob", "MALE", 20),
				new PersonJava8("Paula", "FEMALE", 32),
				new PersonJava8("Paul", "MALE", 32),
				new PersonJava8("Jack", "MALE", 2),
				new PersonJava8("Jack", "MALE", 72),
				new PersonJava8("Jill", "FEMALE", 12)
				);
		
		
	}
	public static int compute(int number) {
		//assume this is time intensive
		try {Thread.sleep(1000);}catch(Exception es) {}
		return number * 2;
	}
}
