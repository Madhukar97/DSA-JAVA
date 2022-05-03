package com.trees;

//112. Path Sum
//https://leetcode.com/problems/path-sum/
public class PathSum {
    public static void main(String[] args) {

    }
    public class TreeNode {
        int val;
        PathSum.TreeNode left;
        PathSum.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, PathSum.TreeNode left, PathSum    .TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return recFunc(root, targetSum, 0);
    }

    boolean recFunc(TreeNode root, int target, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && sum+root.val != target) return false;

        if(root.left == null && root.right == null && sum+root.val == target) return true;

        sum = sum+root.val;

        if(root != null && recFunc(root.left, target, sum)) {
            return true;
        }
        return (root != null && recFunc(root.right, target, sum));
    }
}
