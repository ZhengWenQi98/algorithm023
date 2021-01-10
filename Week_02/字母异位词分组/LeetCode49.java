package cn.zwq.algorithm.middle;

import java.util.*;

/**
 * 49. 字母异位词分组
 *
 * @author G20200343200113
 */
public class LeetCode49 {

    /**
     * 遍历字符串数组，先对每个字符串进行排序，然后将排序后的字符串作为 HashMap 的 key，
     * 因为字母异位词排序后的字符串是相同的，所以字母异位词都是相同的 key，
     * 然后将未排序之前的字符串作为 ArrayList 的元素存储到 HashMap 的 value 当中
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 因为字符串都是小写字母，所以定义一个长度为 26 的整型数组，
     * 然后遍历字符串数组，统计单个字符串中每个字母出现个数，最终将字母和出现个数拼接成字符串，
     * 如果是字母异位词，那么拼接的结果是一样的，将之当成 HashMap 的 key，
     * 将相同的 key 对应的字符串存储到一个列表中
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {

        Map<String, List<String>> results = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    stringBuffer.append((char) ('a' + i));
                    stringBuffer.append(counts[i]);
                }
            }
            String key = stringBuffer.toString();
            List<String> list = results.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            results.put(key, list);
        }
        return new ArrayList<>(results.values());
    }

}