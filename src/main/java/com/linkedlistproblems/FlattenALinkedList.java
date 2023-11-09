package com.linkedlistproblems;

//Flatten A Linked List
//https://www.codingninjas.com/studio/problems/1112655?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
//https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1
public class FlattenALinkedList {
    class Node
    {
        int data;
        Node next;
        Node bottom;

        Node(int d)
        {
            data = d;
            next = null;
            bottom = null;
        }
    }
    //sol with time O(n*(m1+m2)) and space O(n) stack space
    Node flattenUsingRecursion(Node root)
    {
        return recFlatten(root);
    }

    Node recFlatten(Node root){
        if(root == null || root.next==null) return root;

        Node b = recFlatten(root.next);

        return mergeTwoSortedLL(root,b);
    }

    Node mergeTwoSortedLL(Node a, Node b){
        Node temp = new Node(0);
        Node res = temp;

        while(a!=null && b!= null){
            if(a.data < b.data){
                temp.bottom=a;
                a=a.bottom;
                temp=temp.bottom;
            }else{
                temp.bottom=b;
                b=b.bottom;
                temp=temp.bottom;
            }
        }
        if(a!= null)temp.bottom=a;
        else temp.bottom=b;
        return res.bottom;
    }

    //Most optimal sol with time O(n*(m1+m2)) and space O(1)
    public Node flattenLinkedList(Node head) {
        Node res=head;
        Node curr=head;
        while(curr.next != null){
            Node next=curr.next.next;
            curr.next.next=null;
            Node merged = mergeTwoSortedLL(curr,curr.next);
            merged.next=next;
            curr=merged;
        }
        return curr;
    }

    //Most Optimal sol using Iteration
    Node flatten(Node root){
        Node head = new Node(0);
        head.next = root;

        Node next = root.next;

        while(next != null){
            head.next = mergeSortedLists(head.next, next);
            next=next.next;
        }
        return head.next;
    }

    Node mergeSortedLists(Node a, Node b){
        Node head = new Node(0);
        Node prev = head;

        while(a != null && b != null){
            if(a.data <= b.data){
                prev.bottom=a;
                prev=prev.bottom;
                a=a.bottom;
            }else{
                prev.bottom=b;
                prev=prev.bottom;
                b=b.bottom;
            }
        }

        if(a != null) prev.bottom = a;
        if(b != null) prev.bottom = b;
        return head.bottom;
    }
}
