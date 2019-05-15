package com.gen.leetcode.bits;

/**
 * 问题：169
 * @author Genge
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int res = 0;
        for (int num: nums) {
            if (count == 0){
                res = num;
            }else if (res != num){
                count--;
            }else {
                count++;
            }
        }
        return res;
    }
}
