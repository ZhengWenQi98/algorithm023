package cn.zwq.algorithm.simple;

/**
 * 删除排序数组中的重复项
 *      题目要求不是真的删除重复项元素，而是将不重复的元素按原来位置移到相邻位置
 *      需要返回不重复元素个数，所以当出现重复元素，就将数组长度减一
 *
 *      定义一个计数器 count
 *      判断相邻元素是否相同，相同长度就减一，计数器加一
 *      如果不相同，需要移动该元素，移动的位置是由 count 决定的，
 *      比如（count = 2，说明一个元素出现了两个重复元素，所以 -count 就是应该移动的位置）
 *
 * @author G20200343200113
 */
public class LeetCode26 {

    /**
     * 时间复杂度是 O(n)
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int newLength = nums.length;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                newLength--;
                count++;
            } else {
                nums[i + 1 - count] = nums[i + 1];
            }
        }
        return newLength;
    }
}
