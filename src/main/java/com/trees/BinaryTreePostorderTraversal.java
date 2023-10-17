package com.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//145. Binary Tree Postorder Traversal
public class BinaryTreePostorderTraversal {
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recFunc(root, ans);
        return ans;
    }
    static void recFunc(TreeNode root, List<Integer> ans) {
        if(root == null) {
            return;
        }
        recFunc(root.left, ans);
        recFunc(root.right, ans);
        ans.add(root.val);
    }
    //Iterative solution using loops and stack without recursion
    /*
    This code iteratively traverses a binary tree in an postorder manner using a stack to keep track of the nodes to be processed.
     It ensures that we visit the right subtree, then the current node, and then the left subtree, just like the recursive approach,
     but without the use of recursion. This approach is more memory-efficient and avoids stack overflow errors for large trees.
     Finally reverse the ans and return
     */
    public List<Integer> postorderTraversalSol2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr= root;
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                ans.add(curr.val);
                stack.push(curr);
                curr=curr.right;
            }

            curr=stack.pop();
            curr=curr.left;
        }
        Collections.reverse(ans);
        return ans;
    }
    //Morris Preorder Traversal with time O(n) and space O(1)
    //Most Optimal
    public List<Integer> postorderTraversalMorris(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;

        while(curr != null ){
            if(curr.right == null){
                ans.add(curr.val);
                curr=curr.left;
            }else{
                TreeNode prev = curr.right;
                while(prev.left != null && prev.left != curr){
                    prev=prev.left;
                }
                if(prev.left == curr){
                    prev.left=null;
                    curr=curr.left;
                }else{
                    prev.left=curr;
                    ans.add(curr.val);
                    curr=curr.right;
                }
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
