package com.gen.test;

import java.util.Arrays;
import java.util.Scanner;

public class NiuKeTest {

    static {
        System.out.println("类加载初始化阶段");

    }
    NiuKeTest(){
        System.out.println("构造方法执行");

        printSomething();
    }
    void printSomething(){
        printSomething();
    }
    public static void main(String[] args) {
        NiuKeTest nt = new NiuKeTest();

        for (;;){
            byte[] bytes = new byte[1024 * 100];
        }
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
//        System.out.println(arrays.toString(arr));
//        for (int i = 1; i <= 20 ; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                i = arr[j] *
//            }
//        }


    }
}
