package com.java.code.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/unicom")
public class UnicomTest {

    final static char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
            'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
            'o' , 'p' , 'q' , 'r' , 's' , 't' ,
            'u' , 'v' , 'w' , 'x' , 'y' , 'z'
    };

    public static void main(String[] args) {

        long a = -128l;
        String value = toUnsignedString(a,4);
        System.out.println(value);
    }

    private static String toUnsignedString(long val, int shift) {

        int mag = Long.SIZE - Long.numberOfLeadingZeros(val);
        int chars = Math.max(((mag + (shift - 1)) / shift), 1);
        char[] buf = new char[chars];

        int charPos = chars;
        int radix = 1 << shift;
        int mask = radix - 1;
        do {
            buf[0 + --charPos] = UnicomTest.digits[((int) val) & mask];
            val >>>= shift;
        } while (val != 0 && charPos > 0);

        //formatUnsignedLong(val, shift, buf, 0, chars);
        return new String(buf);
    }

    private static int formatUnsignedLong(long val, int shift, char[] buf, int offset, int len) {
        int charPos = len;
        int radix = 1 << shift;
        int mask = radix - 1;
        do {
            buf[offset + --charPos] = UnicomTest.digits[((int) val) & mask];
            val >>>= shift;
        } while (val != 0 && charPos > 0);

        return charPos;
    }

    @RequestMapping(value = "/verify/{code}}", produces = {"application/json;charset=UTF-8"})
    public Object getAsync(){

        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 100, 200, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(100));

        CompletableFuture  future = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(3000);
                System.out.println("code");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return " ";
        },pool);

        return "success";
    }

}
