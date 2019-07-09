package com.gen.test2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

public class LinkedHashMapTest {
    /**
     *
     * 测试hashmap扩容
     */
    public static void test3(){
        HashMap<Integer,Integer> map = new HashMap<>(2,0.75f);
        for (int i = 0; i < 5; i++) {
            map.put(i,i);
        }
        System.out.println("map size="+map.size());
    }
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
    public static void test(){
        TreeMap<Integer,String> map = new TreeMap<>();
        map.put(1,"Chinese");
        map.put(2,"Math");
        map.put(3,"English");
        for (Map.Entry entry: map.entrySet()) {
            System.out.println(entry.getKey()+":-->"+entry.getValue());
        }
    }
    public static void test2(){
        LinkedHashMap<String,Integer> linkMap = new LinkedHashMap<String,Integer>(16,0.75f,true);
        linkMap.put("语文",1);
        linkMap.put("数学",2);
        linkMap.put("物理",3);
        for (Map.Entry<String,Integer> enty: linkMap.entrySet()) {
            System.out.println(enty.getKey()+":  "+enty.getValue());
        }
        System.out.println("访问顺序：");
        linkMap.get("语文");
        for (Map.Entry<String,Integer> enty: linkMap.entrySet()) {
            System.out.println(enty.getKey()+":  "+enty.getValue());
        }
    }
    public static void main(String[] args) {
        test3();
        System.out.println("capacity="+tableSizeFor(7));
    }
}
