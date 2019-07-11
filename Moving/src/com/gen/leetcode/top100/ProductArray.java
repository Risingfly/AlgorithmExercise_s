package com.gen.leetcode.top100;

/**
 * 问题：238
 * 核心思路：先存放每个位置左边的累乘，再乘以 右边每个位置的累乘
 * 最左边的位置开始为1，同样最右边的位置为1（最左无左，最右无右，故放1）
 * @author Genge
 */
public class ProductArray {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0){
            return nums;
        }
        int[] out = new int[nums.length];
//        每个位置存放该位置左边所有数的乘积（第一个位置放1）
        for(int i = 0,tmp = 1; i < nums.length; i++){
            out[i] = tmp;
//            该位置包括之前的乘积，给下一个存放
            tmp *= nums[i];
        }
//        将上述结果再每个位置乘以该位置右边所有数的乘积（最后一个位置乘1）
        for(int i = nums.length - 1,tmp = 1; i >= 0; i--){
//
            out[i] *= tmp;
//            该位置右边的乘积累积给左边
            tmp *= nums[i];
        }
        return out;
    }
}
