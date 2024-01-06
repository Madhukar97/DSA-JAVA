package com.dynamicprogramming.dp4D;

import java.util.Arrays;

//741. Cherry Pickup
//https://leetcode.com/problems/cherry-pickup/description/
public class CherryPickup {
    //Brute force sol1 using recursion and dfs
    //Getting TLE
    class Solution {
        public int cherryPickup(int[][] grid) {
            int[] ans = new int[1];
            int[][] grid2 = new int[grid.length][grid[0].length];
            dfs(grid, 0, 0, 0, grid2, ans);
            int[] ans2 = new int[1];
            // System.out.println("GRID 2 : " +Arrays.deepToString(grid2));
            // dfs2(grid2, grid.length-1, grid[0].length-1, 0, ans2);
            return ans[0];
        }

        public void dfs(int[][] grid, int i, int j, int count, int[][] grid2, int[] ans){
            if(i == grid.length || j == grid[0].length || grid[i][j] == -1) return;
            if(i == grid.length-1 && j == grid[0].length-1){
                int temp = grid[i][j];
                if(grid[i][j] == 1) {
                    count++;
                    grid[i][j] = 0;
                }

                dfs2(grid, grid.length-1, grid[0].length-1, count, ans);
                // if(count > ans[0]){
                //     for(int r=0;r<grid.length;r++){
                //         for(int c=0;c<grid[0].length;c++){
                //             grid2[r][c] = grid[r][c];
                //         }
                //     }
                //     ans[0] = count;
                // }
                grid[i][j] = temp;
                return;
            }

            int cherry=0;
            //right
            if(grid[i][j] == 1) cherry=1;
            int temp = grid[i][j];
            grid[i][j] = 0;
            dfs(grid, i, j+1, count+cherry, grid2, ans);
            //down
            dfs(grid, i+1, j, count+cherry, grid2, ans);
            grid[i][j] = temp;
        }

        public void dfs2(int[][] grid, int i, int j, int count, int[] ans){
            if(i < 0 || j <0 || grid[i][j] == -1) return;
            if(i ==0 && j==0 ){
                if(count > ans[0]) ans[0] = count;
                return;
            }

            int cherry=0;
            //left
            if(grid[i][j] == 1) cherry = 1;
            int temp = grid[i][j];
            grid[i][j] = 0;
            dfs2(grid, i, j-1, count+cherry, ans);
            //up
            dfs2(grid, i-1, j, count+cherry, ans);
            grid[i][j] = temp;
        }
    }

    //Optimal sol using 4D DP with two persons starting from 0,0 to m-1,n-1 to collect max cherries with 2 different paths
    class Solution2 {
        public int cherryPickup(int[][] grid) {
            int m=grid.length;
            int n=grid[0].length;
            int[][][][] dp = new int[m][n][m][n];
            for(int[][][] l1 : dp){
                for(int[][] l2 : l1){
                    for(int[] l3 : l2) Arrays.fill(l3, -1);
                }
            }
            return Math.max(0, dfs(grid,0,0,0,0,m,n,dp));
        }

        public int dfs(int[][] grid, int x1, int y1, int x2, int y2, int m, int n, int[][][][] dp){
            if(x1==m || y1==n || x2==m || y2==n || grid[x1][y1] == -1 || grid[x2][y2] == -1){
                return Integer.MIN_VALUE;
            }
            if((x1==m-1 && y1 == n-1) || (x2==m-1 && y2 == n-1))  return grid[x1][y1];

            if(dp[x1][y1][x2][y2] != -1) return dp[x1][y1][x2][y2];

            int cherry = 0;
            if(x1 == x2 || y1 == y2) cherry+=grid[x2][y2];
            else cherry+=grid[x1][y1] + grid[x2][y2];

            int path1 = dfs(grid, x1+1,y1,x2+1,y2,m,n,dp);
            int path2 = dfs(grid, x1+1,y1,x2,y2+1,m,n,dp);
            int path3 = dfs(grid, x1,y1+1,x2+1,y2,m,n,dp);
            int path4 = dfs(grid, x1,y1+1,x2,y2+1,m,n,dp);

            cherry+= Math.max(path1, Math.max(path2, Math.max(path3, path4)));
            dp[x1][y1][x2][y2] = cherry;
            return cherry;
        }
    }
}
