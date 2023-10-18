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
        inOrderPreOrder(root, inOrder, preOrder);
        post(root, postOrder);
        Collections.reverse(postOrder);

        ans.add(inOrder);
        ans.add(preOrder);
        ans.add(postOrder);

        return ans;
    }

    public static void inOrderPreOrder(TreeNode node, List<Integer> ans, List<Integer> ans2){
        if(node == null) return;

        ans2.add(node.data);
        inOrderPreOrder(node.left, ans, ans2);
        ans.add(node.data);
        inOrderPreOrder(node.right, ans, ans2);
    }

    public static void post(TreeNode node, List<Integer> ans){
        if(node == null) return;

        ans.add(node.data);
        post(node.right, ans);
        post(node.left, ans);
    }
}
