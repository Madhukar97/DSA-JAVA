package com.linkedlistproblems;

//876. Middle of the Linked List
//https://leetcode.com/problems/middle-of-the-linked-list/
public class MiddleOfLinkedList {
    public static void main(String[] args) {

    }
    public class ListNode {
        int val;
        MiddleOfLinkedList.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, MiddleOfLinkedList.ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode middleNode(ListNode head) {
        if(head == null ) return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
