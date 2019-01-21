package com.glw;

import java.util.Arrays;

/**
 * @author glw
 * @date 2019/1/21 9:36
 *假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int index = -1, length = nums.length;
        if (length > 0) {   // 数组长度必须存在才能继续执行
            int i;
            // 当target小于数组第一个元素时，从数组末尾开始遍历
            if (target < nums[0]) {
                i = length - 1;
                while (i > 0) {
                    if (nums[i] == target) {
                        index = i;
                    }
                    i--;
                }
            } else if (target > nums[0]) {  // 当target大于数组第一个元素时，从数组首位开始遍历
                i = 0;
                while (i < length) {
                    if (nums[i] == target) {
                        index = i;
                    }
                    i++;
                }
            } else {    // 当target等于数组第一个元素时，返回当前元素索引0
                return 0;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,4,3,1};
        int result = search(nums, 1);
        System.out.println("我的答案：   数组：" + Arrays.toString(nums) + "\n结果：" + result);
    }
}
