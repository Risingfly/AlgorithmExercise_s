package com.gen.online;


import java.util.Scanner;
import java.util.Stack;

public class Shopee {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String str1 = read.nextLine();
            if (!isCorrect(str1)){
                System.out.println("ERROR");
            }else {
                System.out.println(calculate(str1));
            }
        }
    }
    private static boolean isCorrect(String str){
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            if (!Character.isDigit(chars[i]) && (chars[i] != '+' || chars[i]!= '-' || chars[i] != '*'
            || chars[i] != '/' || chars[i] != '(' || chars[i] != ')')){
                return false;
            }
        }
        return true;
    }
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = 10 * number + (int)(c - '0');
            }else if(c == '+'){
                result += sign * number;
                number = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * number;
                number = 0;
                sign = -1;
            }else if(c == '('){
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            }else if(c == ')'){
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();

            }
        }
        if(number != 0) result += sign * number;
        return result;
    }

}
