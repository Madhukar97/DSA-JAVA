package com.codestudio.dynamicprogramming.stocks;

//Best Time to Buy and Sell Stock with Cooldown
//https://www.codingninjas.com/studio/problems/best-time-to-buy-and-sell-stock-with-cooldown_3125969?leftPanelTab=1
//Striver DP series vid 39
public class BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        return rec(0,1,prices);
    }
    //Normal recursion solution with TC = O(2^n) and SC = O(n)
    //getting TLE error
    public int rec(int i, int buy, int[] prices){
        if(i >= prices.length) return 0;

        int profit=0;
        if(buy==1){
            profit = Math.max(-prices[i] + rec(i+1,0,prices), 0+rec(i+1,1,prices));
        }else{
            profit = Math.max(prices[i] + rec(i+2,1,prices), 0+rec(i+1,0,prices));
        }
        return profit;
    }

    public int maxProfitMem(int[] prices) {
        int[][] dp = new int[prices.length][2];

        for(int i=0;i<prices.length;i++){
            dp[i][0]=-1;
            dp[i][1]=-1;
        }

        return recMem(0,1,prices,dp);
    }
    //Recursion with Memoization(Top-Down approach) solution TC = O(n*2) , SC = O(n) + dp[n][2]
    public int recMem(int i, int buy, int[] prices, int[][] dp){
        if(i >= prices.length) return 0;

        if(dp[i][buy] != -1) return dp[i][buy];

        int profit=0;
        if(buy==1){
            profit = Math.max(-prices[i] + recMem(i+1,0,prices,dp), 0+recMem(i+1,1,prices,dp));
        }else{
            profit = Math.max(prices[i] + recMem(i+2,1,prices,dp), 0+recMem(i+1,0,prices,dp));
        }
        dp[i][buy] = profit;
        return dp[i][buy];
    }
    //Tabulation(Bottom-up approach) solution TC = O(n*2) , SC = dp[n+2][2]
    public int maxProfitTabulation(int[] prices) {
        int[][] dp = new int[prices.length+2][2];

        for(int i=prices.length-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                int profit=0;
                if(buy==1){
                    profit = Math.max(-prices[i] + dp[i+1][0], 0+dp[i+1][1]);
                }else{
                    profit = Math.max(prices[i] + dp[i+2][1], 0+dp[i+1][0]);
                }
                dp[i][buy] = profit;
            }
        }
        return dp[0][1];
    }
    //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*2) , SC = 3*dp[2]

    public int maxProfitTabulationWithSpaceOptimization(int[] prices) {
        int[] prevPrev = new int[2];
        int[] prev = new int[2];
        int[] curr = new int[2];

        for(int i=prices.length-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                int profit=0;
                if(buy==1){
                    profit = Math.max(-prices[i] + prev[0], 0+prev[1]);
                }else{
                    profit = Math.max(prices[i] + prevPrev[1], 0+prev[0]);
                }
                curr[buy] = profit;
            }
            prevPrev=prev;
            prev=curr;
            curr=new int[2];
        }
        return prev[1];
    }
}
