package com.trees.bst;

//98. Validate Binary Search Tree
//https://leetcode.com/problems/validate-binary-search-tree/description/
public class ValidateBinarySearchTree {
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
    class Solution {
        public boolean isValidBST(TreeNode root) {
            boolean[] ans = {true};
            dfs(root, ans);
            return ans[0];
        }

        private long[] dfs(TreeNode node, boolean[] ans){
            if(node == null) return new long[]{Long.MAX_VALUE, Long.MIN_VALUE};
            if(node.left == null && node.right == null) return new long[]{node.val, node.val};
            long[] left = dfs(node.left, ans);
            long[] right = dfs(node.right, ans);
            if(left[1] >= node.val || right[0] <= node.val) ans[0] = false;
            return new long[]{Math.min(right[0], Math.min(left[0], node.val)), Math.max(right[1], Math.max(left[1], node.val))};
        }
    }
}
