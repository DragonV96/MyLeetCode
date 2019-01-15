package com.glw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author glw
 * @date 2019/1/15 9:42
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例:
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int arrLength = height.length;
        if (arrLength != 0) {
            int width = 0;
            int maxArea = 0;
            int areaTmp = 0;
            int i = 0;
            int j = arrLength - 1;
            while(i < j) {
                width = j - i;
                if (height[i] < height[j]) {
                    areaTmp = width * height[i];
                    if (areaTmp > maxArea) {
                        maxArea = areaTmp;
                    }
                    i++;
                } else {
                    areaTmp = width * height[j];
                    if (areaTmp > maxArea) {
                        maxArea = areaTmp;
                    }
                    j--;
                }
            }
            return maxArea;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        int result = maxArea(nums);
        System.out.println("我的答案   数组：" + Arrays.toString(nums) + "结果：" + result);
    }
}
