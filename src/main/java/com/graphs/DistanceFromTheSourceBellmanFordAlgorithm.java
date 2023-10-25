package com.graphs;

import java.util.*;

//Distance from the Source (Bellman-Ford Algorithm)
//https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/0?fbclid=IwAR2_lL0T84DnciLyzMTQuVTMBOi82nTWNLuXjUgahnrtBgkphKiYk6xcyJU
public class DistanceFromTheSourceBellmanFordAlgorithm {

    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int[] dist = new int[V];
        Arrays.fill(dist, 100000000);
        dist[S]=0;

        // N-1 iterations
        for(int count =0; count<V-1; count++) {
            for(List<Integer> list : edges) {
                int src = list.get(0);
                int dest = list.get(1);
                int wt = list.get(2);
                if(dist[src] != 100000000 && dist[src] + wt < dist[dest]) dist[dest] = dist[src]+wt;
            }
        }

        // Nth iteration to find negetive cycle
        for(List<Integer> list : edges) {
            int src = list.get(0);
            int dest = list.get(1);
            int wt = list.get(2);
            if(dist[src] != 100000000 && dist[src] + wt < dist[dest]) return new int[]{-1};
        }
        return dist;
    }
}
