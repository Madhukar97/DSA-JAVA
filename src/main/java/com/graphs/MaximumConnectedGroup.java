package com.graphs;

import java.util.*;

//Maximum Connected group
//https://www.geeksforgeeks.org/problems/maximum-connected-group/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=maximum-connected-group
public class MaximumConnectedGroup {
    class Solution {

        public int MaxConnection(int grid[][]) {
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
            for(int i : djs.size) max = Math.max(max,i);
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]==1) continue;
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
                    int total=1;
                    for(int parent : parents){
                        total+=djs.size[djs.findUltimateParent(parent)];
                    }
                    max = Math.max(max,total);
                }
            }
            return max;

        }

        public class DisjointSet{
            int[] parent;
            int[] size;

            public DisjointSet(int n){
                parent= new int[n+1];
                size= new int[n+1];
                for(int i=0;i<=n;i++){
                    parent[i]=i;
                    size[i]=1;
                }
            }

            public int findUltimateParent(int node){
                if(node == parent[node])  return node;

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
                    parent[upv] = upu;
                    size[upu]+=size[upv];
                }
            }

            public boolean detectCycle(int u, int v){
                return findUltimateParent(u)==findUltimateParent(v);
            }
        }

    }
}
