package com.gen.test4;

import java.util.Arrays;

public class QuickTest {
    public static void main(String[] args) {
        int[] arr = {2,312,1,45,54,7,645,23,4342,56,5674,345,453};
        System.out.println("before sort:"+ Arrays.toString(arr));
//        System.out.println("after sort:"+ Arrays.toString(heapSortTest(arr)));
    }
//    private static int[] heapSortTest(int[] arr){
//        buildHeap(arr);
//        for (int i = arr.length - 1; i > 0 ; i--) {
//            swap(arr,i,0);
//            adjustHeap(arr,0,i);
//        }
//        return arr;
//    }
//    private static void buildHeap(int[] arr){
//        if (arr == null || arr.length == 0){
//            return;
//        }
//        for (int i = arr.length/2 - 1; i >= 0; i--) {
//            adjustHeap(arr,i,arr.length);
//        }
//    }
//    private static void adjustHeap(int[] arr,int parent,int size){
//        int l = parent * 2 + 1;
//        int r = parent * 2 + 2;
//        int tmp = parent;
//        if (parent < size/2){
//            if (l < size && arr[l] > arr[tmp]){
//                tmp = l;
//            }
//            if (r < size && arr[r] > arr[tmp]){
//                tmp = r;
//            }
//            if (tmp != parent){
//                swap(arr,tmp,parent);
//                adjustHeap(arr,tmp,size);
//            }
//        }
//    }
//    private static void swap(int[] arr,int l,int r){
//        int tmp = arr[l];
//        arr[l] = arr[r];
//        arr[r] = tmp;
//    }
//    private static int[] mergeSortTest(int[] arr,int left,int right){
//        if (arr == null || left >= right){
//            return arr;
//        }
//        int mid = left + (right - left) / 2;
//        mergeSortTest(arr,left,mid);
//        mergeSortTest(arr,mid + 1,right);
//        merge(arr,left,mid,right);
//        return arr;
//    }
//    private static void merge(int[] arr,int left,int mid,int right){
//        int[] tmp = new int[arr.length];
//        int index = left;
//        int count = left;
//        int midNext = mid + 1;
//        while (left <= mid && midNext <= right){
//            if (arr[left] < arr[midNext]){
//                tmp[index++] = arr[left++];
//            }else {
//                tmp[index++] = arr[midNext++];
//            }
//        }
//        while (left <= mid){
//            tmp[index++] = arr[left++];
//        }
//        while (midNext <= right){
//            tmp[index++] = arr[midNext++];
//        }
//        while (count <= right){
//            arr[count] = tmp[count];
//            count++;
//        }
//    }
//    private static int[] quickSortTest(int[] arr,int left,int right){
//        if (arr == null || left >= right){
//            return arr;
//        }
//        int l = left;
//        int r = right;
//        int tmp = arr[left];
//        while (l < r){
//            while (l < r && arr[r] > tmp){
//                r--;
//            }
//            if (l < r){
//                arr[l++] = arr[r];
//            }
//            while (l < r && arr[l] < tmp){
//                l++;
//            }
//            if (l < r){
//                arr[r--] = arr[l];
//            }
//        }
//        int index = l;
//        arr[index] = tmp;
//        quickSortTest(arr,left,index - 1);
//        quickSortTest(arr,index + 1,right);
//        return arr;
//    }
}
