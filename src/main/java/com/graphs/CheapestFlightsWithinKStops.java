package com.graphs;

import java.util.*;

//787. Cheapest Flights Within K Stops
//https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
public class CheapestFlightsWithinKStops {
    //Modified Bellman-Ford Algorithm
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        //take a tempDis array because you dont want to consider the updated node value
        //for your neighbouring stops in the same iteration, to satisfy the condition (Kth iteration = k no.of stops)
        int[] tempDis = new int[n];
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Arrays.fill(tempDis, Integer.MAX_VALUE);

        dis[src]=0;
        tempDis[src]=0;

        //run bellman-ford algo for k+1 times
        for(int i=1;i<=k+1;i++){
            for(int[] edge : flights){
                int x = edge[0];
                int y = edge[1];
                int wt = edge[2];
                if(dis[x] != Integer.MAX_VALUE && dis[x]+wt < tempDis[y]) tempDis[y] = dis[x]+wt;
            }
            for(int j=0;j<n;j++) dis[j] = tempDis[j];
        }
        int ans = dis[dst];
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }

    //Dijkstras algo
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            //Dijkstras shortest path algo
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);

            List<List<Node>> adj = new ArrayList<>();
            for(int i=0;i<n;i++) adj.add(new ArrayList<>());
            for(int[] edge : flights){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                adj.get(u).add(new Node(v, wt, Integer.MAX_VALUE));
            }

            Queue<Node> pq = new LinkedList<>();
            pq.add(new Node(src, 0, 0));
            dist[src]=0;

            while(!pq.isEmpty()){
                Node node = pq.poll();

                if(node.stops > k ) continue;

                for(Node neighbour : adj.get(node.index)){
                    if(node.dist+neighbour.dist < dist[neighbour.index] && node.stops <=k){
                        dist[neighbour.index] = node.dist + neighbour.dist;
                        pq.add(new Node(neighbour.index, dist[neighbour.index],node.stops+1));
                    }
                }
            }
            if(dist[dst] == Integer.MAX_VALUE) return -1;
            return dist[dst];
        }

        public class Node{
            int index;
            int dist;
            int stops;

            public Node(int i, int d, int s){
                index=i;
                dist=d;
                stops=s;
            }
        }
    }

    // Revision 2 using BFS algo
    class Solution3 {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            List<List<Node>> adj = new ArrayList<>();
            for(int i=0;i<n;i++) adj.add(new ArrayList<>());
            for(int[] edge : flights){
                int u = edge[0];
                int v = edge[1];
                int price = edge[2];
                adj.get(u).add(new Node(0, price, v));
            }

            int[] prices = new int[n];
            Arrays.fill(prices, Integer.MAX_VALUE);
            prices[src]=0;

            Queue<Node> q = new LinkedList<>();
            q.add(new Node(0, 0, src));

            // BFS algo
            while(!q.isEmpty()){
                Node curr = q.poll();
                for(Node neigh : adj.get(curr.index)){
                    if(curr.price + neigh.price < prices[neigh.index] && curr.stops <= k){
                        prices[neigh.index] = curr.price + neigh.price;
                        q.add(new Node(curr.stops+1, prices[neigh.index], neigh.index));
                    }
                }
            }
            return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
        }

        class Node{
            int stops;
            int price;
            int index;

            public Node(int stops, int price, int index){
                this.stops=stops;
                this.price=price;
                this.index=index;
            }
        }
    }
}
