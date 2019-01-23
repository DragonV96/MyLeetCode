package com.glw;

import java.util.Arrays;

/**
 * @author glw
 * @date 2019/1/23 9:49
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right)/2; // 二分查找（时间复杂度为O(n),空间复杂度为O(1)）
            if (target == nums[mid]) {  // 与target值相等直接返回
                return mid;
            } else if (target > nums[mid]) {    // target值大于数组元素时，将left索引向右边的mid靠
                left = mid + 1;
            } else {
                right = mid - 1;    // target值小于数组元素时，将right索引向左边的mid靠
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,5};
        int result = searchInsert(nums, 4);
        System.out.println("我的答案：   数组：" + Arrays.toString(nums) + "\n结果：" + result);
    }
}
