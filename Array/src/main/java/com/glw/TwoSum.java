package com.glw;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by glw
 * 2019/1/9 23:45
 * 1. Two Sum
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {

    //我的答案
    public static int[] twoSum(int[] nums, int target) {
        int[] temp = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int result = nums[i] + nums[j];
                if (result == target){
                    if (i != j) {
                        temp[0] = i;
                        temp[1] = j;
                    }
                }
            }
        }
        return temp;
    }

    // 官方答案
    public static int[] twoSumOffice(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];  // 将求两个值索引的问题转换为求单个值索引的问题
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two Sum solution");
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,4};
        int target = 6;
        int[] temp = twoSum(arr, target);
        int[] tempOffice = twoSumOffice(arr, target);
        System.out.println("我的答案   数组：" + Arrays.toString(arr) + ", 目标数：" + target + "结果：" + Arrays.toString(temp));
        System.out.println("官方答案   数组：" + Arrays.toString(arr) + ", 目标数：" + target + "结果：" + Arrays.toString(tempOffice));
    }
}
