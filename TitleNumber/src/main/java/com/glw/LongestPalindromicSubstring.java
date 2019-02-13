package com.glw;

/**
 * @author glw
 * @date 2019/2/2 10:06
 * 5. Longest Palindromic Substring
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";     // 字符串不存在时返回空
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {  // 循环指针i
            int len1 = expandAroundCenter(s, i, i);    // 判断偶数回文串
            int len2 = expandAroundCenter(s, i, i + 1);    // 判断奇数回文串
            int len = Math.max(len1, len2);     // 取出长度最长的回文字符串长度值
            if (len > end - start) {    // 比较当前回文串的长度和上一个回文串的长度，若大于上一个，则将start和end设置为当前最长的
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    // 取以left和right为中心的回文串，并返回它的长度值
    private static int expandAroundCenter(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static void main(String[] args) {
        String input = "dsafsgaagsss";
        String result = longestPalindrome(input);
        System.out.println("官方答案：   输入字符串：" + input + "\n结果：" + result);
    }
}
