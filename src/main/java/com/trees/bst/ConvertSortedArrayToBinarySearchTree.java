package com.trees.bst;

import com.trees.SearchInABinarySearchTree;

//108. Convert Sorted Array to Binary Search Tree
//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
public class ConvertSortedArrayToBinarySearchTree {
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
    //using DFS and recursion start with mid as root and keep returning left and right nodes
    public TreeNode sortedArrayToBST(int[] nums) {
        return rec(nums, 0, nums.length-1);
    }

    public TreeNode rec(int[] nums, int l, int r){
        if(l>r) return null;

        int mid = (l+r)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = rec(nums, l, mid-1);
        node.right = rec(nums, mid+1,r);
        return node;
    }
}
