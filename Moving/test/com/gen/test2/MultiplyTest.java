package com.gen.test2;

import java.util.Arrays;

public class MultiplyTest {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3,4,4,4,4,6,7,7,8,8,5,4,45,6,7,65,4};
        System.out.println("input array= "+Arrays.toString(arr));
        System.out.println("after process res = "+Arrays.toString(productExceptSelf(arr)));
    }
    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0){
            return nums;
        }
        int[] out = new int[nums.length];
        for(int i = 0; i < out.length; i++){
            int tmp = nums[i];
            nums[i] = 1;
            out[i] = product(nums);
            nums[i] = tmp;
        }
        return out;
    }
    private static int product(int[] nums){
        int res = 1;
        for(int i = 0; i < nums.length; i++){
            res *= nums[i];
        }
        return res;
    }
}
