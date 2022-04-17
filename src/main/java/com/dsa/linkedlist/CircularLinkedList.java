package com.dsa.linkedlist;

public class CircularLinkedList {
    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;

    public void insert(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
    }

    public void display() {
        Node temp = head;
        do {
            System.out.print(temp.val + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public int delete(int val) {
        Node current = head;
        if (head.val == val) {
            tail.next = head.next;
            head = tail.next;
            current.next = null;
            return current.val;
        }
        while (current.next != head) {
            if (current.next.val == val) break;
            current = current.next;
        }
        Node temp = current.next;
        current.next = current.next.next;
        temp.next = null;
        return temp.val;
    }
}
