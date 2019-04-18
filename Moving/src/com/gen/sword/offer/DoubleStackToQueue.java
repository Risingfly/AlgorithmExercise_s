package com.gen.sword.offer;

import java.util.Stack;

public class DoubleStackToQueue {
    /**
     * stack1作为入
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    /***
     * stack2作为出
     */
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.isEmpty() && stack2.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
