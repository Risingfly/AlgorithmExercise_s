package com.gen.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

@NB()
public class TestNB {
    @NB(arr = {1,8,3},sb = 10086,zhujie = @Table("fuck"))
    private static int a ;
    public static void main(String[] args)throws Exception {
        Class baba = TestNB.class;
        NB aa = (NB) baba.getAnnotation(NB.class);
        System.out.println(aa.sb());
        System.out.println(Arrays.toString(aa.arr()));

        Field field = baba.getDeclaredField("a");
        NB nb =  field.getAnnotation(NB.class);
        System.out.println("field="+Arrays.toString(nb.arr()));
        System.out.println("sb="+nb.sb());
        System.out.println("sb="+nb.zhujie());
    }
}
