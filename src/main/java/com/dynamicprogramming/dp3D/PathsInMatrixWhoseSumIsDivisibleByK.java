package com.dynamicprogramming.dp3D;

import java.util.Arrays;

//2435. Paths in Matrix Whose Sum Is Divisible by K
//https://leetcode.com/problems/paths-in-matrix-whose-sum-is-divisible-by-k/description/
public class PathsInMatrixWhoseSumIsDivisibleByK {
    //Brute force using recursion
    class Solution {
        public int numberOfPaths(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;

            return dfs(grid, 0, 0, k,m,n,0,"");
        }

        public int dfs(int[][] grid, int x, int y, int k, int m, int n, int sum,String path){
            if(x == m || y == n) return 0;

            if(x==m-1 && y==n-1){
                sum+=grid[x][y];
                // System.out.println("PATH : " + path + ", Sum : " +sum);
                return sum%k==0 ? 1 : 0;
            }
            // System.out.println("PATH : " + path+grid[x][y] + ", Sum : " +(sum+grid[x][y])+ ", x : "+x+", y : "+y);
            int paths = 0;
            //try all posible ways
            int p1 = dfs(grid, x+1, y, k, m, n, sum+grid[x][y], path+grid[x][y]);
            int p2 = dfs(grid, x, y+1, k, m, n, sum+grid[x][y], path+grid[x][y]);

            paths+=p1+p2;
            return paths;
        }
    }

    //Recursion with Memoization using 3D dp
    class Solution2 {
        private final int mod = (int) (Math.pow(10,9) + 7);
        public int numberOfPaths(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;

            int[][][] dp = new int[m][n][k+1];
            for(int[][] l1 : dp){
                for(int[] row : l1) Arrays.fill(row, -1);
            }

            return dfs(grid, 0, 0, k, dp,m,n,0);
        }

        public int dfs(int[][] grid, int x, int y, int k, int[][][] dp, int m, int n, int sum){
            if(x == m || y == n) return 0;

            if(x==m-1 && y==n-1){
                sum+=grid[x][y];
                return sum%k==0 ? 1 : 0;
            }

            if(dp[x][y][sum] != -1) return dp[x][y][sum];

            int paths = 0;
            //try all posible ways
            int p1 = dfs(grid, x+1, y, k, dp, m, n, (sum+grid[x][y])%k);
            int p2 = dfs(grid, x, y+1, k, dp, m, n, (sum+grid[x][y])%k);

            paths+=p1+p2;
            dp[x][y][sum] = paths%mod;
            return dp[x][y][sum];
        }
    }
}
