package cn.zwq.algorithm.middle;

/**
 * 33. 搜索旋转排序数组
 *
 * @author G20200343200113
 */
public class LeetCode33 {

    public static void main(String[] args) {
        //二分查找法
        int[] nums = {1, 3, 6, 8, 13, 16};
        int target = 17;
        System.out.println(binarySearch(nums, target));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int middle;
        while (start <= end) {
            middle = start + (end - start) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            //前半部分有序
            if (nums[start] <= nums[middle]) {
                //target在前半部分
                if (target >= nums[start] && target < nums[middle]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            } else {
                if (target > nums[middle] && target <= nums[end]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 二分查找法
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int middle = (end - start) / 2;
        while (start <= end) {
            if (nums[middle] < target) {
                start = middle + 1;
            } else if (nums[middle] > target) {
                end = middle - 1;
            } else {
                return middle;
            }
            middle = (start + end) / 2;
        }
        return -1;
    }
}
