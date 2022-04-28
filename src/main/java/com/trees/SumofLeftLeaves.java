package com.trees;

//404. Sum of Left Leaves
//https://leetcode.com/problems/sum-of-left-leaves/
public class SumofLeftLeaves {
    public static void main(String[] args) {

    }
    public class TreeNode {
        int val;
        SumofLeftLeaves.TreeNode left;
        SumofLeftLeaves.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, SumofLeftLeaves.TreeNode left, SumofLeftLeaves.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        if(root.left == null && root.right == null) return 0;
        recFunc(root);
        return sum;
    }
    static void recFunc(TreeNode root) {
        if(root == null) return;
        if(root.left != null && root.left.left == null && root.left.right == null) sum = sum+root.left.val;
        if(root.left != null) recFunc(root.left);
        if(root.right != null) recFunc(root.right);
    }
}
