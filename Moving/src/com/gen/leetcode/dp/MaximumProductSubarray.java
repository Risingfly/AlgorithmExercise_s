package com.gen.leetcode.dp;

/**
 * 问题:152
 * 思路:一个保存当前最小,一个保存当前最大,当前变为负数时,则最大和最小交换,最终获得最大
 * @author Genge
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len <= 0){
            return 0;
        }
        int curMax = nums[0];
        int imax = nums[0];
        int imin = nums[0];
        for (int i = 1; i < len; i++) {
//            当前值为负数,则大小交换(当前为负数时,大会变小,小会变大)
            if (nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
//            存储二者中大的
            imax = Math.max(nums[i],nums[i] * imax);
//            存储二者中小的(当前为负数时,大会变小,小会变大)
            imin = Math.min(nums[i],nums[i] * imin);
//            存储当前最大
            curMax = Math.max(imax,curMax);
        }
        return curMax;
    }
    public void swap(int a, int b){
        int tmp = a;
        a = b;
        b = tmp;
    }
}
