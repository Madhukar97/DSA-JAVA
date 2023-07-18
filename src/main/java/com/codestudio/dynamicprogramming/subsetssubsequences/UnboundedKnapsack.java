package com.codestudio.dynamicprogramming.subsetssubsequences;

//Unbounded Knapsack
//https://www.codingninjas.com/studio/problems/unbounded-knapsack_1215029?leftPanelTab=0
public class UnboundedKnapsack {
    public static void main(String[] args) {

    }

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        return rec(n-1,w,profit,weight);
    }

    //Normal recursion solution with TC = exponential and SC = O(w)
    public static int rec(int ind, int w, int[] profit, int[] weights){
        if(ind == 0){
            return w/weights[0]*profit[0];
        }

        int notPick = 0+rec(ind-1,w,profit,weights);
        int pick = 0;
        if(weights[ind]<= w) pick = profit[ind] + rec(ind, w-weights[ind], profit, weights);

        return Math.max(notPick,pick);
    }

    public static int unboundedKnapsackMem(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w+1];
        for(int i=0; i<n;i++){
            for(int j=0;j<w+1;j++){
                dp[i][j]= -1;
            }
        }

        return recMem(n-1,w,profit,weight,dp);
    }
    //Recursion with Memoization(Top-Down approach) solution TC = O(n*w) , SC = O(w) + dp[n][w+1]
    public static int recMem(int ind, int w, int[] profit, int[] weights, int[][] dp){
        if(ind == 0){
            return w/weights[0]*profit[0];
        }

        if(dp[ind][w] != -1) return dp[ind][w];

        int notPick = 0+recMem(ind-1,w,profit,weights,dp);
        int pick = 0;
        if(weights[ind]<= w) pick = profit[ind] + recMem(ind, w-weights[ind], profit, weights,dp);

        dp[ind][w] = Math.max(notPick,pick);
        return Math.max(notPick,pick);
    }


    //Tabulation(Bottom-up approach) solution TC = O(n*w) , SC = dp[n][w+1]
    public static int unboundedKnapsackTabulation(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w+1];
        for(int wt=0;wt<=w;wt++){
            dp[0][wt] = wt/weight[0]*profit[0];
        }

        for(int ind=1;ind<n;ind++){
            for(int W=0;W<=w;W++){
                int notPick = 0 + dp[ind-1][W];
                int pick = 0;
                if(weight[ind] <= W) pick = profit[ind] + dp[ind][W-weight[ind]];
                dp[ind][W] = Math.max(notPick,pick);
            }
        }
        return dp[n-1][w];
    }

    //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*w) , SC = 2*dp[w+1] :: 2 array space optimization
    public static int unboundedKnapsackTabWithSpaceOptimization(int n, int w, int[] profit, int[] weight) {
        int[] prev = new int[w+1];
        int[] curr = new int[w+1];

        for(int wt=0;wt<=w;wt++){
            prev[wt] = wt/weight[0]*profit[0];
        }

        for(int ind=1;ind<n;ind++){
            for(int W=0;W<=w;W++){
                int notPick = 0 + prev[W];
                int pick = 0;
                if(weight[ind] <= W) pick = profit[ind] + curr[W-weight[ind]];
                curr[W] = Math.max(notPick,pick);
            }
            prev = curr;
        }
        return prev[w];
    }

    //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*w) , SC = 1*dp[w+1] :: 1 array space optimization
    public static int unboundedKnapsackTabulationWith1ArraySpaceOptimization(int n, int w, int[] profit, int[] weight) {
        int[] prev = new int[w+1];

        for(int wt=0;wt<=w;wt++){
            prev[wt] = wt/weight[0]*profit[0];
        }

        for(int ind=1;ind<n;ind++){
            for(int W=0;W<=w;W++){
                int notPick = 0 + prev[W];
                int pick = 0;
                if(weight[ind] <= W) pick = profit[ind] + prev[W-weight[ind]];
                prev[W] = Math.max(notPick,pick);
            }
        }
        return prev[w];
    }
}
