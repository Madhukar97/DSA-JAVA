package com.trees.bst;

//1008. Construct Binary Search Tree from Preorder Traversal
//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
public class ConstructBinarySearchTreeFromPreorderTraversal {
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
    //sol using dfs and recursion
    public TreeNode bstFromPreorder(int[] preorder) {
        return rec(preorder, 0, preorder.length-1);
    }

    public TreeNode rec(int[] preorder, int start, int end){
        if(start > end) return null;
        if(start == end) return new TreeNode(preorder[start]);

        int mid = start;
        for(int i=start;i<=end && preorder[i] <= preorder[start];i++){
            mid=i;
        }
        TreeNode node = new TreeNode(preorder[start]);

        node.left = rec(preorder, start+1,mid);
        node.right = rec(preorder, mid+1, end);
        return node;
    }
}
