package com.gen.sword.offer;

/**
 * 问题：求一串数字中最大连续子数组的和
 * @author Genge
 */
public class MaxSequenceNum {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length <= 0){
            return 0;
        }
        int total = array[0];
        int Max = array[0];
        for (int i = 1; i < array.length; i++) {
//            total只要大于0，就一直加下去，对于找到最大值有效果，若小于0，则表示之前的累积都是负数可以抛弃
//            从新开始
            if (total > 0){
                total += array[i];
            }else {
                total = array[i];
            }
//            Max记录total累积过程中的最大值
            if (total > Max){
                Max = total;
            }
        }
        return Max;
    }
}
