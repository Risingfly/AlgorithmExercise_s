package com.gen.leetcode.top100;

import java.util.Stack;

/**
 * 问题：155
 * @author Genge
 */
public class MinStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;
    public MinStack(Stack<Integer> stackData,Stack<Integer> stackMin) {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int x) {
        if (stackMin.isEmpty()){
            stackMin.push(x);
        }
        int val = stackMin.peek();
        if (x <= val){
            stackMin.push(x);
        }else{
            stackMin.push(val);
        }
        stackData.push(x);
    }

    public void pop() {
        stackMin.pop();
        stackData.pop();
    }

    public int top() {
        return stackData.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }
}
