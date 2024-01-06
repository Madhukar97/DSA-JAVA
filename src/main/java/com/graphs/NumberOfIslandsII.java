package com.graphs;

import java.util.*;

//Number Of Islands
//https://www.geeksforgeeks.org/problems/number-of-islands/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-islands
public class NumberOfIslandsII {
    class Solution {

        public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
            List<Integer> components = new ArrayList<>();
            DisjointSet djs = new DisjointSet(rows*cols);

            int[][] grid = new int[rows][cols];
            int count=0;

            for(int[] edge : operators){
                int i=edge[0];
                int j=edge[1];
                if (grid[i][j] == 1) {
                    components.add(count);
                    continue;
                }
                grid[i][j]=1;
                count++;
                int[] rowsA = {-1,0,1,0};
                int[] colsA = {0,1,0,-1};
                for(int k=0;k<4;k++){
                    int nx = i+rowsA[k];
                    int ny = j+colsA[k];
                    if(nx >=0 && nx<rows && ny>=0 && ny<cols && grid[nx][ny] == 1) {
                        if(!djs.detectCycle(i*cols+j, nx*cols+ny)){
                            djs.unionBySize(i*cols+j, nx*cols+ny);
                            count--;
                        }
                    }
                }
                components.add(count);
            }
            return components;
        }

        class DisjointSet{
            int[] parent;
            int[] size;

            public DisjointSet(int n){
                parent= new int[n+1];
                size=new int[n+1];
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
                if(upU==upV) return;
                if(size[upU] < size[upV]){
                    parent[upU] = upV;
                    size[upV]+=size[upU];
                }else{
                    parent[upV] = upU;
                    size[upU]+=size[upV];
                }
            }

            public boolean detectCycle(int u, int v){
                int ultimateParentOfU = findUltimateParent(u);
                int ultimateParentOfV = findUltimateParent(v);
                // System.out.println("upU of " + u+" : "+ ultimateParentOfU + ", upV "+v+ " : "+ ultimateParentOfV);
                return  ultimateParentOfU == ultimateParentOfV;
            }
        }

    }
}
