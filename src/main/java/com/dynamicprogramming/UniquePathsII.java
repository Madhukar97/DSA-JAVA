package com.dynamicprogramming;

import java.util.Arrays;

//63. Unique Paths II
//https://leetcode.com/problems/unique-paths-ii/
public class UniquePathsII {
    public static void main(String[] args) {

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 1 && obstacleGrid[0].length == 1 && obstacleGrid[0][0] == 0) return 1;

        boolean[][] vis = new boolean[obstacleGrid.length][obstacleGrid[0].length];
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[] row : dp) {
            Arrays.fill(row, 0);
        }
        recFunc(obstacleGrid, 0, 0, dp, vis);

        return dp[0][0];
    }

    int recFunc(int[][] grid, int r, int c, int[][] dp, boolean[][] vis) {
        if(r == grid.length || c == grid[r].length || grid[r][c] == 1) return 0;

        if(r == grid.length-1 && c == grid[r].length-1) return 1;

        if(vis[r][c] == true) return dp[r][c];
        int result = recFunc(grid, r+1, c, dp, vis) + recFunc(grid, r, c+1, dp, vis);
        vis[r][c] = true;
        dp[r][c] = result;
        return result;

    }
}
