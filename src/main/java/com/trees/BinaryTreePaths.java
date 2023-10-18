package com.trees;

import java.util.*;

//257. Binary Tree Paths
//https://leetcode.com/problems/binary-tree-paths/description/
public class BinaryTreePaths {

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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        rec(root, list, ans);
        return ans;
    }

    public void rec(TreeNode node, List<Integer> list, List<String> ans){
        if(node == null) return;
        if(node.left == null && node.right == null){
            String str = "";
            for(int i=0;i<list.size();i++){
                str+=list.get(i)+"->";
            }
            str+=node.val;
            ans.add(str);
        }

        list.add(node.val);
        rec(node.left, list, ans);
        rec(node.right, list, ans);
        list.remove(list.size()-1);
    }
    //Sol using StringBuilder beats 99.94%
    public List<String> binaryTreePathsSol2(TreeNode root) {
        List<String> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        rec2(root, list, ans);
        return ans;
    }

    public void rec2(TreeNode node, List<Integer> list, List<String> ans){
        if(node == null) return;
        if(node.left == null && node.right == null){
            StringBuilder str = new StringBuilder();
            for(int i=0;i<list.size();i++){
                str.append(list.get(i)).append("->");
            }
            str.append(node.val);
            ans.add(str.toString());
        }

        list.add(node.val);
        rec2(node.left, list, ans);
        rec2(node.right, list, ans);
        list.remove(list.size()-1);
    }
}
