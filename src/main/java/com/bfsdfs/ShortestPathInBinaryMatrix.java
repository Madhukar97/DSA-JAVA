package com.bfsdfs;

import java.util.LinkedList;
import java.util.Queue;

//1091. Shortest Path in Binary Matrix
//https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
public class ShortestPathInBinaryMatrix {
    /*
    BFS vs DFS
Why Use BFS? Search Every Possible Path vs Search A Possible Path
Intuition :
1.If we want to find a possible path, DFS will be more efficient. Because DFS will return a possible path if found, while it may not the shortest path.
2.BFS will try every possible path at the same time.
3.If we want to find the shortest of all possible paths, BFS is more efficient. It's impossible for DFS to determine which is the shortest before trying all possible paths.
     */
    //Using BFS
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1]==1) return -1;

        int[][] vis = new int[n][n];
        vis[0][0] = 1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[2]);

        int[] rows = {1,1,-1,-1,0,0,1,-1};
        int[] cols = {1,-1,1,-1,1,-1,0,0};

        int count=0;

        while(!q.isEmpty()){
            int size = q.size();
            count++;

            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];

                if(x==n-1 && y==n-1) return count;

                for(int j=0;j<8;j++){
                    int newX = x + rows[j];
                    int newY = y + cols[j];
                    if(newX >=0 && newY >=0 && newX<n && newY<n && grid[newX][newY]==0 && vis[newX][newY]==0){
                        q.add(new int[]{newX,newY});
                        vis[newX][newY] = 1;
                    }
                }
            }
        }
        return -1;
    }

    //DFS solution giving TLE
    //Memoization/DP is not possible
    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            int n=grid.length;
            int[][] vis = new int[n][n];
            int ans = dfs(grid, 0,0,n,vis);
            return ans >= 100000 ? -1 : ans;
        }

        public int dfs(int[][] grid, int x, int y,int n, int[][] vis){
            if(x<0 || y<0 || x==n || y==n || grid[x][y]==1 || vis[x][y] == 1) return 100000;
            if(x==n-1 && y==n-1){
                return 1;
            }

            vis[x][y] = 1;

            int count = 1;
            //try all possible paths
            int p1 = dfs(grid, x+1, y+1, n,vis);
            int p2 = dfs(grid, x+1, y-1, n,vis);
            int p3 = dfs(grid, x-1, y+1, n,vis);
            int p4 = dfs(grid, x-1, y-1, n,vis);

            int p5 = dfs(grid, x, y+1, n,vis);
            int p6 = dfs(grid, x, y-1, n,vis);
            int p7 = dfs(grid, x+1, y, n,vis);
            int p8 = dfs(grid, x-1, y, n,vis);

            count += Math.min(p1, Math.min(p2, Math.min(p3, Math.min(p4, Math.min(p5, Math.min(p6, Math.min(p7,p8)))))));
            vis[x][y] = 0;
            return count;
        }
    }

}
