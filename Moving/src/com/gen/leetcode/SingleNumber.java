package com.gen.leetcode;

/**
 * 问题：136
 * @author Genge
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
//        0异或任何数等于其本身
        int tmp = 0;
        for (int num: nums) {
            tmp ^= num;
        }
        return tmp;
    }
}
