package com.gen.nk;

import java.util.Arrays;
import java.util.Scanner;

public class Children {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int res = arr[n - 1] - arr[n/2];
        System.out.println(res);
    }
}
