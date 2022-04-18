package com.linkedlistproblems;

//92. Reverse Linked List II
//https://leetcode.com/problems/reverse-linked-list-ii/
public class ReverseSubLinkedList {
    public static void main(String[] args) {

    }
    public class ListNode {
        int val;
        ReverseSubLinkedList.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ReverseSubLinkedList.ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;

        ListNode previous  = null;
        ListNode current = head;

        for(int i=0; current != null && i< left-1 ; i++) {
            previous = current;
            current = current.next;
        }

        ListNode last = previous;
        ListNode newEnd = current;
        ListNode next = current.next;

        for(int i=0; current != null && i < right-left+1; i++) {
            current.next = previous;
            previous = current;
            current = next;
            if(next != null) next = next.next;
        }
        if(last != null) last.next = previous;
        else head = previous;

        newEnd.next = current;
        return head;
    }
}
