package com.codestudio.dynamicprogramming.subsetssubsequences;

//Rod cutting problem
//https://www.codingninjas.com/studio/problems/rod-cutting-problem_800284?leftPanelTab=0
public class RodCuttingProblem {
    public static void main(String[] args) {

    }

    public static int cutRod(int price[], int n) {
        return rec(n-1, n, price);
    }
    //Normal recursion solution with TC = exponential and SC = O(n)
    public static int rec(int ind, int n, int[] price){
        if(ind == 0){
            return n*price[0];
        }

        int notCut = 0 + rec(ind-1, n, price);
        int cut = Integer.MIN_VALUE;
        int length = ind+1;
        if(length <= n) cut = price[ind] + rec(ind, n-length, price);

        return Math.max(notCut,cut);
    }

    public static int cutRodMem(int price[], int n) {
        int[][] dp = new int[n][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n+1;j++){
                dp[i][j] = -1;
            }
        }

        return recMem(n-1, n, price,dp);
    }
    //Recursion with Memoization(Top-Down approach) solution TC = O(n*(n+1)) , SC = O(n) + dp[n][n+1]
    public static int recMem(int ind, int n, int[] price, int[][] dp){
        if(ind == 0){
            return n*price[0];
        }

        if(dp[ind][n] != -1) return dp[ind][n];

        int notCut = 0 + recMem(ind-1, n, price,dp);
        int cut = Integer.MIN_VALUE;
        int length = ind+1;
        if(length <= n) cut = price[ind] + recMem(ind, n-length, price,dp);

        dp[ind][n] = Math.max(notCut,cut);
        return Math.max(notCut,cut);
    }

    //Tabulation(Bottom-up approach) solution TC = O(n*(n+1)) , SC = dp[n][n+1]
    public static int cutRodTabulation(int price[], int n) {
        int[][] dp = new int[n][n+1];
        for(int N=0;N<=n;N++) dp[0][N] = N*price[0];

        for(int ind=1;ind<n;ind++){
            for(int N=0;N<n+1;N++){
                int notCut = 0 + dp[ind-1][N];
                int cut = Integer.MIN_VALUE;
                int length = ind+1;
                if(length <= N) cut = price[ind] + dp[ind][N-length];

                dp[ind][N] = Math.max(notCut,cut);
            }
        }

        return dp[n-1][n];
    }

    //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*(n+1)) , SC = 2*dp[n+1] :: 2 array space optimization
    public static int cutRodTabSpaceOptimization(int price[], int n) {
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];

        for(int N=0;N<=n;N++) prev[N] = N*price[0];

        for(int ind=1;ind<n;ind++){
            for(int N=0;N<n+1;N++){
                int notCut = 0 + prev[N];
                int cut = Integer.MIN_VALUE;
                int length = ind+1;
                if(length <= N) cut = price[ind] + curr[N-length];

                curr[N] = Math.max(notCut,cut);
            }
            prev=curr;
        }

        return prev[n];
    }

    //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*(n+1)) , SC = 1*dp[n+1] :: 1 array space optimization
    public static int cutRodTabWithSingleArraySpace(int price[], int n) {
        int[] prev = new int[n+1];
        for(int N=0;N<=n;N++) prev[N] = N*price[0];

        for(int ind=1;ind<n;ind++){
            for(int N=0;N<n+1;N++){
                int notCut = 0 + prev[N];
                int cut = Integer.MIN_VALUE;
                int length = ind+1;
                if(length <= N) cut = price[ind] + prev[N-length];

                prev[N] = Math.max(notCut,cut);
            }
        }
        return prev[n];
    }
}
