package com.graphs;

import java.util.Arrays;

// Minimum Spanning Tree
//https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
public class KruskalsMinimumSpanningTree {
    //Using DisjointSet and UnionFind
    class Solution{
        static int spanningTree(int V, int E, int edges[][]){

            DisjointSet djs = new DisjointSet(E);
            Arrays.sort(edges, (a1, a2)->a1[2]-a2[2]);

            int ans=0;

            for(int[] edge : edges){
                int u=edge[0];
                int v=edge[1];
                int wt=edge[2];
                if(!djs.detectCycle(u,v)){
                    ans+=wt;
                    djs.unionBySize(u,v);
                }
            }

            return ans;
        }

        static class DisjointSet{
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
                int upU = findUltimateParent(u);
                int upV = findUltimateParent(v);
                if(upU == upV) return;
                if(size[upU] < size[upV]){
                    parent[upU] = upV;
                    size[upV] += size[upU];
                }else{
                    parent[upV] = upU;
                    size[upU]+=size[upV];
                }
            }

            public boolean detectCycle(int u, int v){
                return findUltimateParent(u)==findUltimateParent(v);
            }
        }
    }
}
