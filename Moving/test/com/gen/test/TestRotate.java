package com.gen.test;

public class TestRotate {
    public int minNumberInRotateArray(int [] array){
        int l = 0;
        int r = array.length - 1;
        while (l < r){
            int mid = l + (l - r) >> 1;
            if (array[mid] > array[r]){
                r = mid - 1;
            }else if (array[mid] < array[r]){
                l = mid + 1;
            }else {
                r = r - 1;
            }
        }
        return array[l];
    }
}
