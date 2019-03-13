package com.glw;

/**
 * @author glw
 * @date 2019/3/13 9:19
 *
 * 9. Palindrome Number
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 * 输入: 121
 * 输出: true
 *
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        else if (x == reverseNumber(x)) {
            return true;
        }
        else {
            return false;
        }
    }

    private static int reverseNumber (int num) {
        int result = 0;
        while (num != 0){
            int d = num % 10;       // 取末位数
            result = result * 10 + d;
            num = num / 10;          // 取完末位数，位数减少一位
        }
        return result;
    }

    public static void main(String[] args) {
        int input = 0;
        boolean result = isPalindrome(input);
        System.out.println("我的答案：   输入数字：" + input + "\n结果：" + result);
    }
}
