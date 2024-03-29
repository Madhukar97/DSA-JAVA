package com.dynamicprogramming;

import java.util.Arrays;

//62. Unique Paths
//https://leetcode.com/problems/unique-paths/
public class UniquePaths {
    public static void main(String[] args) {

    }

    //dp solution
    public int uniquePaths(int m, int n) {
        if(m==1 && n==1) return 1;
        int[][] dp = new int[m][n];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        recFunc(0, 0, dp);
        return dp[0][0];
    }

    int recFunc( int m, int n, int[][] dp) {
        if(dp.length-1 == m && dp[0].length-1 == n) {
            return 1;
        }
        if( m == dp.length || n == dp[0].length) return 0;

        if(dp[m][n] != -1) return dp[m][n];
        int result = recFunc( m, n+1, dp) + recFunc( m+1, n, dp);
        dp[m][n] = result;

        return result;
    }

    public int uniquePathsTabulation(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0 ) continue;
                int up = 0;
                int left = 0;
                if(i > 0) up = dp[i-1][j];
                if(j > 0) left = dp[i][j-1];
                dp[i][j] = up+left;
            }
        }

        return dp[m-1][n-1];
    }

    //nCr Combinations solution
    public int uniquePathsNcRCombinations(int m, int n) {
        int N = m+n-2;
        int R = n-1;
        double ans = 1;

        for(int r=1;r<=R;r++){
            ans = ans*(N-R+r)/r;
        }
        return (int)ans;
    }
}
