package com.graphs;

import java.util.*;

//BFS in Graph
//https://www.codingninjas.com/studio/problems/bfs-in-graph_973002?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0
//https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
public class BFSInGraph {
    //BFS using iteration and Queue
    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj){
        ArrayList<Integer> ans = new ArrayList<>();
        int[] vis = new int[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()){
            int currIndex = q.poll();

            if(vis[currIndex] == 0){
                vis[currIndex] = 1;
                ans.add(currIndex);
                List<Integer> list = adj.get(currIndex);
                for(int i : list){
                    q.add(i);
                }
            }
        }
        return ans;
    }
}
