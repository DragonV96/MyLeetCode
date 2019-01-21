package com.glw;

import java.util.Arrays;

/**
 * @author glw
 * @date 2019/1/21 9:36
 *
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
