package com.dsa.linkedlist;


public class DDLMain {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.display();
        list.displayReverse();

        list.append(5);
        list.append(6);
        list.append(7);
        list.display();
        list.displayReverse();

        list.insertAfter(7, 0);
        list.display();
    }

}
