package com.trees;

import java.util.*;

//Boundary Traversal of Binary Tree
//https://www.codingninjas.com/studio/problems/boundary-traversal-of-binary-tree_790725?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0
public class BoundaryTraversalOfBinaryTree {
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> traverseBoundary(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        if(!isLeaf(root)) ans.add(root.data);

        leftBoundary(root, ans);
        leaves(root,ans);
        rightBoundary(root,ans);
        return ans;
    }

    public static boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }

    public static void leftBoundary(TreeNode node, List<Integer> ans){
        node = node.left;
        while(node != null){
            if(!isLeaf(node)) ans.add(node.data);
            if(node.left != null) node=node.left;
            else node=node.right;
        }
    }

    public static void leaves(TreeNode node, List<Integer> ans){
        if(node == null) return;
        if(isLeaf(node)) {
            ans.add(node.data);
            return;
        }
        leaves(node.left,ans);
        leaves(node.right,ans);
    }

    public static void rightBoundary(TreeNode node, List<Integer> ans){
        node = node.right;
        List<Integer> list = new ArrayList<>();
        while(node != null){
            if(!isLeaf(node)) list.add(node.data);
            if(node.right != null) node=node.right;
            else node=node.left;
        }
        for(int i=list.size()-1;i>=0;i--) ans.add(list.get(i));
    }
}
