package com.linkedlistproblems;

import java.util.Random;

//382. Linked List Random Node
//https://leetcode.com/problems/linked-list-random-node/description/
public class LinkedListRandomNode {
    
//     Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

      //Time complexity: O(n+c) and SC = O(n)

    class Solution {
        ListNode head;
        int size;
        Random random;

        public Solution(ListNode head) {
            this.head=head;
            random = new Random();
            int len=0;
            ListNode node = head;
            while(node != null){
                node=node.next;
                len++;
            }
            size=len;
        }

        public int getRandom() {
            int index = random.nextInt(size);
            ListNode node = head;
            for(int i=0;i<index;i++){
                node=node.next;
            }
            return node.val;
        }
    }

/**
  Your Solution object will be instantiated and called as such:
  Solution obj = new Solution(head);
  int param_1 = obj.getRandom();
 */

    //Reservoir Sampling : the probability of choosing new hat is 1/i and keeping the existing hat is (i-1)/i
    //What if the linked list is extremely large and its length is unknown to you?
    //Could you solve this efficiently without using extra space?
class Solution2 {
    ListNode head;
    Random rand;

    public Solution2(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }

    public int getRandom() {
        ListNode node = head;
        int count=0, res=0;

        while(node != null) {
            count++;
            if(rand.nextInt(count) == 0)
                res = node.val;
            node = node.next;
        }

        return res;
    }
}
}
