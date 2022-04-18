package com.linkedlistproblems;

//234. Palindrome Linked List
//https://leetcode.com/problems/palindrome-linked-list/
// Google, Microsoft, Facebook, LinkedIn, Apple, Amazon
public class PalindromeLinkedList {
    public static void main(String[] args) {

    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        return recFunc(head, 0, 0);

    }
    static boolean recFunc(ListNode pointer, int normal, int reverse) {
        if(pointer == null) return false;
        normal = normal*10+pointer.val;
        recFunc(pointer.next, normal, reverse);
        reverse = reverse*10+pointer.val;
        if(normal == reverse) return true;
        else return false;
    }
}
