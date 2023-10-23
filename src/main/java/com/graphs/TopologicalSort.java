package com.graphs;

import java.util.*;

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

    //https://www.codingninjas.com/studio/problems/982938?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
    //Topological sort using DFS and stack
    //use DFS(recursion) and stack and vis[], If adjacency list is not given create it using edges list,
    // for every index do dfs and for every neighbour do dfs and after coming out of recursion add index to stack and return the ans popping the stack
    //Time complexity O(n + E) for directed graphs and space O(n + n)
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++) adj.add(new ArrayList<>());
        for(List<Integer> edge : edges){
            int x = edge.get(0);
            int y = edge.get(1);
            adj.get(x).add(y);
        }
        int[] vis = new int[v];
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<v;i++){
            if(vis[i]==0){
                dfsTopoSort(adj,i,vis,stack);
            }
        }
        while(!stack.isEmpty()) ans.add(stack.pop());
        return ans;
    }

    public static void dfsTopoSort(ArrayList<ArrayList<Integer>> adj, int index, int[] vis, Stack<Integer> stack){
        vis[index] = 1;

        for(int neighbour : adj.get(index)){
            if(vis[neighbour] == 0){
                dfsTopoSort(adj,neighbour,vis,stack);
            }
        }
        stack.push(index);
    }

    //Topological sort using BFS and queue
    //Use iteration and inDegree[] array, form the inDegree array, add all nodes with inDegree=0 to q and
    //for every node in q iterate all neighbours and decrement the inDegree of each neighbour by 1
    // and if for any neighbour inDegree==0 add neighbour node to q
    public static ArrayList<Integer> topologicalSortSol2(ArrayList<ArrayList<Integer>> edges, int v, int e) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++) adj.add(new ArrayList<>());
        for(List<Integer> edge : edges){
            int x = edge.get(0);
            int y = edge.get(1);
            adj.get(x).add(y);
        }

        int[] inDegree = new int[v];

        for(int i=0;i<v;i++){
            for(int node : adj.get(i)){
                inDegree[node]+=1;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<v;i++){
            if(inDegree[i]==0) q.add(i);
        }

        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);

            for(int neighbour : adj.get(node)){
                inDegree[neighbour]-=1;
                if(inDegree[neighbour] == 0) q.add(neighbour);
            }
        }
        return ans;
    }
}
