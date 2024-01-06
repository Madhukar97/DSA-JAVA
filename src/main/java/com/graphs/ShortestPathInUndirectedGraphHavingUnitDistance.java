package com.graphs;

import java.util.*;

//Shortest path in Undirected Graph having unit distance
//geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
public class ShortestPathInUndirectedGraphHavingUnitDistance {
    //Dijkstras shortest path algo
    class Solution {

        public int[] shortestPath(int[][] edges,int N,int m ,int src) {
            int[] dist = new int[N];
            Arrays.fill(dist, Integer.MAX_VALUE);

            List<List<Node>> adj = new ArrayList<>();
            for(int i=0;i<N;i++) adj.add(new ArrayList<>());
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                //  int wt = edge[2];
                adj.get(u).add(new Node(v, 1));
                adj.get(v).add(new Node(u, 1));
            }

            PriorityQueue<Node> pq = new PriorityQueue<>((n1,n2) -> n1.wt-n2.wt);
            pq.add(new Node(src, 0));
            dist[src] = 0;

            while(!pq.isEmpty()){
                Node node = pq.poll();
                int nodeIndex = node.index;
                //  int nodeWt = node.wt;

                for(Node neighbour : adj.get(nodeIndex)){
                    if(dist[nodeIndex] != Integer.MAX_VALUE && dist[nodeIndex] + neighbour.wt < dist[neighbour.index]) {
                        dist[neighbour.index] = dist[nodeIndex] + neighbour.wt;
                        pq.add(new Node(neighbour.index, dist[neighbour.index]));
                    }
                }
            }
            for(int i=0;i<N;i++) if(dist[i] == Integer.MAX_VALUE) dist[i] = -1;
            return dist;
        }

        public class Node{
            int index;
            int wt;

            public Node(int i, int w){
                index=i;
                wt=w;
            }
        }
    }
}
