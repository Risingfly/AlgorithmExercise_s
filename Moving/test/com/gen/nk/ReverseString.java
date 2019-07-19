package com.gen.nk;

public class ReverseString {
    public void reverse(char[] chars,int l,int r){
        while (l < r){
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }
    }
    public String ReverseSentence(String str){
        if (str == null){
            return str;
        }
        char[] chars = str.toCharArray();
        reverse(chars,0,chars.length - 1);
        int l = 0,r = chars.length;
        while (l < r){
//            记录单词的第一个位置,跳过空格
            while (l < r && chars[l] == ' '){
                l++;
            }
            int s = l;
//            找到最后一个字符的位置
            while (l < r && chars[l] != ' '){
                l++;
            }
//            以空格为界,局部反转
            reverse(chars,s,l - 1);
        }
        return String.valueOf(chars);
    }
}
