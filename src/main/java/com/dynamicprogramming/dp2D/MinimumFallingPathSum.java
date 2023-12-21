package com.dynamicprogramming.dp2D;

import java.util.Arrays;

//931. Minimum Falling Path Sum
//https://leetcode.com/problems/minimum-falling-path-sum/description/
public class MinimumFallingPathSum {
    //Brute Force using recursion
    class Solution {
        public int minFallingPathSum(int[][] matrix) {
            int m=matrix.length;
            int n=matrix[0].length;

            int ans = Integer.MAX_VALUE;
            for(int c=0;c<n;c++){
                ans = Math.min(ans, dfs(matrix, 0, c));
            }
            return ans;
        }

        public int dfs(int[][] grid, int x, int y){
            if(y<0 || y==grid[0].length) return 100000;
            if(x == grid.length-1) return grid[x][y];

            int sum = grid[x][y];

            //try all possible paths
            int p1 = dfs(grid, x+1, y-1);
            int p2 = dfs(grid, x+1, y);
            int p3 = dfs(grid, x+1, y+1);

            sum += Math.min(p1, Math.min(p2,p3));
            return sum;
        }
    }

    //Optimal Sol using Memoization and 2D-DP with TC = O(m*n) and SC = O(m*n) + O(n)
    class Solution2 {
        public int minFallingPathSum(int[][] matrix) {
            int m=matrix.length;
            int n=matrix[0].length;

            int[][] dp = new int[m][n];
            for(int[] row : dp) Arrays.fill(row , 100000);

            int ans = Integer.MAX_VALUE;
            for(int c=0;c<n;c++){
                ans = Math.min(ans, dfs(matrix, 0, c, dp));
            }
            return ans;
        }

        public int dfs(int[][] grid, int x, int y, int[][] dp){
            if(y<0 || y==grid[0].length) return 100000;
            if(x == grid.length-1) return grid[x][y];

            if(dp[x][y] != 100000) return dp[x][y];

            int sum = grid[x][y];

            //try all possible paths
            int p1 = dfs(grid, x+1, y-1, dp);
            int p2 = dfs(grid, x+1, y, dp);
            int p3 = dfs(grid, x+1, y+1, dp);

            sum += Math.min(p1, Math.min(p2,p3));
            dp[x][y] = sum;
            return dp[x][y];
        }
    }

    //Most Optimal sol using Tabulation 2D-DP with TC = O(m*n) and SC = O(m*n)
    class Solution3 {
        public int minFallingPathSum(int[][] grid) {
            int m=grid.length;
            int n=grid[0].length;

            int[][] dp = new int[m+1][n];

            for(int x=m-1;x>=0;x--){
                for(int y=0;y<n;y++){
                    int sum = grid[x][y];
                    int p1=Integer.MAX_VALUE,p2=Integer.MAX_VALUE,p3=Integer.MAX_VALUE;

                    //try all possible paths
                    if(y-1 >= 0) p1 = dp[x+1][y-1];
                    p2 = dp[x+1][y];
                    if(y+1 < n) p3 = dp[x+1][y+1];

                    sum += Math.min(p1, Math.min(p2,p3));
                    dp[x][y] = sum;
                }
            }

            int ans = Integer.MAX_VALUE;
            for(int c=0;c<n;c++){
                ans = Math.min(ans, dp[0][c]);
            }
            return ans;
        }
    }
}
