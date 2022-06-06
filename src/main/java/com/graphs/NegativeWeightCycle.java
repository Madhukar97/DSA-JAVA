package com.graphs;

import java.util.Arrays;

//Negative weight cycle
//https://practice.geeksforgeeks.org/problems/negative-weight-cycle3504/1#
public class NegativeWeightCycle {
    public static void main(String[] args) {

    }
    //Method to detect if negative weighted cycle present in graph
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0]=0;

        for(int count =0; count<n; count++) {
            for(int[] list : edges) {
                int src = list[0];
                int dest = list[1];
                int wt = list[2];
                if(dist[src] != Integer.MAX_VALUE && dist[src] + wt < dist[dest]) dist[dest] = dist[src]+wt;
            }
        }
        for(int[] list : edges) {
            int src = list[0];
            int dest = list[1];
            int wt = list[2];
            if(dist[src] != Integer.MAX_VALUE && dist[src] + wt < dist[dest]) return 1;
        }
        return 0;
    }
}

