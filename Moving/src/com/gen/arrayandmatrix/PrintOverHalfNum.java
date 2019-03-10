package com.gen.arrayandmatrix;

/***
 * 打印数组中出现超过一半的数
 *
 * @author Genge
 */
public class PrintOverHalfNum {
    private static void printHalf(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }
        int[] map = new int[256];
        for (int i = 0; i < arr.length; i++) {
            map[arr[i]]++;
        }
        int half = arr.length / 2;
        for (int i = 0; i < map.length; i++) {
            if (map[i] < half){
                System.out.println("half="+arr[i]);
                return;
            }
        }
        System.out.println("it didn't have the num!");
    }
}
