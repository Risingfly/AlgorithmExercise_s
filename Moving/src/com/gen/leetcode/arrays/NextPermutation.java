package com.gen.leetcode.arrays;

import java.util.Arrays;

/**
 * 问题:31
 * 下一个字典全排列
 * 思路:1-- 从数组后向前寻找第一个nums[i - 1] < nums[i]的位置,并记录i - 1的位置为first(若没找到,则说明该数组逆序,重新升序排序即可)
 *      2-- 从first + 1 到数组末尾寻找大于nums[i - 1]的最小的那个数,并记录位置firstMinIndex
 *      3-- 交换nums[i - 1] 和 nums[firstMinIndex]
 *      4-- 将first + 1 到数组末尾重新排序,over
 * @author Genge
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int firstIndex = -1;
        int max = Integer.MAX_VALUE;
        int firstMinIndex = -1;
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i - 1] < nums[i]){
                firstIndex = i - 1;
                break;
            }
        }
        if(firstIndex == -1){
            Arrays.sort(nums);
            return;
        }
        for(int i = firstIndex + 1; i < nums.length; i++){
            if(nums[i] > nums[firstIndex]){
                if(nums[i] < max){
                    max = nums[i];
                    firstMinIndex = i;
                }
            }
        }
        swap(nums,firstIndex,firstMinIndex);
        Arrays.sort(nums,firstIndex + 1,nums.length);
    }
    private void swap(int[] nums,int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
