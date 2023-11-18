package com.trees;

//101. Symmetric Tree
//https://leetcode.com/problems/symmetric-tree/description/
public class SymmetricTree {
    class TreeNode {
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
    //do inorder traversal with two nodes : root-left-right and root-right-left and compare and return ans
    public boolean isSymmetric(TreeNode root) {
        return rec(root,root);
    }

    public boolean rec(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 != null || node1 != null && node2==null) {
            return false;
        }else if(node1 == null && node2 == null) return true;

        // System.out.println("n1 : "+node1.val+", n2 :"+node2.val);
        boolean left = rec(node1.left, node2.right);
        if(node1.val != node2.val) return false;
        boolean right = rec(node1.right, node2.left);
        return left && right;
    }

    //Revision 2
    public boolean isSymmetricR2(TreeNode root) {
        return recR2(root,root);
    }

    public boolean recR2(TreeNode n1, TreeNode n2){
        if(n1 == null && n2 == null) return true;
        if((n1 == null && n2 != null) || (n1 != null && n2==null) || n1.val != n2.val) return false;

        return recR2(n1.left,n2.right) && rec(n1.right,n2.left);
    }
}
