package com.linkedlistproblems;

//2074. Reverse Nodes in Even Length Groups
//https://leetcode.com/problems/reverse-nodes-in-even-length-groups/description/
public class ReverseNodesInEvenLengthGroups {
    //sol similar to Reverse Nodes in K Groups
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int k = 1;
        ListNode root = new ListNode();
        root.next=head;
        ListNode prev = root;
        ListNode end = head;
        ListNode curr = null;
        if(prev != null) curr = prev.next;
        ListNode next = null;
        if(curr != null) next = curr.next;

        while(next != null && prev != null){
            int count=0;
            for(int i=0;i<k;i++) {
                if(end == null) break;
                end=end.next;
                count++;
            }
            k=count;
            // if(end != null) System.out.println("END : "  +end.val);
            curr=prev.next;
            if(curr != null) next=curr.next;

            // if(curr != null) System.out.println("curr : "  +curr.val);
            // if(next != null) System.out.println("next : "  +next.val);

            // System.out.println(" iteration starts ----------------------");

            while(curr != null && next != end && k%2 == 0){
                curr.next=next.next;
                next.next=prev.next;
                prev.next=next;
                next = curr.next;
            }
            if(k%2 != 0){
                for(int i=0;i<k && prev != null;i++) prev=prev.next;
            }
            else prev=curr;
            k++;
        }
        return root.next;
    }
}
