package com.trees;

import java.util.*;

//Tree Traversals
//https://www.codingninjas.com/studio/problems/981269?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
public class TreeTraversals {
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }
        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        inOrder(root, inOrder);
        pre(root, preOrder);
        post(root, postOrder);
        Collections.reverse(postOrder);

        ans.add(inOrder);
        ans.add(preOrder);
        ans.add(postOrder);

        return ans;
    }

    public static void inOrder(TreeNode node, List<Integer> ans){
        if(node == null) return;

        inOrder(node.left, ans);
        ans.add(node.data);
        inOrder(node.right, ans);
    }

    public static void pre(TreeNode node, List<Integer> ans){
        if(node == null) return;

        ans.add(node.data);
        pre(node.left, ans);
        pre(node.right, ans);
    }

    public static void post(TreeNode node, List<Integer> ans){
        if(node == null) return;

        ans.add(node.data);
        post(node.right, ans);
        post(node.left, ans);
    }
}
