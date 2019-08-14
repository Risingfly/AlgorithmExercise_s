package com.gen.test3;

import java.util.Scanner;

public class TigerTest4 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        if (n < 3){
            System.out.println(-1);
        }
        int sum = 0;
        int tmp = 0;
        int max = sum = read.nextInt();
        for (int i = 1; i < n; i++) {
            max = (tmp = read.nextInt()) > max ? tmp : max;
            sum += tmp;
            int sumSubMax = sum - max;
            if (i > 1){
                if (sumSubMax > max){
                    System.out.println(i + 1);
                    break;
                }
            }
            if (i == n - 1){
                System.out.println(-1);
            }
        }

    }
}
