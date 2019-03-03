package com.gen.test;

public class RunTest {
    public static void main(String[] args) {
        Rice rice = new Rice("good");
        CookRice cookRice = new CookRice(rice);
        EatRice eatRice = new EatRice(rice);
        cookRice.start();
        eatRice.start();
        System.out.println("main over!");
    }
}
