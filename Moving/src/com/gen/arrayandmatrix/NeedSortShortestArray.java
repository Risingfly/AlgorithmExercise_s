package com.gen.arrayandmatrix;

/***
 * 需要排序的最短子数组长度
 * 解法：从最右边找到最后一个左边比右边大的数位置，再从最左边找到
 * 最后一个右边比左边大的数
 * @author Genge
 */
public class NeedSortShortestArray {
    private static int len(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }

        int noMinIndex = -1;
        int min = arr[arr.length - 1];
        int noMaxIndex = -1;
        int max = arr[0];

        for (int i = arr.length - 2; i >= 0 ; i--) {
            if (arr[i] > min){
                noMinIndex = i;
            }else {
                min = Math.min(min,arr[i]);
            }
        }
        if (noMinIndex == -1){
            return 0;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < max){
                noMaxIndex = i;
            }else {
                max = Math.max(arr[i],max);
            }
        }
        return (noMaxIndex - noMinIndex + 1);
    }
}
