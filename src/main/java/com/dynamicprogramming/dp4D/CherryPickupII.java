package com.dynamicprogramming.dp4D;

import java.util.Arrays;

//1463. Cherry Pickup II
//https://leetcode.com/problems/cherry-pickup-ii/description/
public class CherryPickupII {
    //Optimal sol using 3D DP with recursion and DFS
    class Solution {
        public int cherryPickup(int[][] grid) {
            int m=grid.length;
            int n=grid[0].length;
            int[][][] dp = new int[m][n][n];
            for(int[][] l1 : dp){
                for(int[] l2 : l1) Arrays.fill(l2, -1);
            }

            return Math.max(0, dfs(grid, 0,0,n-1, m,n,dp));
        }

        public int dfs(int[][] grid, int x, int y1, int y2, int m, int n, int[][][] dp){
            if(y1<0 || y2<0 || y1==n || y2==n) return Integer.MIN_VALUE;
            if(x == m-1){
                if(y1 == y2) return grid[x][y1];
                else return grid[x][y1]+grid[x][y2];
            }

            if(dp[x][y1][y2] != -1) return dp[x][y1][y2];

            int cherry=0;
            if(y1 == y2) cherry+=grid[x][y1];
            else cherry+=grid[x][y1]+grid[x][y2];

            int p1 = dfs(grid, x+1, y1-1,y2-1,m,n,dp);
            int p2 = dfs(grid, x+1, y1-1,y2,m,n,dp);
            int p3 = dfs(grid, x+1, y1-1,y2+1,m,n,dp);
            int p4 = dfs(grid, x+1, y1,y2-1,m,n,dp);
            int p5 = dfs(grid, x+1, y1,y2,m,n,dp);
            int p6 = dfs(grid, x+1, y1,y2+1,m,n,dp);
            int p7 = dfs(grid, x+1, y1+1,y2-1,m,n,dp);
            int p8 = dfs(grid, x+1, y1+1,y2,m,n,dp);
            int p9 = dfs(grid, x+1, y1+1,y2+1,m,n,dp);

            cherry+= Math.max(p1, Math.max(p2, Math.max(p3, Math.max(p4, Math.max(p5, Math.max(p6, Math.max(p7, Math.max(p8,p9))))))));
            dp[x][y1][y2] = cherry;
            return cherry;
        }
    }
}
