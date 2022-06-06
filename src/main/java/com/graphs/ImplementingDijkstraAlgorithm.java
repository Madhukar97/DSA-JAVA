package com.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

//Implementing Dijkstra Algorithm
//https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1#
public class ImplementingDijkstraAlgorithm {
    public static void main(String[] args) {

    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        boolean[] vis = new boolean[V];
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(S, 0));
        int[] ans = new int[V];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[S] = 0;

        while(!q.isEmpty()) {
            Pair cur = q.poll();

            int u = cur.v;
            if(vis[u]) continue;

            vis[u] = true;
            ArrayList<ArrayList<Integer>> neighbours = adj.get(u);

            for(ArrayList<Integer> list : neighbours) {
                int vertex = list.get(0);
                int wt = list.get(1);
                if( ans[vertex] > cur.wt + wt) {
                    ans[vertex] = cur.wt+wt;
                    q.add(new Pair(vertex, ans[vertex]));
                }
            }
        }
        return ans;
    }

}
