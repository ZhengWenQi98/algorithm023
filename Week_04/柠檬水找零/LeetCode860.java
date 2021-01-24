package cn.zwq.algorithm.simple;

/**
 * 860. 柠檬水找零
 *
 * @author G20200343200113
 */
public class LeetCode860 {

    public static void main(String[] args) {
        int[] bills = {5, 5, 10, 10, 20};
        System.out.println(lemonadeChange(bills));
    }

    /**
     * 遍历钞票数组，判断每一次顾客给的钞票
     * 如果是 5，那么钞票 5 计数器加 1，
     * 如果是 10，判断是否已持有不少于 1 张的钞票 5，
     *      是的话钞票 10 计数器加 1，钞票 5 计数器减 1
     *      不是的话直接结束方法，返回 false
     * 如果是钞票 20
     *      1.判断是否已持有不少于 1 张钞票 10和持有不少于 1 张钞票 5，如果是，钞票 10 计数器和钞票 5 计数器各自减一，钞票 20 计数器加 1
     *      2.如果不满足上面条件，再判断是否持有不少于 3 张钞票 5，是的话，钞票 5 计数器减 3，钞票 20 计数器加 1
     *      3.如果不满足上面两种情况，直接结束方法返回 false
     *
     * @param bills
     * @return
     */
    public static boolean lemonadeChange(int[] bills) {
        int bill5 = 0;
        int bill10 = 0;
        int bill20 = 0;
        for (int i = 0; i < bills.length; i++) {
            int bill = bills[i];
            if (bill == 5) {
                bill5++;
            } else if (bill == 10) {
                if (bill5 < 1) {
                    return false;
                } else {
                    bill5--;
                    bill10++;
                }
            } else if (bill == 20) {
                if (bill10 < 1) {
                    if (bill5 < 3) {
                        return false;
                    } else {
                        bill5 -= 3;
                    }
                } else {
                    if (bill5 < 1) {
                        return false;
                    } else {
                        bill10--;
                        bill5--;
                    }
                }
                bill20++;
            }
        }
        return true;
    }
}
