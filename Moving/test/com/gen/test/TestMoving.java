package com.gen.test;


import java.util.ArrayList;
import java.util.List;

public class TestMoving {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0;i < 10;i++){
            if (i % 2 == 0 ){
                list2.add(i);
            }else {
                list.add(i);
            }
        }
//        list.addAll(list2);
        list.removeAll(list2);
        int size = list.size();
        Integer[]arr = list.toArray(new Integer[size]);

        for (Integer i: arr)
        {
            System.out.println("list:"+i);
        }
//        for (Integer i: list2){
//            System.out.println("list2:"+i);
//        }
    }
}
