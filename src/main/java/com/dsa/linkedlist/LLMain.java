package com.dsa.linkedlist;

public class LLMain {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.display();

        list.insertAfter(1, 0);
        list.display();

        list.insertUsingRec(0, 9);
        list.display();
    }
}
