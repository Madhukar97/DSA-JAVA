package com.trees;

import java.util.*;

//102. Binary Tree Level Order Traversal
//https://leetcode.com/problems/binary-tree-level-order-traversal/
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

    }
    public class TreeNode {
        int val;
        BinaryTreeLevelOrderTraversal.TreeNode left;
        BinaryTreeLevelOrderTraversal.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, BinaryTreeLevelOrderTraversal.TreeNode left, BinaryTreeLevelOrderTraversal.TreeNode right) {
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

    // Revision 5
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if(root == null) return ans;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            List<Integer> lvl = new ArrayList<>();

            while(!q.isEmpty()){
                int size = q.size();
                lvl = new ArrayList<>();
                for(int i=0;i<size;i++){
                    TreeNode curr = q.poll();
                    if(curr.left != null) q.add(curr.left);
                    if(curr.right != null) q.add(curr.right);
                    lvl.add(curr.val);
                }
                ans.add(lvl);
            }
            return ans;
        }
    }
}
