package com.linkedlistproblems;

//2095. Delete the Middle Node of a Linked List
//https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
public class DeletetheMiddleNodeofaLinkedList {
    public static void main(String[] args) {

    }
    public class ListNode {
        int val;
        DeletetheMiddleNodeofaLinkedList.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, DeletetheMiddleNodeofaLinkedList.ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = slow.next;
        return head;
    }
}
