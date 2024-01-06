package com.graphs;

import java.util.*;

//797. All Paths From Source to Target
//https://leetcode.com/problems/all-paths-from-source-to-target/description/
public class AllPathsFromSourceToTarget {
    //Using DFS traversal
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n=graph.length;
        List<List<Integer>> ans = new ArrayList<>();

        dfs(graph, 0, ans, new ArrayList<>());
        return ans;
    }

    public void dfs(int[][] graph, int node, List<List<Integer>> ans, List<Integer> path){
        if(node == graph.length-1){
            path.add(node);
            ans.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }

        path.add(node);
        for(int neighbour : graph[node]){
            dfs(graph, neighbour, ans, path);
        }
        path.remove(path.size()-1);
    }
}
