package com.gen.leetcode.arrays;

/**
 * 问题：34
 * @author Genge
 */
public class FirstAndLastInSortArray {
    public int[] searchRange(int[] nums, int target) {
        int start = getIndex(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, getIndex(nums, target + 1) - 1};
    }
    public int getIndex(int[] nums,int target){
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int mid = (l + r) >> 1;
            if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }
}
