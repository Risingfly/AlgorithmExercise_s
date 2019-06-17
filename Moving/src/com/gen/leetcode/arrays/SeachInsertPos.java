package com.gen.leetcode.arrays;

/**
 * 问题：35
 * @author Genge
 */
public class SeachInsertPos {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int id = search(nums,target);
        if(nums[id] == target){
            return id;
        }else if(nums[id] > target){
            return id;
        }else{
            return id + 1;
        }
    }
    public int search(int[]nums, int target){
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int mid = (l + r) >> 1;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
}
