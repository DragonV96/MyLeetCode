package com.glw;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class  RemoveDuplicatesfromSortedArray{

    public static int removeDuplicates(int[] nums) {
        int result = 0;
        Set numsSet = new HashSet();
        for (int i = 0; i < nums.length - 1; i++) {
            numsSet.add(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0};
        int result = removeDuplicates(nums);
        System.out.println("我的答案1   数组：" + Arrays.toString(nums) + "\n结果：" + result);
    }
}
