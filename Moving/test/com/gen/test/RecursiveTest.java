package com.gen.test;

import java.util.Scanner;

public class RecursiveTest {
    /**
     * n的输入由自己决定,写函数时不需要考虑
     * @param arr
     * @param n
     * @return
     */
    public static int sum(int[] arr, int n){
        if (n == 0){
            return arr[0];
        }else {
            return sum(arr,n - 1) + arr[n];
        }
    }

    public static int max(int[] arr,int n){
        if (n == 0){
            return arr[0];
        }else {
            return Math.max(max(arr,n - 1),arr[n]);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Scanner reader = new Scanner(System.in);
        System.out.println("Please input the limit of the array:");
        int limit = reader.nextInt();
        int[] arrs = new int[limit + 1];
        for (int i = 0; i <= limit; i++) {
            arrs[i] = i;
        }
        System.out.println(sum(arrs,limit));
        System.out.println("max="+max(arrs,limit));
//        main(args);
    }
}
