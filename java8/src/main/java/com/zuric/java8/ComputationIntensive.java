package com.zuric.java8;

import java.util.stream.IntStream;

public class ComputationIntensive {
    
    static int MAX = 1500;

    public static double compte(double number){
        double result = 0;
        for(int i = 0; i< MAX; i++){
            for(int j=0;j<MAX;j++){
                result +=Math.sqrt(i*j);
            }
        }
        return result;
    }



    public static void main(String[] args){

         double result =
           IntStream.range(0,MAX)
           .parallel()
           .mapToDouble(ComputationIntensive::compte)
           .sum();

           System.out.print(result);
    }
}
