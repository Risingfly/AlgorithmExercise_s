package com.gen.test;

import java.util.Scanner;
import java.util.Stack;

public class PinDuoDuo {
    public static int solve(String str){
        if (str == null || str.length() <= 1){
            return 0;
        }
        char[] chars = str.toCharArray();
        int len = chars.length;

//      指向数组下标
        int index = 1;
        Stack<Character> stack = new Stack<>();

        stack.push(chars[0]);
        int count = 0;
        while (index < len){

                while (!stack.isEmpty() && stack.peek() == chars[index]){
                    count++;
                    stack.pop();
                    index++;
                }
                stack.push(chars[index++]);

        }
//        int res = (len - stack.size()) >> 1;
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(solve(input));
    }
}
