package com.trees.bst;

import java.util.*;

//Predecessor SuccessorInBST
//https://www.codingninjas.com/studio/problems/893049?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTabValue=PROBLEM
public class PredecessorAndSuccessorInBST {
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

    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        List<Integer> ans = new ArrayList<>();
        ans.add(Integer.MIN_VALUE);
        ans.add(Integer.MAX_VALUE);
        rec(root,key,ans);
        if(ans.get(0) == Integer.MIN_VALUE) ans.set(0,-1);
        if(ans.get(1) == Integer.MAX_VALUE) ans.set(1,-1);
        return ans;
    }

    public static void rec(TreeNode node, int key, List<Integer> ans){
        if(node == null) return;
        if(node.data == key && node.left != null && node.right != null){
            ans.set(0,node.left.data);
            ans.set(1,node.right.data);
            return;
        }

        if(node.data > ans.get(0) && node.data < key) ans.set(0, node.data);
        if(node.data < ans.get(1) && node.data > key) ans.set(1, node.data);

        if(key <= node.data) rec(node.left,key,ans);
        else rec(node.right,key,ans);
    }
}
