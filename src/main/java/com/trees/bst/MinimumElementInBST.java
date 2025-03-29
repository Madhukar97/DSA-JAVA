package com.trees.bst;

//Minimum element in BST
//https://www.geeksforgeeks.org/problems/minimum-element-in-bst/1
public class MinimumElementInBST {

    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    class Solution {
        // Function to find the minimum element in the given BST.
        int minValue(Node root) {
            // code here
            if(root == null) return 0;
            if(root.left == null) return root.data;
            return minValue(root.left);
        }
    }
}
