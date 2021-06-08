package com.java.code.arithmetic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by iriwen on 2020/06/30.
 */
public class Target {


    public static void main(String[] args) {
        int[] a = {3, 2, 4};
        int[] res = twoSum(a, 6);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
        System.out.println(res);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap();

        for(int i = 0; i< nums.length;i++){
            map.put(i,nums[i]);
        }
        List<Integer> list  = new ArrayList();
        for(int i = 0; i< nums.length;i++){
            int res = target- nums[i];
            for(Map.Entry<Integer,Integer>  entry : map.entrySet()){
                if(entry.getValue() == res && !list.contains(i) && i!= entry.getKey()){
                    list.add(i);
                    list.add(entry.getKey());
                }
            }
        }
        int[]  arr = new int[list.size()];

        for(int i = 0;i < arr.length ;i++){
            arr[i] = list.get(i);
        }
        return arr;

    }

}
