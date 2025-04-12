package com.trees;

//104. Maximum Depth of Binary Tree
//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class BinaryTreeMaxDepth {
    public static void main(String[] args) {

    }
    public class TreeNode {
        int val;
        BinaryTreeMaxDepth.TreeNode left;
        BinaryTreeMaxDepth.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, BinaryTreeMaxDepth.TreeNode left, BinaryTreeMaxDepth.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        return recFunc(root);
    }
    static int recFunc(TreeNode root) {
        if(root == null) return 0;
        return Math.max(recFunc(root.left) + 1, recFunc(root.right) + 1);
    }

    // Revision 5
    class Solution {
        public int maxDepth(TreeNode root) {
            if(root == null) return 0;
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return 1 + Math.max(left,right);
        }
    }
}
