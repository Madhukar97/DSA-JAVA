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
        ans.add(new ArrayList<>()); //InOrder
        ans.add(new ArrayList<>()); //PreOrder
        ans.add(new ArrayList<>()); //PostOrder

        inOrderPreOrderPostOrder(root, ans);

        return ans;
    }
    public static void inOrderPreOrderPostOrder(TreeNode node, List<List<Integer>> ans){
        if(node == null) return;

        ans.get(1).add(node.data);
        inOrderPreOrderPostOrder(node.left, ans);
        ans.get(0).add(node.data);
        inOrderPreOrderPostOrder(node.right, ans);
        ans.get(2).add(node.data);
    }
}
