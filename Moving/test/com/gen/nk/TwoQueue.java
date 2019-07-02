package com.gen.nk;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 问题：两个队列实现一个栈
 * 思路：两个队列互捣，将元素入到一个非空队列中，然后不断出队到空队列中，直到该队列
 * 剩余一个元素，即为要出队元素（栈的功能，先进后出），再继续这个操作
 * @author Genge
 */
public class TwoQueue {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();
    public void push(int e){
//        往不空的队列中入队（若二者都空，任选其一即可） --》单线程情况
        if (!queue1.isEmpty()){
            queue1.offer(e);
        }else {
            queue2.offer(e);
        }
    }
    public int pop(){
        if (queue1.isEmpty() && queue2.isEmpty()){
            throw new RuntimeException("error");
        }
        int tmp = 0;
        if (!queue1.isEmpty()){
            while (!queue1.isEmpty()){
                queue2.offer(queue1.poll());
                if (queue1.size() == 1){
                    tmp = queue1.poll();
                    break;
                }
            }
        }else {
            while (!queue2.isEmpty()){
                queue1.offer(queue2.poll());
                if (queue2.size() == 1){
                    tmp = queue2.poll();
                    break;
                }
            }
        }
        return tmp;
    }
}
