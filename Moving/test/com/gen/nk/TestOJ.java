package com.gen.nk;

import java.util.Scanner;

public class TestOJ {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            int n = read.nextInt();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += read.nextInt();
            }
            System.out.println(sum);
        }
//        while (read.hasNextLine()) {
//            String[] str1 = read.nextLine().split(" ");
//            int n = Integer.parseInt(str1[0]);
//            int sum = 0;
//            for (int i = 1; i < str1.length; i++) {
//                sum += Integer.parseInt(str1[i]);
//            }
//            System.out.println(sum);
//        }
    }
}
