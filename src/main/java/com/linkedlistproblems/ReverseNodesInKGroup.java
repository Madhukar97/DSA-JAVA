package com.linkedlistproblems;

//25. Reverse Nodes in k-Group
//https://leetcode.com/problems/reverse-nodes-in-k-group/description/
public class ReverseNodesInKGroup {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode pointer = head;
        int count=0;
        while(pointer != null){
            count++;
            pointer=pointer.next;
        }

        ListNode pre=dummy;
        ListNode curr=dummy;
        ListNode next=dummy;
        while(count >= k){
            curr=pre.next;
            next=curr.next;
            for(int i=1;i<k;i++){
                curr.next=next.next;
                next.next=pre.next;
                pre.next=next;
                next=curr.next;
            }
            pre=curr;
            count-=k;
        }
        return dummy.next;
    }

    //Optimal sol
    //Revision 2
    public ListNode reverseKGroupR2(ListNode head, int k) {
        ListNode root = new ListNode();
        root.next=head;
        ListNode prev = root;
        ListNode end = head;
        ListNode curr = null;
        if(prev != null) curr = prev.next;
        ListNode next = null;
        if(curr != null) next = curr.next;

        while(end != null){
            for(int i=0;i<k;i++) {
                if(end == null) return root.next;
                end=end.next;
            }
            curr=prev.next;
            next=curr.next;

            while(next != end){
                curr.next=next.next;
                next.next=prev.next;
                prev.next=next;
                next = curr.next;
            }
            prev=curr;
        }
        return root.next;
    }
}
