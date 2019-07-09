package com.gen.test2;

import com.gen.wheel.Gmap;

public class GmapTest {
    public static void main(String[] args) {
//        Gmap<Integer,String> gmap = new Gmap<>();
//        gmap.put(1,"根哥");
//        gmap.put(2,"牛逼");
//        gmap.put(3,"666");
//        System.out.println(gmap.get(1));
//        System.out.println(gmap.get(2));
//        System.out.println(gmap.get(3));

        Gmap<String,String> gmap1 = new Gmap<>();
        gmap1.put("根哥","牛逼");
        gmap1.put("根哥","牛逼");
        System.out.println(gmap1.get("根哥"));
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            gmap1.put(i+"","NB");
            System.out.println("res= "+ i);
            System.out.println("get= "+gmap1.get(i+""));
        }
    }
}
