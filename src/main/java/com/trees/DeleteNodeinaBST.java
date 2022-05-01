package com.trees;

//450. Delete Node in a BST
//https://leetcode.com/problems/delete-node-in-a-bst/
public class DeleteNodeinaBST {
    public static void main(String[] args) {

    }
    public class TreeNode {
        int val;
        DeleteNodeinaBST.TreeNode left;
        DeleteNodeinaBST.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, DeleteNodeinaBST.TreeNode left, DeleteNodeinaBST.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(key <  root.val) root.left = deleteNode(root.left, key);
        else if(key > root.val) root.right = deleteNode(root.right, key);
        else {
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;

            root.val = minVal(root.right);

            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    int minVal(TreeNode root) {
        int minVal = root.val;

        while(root != null) {
            minVal = root.val;
            root = root.left;
        }
        return minVal;
    }
}
