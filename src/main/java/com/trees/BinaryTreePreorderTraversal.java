package com.trees;

import java.util.ArrayList;
import java.util.List;

//144. Binary Tree Preorder Traversal
public class BinaryTreePreorderTraversal {
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recFunc(root, ans);
        return ans;
    }
    static void recFunc(TreeNode root, List<Integer> ans) {
        if(root == null) {
            return;
        }
        ans.add(root.val);
        recFunc(root.left, ans);
        recFunc(root.right, ans);
    }
}
