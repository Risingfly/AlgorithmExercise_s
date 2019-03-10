package com.gen.arrayandmatrix;

/***
 * 给定一个长度为N的整形数组arr,其中有N个互不相等的自然数1 ~ n,请实现
 * arr的排序。
 *
 * @author Genge
 */
public class NatureNumSort {
    private static void sort(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }
        int tmp = 0;
        int next = 0;
        for (int i = 0; i < arr.length; i++) {
            tmp = arr[i];
            while (arr[i] != i + 1){
                next = tmp - 1;
                arr[tmp - 1] = tmp;
                tmp = next;
            }
        }
    }
}
