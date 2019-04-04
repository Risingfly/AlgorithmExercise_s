package com.gen.test;

import java.util.Arrays;
import java.util.Scanner;

public class OutPut {
     static {
        synchronized (Object.class){
            System.out.println("牛逼！！！！");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){

            String a = scanner.nextLine();
            String[] arr =  a.split(" ");
//            int b = scanner.nextInt();
            System.out.println("arr = "+ Arrays.toString(arr));
        }
    }
}
