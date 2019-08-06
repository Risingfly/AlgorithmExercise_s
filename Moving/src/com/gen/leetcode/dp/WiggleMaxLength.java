package com.gen.leetcode.dp;

/**
 * 问题：376
 * @author Genge
 */
public class WiggleMaxLength {
    public int wiggleMaxLength(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int down = 1, up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]){
                up = down + 1;
            }else if (nums[i] < nums[i - 1]){
                down = up + 1;
            }
        }
        return Math.max(up,down);
    }
}
