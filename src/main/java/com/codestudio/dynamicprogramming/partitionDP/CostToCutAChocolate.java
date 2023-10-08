package com.codestudio.dynamicprogramming.partitionDP;

import java.util.Arrays;

//Cost to Cut a Chocolate
//https://www.codingninjas.com/studio/problems/cost-to-cut-a-chocolate_3208460?leftPanelTab=0
//Striver DP series vid 50
public class CostToCutAChocolate {
    //Normal recursion solution with TC = O(2^n)*n and SC = O(n)
    //getting TLE error
    public int minCost(int n, int[] cuts) {
        int[] arr = new int[cuts.length+2];
        arr[0]=0;
        arr[cuts.length+1] = n;
        for(int i=0;i<cuts.length;i++) arr[i+1] = cuts[i];
        Arrays.sort(arr);
        return rec(1,cuts.length,arr);
    }

    public int rec(int i, int j, int[] cuts){
        if(i > j) return 0;

        int min = Integer.MAX_VALUE;
        for(int c=i;c<=j;c++){
            int cost = cuts[j+1]-cuts[i-1] + rec(i,c-1,cuts) + rec(c+1,j,cuts);
            min = Math.min(min,cost);
        }
        return min;
    }
    //recursion with memoization solution with TC = O(n*n)*n and SC = O(n) + dp[n+2][n+2]
    public int minCostMem(int n, int[] cuts) {
        int cLength = cuts.length;
        int[] arr = new int[cLength+2];
        arr[0]=0;
        arr[cLength+1] = n;
        for(int i=0;i<cLength;i++) arr[i+1] = cuts[i];
        Arrays.sort(arr);

        int[][] dp = new int[cLength+2][cLength+2];
        for(int i=0;i<cLength+2;i++){
            for(int j=0;j<cLength+2;j++){
                dp[i][j] = -1;
            }
        }

        return recMem(1,cuts.length,arr,dp);
    }

    public int recMem(int i, int j, int[] cuts, int[][] dp){
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for(int c=i;c<=j;c++){
            int cost = cuts[j+1]-cuts[i-1] + recMem(i,c-1,cuts,dp) + recMem(c+1,j,cuts,dp);
            min = Math.min(min,cost);
        }
        dp[i][j] = min;
        return min;
    }
    //Tabulation(Bottom-up approach) solution TC = O(n*n)*n , SC = dp[n+2][n+2]
    public static int cost(int n, int c, int cuts[]) {
        int cLength = c;
        int[] arr = new int[cLength+2];
        arr[0]=0;
        arr[cLength+1] = n;
        for(int i=0;i<cLength;i++) arr[i+1] = cuts[i];
        Arrays.sort(arr);

        int[][] dp = new int[cLength+2][cLength+2];
        for(int i=cLength;i>0;i--){
            for(int j=i;j<cLength+1;j++){
                int min = Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    int cost = arr[j+1]-arr[i-1] + dp[i][k-1] + dp[k+1][j];
                    min = Math.min(min,cost);
                }
                dp[i][j] = min;
            }
        }

        return dp[1][cuts.length];
    }

}
