package com.gen.leetcode.bits;

/**
 * 问题:260
 * @author Genge
 */
public class SingleNumberIII{
    public int[] singleNumber2(int[] nums){
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp ^= nums[i];
        }
        int numHasOne = 0;
//      取反再加1再与原数相与即可得到最右边包含1的位置的数 (只有最右边有1,其他位为0)
        int rightOne = tmp & (~tmp + 1);
        for (int num: nums) {
            if ((num & rightOne) != 0){
                numHasOne ^= num;
            }
        }
        int[] res = new int[2];
        res[0] = numHasOne;
        res[1] = numHasOne ^ tmp;
        return res;
    }

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
