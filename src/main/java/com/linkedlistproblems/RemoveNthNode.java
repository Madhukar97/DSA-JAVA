package com.linkedlistproblems;

//19. Remove Nth Node From End of List
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNode {
    public static void main(String[] args) {

    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null && n == 1) return null;
        ListNode pointer = head;
        int length = 0;
        while(pointer != null){
            pointer = pointer.next;
            length++;
        }
        int skip = length - n;
        pointer = head;
        for (int i = 1 ; i < skip; i++){
            pointer = pointer.next;
        }
        if(n == length) return pointer.next;
        if(pointer.next != null) pointer.next = pointer.next.next;
        else pointer.next = null;
        return head;
    }
}
