package com.gen.test3;

public class InheritateTest extends AbsTest {
    public static String nb = "6666 NB";
    public static void main(String[] args) {
        InheritateTest inheritateTest = new InheritateTest();
        inheritateTest.inte1();
        inheritateTest.inte2();
        inheritateTest.inte3();
//        System.out.println(inheritateTest.count);
//        System.out.println(inheritateTest.nb);
//        System.out.println(InheritateTest.var);
//        System.out.println(InheritateTest.nb);
    }
//    @Override
//    public void inte1() {
//        System.out.println("abstract inte1");
//    }

//    @Override
//    public void inte2() {
//
//    }

    @Override
    public void inte3() {
        System.out.println("InheritateTest==>inte3");
    }

}
