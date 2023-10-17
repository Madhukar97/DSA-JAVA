package com.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    //Iterative solution using loops and stack without recursion
    /*
    This code iteratively traverses a binary tree in an preorder manner using a stack to keep track of the nodes to be processed.
     It ensures that we visit the left subtree, then the current node, and then the right subtree, just like the recursive approach,
     but without the use of recursion. This approach is more memory-efficient and avoids stack overflow errors for large trees.
     */
    public List<Integer> preorderTraversalSol2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr=root;
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                ans.add(curr.val);
                curr=curr.left;
            }

            curr = stack.pop();
            curr=curr.right;
        }
        return ans;
    }
}
