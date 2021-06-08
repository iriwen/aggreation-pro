package code.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * created by iriwen on 2020/06/30.
 *
 *
 * 回溯 贪心  分治  动态规划
 */
public class Permute {


    public static void main(String[] args) {
        //int[] a = {2,3,5,8};
        int[] a = {1,2,3};
        List<List<Integer>> fullOrder = getFullOrder(a);
        fullOrder.forEach(item-> System.out.println(item));
    }


    public static List<List<Integer>> getFullOrder(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return null;
        } else {
            ArrayList<Integer> arr = new ArrayList<>();
            fullOrder(res, nums, arr);
        }
        return res;
    }

    private static void fullOrder(List<List<Integer>> res, int[] nums, ArrayList<Integer> list) {

        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {

                if (!list.contains(nums[i])) {
                    list.add(nums[i]);
                    fullOrder(res, nums, list);
                    list.remove(list.size() - 1);
                    //System.out.println("current size : " + list.size());
                }
            }
        }
    }
}
