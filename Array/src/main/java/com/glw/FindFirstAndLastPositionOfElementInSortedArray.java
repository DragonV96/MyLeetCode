package com.glw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author glw
 * @date 2019/1/22 9:24
 * 34. Find First and Last Position of Element in Sorted Array
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    // 我的答案
    public static int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int result[] = {-1, -1};
        // 长度为0的数组优先判断
        if (length == 0) {
            return result;
        } else if (target < nums[0] || target > nums[length - 1]) { // 目标值小于数组最小值或者大于数组最大值直接返回
            return result;
        }
        List<Integer> temp = new ArrayList<>();
        int i;
        if (length % 2 == 0) {
            // 偶数个元素的数组从中间分成两部分遍历
            i = length/2;
        } else {
            // 寄数个元素的数组从中间分成两部分遍历
            i = (length - 1) / 2;
        }
        if (target > nums[i]) { // 目标值大于数组中位数
            while (i < length) {
                if (target == nums[i]) {
                    temp.add(i);
                }
                i++;
            }
            if (temp.size() > 0) {
                result[0] = temp.get(0);
                result[1] = temp.get(temp.size() - 1);
            }
        } else if (target < nums[i]) {  // 目标值小于数组中位数
            while (i >= 0) {
                if (target == nums[i]) {
                    temp.add(i);
                }
                i--;
            }
            if (temp.size() > 0) {
                result[0] = temp.get(temp.size() - 1);
                result[1] = temp.get(0);
            }
        } else {    // 目标值等于数组中位数
            int j = i;
            List<Integer> nextList = new ArrayList<>();
            // 取结束位置
            while (i < length && target == nums[i]) {
                temp.add(i);
                i++;
            }
            // 取开始位置
            while (j >= 0 && target == nums[j]) {
                nextList.add(j);
                j--;
            }
            if (temp.size() > 0 && nextList.size() > 0) {
                result[0] = nextList.get(nextList.size() - 1);
                result[1] = temp.get(temp.size() - 1);
            }
        }
        return result;
    }

    // 官方答案
    public static int[] searchRangeOffice(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // leftIdx在数组边界且等于对应的当前元素不等于target
        // 在数组nums中
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }
    // 返回target的左边最大边界值或者右边边界最大值
    // 通过二分查找法搜索数组nums
    private static int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3};
        int[] result = searchRange(nums, 1);
        System.out.println("我的答案   数组：" + Arrays.toString(nums) + " 目标值：1" + "\n结果：" + Arrays.toString(result));
        int[] nums1 = new int[]{1,3};
        int[] result1 = searchRangeOffice(nums1, 3);
        System.out.println("官方答案   数组：" + Arrays.toString(nums1) + " 目标值：3" + "\n结果：" + Arrays.toString(result1));
    }
}
