package com.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//543. Diameter of Binary Tree
//https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfBinaryTree {
    public static void main(String[] args) {

    }
    public class TreeNode {
        int val;
        DiameterOfBinaryTree.TreeNode left;
        DiameterOfBinaryTree.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, DiameterOfBinaryTree.TreeNode left, DiameterOfBinaryTree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        diameter(root);
        return ans-1;
    }

    int diameter(TreeNode node) {
        if(node == null) return 0;

        int l = diameter(node.left);
        int r = diameter(node.right);
        ans = Math.max(ans, 1+l+r);
        return Math.max(l,r) +1;
    }
}
