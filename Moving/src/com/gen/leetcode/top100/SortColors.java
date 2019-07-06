package com.gen.leetcode.top100;

/**
 * 问题：75
 * 思路：双指针问题，左指针遇到0与之交换，右指针遇到2与之交换（设置一个变量从开始指针，
 * 网右累加直到大于右指针）
 * 重点提示：该变量在发生右指针交换的时候不累加，因为此时不知交换过的数是谁，任要和指针比较
 * @author Genge
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2){
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (i <= right){
            if (nums[i] == 0){
                swap(nums,i,left);
                left++;
                i++;
            }else if (nums[i] == 2){
                swap(nums,i,right);
//                交换时变量i 此时不累加
                right--;
            }else{
                i++;
            }
        }
    }
    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
