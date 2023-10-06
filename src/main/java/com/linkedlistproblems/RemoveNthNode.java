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
    //Optimal sol with time O(2n) and space O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len=0;
        ListNode curr=head;

        while(curr != null){
            curr=curr.next;
            len++;
        }

        curr=head;
        for(int i=1;i<len-n;i++){
            curr=curr.next;
        }

        if(n==len) return head.next;
        if(curr.next != null) curr.next=curr.next.next;
        return head;
    }
}
