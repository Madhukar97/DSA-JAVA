package com.trees;

import java.util.*;

//107. Binary Tree Level Order Traversal II
//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
public class BinaryTreeLevelOrderTraversal2 {
    public static void main(String[] args) {

    }
    public class TreeNode {
        int val;
        BinaryTreeLevelOrderTraversal2.TreeNode left;
        BinaryTreeLevelOrderTraversal2.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, BinaryTreeLevelOrderTraversal2.TreeNode left, BinaryTreeLevelOrderTraversal2.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();

        Stack<List<Integer>> stack = new Stack<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if(current != null) inner.add(current.val);

            if(current == null) {
                if(queue.isEmpty()) {
                    break;
                }else {
                    queue.add(null);
                    stack.add(inner);
                    inner = new ArrayList<>();
                    continue;
                }
            }
            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);
        }
        stack.add(inner);
        while (!stack.isEmpty()) {
            outer.add(stack.pop());
        }
        return outer;
    }
}
