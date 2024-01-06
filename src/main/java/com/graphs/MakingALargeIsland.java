package com.graphs;

import java.util.*;

//827. Making A Large Island
//leetcode.com/problems/making-a-large-island/description/
//Maximum Connected group
//https://www.geeksforgeeks.org/problems/maximum-connected-group/1
public class MakingALargeIsland {
    class Solution {
        public int largestIsland(int[][] grid) {
            int n=grid.length;

            DisjointSet djs = new DisjointSet(n*n);
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j] == 1){

                        int[] rows = {-1,0,1,0};
                        int[] cols = {0,1,0,-1};
                        for(int k=0;k<4;k++){
                            int x = i+rows[k];
                            int y = j+cols[k];
                            if(x>=0 && x<n && y>=0 && y<n && grid[x][y]==1){
                                djs.unionBySize(i*n+j, x*n+y);
                            }
                        }
                    }
                }
            }

            int max=0;
            for(int i=0;i<n*n;i++) max = Math.max(max, djs.size[i]);
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j] == 0){

                        Set<Integer> parents = new HashSet<>();

                        int[] rows = {-1,0,1,0};
                        int[] cols = {0,1,0,-1};
                        for(int k=0;k<4;k++){
                            int x = i+rows[k];
                            int y = j+cols[k];
                            if(x>=0 && x<n && y>=0 && y<n && grid[x][y]==1){
                                parents.add(djs.findUltimateParent(x*n+y));
                            }
                        }
                        int totalSize=1;
                        for(int parent : parents){
                            totalSize+=djs.size[parent];
                        }
                        max=Math.max(max, totalSize);
                    }
                }
            }
            return max;
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
