package com.trees;

//124. Binary Tree Maximum Path Sum
//https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
public class BinaryTreeMaximumPathSum {
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
    //Sol using inorder traversal
    //beats 100%
    public int maxPathSum(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        rec(root,ans);
        return ans[0];
    }

    public int rec(TreeNode node, int[] ans){
        if(node == null) return 0;

        int left = rec(node.left, ans);
        int right = rec(node.right, ans);

        int case1 = node.val+left;      //take left path
        int case2 = node.val+right;     //take right path
        int case3 = node.val+left+right;    //take the entire subtree with curr node
        int case4 = node.val;           //just take the curr node

        ans[0] = Math.max(ans[0],Math.max(case4,Math.max(case3, Math.max(case2, case1))));
        return Math.max(case4,Math.max(case1,case2));
    }

    //Revision 2
    //Most optimal sol beats 100%
    class Solution {
        public int maxPathSum(TreeNode root) {
            int[] ans = {-1000};
            rec(root, ans);
            return ans[0];
        }

        public int rec(TreeNode node, int[] ans){
            if(node == null) return -1000;

            int left = rec(node.left, ans);
            int right = rec(node.right, ans);
            int max = Math.max(left, right);
            int c1 = left+right+node.val;
            int c2 = node.val;
            int c3 = max+node.val;
            ans[0] = Math.max(ans[0], Math.max(c1, Math.max(c2,c3)));
            return Math.max(c2,c3);
        }
    }

    // Revision 5
    class Solution3 {
        public int maxPathSum(TreeNode root) {
            int[] ans = {Integer.MIN_VALUE};
            checkSum(root, ans);
            return ans[0];
        }

        private int checkSum(TreeNode node, int[] ans){
            if(node == null) return 0;
            int left = checkSum(node.left, ans);
            int right = checkSum(node.right, ans);
            ans[0] = Math.max(node.val, Math.max(ans[0], Math.max(node.val+left, Math.max(node.val+right, node.val+left+right))));
            return Math.max(node.val, node.val + Math.max(left, right));
        }
    }
}
