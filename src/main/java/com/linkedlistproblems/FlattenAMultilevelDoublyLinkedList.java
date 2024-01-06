package com.linkedlistproblems;

//430. Flatten a Multilevel Doubly Linked List
//https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/description/
public class FlattenAMultilevelDoublyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        Node[] prev = new Node[1];
        rec(head,prev);
        return prev[0];
    }

    public void rec(Node node, Node[] prev){
        if(node == null) return;

        rec(node.next,prev);
        rec(node.child,prev);

        node.next=prev[0];
        if(prev[0] != null) prev[0].prev=node;
        node.child=null;
        prev[0] = node;
    }
}
