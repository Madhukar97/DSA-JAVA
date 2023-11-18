package com.trees;

//114. Flatten Binary Tree to Linked List
//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class FlattenBinaryTreeToLinkedList {
    class TreeNode {
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
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        rec(root);
    }

    public void rec(TreeNode node){
        if(node == null) return;

        rec(node.right);
        rec(node.left);

        node.right=prev;
        node.left=null;
        prev=node;
    }

    //Revision 2
    class Solution {
        public void flatten(TreeNode root) {
            TreeNode[] prev = new TreeNode[1];
            rec(root,prev);
        }

        public void rec(TreeNode node, TreeNode[] prev){
            if(node == null) return;

            rec(node.right,prev);
            rec(node.left,prev);

            node.right = prev[0];
            node.left = null;
            prev[0] = node;
        }
    }
}
