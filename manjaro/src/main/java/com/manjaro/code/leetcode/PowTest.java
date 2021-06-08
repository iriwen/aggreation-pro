package com.manjaro.code.leetcode;

public class PowTest {


    public static void main(String[] args) {
       long result =  pow(3,4);
        System.out.printf(result+"");
    }

    public static long pow(int m, int n){

        long result = 1L;

        for(int i = 0; i< n; i++){
            result *= m;
        }
        return result ;
    }
}
