package com.graphs;

import java.util.*;

//DFS of Graph
//https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1/?page=1&category[]=Graph&sortBy=submissions
//https://www.codingninjas.com/studio/problems/dfs-traversal_630462?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0
public class DFSofGraph {
    public static void main(String[] args) {

    }
    // Function to return a list containing the DFS traversal of the graph.
    // DFS of Graph(connected undirected graph)
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();

        dfs(0, adj, vis, ans);
        return ans;
    }

    void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> ans) {
        vis[v] = true;
        ans.add(v);

        for(Integer neighbour : adj.get(v)) {
            if(!vis[neighbour]) dfs(neighbour, adj, vis, ans);
        }

    }

    //DFS Traversal (disconnected and undirected graph)
    //If adjacency list is not given create it using edges list
    //if graph is disconnected do dfs for every index in adj list and store the graphs into ans
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] vis = new int[v];

        for(int i=0;i<v;i++) adj.add(new ArrayList<>());

        for(List<Integer> edge : edges){
            int x1 = edge.get(0);
            int x2 = edge.get(1);
            adj.get(x1).add(x2);
            adj.get(x2).add(x1);
        }

        for(int i=0;i<v;i++ ){
            ArrayList<Integer> graph = new ArrayList<>();
            if(vis[i] == 0)dfs(adj, i, graph, vis);
            if(graph.size() > 0)ans.add(graph);
        }
        return ans;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int index, ArrayList<Integer> ans, int[] vis){
        vis[index] = 1;
        ans.add(index);

        for(int i : adj.get(index)){
            if(vis[i] == 0) dfs(adj,i,ans,vis);
        }
    }
}
