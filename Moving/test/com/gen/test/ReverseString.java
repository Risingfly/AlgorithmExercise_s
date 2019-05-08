package com.gen.test;

import java.util.LinkedList;

public class ReverseString {
    public char[] reverse(char[] chars, int l, int r){
        char tmp;
        while (l < r){
            tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }
        return chars;
    }
    public String ReverseSentence(String str){
        if (str == null || str.length() == 0){
            return "";
        }
        char[] chars = str.toCharArray();
        reverse(chars,0,chars.length - 1);
        int blank = -1;
        int nextBlank = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' '){
                nextBlank = i;
                reverse(chars,blank + 1,nextBlank - 1);
                blank = nextBlank;
            }
        }
        reverse(chars,nextBlank + 1,chars.length - 1);
        return new String(chars);
    }

    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0){
            return false;
        }
        int max = -1;
        int min = 14;
        int[] map = new int[14];
        for (int i = 0; i < 14; i++) {
            if (map[numbers[i]] != 0){
                return false;
            }
            map[numbers[i]]++;
            if (numbers[i] < min && numbers[i] != 0){
                min = numbers[i];
            }
            if (numbers[i] > max && numbers[i] != 0){
                max = numbers[i];
            }
        }
        return max - min < numbers.length;
    }

    public static int LastRemaining_Solution(int n, int m) {
        if (n < 2 || m < 2){
            return 0;
        }
        LinkedList<Integer> circle = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            circle.add(i);
        }
        int pre = 0;
        while (circle.size() > 1){
            int cur = (pre + m - 1) % circle.size();
            circle.remove(cur);
            pre = cur;
        }
        return circle.size() == 1 ? circle.get(0) : -1;
    }

    public static void main(String[] args) {
        LastRemaining_Solution(5,3);
    }
}
