package com.trees.bst;

import com.trees.BinaryTreeLevelOrderTraversal;

import java.util.Stack;

//173. Binary Search Tree Iterator
//https://leetcode.com/problems/binary-search-tree-iterator/description/
public class BinarySearchTreeIterator {
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
    private Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        pushAllLeft(root);
    }

    public int next() {
        TreeNode curr = stack.pop();
        pushAllLeft(curr.right);
        return curr.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAllLeft(TreeNode node){
        while( node != null){
            stack.push(node);
            node=node.left;
        }
    }
}
