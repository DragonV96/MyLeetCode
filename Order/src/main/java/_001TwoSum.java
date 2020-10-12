import constant.Constant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : glw
 * @date : 2020/10/11
 * @time : 23:31
 * @Description :
 * 1. 两数之和
 */
public class _001TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int rest = target - nums[i];
            if (numMap.containsKey(rest)) {
                return new int[]{numMap.get(rest), i};
            }
            numMap.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{2, 7, 11, 15};
        int target1 = 9;

        System.out.print(Constant.MY_ANSWER);
        System.out.println(Arrays.toString(twoSum(num1, target1)));
    }
}
