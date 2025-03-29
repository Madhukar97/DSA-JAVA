package com.trees;

//Children Sum Property
//https://www.geeksforgeeks.org/problems/children-sum-parent/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=hildren-sum-parent
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

    //Revision 2
    public static boolean isParentSumR2(Node root) {
        return recR2(root);
    }

    public static boolean recR2(Node node){
        if(node == null) return true;
        else if(node.left != null && node.right != null && node.left.data+node.right.data != node.data) return false;
        else if(node.left == null && node.right != null && node.data != node.right.data) return false;
        else if(node.left != null && node.right == null && node.data != node.left.data) return false;

        return recR2(node.left) && recR2(node.right);
    }

    // Revision 5
    class Solution
    {
        //Function to check whether all nodes of a tree have the value
        //equal to the sum of their child nodes.
        public static int isSumProperty(Node root)
        {
            // add your code here
            return dfs(root);

        }

        public static int dfs(Node node){
            if(node == null || (node.left == null && node.right == null)) return 1;
            int left=0;
            int right=0;
            if(node.left != null) left=node.left.data;
            if(node.right != null) right = node.right.data;
            if(node.data != left+right) return 0;
            int lst = dfs(node.left);
            int rst = dfs(node.right);
            if(lst==0 || rst ==0) return 0;
            return 1;
        }
    }
}
