package com.glw;

/**
 * @author glw
 * @date 2019/2/25 8:50
 * 7. Reverse Integer
 *给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 *  示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 *
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class ReverseInteger {

    public static int reverse(int x) {
        String input = String.valueOf(x);
        int i = input.length() - 1;
        StringBuilder resultStr = new StringBuilder();
        // 转置
        while (i>= 0) {
            resultStr.append(input.charAt(i));
            i--;
        }
        //将负号转换到最前面
        if (!Character.isDigit(resultStr.toString().charAt(input.length() - 1))) {
            resultStr.deleteCharAt(input.length() - 1);
            resultStr.insert(0, "-");
        }
        int result = 0;
        try {
            result = Integer.parseInt(resultStr.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int input = 964624351;
        int result = reverse(input);
        System.out.println("我的答案：   输入数字：" + input + "\n结果：" + result);
    }

}
