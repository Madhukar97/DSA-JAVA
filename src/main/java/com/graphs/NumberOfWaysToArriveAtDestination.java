package com.graphs;

import java.util.*;

//1976. Number of Ways to Arrive at Destination
//https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/
public class NumberOfWaysToArriveAtDestination {
    //Using Dijkstras algo with ways[] array to reduce the traversal visited paths with same time
    class Solution {
        int mod = (int)Math.pow(10, 9)+7;
        public int countPaths(int n, int[][] roads) {
            List<List<Node>> adj = new ArrayList<>();
            for(int i=0;i<n;i++) adj.add(new ArrayList<>());
            for(int[] edge : roads){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                adj.get(u).add(new Node(v, wt));
                adj.get(v).add(new Node(u, wt));
            }

            long[] dist = new long[n];
            int[] ways = new int[n];
            Arrays.fill(dist, Long.MAX_VALUE);
            dist[0]=0;
            ways[0]=1;

            PriorityQueue<Node> pq = new PriorityQueue<>((n1,n2)->{
                long w1 = n1.wt;
                long w2 = n2.wt;
                if(w1 == w2) return 0;
                else if(w1 > w2) return 1;
                else return -1;
            });
            pq.add(new Node(0,0));

            while(!pq.isEmpty()){
                Node node = pq.poll();
                int nodeIndex = node.index;
                long nodeWt = node.wt;

                for(Node neighbour : adj.get(nodeIndex)){
                    if(nodeWt + neighbour.wt < dist[neighbour.index]){
                        ways[neighbour.index] =ways[nodeIndex];
                        dist[neighbour.index] = nodeWt + neighbour.wt;
                        pq.add(new Node(neighbour.index, nodeWt + neighbour.wt));
                    }else if(nodeWt + neighbour.wt == dist[neighbour.index]){
                        ways[neighbour.index]= (ways[neighbour.index]+ways[nodeIndex])%mod;
                    }
                }
            }
            return ways[n-1]%mod;
        }

        public class Node{
            int index;
            long wt;

            public Node(int i, long w){
                index=i;
                wt=w;
            }
        }
    }
}
