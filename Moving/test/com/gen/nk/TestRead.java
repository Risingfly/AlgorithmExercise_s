package com.gen.nk;

import java.util.Arrays;
import java.util.Scanner;

public class TestRead {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
//        int str = read.nextInt();
        String line = read.nextLine();
        String[] str = line.split("");
        System.out.println(Arrays.toString(str));
    }
}
