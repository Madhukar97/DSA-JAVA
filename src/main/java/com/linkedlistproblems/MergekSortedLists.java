package com.linkedlistproblems;

//23. Merge k Sorted Lists
//https://leetcode.com/problems/merge-k-sorted-lists/description/
public class MergekSortedLists {
    public class ListNode {
        int val;
       ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val,ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];

        ListNode root = lists[0];

        for(int i=1;i<lists.length;i++){
            root = merge2Lists(root, lists[i]);
        }
        return root;
    }

    public ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode head = new ListNode();
        ListNode temp = head;
        ListNode a = l1;
        ListNode b = l2;

        while(a != null && b!=null){
            if(a.val < b.val){
                temp.next = a;
                a=a.next;
                temp=temp.next;
            }else{
                temp.next=b;
                b=b.next;
                temp=temp.next;
            }
        }

        if(a != null) temp.next=a;
        else temp.next = b;
        return head.next;
    }
}
