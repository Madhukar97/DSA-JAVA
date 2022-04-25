package com.linkedlistproblems;

//82. Remove Duplicates from Sorted List II
//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
public class RemoveDuplicatesfromSortedList2 {
    public static void main(String[] args) {

    }
    private class ListNode {
        int val;
        RemoveDuplicatesfromSortedList2.ListNode next;
        ListNode() {};
        ListNode(int val) { this.val = val; }
        ListNode(int val, RemoveDuplicatesfromSortedList2.ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode ans = head;
        ListNode pre = null;
        ListNode current = head;
        ListNode next = head.next;
        while(next != null) {
            if(current.val == next.val) {
                while(next != null && current.val == next.val) {
                    next = next.next;
                }
                if(pre == null) head = next;
                else pre.next = next;
                current = next;
                if(next != null) next = next.next;
            }else{
                pre = current;
                current = next;
                if(next != null) next = next.next;
            }
        }
        return head;
    }
}
