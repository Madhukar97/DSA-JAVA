package com.trees;

//235. Lowest Common Ancestor of a Binary Search Tree
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class LowestCommonAncestorofBST {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        LowestCommonAncestorofBST.TreeNode left;
        LowestCommonAncestorofBST.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, LowestCommonAncestorofBST.TreeNode left, LowestCommonAncestorofBST.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;

        TreeNode left = null;
        TreeNode right = null;

        if(p.val < root.val || q.val < root.val) left = lowestCommonAncestor(root.left, p, q);
        if(p.val > root.val || q.val > root.val) right = lowestCommonAncestor(root.right, p, q);

        if(left == null) return right;
        if(right == null) return left;

        return root;
    }
}
