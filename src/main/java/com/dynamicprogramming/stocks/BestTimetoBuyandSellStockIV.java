package com.dynamicprogramming.stocks;

//188. Best Time to Buy and Sell Stock IV
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
//Striver DP series vid 38
public class BestTimetoBuyandSellStockIV {
    public int maxProfit(int k,int[] prices) {
        int n=prices.length;
        return rec(0,1,k,prices);
    }
    //Normal recursion solution with TC = O(2^n) and SC = O(n)
    //getting TLE error
    public static int rec(int i, int buy, int trans, int[] prices){
        if(i == prices.length || trans == 0) return 0;

        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[i] + rec(i+1,0,trans,prices), 0+rec(i+1,1,trans,prices));
        }else{
            profit = Math.max(prices[i] + rec(i+1,1,trans-1,prices), 0+rec(i+1,0,trans,prices));
        }
        return profit;
    }

    public int maxProfitMem(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp = new int[n][2][k];

        for(int i=0;i<n;i++){
            for(int t=0;t<k;t++) {
                dp[i][0][t] = -1;
                dp[i][1][t] = -1;
            }
        }
        return recMem(0,1,k,prices,dp);
    }
    //Recursion with Memoization(Top-Down approach) solution TC = O(n*2*k) , SC = O(n) + dp[n][2][k]
    public static int recMem(int i, int buy, int trans, int[] prices, int[][][] dp){
        if(i == prices.length || trans == 0) return 0;

        if(dp[i][buy][trans-1] != -1) return dp[i][buy][trans-1];

        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[i] + recMem(i+1,0,trans,prices,dp), 0+recMem(i+1,1,trans,prices,dp));
        }else{
            profit = Math.max(prices[i] + recMem(i+1,1,trans-1,prices,dp), 0+recMem(i+1,0,trans,prices,dp));
        }
        dp[i][buy][trans-1] = profit;
        return dp[i][buy][trans-1];
    }
    //Tabulation(Bottom-up approach) solution TC = O(n*2*k) , SC = dp[n+1][2][k]
    public int maxProfitTabulation(int k,int[] prices) {
        int n=prices.length;
        int[][][] dp = new int[n+1][2][k+1];

        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int trans=1;trans<=k;trans++){
                    int profit = 0;
                    if(buy == 1){
                        profit = Math.max(-prices[i] + dp[i+1][0][trans], 0+dp[i+1][1][trans]);
                    }else{
                        profit = Math.max(prices[i] + dp[i+1][1][trans-1], 0+dp[i+1][0][trans]);
                    }
                    dp[i][buy][trans] = profit;
                }
            }
        }
        return dp[0][1][k];
    }
    //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*2*k) , SC = 2*dp[2][k+1]
    public int maxProfitTabulationWithSpaceOptimization(int k, int[] prices) {
        int n=prices.length;
        int[][] prev = new int[2][k+1];
        int[][] curr = new int[2][k+1];

        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int trans=1;trans<=k;trans++){
                    int profit = 0;
                    if(buy == 1){
                        profit = Math.max(-prices[i] + prev[0][trans], 0+prev[1][trans]);
                    }else{
                        profit = Math.max(prices[i] + prev[1][trans-1], 0+prev[0][trans]);
                    }
                    curr[buy][trans] = profit;
                }
            }
            prev = curr;
            curr = new int[2][k+1];
        }
        return prev[1][k];
    }
    //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*2*k) , SC = 2*dp[2*k+1]
    public int maxProfitTabulationWithSpaceOptimization2(int k, int[] prices) {
        int n=prices.length;
        int[] prev = new int[2*k+1];
        int[] curr = new int[2*k+1];

        for(int i=n-1;i>=0;i--){
            for(int trans=2*k-1;trans>=0;trans--){
                int profit = 0;
                if(trans%2 == 0){
                    profit = Math.max(-prices[i] + prev[trans+1], 0+prev[trans]);
                }else{
                    profit = Math.max(prices[i] + prev[trans+1], 0+prev[trans]);
                }
                curr[trans] = profit;
            }
            prev = curr;
            curr = new int[2*k+1];
        }
        return prev[0];
    }
}
