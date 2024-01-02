package com.graphs;

//Connecting the graph
//https://www.geeksforgeeks.org/problems/connecting-the-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=connecting-the-graph
public class ConnectingTheGraph {
    class Solution {

        public int Solve(int n, int[][] edges) {
            DisjointSet djs = new DisjointSet(n);
            int extraEdges = 0;
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                if(djs.detectCycle(u,v)) extraEdges++;
                djs.unionBySize(u,v);
            }

            int component=0;
            for(int i=0;i<n;i++){
                if(djs.parent[i]==i) component++;
            }
            if(extraEdges >= component-1) return component-1;
            else return -1;
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

            public int findUltimateParent(int node){
                if(node == parent[node]) return node;

                int up = findUltimateParent(parent[node]);
                parent[node] = up;
                return up;
            }

            public void unionBySize(int u, int v){
                int upU = findUltimateParent(u);
                int upV = findUltimateParent(v);
                if(upU == upV) return;
                if(size[upU] < size[upV]){
                    parent[upU] = upV;
                    size[upV]+=size[upU];
                }else{
                    parent[upV]=upU;
                    size[upU]+=size[upV];
                }
            }

            public boolean detectCycle(int u, int v){
                return findUltimateParent(u)==findUltimateParent(v);
            }
        }
    }
}
