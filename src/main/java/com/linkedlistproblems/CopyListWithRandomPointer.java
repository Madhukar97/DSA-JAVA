package com.linkedlistproblems;

//138. Copy List with Random Pointer
//https://leetcode.com/problems/copy-list-with-random-pointer/description/
public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    //Most Optimal sol with time O(3n) and space O(1)
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node originalHead=head;
        Node curr=head;
//step 1 insert copy nodes
        while(curr != null){
            Node temp = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next=temp;
            curr=curr.next.next;
        }
//step 2 assign random pointers to copied nodes
        curr=head;
        while(curr != null){
            if(curr.random != null)curr.next.random=curr.random.next;
            curr=curr.next.next;
        }
//step 3 seperate original LL and copy LL
        Node res=head.next;
        Node origCurr=head;
        Node clone=head.next;
        Node origNext=head.next.next;
        while(origCurr != null){
            if(clone.next != null)clone.next=clone.next.next;
            origCurr.next=origNext;
            clone=clone.next;
            origCurr=origNext;
            if(origNext != null && origNext.next != null)origNext=origNext.next.next;
            else origNext = null;
        }
        return res;
    }

    //Optimal sol
    //Revision 2
    public Node copyRandomListR2(Node head) {
        Node originalHead = head;

        //Step 1 insert clone nodes
        Node curr = head;
        while(curr != null){
            Node clone = new Node(curr.val);
            clone.next=curr.next;
            curr.next=clone;
            curr = curr.next.next;
        }

        //Step 2 assign random pointers
        curr = head;
        while(curr != null ){
            if(curr.random != null) curr.next.random = curr.random.next;
            curr=curr.next.next;
        }

        //Step 3 seperate clone list
        Node cloneHead = new Node(0);
        Node cloneCurr = cloneHead;
        curr=head;
        while(curr != null){
            cloneCurr.next=curr.next;
            curr.next=curr.next.next;
            curr=curr.next;
            cloneCurr=cloneCurr.next;
        }
        return cloneHead.next;
    }
}
