package com.graphs;

import java.util.ArrayList;

//Detect cycle in a directed graph
//https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1#
public class DetectcycleIndirectedgraph {
    public static void main(String[] args) {

    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] vis = new boolean[V];
        boolean[] recS = new boolean[V];

        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                if(dfs(i, adj, vis, recS)) return true;
            }
        }
        return false;

    }
    boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] recS) {
        vis[v] = true;
        recS[v] = true;

        for(Integer neighbour : adj.get(v)) {
            if(!vis[neighbour]) {
                if(dfs(neighbour, adj, vis, recS)) return true;
            }
            else if(recS[neighbour]) {
                return true;
            }
        }
        recS[v] = false;
        return false;
    }
}
