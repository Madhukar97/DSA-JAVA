package com.trees.bst;

import com.trees.BinaryTreeLevelOrderTraversal;

//1373. Maximum Sum BST in Binary Tree
//https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/description/
public class MaximumSumBSTInBinaryTree {
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
    //sol using NodeValue class
    //for a valid BST the largest of left-subtree should be less than root and root should be less than the smallest of right-subtree
    //leftSubTree.largest < root < rightSubTree.smallest
    int maxi=0;
    public int maxSumBST(TreeNode root) {
        rec(root);
        return maxi;
    }

    public NodeValue rec(TreeNode node){
        if(node == null) return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0,0);

        NodeValue left = rec(node.left);
        NodeValue right = rec(node.right);

        if(left.maxNode < node.val && node.val < right.minNode){
            maxi = Math.max(maxi, left.maxSum+right.maxSum+node.val);
            return new NodeValue(Math.min(node.val, left.minNode), Math.max(node.val, right.maxNode), left.maxSize+right.maxSize+1, left.maxSum+right.maxSum+node.val);

        }
        return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.maxSize,right.maxSize),Math.max(0,Math.max(left.maxSum,right.maxSum)));
    }

    class NodeValue{
        int minNode, maxNode, maxSize, maxSum;

        public NodeValue(int minNode, int maxNode, int maxSize, int maxSum){
            this.minNode=minNode;
            this.maxNode=maxNode;
            this.maxSize=maxSize;
            this.maxSum=maxSum;
        }
    }
}
