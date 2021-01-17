package cn.zwq.algorithm.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 *
 * @author G20200343200113
 */
public class LeetCode47 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        DFS(nums, flag, 0, results, temp);
        return results;
    }

    public static void DFS(int[] nums, boolean[] flag, int start, List<List<Integer>> results, List<Integer> temp) {
        if (start == nums.length) {
            results.add(new ArrayList<>(temp));
            return;
        }
        int pre = -1;
        for (int i = 0; i < nums.length; i++) {
            if (!flag[i] && (pre == -1 || nums[i] != nums[pre])) {
                flag[i] = true;
                temp.add(nums[i]);
                pre = i;
                DFS(nums, flag, start + 1, results, temp);
                flag[i] = false;
                temp.remove(start);
            }
        }
    }

}
