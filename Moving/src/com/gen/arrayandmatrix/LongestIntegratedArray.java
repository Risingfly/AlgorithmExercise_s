package com.gen.arrayandmatrix;

import java.util.HashSet;

/***
 * 最长的可整合子数组的长度
 * 解法：一个数组中如果没有重复元素，并且如果最大值减去最小值再加1，
 * 的结果等于元素个数（max - min + 1），则为可整合数组。
 * @author Genge
 */
public class LongestIntegratedArray {
    private static int getLong(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int max = 0;
        int min = 0;
        int len = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                if (set.contains(arr[j])){
                    break;
                }
                set.add(arr[j]);
                max = Math.max(max,arr[j]);
                min = Math.min(min,arr[j]);
                if (max - min == j - i){
                    len = Math.max(len,j - i + 1);
                }
            }
            set.clear();
        }
        return len;
    }
}
