package com.graphs;

//1319. Number of Operations to Make Network Connected
//https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/
//Connecting the graph
//https://www.geeksforgeeks.org/problems/connecting-the-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=connecting-the-graph
public class NumberOfOperationsToMakeNetworkConnected {
    class Solution {
        public int makeConnected(int n, int[][] connections) {
            DisjointSet djs = new DisjointSet(n);

            int extraConnection=0;
            for(int[] conn : connections){
                int u = conn[0];
                int v = conn[1];
                if(djs.detectCycle(u,v)) extraConnection++;
                djs.unionBySize(u,v);
            }

            int components = 0;
            for(int i=0;i<n;i++){
                if(djs.parent[i]==i) components++;
            }
            // System.out.println("extra : " + extraConnection +", comps : " + components);
            if(extraConnection>=components-1) return components-1;
            return -1;
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

            public boolean detectCycle(int u, int v){
                return findUltimateParent(u) == findUltimateParent(v);
            }
        }
    }
}
