package com.zuric.java8;

import java.util.Arrays;
import java.util.List;

/**
 * Parallel Strems:

collection pipeline pattern
from imperative to functional
benefits of the pipeline pattern

 */
public class Java8Application {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		//Find the total of double of even numbers
		int total = 0;
		for(int e: numbers){
			if ( e % 2 == 0){
				total += e*2;
			}
		}
		System.out.print(total);
		//Synchronize and suffer model

		//Imperative style has accidental complexity
		//Functional stlye has less complexity and is also easier to parallelize
		numbers.stream()
		.filter( e -> e%2==0)
		.mapToInt(e -> e*2)
		.sum();
	}

}
