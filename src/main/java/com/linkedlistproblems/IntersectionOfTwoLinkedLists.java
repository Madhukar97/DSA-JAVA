package com.linkedlistproblems;

import java.util.HashSet;
import java.util.Set;

//160. Intersection of Two Linked Lists
//https://leetcode.com/problems/intersection-of-two-linked-lists/description/
public class IntersectionOfTwoLinkedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //Better sol using hashing with time O(n+m) and space O(n)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        ListNode ans = null;
        Set<ListNode> set = new HashSet<>();

        while(l1 != null){
            set.add(l1);
            l1=l1.next;
        }

        while(l2 != null){
            if(set.contains(l2)) {
                return l2;
            }
            l2=l2.next;
        }
        return ans;
    }
    //Most Optimal sol with time O(n+m) and space O(1)
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        int len1=0;
        int len2=0;

        while(l1 != null){
            l1=l1.next;
            len1++;
        }
        while(l2 != null){
            l2=l2.next;
            len2++;
        }

        l1=headA;
        l2=headB;
        if(len1 > len2){
            for(int i=0;i<len1-len2;i++){
                l1=l1.next;
            }
        }else{
            for(int i=0;i<len2-len1;i++){
                l2=l2.next;
            }
        }

        while(l1 != null && l2 !=null){
            if(l1 == l2) return l1;
            l1=l1.next;
            l2=l2.next;
        }
        return null;
    }
}
