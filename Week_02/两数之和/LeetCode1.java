package cn.zwq.algorithm.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author G20200343200113
 */
public class LeetCode1 {

    /**
     * 暴力解法
     * 相邻元素依次相加，返回第一次相加结果等于 target
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 遍历数组，依次判断 HashMap key 有没有包含 target - 元素的结果
     * 如果不包含，就把当前元素当成 key，索引位置当成 value 添加进 HashMap
     * 如果包含，说明当前元素和包含的 key 相加就等于 target
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}