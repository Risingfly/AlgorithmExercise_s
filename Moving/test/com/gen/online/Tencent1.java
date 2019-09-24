package com.gen.online;

import java.util.Scanner;

public class Tencent1 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            int t = Integer.parseInt(read.nextLine());
            for (int i = 0; i < t; i++) {
                int n = Integer.parseInt(read.nextLine());
                String str = read.nextLine();
                if (solve(str,n)){
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }
            }
        }
    }
    private static boolean solve(String str,int n){
        if (n < 11){
            return false;
        }
        if (str.charAt(0) == '8' && n == 11){
            return true;
        }
        int index = str.indexOf('8');
        String newStr = str.substring(index,n);
        if (newStr.length() >= 11){
            return true;
        }
        return false;
    }
}
