package com.graphs;

import java.util.*;

//200. Number of Islands
//https://leetcode.com/problems/number-of-islands/description/
public class NumberOfIslands {
    //Using BFS and vis[][] matrix
    //BFS is bit slow than DFS
    public int numIslands(char[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        int ans=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && vis[i][j] == 0){
                    bfs(grid, vis, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void bfs(char[][] grid, int[][] vis, int i, int j){
        vis[i][j] = 1;

        Queue<Island> q = new LinkedList<>();
        q.add(new Island(i,j));

        while(!q.isEmpty()){
            Island island = q.poll();
            int r = island.row;
            int c = island.col;

            int[] rows = {-1,0,1,0};
            int[] cols = {0,1,0,-1};

            for(int dir=0;dir<4;dir++){
                int currRow = r+rows[dir];
                int currCol = c+cols[dir];

                if(currRow >=0 && currRow < grid.length && currCol >=0 && currCol < grid[0].length && grid[currRow][currCol] == '1' && vis[currRow][currCol]==0){
                    q.add(new Island(currRow,currCol));
                    vis[currRow][currCol]=1;
                }
            }
        }
    }

    public class Island{
        int row;
        int col;

        public Island(int r, int c){
            this.row=r;
            this.col=c;
        }
    }

    //Using DFS and vis[][] matrix
    public int numIslandsSol2(char[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        int ans=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && vis[i][j] == 0){
                    dfs(grid, vis, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid, int[][] vis, int i, int j){
        vis[i][j] = 1;

        if(i-1 >=0 && vis[i-1][j] == 0 && grid[i-1][j] == '1') dfs(grid,vis,i-1,j);
        if(j+1 < grid[0].length && vis[i][j+1] == 0 && grid[i][j+1] == '1') dfs(grid,vis,i,j+1);
        if(i+1 < grid.length && vis[i+1][j] == 0 && grid[i+1][j] == '1') dfs(grid,vis,i+1,j);
        if(j-1 >=0 && vis[i][j-1] == 0 && grid[i][j-1] == '1') dfs(grid,vis,i,j-1);
    }

    //Using DisjointSet and UnionFind
    class Solution {
        public int numIslands(char[][] grid) {
            int m=grid.length;
            int n=grid[0].length;
            DisjointSet djs = new DisjointSet(m*n);

            // int count=0;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j] == '1'){
                        // count++;
                        int[] rows = {-1,0,1,0};
                        int[] cols = {0,1,0,-1};
                        for(int k=0;k<4;k++){
                            int nx = i+rows[k];
                            int ny = j+cols[k];
                            if(nx >=0 && nx<m && ny>=0 && ny<n && grid[nx][ny] == '1') {
                                if(!djs.detectCycle(i*n+j, nx*n+ny)){
                                    djs.unionBySize(i*n+j, nx*n+ny);
                                    // count--;
                                }
                            }
                        }
                    }
                }
            }

            int ans=0;
            for(int i=0;i<m*n;i++){
                if(djs.parent[i] == i && grid[i/n][i%n]=='1') ans++;
            }
            return ans;
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
