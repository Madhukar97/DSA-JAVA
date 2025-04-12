package com.trees.bst;

//450. Delete Node in a BST
//https://leetcode.com/problems/delete-node-in-a-bst/description/
public class DeleteNodeInABST {
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
        public TreeNode deleteNode(TreeNode root, int key) {
            if(root == null) return root;
            if(root.val == key ) return helper(root);
            TreeNode dummy = root;
            while(root != null){
                if(root.val > key){
                    if(root.left != null && root.left.val == key){
                        root.left = helper(root.left);
                        break;
                    }else root=root.left;
                }else{
                    if(root.right != null && root.right.val == key){
                        root.right = helper(root.right);
                        break;
                    }else root = root.right;
                }
            }
            return dummy;
        }

        private TreeNode helper(TreeNode root){
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            TreeNode rst = root.right;
            TreeNode leftMax = findLeftMax(root.left);
            leftMax.right = rst;
            return root.left;
        }

        private TreeNode findLeftMax(TreeNode root){
            while(root.right != null){
                root = root.right;
            }
            return root;
        }
    }
}
