package com.graphs;

//684. Redundant Connection
//leetcode.com/problems/redundant-connection/description/
public class RedundantConnection {
    class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            DisjointSet djs = new DisjointSet(edges.length);
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                if(djs.detectCycle(u,v)) return edge;
                djs.unionBySize(u,v);
            }
            return new int[2];
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
                int upU = findUltimateParent(u);
                int upV = findUltimateParent(v);
                if(upU == upV) return;
                if(size[upU] < size[upV]){
                    parent[upU] = upV;
                    size[upV] = size[upV]+size[upU];
                }else{
                    parent[upV] = upU;
                    size[upU] = size[upU]+size[upV];
                }
            }

            public boolean detectCycle(int u, int v){
                return findUltimateParent(u) == findUltimateParent(v);
            }
        }
    }
}
