package cn.zwq.algorithm.simple;

/**
 * 移动零
 *
 * @author G20200343200113
 */
public class LeetCode283 {

    /**
     *  时间复杂度是 O(n)
     *
     *  假设数组为：1,0,0,2,3,0,6
     *    声明一个指针变量 count 指向数组的第一个元素(索引 0)，
     *    然后遍历数组，判断该元素是否不为 0，不为 0 说明是需要移动位置的，
     *    然后将该元素移动到 count 指针指向的索引位置，
     *    如果该元素的索引位置与 count 指向的索引位置一样的话，就不用把值改为 0
     *    如果不一样的话，就需要将该元素的值改为 0 ，最后将 count 指针指向后一位索引
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[count] = nums[i];
                if (count != i) {
                    nums[i] = 0;
                }
                count++;
            }
        }
    }
}
