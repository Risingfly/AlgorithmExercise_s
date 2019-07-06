package com.gen.test2;

import java.util.HashSet;

public class EqualsReview  {
    private int age;
    private String name;
    private int id;

    public EqualsReview(int age, String name, int id) {
        this.age = age;
        this.name = name;
        this.id = id;
    }
    public int hashCode(){
        int code = 17;
        code = code * 31 + age;
        code = code * 31;
        code = code * 31 + id;
        return code;
    }
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()){
            return false;
        }
//        if (obj instanceof EqualsReview){
            EqualsReview cobj = (EqualsReview) obj;
            if (this.age != cobj.age){
                return false;
            }
            if (!this.name.equals(cobj.name)){
                return false;
            }
            if (id != cobj.id ){
                return false;
            }
//        }

        return true;
    }

    public static void main(String[] args) {
        EqualsReview e1 = new EqualsReview(10,"nb",1);
        EqualsReview e2 = new EqualsReview(10,"nb",1);
        EqualsReview e3 = new SonOfEqual(10,"nb",1);
        SonOfEqual e4 = new SonOfEqual(10,"nb",1);
//        System.out.println(e1.equals(e2));
//        System.out.println("e3==e1:"+e3.equals(e1));
//        System.out.println("e4==e1:"+e4.equals(e1));
//        System.out.println("e1==e4:"+e1.equals(e4));
//        HashSet<EqualsReview> set = new HashSet<>();
////        set.add(e1);
//        set.add(e2);
////        set.add(e3);
//        set.add(e4);
//        System.out.println("size="+set.size());
//        System.out.println("e4==e3:"+e3.equals(e4));
        try {
            EqualsReview e5 = (EqualsReview)e4.clone();
            System.out.println(e5.equals(e4));
            System.out.println(e5.name + ","+e5.age);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
