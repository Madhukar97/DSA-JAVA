package com.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Left View Of a Binary Tree
//https://www.codingninjas.com/studio/problems/920519?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
//https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
public class LeftViewOfABinaryTree {
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

    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        rec(root, ans, 0);
        return ans;
    }

    public static void rec(TreeNode<Integer> root, ArrayList<Integer> ans, int lvl){
        if(root == null) return;

        if(lvl == ans.size()) ans.add(root.data);
        rec(root.left,ans,lvl+1);
        rec(root.right,ans,lvl+1);
    }

    //Revision 2
    //Most optimal sol using BFS with Queue
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                Node curr = q.poll();

                if(i==0) ans.add(curr.data);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        return ans;
    }

    class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
}
