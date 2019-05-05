package com.gen.sword.offer;

public class TimesOfArray {
    public int GetNumberOfK(int [] array , int k){
        return binarySearch(array,(int) (k + 0.5)) - binarySearch(array,(int)(k - 0.5));
    }
    public int binarySearch(int[] arr,int k){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int l = 0;
        int r = arr.length - 1;
//        int mid = 0;
        while (l < r){
            int mid = (l + r) >> 2;
            if (arr[mid] < k){
                l = mid + 1;
            }else if (arr[mid] > k){
                r = mid - 1;
            }
        }
        return l;
    }
}
