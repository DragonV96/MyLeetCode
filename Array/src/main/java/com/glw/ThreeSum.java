package com.glw;

import java.util.*;

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
    public static Set<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> resultList = new ArrayList<>();
        if (length > 2) {
            Arrays.sort(nums);
            int i = 0;
            int[] temp = new int[3];
            for (; i < nums.length; i++) {
                int target = -nums[i];
                int left = i + 1;
                int right = length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        List<Integer> elements = new ArrayList<>(3);
                        temp[0] = nums[i];
                        temp[1] = nums[left];
                        temp[2] = nums[right];
                        elements.add(temp[0]);
                        elements.add(temp[1]);
                        elements.add(temp[2]);
                        resultList.add(elements);
                        if (left < right && nums[left] == temp[1]) {
                            left++;
                        } else  if (left > right && nums[right] == temp[2]) {
                            right--;
                        }
                    }
                    if (i + 1 < length && nums[i + 1] == nums[i]) {
                        i++;
                    }
                }
            }
        }
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < resultList.size() - 1; i++) {
            result.add(resultList.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0,0,0,0};
        Set result1 = threeSum(nums1);
        System.out.println("我的答案1   数组：" + Arrays.toString(nums1) + "\n结果：" + result1);
        int[] nums2 = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        Set result2 = threeSum(nums2);
        System.out.println("我的答案2   数组：" + Arrays.toString(nums2) + "\n结果：" + result2);
    }
}
