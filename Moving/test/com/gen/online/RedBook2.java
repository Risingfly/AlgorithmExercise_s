package com.gen.online;

import java.util.Scanner;

public class RedBook2 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String str1 = read.nextLine();
            System.out.println(slove(str1));
        }
    }
    private static String slove(String str){
        int len = str.length();
        int begin = str.indexOf("(");
        int end = str.lastIndexOf(")");
        String newstr = null;
        if (begin != -1 && end != -1){
            String str1 = str.substring(0,begin);
            String str2 = str.substring(end + 1,len);
            newstr = str1 + str2;
        }
        char[] chars = newstr == null ? str.toCharArray() : newstr.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (i < chars.length - 1 && chars[i] != '<' && chars[i + 1] == '<'){
                i++;
                continue;
            }
            sb.append(chars[i]);
        }
        String res = sb.toString();
        res = res.replaceAll("\\<","");
        return res;
    }
}
