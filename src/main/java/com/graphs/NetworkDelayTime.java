package com.graphs;

import java.util.*;

//743. Network Delay Time
//https://leetcode.com/problems/network-delay-time/description/
public class NetworkDelayTime {
    //Same as Dijkstras algorithm (find the Shortest path array and return max value)
    public int networkDelayTime(int[][] times, int n, int k) {
        //Dijkstras Shortest Path Algorithm
        List<List<Node>> adj = new ArrayList<>();
        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0]=0;
        dis[k]=0;

        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int[] edge : times){
            int x = edge[0];
            int y = edge[1];
            int wt = edge[2];
            adj.get(x).add(new Node(y, wt));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((n1,n2)->n1.wt-n2.wt);
        pq.add(new Node(k,0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int index = node.i;
            int wt = node.wt;

            for(Node neighbour : adj.get(index)){
                if(neighbour.wt + wt < dis[neighbour.i]){
                    dis[neighbour.i] = neighbour.wt+wt;
                    pq.add(new Node(neighbour.i, dis[neighbour.i]));
                }
            }
        }

        int ans = 0;
        for(int i : dis) ans = Math.max(ans, i);
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }

    public class Node{
        int i;
        int wt;

        public Node(int i, int wt){
            this.i=i;
            this.wt=wt;
        }
    }
}
