package com.gen.test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int[] arr = new int[10];
        int j = 0;
        System.out.println("请输入数组：");
        while (in.hasNext()){
            if (j >= 10){
                break;
            }
            arr[j++] = in.nextInt();
        }
        System.out.println("当前数组："+ Arrays.toString(arr));
        System.out.println("开始排序：=======");
        System.out.println("排序后数组："+Arrays.toString(quickSort(arr,0,arr.length - 1)));
    }
    public static int[] bubbleSort(int[] arr){
        if (arr == null || arr.length == 0){
            return null;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] > arr[j]){
                    swap(arr,j,j + 1);
                }
            }
        }
        return arr;
    }
    public static int[] selectSort(int[] arr, int n){
        if (arr == null || n <= 0){
            return arr;
        }

        for (int i = 0; i < n - 1 ; i++) {
            int tmp = arr[i];
            int k = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < tmp){
                    tmp = arr[j];
                    k = j;
                }
            }
            swap(arr,k,i);
        }
        return arr;
    }
    public static int[] insertSort(int[] arr, int n){
        if (arr == null || n <= 0){
            return arr;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]){
                    swap(arr,j,i);
                }
            }
        }
        return arr;
    }

    /***
     * 另第一个数为pivot,从右边起找比其小的，直接替换；从左边起，找其大的
     *直接替换，最终左右相等放入pivot;然后左右递归这个过程。
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int[] quickSort(int[] arr, int left, int right){
        if (arr == null || left >= right){
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
                arr[l++] = arr[r];
            }
            while (l < r && arr[l] < tmp){
                l++;
            }
            if (l < r){
                arr[r--] = arr[l];
            }
            arr[l] = tmp;
//            int k = l;
        }

        quickSort(arr,left,l - 1);
        quickSort(arr,l + 1,right);
        return arr;
    }
    public static void swap(int [] arr,int l,int r){
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
    public static int getSum(int n, int m){
        return (n/(2*m)) * m * m;
    }


}
