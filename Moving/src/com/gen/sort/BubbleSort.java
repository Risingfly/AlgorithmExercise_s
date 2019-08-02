package com.gen.sort;

import java.util.Arrays;

/**
 * 问题：冒泡排序
 * 思路：刚开始的交换规模为0到n-1，从第一个数开始，将相邻两个数进行比较，
 * 大的放在后面，然后继续比较第二个数和第三个数，将大的放在后面，
 * 直到比较到最后一个数，即为最大值，然后缩小规模为0到n-2，得到第二大值，
 * 以此类推直到规模为1，数组有序
 * 平均和最坏时间复杂度 O(n^2) 最好O(n) 空间复杂度O(1)  稳定
 * @author Genge
 */
public class BubbleSort {
    public static int[] bubleSort(int[] arr){
        if (arr == null || arr.length == 0){
            return arr;
        }
//        需要比较 n - 1次，逆向是因为当数据比较到后面的位置后，交换停止，方便再缩小规模
        for (int i = arr.length - 1; i >= 1; i--) {
//            每个都是从0开始比较到后面的数，相邻的进行比较
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]){
                    swap(arr,j,j + 1);
                }
            }
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
        bubleSort(arr);
        System.out.println("after sort:"+Arrays.toString(arr));
    }
}
