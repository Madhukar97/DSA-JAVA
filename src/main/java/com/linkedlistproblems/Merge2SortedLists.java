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
}
