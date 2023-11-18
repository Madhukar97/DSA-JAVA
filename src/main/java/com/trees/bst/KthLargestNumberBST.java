package com.trees.bst;

//K-th largest Number BST
//https://www.codingninjas.com/studio/problems/920438?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
public class KthLargestNumberBST {
    class TreeNode<T> {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    //DFS inorder traversal using recursion with time O(n) and space O(1)
    public static int KthLargestNumber(TreeNode<Integer> root, int k) {
        int[] count = new int[1];
        rec(root,count);
        TreeNode<Integer> ans = rec2(root, count[0]-k+1, new int[1]);
        if(ans != null) return ans.data;
        return -1;
    }

    public static TreeNode<Integer> rec2(TreeNode<Integer> node, int k, int[] count){
        if(node == null) return null;

        TreeNode<Integer> left = rec2(node.left, k, count);
        count[0]+=1;
        if(count[0] == k) return node;
        TreeNode<Integer> right = rec2(node.right, k, count);
        if(left == null) return right;
        return left;
    }

    public static void rec(TreeNode<Integer> node, int[] count){
        if(node == null) return;

        rec(node.left,count);
        count[0]+=1;
        rec(node.right,count);
    }

    //Revision 2

    class Node
    {
        int data;
        Node left;
        Node right;
        Node(int data)
        {
            this.data = data;
            left=null;
            right=null;
        }
    }
    class Solution
    {
        // return the Kth largest element in the given BST rooted at 'root'
        public int kthLargest(Node root,int K)
        {
            int[] ans = new int[2];
            ans[0] = K;
            rec(root,ans);
            return ans[1];
        }

        public void rec(Node node, int[] ans){
            if(node == null) return;

            rec(node.right,ans);
            ans[0]--;
            if(ans[0] == 0) ans[1] = node.data;
            rec(node.left,ans);
        }
    }
}
