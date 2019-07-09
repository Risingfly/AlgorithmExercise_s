package com.gen.leetcode.top100;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheII<K,V> extends LinkedHashMap<K,V> {
    private static final int MAX_ENTRIES = 3;

    /**
     * 覆盖LinkedHashMap中的该方法即可
     * 当数量大于最大值时，则移除最近最久未使用的数据
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > 3;
    }

    /**
     * 开启accessOrder为true,即为开启LRU顺序
     */
    public LRUCacheII(){
        super(MAX_ENTRIES,0.75f,true);
    }

    public static void main(String[] args) {
        LRUCacheII<Integer,String> lruCacheII = new LRUCacheII<>();
        lruCacheII.put(1,"marry");
        lruCacheII.put(2,"Bob");
        System.out.println("res= "+lruCacheII.get(2));
        System.out.println("res1= "+lruCacheII.get(1));
        lruCacheII.put(3,"Genge");
        lruCacheII.put(4,"NB");
        System.out.println("res= "+lruCacheII.get(2));
        System.out.println("res2= "+lruCacheII.get(1));
        System.out.println(lruCacheII.keySet());
    }
}
