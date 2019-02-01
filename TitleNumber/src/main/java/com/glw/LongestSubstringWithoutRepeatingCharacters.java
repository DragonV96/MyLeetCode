package com.glw;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by glw
 * 2019/2/1 21:31
 * 3. Longest Substring Without Repeating Characters
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 *
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LongestSubstringWithoutRepeatingCharacters {

    // 官方答案
    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length < 2) return length;
        int result = 0;
        Map<Character, Integer> temp = new HashMap<>();     //用来存储字符串中临时的单个字符与对应索引
        for (int i = 0, j = 0; j < length; j++) {
            if (temp.containsKey(s.charAt(j))) {
                i = Math.max(temp.get(s.charAt(j)), i);
            }
            result = Math.max(result, j - i + 1);     //将temp中的无重复字符串长度与上一个结果对比，取最大的
            temp.put(s.charAt(j), j + 1);       // +1是与字符串位数对应
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "dsafsgaasssg";
        int result = lengthOfLongestSubstring(input);
        System.out.println("我的答案：   输入字符串：" + input + "\n结果：" + result);
    }
}
