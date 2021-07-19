package com.zuric.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Seqvsparallel {
    
    public static int transform(int number){
        //System.out.print("T:    "+number+"--"+Thread.currentThread());
        sleep(1000);
        return number*1;
    }
    public static boolean sleep(int ms){
        try{
        Thread.sleep(ms);
        return true;
        }catch(InterruptedException i){
            return false;
        }
    }

    public static void use(Stream<Integer> use){
        use
        .parallel()
        .map(e->transform(e))
        .forEach(System.out::println);
        
    }
    public static void main(String args[]){
        List<Integer> number = Arrays.asList(1,2,3,4,5,6,7,10);

        number.parallelStream()
        .map(e -> transform(e))
        .forEach(System.out::println);

    }
}
