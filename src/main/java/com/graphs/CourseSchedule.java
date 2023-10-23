package com.graphs;

import java.util.*;

//207. Course Schedule
//https://leetcode.com/problems/course-schedule/description/
public class CourseSchedule {
    //Detect cycle in directed graph using DFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
        for(int[] edge : prerequisites){
            int x = edge[1];
            int y = edge[0];
            adj.get(y).add(x);
        }

        int[] vis = new int[numCourses];
        int[] dfsvis = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(vis[i]==0){
                if(dfsDetectCycle(adj, i, vis, dfsvis)) return !true;
            }
        }
        return !false;
    }

    public boolean dfsDetectCycle(List<List<Integer>> adj, int index, int[] vis, int[] dfsvis){
        vis[index]=1;
        dfsvis[index]=1;

        for(int neighbour : adj.get(index)){
            if(vis[neighbour]==0){
                if(dfsDetectCycle(adj, neighbour, vis, dfsvis)) return true;
            }else if(dfsvis[neighbour] == 1) return true;
        }
        dfsvis[index]=0;
        return false;
    }

    //Detect cycle in directed graph using BFS (Use TopoSort with BFS (indegree[]))
    public boolean canFinishSol2(int numCourses, int[][] prerequisites) {
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

        List<Integer> topoSort = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            topoSort.add(node);

            for(int neighbour : adj.get(node)){
                indegree[neighbour]-=1;
                if(indegree[neighbour]==0) q.add(neighbour);
            }
        }
        if(topoSort.size() == numCourses) return true;
        return false;
    }
}
