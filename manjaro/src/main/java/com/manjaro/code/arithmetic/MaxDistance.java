package com.manjaro.code.arithmetic;

import java.util.ArrayList;
import java.util.List;

public class MaxDistance {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 1, 0, 0, 0, 0, 1};
        int result = getMaxIndex(arr);
        //System.out.println(result);


        List<int[]> list = new ArrayList<>();

        int[] arrA = {1,3,5};
        list.add(new int[]{6, 2, 5});
        list.add(new int[]{2, 1, 1});
        list.add(new int[]{2, 6, 2});
        list.add(new int[]{1, 3, 3});
        list.add(new int[]{3, 4, 1});
        list.add(new int[]{6, 5, 2});

        int minCost = getMinCost(list);

        System.out.println("仓库运输最小耗时" + minCost);

    }

    public static int getMaxIndex(int[] arr) {
        //确定最大连续0 的个数 /2
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                int counter = 1;
                while (arr[++i] == 0) {
                    counter++;
                }
                if (counter > max) {
                    max = counter;
                }
            }
        }
        if (max % 2 == 1) {
            return max / 2 + 1;
        } else {
            return max / 2;
        }
    }

    public static int getMinCost(List<int[]> ware) {

        int[] firstLine = ware.get(0);
        int origin = firstLine[1];

        int time = 0;

        for (int[] itemArr : ware) {

            if (itemArr[0] == origin) {

                int[] startArr = itemArr;
                int pathCost = 0;
                //计算每条运输路径花费的时间
                while (null != startArr) {
                    pathCost += startArr[2];

                    int repoNum = startArr[1];
                    startArr = null;
                    for (int i = 1; i < ware.size(); i++) {


                        if (repoNum == ware.get(i)[0]) {
                            startArr = ware.get(i);
                            break;
                        }
                    }
                    //startArr = findStartArr(startArr[1], ware);
                }
                if (pathCost > time) {
                    time = pathCost;
                }
            }
        }
        return time;
    }

    private static int[] findStartArr(int num, List<int[]> ware) {

        for (int i = 1; i < ware.size(); i++) {

            if (num == ware.get(i)[0]) {
                return ware.get(i);
            }
        }
        return null;
    }
}
