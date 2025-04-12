package com.graphs;

import java.util.*;

//1584. Min Cost to Connect All Points
//https://leetcode.com/problems/min-cost-to-connect-all-points/description/
public class MinCostToConnectAllPoints {
    //Kruskals MST using DisjointSet Data structure
    class Solution {
        public int minCostConnectPoints(int[][] points) {
            int n=points.length;

            PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2)->a1[2]-a2[2]);
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    int[] p1 = points[i];
                    int[] p2 = points[j];
                    int dist = Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]);
                    pq.add(new int[]{i,j,dist});
                }
            }

            DisjointSet djs = new DisjointSet(n);
            int ans=0;
            while(!pq.isEmpty()){
                int[] node = pq.poll();
                int u=node[0];
                int v=node[1];
                int wt=node[2];

                if(!djs.isConnected(u,v)){
                    ans+=wt;
                    djs.unionBySize(u,v);
                }
            }
            return ans;
        }

        public class DisjointSet{
            int[] parent;
            int[] size;

            public DisjointSet(int n){
                parent = new int[n+1];
                size = new int[n+1];
                for(int i=0;i<=n;i++){
                    parent[i]=i;
                    size[i]=1;
                }
            }

            public int findUP(int node){
                if(node==parent[node]) return node;

                int up = findUP(parent[node]);
                parent[node] = up;
                return up;
            }

            public void unionBySize(int u, int v){
                int upu = findUP(u);
                int upv = findUP(v);
                if(upu==upv) return;
                if(size[upu] < size[upv]){
                    parent[upu] = upv;
                    size[upv]+=size[upu];
                }else{
                    parent[upv] = upu;
                    size[upu]+=size[upv];
                }
            }

            public boolean isConnected(int u, int v){
                return findUP(u)==findUP(v);
            }
        }
    }
}
