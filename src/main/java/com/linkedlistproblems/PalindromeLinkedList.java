package com.linkedlistproblems;

//234. Palindrome Linked List
//https://leetcode.com/problems/palindrome-linked-list/
// Google, Microsoft, Facebook, LinkedIn, Apple, Amazon
public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next = new ListNode(2);
        head.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        return recFunc(head, left, right);

    }
    static boolean recFunc(ListNode pointer, ListNode normal, ListNode reverse) {
        if(pointer == null) return true;

        normal.val = normal.val*10+pointer.val;
        recFunc(pointer.next, normal, reverse);
        reverse.val = reverse.val*10+pointer.val;
        if(normal.val == reverse.val) return true;
        else return false;
    }

    //Most optimal sol with time O(n/2+n/2+n/2) and space O(1)
    public boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }

        //reverse the right half of the linked list
        // ListNode pre=slow;
        // ListNode curr=slow.next;
        // ListNode next=null;
        // if(curr != null)next=curr.next;
        // while(next != null){
        //     curr.next=next.next;
        //     next.next=pre.next;
        //     pre.next=next;
        //     next=curr.next;
        // }
        slow.next=reverseLL(slow.next);


        ListNode p1=head;
        ListNode p2=slow.next;
        while(p2 != null){
            if(p1.val != p2.val){
                return false;
            }
            p1=p1.next;
            p2=p2.next;
        }
        return true;
    }

    public ListNode reverseLL(ListNode head){
        ListNode pre=null;
        ListNode curr=head;
        ListNode next=head.next;
        while(curr != null){
            curr.next=pre;
            pre=curr;
            curr=next;
            if(next != null)next=next.next;
        }
        return pre;
    }
}
