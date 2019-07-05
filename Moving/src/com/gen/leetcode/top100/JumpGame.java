package com.gen.leetcode.top100;

/**
 * 问题：55
 * 思路：记录当前位置i + nums[i]能够达到的最远距离，若大于等于 nums.length - 1，则可以
 * 前提能够达到下一位置，因此 i <= max 如[0,1,3]则无法到达下一位置
 * @author Genge
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0; i <= max; i++){
            max = Math.max(max,nums[i] + i);
            if (max >= nums.length - 1){
                return true;
            }
        }
        return false;
    }
}
