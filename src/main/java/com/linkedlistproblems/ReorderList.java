package com.linkedlistproblems;

//143. Reorder List
//https://leetcode.com/problems/reorder-list/
// google
public class ReorderList {
    public static void main(String[] args) {

    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;

        ListNode head1 = head;
        ListNode mid = findMid(head);
        ListNode l2 = reverseLL(mid);

        while(head1 != null && l2 != null) {
            ListNode temp = head1.next;
            head1.next = l2;
            head1 = temp;

            temp = l2.next;
            l2.next = head1;
            l2 = temp;
        }

        //setting next of tail to null
        if(head1 != null) {
            head1.next = null;
        }
    }

    static ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while( fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static ListNode reverseLL(ListNode head) {
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
