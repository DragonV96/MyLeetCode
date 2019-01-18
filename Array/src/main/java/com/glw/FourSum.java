package com.glw;

import java.util.*;

/**
 * @author glw
 * @date 2019/1/18 10:20
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 注意：
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> resultSet = new HashSet<>();
        int length = nums.length;
        Arrays.sort(nums);  //数组排序（由小到大）
        for (int i = 0; i < length - 3; i++) {
            if (nums[i]<<2 > target) {  //若第一个数乘以2大于给定值，则不可能存在数组使得元素和为target
                break;
            }
            for (int j = length - 1; j >i + 2; j--) {
                if (nums[j]<<2 < target) {  //若最后一个数乘以2于于给定值，则不可能存在数组使得元素和为target
                    break;
                }
                int left = i + 1;
                int right = j - 1;
                int outerTarget = target - nums[i] - nums[j];
                while (left < right) {
                    int innerTarget = nums[left] + nums[right];
                    if (innerTarget > outerTarget) {
                        right--;
                    } else if (innerTarget < outerTarget) {
                        left++;
                    } else {
                        List<Integer> elements = new ArrayList<>();
                        elements.add(nums[i]);
                        elements.add(nums[left]);
                        elements.add(nums[right]);
                        elements.add(nums[j]);
                        resultSet.add(elements);    // 存入Set集合去重
                        left++;
                    }
                }
                while (j >= 1 && nums[j] == nums[j-1]) --j;
            }
            while (i < length - 1 && nums[i] == nums[i+1]) ++i;
        }
        Iterator it = resultSet.iterator();
        while(it.hasNext()){
            result.add((List<Integer>) it.next());
        }
        return  result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 0, -1, 0, -2, 2};
        int[] nums2 = new int[]{-4,-3,-2,-1,0,0,1,2,3,4,6};
        List result1 = fourSum(nums1,0);
        List result2 = fourSum(nums2,0);
        System.out.println("我的答案   数组：" + Arrays.toString(nums1) + "\n结果：" + result1);
        System.out.println("我的答案   数组：" + Arrays.toString(nums2) + "\n结果：" + result2);
    }
}
