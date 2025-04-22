package com.graphs;

import java.util.*;

//1489. Find Critical and Pseudo-Critical Edges in Minimum Spanning Tree
//https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/description/
public class FindCriticalAndPseudoCriticalEdgesInMST {
    class Solution {
        public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
            List<List<Integer>> ans = new ArrayList<>();
            for(int i=0;i<2;i++) ans.add(new ArrayList<>());
            int m=edges.length;
            int[][] newEdges = new int[m][4];
            for(int i=0;i<m;i++){
                newEdges[i] = Arrays.copyOf(edges[i], 4);
                newEdges[i][3] = i;
            }

            Arrays.sort(newEdges, (e1,e2) -> e1[2]-e2[2]);
            int mstWeight = 0;
            DJS mst = new DJS(n);
            for(int[] edge : newEdges){
                if(mst.unionBySize(edge[0], edge[1])) mstWeight+=edge[2];
            }

            for(int i=0;i<m;i++){
                DJS critical = new DJS(n);
                int ignoreWt = 0;
                for(int j=0;j<m;j++){
                    if(i!=j && critical.unionBySize(newEdges[j][0], newEdges[j][1])) ignoreWt+=newEdges[j][2];
                }
                if(critical.maxSize < n || ignoreWt > mstWeight) ans.get(0).add(newEdges[i][3]);
                else {
                    DJS mstForced = new DJS(n);
                    mstForced.unionBySize(newEdges[i][0], newEdges[i][1]);
                    int forcedWt = newEdges[i][2];
                    for(int j=0;j<m;j++){
                        if(i!=j && mstForced.unionBySize(newEdges[j][0], newEdges[j][1])) forcedWt += newEdges[j][2];
                    }
                    if(forcedWt == mstWeight) ans.get(1).add(newEdges[i][3]);
                }
            }
            return ans;
        }

        class DJS{
            int[] parent;
            int[] size;
            int maxSize;
            public DJS(int n){
                parent = new int[n];
                size = new int[n];
                for(int i=0;i<n;i++){
                    parent[i]=i;
                    size[i]=1;
                }
                maxSize=0;
            }
            public int findUltimateParent(int node){
                if(parent[node] == node) return node;
                return parent[node] = findUltimateParent(parent[node]);
            }
            public boolean unionBySize(int u, int v){
                int upu = findUltimateParent(u);
                int upv = findUltimateParent(v);
                if(upu == upv) return false;
                if(size[upu] > size[upv]){
                    parent[upv] = upu;
                    size[upu] += size[upv];
                    maxSize = Math.max(maxSize, size[upu]);
                }else {
                    parent[upu] = upv;
                    size[upv] += size[upu];
                    maxSize = Math.max(maxSize, size[upv]);
                }
                return true;
            }
        }
    }
}
