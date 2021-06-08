package com.manjaro.code.arithmetic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * created by iriwen on 2020/06/30.
 */
public class FullSort {

    public static void main(String[] args) {

        Integer[] arr = {2, 3, 5, 8};

        List<String> fullSortByArr = getFullSortByArr(arr);

        fullSortByArr.forEach(item -> {
            System.out.println(fullSortByArr);
        });

    }

    public static List<String> getFullSortByArr(Integer[] arrNum) {

        if (arrNum.length == 1) {
            String join = arrNum[0] + ",";
            List<String> strArr = Stream.of(join).collect(Collectors.toList());
            return strArr;
        } else {

            List<String> result = new ArrayList<>();
            for (int i = 0; i < arrNum.length; i++) {

                int initNum = arrNum[i];

                LinkedList<Integer> list = new LinkedList<>();

                Integer[] subArray = getSubArr(initNum, arrNum, list);
                List<String> subArrFullSort = getFullSortByArr(subArray);

                result = subArrFullSort.stream().map(item -> (initNum + "," + item)).collect(Collectors.toList());
            }
            return result;
        }
    }

    public static Integer[] getSubArr(int excludeNum, Integer[] arrNum, LinkedList<Integer> list) {

        Stream.of(arrNum).filter(item -> item != excludeNum).forEach(item -> {
            list.add(item);
        });

        Integer[] sub = new Integer[list.size()];

        for (int i = 0; i < list.size(); i++) {
            sub[i] = list.get(i);
        }
        return sub;
    }
}
