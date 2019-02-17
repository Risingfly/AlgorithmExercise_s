package com.gen.linknode;

public class Node {
    public int val;
    public Node next;
    public Node(int val){
        this.val = val;
    }
    public Node add(Node node){
        this.next = node;
        return this;
    }
}
