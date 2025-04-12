package com.trees;

import java.util.*;

//863. All Nodes Distance K in Binary Tree
//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
public class AllNodesDistanceKInBinaryTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    class Solution {
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            List<Integer> ans = new ArrayList<>();
            Map<TreeNode, TreeNode> map = new HashMap<>();
            mapParents(root, map);
            int[] vis = new int[map.size()+2];
            vis[target.val]=1;
            // System.out.println("map size : " + map.size());

            Queue<TreeNode> q = new LinkedList<>();
            q.add(target);
            int lvl=0;
            while(!q.isEmpty()){
                int n=q.size();
                // System.out.println("q size : " + q.size());
                if(lvl == k) {
                    while(!q.isEmpty()) {
                        // System.out.println("node : " + q.peek().val);
                        ans.add(q.poll().val);

                    }
                    return ans;
                }
                for(int i=0;i<n;i++){
                    TreeNode curr = q.poll();
                    // System.out.println("node : " + curr.val);
                    if(curr.left != null && vis[curr.left.val] == 0) {
                        q.add(curr.left);
                        vis[curr.left.val]=1;
                    }
                    if(curr.right != null && vis[curr.right.val] == 0) {
                        q.add(curr.right);
                        vis[curr.right.val]=1;
                    }
                    if(map.containsKey(curr) && vis[map.get(curr).val] == 0) {
                        q.add(map.get(curr));
                        vis[map.get(curr).val]=1;
                    }
                }
                lvl++;
            }
            return ans;
        }

        public void mapParents(TreeNode node, Map<TreeNode, TreeNode> map){
            Queue<TreeNode> q = new LinkedList<>();
            q.add(node);
            while(!q.isEmpty()){
                int n=q.size();
                for(int i=0;i<n;i++){
                    TreeNode curr = q.poll();
                    if(curr.left != null) {
                        map.put(curr.left, curr);
                        q.add(curr.left);
                    }
                    if(curr.right != null) {
                        map.put(curr.right, curr);
                        q.add(curr.right);
                    }
                }
            }
        }
    }
}
