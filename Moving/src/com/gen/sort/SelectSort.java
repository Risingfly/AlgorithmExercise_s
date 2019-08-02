package com.gen.sort;

import java.util.Arrays;

/**
 * 问题：选择排序
 * 思路：从第0个开始一共需要选择n - 1次，
 * 同时每次从当前坑位到最后一个进行比较选择最小的一个放入当前坑位
 * 平均 最好 最坏 时间复杂度都为O(n^ 2) 空间复杂度 O(1) 不稳定
 * @author Genge
 */
public class SelectSort {
    public static int[] selectSort(int[] arr){
        if (arr == null || arr.length == 0){
            return arr;
        }
//        需要选择n - 1次
        for (int i = 0; i < arr.length - 1; i++) {
//            每次从当前坑位到最后一个进行比较选择最小的一个放入当前坑位
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                min = arr[min] < arr[j] ? min : j;
            }
            swap(arr,min,i);
        }
        return arr;
    }
    public static void swap(int[] arr, int i ,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,2,3,5,6,9};
        System.out.println("before sort:"+ Arrays.toString(arr));
        selectSort(arr);
        System.out.println("after sort:"+Arrays.toString(arr));
    }
}
