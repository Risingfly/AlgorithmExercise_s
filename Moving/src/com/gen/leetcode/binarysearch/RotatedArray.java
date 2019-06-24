package com.gen.leetcode.binarysearch;

/**
 * 问题：81
 * 通过nums[mid] > nums[end]将数组划分成两种情况：
 * 1--》 nums[mid] > nums[end]，说明上半部乱序，在此情况及进行二分查找划分
 * 2--》nums[mid] < nums[end],说明上半部有序，再进行二分查找
 * 3--》nums[mid] == nums[end]，说明这一段都是重复的，所以end--
 * @author Genge
 */
public class RotatedArray {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
//        当查到相等都没有，必然不存在此数组中
        while(start <= end){
            int mid = (start + end) >> 1;
            if(nums[mid] == target){
                return true;
            }
            if(nums[mid] > nums[end]){
                if(target > nums[mid] || target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }else if(nums[mid] < nums[end]){
                if(target > nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }else{
                end--;
            }
        }

        return false;
    }
}
