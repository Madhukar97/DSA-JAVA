package com.graphs;

import java.util.ArrayList;
import java.util.Stack;

//Topological sort
//https://practice.geeksforgeeks.org/problems/topological-sort/1
public class TopologicalSort {
    public static void main(String[] args) {

    }

    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                dfs(i, adj, vis, stack);
            }
        }

        int[] ans = new int[V];
        int i=0;
        while(!stack.isEmpty()) {
            ans[i++] = stack.pop();
        }
        return ans;
    }

    static void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> stack) {
        vis[v] = true;

        for(Integer neighbour : adj.get(v)) {
            if(!vis[neighbour]) {
                dfs(neighbour, adj, vis, stack);
            }
        }
        stack.push(v);
    }
}
