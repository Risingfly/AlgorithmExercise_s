package com.gen.leetcode.arrays;

import java.util.Arrays;

/**
 * 问题:16
 * @author Genge
 */
public class SumCloset3 {
    public int threeSumClosest(int[] nums, int target) {
//        先排序再用双指针逼近
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[nums.length - 1];
//        因为三个数,所以长度小于2
        for(int i = 0;i < nums.length - 2;i++){
//            在i基础上向右逼近
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum > target){
                    end--;
                }else{
                    start++;
                }
//                每次更新新值与target之间的差值是否小于之前的res
                if(Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }
            }
        }
        return res;
    }
}
