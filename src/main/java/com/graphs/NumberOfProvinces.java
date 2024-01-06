package com.graphs;

import java.util.ArrayList;

//Number of Provinces
//https://www.geeksforgeeks.org/problems/number-of-provinces/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-provinces
//547. Number of Provinces
//https://leetcode.com/problems/number-of-provinces/description/
public class NumberOfProvinces {
    //Using DisjointSet and UnionFind
    class Solution {
        static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
            DisjointSet djs = new DisjointSet(V);
            for(int i=0;i<V;i++){
                for(int j=0;j<V;j++){
                    if(adj.get(i).get(j) == 1){
                        djs.unionBySize(i,j);
                    }
                }
            }

            int count=0;
            for(int i=0;i<V;i++){
                if(djs.parent[i]==i) count++;
            }
            return count;
        }

        static class DisjointSet{
            int[] parent;
            int[] size;

            public DisjointSet(int n){
                parent= new int[n+1];
                size=new int[n+1];
                for(int i=0;i<=n;i++){
                    parent[i]=i;
                    size[i]=1;
                }
            }

            public int findUltimateParent(int node){
                if(node == parent[node]) return node;

                int ultimate = findUltimateParent(parent[node]);
                parent[node] = ultimate;
                return ultimate;
            }

            public void unionBySize(int u, int v){
                int upU = findUltimateParent(u);
                int upV = findUltimateParent(v);
                if(upU==upV) return;
                if(size[upU] < size[upV]){
                    parent[upU] = upV;
                    size[upV]+=size[upU];
                }else{
                    parent[upV] = upU;
                    size[upU]+=size[upV];
                }
            }
        }
    }

    //leetcode solution
    class Solution2 {
        public int findCircleNum(int[][] isConnected) {
            int n=isConnected.length;
            DisjointSet djs = new DisjointSet(n);

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(isConnected[i][j] == 1){
                        djs.unionBySize(i, j);
                    }
                }
            }

            int count=0;
            for(int i=0;i<n;i++) if(djs.parent[i]==i) count++;
            return count;
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

                int ultimate = findUltimateParent(parent[node]);
                parent[node] = ultimate;
                return ultimate;
            }

            public void unionBySize(int u, int v){
                int upu = findUltimateParent(u);
                int upv = findUltimateParent(v);
                if(upu == upv) return;
                if(size[upu] < size[upv]){
                    parent[upu] = upv;
                    size[upv]+=size[upu];
                }else{
                    parent[upv]=upu;
                    size[upu]+=size[upv];
                }
            }
        }
    }
}
