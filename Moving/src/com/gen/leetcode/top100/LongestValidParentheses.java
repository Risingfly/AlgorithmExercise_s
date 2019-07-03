package com.gen.leetcode.top100;

import java.util.Stack;

/**
 * 问题：32
 * @author Genge
 */
public class LongestValidParentheses {
    /**
     * 用栈实现：第一将栈插入下标-1
     *           第二当出现配对的括号时更新result，记录最大值
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '('){
                stack.pop();
                result = Math.max(result,i - stack.peek());
            }else{
                stack.push(i);
            }
        }
        return result;
    }
}
