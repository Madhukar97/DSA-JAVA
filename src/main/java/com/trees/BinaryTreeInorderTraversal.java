package com.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//94. Binary Tree Inorder Traversal
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {

    }
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

    //LNR
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recFunc(root, ans);
        return ans;
    }
    static void recFunc(TreeNode root, List<Integer> ans) {
        if(root == null) {
            return;
        }
        recFunc(root.left, ans);
        ans.add(root.val);
        recFunc(root.right, ans);
    }
}
