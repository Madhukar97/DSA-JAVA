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
}
