package com.graphs;

import java.util.*;

//947. Most Stones Removed with Same Row or Column
//https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/
//Maximum Stone Removal
//https://www.geeksforgeeks.org/problems/maximum-stone-removal-1662179442/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=maximum-stone-removal
public class MostStonesRemovedWithSameRowOrColumn {
    class Solution {
        public int removeStones(int[][] stones) {
            int n=stones.length;
            int maxRow = 0;
            int maxCol = 0;
            for (int i = 0; i < n; i++) {
                maxRow = Math.max(maxRow, stones[i][0]);
                maxCol = Math.max(maxCol, stones[i][1]);
            }
            DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
            HashMap<Integer, Integer> stoneNodes = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int nodeRow = stones[i][0];
                int nodeCol = stones[i][1] + maxRow + 1;
                ds.unionBySize(nodeRow, nodeCol);
                stoneNodes.put(nodeRow, 1);
                stoneNodes.put(nodeCol, 1);
            }

            int cnt = 0;
            for (Map.Entry<Integer, Integer> it : stoneNodes.entrySet()) {
                if (ds.findUltimateParent(it.getKey()) == it.getKey()) {
                    cnt++;
                }
            }
            return n - cnt;
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
