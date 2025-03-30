package com.trees.bst;

//Largest BST
//https://www.geeksforgeeks.org/problems/largest-bst/1
public class LargestBST {
    class Node  {
        int data;
        Node left, right;

        public Node(int d)
        {
         data = d;
         left = right = null;
        }
    }


    class Solution{

        // Return the size of the largest sub-tree which is also a BST
        static int largestBst(Node root){
            // Write your code here
            return dfs(root)[2];
        }

        static int[] dfs(Node node){
            if(node == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 1};
            if(node.left == null && node.right == null) return new int[]{node.data,node.data,1, 1};
            int[] left = dfs(node.left);
            int[] right = dfs(node.right);
            if(left[1] >= node.data || right[0] <= node.data) return new int[]{Math.min(node.data, Math.min(left[0], right[0])), Math.max(node.data, Math.max(left[1],right[1])), Math.max(left[2],right[2]), 0};
            int size = 0;
            if(left[3]==1 && right[3]==1) size = 1+left[2]+right[2];
            else if(left[3]==0 || right[3]==0) size = Math.max(left[2], right[2]);
            return new int[]{Math.min(node.data, Math.min(left[0], right[0])), Math.max(node.data, Math.max(left[1],right[1])), size, left[3]==1 && right[3]==1 ? 1 : 0};
        }

    }
}
