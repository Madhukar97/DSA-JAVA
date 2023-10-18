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
        inOrderPreOrderPostOrder(root, inOrder, preOrder, postOrder);

        ans.add(inOrder);
        ans.add(preOrder);
        ans.add(postOrder);

        return ans;
    }

    public static void inOrderPreOrderPostOrder(TreeNode node, List<Integer> ans, List<Integer> ans2, List<Integer> ans3){
        if(node == null) return;

        ans2.add(node.data);
        inOrderPreOrderPostOrder(node.left, ans, ans2, ans3);
        ans.add(node.data);
        inOrderPreOrderPostOrder(node.right, ans, ans2, ans3);
        ans3.add(node.data);
    }
}
