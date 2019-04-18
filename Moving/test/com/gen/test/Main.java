package com.gen.test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    static int i = 0;
    public int NumberOf1(int n){
        int count = 0;
        while (n != 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }
    Thread t1 = new Thread(){
        @Override
        public void run() {
            while (t1 != null){
                i = i + 1;
            }
        }
    };
    public static void main(String[] args) {
//        Scanner reader = new Scanner(System.in);
//        int n = reader.nextInt();
        int flag = 1;
        int i = 0;
        while (flag != 0){
            i++;
            flag <<= 1;
            System.out.println(flag);

        }
        System.out.println(i);
//        System.out.println(n);
    }
}
