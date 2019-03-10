package com.gen.arrayandmatrix;

/**
 * 未排序整数数组中累加和为给定值的最长子数组长度
 * 解法：定义l、r两个指针都指向i = 0；lr之间和即为sum,如果和等于k,则计算lr之间长度，
 * 同时更新l++,继续向后，若大于k,说明以l为左的都大于k,因此l++.同时sum -= arr[l];
 * 若小于k,则r++（注意是否越界）
 *
 * @author Genge
 */
public class UnsortLongestArray {


    private static int longestArray(int[] arr, int k){
        if (arr == null || arr.length == 0 || k <= 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int len = 0;
        while (left <= right && right < arr.length){
            if (sum == k){
                len = Math.max(len,right - left + 1);
                sum -= arr[left++];
            }else if (sum < k){
                right++;
//                right有可能超出边界
                if (right == arr.length){
                    break;
                }
                sum += arr[right];
            }else {
                sum -= arr[left];
                left++;
            }

        }
        return len;
    }

    private static int len(int[] arr, int k){
        if (arr == null || k < 0){
            return 0;
        }
        int sum = 0;
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k){
                    len = Math.max(len,j - i + 1);
                }
            }
        }
        return len;
    }
}
