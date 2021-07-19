package com.zuric.java8;

import java.util.Arrays;
import java.util.List;

public class reduce {
    
    public static int add(int a, int b){
      int result = a + b;
      System.out.println("a = "+ a + " b = "+ b + " r "+ result + " -- "+ Thread.currentThread() );
      return result;
    }
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        /*System.out.println(
        numbers.stream()
        .reduce(0,(total,e) -> add(total,e)));*/

        /*System.out.println(
            numbers.parallelStream()
            .reduce(0,(total,e) -> add(total,e)));
            */

        System.out.println(
            numbers.stream()
            .reduce(30,(total,e) -> add(total,e)));    //inital value

            System.out.println(
                numbers.parallelStream()
                .reduce(30,(total,e) -> add(total,e))); //inital value    


       //reduce doen't take an initial value, it takes an identity value
       
       //int + identity is 0  x+0= x
       //int * identity is 1  x*1 = x
       
    }

    // int + 
}
