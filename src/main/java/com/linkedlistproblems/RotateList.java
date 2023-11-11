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

    //Sol 2
    public ListNode rotateRightSol2(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int rotations=k;
        int len=0;
        ListNode res=new ListNode();
        res.next=head;
        ListNode curr=head;
        while(curr != null){
            curr=curr.next;
            len++;
        }
        rotations=k%len;  // if the k is same as length or greater than len then calc no.of rotations

        if(rotations > 0){
            ListNode p1=head;
            ListNode p2=head;

            for(int i=1;i<len-rotations;i++) p1=p1.next;
            while(p2.next != null) p2=p2.next;
            ListNode temp=res.next;
            res.next=p1.next;
            p1.next=null;
            p2.next=temp;
        }
        return res.next;
    }

    //Revision 2
    public ListNode rotateRightR2(ListNode head, int k) {
        if(k == 0 || head == null || head.next==null) return head;
        int len = 1;
        ListNode end = head;

        while(end.next != null){
            end=end.next;
            len++;
        }

        k=k%len;
        ListNode root = new ListNode();
        root.next = head;

        ListNode start = head;
        for(int i=1;i<len-k;i++){
            start = start.next;
        }
        end.next = head;
        root.next = start.next;
        start.next=null;
        return root.next;
    }
}
