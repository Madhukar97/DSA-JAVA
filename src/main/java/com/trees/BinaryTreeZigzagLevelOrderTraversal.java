package com.trees;

import java.util.*;

//103. Binary Tree Zigzag Level Order Traversal
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {

    }
    public class TreeNode {
        int val;
        BinaryTreeZigzagLevelOrderTraversal.TreeNode left;
        BinaryTreeZigzagLevelOrderTraversal.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, BinaryTreeZigzagLevelOrderTraversal.TreeNode left, BinaryTreeZigzagLevelOrderTraversal.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean flag = false;

        List<List<Integer>> outer  = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if(node != null){
                inner.add(node.val);
            }

            if(node == null) {
                if(queue.isEmpty()){
                    break;
                }
                else {
                    queue.add(null);
                    outer.add(inner);
                    inner = new ArrayList<>();
                    continue;
                }
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        outer.add(inner);
        for(int i=1; i<outer.size(); i=i+2) {
            Collections.reverse(outer.get(i));
        }
        return outer;
    }
}
