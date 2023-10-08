package com.linkedlistproblems;

//21. Merge Two Sorted Lists
//https://leetcode.com/problems/merge-two-sorted-lists/
public class Merge2SortedLists {
    public static void main(String[] args) {

    }
    public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newList = null;
        ListNode pointer = newList;
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val < list2.val){
            newList = list1;
            pointer = list1;
            list1 = list1.next;
        }
        else {
            newList = list2;
            pointer = list2;
            list2 = list2.next;
        }

        while( list1 != null && list2 != null ) {
            if( list1.val < list2.val ) {
                pointer.next = list1;
                list1 = list1.next;
                pointer = pointer.next;
            } else {
                pointer.next = list2;
                list2 = list2.next;
                pointer = pointer.next;
            }
        }
        if( list1 == null && list2 != null ) {
            pointer.next = list2;
        }
        if( list1 != null && list2 == null ) {
            pointer.next = list1;
        }
        return newList;
    }

    //sol 2 using 3 pointer and swapping(not recommended) with time O(n1 + n2) and space O(1)
    public ListNode mergeTwoListsSol2(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2==null) return list1;
        ListNode l1 = list1;
        ListNode l2 = list2;

        if(list1.val > list2.val){
            l1=list2;
            l2=list1;
        }
        ListNode temp=l1;
        ListNode head=l1;

        while(l1 != null && l2 != null){
            while(l1 != null && l1.val <= l2.val){
                temp = l1;
                l1 = l1.next;
            }
            temp.next = l2;

            //swap
            ListNode temp2 = l2;
            l2=l1;
            l1=temp2;
        }
        return head;
    }
    //sol 3 using 3 pointer with time O(n1 + n2) and space O(1)
    public ListNode mergeTwoListssol3(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode temp=new ListNode();
        ListNode res=temp;
        ListNode a=list1;
        ListNode b=list2;
        while(a != null && b!= null){
            if(a.val < b.val){
                temp.next=a;
                a=a.next;
                temp=temp.next;
            }else{
                temp.next=b;
                b=b.next;
                temp=temp.next;
            }
        }

        if(a != null) temp.next=a;
        else if(b!=null) temp.next = b;
        return res.next;
    }
}
