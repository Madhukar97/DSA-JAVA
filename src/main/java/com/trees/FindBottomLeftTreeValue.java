package com.trees;

import java.util.LinkedList;
import java.util.Queue;

//513. Find Bottom Left Tree Value
//https://leetcode.com/problems/find-bottom-left-tree-value/
public class FindBottomLeftTreeValue {
    public static void main(String[] args) {

    }
    public class TreeNode {
        int val;
        FindBottomLeftTreeValue.TreeNode left;
        FindBottomLeftTreeValue.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, FindBottomLeftTreeValue.TreeNode left, FindBottomLeftTreeValue.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int findBottomLeftValue(TreeNode root) {
        Integer ans = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode pre = null;

        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if(curr == null && !queue.isEmpty()) {
                pre = null;
                queue.add(null);
                continue;
            }
            if(curr == null && queue.isEmpty()) break;
            if(pre == null && curr.left != null){
                pre = curr.left;
                ans = curr.left.val;
            }
            if(curr.left != null) {
                queue.add(curr.left);
            }
            if(pre == null && curr.left == null & curr.right != null){
                ans = curr.right.val;
                pre = curr.right;
            }
            if(curr.right != null) {
                queue.add(curr.right);
            }

        }
        return ans;
    }
}
