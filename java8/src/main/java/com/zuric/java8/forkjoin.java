package com.zuric.java8;

import java.util.concurrent.ForkJoinPool;

public class forkjoin {
    public static void main(String[] args){
        
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(ForkJoinPool.commonPool());
    }
}
