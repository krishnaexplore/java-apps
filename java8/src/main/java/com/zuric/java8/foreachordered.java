package com.zuric.java8;

import java.util.Arrays;
import java.util.List;

public class foreachordered {

    public static void printit(int number){
        System.out.print("p:    "+number+"--"+Thread.currentThread());
        System.out.println(number);
    }
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(1,2,3,4,5,6,7,10);

        number.parallelStream()
        .map(e -> transform(e))
        .forEachOrdered(e->printit(e));

    }
    public static int transform(int number){
        System.out.println("T:    "+number+"--"+Thread.currentThread());
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
}
