package com.gen.nk;

import java.util.Scanner;

public class FlyTest {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String[] str = read.nextLine().split(",");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            String[] str2 = read.nextLine().split(" ");
            int key = Integer.parseInt(str2[0]);
            int res = binarySearch(arr,0,arr.length - 1,key);
            System.out.println(res);
        }
    }
    public static int binarySearch(int arr[], int start, int end, int key) {
        int mid = (end - start) / 2 + start;
        if (arr[mid] == key) {
            return mid;
        }
        if (start >= end) {
            return -1;
        } else if (key > arr[mid]) {
            return binarySearch(arr, mid + 1, end, key);
        } else if (key < arr[mid]) {
            return binarySearch(arr, start, mid - 1, key);
        }
        return -1;
    }
}
