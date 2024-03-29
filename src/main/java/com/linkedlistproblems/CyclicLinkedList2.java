package com.linkedlistproblems;

//142. Linked List Cycle II
//https://leetcode.com/problems/linked-list-cycle-ii/
public class CyclicLinkedList2 {
    public static void main(String[] args) {

    }
    public class ListNode {
        int val;
        CyclicLinkedList2.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, CyclicLinkedList2.ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode fast = head.next;
        ListNode slow = head;

        ListNode first = head;
        ListNode second = head;

        int length = 1;
        while(fast != null && fast.next != null) {
            if( fast == slow ) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast == null || fast.next == null) return null;
        fast = fast.next;
        while( fast != slow) {
            length++;
            fast = fast.next;
        }

        for(int i = 0; i < length; i++) {
            second = second.next;
        }
        while( first != second ) {
            first = first.next;
            second = second.next;
        }
        return first;
    }

    //Optimal sol
    public ListNode detectCycleSol2(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow=head;
        ListNode fast=head;
        while(fast != null && fast.next !=null ){
            slow=slow.next;
            fast=fast.next.next;
            if(slow == fast){
                break;
            }
        }

        slow=head;
        while(fast != null){
            if(slow == fast) return slow;
            slow=slow.next;
            fast=fast.next;
        }
        return null;
    }

    //Optimal sol 2
    //Revision 2
    public ListNode detectCycleR2(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }

        if(slow != fast) return null;

        slow = head;
        while(slow != fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
