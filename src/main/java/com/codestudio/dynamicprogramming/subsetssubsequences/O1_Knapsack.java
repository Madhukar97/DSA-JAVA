package com.codestudio.dynamicprogramming.subsetssubsequences;


//https://www.codingninjas.com/studio/problems/0-1-knapsack_920542?leftPanelTab=1
//0 1 Knapsack
public class O1_Knapsack {
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        return rec(n-1, maxWeight, value, weight);
    }

    //Normal recursion solution with TC = O(2^n) and SC = O(n)
    public static int rec(int ind, int w, int[] vals, int[] wts){
        if(ind == 0){
            if(wts[ind] <= w) return vals[0];
            else return 0;
        }

        int notPick = 0 + rec(ind-1, w, vals, wts);
        int pick = Integer.MIN_VALUE;
        if(wts[ind] <= w) {
            pick = vals[ind] + rec(ind-1, w-wts[ind], vals, wts);
        }

        return Math.max(notPick, pick);
    }

    static int knapsackMem(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight+1];
        for(int i=0;i<n;i++){
            for(int j=0; j<maxWeight+1;j++){
                dp[i][j] = -1;
            }
        }

        return recMem(n-1, maxWeight, value, weight, dp);
    }

    //Recursion with Memoization(Top-Down approach) solution TC = O(n*maxWeight) , SC = O(n) + dp[n][maxWeight+1]
    public static int recMem(int ind, int w, int[] vals, int[] wts, int[][] dp){
        if(ind == 0){
            if(wts[ind] <= w) return vals[0];
            else return 0;
        }

        if(dp[ind][w] != -1) return dp[ind][w];

        int notPick = 0 + recMem(ind-1, w, vals, wts, dp);
        int pick = Integer.MIN_VALUE;
        if(wts[ind] <= w) {
            pick = vals[ind] + recMem(ind-1, w-wts[ind], vals, wts, dp);
        }
        dp[ind][w] = Math.max(notPick, pick);
        return dp[ind][w];
    }

    //Tabulation(Bottom-up approach) solution TC = O(n*maxWeight) , SC = dp[n][maxWeight+1]
    static int knapsackTabulation(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight+1];
        for(int w=weight[0];w<maxWeight+1;w++) dp[0][w] = value[0];

        for(int ind=1;ind<n;ind++){
            for(int w=maxWeight; w>=0;w--){
                int notPick = 0 + dp[ind-1][w];
                int pick = Integer.MIN_VALUE;
                if(weight[ind] <= w) {
                    pick = value[ind] + dp[ind-1][w-weight[ind]];
                }
                dp[ind][w] = Math.max(notPick, pick);
            }
        }

        return dp[n-1][maxWeight];
    }

    //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*maxWeight) , SC = 2*dp[maxWeight+1]
    static int knapsackTabulationWithSpaceOptimization(int[] weight, int[] value, int n, int maxWeight) {
        int[] prev = new int[maxWeight+1];
        int[] curr = new int[maxWeight+1];

        for(int w=weight[0];w<maxWeight+1;w++) prev[w] = value[0];

        for(int ind=1;ind<n;ind++){
            for(int w=maxWeight; w>=0;w--){
                int notPick = 0 + prev[w];
                int pick = Integer.MIN_VALUE;
                if(weight[ind] <= w) {
                    pick = value[ind] + prev[w-weight[ind]];
                }
                curr[w] = Math.max(notPick, pick);
            }
            prev = curr;
            curr = new int[maxWeight+1];
        }

        return prev[maxWeight];
    }

    //Tabulation(Bottom-up approach) with 1 Array space optimization solution TC = O(n*maxWeight) , SC = 1*dp[maxWeight+1]
    static int knapsackTabulationWith1ArraySpaceOptimization(int[] weight, int[] value, int n, int maxWeight) {
        int[] prev = new int[maxWeight+1];
        for(int w=weight[0];w<maxWeight+1;w++) prev[w] = value[0];

        for(int ind=1;ind<n;ind++){
            for(int w=maxWeight; w>=0;w--){
                int notPick = 0 + prev[w];
                int pick = Integer.MIN_VALUE;
                if(weight[ind] <= w) {
                    pick = value[ind] + prev[w-weight[ind]];
                }
                prev[w] = Math.max(notPick, pick);
            }
        }

        return prev[maxWeight];
    }

}
