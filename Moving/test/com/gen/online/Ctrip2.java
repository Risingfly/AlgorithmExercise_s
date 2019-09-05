package com.gen.online;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Ctrip2 {
    public static void main(String[] args) {
    }

    static String resolve(String expr) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '('){

            }
        }
        if (!isValid(expr)){
            return "";
        }else {

        }
        return null;
    }
    private static boolean isValid(String string) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (map.containsKey(ch)) {
                stack.push(ch);
            } else if (map.containsValue(ch)) {
                if (!stack.isEmpty() && map.get(stack.peek()) == ch) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
