package com.graphs;

import java.util.Arrays;

//1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance
//https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/
//City With the Smallest Number of Neighbors at a Threshold Distance
//https://www.geeksforgeeks.org/problems/city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=city-with-the-smallest-number-of-neighbors-at-a-threshold-distance
public class CityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
    //Using Bellman Ford algo
    //For undirected graph : consider the edges in both directions to calc the shortest dist
    class Solution {
        int findCity(int n, int m, int[][] edges,int distanceThreshold)
        {
            int[] dist = new int[n];

            int ans=0;
            int min=Integer.MAX_VALUE;

            for(int src=0;src<n;src++){
                Arrays.fill(dist, Integer.MAX_VALUE);
                dist[src]=0;
                for(int i=0;i<n-1;i++){
                    for(int[] edge : edges){
                        int u = edge[0];
                        int v = edge[1];
                        int wt = edge[2];
                        if(dist[u] != Integer.MAX_VALUE && dist[u]+wt < dist[v]){
                            dist[v] = dist[u]+wt;
                        }
                        if(dist[v] != Integer.MAX_VALUE && dist[v]+wt < dist[u]){
                            dist[u] = dist[v]+wt;
                        }
                    }
                }
                int cities = 0;
                for(int d : dist) if(d != 0 && d<=distanceThreshold) cities++;
                if(cities <= min) {
                    min = cities;
                    ans = src;
                }
            }

            return ans;
        }
    }
}
