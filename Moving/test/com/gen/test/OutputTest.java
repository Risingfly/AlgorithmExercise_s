package com.gen.test;

import java.util.Scanner;

public class OutputTest {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("请输入n= :");
        int n = read.nextInt();
        for (int i = 0; i < n; i++) {
            if (i < n){
                System.out.print(++i+" ");
            }else {
                System.out.print(++i);
            }

        }
    }
}
