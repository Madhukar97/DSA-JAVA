package com.trees.bst;

import com.trees.BinaryTreeLevelOrderTraversal;

import java.util.*;

//230. Kth Smallest Element in a BST
//https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
public class KthSmallestElementInABST {
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
    //store inorder traversal(sorted list) in a array and return arr[k-1]
    // Time O(n) and space O(n)
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        rec(root,list);
        return list.get(k-1);
    }

    public void rec(TreeNode node, List<Integer> list){
        if(node == null) return;

        rec(node.left,list);
        list.add(node.val);
        rec(node.right,list);
    }

    //use DFS and recursion and carry count when count == k return ans
    //time O(n) and space(1)
    public int kthSmallestSol2(TreeNode root, int k) {
        int[] count = new int[1];
        return rec(root,k,count).val;
    }

    public TreeNode rec(TreeNode node, int k, int[] count){
        if(node == null) return null;

        TreeNode left = rec(node.left,k,count);
        count[0]+=1;
        if(count[0] == k) return node;
        TreeNode right = rec(node.right,k,count);
        if(left == null) return right;
        return left;
    }

    //Revision 2
    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            int[] arr = new int[2];
            arr[0] =k;
            rec(root,arr);
            return arr[1];
        }

        public void rec(TreeNode node, int[] arr){
            if(node == null) return;

            rec(node.left,arr);
            arr[0]--;
            if(arr[0] == 0) arr[1] = node.val;
            rec(node.right,arr);
        }
    }
}
