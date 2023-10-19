package com.trees;

import java.util.*;

//All Root to Leaf Paths In Binary Tree.
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
}
