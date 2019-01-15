package com.glw;

import java.util.Arrays;

/**
 * @author glw
 * @date 2019/1/14 9:10
 */
public class MedianOfTwoSortedArrays {
//    public static double findMedianSortednums1rrays(int[] nums1, int[] nums2) {
//        int index = nums1.length + nums2.length;
//        int[] nums = new int[index];
//        int i = 0;
//        List temp = new nums1rrayList();
//        do{
//            if (nums1[i] < nums2[index - i - 1]) {
//                nums[i] = nums1[i];
//                nums[index - i - 1] = nums2[index - i - 1];
//            } else {
//                nums[i] = nums2[i];
//                nums[index - i - 1] = nums1[index - i - 1];
//            }
//            i++;
//        }while(i < index);
//        double result = index%2;
//        if (result == 0.0) {
//            result = nums[index/2 + 1];
//        } else {
//            result = (nums[(index+1)/2] + nums[(index-1)/2])/2;
//        }
//        return result;
//    }

    public static double findMedianSortednums1rraysOffice(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) { //m大于n时
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j-1] > nums1[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && nums1[i-1] > nums2[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = nums2[j-1]; }
                else if (j == 0) { maxLeft = nums1[i-1]; }
                else { maxLeft = Math.max(nums1[i-1], nums2[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = nums2[j]; }
                else if (j == n) { minRight = nums1[i]; }
                else { minRight = Math.min(nums2[j], nums1[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        double result = findMedianSortednums1rraysOffice(nums1, nums2);
        System.out.println("我的答案   数组1：" + Arrays.toString(nums1) + ",数组2：" + Arrays.toString(nums2) + "结果：" + result);
    }
}
