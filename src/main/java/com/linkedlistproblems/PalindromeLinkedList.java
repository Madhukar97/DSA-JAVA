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
}
