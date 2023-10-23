package com.graphs;

import java.util.*;

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
//https://www.codingninjas.com/studio/problems/1062626?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
    public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
        int[] vis = new int[n+1];
        int[] dfsvis = new int[n+1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(List<Integer> edge : edges){
            int x1 = edge.get(0);
            int x2 = edge.get(1);
            adj.get(x1).add(x2);
        }
        // System.out.println("ADJ list : " + adj.toString());
        for(int i=1;i<=n;i++){
            if(vis[i]==0){
                if(dfsDetectCycle(adj,i,vis,dfsvis)) return true;
            }
        }
        return false;
    }

    public static boolean dfsDetectCycle(ArrayList<ArrayList<Integer>> adj, int index, int[] vis, int[] dfsvis){
        vis[index]=1;
        dfsvis[index]=1;

        for(int neighbour : adj.get(index)){
            if(vis[neighbour]==0){
                if(dfsDetectCycle(adj, neighbour, vis, dfsvis)) return true;
            }
            else if(vis[neighbour]==1 && dfsvis[neighbour]==1) return true;
        }
        dfsvis[index]=0;
        return false;
    }
}
