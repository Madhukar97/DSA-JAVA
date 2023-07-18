package com.codestudio.dynamicprogramming.stocks;

//Best Time to Buy and Sell Stock II
//https://www.codingninjas.com/studio/problems/selling-stock_630282
//Striver DP series vid 36
public class BestTimeToBuyAndSellStockII {
    public static long getMaximumProfit (int n, long[] values) {
        return rec(0, 1, values, n);    //buy == 1 represents can buy a stock and 0 cant buy
    }
    //Normal recursion solution with TC = O(2^n) and SC = O(n)
    //getting TLE error
    public static long rec(int i, int buy, long[] vals, int n){
        //base cases
        if(i==n) return 0;

        long profit=0;
        //all possibilities
        if(buy == 1){
            profit = Math.max(-vals[i] + rec(i+1,0,vals,n), 0 + rec(i+1,1,vals,n));
        }else{
            profit = Math.max(vals[i] + rec(i+1,1,vals,n), 0 + rec(i+1,0,vals,n));
        }
        return profit;
    }
    public int maxProfitMem(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int i=0;i<prices.length;i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        return recMem(0, 1 , prices, dp);
    }
    //Recursion with Memoization(Top-Down approach) solution TC = O(n*2) , SC = O(n) + dp[n][2]
    public int recMem(int i, int buy, int[] prices, int[][] dp){
        if(i==prices.length) return 0;

        if(dp[i][buy] != -1) return dp[i][buy];

        int profit = 0;
        if(buy==1){
            profit = Math.max(-prices[i] + recMem(i+1,0,prices,dp), 0+recMem(i+1,1,prices,dp));
        }else{
            profit = Math.max(prices[i] + recMem(i+1,1,prices,dp), 0+recMem(i+1,0,prices,dp));
        }
        dp[i][buy] = profit;
        return dp[i][buy];
    }
    //Tabulation(Bottom-up approach) solution TC = O(n*2) , SC = dp[n+1][2]
    public int maxProfitTabulation(int[] prices) {
        int[][] dp = new int[prices.length+1][2];

        for(int i=prices.length-1;i>=0;i--) {
            for(int buy=0;buy<=1;buy++){
                int profit = 0;
                if(buy==1){
                    profit = Math.max(-prices[i] + dp[i+1][0], 0+dp[i+1][1]);
                }else{
                    profit = Math.max(prices[i] + dp[i+1][1], 0+dp[i+1][0]);
                }
                dp[i][buy] = profit;
            }
        }
        return dp[0][1];
    }
    //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*2) , SC = 2*dp[2]
    public int maxProfitTabWithSpaceOptimization(int[] prices) {
        int[] prev = new int[2];
        int[] curr = new int[2];

        for(int i=prices.length-1;i>=0;i--) {
            for(int buy=0;buy<=1;buy++){
                int profit = 0;
                if(buy==1){
                    profit = Math.max(-prices[i] + prev[0], 0+prev[1]);
                }else{
                    profit = Math.max(prices[i] + prev[1], 0+prev[0]);
                }
                curr[buy] = profit;
            }
            prev=curr;
            curr = new int[2];
        }
        return prev[1];
    }
    //Tabulation(Bottom-up approach) with 1 Array space optimization solution TC = O(n*2) , SC = dp[2]
    public int maxProfitTabWithSpaceOptimization2(int[] prices) {
        int[] prev = new int[2];

        for(int i=prices.length-1;i>=0;i--) {
            for(int buy=0;buy<=1;buy++){
                int profit = 0;
                if(buy==1){
                    profit = Math.max(-prices[i] + prev[0], 0+prev[1]);
                }else{
                    profit = Math.max(prices[i] + prev[1], 0+prev[0]);
                }
                prev[buy] = profit;
            }
        }
        return prev[1];
    }

}
