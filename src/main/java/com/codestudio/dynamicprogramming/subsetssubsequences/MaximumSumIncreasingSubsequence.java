package com.codestudio.dynamicprogramming.subsetssubsequences;

import java.util.*;

//Maximum Sum Increasing Subsequence
//https://www.codingninjas.com/studio/problems/1112624?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
public class MaximumSumIncreasingSubsequence {
    //Brute Force Recursion with TC = O(2^n) and space O(n)
    public static int maxIncreasingDumbbellsSum(ArrayList<Integer> rack, int n) {
        return rec(rack, n-1,n);
    }

    public static int rec(ArrayList<Integer> rack, int i, int next){
        if(i < 0) return 0;

        if(next == rack.size() || rack.get(i) < rack.get(next)){
            return Math.max(rack.get(i) + rec(rack, i-1, i), rec(rack, i-1, next));
        }
        return rec(rack,i-1,next);
    }
    //Recursion with Memoization with TC = O(n*n) and SC = O(n*n) + O(n)
    //Solving from right to left, n to 0
    public static int maxIncreasingDumbbellsSumMemoization(ArrayList<Integer> rack, int n) {
        int[][] dp = new int[n][n+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return recMem(rack, n-1,n,dp);
    }

    public static int recMem(ArrayList<Integer> rack, int i, int next, int[][] dp){
        if(i < 0) return 0;

        if(dp[i][next] != -1) return dp[i][next];

        if(next == rack.size() || rack.get(i) < rack.get(next)){
            dp[i][next] = Math.max(rack.get(i) + recMem(rack, i-1, i,dp), recMem(rack, i-1, next,dp));
            return dp[i][next];
        }
        dp[i][next] = recMem(rack,i-1,next,dp);
        return dp[i][next];
    }
    //Recursion with Memoization with TC = O(n*n) and SC = O(n*n) + O(n)
    //Solving from left to right, 0 to n
    public static int maxIncreasingDumbbellsSumMemoization2(ArrayList<Integer> rack, int n) {
        int[][] dp = new int[n][n+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return rec(rack, 0,-1,dp);
    }

    public static int rec(ArrayList<Integer> rack, int i, int prev, int[][] dp){
        if(i == rack.size()) return 0;

        if(dp[i][prev+1] != -1) return dp[i][prev+1];

        if(prev == -1 || rack.get(i) > rack.get(prev)){
            dp[i][prev+1] = Math.max(rack.get(i) + rec(rack, i+1, i,dp), rec(rack, i+1, prev,dp));
            return dp[i][prev+1];
        }
        dp[i][prev+1] = rec(rack,i+1,prev,dp);
        return dp[i][prev+1];
    }
}
