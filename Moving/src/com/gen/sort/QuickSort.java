package com.gen.sort;

import java.util.Arrays;

/**
 * 问题:快速排序
 * @author Genge
 */
public class QuickSort {
    public int[] quicksort(int[] arr, int left, int right){
        if (arr == null || arr.length == 0 || left > right){
            return arr;
        }
        int l = left;
        int r = right;
        int tmp = arr[left];
        while (l < r){
            while (l < r && arr[r] > tmp){
                r--;
            }
            if (l < r){
                arr[l] = arr[r];
                l++;
            }
            while (l < r && arr[l] < tmp){
                l++;
            }
            if (l < r){
                arr[r] = arr[l];
                r--;
            }
        }
        int index = l;
        arr[index] = tmp;
        quicksort(arr,left,index - 1);
        quicksort(arr,index + 1,right);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,60,1,2,7};
        QuickSort quickSort = new QuickSort();
        System.out.println("before:"+Arrays.toString(arr));
        quickSort.quicksort(arr,0,arr.length - 1);
        System.out.println("after:"+Arrays.toString(arr));
    }
    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
