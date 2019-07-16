package com.gen.test2;

public class BinaryTest {
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0){
            return 0;
        }
        int res = getIndex(array,k ) - getIndex(array,k );
        return res;
    }
    private int getIndex(int[] arr,int k){
        int l = 0;
        int r = arr.length - 1;
        while (l < r){
            int mid = l + (r - l);
            if (arr[mid] == k){
                return mid;
            }else if (arr[mid] < k){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }
}
