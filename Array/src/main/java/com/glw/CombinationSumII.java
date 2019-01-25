package com.glw;

import java.util.*;

/**
 * @author glw
 * @date 2019/1/25 11:55
 * 40. Combination Sum II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 *
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class CombinationSumII {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> temp = new HashSet<>();
        Arrays.sort(candidates);    //排序
        getList(temp, new ArrayList<Integer>(), candidates, target, 0);
        Iterator it = temp.iterator();
        while (it.hasNext()) {
            result.add((List<Integer>) it.next());
        }
        return result;
    }

    // 递归求解集
    private static void getList (Set<List<Integer>> list, List<Integer> tempList, int[] nums, int target, int start) {
        if (target < 0) return;
        else if (target == 0) list.add(new ArrayList<>(tempList)); //target等于0时加入List
        else {
            int i = start;
            while (i < nums.length) {
                tempList.add(nums[i]);
                getList(list, tempList, nums, target - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);   //移除上一次添加的元素
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,1,2,7,6,1,5};
        List result = combinationSum2(nums, 8);
        System.out.println("我的答案：   数组：" + Arrays.toString(nums) + "\n结果：" + result.toString());
    }
}
