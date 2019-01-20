package com.glw;

import java.util.Arrays;

/**
 * Create by glw
 * 2019/1/20 17:07
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {

    // 我的答案
//    public static void nextPermutation(int[] nums) {
//        int temp = 0;
//        for (int x = 0; x < nums.length - 1; x++) {
//            if (nums[x] > nums[x + 1]) {
//                for (int k = x + 1; k < nums.length; k++) {
//                    if (nums[x] > nums[k]) {
//                        temp = nums[k];
//                        nums[k] = nums[x];
//                        nums[x] = temp;
//                    }
//                }
//            }
//        }
//    }

    // 官方答案
    public static void nextPermutationOffice(int[] nums) {
        int i = nums.length - 2;
        // 1. 从后往前找第一对两个连续的数字 a[i]a[i] 和 a[i-1]a[i−1]，使它们满足 a[i]>a[i-1]
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        // 2. 在数组从结尾到a[i]开始的降序部分中由右至左找出第一个比a[i-1]大的数a[j]
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // 交换a[j]与a[i]的位置
            swap(nums, i, j);
        }
        // 将a[i + 1]及其后面的元素按升序排序
        reverse(nums, i + 1);
    }

    // 将索引从第start开始的数组部分按升序排序
    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    // 交换数组中第i个与第j个的位置
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,5,0,1,7,3,2};
        System.out.println("执行之前   数组：" + Arrays.toString(nums) + "\n结果：");
        nextPermutationOffice(nums);
        System.out.println("官方答案   数组：" + Arrays.toString(nums) + "\n结果：");
    }
}
