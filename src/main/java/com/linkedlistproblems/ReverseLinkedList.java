package com.linkedlistproblems;

//206. Reverse Linked List
//https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList {
    public static void main(String[] args) {

    }
    public class ListNode {
        int val;
        ReverseLinkedList.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ReverseLinkedList.ListNode next) { this.val = val; this.next = next; }
    }

    // three pointer method
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode previous = null;
        ListNode present = head;
        ListNode next = present.next;

        while ( present != null) {
            present.next = previous;
            previous = present;
            present = next;
            if(next != null) next = next.next;
        }
        return previous;
    }
}
