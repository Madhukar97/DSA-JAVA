package com.trees;

//Good Nodes
//https://www.codingninjas.com/studio/problems/good-nodes_3169337?ieSlug=google-interview-experience-application-engineer-mar-2022-exp-0-2-years&ieCompany=google&leftPanelTabValue=PROBLEM
public class GoodNodes {
    class TreeNode<T> {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = right = null;
        }

    };

    public class Solution {
        public static int goodNodes(TreeNode<Integer> root)  {
            int[] ans = new int[1];
            rec(root, ans, -1);
            return ans[0];
        }

        public static void rec(TreeNode<Integer> node, int[] ans, int max){
            if(node == null) return;

            if(max <= node.data) ans[0]++;

            rec(node.left, ans, Math.max(max, node.data));
            rec(node.right, ans, Math.max(max, node.data));
        }
    }
}
