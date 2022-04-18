package com.linkedlistproblems;

//141. Linked List Cycle
//https://leetcode.com/problems/linked-list-cycle/
// LinkedList cycle detection using slow and fast pointer method
public class CyclicLinkedList {
    public static void main(String[] args) {

    }
    public class ListNode {
        int val;
        CyclicLinkedList.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, CyclicLinkedList.ListNode next) { this.val = val; this.next = next; }
    }

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            if(fast == slow) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
