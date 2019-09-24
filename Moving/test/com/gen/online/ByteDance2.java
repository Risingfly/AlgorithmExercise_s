package com.gen.online;

import java.util.Scanner;

public class ByteDance2 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            int n = read.nextInt();
            int end = 0;

            for (int i = 0; i < n; i++) {
                int time = read.nextInt();
                int num = read.nextInt();
                end += num;
            }
            end += 1;

        }
    }
}
