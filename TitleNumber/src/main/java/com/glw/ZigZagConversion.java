package com.glw;

/**
 * @author glw
 * @date 2019/2/16 8:49
 * <p>
 * 6. ZigZag Conversion
 * <p>
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * <p>
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * <p>
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * <p>
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * <p>
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class ZigZagConversion {

    // 我的答案
    public static String convert(String s, int numRows) {
        if (numRows < 2 || numRows >= s.length()) return s;   //行数小于2，行数不小于字符串长度等几种特殊情况
        int step = 2 * (numRows - 1);  // 推理出脚标的间距为step
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(appendResult(s, i, step, numRows));
        }
        return result.toString();
    }

    public static String appendResult(String s, int i, int step, int numRows) {
        StringBuilder part = new StringBuilder();
        // 分成两种情况，Z的边缘和Z的中间
        if (i == 0 || i == numRows - 1) {   //边缘 (0表示第一行，numRows - 1表示最后一行)
            int index = i;
            while (index < s.length()) {
                part.append(s.charAt(index));
                index += step;
            }
        } else {    //中间
            int index = step;
            part.append(s.charAt(i));
            while (index - i < s.length()) {
                part.append(s.charAt(index - i));
                if (index + i < s.length()) {
                    part.append(s.charAt(index + i));
                }
                index += step;
            }
        }
        return part.toString();
    }

    public static void main(String[] args) {
        String input = "LEE";
        String result = convert(input, 2);
        System.out.println("我的答案：\n输入：" + input + "\n结果：" + result);
    }
}
