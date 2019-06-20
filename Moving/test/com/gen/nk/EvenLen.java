package com.gen.nk;

import java.util.Scanner;

public class EvenLen {
    public static boolean isEven(String str){
        if (str == null || str.length() % 2 != 0){
            return false;
        }
        int start0 = 0;
        int start1 = str.length()/2;
        int tmp = start1;
        while (start0 < tmp && start1 < str.length()){
            if (str.charAt(start0) == str.charAt(start1)){
                start0++;
                start1++;
            }else {
                return false;
            }
        }
        return true;
    }
    public static int getLen(String str){
        boolean flag = false;
        int len = 0;
        for (int i = str.length() - 2; i > 0 ; i--) {
            if (isEven(str.substring(0,i))){
                len = i;
                break;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println("请输入：");
        Scanner read = new Scanner(System.in);
        String str = read.nextLine();
        System.out.println(getLen(str));
    }
}
