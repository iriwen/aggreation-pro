package com.manjaro.code.codec;

public class TestNull {

    public static void main(String[] args) {

        String[] arrs ={"first","a","b","c"};

        StringBuilder result  = new StringBuilder(arrs[0]);

        for(int i= 1;i<arrs.length;i++){
            result.append(":").append(arrs[i]);
        }

        System.out.println(result);
    }
}
