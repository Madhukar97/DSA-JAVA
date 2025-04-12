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

    // Revision 2
    class Solution2 {
        public int makeConnected(int n, int[][] connections) {
            DJS djs = new DJS(n);
            int extraConnections=0;

            for(int[] edge : connections){
                int u = edge[0];
                int v = edge[1];
                if(djs.isConnected(u,v)) extraConnections++;
                djs.unionBySize(u,v);
            }

            int components=0;
            for(int i=0;i<n;i++) if(djs.parent[i] == i) components++;
            return components-1 <= extraConnections ? components-1 : -1;
        }

        class DJS{
            int[] parent;
            int[] size;

            public DJS(int n){
                this.parent = new int[n];
                this.size = new int[n];

                for(int i=0;i<n;i++){
                    parent[i]=i;
                    size[i]=1;
                }
            }

            public int findUltimateParent(int node){
                if(parent[node]==node) return node;
                return parent[node] = findUltimateParent(parent[node]);
            }

            public void unionBySize(int u, int v){
                int ulp_u = findUltimateParent(u);
                int ulp_v = findUltimateParent(v);
                if(ulp_u == ulp_v) return;
                else if(size[ulp_u] < size[ulp_v]){
                    parent[ulp_u] = ulp_v;
                    size[ulp_v] += size[ulp_u];
                }else {
                    parent[ulp_v] = ulp_u;
                    size[ulp_u] += size[ulp_v];
                }
            }

            public boolean isConnected(int u, int v) {
                return findUltimateParent(u) == findUltimateParent(v);
            }
        }
    }
}
