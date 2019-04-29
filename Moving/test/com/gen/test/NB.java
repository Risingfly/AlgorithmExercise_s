package com.gen.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD})
public @interface NB {
    String nb() default "NB";
    int[] arr() default {1,2,3} ;
    int sb() default 666;
    Table zhujie() default @Table("沙雕");
}
