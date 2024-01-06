package com.graphs;

import java.util.*;

//802. Find Eventual Safe States
//https://leetcode.com/problems/find-eventual-safe-states/
public class FindEventualSafeStates {
    //Using Toposort with BFS
    //Reverse the edges and return the toposort
    class Solution {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int n = graph.length;
            List<Integer> toposort = new ArrayList<>();
            int[] indegree = new int[graph.length];

            List<List<Integer>> adjT = new ArrayList<>();
            for(int i=0;i<n;i++) adjT.add(new ArrayList<>());
            for(int i=0;i<n;i++){
                for(int u : graph[i]){
                    indegree[i]++;
                    adjT.get(u).add(i);
                }
            }

            Queue<Integer> q = new LinkedList<>();
            for(int i=0;i<n;i++) if(indegree[i]==0) q.add(i);

            while(!q.isEmpty()){
                int node = q.poll();
                toposort.add(node);

                for(int neighbour : adjT.get(node)){
                    indegree[neighbour]--;
                    if(indegree[neighbour]==0) q.add(neighbour);
                }
            }
            Collections.sort(toposort);
            return toposort;
        }
    }
}
