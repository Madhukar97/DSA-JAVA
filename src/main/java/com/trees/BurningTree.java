package com.trees;

import java.util.*;

//Burning Tree
//https://www.geeksforgeeks.org/problems/burning-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=burning-tree
public class BurningTree {
    class Solution {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

        public static int minTime(Node root, int target) {
            // code here
            Map<Node, Node> map = new HashMap<>();
            mapParents(root, map);
            Queue<Node> q = new LinkedList<>();
            int[] vis = new int[100002];
            Node targ = root;
            for(Node node : map.keySet()){
                if(node.data == target) targ = node;
            }
            q.add(targ);
            vis[targ.data]=1;
            int dist=0;
            while(!q.isEmpty()){
                int n=q.size();
                for(int i=0;i<n;i++){
                    Node curr = q.poll();
                    if(curr.left != null && vis[curr.left.data]==0){
                        vis[curr.left.data]=1;
                        q.add(curr.left);
                    }
                    if(curr.right != null && vis[curr.right.data]==0){
                        vis[curr.right.data]=1;
                        q.add(curr.right);
                    }
                    if(map.containsKey(curr) && vis[map.get(curr).data]==0){
                        vis[map.get(curr).data]=1;
                        q.add(map.get(curr));
                    }
                }
                dist++;
            }
            return dist-1;
        }

        public static void mapParents(Node root, Map<Node, Node> map){
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int n=q.size();
                for(int i=0;i<n;i++){
                    Node curr = q.poll();
                    if(curr.left != null) {
                        q.add(curr.left);
                        map.put(curr.left, curr);
                    }
                    if(curr.right != null){
                        q.add(curr.right);
                        map.put(curr.right, curr);
                    }
                }
            }
        }
    }
}
