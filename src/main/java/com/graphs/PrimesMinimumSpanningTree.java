package com.graphs;

import java.util.*;

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

    //https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1
    //If edges are given form the adjacency list
    static int spanningTree(int V, int E, int edges[][]){
        List<List<Node>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            int x = edge[0];
            int y = edge[1];
            int wt = edge[2];
            adj.get(x).add(new Node(y,wt));
            adj.get(y).add(new Node(x,wt));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((n1,n2)->n1.wt-n2.wt);
        int[] vis = new int[V];

        pq.add(new Node(0, 0));
        int sum=0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int nodeIndex = node.i;
            int wt = node.wt;

            if(vis[nodeIndex] == 1)continue;
            vis[nodeIndex] = 1;
            sum+=wt;

            for(Node neighbour : adj.get(nodeIndex)){
                if(vis[neighbour.i] == 0){
                    pq.add(new Node(neighbour.i,neighbour.wt));
                }
            }
        }
        return sum;
    }

    public static class Node{
        int i;
        int wt;

        public Node(int i, int wt){
            this.i=i;
            this.wt=wt;
        }
    }
}
