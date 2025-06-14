package com.trees;

import java.util.*;

//All Root to Leaf Paths In Binary Tree.
//https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=root-to-leaf-paths
//https://www.codingninjas.com/studio/problems/all-root-to-leaf-paths-in-binary-tree._983599?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=1
public class AllRootToLeafPathsInBinaryTree {
    class BinaryTreeNode {
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static List<String> allRootToLeaf(BinaryTreeNode root) {
        List<String> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        rec(root, list, ans);
        return ans;
    }

    public static void rec(BinaryTreeNode node, List<Integer> list, List<String> ans){
        if(node == null) return;
        if(node.left == null && node.right == null){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<list.size();i++){
                sb.append(list.get(i)).append(" ");
            }
            sb.append(node.data);
            ans.add(sb.toString());
            return;
        }

        list.add(node.data);
        rec(node.left, list, ans);
        rec(node.right, list, ans);
        list.remove(list.size()-1);
    }

    //Most Optimal sol with TC = O(n) and SC = O(1)
    //Revision 2
    public static List<String> allRootToLeafR2(BinaryTreeNode root) {
        List<String> ans = new ArrayList<>();
        rec(root,ans,"");
        return ans;
    }

    public static void rec(BinaryTreeNode node, List<String> ans, String path){
        if(node == null) return;
        if(node.left == null && node.right == null){
            ans.add(path+node.data);
            return;
        }

        rec(node.left, ans, path+node.data+" ");
        rec(node.right,ans, path+node.data+" ");
    }

    // Revision 5
    class Solution3 {
        public static ArrayList<ArrayList<Integer>> Paths(BinaryTreeNode root) {
            // code here
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ArrayList<Integer> path = new ArrayList<>();
            inorder(root, path, ans);
            return ans;
        }

        public static void inorder(BinaryTreeNode node, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ans){
            if(node == null) return;
            path.add(node.data);
            if(node.left == null && node.right == null){
                ans.add(new ArrayList<>(path));
                path.remove(path.size()-1);
                return;
            }
            inorder(node.left, path, ans);
            inorder(node.right, path, ans);
            path.remove(path.size()-1);
        }
    }
}
