package com.codestudio.dynamicprogramming;

//https://www.codingninjas.com/codestudio/problems/total-unique-paths_1081470?leftPanelTab=0
public class UniquePaths {
    public static void main(String[] args) {

    }

    //normal recursion sol with TC = O(2^(m*n)), SC = O(m-1+n-1);
    public static int rec(int m, int n){
        if(m==0 && n==0) return 1;
        if(m<0 || n<0) return 0;
        int up = rec(m-1,n);
        int left = rec(m,n-1);
        return up+left;

    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return mem(m-1,n-1,dp);

    }

    //Recursion with memoization solution TC = O(m*n), SC = O(m-1+n-1) + dp[m][n]
    public static int mem(int m, int n, int[][] dp){
        if(m==0 && n==0) return 1;
        if(m<0 || n<0) return 0;

        if(dp[m][n] != -1)return dp[m][n];

        int up = mem(m-1,n,dp);
        int left = mem(m,n-1,dp);
        dp[m][n] = up+left;
        return up+left;

    }

    //Tabulation solution with TC = O(m*n), SC = O(m*n)
    public static int uniquePathsTabulation(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) dp[i][j] = 1;
                else{
                    int up=0;
                    int left=0;

                    if(i>0) up=dp[i-1][j];
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }

    //Tabulation with SpaceOptimization solution with TC = O(m*n), SC = O(n)
    public static int uniquePathsTabulationWithSpaceOptimization(int m, int n) {
        int[] prevRow = new int[n];
        int[] currRow = new int[n];
        int temp=1;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int up=prevRow[j];
                int left = temp;
                currRow[j] = up+left;
                temp = up+left;
            }
            prevRow=currRow;
            temp=0;
            currRow = new int[n];
        }
        return prevRow[n-1];
    }


}
