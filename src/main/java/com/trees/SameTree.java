package com.trees;

//100. Same Tree
//https://leetcode.com/problems/same-tree/description/  
public class SameTree {
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
    //Sol using Inorder traversal with time O(min(n1,n2)) and space O(1)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return rec(p,q);
    }

    public boolean rec(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        else if(p == null || q == null) return false;
        else if(p.val != q.val) return false;

        return rec(p.left,q.left) && rec(p.right,q.right);
    }

    // Revision 5
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p == null && q == null) return true;
            if((p == null && q != null) || (p != null && q == null) || p.val != q.val) return false;

            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
