package com.trees;

import java.util.*;

//662. Maximum Width of Binary Tree
//https://leetcode.com/problems/maximum-width-of-binary-tree/description/
public class MaximumWidthOfBinaryTree {
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
    //Level Order Traversal sol
    public int widthOfBinaryTree(TreeNode root) {
        Map<Integer, TreeNode> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,root));
        int ans=0;

        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().h;
            int first=0;
            int last=0;

            for(int i=0;i<size;i++){
                Tuple tuple = q.poll();
                TreeNode node = tuple.node;
                int curInd = tuple.h-min;
                if(i == 0) first = tuple.h;
                if(i == size-1) last = tuple.h;

                if(node.left != null) q.add(new Tuple(2*curInd+1,node.left));
                if(node.right != null) q.add(new Tuple(2*curInd+2, node.right));
            }

            ans = Math.max(ans, last - first +1);
        }
        return ans;
    }

    class Tuple{
        int h;
        TreeNode node;

        public Tuple(int h, TreeNode node){
            this.h=h;
            this.node=node;
        }
    }
}
