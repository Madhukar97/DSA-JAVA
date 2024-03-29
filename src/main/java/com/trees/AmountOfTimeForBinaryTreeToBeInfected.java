package com.trees;

import java.util.*;

//2385. Amount of Time for Binary Tree to Be Infected
//https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/
public class AmountOfTimeForBinaryTreeToBeInfected {
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
    //
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        //convert tree into graph
        findAdj(root,adj);

        int[] vis = new int[100001];
        vis[start] = 1;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int ans=0;
        while(!q.isEmpty()){
            int n=q.size();

            for(int i=0;i<n;i++){
                int node = q.poll();
                List<Integer> neighbours = adj.get(node);
                if(neighbours == null) continue;
                // System.out.println("Node : " + node);
                // System.out.println(", adj : " + neighbours.toString());
                for(int neighbour : neighbours){
                    if(vis[neighbour] == 0){
                        q.add(neighbour);
                        vis[neighbour]=1;
                    }
                }
            }
            ans++;
        }
        return ans-1;
    }

    public void findAdj(TreeNode node, Map<Integer, List<Integer>> adj){
        if(node == null) return;

        if(node.left != null){
            adj.putIfAbsent(node.val, new ArrayList<>());
            adj.get(node.val).add(node.left.val);
            adj.putIfAbsent(node.left.val, new ArrayList<>());
            adj.get(node.left.val).add(node.val);
        }
        if(node.right != null){
            adj.putIfAbsent(node.val, new ArrayList<>());
            adj.get(node.val).add(node.right.val);
            adj.putIfAbsent(node.right.val, new ArrayList<>());
            adj.get(node.right.val).add(node.val);
        }
        findAdj(node.left,adj);
        findAdj(node.right,adj);
    }
}
