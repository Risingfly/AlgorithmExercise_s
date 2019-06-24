package com.gen.leetcode.binarysearch;

/**
 * 问题：153
 * 将右指针不断逼近较小的数，最终会落在最小处
 * @author Genge
 */
public class RotatedArrayMin {
    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
//            防止溢出
            int mid = start + ((end - start) >> 1);
//            右指针不断向小的方向移动
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return nums[start];
    }
}
