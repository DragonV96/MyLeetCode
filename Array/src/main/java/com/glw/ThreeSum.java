package com.glw;

import java.util.Arrays;
import java.util.List;

import static com.glw.ContainerWithMostWater.maxArea;

/**
 * @author glw
 * @date 2019/1/15 11:13
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {

        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        List result = threeSum(nums);
        System.out.println("我的答案   数组：" + Arrays.toString(nums) + "结果：" + result);
    }
}
