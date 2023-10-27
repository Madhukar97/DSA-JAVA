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
    //sol 2 using DFS and min and max range
    public boolean isValidBSTSol2(TreeNode root) {
        return rec(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean rec(TreeNode node, long min, long max){
        if(node == null) return true;
        if(node.val <= min || node.val >= max) return false;

        return rec(node.left, min, node.val) && rec(node.right, node.val, max);
    }
}
