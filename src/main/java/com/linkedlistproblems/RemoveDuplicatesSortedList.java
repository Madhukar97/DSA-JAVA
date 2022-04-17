package com.linkedlistproblems;

// 83. Remove Duplicates from Sorted List leetcode easy
public class RemoveDuplicatesSortedList {

    public void main(String[] args) {

    }

    private class ListNode {
     int val;
     ListNode next;
     ListNode() {};
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        if(current == null) return head;
        while( current.next != null ) {
            if( current.val == current.next.val ) {
                current.next = current.next.next;
            }
            else current = current.next;
        }
        return head;
    }
}
