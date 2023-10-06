package com.linkedlistproblems;

//2487. Remove Nodes From Linked List
//https://leetcode.com/problems/remove-nodes-from-linked-list/description/
public class RemoveNodesFromLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //Time complexity O(4n) and space O(n)
    public ListNode removeNodes(ListNode head) {
        int len=0;
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode curr=head;

        while(curr != null){
            len++;
            curr=curr.next;
        }
        int[] arr = new int[len];

        curr=head;
        for(int i=0;i<len;i++){
            arr[i] = curr.val;
            curr=curr.next;
        }
        for(int i=len-1;i>=0;i--){
            if(i < len-1 )arr[i]= Math.max(arr[i],arr[i+1]);
        }
        curr=dummy;
        int i=0;
        while(curr.next != null){
            if(curr.next.val < arr[i]){
                curr.next=curr.next.next;
            }
            else curr=curr.next;
            i++;
        }
        return dummy.next;
    }
}
