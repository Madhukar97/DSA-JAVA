package com.dsa.linkedlist;

public class LinkedList {
    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;

    public void push (int val) {
        Node newNode = new Node(val);
        if ( head == null ) {
            this.head = newNode;
            this.tail = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void append(int val) {
        Node newNode = new Node(val);
        if (tail == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void display() {
        Node current = head;
        while ( current != null ) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println();
    }

    public void insertAfter(int after, int val) {
        Node current = head;
        Node newNode = new Node(val);
        Node temp;
         while (current.next != null) {
            if (current.val == after) {
                break;
            }
            current = current.next;
        }
        if (current.val == after && current.next == null) {
            current.next = newNode;
            tail = newNode;
            return;
        }
        if (current.next == null) {
            System.out.println("Element doesn't exist");
            return;
        }
         newNode.next = current.next;
         current.next = newNode;
    }

    public void insertUsingRec(int after, int val) {
        insertAfterUsingRecursion(after, val, head);
    }

    private void insertAfterUsingRecursion(int after, int val, Node current) {
        if (tail.val == after) {
            append(val);
            return;
        }
        if (current.next != null) {
            if (current.val == after) {
                Node newNode =  new Node(val);
                newNode.next = current.next;
                current.next = newNode;
                return;
            }
            insertAfterUsingRecursion(after, val, current.next);
        }
    }
}
