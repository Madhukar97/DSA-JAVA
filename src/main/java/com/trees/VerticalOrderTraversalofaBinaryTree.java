package com.trees;

import java.util.*;

//987. Vertical Order Traversal of a Binary Tree
//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
public class VerticalOrderTraversalofaBinaryTree {
    public static void main(String[] args) {

    }
    public class TreeNode {
        int val;
        VerticalOrderTraversalofaBinaryTree.TreeNode left;
        VerticalOrderTraversalofaBinaryTree.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, VerticalOrderTraversalofaBinaryTree.TreeNode left, VerticalOrderTraversalofaBinaryTree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //Not working solution, since overlapping nodes has to be sorted by value
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        List<List<Integer>> outer = new ArrayList<>();

        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();

        queue.add(new Pair(0, root));
        while(!queue.isEmpty()) {
            Pair curr = queue.poll();

            if(map.containsKey(curr.hd)){
                map.get(curr.hd).add(curr.node.val);
            }else{
                ArrayList<Integer> inner = new ArrayList<>();
                inner.add(curr.node.val);
                map.put(curr.hd, inner);
            }

            if(curr.node.left != null) {
                queue.add(new Pair(curr.hd-1, curr.node.left));
            }
            if(curr.node.right != null) {
                queue.add(new Pair(curr.hd+1, curr.node.right));
            }
        }

//        for(List<Integer> inner : map.values()) {
//            inner.sort(Integer::compareTo);
//        }


        outer.addAll(map.values());

        return outer;
    }

    class Pair{
        int hd;
        TreeNode node;

        Pair(int hd, TreeNode node){
            this.hd = hd;
            this.node = node;
        }
    }
}
