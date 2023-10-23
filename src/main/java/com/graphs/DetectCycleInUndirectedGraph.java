package com.graphs;

import java.util.*;

//Detect cycle in an undirected graph
//https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
//https://codingninjas.com/studio/problems/1062670?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
public class DetectCycleInUndirectedGraph {
    public static void main(String[] args) {

    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];

        for(int i=0; i<V; i++) {
            if(!vis[i]){
                if(dfs(i, adj, vis, -1)) return true;
            }
        }
        return false;
    }

    boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int parent) {
        vis[v] = true;

        for(Integer neighbour : adj.get(v)) {
            if(!vis[neighbour]) {
                if(dfs(neighbour, adj, vis, v)) return true;
            }
            else if(neighbour != parent) {
                return true;
            }
        }
        return false;
    }

    //Cycle Detection In Disconnected Undirected Graph using BFS
    //Time O(N + 2*E) and space O(N)
    public static String cycleDetection(int[][] edges, int n, int m) {
        int[] vis = new int[n+1];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            int x1 = edge[0];
            int x2 = edge[1];
            adj.get(x1).add(x2);
            adj.get(x2).add(x1);
        }

        for(int i=1;i<=n;i++){
            if(vis[i] == 0){
                if(bfsDetectCycle(adj, i, -1, vis)) return "Yes";
            }
        }
        return "No";
    }

    public static boolean bfsDetectCycle(List<List<Integer>> adj, int index, int parent, int[] vis){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(index, parent));
        vis[index]=1;

        while(!q.isEmpty()){
            Pair pair = q.poll();
            int node = pair.node;
            int nodeParent = pair.parent;

            for(int neighbour : adj.get(node)){
                if(vis[neighbour] == 0){
                    vis[neighbour] = 1;
                    q.add(new Pair(neighbour, node));
                }else if(neighbour != nodeParent) return true;
            }
        }
        return false;
    }

    public static class Pair{
        int node;
        int parent;

        public Pair(int n, int p){
            this.node=n;
            this.parent=p;
        }
    }

}
