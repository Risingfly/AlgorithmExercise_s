package com.gen.sword.offer;

import java.util.LinkedList;
import java.util.Queue;

public class FirstOfCharacter {

    private int[] arr = new int[128];
    private Queue<Character> queue = new LinkedList<>();
    public void Insert(char ch){
        ++arr[ch];
        if (arr[ch] == 1){
            queue.offer(ch);
        }
    }
    public char FirstAppearingOnce(){
        while (!queue.isEmpty() && (arr[queue.peek()] > 1) ){
            queue.poll();
        }
        if (queue.isEmpty()){
            return '#';
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        FirstOfCharacter first = new FirstOfCharacter();
        first.Insert('g');
        first.Insert('o');
        first.FirstAppearingOnce();
        first.FirstAppearingOnce();
    }
}
