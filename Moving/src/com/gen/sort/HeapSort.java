package com.gen.sort;

import java.util.Arrays;

/**
 * 问题：堆排序
 * 最好最坏平均情况均为O（nlog(n)）,空间复杂度为O（1），使用递归则为O（log(n)）
 * 不稳定排序
 * @author Genge
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {9,6,12,32,23,11,2,100,85};
        System.out.println("排序前："+ Arrays.toString(arr));
        heapSort(arr);
        System.out.println("排序后："+Arrays.toString(arr));
    }

    /**
     * 先建堆，然后将堆顶和最后一个元素交换，再缩小范围
     * @param arr
     */
    public static void heapSort(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }
//        建堆
        buildHeap(arr);
//        下标从0开始，已建堆一次了，所以i从length - 1开始
        for (int i = arr.length - 1; i > 0 ; i--) {
//            将堆顶和堆尾进行交换
            swap(arr,i,0);
//            缩小数组长度继续调整堆，此刻的i为size
            adjustHeap(arr,0,i);
        }
    }

    /**
     * 从第一个非叶子节点开始建堆，并调整
     * @param arr
     */
    public static void buildHeap(int[] arr){
        if (arr == null){
            return;
        }
//        从第一个非叶子节点进行调整建堆
        for (int i = arr.length/2; i >= 0 ; i--) {
            adjustHeap(arr,i,arr.length);
        }
    }

    /**
     * 从上往下调整堆
     * @param arr
     * @param parent 父节点必须为非叶子节点（堆为一棵完全二叉树）
     * @param size 该堆对应的数组长度
     */
    public static void adjustHeap(int[] arr,int parent,int size){
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
//        save current location
        int tmp = parent;
//        下标必须为非叶子节点
        if (parent < size / 2){
            if (left < size && arr[tmp] < arr[left]){
                tmp = left;
            }
            if (right < size && arr[tmp] < arr[right]){
                tmp = right;
            }
            if (tmp != parent){
                swap(arr,tmp,parent);
//                以调整后的位置作为新的父节点进行递归调整
                adjustHeap(arr,tmp,size);
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
