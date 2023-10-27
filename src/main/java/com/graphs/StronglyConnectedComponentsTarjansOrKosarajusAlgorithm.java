package com.graphs;

import java.util.*;

//Strongly Connected Components (Tarjan’s Algorithm) / Kosarajus Algorithm
//https://www.codingninjas.com/studio/problems/985311?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
public class StronglyConnectedComponentsTarjansOrKosarajusAlgorithm {

    //Kosarajus Algorithm for strongly connected components : find toposort using DFS stack, reverse edges, do dfs and add to ans
    /*
    1.If edges are given form the adjacency matrix
    2.Find the topoSort using DFS and stack and vis[] array
    3.Form the reverse Adjacency matrix
    4.Do dfs on revAdj for all indexes which are not visited and add each component dfs to ans and return
     */

    public static List<List<Integer>> stronglyConnectedComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            int x = edge[0];
            int y = edge[1];
            adj.get(x).add(y);
        }

        int[] vis = new int[n];
        Stack<Integer> toposort = new Stack<>();

        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(adj, vis, toposort, i);
            }
        }

        // System.out.println("TOPOSORT : " + toposort.toString());

        List<List<Integer>> revAdj = new ArrayList<>();
        for(int i=0;i<n;i++) revAdj.add(new ArrayList<>());
        for(int[] edge : edges){
            int x = edge[1];
            int y = edge[0];
            revAdj.get(x).add(y);
        }

        Arrays.fill(vis,0);
        List<List<Integer>> ans = new ArrayList<>();

        while(!toposort.isEmpty()){
            int node = toposort.pop();

            if(vis[node]==0){
                List<Integer> scc = new ArrayList<>();
                dfs2(revAdj, vis, scc, node);
                ans.add(scc);
            }
        }
        return ans;
    }

    public static void dfs2(List<List<Integer>> adj, int[] vis, List<Integer> scc, int index){
        vis[index]=1;
        scc.add(index);

        for(int neighbour : adj.get(index)){
            if(vis[neighbour]==0){
                dfs2(adj,vis,scc,neighbour);
            }
        }
    }

    public static void dfs(List<List<Integer>> adj, int[] vis, Stack<Integer> stack, int index){
        vis[index]=1;

        for(int neighbour : adj.get(index)){
            if(vis[neighbour]==0){
                dfs(adj,vis,stack,neighbour);
            }
        }
        stack.push(index);
    }
}
