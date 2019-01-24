package com.glw;

import java.util.*;

/**
 * @author glw
 * @date 2019/1/24 9:36
 * 39. Combination Sum
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 *
 * 示例 1:
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * 示例 2:
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(candidates);    //首先对数组进行排序
        // 调用递归方法
        getList(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }

    // 递归推算出每一个符合要求的list
    private static void getList (List<List<Integer>> result, List<Integer> tempList, int[] candidates, int target, int start) {
        if (target < 0) return; //target小于0直接返回
        else if (target == 0) result.add(new ArrayList<>(tempList)); //target等于0时加入List
        else {
            int i = start;
            while (i < candidates.length) {
                tempList.add(candidates[i]);
                getList(result, tempList, candidates, target - candidates[i], i);   //递归
                tempList.remove(tempList.size() - 1);   //移除上一次添加的无效元素
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,6,7};
        List result = combinationSum(nums, 6);
        System.out.println("我的答案：   数组：" + Arrays.toString(nums) + "\n结果：" + result.toString());
    }
}
