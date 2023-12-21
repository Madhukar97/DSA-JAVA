package com.dynamicprogramming.dp2D;

import java.util.Arrays;

//1289. Minimum Falling Path Sum II
//https://leetcode.com/problems/minimum-falling-path-sum-ii/description/
public class MinimumFallingPathSumII {
    //Brute Force using Recursion and DFS
    class Solution {
        public int minFallingPathSum(int[][] grid) {
            int m=grid.length;
            int n=grid[0].length;
            int ans = Integer.MAX_VALUE;
            for(int c=0;c<n;c++){
                ans = Math.min(ans, dfs(grid, 0, c, -1));
            }
            return ans;
        }

        public int dfs(int[][] grid, int x, int y, int prevY){
            if(x == grid.length-1) {
                return grid[x][y];
            }

            int sum = grid[x][y];
            int min = Integer.MAX_VALUE;
            //try all possible paths
            for(int c=0;c<grid[0].length;c++){
                if(c == y) continue;
                min = Math.min(min, dfs(grid, x+1, c, y));
            }
            sum+=min;
            return sum;
        }
    }
    //Better sol using Memoization and 2D-DP with TC = O(m*n) and SC = O(m*n) + O(m)
    class Solution2 {
        public int minFallingPathSum(int[][] grid) {
            int m=grid.length;
            int n=grid[0].length;
            int ans = Integer.MAX_VALUE;
            int[][] dp = new int[m][n];
            for(int[] row : dp) Arrays.fill(row , -1);
            for(int c=0;c<n;c++){
                ans = Math.min(ans, dfs(grid, 0, c, dp));
            }
            return ans;
        }

        public int dfs(int[][] grid, int x, int y, int[][] dp){
            if(x == grid.length-1) {
                return grid[x][y];
            }

            if(dp[x][y] != -1) return dp[x][y];

            int sum = grid[x][y];
            int min = Integer.MAX_VALUE;
            //try all possible paths
            for(int c=0;c<grid[0].length;c++){
                if(c == y) continue;
                min = Math.min(min, dfs(grid, x+1, c, dp));
            }
            sum+=min;
            dp[x][y] = sum;
            return dp[x][y];
        }
    }
    //Most Optimal sol using Tabulation with TC = O(m*n) and SC = O(m*n)
    class Solution3 {
        public int minFallingPathSum(int[][] grid) {
            int m=grid.length;
            int n=grid[0].length;
            int ans = Integer.MAX_VALUE;
            int[][] dp = new int[m+1][n];

            for(int x=m-1;x>=0;x--){
                for(int y=0;y<n;y++){
                    int sum = grid[x][y];
                    int min = 100000;
                    //try all possible paths
                    for(int c=0;c<grid[0].length;c++){
                        if(c == y) continue;
                        min = Math.min(min, dp[x+1][c]);
                    }
                    if(min != 100000) sum+=min;
                    dp[x][y] = sum;
                }
            }

            for(int c=0;c<n;c++){
                ans = Math.min(ans, dp[0][c]);
            }
            return ans;
        }
    }
}
