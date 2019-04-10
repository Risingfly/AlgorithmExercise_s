package com.gen.test;

public class Gmap {
    private int size = 8;
    private int[] table;
    public Gmap(){
        table = new int[size];
    }
    public Gmap(int size){
        this.size = size;
        table = new int[size];
    }
    public int hash(int key){
        return Integer.valueOf(key).hashCode();
    }
    public void put(int key, int val){
        int i = hash(key);
        table[i] = val;
    }

    public int get(int key){
        int i = hash(key);
        return table[i];
    }
    public static void main(String[] args) {
        Gmap gmap = new Gmap(10);
        for (int i = 0; i < 10 ; i++) {
            gmap.put(i,i + 1);
        }

        for (int i = 0; i < gmap.size; i++) {
            System.out.println("key"+i + "->" + gmap.get(i));
        }
//        gmap.put(1,3);
//        gmap.put(1,3);
    }
}
