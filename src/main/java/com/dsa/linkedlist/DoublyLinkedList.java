package com.dsa.linkedlist;

public class DoublyLinkedList {
    private class Node {
        int val;
        Node next;
        Node previous;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node previous) {
            this.val = val;
            this.next = next;
            this.previous = previous;
        }
    }

    private Node head;
    private Node tail;

    public void push (int data) {
        Node newNode = new Node(data);
        if (head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            newNode.previous = null;
            head = newNode;
        }
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            this.head= newNode;
            this.tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            newNode.next = null;
            tail = newNode;
        }
    }

    public void display() {
        Node node = head;
        while ( node != null ) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public void displayReverse() {
        Node node = tail;
        while ( node != null ) {
            System.out.print(node.val + " ");
            node = node.previous;
        }
        System.out.println();
    }

    public void insertAfter(int after, int data) {
        Node newNode = new Node(data);
        Node current = head;
        while ( current.next != null ) {
            if ( current.val == after ) break;
            current = current.next;
        }
        if ( current.next == null && current.val == after ) {
            append(data);
            return;
        }
        if(current.next == null ) {
            System.out.println("Element doesn't exist");
            return;
        }
        Node temp = current.next;
        current.next = newNode;
        newNode.previous = current;
        newNode.next = temp;
        temp.previous = newNode;
    }
}
