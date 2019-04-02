package com.gen.test;

import java.util.HashSet;

public class Single {
    private static volatile  Single intstnce ;
    private Single(){}
    public static Single getIntstnce(){
        if (intstnce == null){
            synchronized (Single.class){
                if (intstnce == null){
                    intstnce = new Single();
                }
            }
        }
        return intstnce;
    }


}
