package com.graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

//Minimum Spanning Tree
//https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1
class Pair implements Comparable<Pair>{
    int v;
    int wt;
    public Pair(int v, int wt) {
        this.v = v;
        this.wt = wt;
    }
    public int compareTo(Pair that) {
        return wt-that.wt;
    }
}

public class PrimesMinimumSpanningTree {
    public static void main(String[] args) {
    }
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj)
    {
        // Add your code here
        int ans = 0;
        boolean[] vis = new boolean[V];
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(0,0));

        while(!q.isEmpty()){
            Pair cur = q.poll();

            int u = cur.v;
            if(vis[u]) continue;

            ans+= cur.wt;
            vis[u] = true;
            ArrayList<ArrayList<Integer>> neighbours = adj.get(u);

            for(ArrayList<Integer> list : neighbours) {
                int vertex = list.get(0);
                int wt = list.get(1);
                if(!vis[vertex]) q.add(new Pair(vertex, wt));
            }
        }
        return ans;
    }
}
