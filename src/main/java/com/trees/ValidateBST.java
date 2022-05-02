package com.trees;

//98. Validate Binary Search Tree
//https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBST {
    public static void main(String[] args) {

    }
    public class TreeNode {
        int val;
        ValidateBST.TreeNode left;
        ValidateBST.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, ValidateBST.TreeNode left, ValidateBST.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        if(!isValidBST(root.left)) return false;
        if(pre != null && pre.val >= root.val) return false;
        pre = root;
        return isValidBST(root.right);

    }
}
