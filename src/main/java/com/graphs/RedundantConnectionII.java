package com.graphs;

//685. Redundant Connection II
//leetcode.com/problems/redundant-connection-ii/description/
public class RedundantConnectionII {
    class Solution {
        public int[] findRedundantDirectedConnection(int[][] edges) {
            int n = edges.length;
            int edge1 = -1;
            int edge2 = -1;

            int[] inDegree = new int[n+1];
            for(int[] edge : edges) inDegree[edge[1]]++;

            int targetNode = 0;
            for(int i=1;i<=n;i++) if(inDegree[i]==2) targetNode = i;
            // System.out.println("Target Node : " + targetNode);

            for(int i=0;i<n;i++){
                int[] edge = edges[i];
                if(edge[1] == targetNode && edge1==-1) edge1 = i;
                else if(edge[1] == targetNode && edge2==-1) edge2 = i;
            }
            // if(targetNode != 0) System.out.println("edge1 : " + Arrays.toString(edges[edge1]));
            // if(targetNode != 0) System.out.println("edge2 : " + Arrays.toString(edges[edge2]));

            if(targetNode != 0){
                //1st try skipping later edge : edge2 and see if cycle is present if present 1st edge is ans else later edge
                DisjointSet djs = new DisjointSet(n);
                for(int[] edge : edges){
                    if(edge == edges[edge2]) continue;
                    int u=edge[0];
                    int v=edge[1];
                    if(djs.detectCycle(u,v)) return edges[edge1];
                    djs.unionBySize(u,v);
                }
                return edges[edge2];
            }
            //Detect edge which is causing cycle
            DisjointSet djs = new DisjointSet(n);
            for(int[] edge : edges){
                int u=edge[0];
                int v=edge[1];
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
                for(int i=0;i<n;i++){
                    parent[i]=i;
                    size[i]=1;
                }
            }

            public int findUltimateParent(int node){
                if(node == parent[node]) return node;

                int ultimateParent = findUltimateParent(parent[node]);
                parent[node] = ultimateParent;
                return ultimateParent;
            }

            public void unionBySize(int u, int v){
                int uParent = findUltimateParent(u);
                int vParent = findUltimateParent(v);
                if(uParent == vParent) return;
                if(size[uParent] < size[vParent]){
                    parent[uParent] = vParent;
                    size[vParent] = size[vParent]+size[uParent];
                }else{
                    parent[vParent] = uParent;
                    size[uParent] = size[uParent]+size[vParent];
                }
            }

            public boolean detectCycle(int u, int v){
                return findUltimateParent(u) == findUltimateParent(v);
            }
        }
    }
}
