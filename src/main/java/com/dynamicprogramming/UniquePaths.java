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
}
