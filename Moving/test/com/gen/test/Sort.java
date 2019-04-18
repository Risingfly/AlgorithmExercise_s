package com.gen.test;

import java.util.Arrays;
import java.util.Scanner;

public class Sort {
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
        System.out.println("排序后数组："+Arrays.toString(heapSort(arr,arr.length)));
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
        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= i; j++) {
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
    public static int[] heapSort(int[] arr,int n){
        if (arr == null || n <= 0){
            return arr;
        }
//        调整初始大根堆
//        从第一个非叶子节点开始调整，从右至左，从下至上
        for (int i = (arr.length/2 - 1); i >= 0; i--) {
            adjustHeap(arr,i,n);
        }

//        交换堆顶元素与末尾元素，并再次调整剩下的，实现排序
        for (int i = arr.length - 1; i > 0 ; i--) {
//        数组下标0总是新堆的堆顶（堆中存储的是元素下标）
            swap(arr,i,0);
//         从堆顶开始调整
            adjustHeap(arr,0,i);
        }

        return arr;
    }
    public static void adjustHeap(int[] arr,int i,int len){
//        保存当前需要调整的元素
        int tmp = arr[i];
//        从当前节点的左子树节点开始直到最后一个节点进行调整
        for (int j = 2 * i + 1; j < len; j = 2 * j + 1) {
//            从左右子节点中找出一个大的与父节点比较
            if (j + 1 < len && arr[j] < arr[j + 1]){
//            右子节点大
                j++;
            }
//            此时表明子节点大于父节点
            if (arr[j] > tmp){
//            将父节点直接替换为大的子节点，并记录大子节点的位置
                arr[i] = arr[j];
                i = j;
            }else {
                break;
            }
        }
//        将父节点放到最终位置
        arr[i] = tmp;
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
