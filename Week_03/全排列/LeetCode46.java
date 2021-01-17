package cn.zwq.algorithm.middle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 46. 全排列
 *
 * @author G20200343200113
 */
public class LeetCode46 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute1(nums));
        System.out.println(permute2(nums));
    }

    public static List<List<Integer>> permute1(int[] nums) {

        List<List<Integer>> results = new ArrayList<List<Integer>>();
        int length = nums.length;
        if (length == 0) {
            return results;
        }

        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }

        backtrack(length, output, results, 0);
        return results;
    }

    private static void backtrack(int length, List<Integer> output, List<List<Integer>> results, int first) {
        if (first == length) {
            results.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < length; i++) {
            Collections.swap(output, first, i);
            backtrack(length, output, results, first + 1);
            Collections.swap(output, first, i);
        }
    }

//----------------------------------------------------------

    public static List<List<Integer>> permute2(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();

        int length = nums.length;
        if (length == 0) {
            return results;
        }

        boolean[] used = new boolean[length];
        List<Integer> path = new ArrayList<>();
        dfs(nums, length, 0, path, used, results);
        return results;
    }

    private static void dfs(int[] nums, int length, int depth, List<Integer> path,
                            boolean[] used, List<List<Integer>> results) {

        if (depth == length) {
            results.add(path);
            return;
        }

        for (int i = 0; i < length; i++) {
            if (!used[i]) {
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(nums[i]);

                boolean[] newUsed = new boolean[length];
                System.arraycopy(used, 0, newUsed, 0, length);
                newUsed[i] = true;

                dfs(nums, length, depth + 1, newPath, newUsed, results);
            }
        }

    }
}
