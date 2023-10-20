package com.trees;

import java.util.*;

//2415. Reverse Odd Levels of Binary Tree
//https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/
public class ReverseOddLevelsOfBinaryTree {
    class TreeNode {
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
    //BFS(level order traversal) using iteration and queue
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int lvl=0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }

            lvl++;
            if(lvl%2 == 1 && !q.isEmpty()){
                int[] nums = new int[q.size()];
                int i = 0;
                for (TreeNode node : q) {
                    nums[i++] = node.val;
                }

                int j = q.size() - 1;
                for (TreeNode node : q) {
                    node.val = nums[j--];
                }
            }
        }
        return root;
    }

    //DFS sol using recursion
    public TreeNode reverseOddLevelsSol2(TreeNode root) {
        // We call the function from lvl 0, and everything starts from lvl 1
        traverse(root.left, root.right, 1);
        return root;
    }

    public void traverse(TreeNode node1, TreeNode node2, int lvl) {
        if (node1 == null || node2 == null) {
            return;
        }
        if (lvl % 2 == 1){
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }

        traverse(node1.left, node2.right, lvl + 1);
        traverse(node1.right, node2.left, lvl + 1);
    }
}
