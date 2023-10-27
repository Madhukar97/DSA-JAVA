package com.trees;

//Children Sum Property
//https://www.codingninjas.com/studio/problems/children-sum-property_8357239?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0
public class ChildrenSumProperty {
    class Node {
        public int data;
        public Node left;
        public Node right;

        Node()
        {
            this.data = 0;
            this.left = null;
            this.right = null;
        }

        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        Node(int data, Node left, Node right)
        {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static boolean isParentSum(Node root) {
        return rec(root);
    }

    public static boolean rec(Node node){
        if(node == null) return true;
        if(node.left == null && node.right == null) return true;

        int left=0;
        int right=0;
        if(node.left != null) left=node.left.data;
        if(node.right != null) right = node.right.data;

        if( node.data != left+right) return false;

        return rec(node.left) && rec(node.right);
    }
}
