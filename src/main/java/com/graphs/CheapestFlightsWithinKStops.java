package com.graphs;

import java.util.Arrays;

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
}
