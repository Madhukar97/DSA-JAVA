package com.graphs;

import java.util.*;

//1020. Number of Enclaves
//https://leetcode.com/problems/number-of-enclaves/description/
public class NumberOfEnclaves {
    //Using DisjointSet
    class Solution {
        public int numEnclaves(int[][] grid) {
            int m=grid.length;
            int n=grid[0].length;

            DisjointSet djs = new DisjointSet(m*n);
            int land=0;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j] == 1){
                        land++;
                        int[] rows = {-1,0,1,0};
                        int[] cols = {0,1,0,-1};
                        for(int k=0;k<4;k++){
                            int x = i+rows[k];
                            int y = j+cols[k];
                            if(x>=0 && y>=0 && x<m && y<n && grid[x][y]==1){
                                djs.unionBySize(i*n+j, x*n+y);
                            }
                        }
                    }
                }
            }

            Set<Integer> parents = new HashSet<>();
            for(int i=0;i<m;i++){
                if(grid[i][0] == 1) parents.add(djs.findUltimateParent(i*n+0));
                if(grid[i][n-1] == 1) parents.add(djs.findUltimateParent(i*n+n-1));
            }
            for(int j=0;j<n;j++){
                if(grid[0][j] == 1) parents.add(djs.findUltimateParent(0*n+j));
                if(grid[m-1][j] == 1) parents.add(djs.findUltimateParent((m-1)*n+j));
            }
            // System.out.println()
            int canwalk=0;
            for(int p : parents) canwalk+=djs.size[p];
            return land-canwalk;
        }

        public class DisjointSet{
            int[] parent;
            int[] size;

            public DisjointSet(int n){
                parent =  new int[n+1];
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
                if(size[upu] < size[upv]) {
                    parent[upu]=upv;
                    size[upv] += size[upu];
                }else{
                    parent[upv]=upu;
                    size[upu] += size[upv];
                }
            }
        }
    }
}
