package com.gen.leetcode;

/**
 * 问题:260
 * @author Genge
 */
public class SingleNumberIII{
    public int[] singleNumber(int[] nums){
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp ^= nums[i];
        }
//      二进制中该数第一个为1的位置
        int index = findFirstOneLocation(tmp);
        int[] res = new int[2];
//      用对应位置是否为1来划分数组
        for (int i = 0; i < nums.length; i++) {
            if (isOne(nums[i],index)){
                res[0] ^= nums[i];
            }else {
                res[1] ^= nums[i];
            }
        }
        return res;
    }

    public boolean isOne(int num,int index){
//      判断该数对应位是否为1
        return ((num >> index) & 1) == 1;
    }
    public int findFirstOneLocation(int num){
//      找到num二进制中第一个为1的位置
        int index = 0;
        while (index < 32 && ((num >> index) & 1) == 0){
            index++;
        }
        return index;
    }
}
