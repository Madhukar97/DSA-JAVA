package com.dsa.linkedlist;

public class CLLMain {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.display();

        list.delete(1);
        list.display();
    }
}
