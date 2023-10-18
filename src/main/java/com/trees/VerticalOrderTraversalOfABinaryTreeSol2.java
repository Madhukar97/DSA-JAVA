package com.trees;

import java.util.*;

//987. Vertical Order Traversal of a Binary Tree
//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
public class VerticalOrderTraversalOfABinaryTreeSol2 {
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
    //Sol using dfs and recursion
    //use outer map to store horizontal.dist , TreeMap to store levels in ascending order, PriorityQueue to store values of overlapping h,v in ascending order
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        rec(root,map,0,0);

        for(int key : map.keySet()){
            TreeMap<Integer, PriorityQueue<Integer>> tmap = map.get(key);
            List<Integer> subList = new ArrayList<>();
            for(int key2 : tmap.keySet()){
                PriorityQueue<Integer> pq = tmap.get(key2);
                while(!pq.isEmpty()) subList.add(pq.poll());
            }
            ans.add(subList);
        }
        return ans;
    }

    public void rec(TreeNode root, Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map, int h, int v){
        if(root == null) return;

        map.putIfAbsent(h, new TreeMap<>());
        map.get(h).putIfAbsent(v, new PriorityQueue<>());
        map.get(h).get(v).add(root.val);

        rec(root.left, map, h-1,v+1);
        rec(root.right, map, h+1,v+1);
    }

    //Sol 2 using queue
    public List<List<Integer>> verticalTraversalSol2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,0,root));

        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int h=tuple.h;
            int v=tuple.v;

            map.putIfAbsent(h, new TreeMap<>());
            map.get(h).putIfAbsent(v, new PriorityQueue<>());
            map.get(h).get(v).add(node.val);

            if(node.left != null) q.add(new Tuple(h-1,v+1,node.left));
            if(node.right != null) q.add(new Tuple(h+1,v+1,node.right));
        }

        for(int key : map.keySet()){
            TreeMap<Integer, PriorityQueue<Integer>> tmap = map.get(key);
            List<Integer> subList = new ArrayList<>();
            for(int key2 : tmap.keySet()){
                PriorityQueue<Integer> pq = tmap.get(key2);
                while(!pq.isEmpty()) subList.add(pq.poll());
            }
            ans.add(subList);
        }
        return ans;
    }

    class Tuple{
        int h;
        int v;
        TreeNode node;

        public Tuple(int h, int v, TreeNode node){
            this.h=h;
            this.v=v;
            this.node=node;
        }
    }
}
