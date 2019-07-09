package com.gen.wheel;

public class Gmap<K,V> {
    private Node<K,V>[] table;
    private int capacity = 16;
    private int count = 0;
    private float loafFactor = 0.75f;
    private int hash(Object key){
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    public Gmap(){
        table = resize();
    }
    public Gmap(int capacity, float loafFactor){
        this.capacity = capacity;
        this.loafFactor = loafFactor;
        table = resize();
    }
    final Node<K,V>[] resize(){
        Node<K,V>[] table = new Node[capacity];
        return table;
    }
    public void put(K key, V value){
        Node<K,V> tmp = new Node<K,V>(hash(key),key,value,null);
        int l = hash(key) & (table.length - 1);
        if (table[l] == null){
            table[l] = tmp;
        }else {
            Node node = table[l];
            while (node.next != null){
                node = node.next;
            }
            node.next = tmp;
        }
    }
    public V get(Object key){
        if (key == null){
           throw new RuntimeException("key is invalid");
        }
        int l = hash(key) & (table.length - 1);
        if (table[l] != null && table[l].next == null){
            return table[l].value;
        }else if (table[l] == null){
            throw new RuntimeException("null");
        }else {
            Node tmp = table[l];
            while (tmp != null){
                if (tmp.key.equals(key)){
                    break;
                }
                tmp = tmp.next;
            }
            return (V) tmp.value;
        }
    }
    static class Node<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }
}
