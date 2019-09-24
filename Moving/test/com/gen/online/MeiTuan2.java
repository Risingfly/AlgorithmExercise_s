package com.gen.online;

import java.util.Scanner;

public class MeiTuan2 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            int n = read.nextInt();
            boolean flag = true;
            for (int i = 1; i <= n ; i++) {
                if ((i & 1) == 1){
                    System.out.print("A");
                }else if (flag){
                    System.out.print("B");
                    flag = !flag;
                }else {
                    System.out.print("C");
                    flag = !flag;
                }
            }
        }
    }
}
