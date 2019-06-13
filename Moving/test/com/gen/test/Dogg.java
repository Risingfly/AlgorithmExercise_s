package com.gen.test;

public class Dogg {
   private Dog dog;
   private String name;
   public Dogg(){}
    public Dogg(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
    public void print(){
        System.out.println("汪!");
    }
}
