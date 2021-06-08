package com.manjaro.code.codec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * created by iriwen on 2020/12/21.
 */
public class Md5Util {

    public static void main(String[] args) {
        String uri = "/bookstore/queryBookstoreData";
        String key = "bookstore";
        LocalDateTime dateTime = LocalDateTime.now();
        Long nowMills = dateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();

        //uri+timestamp+key
        String sig = uri + nowMills + key;
        System.out.println("mills : " + nowMills);

        String src = sig;
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 准备要加密的数据
        byte[] b = src.getBytes();
        // 加密
        byte[] digest = md5.digest(b);
        // 十六进制的字符
        char[] chars = new char[]{'0', '1', '2', '3', '4', '5',
                '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuffer sb = new StringBuffer();
        // 处理成十六进制的字符串(通常)
        for (byte bb : digest) {
            sb.append(chars[(bb >> 4) & 15]);
            sb.append(chars[bb & 15]);
        }
        System.out.println(sb.toString());
    }
}
