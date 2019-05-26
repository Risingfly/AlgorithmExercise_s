package com.gen.leetcode.arrays;

import java.util.Stack;

/**
 * 问题:20
 * @author Genge
 */
public class ValidParentheses{
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c: s.toCharArray()) {
            if (c == '('){
                stack.push(')');
            }else if (c == '['){
                stack.push(']');
            }else if (c == '{'){
                stack.push('}');
            }else if (stack.isEmpty() || !stack.pop().equals(c)){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
