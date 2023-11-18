package com.trees.bst;

//700. Search in a Binary Search Tree
//https://leetcode.com/problems/search-in-a-binary-search-tree/description/
public class SearchInABinarySearchTree {
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
    //use DFS with recursion : return node if found else null
    public TreeNode searchBST(TreeNode root, int val) {
        return rec(root,val);
    }

    public TreeNode rec(TreeNode node, int val){
        if(node == null) return null;

        if(node.val == val) return node;

        TreeNode left = rec(node.left, val);
        TreeNode right = rec(node.right, val);

        if(left == null) return right;
        return left;
    }

    //Revision 2
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            return rec(root, val);
        }

        public TreeNode rec(TreeNode node, int val){
            if(node == null) return null;
            if(node.val == val) return node;

            if(val < node.val) return rec(node.left,val);
            return rec(node.right,val);
        }
    }
}
