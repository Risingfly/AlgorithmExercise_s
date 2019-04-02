package com.gen.sword.offer;

import java.util.LinkedList;

/***
 * 问题：约瑟夫杀人问题
 *
 * @author Genge
 */
public class LastRemaining {
    public int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            ll.add(i);
        }
        int index = 0;
        while (ll.size() > 1){
            index = (index + m - 1) % ll.size();
            ll.remove(index);
        }
        return ll.size() == 1 ? ll.get(0) : -1;
    }
}
