package com.gen.test2;

import com.gen.leetcode.top100.LRUCache;

public class LRUTest {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(50);
        for (int i = 0; i < 100; i++) {
            cache.put(i,i);
        }
        for (int i = 0; i < 50; i++) {
            System.out.println(i+"= "+cache.get(i));
        }
    }
}
