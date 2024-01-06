package com.graphs;

//1579. Remove Max Number of Edges to Keep Graph Fully Traversable
//https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/description/
public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {
    //Sol Using DisjointSet
    class Solution {
        public int maxNumEdgesToRemove(int n, int[][] edges) {
            DisjointSet alice = new DisjointSet(n);
            DisjointSet bob = new DisjointSet(n);

            int count=0;
            //connect type 3 edges in both DJSs and if(both alice & bob are already connected thats an extra edge)
            for(int[] edge : edges){
                int type = edge[0];
                int u=edge[1];
                int v=edge[2];
                if(type != 3) continue;
                if(alice.isConnected(u,v) && bob.isConnected(u,v)) count++;
                else {
                    alice.unionBySize(u,v);
                    bob.unionBySize(u,v);
                }
            }
            //connect type 1 and 2 edges if(alice or bob is already connected thats and extra edge)
            for(int[] edge : edges){
                int type = edge[0];
                int u=edge[1];
                int v=edge[2];

                if(type == 1){
                    if(alice.isConnected(u,v)) count++;
                    else alice.unionBySize(u,v);
                }else if(type == 2){
                    if(bob.isConnected(u,v)) count++;
                    else bob.unionBySize(u,v);
                }
            }

            int componentsAlice=0;
            int componentsBob=0;
            for(int i=1;i<=n;i++){
                if(alice.parent[i]==i) componentsAlice++;
                if(bob.parent[i]==i) componentsBob++;
            }
            if(componentsAlice > 1 || componentsBob > 1) return -1;
            return count;
        }

        public class DisjointSet{
            int[] parent;
            int[] size;

            public DisjointSet(int n){
                parent = new int[n+1];
                size = new int[n+1];
                for(int i=0;i<=n;i++){
                    parent[i] = i;
                    size[i]=1;
                }
            }

            public int findUltimateParent(int node){
                if(node==parent[node]) return node;

                int ultimate = findUltimateParent(parent[node]);
                parent[node] = ultimate;
                return ultimate;
            }

            public void unionBySize(int u, int v){
                int upu = findUltimateParent(u);
                int upv = findUltimateParent(v);
                if(upu == upv) return;
                if(size[upu] < size[upv]){
                    parent[upu]=upv;
                    size[upv]+=size[upu];
                }else{
                    parent[upv]=upu;
                    size[upu]+=size[upv];
                }
            }

            public boolean isConnected(int u, int v){
                return findUltimateParent(u)==findUltimateParent(v);
            }
        }
    }
}
