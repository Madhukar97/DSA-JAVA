package com.trees;

//222. Count Complete Tree Nodes
//https://leetcode.com/problems/count-complete-tree-nodes/description/
public class CountCompleteTreeNodes {
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
        public int countNodes(TreeNode root) {
            if(root == null) return 0;
            int leftHt = findLeftHt(root);
            int rightHt = findRightHt(root);
            if(leftHt == rightHt) return (int)Math.pow(2, leftHt) - 1;
            return 1 + countNodes(root.left) + countNodes(root.right);
        }

        public int findLeftHt(TreeNode node){
            if(node == null) return 0;
            int ht=0;
            while(node != null){
                node=node.left;
                ht++;
            }
            return ht;
        }
        public int findRightHt(TreeNode node){
            if(node == null) return 0;
            int ht=0;
            while(node != null){
                node=node.right;
                ht++;
            }
            return ht;
        }
    }
}
