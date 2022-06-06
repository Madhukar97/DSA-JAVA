package com.graphs;

import java.util.ArrayList;

//Detect cycle in an undirected graph
//https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
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
}
