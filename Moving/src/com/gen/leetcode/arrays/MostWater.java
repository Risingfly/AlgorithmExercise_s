package com.gen.leetcode.arrays;

/**
 * 问题:11
 * @author Genge
 */
public class MostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
//        双指针法
        while(left < right){
            max = Math.max(max,Math.min(height[left],height[right]) * (right - left));
//          指针对应位置小的要向大的方向移动(已被数学证明过)
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
