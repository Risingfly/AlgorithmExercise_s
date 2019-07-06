package com.gen.test;

public class Father1 {
    private int age;
    private String name;
    public Father1(){}
    public Father1(int age, String name) {
        this.age = age;
        this.name = name;
        System.out.println("爸爸来了");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
