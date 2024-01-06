package com.trees;

//Mirror Tree
//https://practice.geeksforgeeks.org/problems/mirror-tree/1
public class MirrorTree {
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

    void mirror(Node node) {
        rec(node);
    }

    public void rec(Node node){
        if(node == null) return;

        rec(node.left);
        rec(node.right);

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
