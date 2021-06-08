package code.entity;

import java.util.Objects;

/**
 * created by iriwen on 2020/05/21.
 */
public class MinSubContain {

    public static void main(String[] args) {
        int minString = getMinString();
        System.out.println(minString);
    }

    public static int getMinString() {

        String str1 = "ababcc";
        String str2 = "bbc";

        int min = 5;

        if(!str1.contains(str2)){
            return 0;
        }

        for (int i = 0; i < str1.length(); i++) {
            for (int j = 1; j < str1.length()-i; j++) {
                String target = str1.substring(i, i+j );

                if (!Objects.isNull(target) && target.contains(str2)) {
                    //System.out.println(target);
                    if(target.length()< min ){
                        min = target.length();
                        System.out.println(target + " ; min length is: " + min );
                    }
                } else {
                    continue;
                }
            }
        }
        return min;
    }
}
