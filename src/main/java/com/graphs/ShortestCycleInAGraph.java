package com.graphs;

import java.util.*;

//2608. Shortest Cycle in a Graph
//leetcode.com/problems/shortest-cycle-in-a-graph/description/
public class ShortestCycleInAGraph {
    //Using DFS and dist[] array
    class Solution {
        public int findShortestCycle(int n, int[][] edges) {
            List<List<Integer>> adj = new ArrayList<>();
            for(int i=0;i<n;i++) adj.add(new ArrayList<>());
            for(int[] edge : edges){
                int u=edge[0];
                int v=edge[1];
                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            int[] vis = new int[n];
            int[] dist = new int[n];
            int[] ans = new int[]{Integer.MAX_VALUE};

            for(int i=0;i<n;i++){
                dist=new int[n];
                vis=new int[n];
                dfs(adj, i, -1, vis, dist, ans, 1);
            }
            return ans[0] == Integer.MAX_VALUE ? -1 : ans[0];
        }

        public void dfs(List<List<Integer>> adj, int node, int parent, int[] vis, int[] dist, int[] ans, int len){
            vis[node]=1;
            dist[node] = len;

            for(int neighbour : adj.get(node)){
                if(vis[neighbour] == 0){
                    dfs(adj, neighbour, node, vis, dist, ans, len+1);
                }else if(vis[neighbour]==1 && neighbour != parent){
                    int cycleLenght = Math.abs(len-dist[neighbour])+1;
                    ans[0] = Math.min(ans[0], cycleLenght);
                    if(dist[neighbour] > len+1) dist[neighbour] = len+1;
                }
            }
        }
    }
}
