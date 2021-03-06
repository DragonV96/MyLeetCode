package com.glw;

import java.util.*;


/**
 * @author glw
 * @date 2019/1/17 9:53
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        int sum = 0;
        int closestSum = nums[0] + nums[1] + nums[length - 1];    //先取一个最外侧的三个数作为第一次的比较对象
        Arrays.sort(nums);      //先排序
        for (int i = 0; i < length; i++) {
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (target > sum) {     //给定值大于和，说明3个数整体偏小，向右靠
                    left++;
                } else {      //给定值小于和，说明3个数整体偏大，向左靠
                    right--;
                }
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        int result = threeSumClosest(nums,1);
        System.out.println("我的答案   数组：" + Arrays.toString(nums) + "\n结果：" + result);
    }
}
