package com.gen.sort;

import java.util.Arrays;

/**
 * 问题：归并排序
 * 最好最坏情况时间复杂度O(nlog(n)),空间复杂度O(n)(借用额外数组)，稳定排序
 * @author Genge
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1};
        System.out.println("before sort:"+ Arrays.toString(arr));
        mergeSort(arr,0,arr.length - 1);
        System.out.println("after sort:"+Arrays.toString(arr));
    }

    /**
     * 递归的划分数组，然后合并排序
     * @param arr
     * @param left
     * @param right
     */
    public static void mergeSort(int[] arr,int left,int right){
        if (arr == null || arr.length == 0 || left >= right){
            return;
        }
        int mid = (left + right) >> 1;
//        左右递归划分至两个最小的数组
        mergeSort(arr,left,mid);
        mergeSort(arr,mid + 1,right);
//        归并排序两个数组
        merge(arr,left,mid,right);
    }

    /**
     * 该函数主要将arr数组中 left - mid 和 mid + 1 - right 进行归并
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(int[] arr,int left,int mid,int right){
//        归并所需的临时数组
        int[] tmp = new int[arr.length];
//        右边的第一个位置
        int midNext = mid + 1;
//        每次都从left开始拷贝至right
        int index = left;
//        后续拷贝使用
        int count = left;

//        从两个小的数组中比较，每次将二者中小的放入临时数组中
        while (left <= mid && midNext <= right){
            if (arr[left] < arr[midNext]){
                tmp[index++] = arr[left++];
            }else {
                tmp[index++] = arr[midNext++];
            }
        }
//        将两个数组中可能剩余的数拷贝至临时数组
        while (left <= mid){
            tmp[index++] = arr[left++];
        }
        while (midNext <= right){
            tmp[index++] = arr[midNext++];
        }
//        重新将临时数组中的数据拷贝至原数组，完成排序
        while (count <= right){
            arr[count] = tmp[count];
            count++;
        }
    }
}
