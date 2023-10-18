package com.trees;

import java.util.*;

//199. Binary Tree Right Side View
//https://leetcode.com/problems/binary-tree-right-side-view/
public class BinaryTreeRightSideView {
    public static void main(String[] args) {

    }
    public class TreeNode {
        int val;
        BinaryTreeRightSideView.TreeNode left;
        BinaryTreeRightSideView.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, BinaryTreeRightSideView.TreeNode left, BinaryTreeRightSideView.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        recFunc(root, map, 0);
        for(int key : map.keySet()) {
            list.add(map.get(key));
        }
        return list;
    }

    //level order traversal using recursion
    static void recFunc(TreeNode root, HashMap<Integer, Integer> map, int level) {
        if(root == null) return;

        //if(map.get(level) == null) {
        map.put(level, root.val);
        //}

        if(root.left != null) recFunc(root.left, map, level+1);
        if(root.right != null) recFunc(root.right, map, level+1);
    }

    //Optimal sol using arraylist
    public List<Integer> rightSideViewSol2(TreeNode root) {
        List<Integer> ans =  new ArrayList<>();
        rec(root,ans,0);
        return ans;
    }

    public void rec(TreeNode root, List<Integer> ans, int lvl){
        if(root == null) return;

        if(lvl == ans.size()) ans.add(root.val);
        rec(root.right,ans,lvl+1);
        rec(root.left,ans,lvl+1);
    }
}
