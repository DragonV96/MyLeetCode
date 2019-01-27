package com.glw;

import java.util.Arrays;
import java.util.List;

/**
 * @author glw
 * @date 2019/1/26 9:05
 * 41. First Missing Positive
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 * 输入: [1,2,0]
 * 输出: 3
 *
 * 示例 2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 *
 * 示例 3:
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *
 * 说明:
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 *
 * Success
 * Details
 * Runtime: 6 ms, faster than 75.64% of Java online submissions for First Missing Positive.
 */
public class FirstMissingPositive {

    //我的答案（空间复杂度为O(n)，不符合）
    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);  //排序
        int result = 1;
        if (nums.length == 0 || nums[0] > 1 || nums[nums.length - 1] < 1) { //若数组为空或数组第一个元素大于1或者数组最后一个元素小于1，则返回1
            return result;
        } else {
            int i = 0;
            result = -1;
            while (i < nums.length - 1) {
                if (nums[i] < 0 && nums[i + 1] > 1) {   //当前一个元素为负数时
                    result = 1;
                    break;
                } else if (nums[i] >= 0 && nums[i + 1] > 1) {   //当前两个元素都为正数时
                    if (nums[i + 1] - nums[i] > 1) {
                        result = nums[i] + 1;
                        break;
                    }
                }
                i++;
            }
            if (result == -1) {     // 若result仍然为-1，则表示数组为从1或者从0开始的连续数组
                result = nums[nums.length - 1] + 1;
            }
        }
        return result;
    }

    public static int firstMissingPositiveOhters(int[] nums) {
        int n = nums.length;
        //将正数移到前边，并且得到正数的个数
        int k = positiveNumber(nums);
        for (int i = 0; i < k; i++) {
            //得到要标记的下标
            int index = Math.abs(nums[i]) - 1;
            if (index < k) {
                //判断要标记的位置的数是不是小于 0，不是小于 0 就取相反数
                int temp = Math.abs(nums[index]);
                nums[index] = temp < 0 ? temp : -temp;
            }
        }
        //找到第一个大于 0 的位置
        for (int i = 0; i < k; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return k + 1;
    }

    private static int positiveNumber(int[] nums) {
        //解法一 把负数和 0 全部交换到最后
    /*    int n = nums.length;
    for (int i = 0; i < n; i++) {
        while (nums[i] <= 0) {
            swap(nums, i, n - 1);
            n--;
            if (i == n) {
                break;
            }
        }
    }*/

        //解法二 用一个指针 p ，保证 p 之前的都是正数。遍历 nums，每遇到一个正数就把它交换到 p 指针的位置，并且 p 指针后移
        int n = nums.length;
        int p = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                swap(nums, i, p);
                p++;
            }
        }
        return p;

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0};
        int result = firstMissingPositive(nums);
        System.out.println("我的答案：   数组：" + Arrays.toString(nums) + "\n结果：" + result);
        int[] nums1 = new int[]{1,2,0};
        int result1 = firstMissingPositiveOhters(nums1);
        System.out.println("大佬的答案：   数组：" + Arrays.toString(nums1) + "\n结果：" + result1);
    }
}
