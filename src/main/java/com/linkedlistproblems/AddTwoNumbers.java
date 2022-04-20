package com.linkedlistproblems;

//2. Add Two Numbers
//https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {
    public static void main(String[] args) {

    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;
        ListNode slow = null;
        int temp = 0;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            if(temp == 1){
                if(sum+1 > 9) {
                    temp = 1;
                    l1.val = ((sum+1)%10);
                    slow = l1;
                    l1 = l1.next;
                    l2 = l2.next;
                }else {
                    temp = 0;
                    l1.val = sum+1;
                    slow = l1;
                    l1 = l1.next;
                    l2 = l2.next;
                }
            } else {
                if(sum > 9) {
                    temp = 1;
                    l1.val = (sum%10);
                    slow = l1;
                    l1 = l1.next;
                    l2 = l2.next;
                }else {
                    temp = 0;
                    l1.val = sum;
                    slow = l1;
                    l1 = l1.next;
                    l2 = l2.next;
                }
            }

        }
        while(l1 != null){
            int sum = l1.val+temp;
            if(temp==1){
                if(sum > 9){
                    temp = 1;
                    l1.val = sum%10;
                    slow = l1;
                    l1 = l1.next;
                }else {
                    temp = 0;
                    l1.val = sum;
                    slow = l1;
                    l1 = l1.next;
                }
            } else {
                l1.val = l1.val;
                slow = l1;
                l1 = l1.next;
            }
        }
        if(l2 != null) {
            l1 = slow;
            l1.next = l2;
            l1 = l2;
        }
        while(l2 != null){
            l1 = l2;
            int sum = l2.val+temp;
            if(temp==1){
                if(sum > 9){
                    temp = 1;
                    l2.val = sum%10;
                    slow = l1;
                    l2 = l2.next;
                    l1 = l1.next;
                }else {
                    temp = 0;
                    l2.val = sum;
                    slow = l1;
                    l2 = l2.next;
                    l1 = l1.next;
                }
            } else {
                l2.val = l2.val;
                slow = l1;
                l2 = l2.next;
                l1 = l1.next;
            }
        }
        if(temp == 1) {
            slow.next = new ListNode(1);
        }
        return head;
    }
}
