package com.linkedlistproblems;

//61. Rotate List
//https://leetcode.com/problems/rotate-list/
// google twitter facebook
public class RotateList {
    public static void main(String[] args) {

    }
    public static class ListNode {
        int val;
        RotateList.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, RotateList.ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(k <=0 || head == null || head.next == null) return head;
        int length = 1;

        ListNode last = head;
        while(last.next != null) {
            last = last.next;
            length++;
        }

        last.next = head;

        int rotate = k%length;
        int skip = length - rotate;

        ListNode newLast = head;

        for( int i=1; i< skip; i++) {
            newLast = newLast.next;
        }

        head = newLast.next;
        newLast.next = null;
        return head;
    }
}
