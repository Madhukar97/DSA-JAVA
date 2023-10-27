package com.trees.bst;

//109. Convert Sorted List to Binary Search Tree
//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
public class ConvertSortedListToBinarySearchTree {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //use DFS and recursion start with mid as root and keep returning left and right nodes
    public TreeNode sortedListToBST(ListNode head) {
        ListNode curr = head;
        int n=0;
        while(curr != null){
            n++;
            curr=curr.next;
        }
        return rec(head, 0 , n-1);
    }

    public TreeNode rec(ListNode head, int l, int r){
        if(l > r) return null;

        int mid = (l+r)/2;
        ListNode curr = head;
        for(int i=0;i<mid;i++){
            curr=curr.next;
        }
        TreeNode node = new TreeNode(curr.val);

        node.left = rec(head, l, mid-1);
        node.right = rec(head, mid+1, r);

        return node;
    }
    //use DFS and recursion start with mid as root and keep returning left and right nodes
    public TreeNode sortedListToBSTSol2(ListNode head) {
        ListNode curr = head;
        int n=0;
        while(curr != null){
            n++;
            curr=curr.next;
        }
        int[] arr = new int[n];
        curr = head;
        int i=0;
        while(curr != null){
            arr[i++] = curr.val;
            curr=curr.next;
        }
        return rec(arr, 0 , n-1);
    }

    public TreeNode rec(int[] arr, int l, int r){
        if(l > r) return null;

        int mid = (l+r)/2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = rec(arr, l, mid-1);
        node.right = rec(arr, mid+1, r);
        return node;
    }
}
