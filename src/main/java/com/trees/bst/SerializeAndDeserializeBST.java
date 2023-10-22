package com.trees.bst;

import java.util.*;

//449. Serialize and Deserialize BST
//https://leetcode.com/problems/serialize-and-deserialize-bst/description/
public class SerializeAndDeserializeBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //Sol using level order traversal
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node != null) sb.append(node.val).append(" ");
            else{
                sb.append("n ");
                continue;
            }
            q.add(node.left);
            q.add(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() <= 1) return null;
        String[] arr = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        for(int i=1;i<arr.length;i++){
            if(!arr[i].equals("n")){
                TreeNode node = q.peek();
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                node.left=left;
                q.add(left);
            }
            if(!arr[++i].equals("n")){
                TreeNode node = q.peek();
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                node.right=right;
                q.add(right);
            }
            q.poll();
        }
        return root;
    }
}
