package com.trees;

//701. Insert into a Binary Search Tree
//https://leetcode.com/problems/insert-into-a-binary-search-tree/
public class InsertIntoBST {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        InsertIntoBST.TreeNode left;
        InsertIntoBST.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, InsertIntoBST.TreeNode left, InsertIntoBST.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);

        if(val < root.val) root.left = insertIntoBST(root.left, val);
        if(val > root.val) root.right = insertIntoBST(root.right, val);

        return root;
    }
}
