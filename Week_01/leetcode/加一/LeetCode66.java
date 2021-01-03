package cn.zwq.algorithm.simple;

/**
 * 66.加一
 *
 * @author G20200343200113
 */
public class LeetCode66 {

    /**
     * 考虑几种情况
     *      [0] =》 [1]
     *      [1,2,3] =》 [1,2,4]
     *      [1,2,9] =》 [1,3,0]
     *      [9] =》[1,0]
     *      [9,9,9] =》[1,0,0,0]
     *  如果元素不是 9 ，加 1 取余 10 还是原来的数字，这样就不用再判断了
     *  如果是 9 ，还需要继续判断前一个元素是不是 9，如果所有元素都是 9，
     *  就需要创建新的数组，长度是原来长度加一，设置第一个元素为 1 即可。
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += 1;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
