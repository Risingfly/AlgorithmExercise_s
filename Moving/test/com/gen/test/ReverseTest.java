package com.gen.test;

import java.util.Scanner;

public class ReverseTest {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String str1 = read.nextLine();
            System.out.println("res= "+reverseSentence(str1));
        }
    }
    public static String reverseSentence(String str){
        if (str == null || str.length() == 0){
            return str;
        }
        char[] chars = str.toCharArray();
        reverse(chars,0,chars.length - 1);
        int l = 0;
        int r = chars.length;
//        int i = 0;
        while (l < r){
            while (l < r && chars[l] == ' '){
                l++;
            }
//            第一个不等于空的位置
            int i = l;
            while (l < r && chars[l] != ' '){
                l++;
            }
//            第一个等于空的位置
            int j = l;
//            这中间即是非空的字符需要逆序
            reverse(chars,i,j - 1);
        }
        return String.valueOf(chars);
    }
    private static void reverse(char[] chars,int l,int r){
        while (l < r){
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }
    }
}
