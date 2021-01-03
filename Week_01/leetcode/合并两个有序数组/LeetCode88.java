package cn.zwq.algorithm.simple;

/**
 *  88.合并两个有序数组
 *      由题目得知 nums1 数组长度大于或等于 m+n，
 *      所以 nums1 可以存储两个有序数组的元素，需要占用 nums1 m+n-1(k) 个位置
 *      循环倒序遍历两个数组，比较谁元素大，大的移动到 k 位置处，移动成功 k--
 *
 *      循环结束，nums1 或者 nums2 都可能剩余元素没有比较，
 *      剩余的元素绝对比排序好的元素小，
 *      如果是 nums1 剩余元素，则不用移动，因为本身就是在 nuns1 上面排序元素
 *      如果是 nums2 剩余元素，需要将元素移动到 nums1 的对应索引位置
 *
 *
 * @author G20200343200113
 */
public class LeetCode88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1,
            j = n - 1,
            k = n + m - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}