package com.trees;

import java.util.*;

//106. Construct Binary Tree from Inorder and Postorder Traversal
//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
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
    //do inorder traversal and use a map to store inorder indexes and create and return the node :
    // the last element in every postorder[] traversal will be root and left and right parts of this root in inorder[] will be left and right subtrees

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> inMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++) inMap.put(inorder[i],i);

        TreeNode root = rec(inorder,0,inorder.length-1,postorder,0,postorder.length-1,inMap);
        return root;
    }

    public TreeNode rec(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer,Integer> inMap){
        if(inStart > inEnd || postStart > postEnd) return null;

        TreeNode node = new TreeNode(postorder[postEnd]);
        int nodeIndex = inMap.get(postorder[postEnd]);
        int numbersRight = inEnd-nodeIndex;

        node.right = rec(inorder, nodeIndex+1, inEnd, postorder, postEnd-numbersRight, postEnd-1,inMap);
        node.left = rec(inorder, inStart, nodeIndex-1, postorder, postStart, postEnd-numbersRight-1, inMap);
        return node;
    }
}
