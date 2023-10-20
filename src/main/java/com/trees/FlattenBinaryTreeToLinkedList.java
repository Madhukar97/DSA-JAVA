package com.trees;

//114. Flatten Binary Tree to Linked List
//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class FlattenBinaryTreeToLinkedList {
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
}
