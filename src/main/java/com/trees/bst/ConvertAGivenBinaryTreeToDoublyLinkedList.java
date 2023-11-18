package com.trees.bst;

//Convert A Given Binary Tree To Doubly Linked List
//https://www.codingninjas.com/studio/problems/893106?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
public class ConvertAGivenBinaryTreeToDoublyLinkedList {
    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }
    //use DFS (inorder) and prev Node and recursively traverse left and update the node.left=prev, prev.right=node and prev=node and traverse right
    static BinaryTreeNode<Integer> prev=null;
    public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
        prev=null;
        rec(root);
        BinaryTreeNode<Integer> temp = root;
        while(temp.left != null) temp=temp.left;
        return temp;
    }

    public static void rec(BinaryTreeNode<Integer> node){
        if(node == null) return;

        rec(node.left);
        node.left = prev;
        if(prev != null) prev.right=node;
        prev=node;
        rec(node.right);
    }

    //Revision 2 without global variable
    public class Solution {

        public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
            BinaryTreeNode[] prev= new BinaryTreeNode[1];
            rec(root, prev);
            return prev[0];
        }

        public static void rec(BinaryTreeNode<Integer> node, BinaryTreeNode[] prev){
            if(node == null) return;

            rec(node.right,prev);
            node.right = prev[0];
            if(prev[0] != null) prev[0].left = node;
            prev[0] = node;

            rec(node.left,prev);
        }


    }
}
