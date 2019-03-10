package com.gen.arrayandmatrix;

/**
 * 不重复打印排序数组中相加和为给定值的所有二元组和三元组
 * （给定排序数组arr和整数k,不重复打印arr中所有相加和为k的不降序二元组）
 * 解法：有序数组可以通过，设置左右两个指针，向中间推进，若和小于k,则左加，
 * 若大于k，则右加，若等于且满足arr[i] != arr[i - 1],则表示满足条件，
 * （重点，可以使用|| 排除第一个不需要求前面节点不想同的地方）
 * @author Genge
 */
public class NoRepeatPrintArray {
    private static void printNoRepeatNum(int[] arr, int k){
        if (arr == null || arr.length == 0){
            return;
        }
        int left = 0;
        int right = arr.length - 1;
//        int sum = 0;
        while (left < right){
            if (arr[left] + arr[right] < k){
                left++;
            }else if (arr[left] + arr[right] > k){
                right--;
            }else {
                //使用||和left == 0,排除掉第一种特殊情况
                if (left == 0 || arr[left] != arr[left - 1]){
                    System.out.println(arr[left]+","+arr[right]);
                }
                left++;
                right--;
            }
        }
    }
//
//    private static void printThreeArray(int[] arr, int k){
//        if (arr == null || arr.length == 0){
//            return;
//        }
//        int left = 0;
//        int right = arr.length - 1;
//        int sum = 0;
//        for (int i = 0; i < arr.length; i++) {
//            sum = arr[i];
//            left = i;
//            while (left < right){
//                if (sum + arr[left] + arr[right] < k){
//                    left++;
//                }else if (sum + arr[left] + arr[right] > k){
//                    right--;
//                }else {
//                    if (left == i || arr[left] != arr[left - 1]){
//                        System.out.println(arr[left]+","+arr[right]);
//                    }
//                    left++;
//                    right--;
//                }
//            }
//        }
//    }
}
