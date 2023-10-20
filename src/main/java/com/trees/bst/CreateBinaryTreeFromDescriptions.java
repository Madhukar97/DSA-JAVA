package com.trees.bst;

import com.trees.BinaryTreeLevelOrderTraversal;

import java.util.*;

//2196. Create Binary Tree From Descriptions
//https://leetcode.com/problems/create-binary-tree-from-descriptions/description/
public class CreateBinaryTreeFromDescriptions {
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
    //sol using HashMap and HashSet
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,TreeNode> map = new HashMap<>();
        Set<Integer> childs = new HashSet<>();

        for(int[] des : descriptions){
            TreeNode parent = map.getOrDefault(des[0], new TreeNode(des[0]));
            TreeNode child = map.getOrDefault(des[1], new TreeNode(des[1]));
            if(des[2] == 1) parent.left = child;
            else parent.right = child;
            map.put(parent.val, parent);
            map.put(child.val, child);
            childs.add(child.val);
        }
        int root=0;
        for(int[] des : descriptions){
            if(!childs.contains(des[0])){
                root = des[0];
                break;
            }
        }
        return map.get(root);
    }
    //sol using HashMap and HashMap
    public TreeNode createBinaryTreeSol2(int[][] descriptions) {
        Map<Integer,TreeNode> map = new HashMap<>();
        Map<Integer,TreeNode> childs = new HashMap<>();

        for(int[] des : descriptions){
            TreeNode parent = map.getOrDefault(des[0], new TreeNode(des[0]));
            TreeNode child = map.getOrDefault(des[1], new TreeNode(des[1]));
            if(des[2] == 1) parent.left = child;
            else parent.right = child;
            map.put(parent.val, parent);
            map.put(child.val, child);
            childs.put(child.val, child);
        }
        int root=0;
        for(int[] des : descriptions){
            if(!childs.containsKey(des[0])){
                root = des[0];
                break;
            }
        }
        return map.get(root);
    }
}
