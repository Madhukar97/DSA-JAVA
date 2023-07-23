package com.codestudio.dynamicprogramming.stocks;

//Best Time to Buy and Sell Stock with Transaction Fee
//https://www.codingninjas.com/studio/problems/best-time-to-buy-and-sell-stock-with-transaction-fee_3118974?leftPanelTab=1
//Striver DP series vid 40
public class BestTimetoBuyandSellStockwithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        return rec(0,1,fee,prices);
    }
    //Normal recursion solution with TC = O(2^n) and SC = O(n)
    //getting TLE error
    public int rec(int i, int buy, int fee, int[] prices){
        if(i == prices.length) return 0;

        int profit=0;
        if(buy==1){
            profit = Math.max(-prices[i]+rec(i+1,0,fee,prices), 0+rec(i+1,1,fee,prices));
        }else{
            profit = Math.max(prices[i]-fee+rec(i+1,1,fee,prices), 0+rec(i+1,0,fee,prices));
        }
        return profit;
    }
    public int maxProfitMem(int[] prices, int fee) {
        int n=prices.length;
        int[][] dp = new int[n][2];

        for(int i=0;i<n;i++){
            dp[i][0]=-1;
            dp[i][1]=-1;
        }

        return recMem(0,1,fee,prices,dp);
    }
    //Recursion with Memoization(Top-Down approach) solution TC = O(n*2) , SC = O(n) + dp[n][2]
    public int recMem(int i, int buy, int fee, int[] prices, int[][] dp){
        if(i == prices.length) return 0;

        if(dp[i][buy] != -1) return dp[i][buy];

        int profit=0;
        if(buy==1){
            profit = Math.max(-prices[i]+recMem(i+1,0,fee,prices,dp), 0+recMem(i+1,1,fee,prices,dp));
        }else{
            profit = Math.max(prices[i]-fee+recMem(i+1,1,fee,prices,dp), 0+recMem(i+1,0,fee,prices,dp));
        }
        dp[i][buy] = profit;
        return dp[i][buy];
    }
    //Tabulation(Bottom-up approach) solution TC = O(n*2) , SC = dp[n+1][2]
    public int maxProfitTabulation(int[] prices, int fee) {
        int n=prices.length;
        int[][] dp = new int[n+1][2];

        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                int profit=0;
                if(buy==1){
                    profit = Math.max(-prices[i]+dp[i+1][0], 0+dp[i+1][1]);
                }else{
                    profit = Math.max(prices[i]-fee+dp[i+1][1], 0+dp[i+1][0]);
                }
                dp[i][buy] = profit;
            }
        }
        return dp[0][1];
    }
    //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*2) , SC = 2*dp[2]
    public int maxProfitTabulationWithSpaceOptimization(int[] prices, int fee) {
        int n=prices.length;
        int[] prev = new int[2];
        int[] curr = new int[2];

        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                int profit=0;
                if(buy==1){
                    profit = Math.max(-prices[i]+prev[0], 0+prev[1]);
                }else{
                    profit = Math.max(prices[i]-fee+prev[1], 0+prev[0]);
                }
                curr[buy] = profit;
            }
            prev=curr;
            curr=new int[2];
        }
        return prev[1];
    }
    //Tabulation(Bottom-up approach) with 1 array space optimization solution TC = O(n*2) , SC = 1*dp[2]
    public int maxPromaxProfitTabulationWithSingleArraySpaceOptimizationfit(int[] prices, int fee) {
        int n=prices.length;
        int[] prev = new int[2];

        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                int profit=0;
                if(buy==1){
                    profit = Math.max(-prices[i]+prev[0], 0+prev[1]);
                }else{
                    profit = Math.max(prices[i]-fee+prev[1], 0+prev[0]);
                }
                prev[buy] = profit;
            }
        }
        return prev[1];
    }
}
