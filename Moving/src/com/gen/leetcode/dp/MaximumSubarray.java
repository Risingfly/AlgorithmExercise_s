package com.gen.leetcode.dp;

/**
 * 问题:53
 * @author Genge
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum > 0){
//                sum代表i之前的数字的累加和,若大于0则可继续累加,否则抛弃,从i开始重新累加
                sum += nums[i];
            }else {
                sum = nums[i];
            }
            if (sum > max){
                max = sum;
            }
        }
        return max;
    }
}
