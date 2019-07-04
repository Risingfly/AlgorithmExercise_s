package com.gen.sort;

import java.util.Arrays;

/**
 * 问题：插入排序
 * 思路：开始位置0 和 位置1 上的数据进行比较，小的放前面；然后继续位置2 和前面几个
 * 位置的数进行比较，小的插入前面；以此类推，位置n和前n - 1的位置上的数进行比较
 * 一共需要插入 n - 1次。
 * 平均时间复杂度O(n^2) 最好 O（n） 最坏O（n^2） 空间复杂度O（1） 稳定
 * @author Genge
 */
public class InsertSort {
    public static int[] insertSort(int[] arr){
        if (arr == null || arr.length == 0){
            return arr;
        }
        for (int i = 1; i < arr.length; i++) {
            int index = i;
//            从i的位置一直往前比
            while (index > 0){
                if (arr[index] < arr[index - 1]){
                    swap(arr,index,index - 1);
                    index--;
                }else {
//                    前面已有序，若不比当前小，则无需继续比较
                    break;
                }
            }
        }
        return arr;
    }
    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,5,2,3,5,6,9};
        System.out.println("before sort:"+ Arrays.toString(arr));
        insertSort(arr);
        System.out.println("after sort:"+Arrays.toString(arr));
    }
}
