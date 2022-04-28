package com.trees;

//111. Minimum Depth of Binary Tree
//https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class BinaryTreeMinDepth {
    public static void main(String[] args) {

    }
    public class TreeNode {
        int val;
        BinaryTreeMinDepth.TreeNode left;
        BinaryTreeMinDepth.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, BinaryTreeMinDepth.TreeNode left, BinaryTreeMinDepth.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int minDepth(TreeNode root) {
        int ans = recFunc(root);
        return ans;
    }

    static int recFunc(TreeNode root) {
        if(root == null) return 0;
        int l =0;
        int r = 0;
        l = recFunc(root.left);
        r = recFunc(root.right);
        if(l == 0) return r+1;
        if(r == 0) return l+1;
        else return Math.min(l+1, r+1);
    }
}
