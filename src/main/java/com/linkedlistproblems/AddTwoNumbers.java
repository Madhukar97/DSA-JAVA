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
    //Most optimal sol with time O(max(n1,n2)) and space O(n)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode digit = dummy;

        int carry=0;
        while(l1 != null || l2 != null || carry != 0){
            int sum=0;
            if(l1 != null){
                sum+=l1.val;
                l1=l1.next;
            }

            if(l2 != null){
                sum+=l2.val;
                l2=l2.next;
            }

            sum+=carry;

            carry=sum/10;
            ListNode curr = new ListNode(sum%10);
            digit.next=curr;
            digit=digit.next;
        }
        return dummy.next;
    }
}
