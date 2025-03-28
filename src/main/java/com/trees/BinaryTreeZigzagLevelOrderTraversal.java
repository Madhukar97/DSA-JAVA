package com.trees;

import java.util.*;

//103. Binary Tree Zigzag Level Order Traversal
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {

    }
    public class TreeNode {
        int val;
        BinaryTreeZigzagLevelOrderTraversal.TreeNode left;
        BinaryTreeZigzagLevelOrderTraversal.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, BinaryTreeZigzagLevelOrderTraversal.TreeNode left, BinaryTreeZigzagLevelOrderTraversal.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean flag = false;

        List<List<Integer>> outer  = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if(node != null){
                inner.add(node.val);
            }

            if(node == null) {
                if(queue.isEmpty()){
                    break;
                }
                else {
                    queue.add(null);
                    outer.add(inner);
                    inner = new ArrayList<>();
                    continue;
                }
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        outer.add(inner);
        for(int i=1; i<outer.size(); i=i+2) {
            Collections.reverse(outer.get(i));
        }
        return outer;
    }

    //Sol2 using less code with time O(n) and space O(n)
    public List<List<Integer>> zigzagLevelOrderSol2(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = true;

        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size =q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            if(flag == false){
                Collections.reverse(list);
            }
            ans.add(list);
            flag=!flag;
        }
        return ans;
    }

    //Revision 2
    public List<List<Integer>> zigzagLevelOrderR2(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int lvl = 0;
        while(!q.isEmpty()){
            int n = q.size();

            List<Integer> list = new ArrayList<>();
            int[] nodes = new int[n];
            for(int i=0;i<n;i++){
                TreeNode node = q.poll();
                if(lvl%2 == 1) nodes[n-i-1] = node.val;
                else nodes[i] = node.val;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            for(int i : nodes) list.add(i);
            ans.add(list);
            lvl++;
        }
        return ans;
    }

    // Revision 5
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if(root == null) return ans;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            List<Integer> lvl = new ArrayList<>();
            int ht = 0;

            while(!q.isEmpty()){
                lvl = new ArrayList<>();
                int size = q.size();
                for(int i=0;i<size;i++){
                    TreeNode curr = q.poll();
                    if(curr.left != null) q.add(curr.left);
                    if(curr.right != null) q.add(curr.right);
                    lvl.add(curr.val);
                }
                if( ht % 2 != 0){
                    List<Integer> reverse = new ArrayList<>();
                    for(int i=lvl.size()-1;i>=0;i--) reverse.add(lvl.get(i));
                    lvl = reverse;
                }
                ans.add(lvl);
                ht++;
            }
            return ans;
        }
    }
}
