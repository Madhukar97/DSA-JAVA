package com.codestudio.dynamicprogramming;

///https://www.codingninjas.com/codestudio/problems/minimum-path-sum_985349?leftPanelTab=0
public class MinimumPathSum {
    public static void main(String[] args) {

    }

    public static int minSumPath(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                dp[i][j] = -1;
            }
        }

        rec(grid.length-1,grid[0].length-1, grid, dp);
        return dp[grid.length-1][grid[0].length-1];
    }

    ////Recursion with Memoization solution TC = O(n*m), SC = O(n-1+m-1) + dp[n][m]
    public static int rec(int n, int m, int[][] grid, int[][] dp){
        if(n==0 & m==0){
            return grid[n][m];
        }
        if(n<0 || m<0) return 0;
        if(dp[n][m] != -1) return dp[n][m];

        int sum = 0;

        int up = rec(n-1,m,grid,dp);
        int left = rec(n,m-1,grid,dp);

        if(up == 0 && left != 0) sum=left;
        else if(up != 0 && left == 0) sum=up;
        else if(up !=0 && left != 0) sum = Math.min(up,left);


        dp[n][m] = sum+grid[n][m];

        return dp[n][m];
    }

    //Tabulation solution TC = O(n*m), SC = dp[n][m] or O(n*m)
    public static int minSumPathTabulation(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 && j==0) dp[i][j] = grid[i][j];
                else{
                    int up=0;
                    int left=0;
                    int sum=0;

                    if(i>0) up = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];

                    if(up == 0 && left != 0) sum = left;
                    else if(up != 0 && left == 0) sum = up;
                    else sum = Math.min(up,left);

                    dp[i][j] = sum+grid[i][j];
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    //Tabulation with SpaceOptimization solution TC = O(n*m), SC = dp[m] or O(m)
    public static int minSumPathTabulationWithSpaceOptimization(int[][] grid) {
        int[] prevRow = new int[grid[0].length];
        int[] currRow = new int[grid[0].length];
        int temp = grid[0][0];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int up=0;
                int left=0;
                int sum=0;

                if(i>0) up = prevRow[j];
                if(j>0) left = temp;

                if(up == 0 && left != 0) sum = left;
                else if(up != 0 && left == 0) sum = up;
                else sum = Math.min(up,left);

                currRow[j] = sum+grid[i][j];
                temp = sum+grid[i][j];
            }
            temp = 0;
            prevRow = currRow;
            currRow = new int[grid[0].length];
        }
        return prevRow[grid[0].length-1];
    }
}
