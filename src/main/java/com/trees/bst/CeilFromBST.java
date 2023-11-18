package com.trees.bst;

//Ceil from BST
//https://www.codingninjas.com/studio/problems/ceil-from-bst_920464?source=youtube&campaign=Striver_Tree_Videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=Striver_Tree_Videos&leftPanelTab=0
public class CeilFromBST {
    class TreeNode<T>
    {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }
    //do binary search using recursion/iteration : if(x < node.data) node.data can be your potential ans and go left,
    // if(x > node.data) node.data cannot be your ans and go node.right
    public static int findCeil(TreeNode<Integer> node, int x) {
        int ceil = -1;
        while(node != null){
            if(node.data == x) return node.data;

            if(x < node.data){
                ceil = node.data;
                node=node.left;
            }else{
                node=node.right;
            }
        }
        return ceil;
    }

    //Revision 2
    public class Solution {

        public  static int findCeil(TreeNode<Integer> node, int x) {
            int[] ans = new int[1];
            ans[0]=Integer.MAX_VALUE;
            rec(node, x, ans);
            if(ans[0] == Integer.MAX_VALUE) return -1;
            return ans[0];
        }

        public static void rec(TreeNode<Integer> node, int x, int[] ans){
            if(node == null) return;
            if(node.data == x){
                ans[0] = node.data;
                return;
            }

            if(node.data < ans[0] && node.data > x) ans[0] = node.data;

            if(x < node.data) rec(node.left,x, ans);
            else rec(node.right,x, ans);
        }
    }
}
