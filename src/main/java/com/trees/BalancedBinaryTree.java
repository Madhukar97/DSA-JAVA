package com.trees;

//110. Balanced Binary Tree
//https://leetcode.com/problems/balanced-binary-tree/description/
public class BalancedBinaryTree {
    public class TreeNode {
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
    //In order traversal with time O(n) and space O(n)
    public boolean isBalanced(TreeNode root) {
        boolean[] ans = new boolean[1];
        ans[0]=true;
        rec(root,ans);
        return ans[0];
    }

    public int rec(TreeNode node, boolean[] ans){
        if(node == null) return 0;

        int left = rec(node.left, ans);
        int right = rec(node.right, ans);

        if(Math.abs(left-right) > 1) ans[0]=false;
        return Math.max(left,right)+1;
    }
}
