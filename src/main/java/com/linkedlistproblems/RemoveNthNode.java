package com.linkedlistproblems;

//19. Remove Nth Node From End of List
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNode {
    public static void main(String[] args) {
        System.out.println((long)-2147483648/-1);
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count=0;
        ListNode curr=head;

        while(curr != null){
            curr=curr.next;
            count++;
        }

        int i=1;
        curr=head;
        while(i < count-n ){
            curr=curr.next;
            i++;
        }
        if(n==count) return curr.next;
        if(curr.next != null)curr.next=curr.next.next;
        return head;
    }
}
