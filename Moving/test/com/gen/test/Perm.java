package com.gen.test;

import java.util.Arrays;

import static com.gen.test.Sort.swap;

public class Perm {
    public static void perm(int[] arr,int p,int q){
        if (p == q){
            System.out.println("perm="+ Arrays.toString(arr));
            return;
        }else {
            for (int i = p; i <= q; i++) {
                swap(arr,p,i);
                perm(arr,p + 1,q);
                swap(arr,p,i);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        perm(arr,0,arr.length - 1);
    }
}
