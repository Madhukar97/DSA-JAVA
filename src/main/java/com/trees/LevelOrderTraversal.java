package com.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//102. Binary Tree Level Order Traversal
//https://leetcode.com/problems/binary-tree-level-order-traversal/
public class LevelOrderTraversal {
    public static void main(String[] args) {

    }
    public class TreeNode {
        int val;
        LevelOrderTraversal.TreeNode left;
        LevelOrderTraversal.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, LevelOrderTraversal.TreeNode left, LevelOrderTraversal.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

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
        return outer;
    }
}
