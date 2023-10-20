package com.trees;

import java.util.*;

//105. Construct Binary Tree from Preorder and Inorder Traversal
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
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
    // the 1st element in every preorder traversal will be root and left and right parts of this root in inorder[] will be left and right subtrees
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> imap = new HashMap<>();
        for(int i=0;i<inorder.length;i++) imap.put(inorder[i], i);

        TreeNode root = rec(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1,imap);
        return root;
    }

    public TreeNode rec(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer,Integer> imap){
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode node = new TreeNode(preorder[preStart]);
        int rootIndex = imap.get(preorder[preStart]);
        int numbersLeft = rootIndex - inStart;

        node.left = rec(preorder,preStart+1,preStart+numbersLeft,inorder,inStart,rootIndex-1,imap);
        node.right = rec(preorder,preStart+numbersLeft+1,preEnd,inorder,rootIndex+1,inEnd,imap);

        return node;
    }
}
