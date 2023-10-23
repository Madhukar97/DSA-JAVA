package com.graphs;

import java.util.*;

//210. Course Schedule II
//https://leetcode.com/problems/course-schedule-ii/description/
public class CourseScheduleII {
    //Return TopoSort if there is no Cycle present in Directed graph else empty array
    //Using BFS toposort and detect cycle
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //Return TopoSort using BFS and Detect Cycle in Direceted Graph
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
        for(int[] edge : prerequisites){
            int x = edge[1];
            int y = edge[0];
            adj.get(x).add(y);
        }

        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int node : adj.get(i)) indegree[node]+=1;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) q.add(i);
        }
        List<Integer> topoList = new ArrayList<>();
        int[] topoSort = new int[numCourses];

        while(!q.isEmpty()){
            int node = q.poll();
            topoList.add(node);

            for(int neighbour : adj.get(node)){
                indegree[neighbour]-=1;
                if(indegree[neighbour]==0) q.add(neighbour);
            }
        }

        if(topoList.size() <  numCourses) return new int[0];
        for(int i=0;i<numCourses;i++) topoSort[i]=topoList.get(i);
        return topoSort;
    }

    //Return TopoSort if there is no Cycle present in Directed graph else empty array
    //Using DFS toposort and detect cycle
    public int[] findOrderSol2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
        for(int[] edge : prerequisites){
            int x = edge[1];
            int y = edge[0];
            adj.get(x).add(y);
        }

        int[] vis = new int[numCourses];
        int[] dfsvis = new int[numCourses];

        List<Integer> topoList = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            if(vis[i]==0){
                if(dfsDetectCycleTopoSort(adj, i, vis, dfsvis, topoList)) return new int[0];
            }
        }

        int[] toposort = new int[numCourses];
        for(int i=0;i<numCourses;i++) toposort[i] = topoList.get(numCourses-i-1);
        return toposort;
    }

    public boolean dfsDetectCycleTopoSort(List<List<Integer>> adj, int index, int[] vis, int[] dfsvis, List<Integer> topoList){
        vis[index]=1;
        dfsvis[index]=1;

        for(int neighbour : adj.get(index)){
            if(vis[neighbour]==0){
                if(dfsDetectCycleTopoSort(adj, neighbour, vis, dfsvis, topoList)) return true;
            }else if(dfsvis[neighbour]==1) return true;
        }
        topoList.add(index);
        dfsvis[index]=0;
        return false;
    }
}
