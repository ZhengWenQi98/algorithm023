package cn.zwq.algorithm.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 *
 * @author G20200343200113
 */
public class LeetCode242 {

    /**
     * 1.使用 HashMap 统计一个字符串各个字母出现的次数
     * 2.遍历另一个字符串，拿到每一个字母，判断 HashMap key 是否包含该字母，
     * 包含，key 对应的值减 1，最终 HashMap 所有 key 对应的值都为 0 说明两个字符串才是字母异位词
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        Map<Character, Integer> chars = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (chars.containsKey(c)) {
                chars.put(c, chars.get(c) + 1);
            } else {
                chars.put(c, 1);
            }
        }
        for (char c : t.toCharArray()) {
            if (chars.containsKey(c) && chars.get(c) > 0) {
                chars.put(c, chars.get(c) - 1);
            } else {
                chars.put(c, 1);
            }
        }
        for (Character character : chars.keySet()) {
            if (chars.get(character) != 0) {
                return false;
            }
        }
        return true;
    }

}