package cn.zwq.algorithm.middle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 77. 组合
 *
 * @author G20200343200113
 */
public class LeetCode77 {

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        if (k <= 0 || n < k) {
            return results;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, results);
        return results;
    }

    private static void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> results) {
        if (path.size() == k) {
            results.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= n; i++) {
            path.addLast(i);
            dfs(n, k, i + 1, path, results);
            path.removeLast();
        }
    }
}
