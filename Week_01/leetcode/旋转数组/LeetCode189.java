package cn.zwq.algorithm.middle;

/**
 * 189. 旋转数组
 *      使用双重遍历，第一层循环是需要移动的次数，也就是 K
 *      第二层循环是将元素整体向右移一位，最后一位移到第一位
 * @author G20200343200113
 */
public class LeetCode189 {

    /**
     * 时间复杂度是 O(n*k)
     *
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0; i < k; i++) {
            int last = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = last;
        }
    }
}
