package com.trees.bst;

import com.trees.BinaryTreeLevelOrderTraversal;

//1373. Maximum Sum BST in Binary Tree
//https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/description/
public class MaximumSumBSTInBinaryTree {
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
    //sol using NodeValue class
    //for a valid BST the largest of left-subtree should be less than root and root should be less than the smallest of right-subtree
    //leftSubTree.largest < root < rightSubTree.smallest
    int maxi=0;
    public int maxSumBST(TreeNode root) {
        rec(root);
        return maxi;
    }

    public NodeValue rec(TreeNode node){
        if(node == null) return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0,0);

        NodeValue left = rec(node.left);
        NodeValue right = rec(node.right);

        if(left.maxNode < node.val && node.val < right.minNode){
            maxi = Math.max(maxi, left.maxSum+right.maxSum+node.val);
            return new NodeValue(Math.min(node.val, left.minNode), Math.max(node.val, right.maxNode), left.maxSize+right.maxSize+1, left.maxSum+right.maxSum+node.val);

        }
        return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.maxSize,right.maxSize),Math.max(0,Math.max(left.maxSum,right.maxSum)));
    }

    class NodeValue{
        int minNode, maxNode, maxSize, maxSum;

        public NodeValue(int minNode, int maxNode, int maxSize, int maxSum){
            this.minNode=minNode;
            this.maxNode=maxNode;
            this.maxSize=maxSize;
            this.maxSum=maxSum;
        }
    }

    //Revision 1
    class Solution {
        public int maxSumBST(TreeNode root) {
            int[] ans = new int[1];
            rec(root,ans);
            return ans[0];
        }

        public NodeValue rec(TreeNode node, int[] ans){
            if(node == null) return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

            NodeValue left = rec(node.left, ans);
            NodeValue right = rec(node.right, ans);

            if(left.maxNode < node.val && node.val < right.minNode){
                ans[0] = Math.max(ans[0], left.maxSum+right.maxSum+node.val);
                return new NodeValue(Math.min(left.minNode, node.val), Math.max(right.maxNode, node.val), left.maxSum+right.maxSum+node.val);
            }
            return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSum, right.maxSum));
        }

        public class NodeValue{
            int minNode, maxNode, maxSum;

            public NodeValue(int min, int max, int sum){
                minNode=min;
                maxNode=max;
                maxSum=sum;
            }
        }
    }

    //Revision 2
    class Solution2 {
        public int maxSumBST(TreeNode root) {
            int[] ans = new int[1];
            int[] curr = rec(root, ans);
            return ans[0];
        }

        public int[] rec(TreeNode node, int[] ans){
            if(node == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

            int[] left = rec(node.left,ans);
            int[] right = rec(node.right,ans);
            int[] curr = new int[3];

            if(left[1] < node.val && node.val < right[0]){
                ans[0] = Math.max(node.val+left[2]+right[2], ans[0]);
                curr[2] = node.val+left[2]+right[2];
                curr[0] = Math.min(left[0], node.val);
                curr[1] = Math.max(right[1], node.val);
            }else {
                curr[2] = Math.max(left[2], right[2]);
                curr[0] = Integer.MIN_VALUE;
                curr[1] = Integer.MAX_VALUE;
            }
            // System.out.println("Node : "+node.val+ " left : " + Arrays.toString(left) + " , right : " + Arrays.toString(right));
            return curr;
        }
    }
}
