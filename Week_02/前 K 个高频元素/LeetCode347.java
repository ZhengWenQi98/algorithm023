package cn.zwq.algorithm.middle;

import java.util.*;

/**
 * 347.前 K 个高频元素，TopK
 * O(N*logK) -> 小根堆、二叉搜索树；O(N) -> 计数排序、快排变形
 *
 * @author G20200343200113
 */
public class LeetCode347 {

    /**
     * 1.使用 HashMap 统计每个数字出现的次数
     * 2.使用 Java PriorityQueue 维护一个 K 个数的小根堆，如果 PriorityQueue 大小小于 K，
     * 持续往 PriorityQueue 添加元素；如果大小大于 K，判断新添加的元素是否大于小根堆首元素，大于则替换，
     * 如果不大于就不替换
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        Map<Integer, Integer> counts = new HashMap<>();
        for (int key : nums) {
            counts.put(key, counts.getOrDefault(key, 0) + 1);
        }

        Queue<Integer> pq = new PriorityQueue(
                (num1, num2) -> counts.get(num1) - counts.get(num2)
        );
        for (Integer key : counts.keySet()) {
            if (pq.size() < k) {
                pq.offer(key);
            } else if (counts.get(key) > counts.get(pq.peek())) {
                pq.poll();
                pq.offer(key);
            }
        }

        int[] results = new int[k];
        for (int i = 0; i < pq.size(); i++) {
            results[i] = pq.poll();
        }
        return results;
    }

}