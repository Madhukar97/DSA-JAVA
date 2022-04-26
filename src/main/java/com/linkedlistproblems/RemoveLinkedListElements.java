package com.linkedlistproblems;

//203. Remove Linked List Elements
public class RemoveLinkedListElements {
    public static void main(String[] args) {

    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        ListNode l = null;
        ListNode r = head;
        while(r != null) {
            if(r.val == val && l == null) {
                head = r.next;
                r = head;
            }else if(r.val == val) {
                l.next = r.next;
                r = l.next;
            }else {
                l = r;
                r = r.next;
            }
        }
        return head;
    }
}
