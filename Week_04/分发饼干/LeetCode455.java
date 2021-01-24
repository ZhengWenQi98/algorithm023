package cn.zwq.algorithm.simple;

import java.util.Arrays;

/**
 * 455. 分发饼干
 *
 * @author G20200343200113
 */
public class LeetCode455 {

    public static void main(String[] args) {
        int[] childrens = {32, 19, 21, 19, 65};
        int[] cookies = {18, 25, 27};
        System.out.println(findContentChildren(childrens, cookies));
    }

    /**
     * 贪心算法
     * 饼干大的尽量分发给胃口值大的孩子，饼干小的尽量分发给胃口值小的孩子，
     * 对两个数组升序排列，然后遍历饼干数组，为孩子数组分配一个指针指向索引 0，
     * 判断饼干尺寸是否大于等于孩子胃口值
     * 1.大于，孩子指针加 1，分配计数器加 1，饼干指针加 1
     * 2.不大于，饼干指针加 1 即可
     *
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gIndex = 0;
        int answer = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] > g[gIndex]) {
                answer++;
                gIndex++;
            }
        }
        return answer;
    }

    public static int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int sIndex = s.length - 1;
        int answer = 0;
        for (int i = g.length - 1; i >= 0; i--) {
            if (sIndex >= 0 && s[sIndex] >= g[i]) {
                answer++;
                sIndex--;
            }
        }
        return answer;
    }

    public static int findContentChildren3(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int answer = 0;
        while (i < g.length && j < s.length) {
//            if (g[i] <= s[j]) {
//                i++;
//            }
//            j++;
            if (g[i] <= s[j]) {
                answer++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return answer;
    }

    public static int findContentChildren4(int[] g, int[] s) {
        if (s == null || s.length == 0) {
            return 0;
        }
        if (g == null) {
            return s.length;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int numOfChildren = g.length, numOfCookies = s.length;
        int count = 0;
        for (int i = 0, j = 0; i < numOfChildren && j < numOfCookies; i++, j++) {
            while (j < numOfCookies && g[i] > s[j]) {
                j++;
            }
            if (j < numOfCookies) {
                count++;
            }
        }
        return count;
    }
}