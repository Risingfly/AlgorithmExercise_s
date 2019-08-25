package com.gen.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationTest {
    @Zhazha("瘪三666")
    private String bisan;
    @Zhazha(value = "沙雕，思密达")
    private String bisanNb(){
        return "沙雕";
    }

    public static void main(String[] args)throws Exception {
        AnnotationTest an = new AnnotationTest();
        Class cla = AnnotationTest.class;
        Field field = cla.getDeclaredField("bisan");
        System.out.println(field.getAnnotation(Zhazha.class));
        Zhazha zhazha = field.getAnnotation(Zhazha.class);
        an.bisan = field.getAnnotation(Zhazha.class).value();
        System.out.println(an.bisan);

        Method method = cla.getDeclaredMethod("bisanNb",null);
        System.out.println(method.getDeclaredAnnotation(Zhazha.class).value());
//        System.out.println(field.getAnnotation(Zhazha.class).value());
//        System.out.println(zhazha.value());
//        System.out.println(field.getAnnotatedType());
//        field.set(an,"瘪三");
//        Method method = cla.getDeclaredMethod("bisanNb",null);
//        System.out.println(method.invoke(an,null));
//        System.out.println(an.bisan+an.bisanNb());
    }
}
