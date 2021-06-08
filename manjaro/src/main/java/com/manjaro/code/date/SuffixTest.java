package com.manjaro.code.date;

/**
 * created by iriwen on 2020/12/02.
 */
public class SuffixTest {

    public static void main(String[] args) {

        String fileName = "25001.xls";
        String path = "/home/worker/temp/messageNotifyMobiles_aa318492-3f6c-438b-ad15-ee962a942c7e.xlsx";
        String suffix = path.substring(path.lastIndexOf("."));
        System.out.println(suffix);


        String initStr = "sdsdsd$null$null$sdsd";
        String replace = initStr.replace("null", "");
        System.out.println("after replace :" + replace);
    }
}

